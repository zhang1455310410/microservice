FROM java:8
VOLUME /tmp
ADD target/*.jar /eureka.jar
EXPOSE 7001
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eureka.jar"]
