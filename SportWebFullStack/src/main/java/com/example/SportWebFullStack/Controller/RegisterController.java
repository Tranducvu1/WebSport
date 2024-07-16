package com.example.SportWebFullStack.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.SportWebFullStack.Model.Nguoidung;
import com.example.SportWebFullStack.Service.LoginService;
import com.example.SportWebFullStack.Service.RegisterService;

@Controller
@RequestMapping("/sport")
public class RegisterController {
	@Autowired
	private RegisterService loginService;
@GetMapping("/register")
public String register(Model model) {
	model.addAttribute("user",new Nguoidung());
	return "FrontEnd/user/register";
}
@PostMapping("/register")
public String register(Nguoidung nguoidung, Model model) {
    try {
        Boolean isRegistered = loginService.Register(nguoidung); 
        if (isRegistered) {
            return "redirect:/sport/login"; // Redirect to success page
        } else {
            model.addAttribute("error", "Registration failed: User already exists.");
            return "redirect:/sport/register"; // Redirect back to registration page
        }
    } catch (Exception e) {
        model.addAttribute("error", "Registration failed: " + e.getMessage());
        return "redirect:/sport/register"; // Redirect back to registration page
    }
}
}
