package com.exam.controller;

//Authentication class 5 Done

import com.exam.config.JWTUtils;
import com.exam.entity.JwtRequest;
import com.exam.entity.JwtResponse;

import com.exam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JWTUtils jwtUtils;


    @PostMapping("/generate-token")
    public ResponseEntity<?> login(@RequestBody JwtRequest request) throws Exception{

        try
        {
            this.doAuthenticate(request.getUsername(), request.getPassword());

        } catch (UsernameNotFoundException e)
        {
            e.printStackTrace();
            throw new Exception("User Not found");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void doAuthenticate(String username, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
        try {

            manager.authenticate(authentication);

        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }


    //02-05-2024
    //return the details of current user
    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal){
        return (User) this.userDetailsService.loadUserByUsername(principal.getName());
    }
}
