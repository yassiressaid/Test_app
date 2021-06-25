FROM openjdk:11-jre-slim
ADD target/bassmaOnline-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar","app.jar"]