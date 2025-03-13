# Use OpenJDK 17 as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle wrapper and build files
COPY gradlew gradlew
COPY gradle gradle
COPY build.gradle build.gradle
COPY settings.gradle settings.gradle
COPY src src

# Give execute permission to the Gradle wrapper
RUN chmod +x ./gradlew

# Build the Spring Boot application
RUN ./gradlew build -x test

# Copy the built JAR file into the container
COPY build/libs/CoordinatorService-0.0.1-SNAPSHOT.jar CoordinatorService.jar

# Expose the application port
EXPOSE 8089

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "CoordinatorService.jar"]
