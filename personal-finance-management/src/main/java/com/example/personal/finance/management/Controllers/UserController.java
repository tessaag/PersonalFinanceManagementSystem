package com.example.personal.finance.management.Controllers;


import com.example.personal.finance.management.Models.UserModel;
import com.example.personal.finance.management.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/signUp")
    public ResponseEntity<Map<String, String>> addUser(@RequestBody UserModel userModel){
        UserModel userModel1 = userRepo.save(userModel);
        Map<String, String> response = new HashMap<>();
        if(userModel1.getId()!=0){
            response.put("status","Success");
        }
        else {
            response.put("status","Failed");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/SignIn")
    public ResponseEntity<Map<String, String>> SignInUser(@RequestBody UserModel userModel){
        List<UserModel > userModel1 = userRepo.validation(userModel.getEmail(),userModel.getPassword());
        Map<String, String> response = new HashMap<>();
        if(userModel1.size()>0){
            response.put("status","Success");
            response.put("userId",String.valueOf(userModel1.get(0).getUserId()));
            response.put("name",String.valueOf(userModel1.get(0).getUsername()));
        }
        else {
            response.put("status","Failed");
        }
        return ResponseEntity.ok(response);
    }


}
