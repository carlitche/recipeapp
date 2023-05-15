FROM openjdk:17
COPY /build/libs/myrecipeapp-0.1.jar myrecipeapp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "myrecipeapp.jar"]