package com.xpanxion.skeleton.controllers;

import com.xpanxion.skeleton.dto.beans.UserBean;
import com.xpanxion.skeleton.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

/**
 * Tests for the RestApiController
 * @author Gordon Child
 */
@RunWith(MockitoJUnitRunner.class)
public class RestApiControllerTest {

    @InjectMocks
    private RestApiController testee;

    @Mock
    private UserService userService;

    @Test
    public void testGetUsers() {
        // given
        List<UserBean> users = new ArrayList<UserBean>();
        UserBean bean = new UserBean();
        bean.setId(1);
        bean.setUsername("testuser1");
        bean.setPassword("password");
        UserBean bean2 = new UserBean();
        bean2.setId(2);
        bean2.setUsername("testuser2");
        bean2.setPassword("password");

        users.add(bean);
        users.add(bean2);

        given(userService.getUsers()).willReturn(users);

        // when
        List<UserBean> retVal = testee.getUsers();

        assertEquals(users.size(),retVal.size());
        for(int i=0;i<users.size();i++) {
            assertEquals(users.get(i),retVal.get(i));
        }
    }

    @Test
    public void testGetUserByPath() {
        // given
        final Integer id = 1;
        UserBean bean = new UserBean();
        bean.setId(id);
        bean.setUsername("testuser1");

        given(userService.getUserById(id)).willReturn(bean);

        // when
        UserBean returnVal = testee.getUserByPath(id);

        // then
        assertEquals(bean, returnVal);
        verify(userService).getUserById(id);
    }

    @Test
    public void testGetUserByParam() {
        // given
        final Integer id = 2;
        UserBean bean = new UserBean();
        bean.setId(id);
        bean.setUsername("testuser2");

        given(userService.getUserById(id)).willReturn(bean);

        // when
        UserBean returnVal = testee.getUserByParam(id);

        // then
        assertEquals(bean,returnVal);
        verify(userService).getUserById(id);
    }

}
