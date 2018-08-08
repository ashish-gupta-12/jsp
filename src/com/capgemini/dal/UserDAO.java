package com.capgemini.dal;

import java.util.ArrayList;

import com.capgemini.pogo.UserDetails;
import com.capgemini.util.ConnectionFactory;

public class UserDAO {
	ArrayList<UserDetails> userDetailsList=null;
	public UserDAO() {
		userDetailsList=ConnectionFactory.getConnectionVer2();
		userDetailsList.add(new UserDetails("Ashish","java","Admin"));
		userDetailsList.add(new UserDetails("Tanya","bawa","User"));
		userDetailsList.add(new UserDetails("Nikhil","guava","Admin"));
		userDetailsList.add(new UserDetails("Saifi","kava","User"));
	}
	public String getUserType(String userName, String password) {
		for(UserDetails user: userDetailsList) {
			if(user.getUserName().equals(userName) && user.getPassword().equals(password)) {
				return user.getUserType();
			}
		}
		throw new InvalidUserException("Entered user does not exist");
	}
}
