# Use an official OpenJDK runtime as a parent image
FROM openjdk:17

# Set the working directory to /app
WORKDIR /app

# Copy the JAR file into the container at /app
COPY target/clustered-warehouse-service.jar /app/app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Command to run the JAR file
CMD ["java", "-jar", "app.jar"]
