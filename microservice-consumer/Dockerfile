FROM java:8
VOLUME /tmp
ADD target/*.jar /consumer.jar
EXPOSE 8002
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/consumer.jar"]
