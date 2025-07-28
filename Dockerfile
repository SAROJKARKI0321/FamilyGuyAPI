
FROM openjdk:21-jdk-slim


VOLUME /tmp


COPY target/ResponseEntDemo-0.0.1-SNAPSHOT.jar app.jar


EXPOSE 8080

# Command to run your Spring Boot app when container starts
ENTRYPOINT ["java", "-jar", "/app.jar"]
