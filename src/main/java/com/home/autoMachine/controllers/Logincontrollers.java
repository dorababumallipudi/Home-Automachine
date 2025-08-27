package com.home.autoMachine.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.home.autoMachine.daoImp.LogindaoImp;
import com.home.autoMachine.models.Login;

import jakarta.servlet.http.HttpSession;

@Controller
public class Logincontrollers {
	@Autowired
	private LogindaoImp LDI;
	
	@GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
	
	
	@PostMapping("/loginUser/{userName}/{password}")
	@ResponseBody
	public Map<String , Object> loginUser(@PathVariable String userName,@PathVariable String password,HttpSession session) {
		Login dbusers = LDI.getusers(userName, password);
		Map<String, Object> response = new HashMap<>();
		if(dbusers != null) {
			session.setAttribute("userName", dbusers.getUserName());
			session.setAttribute("userId", dbusers.getUserId());
			response.put("status", "success");
			response.put("userName", dbusers.getUserName());
			response.put("userId", dbusers.getUserId());
			return response;
		}
		response.put("status","invalid username ,password");
		return response;
	}
	
	
	@GetMapping("/rooms")
	public String dashboard(HttpSession session) {
		String s=(String)session.getAttribute("userName");
		if(s!=null) {
			return "rooms";
		}
		return "redirect:/login";
	}
}
