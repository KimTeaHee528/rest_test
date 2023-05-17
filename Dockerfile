FROM openjdk:11-jdk
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} rest.jar
ENTRYPOINT ["java","-jar","rest.jar"]