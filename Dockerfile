FROM openjdk:17
ADD target/subscription-[service.jar](service.jar) [app.jar](app.jar)
ENTRYPOINT ["java","-jar","app.jar"]