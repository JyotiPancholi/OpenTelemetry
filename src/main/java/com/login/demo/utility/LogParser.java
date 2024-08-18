package com.login.demo.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser {
	
	private static final Pattern FAILED_LOGIN_PATTERN = Pattern.compile("Failed login attempt for user: (.+)");

	public List<String> parseFailedLogins(String logFilePath) throws IOException {
		List<String> failedLogins = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(logFilePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				Matcher matcher = FAILED_LOGIN_PATTERN.matcher(line);
				if (matcher.find()) {
					failedLogins.add(matcher.group(1));
				}
			}
		}
		return failedLogins;
	}
}