package com.login.demo.export;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.login.demo.utility.LogParser;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;

@Component
public class FailedLoginExporter {

	private final LogParser logParser = new LogParser();
	private final Tracer tracer;

	public FailedLoginExporter(OpenTelemetry openTelemetry) {
		this.tracer = openTelemetry.getTracer("com.example.OpenTelemetrydemoProject");
	}

	public void exportFailedLogins(String logFilePath) throws IOException {
		List<String> failedLogins = logParser.parseFailedLogins(logFilePath);

		for (String username : failedLogins) {
			Span span = tracer.spanBuilder("failed-login").startSpan();
			span.setAttribute("username", username);
			span.end();
		}
	}
}