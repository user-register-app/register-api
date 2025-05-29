FROM amazoncorretto:21.0.4

EXPOSE 8082

COPY build/libs/*.jar app.jar

ENTRYPOINT exec java -jar /app.jar
