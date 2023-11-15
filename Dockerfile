FROM openjdk:11
EXPOSE 8089
WORKDIR /app
RUN apt-get update && apt-get install -y curl
RUN curl -o achat-1.0.jar -L "http://192.168.1.14:8081/repository/maven-releases/com/esprit/examen/tpAchatProject/1.0/tpAchatProject-1.0.jar"
ENTRYPOINT ["java", "-jar", "tpAchatProject-1.0.jar"]