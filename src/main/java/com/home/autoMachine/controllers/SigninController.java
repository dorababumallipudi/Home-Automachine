package com.home.autoMachine.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.home.autoMachine.daoImp.SignindaoImp;
import com.home.autoMachine.models.Signin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SigninController {
    @Autowired
	SignindaoImp signindaoImp;
    /**
     * This page shows the signin.html page 
     * @return to signin page
     */
    @GetMapping("/signin")
    public String showSigninPage() {
		return "signin";  	
    }
    /**
     * This user can signin or create a new account
     * @param user
     * @return string success or Already exists
     */
    @PostMapping("/signinuser")
    @ResponseBody
    public String signUsers(@RequestBody Signin user) {
            int existing = signindaoImp.getUser(user.getUserName(),user.getEmail());
            if(existing == 0){
            	boolean dbsignin =  signindaoImp.setUsers(user.getUserName(),user.getEmail(),user.getPassword());
    			if(dbsignin) {
    				return "success";
    			}else {
    				return "Already exists";
				} 			 
            }
            return "Already exists";		    
    }
    
	
}
