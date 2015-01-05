package com.xpanxion.skeleton.controllers;

import com.xpanxion.skeleton.dto.beans.UserBean;
import com.xpanxion.skeleton.dto.entity.TestEntity;
import com.xpanxion.skeleton.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

/**
 * @author Gordon Child
 *
 * class UsersControllerTest
 */
@RunWith(MockitoJUnitRunner.class)
public class UsersControllerTest {

    @InjectMocks
    private UsersController testee;

    @Mock
    private UserService userService;

    @Test
    public void testGetUserPage() {
        // given
        UserBean bean1 = new UserBean();
        bean1.setId(1);

        UserBean bean2 = new UserBean();
        bean2.setId(2);

        List<UserBean> entityList = new ArrayList<>();
        entityList.add(bean1);
        entityList.add(bean2);
        given(userService.getUsers()).willReturn(entityList);

        // when
        ModelAndView modelAndView = testee.getUserPage();

        //then
        assertEquals("users", modelAndView.getViewName());
        assertEquals(entityList, modelAndView.getModel().get("users"));
    }
}
