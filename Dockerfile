FROM gradle:8.14.4-jdk21 AS build

COPY src/main ./src/main
COPY build.gradle settings.gradle  ./

RUN gradle clean build

FROM eclipse-temurin:21-jre AS run

RUN adduser --system --group app-user

COPY --from=build --chown=app-user:app-user /home/gradle/build/libs/airbin-graphql-api-*.jar app.jar

EXPOSE 8080
USER app-user

CMD ["java", "-jar", "app.jar"]