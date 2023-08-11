FROM maven:3-openjdk-17 AS build-image
WORKDIR /to-build-app
COPY src ./src & pom.xml
RUN mvn package -Dsk ipTests & mvn dependency:go-offline
FROM adopt openjdk:17-jre
WORKDIR /app
COPY --from=build-image /to-build-app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["-jar", "app.jar", "java"]