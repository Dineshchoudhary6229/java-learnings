# Use openJDK 21 slim base image
FROM openjdk:21-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy fat JAR into container
COPY target/student-management.jar student-management.jar

# Expose port if needed (optional, console app doesn't need it)
# EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java", "-jar", "student-management.jar"]
