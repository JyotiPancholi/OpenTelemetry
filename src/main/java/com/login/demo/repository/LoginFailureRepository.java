package com.login.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.demo.entity.LoginFailure;

public interface LoginFailureRepository extends JpaRepository<LoginFailure, Long> {
}