package com.login.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LoginFailure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private LocalDateTime failedLoginTime;

    // Constructors, getters, and setters
    public LoginFailure() {}

    public LoginFailure(String username, LocalDateTime failedLoginTime) {
        this.username = username;
        this.failedLoginTime = failedLoginTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getFailedLoginTime() {
        return failedLoginTime;
    }

    public void setFailedLoginTime(LocalDateTime failedLoginTime) {
        this.failedLoginTime = failedLoginTime;
    }
}