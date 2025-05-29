FROM amazoncorretto:21.0.4

EXPOSE 8082

COPY docker-tmp/app.jar app.jar

ENTRYPOINT exec java -jar /app.jar
