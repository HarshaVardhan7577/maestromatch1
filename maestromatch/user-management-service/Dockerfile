FROM openjdk:11
ADD ./target/user-management-service-0.0.1-SNAPSHOT.jar-SNAPSHOT.jar /usr/src/user-management-service-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "user-management-service-0.0.1-SNAPSHOT.jar"]
