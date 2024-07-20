package com.example.SportWebFullStack.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SportWebFullStack.Model.AuthenticationResponse;
import com.example.SportWebFullStack.Model.LoginRequest;
import com.example.SportWebFullStack.Model.Nguoidung;
import com.example.SportWebFullStack.Service.LoginService;



@Controller
@RequestMapping("/sport")
public class LoginController {
@Autowired
private LoginService loginService;

		@GetMapping("/login")
		public String login(Model model) {
			Nguoidung userEmailAdmin = new Nguoidung();
			model.addAttribute("userEmail", userEmailAdmin);
			return "FrontEnd/user/login";
		}
	//	@PostMapping("/login")
	//	public String login(@ModelAttribute Nguoidung nguoidung, Model model) {
	//	    try {
	//	        	LoginRequest userEmailAdmin = loginService.Loggin(nguoidung.getEmail(),nguoidung.getPassword());
	//	        		System.out.println(loginService.Loggin(nguoidung.getEmail(),nguoidung.getPassword()));
	//	        	if(userEmailAdmin != null) {
	//	        		String roles1 = nguoidung.getRole();
	//	        			if (roles1 == null || roles1.isEmpty()) {
	//	        				throw new IllegalArgumentException("Login failed: No roles assigned.");
	//	        			}
	//	        			model.addAttribute("userEmail", userEmailAdmin);
	//	        			if(roles1.contains("ADMIN")) {
	//	        				System.out.println(userEmailAdmin);
	//	        				return "redirect:/admin"; 
	//	        			} else {    	
	//	        				System.out.println(userEmailAdmin);
	//	        				return "redirect:/sport"; 
	//	        			}
	//	        	} else {
	//	        		model.addAttribute("error", "Bạn chưa nhập email: ");
	//	        		return "redirect:/sport/login"; 
	//	        	}
	//	    } catch (Exception e) {
	//	        model.addAttribute("error", "Login failed: " + e.getMessage());
	//	        return "FrontEnd/login";
	//	    }
	//	}	
		
//	@PostMapping("/login")
//	public String login(@ModelAttribute Nguoidung nguoidung, Model model) {
//	    try {
//	    	System.out.println(nguoidung.getEmail());
//	    	Nguoidung userEmailAdmin = loginService.Loggin(nguoidung.getEmail(), nguoidung.getPassword(),nguoidung.getRole());
//	        if(nguoidung.getEmail() != null) {
//	            model.addAttribute("userEmail", userEmailAdmin);  
//	            if(userEmailAdmin.getRole().contains("ADMIN")) {
//	            	 return "redirect:/admin";        
//	            } else {
//	            	 return "redirect:/sport"; 
//	            }            
//	        } else {
//	            model.addAttribute("error", "Email hoặc mật khẩu không chính xác");
//	            return "FrontEnd/login";
//	        }
//	    } catch (Exception e) {
//	        model.addAttribute("error", "Login failed: " + e.getMessage());
//	        return "FrontEnd/user/login";
//	    }
//	}
}
