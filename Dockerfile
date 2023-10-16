# Use a base image with OpenJDK preinstalled
FROM openjdk:21

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file into the container
COPY target/store-0.0.1-SNAPSHOT.jar .

# Define the command to run your application
CMD ["java", "-jar", "store-0.0.1-SNAPSHOT.jar"]