package com.home.autoMachine.dao;

import com.home.autoMachine.models.Signin;

public interface Signindao {
    
    /**
     * This is the interface for setusers by user name, email and password
     * @param userName
     * @param email
     * @param password
     * @return setUsers
     */
	boolean setUsers(String userName,String email, String password);
	/**
	 * This interface get User by user name and email
	 * @param userName
	 * @param email
	 * @return getUser
	 */
	int getUser(String userName,String email);
}
