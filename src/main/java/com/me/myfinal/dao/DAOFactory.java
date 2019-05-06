package com.me.myfinal.dao;

public class DAOFactory {
	
	public UserDAO createUserDAO() {
		return new UserDAO();
	}

	 public AptDAO createAptDAO(){
	   return new AptDAO();
	 }
	 
}
