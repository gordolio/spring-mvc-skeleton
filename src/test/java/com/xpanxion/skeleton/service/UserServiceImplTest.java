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
import static org.junit.Assert.assertNull;
import static org.mockito.BDDMockito.given;

/**
 * @author gchild on 1/5/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl testee;

    @Mock
    private UserDao userDao;

    @Test
    public void testGetUserBeans() {
        // given
        UserEntity user1 = new UserEntity();
        user1.setId(1);
        user1.setUsername("testuser1");
        user1.setPassword("Password123");
        user1.setSalt("test123");

        UserEntity user2 = new UserEntity();
        user2.setId(2);
        user2.setUsername("testuser2");
        user2.setPassword("Password123");
        user2.setSalt("test123");

        List<UserEntity> entityList = new ArrayList<>();
        entityList.add(user1);
        entityList.add(user2);

        given(userDao.getAllItems()).willReturn(entityList);

        // when
        List<UserBean> output = testee.getUsers();

        // then
        assertEquals(entityList.size(), output.size());

        for(int i=0;i<output.size();i++) {
            UserEntity e = entityList.get(i);
            UserBean b = output.get(i);
            assertEqualsEntityAndBean(e, b);
        }
    }

    public void assertEqualsEntityAndBean(UserEntity e, UserBean b) {
        assertEquals(e.getId(),b.getId());
        assertEquals(e.getUsername(),b.getUsername());
        assertEquals(e.getPassword(),b.getPassword());
        assertEquals(e.getSalt(),b.getSalt());
    }

    @Test
    public void testGetUserByUsername() {
        // given
        final String username = "testuser1";

        UserEntity user1 = new UserEntity();
        user1.setId(1);
        user1.setUsername(username);
        user1.setPassword("Password123");
        user1.setSalt("test123");

        given(userDao.getUserByUsername(username)).willReturn(user1);

        // when
        UserBean bean = testee.getUserByUsername(username);

        // then
        assertEqualsEntityAndBean(user1, bean);
    }

    @Test
    public void testGetUserNonExistentUser() {
        // given
        final String username = "bogusUsername";

        given(userDao.getUserByUsername(username)).willReturn(null);

        // when
        UserBean bean = testee.getUserByUsername(username);

        // then
        assertNull(bean);
    }

    @Test
    public void testGetUserById() {
        // given
        final Integer id = 1;

        UserEntity entity = new UserEntity();
        entity.setId(id);

        given(userDao.getUserById(id)).willReturn(entity);

        // when
        UserBean returnVal = testee.getUserById(id);

        // then
        assertEqualsEntityAndBean(entity, returnVal);
    }

    @Test
    public void testGetUserByInvalidId() {
        // given
        final Integer id = 20;

        given(userDao.getUserById(id)).willReturn(null);

        // when
        UserBean returnVal = testee.getUserById(id);

        // then
        assertNull(returnVal);
    }
}
