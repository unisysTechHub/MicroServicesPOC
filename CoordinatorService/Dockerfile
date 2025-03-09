# Use official OpenJDK 17 runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the build files (JAR) into the container
COPY build/libs/CoordinatorService-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the app runs on
EXPOSE 8089

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
