
FROM openjdk:21-jdk-slim

WORKDIR /app

# Copy everything
COPY . .

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "target/ResponseEntDemo-0.0.1-SNAPSHOT.jar"]
