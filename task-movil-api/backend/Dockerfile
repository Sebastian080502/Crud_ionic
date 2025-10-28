
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -q -B -DskipTests dependency:go-offline
COPY src ./src
RUN mvn -q -B -DskipTests package


FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=build /app/target/*-SNAPSHOT.jar app.jar


ENV JAVA_OPTS=""
ENV SERVER_PORT=8080

EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]
