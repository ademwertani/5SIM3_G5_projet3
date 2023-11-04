# Utilisez l'image de base OpenJDK 11
FROM openjdk:11-jre-slim

# Répertoire de travail dans le conteneur
WORKDIR /app

# Copiez le jar de votre application dans le conteneur (assurez-vous que le nom du fichier JAR correspond à votre projet)
COPY target/classes-2.5.3.jar app.jar

# Exposez le port sur lequel votre application Spring Boot fonctionne (par défaut, c'est généralement 8080)
EXPOSE 8080

# Commande pour exécuter votre application Spring Boot
CMD ["java", "-jar", "app.jar"]
