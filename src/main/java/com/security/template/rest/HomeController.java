package com.security.template.rest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/home")
    public ModelAndView homePage() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        return new ModelAndView("home", "user", username);
    }

    @GetMapping("/public")
    public ModelAndView publicPage() {
        return new ModelAndView("home", "user", "you are public :D");
    }

    @GetMapping("/logout")
    public String logout() {
        SecurityContextHolder.clearContext();
        return "logged out";
    }
}
