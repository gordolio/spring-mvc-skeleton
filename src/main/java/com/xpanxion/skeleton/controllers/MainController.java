package com.xpanxion.skeleton.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
