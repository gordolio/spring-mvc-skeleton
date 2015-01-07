package com.xpanxion.skeleton.dao;

import com.xpanxion.skeleton.dto.entity.UserEntity;

import java.util.List;

/**
 * Created by gchild on 1/2/2015.
 */
public interface UserDao {

    /**
     * Returns all of the user entities.
     * @return all of the user entities.
     */
    List<UserEntity> getAllItems();

    UserEntity getUserByUsername(String username);
}
