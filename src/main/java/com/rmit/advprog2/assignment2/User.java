package com.rmit.advprog2.assignment2;

import java.util.ArrayList;
import java.util.Scanner;


import sun.text.normalizer.CharTrie.FriendAgent;

/*

 *
 * @author rajiv.khushiram
 
 */
public class User {
	private String name;
	private String picture;
	private int age;
	private String status;

	private ArrayList<Dependent> child;
	private ArrayList<User> friends;
	private ArrayList<User> parent;

	
	
	public ArrayList<User> getParent() {
		return parent;
	}

	public void setParent(ArrayList<User> parent) {
		this.parent = parent;
	}
	
	public void addParent(User parentla){
		parent.add(parentla);
		
	}
	
	
	
	public ArrayList<User> getFriends() {
		return friends;
	}

	public void setFriends(ArrayList<User> friends) {
		this.friends = friends;
	}
	
	public void addFriendManual(User addFriend)
	{	
			
			friends.add(addFriend);

	}

	public User(String name, int age){
		this.name = name;
		this.picture = "no picture";
		this.child = new ArrayList<>();
		this.friends = new ArrayList<User>();
		this.age = age;
		this.status = "no status";

		
	}

	public User(String name, String status, String p, int age) 
	{	
		this.name = name;
		this.status= status;
		picture = p;
		this.age = age;	
		this.child = new ArrayList<>();
		this.friends = new ArrayList<>();

	}
	
	public void addChild(Dependent Childd){
		this.child.add(Childd);
	}
	
	
	public void display() {
		System.out.println("Adult User Found");
		System.out.println("Profile");
		System.out.println("Name: " + getName());
		System.out.println("Age: " + getAge());
		System.out.println("Picture path: " + getPicture());
		System.out.print("Children are: ");
		printDep(child);
		System.out.print("Amount of Friends =  ");
		printFriends(friends);
		System.out.println("");
		System.out.println("=============");

		
	}

	public void edit() {
		
		  Scanner sc = new Scanner(System.in);
		  System.out.println("Insert new User name:");
		  String insertedName = sc.next();
		  this.name = insertedName;
		  System.out.println("New Name = " + name);

		// TODO Auto-generated method stub
		
	}


	public void printDep(ArrayList<Dependent> list) {
		for (Dependent elem : list) {
			System.out.print(elem.getName() + ",  ");
		}
	}

	public void printFriends(ArrayList<User> listtarrayLa) {
		for (User elems : listtarrayLa) {
			System.out.print(elems.getName() + ",  ");
		}
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public ArrayList<Dependent> getChild() {
		return child;
	}

	public void setChild(ArrayList<Dependent> child) {
		this.child = child;
	}
	public String getName() {
		return name;
	}
	
	
	
	
	
	


}
