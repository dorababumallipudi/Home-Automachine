package com.home.autoMachine.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.home.autoMachine.models.Login;

public class LoginMapper implements RowMapper<Login>{
	/**
	 * this method maps to the login to user name and password
	 * @return login
	 */
	@Override
	public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
		Login l = new Login();
		l.setUserName(rs.getString("user_name"));
		l.setPassword(rs.getString("password"));
		l.setUserId(rs.getInt("user_id"));
		return l;
	}
}
