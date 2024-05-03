package com.exam.entity;

import jakarta.persistence.*;

@Entity
public class UserRole {

    //using this class we will know which user will get which role (admin or candidate for exam)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //primary key of UserRole table
    private Long userRoleId;

    //userId --> foreign key of User table
    @ManyToOne(fetch = FetchType.EAGER)
    private User userID;

    //roleId --> foreign key of Role table
    @ManyToOne
    private Role roleID;

    public UserRole() {

    }



    public Role getRoleID() {
        return roleID;
    }

    public void setRoleID(Role roleID) {
        this.roleID = roleID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }



}
