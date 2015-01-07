package com.xpanxion.skeleton.controllers;

/**
 * Test the MainController
 * @author Gordon Child
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class MainControllerTest {

    @InjectMocks
    private MainController testee;

    @Test
    public void testMainMain() {
        assertEquals("main", testee.getMainPage().getViewName());
    }

    @Test
    public void testLogoutSuccessUrl() {
        ModelAndView model = testee.getLoginPage(null, "");
        assertEquals("You've been logged out successfully.",model.getModel().get("msg"));
        assertNull(model.getModel().get("error"));
        assertEquals("login", model.getViewName());
    }

    @Test
    public void testLoginErrorMsg() {
        ModelAndView model = testee.getLoginPage("", null);
        assertEquals("Invalid username and password!", model.getModel().get("error"));
        assertNull(model.getModel().get("msg"));
        assertEquals("login", model.getViewName());
    }
}
