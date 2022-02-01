#FROM adoptopenjdk/openjdk11:alpine-jre
#ADD target/gestionEmp-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-jar","app.jar"]
######################################################################################"
#FROM java:8

#EXPOSE 8080

#ADD target/gestionEmp-0.0.1-SNAPSHOT.jar app.jar

#ENTRYPOINT ["java","-jar","app.jar"]


######################################################################################"

FROM openjdk:8
ADD target/gestionEmp-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
