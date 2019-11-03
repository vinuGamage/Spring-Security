package com.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showLogin")
    public String showLoginPage(){
        return "fancy-login";
    }

     @GetMapping("/accessDenied")
    public String accessDeniedPage(){
        return "AccessDenied";
    }

}
