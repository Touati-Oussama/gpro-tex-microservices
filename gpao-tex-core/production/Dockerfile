FROM openjdk:17-oracle
VOLUME /tmp
COPY target/production-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
