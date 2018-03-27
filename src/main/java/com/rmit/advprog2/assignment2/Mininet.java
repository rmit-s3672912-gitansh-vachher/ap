package com.rmit.advprog2.assignment2;

import java.util.ArrayList;
import java.util.Scanner;

public class Mininet {
	public static ArrayList<User> allusers;
	public static ArrayList<User> parentUsers;
	public static ArrayList<Dependent> childUsers;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InMemory();
		start();
		//
	}

	public static void start() {
		Scanner scanner = new Scanner(System.in);
		int selection = 0;
		int x = 0;

		while (x == 0)  {
			menumenu();
			selection = scanner.nextInt();
			switch (selection) {
			case 1:
				x = 1;
				for (User userVar : allusers) {
					System.out.println("Name: " + userVar.getName() + " Age " + userVar.getAge());
				}
				x = 0;
				break;
			case 2:
				x = 1;
				User selectedUser = null;
				System.out.println("Enter Person Name:");
				String nameUser = scanner.next();
				for (User userVar : allusers) {
					if (nameUser.toString().equals(userVar.getName())) {
						selectedUser = userVar;
						selectedUser.display();
						x = 0;
					}
				}
				break;
			case 3:
				x = 1;
				System.out.println("Insert First User name:");
				String insertedFName= scanner.next();
				System.out.println("Insert Second User name:");
				String insertedSName = scanner.next();
				User user1 = returnedUser(insertedFName);
				User user2 = returnedUser(insertedSName);
				
				
				System.out.println("returned user 1 --" + user1.getName());
				System.out.println("returned user2 --" +user2.getName());
				
				if(areTheyFriends(user1, user2)){
					System.out.println("They are direct Friends");					
				}else{
					System.out.println("They are Not direct Friends");					
				}	
				x=0;
				break;
			case 4:
				x = 1;
				System.out.println("Insert New User Name:");
				String insertUserName = scanner.next();
				System.out.println("Insert Age of User:");
				int insertUserAge = scanner.nextInt();

				if (insertUserAge > 16) {

					// Adult Constructor
					User newUser = new User(insertUserName, insertUserAge);
					allusers.add(newUser);
					parentUsers.add(newUser);
					x = 0;
				} else {
					// Child Construtor
					System.out.println("Insert Father Name");
					String motherName = scanner.next();
					if (parentExits(motherName)) {
						User parent11Obj = returnedParent(motherName);
						System.out.println("Enter mother Name");
						String fatherName = scanner.next();
						if ((parentExits(fatherName) && (!(fatherName.equals(motherName))))) {
							User parent2Obj = returnedParent(fatherName);
							Dependent addedDep = new Dependent(insertUserName, "", "", insertUserAge, parent11Obj,
									parent2Obj);
							allusers.add(addedDep);
							childUsers.add(addedDep);
							x = 0;
						} else {
							// S
							System.out.println("Something failed");
							x = 0;
						}
					} else {
						System.out.println("No Such Parent Exits");
						x = 0;
					}
				}
				break;
			case 5:
				System.out.println("Enter Name of First User:");
				String insertUserName1 = scanner.next();
				System.out.println("Insert Name of Second of User:");
				String insertUsername2 = scanner.next();
				User user11 = returnedUser(insertUserName1);
				User user22 = returnedUser(insertUsername2);
				
				if ( Friendable(user11, user22))
				{
					user11.addFriendManual(user22);
					user22.addFriendManual(user11);
					System.out.println("They are now Friends");
				}else 
				{
					System.out.println("They Cannot be friends");
				}		
				
				break;
			case 9:
				System.out.println("Program has Terminated");
				System.exit(0);
				break;
				
			default:
				System.out.println("Please enter a valid selection.");
			}
		}
	}

	private static void menumenu() {
		System.out.println("Please Make a selection:");
		System.out.println("[1] List everyone");
		System.out.println("[2] Select a person");
		System.out.println("[3] Are these two direct friends");
		System.out.println("[4] Add User");
		System.out.println("[5] Connect two Persons");
		System.out.println("[9] Quit");
		System.out.println("Selection: ");
	}
	
	private static boolean parentExits(String parent) {
		for (User userVar : parentUsers) {
			if (parent.toString().equals(userVar.getName())) {
				return true;
			}
		}
		return false;
	}

	private static User returnedParent(String nameOfParent) {
		User parent1 = null;
		for (User userVar : parentUsers) {
			if (nameOfParent.toString().equals(userVar.getName())) {
				parent1 = userVar;
			}
		}
		return parent1;
	}
	
	private static User returnedUser(String nameofUser) {
		User user1 = null;
		for (User userVar : allusers) {
			if (nameofUser.toString().equals(userVar.getName())) {
				user1 = userVar;
			}
		}
		return user1;
	}
	
	private static boolean areTheyFriends(User user1, User user2){		
		int booleanControl = 0;
		ArrayList<User> user1Friends =new ArrayList<>();		 
			 user1Friends = user1.getFriends();
			 for (User instance: user1Friends){
					if((user2.getName()).equals(instance.getName())){
						System.out.println("They are friends");
						booleanControl = 1;
					}
				}		
		 if (booleanControl==1){
				return true;
			}
			else {
				return false;
			}	
	}
	private static boolean Friendable(User user1, User user2){
		int booleanControl = 0;		
		boolean aretheyfriends = (areTheyFriends(user1, user2));
		boolean areTheyFamilyMembers = (areTheyFamily(user1,user2));
		//Does Friend already Exits? 		
		if (aretheyfriends==false && areTheyFamilyMembers==false){
			int ageGap = Math.abs((user1.getAge()) -(user2.getAge()));
			
			
			if(((user1.getAge() < 16) && user2.getAge() > 16) || ((user1.getAge() > 16) && user2.getAge() < 16)){
				booleanControl=0;
			}
			else if ((((user1.getAge() <= 2) || user2.getAge() <= 2))) {
				booleanControl=0;
			}
			else if ((((user1.getAge() <= 16) && ageGap >=3)  || (user2.getAge() <= 16) && ageGap >=3)){
				booleanControl = 0;
			}
			else {
				booleanControl=1;
			}
		}
		else {
			booleanControl = 0;
		}
		if (booleanControl==1){
			return true;
		}
		else {
			System.out.println("Not Friendable");
			return false;
		}	

	}

	private static boolean areTheyFamily(User user1, User user2) {
		// TODO Auto-generated method stub
		
		int booleanControl = 0;	
		ArrayList<Dependent> user1Child =new ArrayList<>();
		 ArrayList<User> user2Parents = new ArrayList<>();
		 ArrayList<Dependent> user2Child =new ArrayList<>();
		 ArrayList<User> user1Parents = new ArrayList<>();
		 user1Child = user1.getChild();
		 user2Parents =user2.getParent();
		 user2Child = user2.getChild();
		 user1Parents =user1.getParent();	 
		 for (User instance1: user1Child){
			 for (User instance2: user2Parents){
				 	if((instance1.getName()).equals((instance2).getName())){
				 		booleanControl=1;
				 	}
			 }
		 }	 
		  for (User instance1: user2Child){
			 for (User instance2: user1Parents){
				 	if((instance1.getName()).equals((instance2).getName())){
				 		booleanControl=1;
				 	}
			 }
		 }
		 if (booleanControl==1){
			 System.out.println("They Are Familly");
				return true;
			}
			else {
				 System.out.println("They Are Not Familly");

				return false;
			}	
	}

}
		