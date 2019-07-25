FROM gradle:jdk8 as builder

EXPOSE 8080
STOPSIGNAL SIGTERM

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

FROM openjdk:8-jre-slim
COPY --from=builder /home/gradle/src/build/libs/app.jar /app/

WORKDIR /app
CMD java -jar app.jar