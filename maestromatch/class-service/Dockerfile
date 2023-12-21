FROM openjdk:11
ADD .target/class-service-0.0.1-SNAPSHOT.jar /usr/src/class-service-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "class-service-0.0.1-SNAPSHOT.jar"]
