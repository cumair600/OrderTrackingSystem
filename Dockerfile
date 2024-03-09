FROM openjdk:17
ADD target/OrderTrackingSystem-1.0-SNAPSHOT.jar OrderTrackingSystem-docker.jar
ENTRYPOINT ["java", "-jar", "OrderTrackingSystem-docker.jar"]