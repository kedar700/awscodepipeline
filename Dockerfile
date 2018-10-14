FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/example-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
EXPOSE 8081
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
