package com.eteration.controller;

import com.eteration.model.User;
import com.eteration.service.SecurityService;
import com.eteration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Arslan on 12.7.2017.
 */

@Controller
public class LoginController {

    private UserService userService;
    private SecurityService securityService;

    @Autowired
    public LoginController(UserService userService, SecurityService securityService) {
        this.userService = userService;
        this.securityService = securityService;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Model model,String error, String logout){
        if (error!=null){
            model.addAttribute("error","Username or password is not valid");
        }
        if (logout!=null){
            model.addAttribute("logout","Logout success");
        }
        model.addAttribute("welcome","Welcome to Welcome Page :)");
        return "login";
    }

    @RequestMapping(value = "welcome",method = RequestMethod.GET)
    public String successLogin(){
        return "welcome";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("newUser",new User());
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@ModelAttribute("newUser") User user,Model model){
        user.setRoleName("ADMIN");
        userService.save(user);
        securityService.autoLogin(user.getUsername(),user.getPassword());
        return "redirect:/welcome";
    }
}
