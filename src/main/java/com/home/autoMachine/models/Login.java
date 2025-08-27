package com.home.autoMachine.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * In this Pojo class the varables userId,userName,password are privatized and getter , setters and 
 * constructers are implimented by @Data @NoArgsConstructor @AllArgsConstructor
 */
public class Login {
    private int userId;
    private String userName;
    private String password; 
}
