FROM openjdk:21
ARG APP_JAR=*.jar
COPY ${APP_JAR} app.jar
ENV DB_URL="jdbc:postgresql://localhost:5432/test"
ENV DB_USERNAME=postgres
ENV DB_PASSWORD=admin
ENTRYPOINT ["java", "-jar", "app.jar"]