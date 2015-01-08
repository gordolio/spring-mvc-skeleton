package com.xpanxion.skeleton.dao;

import com.xpanxion.skeleton.dto.entity.UserEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Implementation of UserDao
 *
 * @author Gordon Child
 */
@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<UserEntity> getAllItems() {
        return this.sessionFactory.getCurrentSession().getNamedQuery("users.getAll").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public UserEntity getUserByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("users.getByUsername");
        query.setString("username",username.toLowerCase());
        List<UserEntity> list = query.list();
        if(list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public UserEntity getUserById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("users.getById");
        query.setInteger("id", id);
        UserEntity user = (UserEntity)query.uniqueResult();
        return user;
    }

    /**
     * Sets the session factory
     * @param factory the session factory
     */
    @Resource
    public void setSessionFactory(SessionFactory factory) {
        this.sessionFactory = factory;
    }
}
