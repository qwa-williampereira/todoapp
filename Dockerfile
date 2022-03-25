FROM openjdk:17-alpine

WORKDIR /app

COPY ./target/todoapp.prod.release.jar /app/

EXPOSE 8080

CMD ["java", "-jar", "todoapp.prod.release.jar"]