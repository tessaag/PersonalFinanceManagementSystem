package com.example.personal.finance.management.Models;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @JsonProperty("username")
    private String username;

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false, nullable = false)
    private Date createdDate= new Date();

    public UserModel(Long id, String username, String userId, String email, String password, Date createdDate) {
        Id = id;
        this.username = username;
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public UserModel() {
    }

}
