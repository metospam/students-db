FROM openjdk:17-slim

COPY ./target/student-db-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app

CMD ["java", "-jar", "student-db-0.0.1-SNAPSHOT.jar"]