package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Usercontroller {
    @Autowired
    Userrepository userrepository;
    // here basically redirect
    @GetMapping("/StartPage/contact")
    public String redirectToRegistration() {
        return "redirect:/StartPage/registration";
    }
    // if i want to show this html pages then i have to use GetMapping then
    // we have to show two pages first stat page then register page thats why we use this
    @GetMapping("/StartPage/registration")
    public String getRegPage(@ModelAttribute("user") User user){
        return "register";
    }
    // here PostMapping w do database work etc
    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user") User user, Model model){
        userrepository.save(user);
        model.addAttribute("message","Congratulations! Your registration is complete.");
        return "register";
    }
    @GetMapping("/StartPage")
    public String Startpage() {
    	return "startpage";
    }

}
