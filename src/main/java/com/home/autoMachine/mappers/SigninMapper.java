package com.home.autoMachine.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.home.autoMachine.models.Signin;

public class SigninMapper implements RowMapper<Signin>{
	/**
	 * this method maps to the username and password
	 * @return Signin
	 */
	@Override
	public Signin mapRow(ResultSet rs, int rowNum) throws SQLException {
		Signin s = new Signin();
		s.setUserName(rs.getString("user_name"));
		s.setPassword(rs.getString("password"));
		return s;
	}

}
