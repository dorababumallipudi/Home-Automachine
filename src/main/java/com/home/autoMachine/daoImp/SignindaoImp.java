package com.home.autoMachine.daoImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.home.autoMachine.dao.Signindao;
import com.home.autoMachine.models.Signin;

@Repository
public class SignindaoImp implements Signindao{
    @Autowired
	private JdbcTemplate jtemp;
	
    /**
     * This method checks the user already exists
     * @param userName
     * @param email
     * @return int
     */
    @Override
	public int getUser(String userName, String email) {
		String query = "SELECT count(*) FROM users WHERE user_name = ? OR email = ?";
		//SELECT count(*) FROM users WHERE user_name = ? AND email = ?
		return jtemp.queryForObject(query, Integer.class,userName,email);
	}
    /**
     * insert the user and login to the controller page
     * @param userName
     * @param email
     * @param password
     * @return boolean
     */
	@Override
	public boolean setUsers(String userName,String email, String password) {
		try {
			String query = "INSERT INTO users (user_name,email,password) values (?,?,?)";
			return jtemp.update(query, userName ,email,password)>0;
		} catch (DuplicateKeyException E) {
			return false;
		}    	
	}
}
