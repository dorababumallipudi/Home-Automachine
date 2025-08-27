package com.home.autoMachine.dao;

import com.home.autoMachine.models.Login;

public interface Logindao  {
    Login getusers(String userName,String password);
}
