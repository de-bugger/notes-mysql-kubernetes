FROM openjdk:8-jdk-alpine
ADD target/users-mysql.jar users-mysql.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","users-mysql.jar"]
