FROM openjdk:11

COPY target/*.jar /bay_02_backend/bay02.jar

RUN ls -la /bay_02_backend

ENTRYPOINT ["java", "-jar", "/bay_02_backend/bay02.jar"]
