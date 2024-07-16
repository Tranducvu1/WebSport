package com.example.SportWebFullStack.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SportWebFullStack.Model.Nguoidung;
import com.example.SportWebFullStack.Service.LoginService;



@Controller
@RequestMapping("/sport/login")
public class LoginController {
@Autowired
private LoginService loginService;

	@GetMapping()
	public String login(Model model) {
		return "FrontEnd/login";
	}
	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password,List<String> roles, Model model) {
	    try {
	        	String userEmailAdmin = loginService.Loggin(email, password,roles);
	        	if (roles == null || roles.isEmpty()) {
	                throw new IllegalArgumentException("Login failed: No roles assigned.");
	            }
		        model.addAttribute("userEmail", userEmailAdmin);
		        if(roles.contains("ADMIN")) {
	        	 return "redirect:/admin"; 
	        } else {    	
	        	 return "redirect:/sport"; 
	        }
	    } catch (Exception e) {
	        model.addAttribute("error", "Login failed: " + e.getMessage());
	        return "FrontEnd/login";
	    }
	}	
	
}
