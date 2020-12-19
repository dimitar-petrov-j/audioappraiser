FROM openjdk:10-jre-slim

WORKDIR /audioapp
COPY ./target/audioapp-0.0.1/SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "audioapp-0.0.1/SNAPSHOT.jar"]