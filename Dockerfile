FROM amazoncorretto:21.0.4

EXPOSE 8082

ARG JAR_FILE=target/register-api-latest.jar
ADD ${JAR_FILE} app.jar

ENTRYPOINT exec jara -jar /app.jar