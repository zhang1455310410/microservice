FROM java:8
VOLUME /tmp
ADD target/*.jar /center.jar
EXPOSE 7003
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/center.jar"]
