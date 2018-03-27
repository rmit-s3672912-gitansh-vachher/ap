package com.rmit.advprog2.assignment2;

import java.util.ArrayList;

/*

*
* @author Gitansh

*/

public class InMemory {

	
	public InMemory() {
		User user1 = new User("Kanye", "Studying at RMIT", "picture", 23);
		User user2 = new User("Kim", "Studying at Unimelb", "pic", 21);
		Dependent dependent1 = new Dependent("North", "studying", "path", 6, user1, user2);
		
		User user3 = new User("Sushil", "Studying at RMIT", "picture", 66);
		User user4 = new User("Mira", "Studying at RMIT", "picture", 62);
		Dependent dependent2 = new Dependent("Rajiv", "kindergaten", "", 4, user3, user4);
		
		User user5 = new User("Toni", "Studying at RMIT", "picture", 51);
		User user6 = new User("Uli", "Studying at RMIT", "picture", 28);
		
		Dependent dependent3 = new Dependent("Rachel", "kindergaten", "", 4, user5, user6);
	//	Dependent dependent4 = new Dependent("Ezra", "kindergaten", "", 4, user5, user6);

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
		dependent2.addFriendManual(dependent3);
		dependent3.addFriendManual(dependent2);	
		Mininet.allusers = new ArrayList<User>();
		Mininet.parentUsers = new ArrayList<User>();
		Mininet.childUsers = new ArrayList<Dependent>();
		Mininet.allusers.add(user1);
		Mininet.allusers.add(user2);
		Mininet.allusers.add(user3);
		Mininet.allusers.add(user4);
		Mininet.allusers.add(user5);
		Mininet.allusers.add(user6);
		Mininet.allusers.add(dependent1);
		Mininet.allusers.add(dependent2);
		Mininet.allusers.add(dependent3);

		Mininet.parentUsers.add(user1);
		Mininet.parentUsers.add(user2);
		Mininet.parentUsers.add(user3);
		Mininet.parentUsers.add(user4);
		Mininet.parentUsers.add(user5);
		Mininet.parentUsers.add(user6);

		Mininet.childUsers.add(dependent1);
		Mininet.childUsers.add(dependent2);
		Mininet.childUsers.add(dependent3);
	}
}
