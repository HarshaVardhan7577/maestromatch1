FROM openjdk:11
ADD ./target/content-management-service-0.0.1-SNAPSHOT.jar /usr/src/content-management-service-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "content-management-service-0.0.1-SNAPSHOT.jar"]
