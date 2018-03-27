package com.rmit.advprog2.assignment2;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Dependent extends User {
	

	private User fatherObj;	
	private User motherObj;
	private ArrayList<User> parenting;

	
	
	
	

	@Override
	public ArrayList<Dependent> getChild() {
		// TODO Auto-generated method stub
		return super.getChild();
	}


	@Override
	public ArrayList<User> getParent() {
		// TODO Auto-generated method stub
		
		 return parenting;
	}


	public Dependent(String name, String status, String p, int age, User father, User mother ) {
		super(name, status, p, age);
		this.fatherObj = father;
		this.motherObj = mother;
		fatherObj.addChild(this);
		motherObj.addChild(this);
		parenting = getParent();
		//parenting.addParent(father);
		//motherObj.addParent(mother);
		
		
		
		
		
		
		
		
		// TODO Auto-generated constructor stub
	}
	
	
	public void display() {
		System.out.println("Child User Found");
		System.out.println("Profile");
		System.out.println("Name: " + getName());
		System.out.println("Age: " + getAge());
		System.out.println("Picture path: " + getPicture());
		System.out.println("Father: " + fatherObj.getName() );
		System.out.println("Mother: " + motherObj.getName() );
		System.out.print("Friends: ");
		super.printFriends(getFriends());
		System.out.println("");
		System.out.println("====================");

		

	}
	/**
	 * 
	 */
	
	
	public User getFatherObj() {
		return fatherObj;
	}

	public void setFatherObj(User fatherObj) {
		this.fatherObj = fatherObj;
	}

	public User getMotherObj() {
		return motherObj;
	}

	public void setMotherObj(User motherObj) {
		this.motherObj = motherObj;
	}
	public ArrayList<User> getParents()
	{
		ArrayList<User> getParents = new ArrayList<>();
		getParents.add(this.fatherObj);
		getParents.add(this.motherObj);
		return getParents;
			
	}
	public ArrayList<User> getParenting() {
		return parenting;
	}


	public void setParenting(ArrayList<User> parenting) {
		this.parenting = parenting;
	}
	

}
