package com.xpanxion.skeleton.controllers;

import com.xpanxion.skeleton.dto.beans.UserBean;
import com.xpanxion.skeleton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Controller for User page
 */
@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @Secured("ROLE_USER")
    @RequestMapping(value="/users", method=RequestMethod.GET)
    public ModelAndView getUserPage() {
        ModelAndView mAndV = new ModelAndView("users");
        List<UserBean> users = userService.getUsers();
        mAndV.addObject("users", users);
        return mAndV;
    }

}
