package com.exam;

import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	//step 1
	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	//step 2 by implementing CommandLineRunner
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting code..");

//		User user = new User();
//		user.setFirstname("Subhadip");
//		user.setLastname("Samanta");
//		user.setUsername("Subh_08");
//		user.setPassword(this.bCryptPasswordEncoder.encode("exam@12345"));
//		user.setEmail("exam10@gmail.com");
//		user.setProfile("default.png");
//		user.setPhone("7029789295");
//
//		Role role1 = new Role();
//		role1.setRollId(35);
//		role1.setRollName("ADMIN");
//
//		Set<UserRole> userRoleSet = new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRoleID(role1);
//		userRole.setUserID(user);
//		userRoleSet.add(userRole);
//
//		User user1 = this.userService.createUser(user,userRoleSet);
//		System.out.println(user1.getUsername());
	}
}
