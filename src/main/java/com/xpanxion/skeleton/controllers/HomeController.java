package com.xpanxion.skeleton.controllers;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xpanxion.skeleton.service.TestService;

/**
 * Controller for the Home Page.
 * 
 * @author brian
 * 
 */
@Controller
public class HomeController {

    @Autowired
    private TestService testService;

    /**
     * The default controller action for the homepage. 
     * 
     * @return the Model and View for the home page. 
     */
    @RequestMapping("/home")
    @Secured("ROLE_USER")
    public ModelAndView getHomePage() {
        ModelAndView mAndV = new ModelAndView("home");
        mAndV.addObject("test", this.testService.getTestBeans());
        return mAndV;
    }

}
