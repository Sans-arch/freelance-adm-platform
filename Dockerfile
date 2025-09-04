# Build stage
FROM maven:3.9.6-eclipse-temurin-21 AS build
LABEL authors="santiago"

WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Production image
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
ENTRYPOINT ["java", "-jar", "app.jar"]