package com.xpanxion.skeleton.dto.entity;

import javax.persistence.*;

/**
 * UserEntity created by Gordon Child on 1/2/2015
 */
@Entity
@Table(name="users")
@NamedQueries({
        @NamedQuery(name = "users.getAll", query = "from UserEntity"),
        @NamedQuery(name = "users.getByUsername", query = "from UserEntity where lower(username)=:username")
})
public class UserEntity {
    private long id;
    private String username;
    private String password;

    /**
     * Returns the ID of the entity
     * @return id
     */
    @Id
    @GeneratedValue
    public long getId() {
        return this.id;
    }

    /**
     * Returns the username of the entity
     * @return username
     */
    @Column(name="username")
    public String getUsername() {
        return this.username;
    }

    /**
     * Returns the password of the entity
     * @return password
     */
    @Column(name="password")
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets the id of the entity
     * @param id - the ID
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Sets the username of the entity
     * @param username - The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the password of the entity
     * @param password - the Password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
