package com.xpanxion.skeleton.dao;

import com.xpanxion.skeleton.dto.entity.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
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

    /**
     * Sets the session factory
     * @param factory the session factory
     */
    @Resource
    public void setSessionFactory(SessionFactory factory) {
        this.sessionFactory = factory;
    }
}
