FROM openjdk:11
ADD ./target/search-and-recommendation-service-0.0.1-SNAPSHOT.jar /usr/src/search-and-recommendation-service-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "search-and-recommendation-service-0.0.1-SNAPSHOT.jar"]
