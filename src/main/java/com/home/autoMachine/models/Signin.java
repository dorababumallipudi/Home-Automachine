package com.home.autoMachine.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * this is the pojo class used for signin dao class which contains private variable of
 * userId,userName,password and @Data,@NoArgsConstructor,@AllArgsConstructor which creates  
 * getters,setters,NoArgsConstructor and AllArgsConstructor
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Signin {
    private int userId;
    private String userName;
    private String email; 
    private String password;
}
