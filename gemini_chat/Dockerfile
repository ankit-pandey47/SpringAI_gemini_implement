# Use official OpenJDK image as base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container (adjust the path based on your project build output)
COPY target/SpringAI_gemini_implement.jar /app/app.jar

# Expose the port your Spring Boot app will run on
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
