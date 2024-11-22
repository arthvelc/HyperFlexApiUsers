# Usa una imagen base de JDK
FROM eclipse-temurin:17-jdk AS build

# Crea un directorio de trabajo para el proyecto
WORKDIR /app

# Copia todos los archivos del proyecto al contenedor
COPY . .

# Construye el proyecto con Gradle
RUN ./gradlew build --no-daemon

# Usa una segunda etapa para ejecutar la aplicación
FROM eclipse-temurin:17-jdk

# Crea un directorio de trabajo para la aplicación
WORKDIR /app

# Copia el .jar generado en la etapa anterior
COPY --from=build /app/build/libs/*.jar app.jar

# Expone el puerto de la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
