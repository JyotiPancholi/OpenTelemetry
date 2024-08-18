package com.login.demo.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import com.login.demo.utility.CsvExporter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.demo.entity.LoginFailure;
import com.login.demo.repository.LoginFailureRepository;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginFailureRepository loginFailureRepository;

    @Autowired
    private CsvExporter csvExporter;
    
    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);


    @Override
    public void recordFailedLogin(String username) {
        LoginFailure loginFailure = new LoginFailure(username, LocalDateTime.now());
        loginFailureRepository.save(loginFailure);
        System.out.println("Failed login attempt recorded for user: " + username);
        logger.error("Failed login attempt for user: {}", username);
    }

    @Override
    public void exportFailedLoginsToCsv() throws IOException {
        List<LoginFailure> failedLogins = loginFailureRepository.findAll();
        csvExporter.exportToCsv(failedLogins, "failed-logins.csv");
        System.out.println("Exporting " + failedLogins.size() + " failed login attempts to CSV.");
//        csvExporter.exportToCsv(failedLogins, "failed-logins.csv");
        
    }
}