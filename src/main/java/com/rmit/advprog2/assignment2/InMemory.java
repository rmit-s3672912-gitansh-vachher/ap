package com.rmit.advprog2.assignment2;

import java.util.ArrayList;

public class InMemory {

	
	public InMemory() {
		// TODO Auto-generated constructor stub
		
		
		
		User user1 = new User("Kanye", "Studying at RMIT", "picture", 23);
		User user2 = new User("Kim", "Studying at Unimelb", "pic", 21);
		Dependent dependent1 = new Dependent("North", "studying", "path", 6, user1, user2);
		
		User user3 = new User("Sushil", "Studying at RMIT", "picture", 66);
		User user4 = new User("Mira", "Studying at RMIT", "picture", 62);
		Dependent dependent2 = new Dependent("Rajiv", "kindergaten", "", 4, user3, user4);
		
		user1.addFriendManual(user3);
		user1.addFriendManual(user4);
		user2.addFriendManual(user3);
		user2.addFriendManual(user4);
		user3.addFriendManual(user1);
		user3.addFriendManual(user2);
		user4.addFriendManual(user1);
		user4.addFriendManual(user2);
		
		dependent1.addFriendManual(dependent2);
		dependent2.addFriendManual(dependent1);
		
		Mininet.allusers = new ArrayList<User>();
		Mininet.parentUsers = new ArrayList<User>();
		Mininet.childUsers = new ArrayList<Dependent>();

		Mininet.allusers.add(user1);
		Mininet.allusers.add(user2);
		Mininet.allusers.add(user3);
		Mininet.allusers.add(user4);
		Mininet.allusers.add(dependent1);
		Mininet.allusers.add(dependent2);

		Mininet.parentUsers.add(user1);
		Mininet.parentUsers.add(user2);
		Mininet.parentUsers.add(user3);
		Mininet.parentUsers.add(user4);

		Mininet.childUsers.add(dependent1);
		Mininet.childUsers.add(dependent2);
	}
}
