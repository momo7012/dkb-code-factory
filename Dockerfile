FROM openjdk:17-alpine

EXPOSE 8090

WORKDIR /app

COPY target/shorturl-0.0.1-SNAPSHOT.jar /app.jar

CMD ["java", "-jar", "-Dspring.profiles.active=default", "/app.jar"]

