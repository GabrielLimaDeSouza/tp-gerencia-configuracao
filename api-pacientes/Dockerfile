FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/api-pacientes-1.0.0.jar api-pacientes.jar
ENTRYPOINT ["java", "-jar", "api-pacientes.jar"]