package com.exam.controller;

import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //creating user by "/" after "/user"
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {

        user.setProfile("default.png");
        Set<UserRole> roles = new HashSet<>();

        //going to encode password with BCryptPasswordEncoder
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

        Role role = new Role();
        role.setRollId(36L);
        role.setRollName("NORMAL_USER");

        UserRole userRole = new UserRole();
        userRole.setUserID(user);
        userRole.setRoleID(role);

        roles.add(userRole);

        //this createUser from UserService interface
        return this.userService.createUser(user,roles);
    }

    //getting user details by username
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return this.userService.getUser(username);
    }


    //delete user by userId
    @DeleteMapping("/userId")
    public void deleteUser(@PathVariable("userId") Long userId){
        this.userService.deleteUser(userId);
    }


    //update user by userId

}
