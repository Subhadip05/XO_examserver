package com.exam.Repo;

import com.exam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

   public User findByUsername(String username);
}
