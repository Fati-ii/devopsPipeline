FROM eclipse-temurin:17-jre-alpine
VOLUME /tmp
COPY target/*.war app.war
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.war"]
