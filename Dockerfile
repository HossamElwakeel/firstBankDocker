FROM openjdk:11
ADD build/libs/firstone-1.0.jar firstone-1.0.jar
Expose 8080
ENTRYPOINT ["java","-jar","firstone-1.0.jar"]