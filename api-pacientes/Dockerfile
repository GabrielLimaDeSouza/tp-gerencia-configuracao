FROM eclipse-temurin:17-jdk-alpine
RUN mkdir app
ADD /target/api-pacientes-0.0.1-SNAPSHOT.jar /app/api-pacientes.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api-pacientes.jar"]