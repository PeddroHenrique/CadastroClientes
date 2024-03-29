FROM maven:3.9.4-amazoncorretto-17-debian AS build
WORKDIR /app
COPY /src /app/src
COPY /pom.xml /app
RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip 

FROM amazoncorretto:17.0.8-alpine3.18
EXPOSE 8080
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
