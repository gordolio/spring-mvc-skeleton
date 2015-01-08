package com.xpanxion.skeleton.controllers;

import com.xpanxion.skeleton.dto.beans.UserBean;
import com.xpanxion.skeleton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RestAPI Controller
 * @author Gordon Child
 */
@Controller
@RequestMapping("/api")
public class RestApiController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value="/users", method={RequestMethod.GET})
    public List<UserBean> getUsers() {
        return userService.getUsers();
    }

    @ResponseBody
    @RequestMapping(value="/user/{id}", method={RequestMethod.GET})
    public UserBean getUser(@PathVariable Integer id) {
        return userService.getUserById(id);
    }
}
