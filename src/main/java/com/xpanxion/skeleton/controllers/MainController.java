package com.xpanxion.skeleton.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Main Controller
 * Created by gchild on 1/2/2015.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public ModelAndView getMainPage() {
        return new ModelAndView("main");
    }

    @RequestMapping("/login")
    public ModelAndView getLoginPage(@RequestParam(value="error", required=false) String error,
                                     @RequestParam(value="logout", required=false) String logout) {
        ModelAndView model = new ModelAndView("login");
        if(error != null) {
            model.addObject("error", "Invalid username and password!");
        }
        if(logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        return model;
    }
}
