FROM java:8
VOLUME /tmp
ADD target/*.jar /cart.jar
EXPOSE 7002
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/cart.jar"]
