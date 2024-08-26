# Use the official OpenJDK image that matches your Java version
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and source code into the container
COPY . .

# Package the application using Maven
RUN ./mvnw package -DskipTests

# Expose the port the application will run on
EXPOSE 8080

# Set the entry point to run the jar file
ENTRYPOINT ["java", "-jar", "target/coursesapi-0.0.1-SNAPSHOT.jar"]
