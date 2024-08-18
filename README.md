# OpenTelemetryDemo

This project demonstrates how to capture failed login attempts in a Spring Boot application using OpenTelemetry and report the data in a CSV file.

## Prerequisites

- Java 17
- Maven
- Spring Boot

## Setup Instructions

1 **Clone the Repository**

2 **Build the Project**
     - mvn clean install
     
3 **Run the Spring Boot Application**
     - mvn spring-boot:run
     
4 **Simulate a Failed Login Attempt**
     - curl -X POST "http://localhost:8080/login/fail?username=testuser"
     
5 **Export the Failed Logins to a CSV File**
     - curl -X GET "http://localhost:8080/login/export"
     
6 **Check the Exported CSV File**
    After running the export command, you should find the CSV file named failed-logins.csv in the project's root director    
