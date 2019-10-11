FROM java:8
VOLUME /tmp
ADD target/*.jar /zipkin.jar
EXPOSE 9411
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/zipkin.jar"]
