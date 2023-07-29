# Use the OpenJDK 17 Alpine image as the base image
FROM openjdk:17-jdk-alpine

# Set the JAR_FILE argument and provide a default value (if needed)
ARG JAR_FILE=target/*.jar
# If the JAR_FILE is not in the root directory but in a subdirectory, adjust the path accordingly.

# Copy the JAR file into the image with the name "app.jar"
COPY ${JAR_FILE} app.jar

# Set the entrypoint to run the Java application when the container starts
ENTRYPOINT ["java","-jar","/app.jar"]
