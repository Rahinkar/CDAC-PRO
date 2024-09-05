package com.example.MainProjectAll.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.example.MainProjectAll.entity.User;
import com.example.MainProjectAll.services.UserService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public RedirectView login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.findUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return new RedirectView("/home");
        }
        model.addAttribute("error", "Invalid credentials");
        return new RedirectView("/login");
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public RedirectView register(@RequestParam String username, 
                                 @RequestParam String password,
                                 @RequestParam String email,
                                 @RequestParam String phoneNumber, 
                                 Model model) {
        User existingUser = userService.findUserByUsername(username);
        if (existingUser != null) {
            model.addAttribute("error", "Username already taken");
            return new RedirectView("/register");
        }
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.setPhoneNumber(phoneNumber);
        userService.saveUser(newUser);
        return new RedirectView("/login");
    }

    @GetMapping("/logout")
    public String logoutPage() {
        return "logout";
    }

    @PostMapping("/logout")
    public RedirectView logout() {
        // Placeholder for logout logic
        return new RedirectView("/login");
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    @GetMapping("/chef")
    public String chefPage() {
        return "chef"; 
    }

    @GetMapping("/maid")
    public String maidPage() {
        return "maid"; 
    }

    @GetMapping("/driver")
    public String driverPage() {
        return "driver"; 
    }
}


