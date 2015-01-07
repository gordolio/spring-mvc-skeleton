package com.xpanxion.skeleton.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xpanxion.skeleton.dto.entity.TestEntity;

/**
 * Implementation of the TestDao interface. 
 * 
 * @author bsmith
 *
 */
@Repository
public class TestDaoImpl implements TestDao {

    @Autowired
    private SessionFactory sessionFactory;

    /* (non-Javadoc)
     * @see com.xpanxion.skeleton.dao.TestDao#getAllItems()
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<TestEntity> getAllItems() {
        return this.sessionFactory.getCurrentSession().getNamedQuery("test.getAll").list();
    }

}
