package com.example.SportWebFullStack.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.SportWebFullStack.Model.AuthenticationResponse;
import com.example.SportWebFullStack.Model.Nguoidung;
import com.example.SportWebFullStack.Service.RegisterService;
import com.fasterxml.jackson.core.JsonProcessingException;
@Controller
@RequestMapping("/sport")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("nguoidung", new Nguoidung());
        return "FrontEnd/user/register";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("nguoidung") Nguoidung nguoidung, 
                                      BindingResult bindingResult, 
                                      Model model, 
                                      RedirectAttributes redirectAttributes) {
    	
        try {
        	
        	nguoidung.setRole("MEMBER");
            // check validation
            if (bindingResult.hasErrors()) {
                return "FrontEnd/user/register";
            }
            String response = registerService.register(nguoidung);
            if (response != null) {
                // Sucess
                redirectAttributes.addFlashAttribute("successMessage", "Đăng ký thành công!");
                return "redirect:/sport/login";
            } else {
                // failed
                model.addAttribute("error", "Đăng ký không thành công. Vui lòng thử lại.");
                return "FrontEnd/user/register";
            }
        	
        } catch (Exception e) {
            model.addAttribute("error", "Có lỗi xảy ra: " + e.getMessage());
            return "FrontEnd/user/register";
        }
    }
}
