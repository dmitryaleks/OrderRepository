FROM openjdk:21
EXPOSE 8080
ADD ./target/*.jar service.jar
ENTRYPOINT ["java","-jar","/service.jar"]
