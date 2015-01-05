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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

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

}
