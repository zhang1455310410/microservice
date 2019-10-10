FROM java:8
VOLUME /tmp
ADD target/*.jar /sellercenter.jar
EXPOSE 7003
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/sellercenter.jar"]
