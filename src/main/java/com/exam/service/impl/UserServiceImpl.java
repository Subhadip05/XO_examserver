package com.exam.service.impl;

import com.exam.Repo.RoleRepo;
import com.exam.Repo.UserRepo;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepository;
    @Autowired
    private RoleRepo roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local = this.userRepository.findByUsername(user.getUsername());

        //if user already exists in database
        if(local!=null){
            System.out.println("User is already there !!");
            throw new Exception("User already exits..");
        }
        else{
            //Create user
            for(UserRole ur: userRoles)
            {
                roleRepository.save(ur.getRoleID());
            }

            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);

        }
        return local;
    }


    //getting user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }

    @Override
    public void updateUser(Long userId) {

    }


}
