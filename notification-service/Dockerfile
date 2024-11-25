FROM maven:3.8.4-openjdk-17 AS build
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
COPY --from=build /app/target/notification-service-0.0.1-SNAPSHOT.jar notification-service.jar
COPY --from=build /app/src/main/resources/static /app/resources/static
ENTRYPOINT ["java", "-jar", "notification-service.jar"]

EXPOSE 2002
