package com.login.demo.service;

import java.io.IOException;

public interface LoginService {
    void recordFailedLogin(String username);
    void exportFailedLoginsToCsv() throws IOException;
}