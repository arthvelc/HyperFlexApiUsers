# Usar una imagen base de JDK
FROM eclipse-temurin:17-jdk

# Crear un directorio para la aplicación
WORKDIR /app

# Copiar los archivos del build
COPY build/libs/*.jar app.jar

# Puerto que la aplicación utilizará
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
