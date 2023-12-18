FROM openjdk:21
ARG APP_JAR=*.jar
COPY ${APP_JAR} app.jar
ENV DB_URL=jdbc:postgresql://5.35.82.78:1234/Grani
ENV DB_USERNAME=mynewuser
ENV DB_PASSWORD=mypassword
ENTRYPOINT ["java", "-jar", "app.jar"]