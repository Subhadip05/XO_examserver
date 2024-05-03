package com.exam.service;

import com.exam.entity.User;
import com.exam.entity.UserRole;

import java.util.Set;

public interface UserService {

    //from this interface you can decide how many admin will be responsible
    public User createUser(User user , Set<UserRole> userRoles) throws Exception;

    //get user by username
    public User getUser(String username);

    //delete user by userId
    public void deleteUser(Long userId);

    //update user by UserId
    public void updateUser(Long userId);
}
