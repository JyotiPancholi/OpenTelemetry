package com.login.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.login.demo.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/fail")
    public void recordFailedLogin(@RequestParam String username) {
        loginService.recordFailedLogin(username);
    }

    @GetMapping("/export")
    public void exportFailedLogins() throws IOException {
        loginService.exportFailedLoginsToCsv();
    }
}