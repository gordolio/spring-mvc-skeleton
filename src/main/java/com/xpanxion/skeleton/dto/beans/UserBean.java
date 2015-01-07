package com.xpanxion.skeleton.dto.beans;

import java.io.Serializable;

/**
 * Created by gchild on 1/2/2015.
 */
public class UserBean implements Serializable {

    private long id;

    private String username;

    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
