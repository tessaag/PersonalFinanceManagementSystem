package com.example.personal.finance.management.Repository;

import com.example.personal.finance.management.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<UserModel, Long> {
    @Query(value = "SELECT * FROM `user_model` WHERE email = ?1 and password = ?2", nativeQuery = true)
    List<UserModel> validation(String email, String password);
}
