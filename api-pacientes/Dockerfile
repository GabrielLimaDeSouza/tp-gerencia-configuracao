FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
ADD target/api-pacientes-0.0.1-SNAPSHOT.jar api-pacientes.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api-pacientes.jar"]