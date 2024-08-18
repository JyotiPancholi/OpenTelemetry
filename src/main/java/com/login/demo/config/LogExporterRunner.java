package com.login.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.login.demo.export.FailedLoginExporter;

@Component
public class LogExporterRunner implements CommandLineRunner {

    private final FailedLoginExporter failedLoginExporter;

    public LogExporterRunner(FailedLoginExporter failedLoginExporter) {
        this.failedLoginExporter = failedLoginExporter;
    }

    @Override
    public void run(String... args) throws Exception {
        failedLoginExporter.exportFailedLogins("failed-logins.log");
    }
}
