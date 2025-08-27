package com.home.autoMachine.daoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.home.autoMachine.dao.Logindao;
import com.home.autoMachine.mappers.LoginMapper;
import com.home.autoMachine.models.Login;
@Repository
public class LogindaoImp implements Logindao{
	
	@Autowired
    private JdbcTemplate temp;
	
	@Override
	public Login getusers(String userName, String password) {
		String query = "select * from users where user_name = ? and password = ?";
		List<Login>  l=  temp.query(query,new LoginMapper(),userName,password);
		//return l.isEmpty() ? null : l.get(0);
		if (l.isEmpty()) {
			return null;
		} else {
            return l.get(0);
		}
	}
	
}
