FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.war Webapp.war
ENTRYPOINT ["java","-jar","/Webapp.war"]
