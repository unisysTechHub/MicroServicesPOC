# Set the working directory
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the Maven build artifact to the container
ARG JAR_FILE=target/TransactionService-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} TransactionService.jar

# Expose the application port
EXPOSE 8086

# Environment variables for MySQL configuration
ENV MYSQL_HOST=localhost
ENV MYSQL_PORT=3306
ENV MYSQL_DB=db_example
ENV MYSQL_USER=springuser
ENV MYSQL_PASSWORD=ThePassword

# Run the application
ENTRYPOINT ["java", "-jar", "TransactionService.jar"]
