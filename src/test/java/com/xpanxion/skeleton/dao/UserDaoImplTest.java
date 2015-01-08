package com.xpanxion.skeleton.dao;

import com.xpanxion.skeleton.dto.entity.UserEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * Created by gchild on 1/5/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserDaoImplTest {

    @InjectMocks
    private UserDaoImpl testee;

    @Mock
    private SessionFactory factory;

    @Test
    public void testGetAllItems() {
        // given
        Session session = mock(Session.class);
        Query query = mock(Query.class);

        List<UserEntity> returnList = new ArrayList<>();

        given(factory.getCurrentSession()).willReturn(session);
        given(session.getNamedQuery("users.getAll")).willReturn(query);
        given(query.list()).willReturn(returnList);

        // when
        List<UserEntity> output = testee.getAllItems();

        // then
        assertEquals(returnList, output);
    }

    @Test
    public void testGetUserByUsername() {
        // given
        Session session = mock(Session.class);
        Query query = mock(Query.class);

        final String username = "testUser1";
        UserEntity user = new UserEntity();
        user.setUsername(username);
        List<UserEntity> users = new ArrayList<>();
        users.add(user);
        given(factory.getCurrentSession()).willReturn(session);
        given(session.getNamedQuery("users.getByUsername")).willReturn(query);
        given(query.list()).willReturn(users);

        // when
        UserEntity returned = testee.getUserByUsername(username);

        // then
        assertEquals(user, returned);
        verify(query).setString("username",username.toLowerCase());
    }

    @Test
    public void testGetUserByUsernameReturnsNull() {
        // given
        Session session = mock(Session.class);
        Query query = mock(Query.class);
        String username = "bogusUser";

        List<UserEntity> list = new ArrayList<>();
        given(factory.getCurrentSession()).willReturn(session);
        given(session.getNamedQuery("users.getByUsername")).willReturn(query);
        given(query.list()).willReturn(list);

        // when
        UserEntity user = testee.getUserByUsername(username);

        // then
        assertNull(user);
        verify(query).setString("username",username.toLowerCase());
    }

    @Test
    public void testGetUserByUserId() {
        // given
        Session session = mock(Session.class);
        Query query = mock(Query.class);

        UserEntity user = new UserEntity();
        user.setId(1);
        given(factory.getCurrentSession()).willReturn(session);
        given(session.getNamedQuery("users.getById")).willReturn(query);
        given(query.uniqueResult()).willReturn(user);

        // when
        UserEntity returnedUser = testee.getUserById(1);

        // then
        assertEquals(user, returnedUser);
        verify(query).setInteger("id", 1);
    }

    @Test
    public void testGetUserByInvalidId() {
        // given
        Session session = mock(Session.class);
        Query query = mock(Query.class);

        given(factory.getCurrentSession()).willReturn(session);
        given(session.getNamedQuery("users.getById")).willReturn(query);
        given(query.uniqueResult()).willReturn(null);

        // when
        UserEntity returnedUser = testee.getUserById(10);

        // then
        assertNull(returnedUser);
        verify(query).setInteger("id",10);
    }

}
