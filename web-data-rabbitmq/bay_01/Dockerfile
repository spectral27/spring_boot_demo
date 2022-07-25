FROM openjdk:11

COPY target/*.jar /bay_01_backend/bay01.jar

RUN ls -la /bay_01_backend

ENTRYPOINT ["java", "-jar", "/bay_01_backend/bay01.jar"]
