package com.xpanxion.skeleton.service;

import com.xpanxion.skeleton.dao.UserDao;
import com.xpanxion.skeleton.dto.beans.UserBean;
import com.xpanxion.skeleton.dto.entity.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

/**
 * @author gchild on 1/5/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserDao userDao;

    @Test
    public void testGetUserBeans() {
        // given
        UserEntity user1 = new UserEntity();
        user1.setId(1);
        user1.setUsername("testuser1");
        user1.setPassword("Password123");

        UserEntity user2 = new UserEntity();
        user2.setId(2);
        user2.setUsername("testuser2");
        user2.setPassword("Password123");

        List<UserEntity> entityList = new ArrayList<>();
        entityList.add(user1);
        entityList.add(user2);

        given(userDao.getAllItems()).willReturn(entityList);

        // when
        List<UserBean> output = userService.getUsers();

        // then
        assertEquals(entityList.size(), output.size());

        for(int i=0;i<output.size();i++) {
            UserEntity e = entityList.get(i);
            UserBean b = output.get(i);
            assertEquals(e.getId(),b.getId());
            assertEquals(e.getUsername(),b.getUsername());
            assertEquals(e.getPassword(),b.getPassword());
        }
    }
}
