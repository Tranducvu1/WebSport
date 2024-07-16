package com.example.SportWebFullStack.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.SportWebFullStack.Service.LoginService;

@Controller
@RequestMapping()
public class LogoutController {
	@Autowired
	private LoginService loginService;
	@PostMapping("/logout")
    public String logout(Model model) {
        boolean logoutSuccess = loginService.logout();
        if (logoutSuccess) {
            return "redirect:/login?logout";
        } else {
            model.addAttribute("error", "Đăng xuất thất bại");
            return "error";
        }
    }
}
