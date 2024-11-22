
# Hyperflex User API

API para la gestión de usuarios para la prueba técnica de hyperflex.

## Requisitos Previos

- **Java 17** o superior.
- **Gradle** como herramienta de construcción.
- **MySQL** como base de datos.

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu-repo/hyperflex-user-api.git
   cd hyperflex-user-api
   ```

2. Configura la base de datos:
    - Crea una base de datos en MySQL llamada `hyperflex`.
    - Actualiza el archivo `application.properties` con tus credenciales de MySQL:
      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/hyperflex
      spring.datasource.username=tu_usuario
      spring.datasource.password=tu_contraseña
      ```

3. Construye el proyecto:
   ```bash
   ./gradlew build
   ```

4. Ejecuta la aplicación:
   ```bash
   ./gradlew bootRun
   ```

5. Accede a Swagger UI para probar los endpoints:
   ```
   http://localhost:8080/swagger-ui.html
   ```

## Endpoints

### Base URL
```
http://localhost:8080/api/users
```

## Documentación Swagger

Puedes encontrar la documentación interactiva generada automáticamente en:

```
http://localhost:8080/swagger-ui.html
```

### Lista de Endpoints

#### 1. Crear un Usuario
- **POST** `/api/users`
- **Body JSON**:
  ```json
  {
    "userName": "user1",
    "email": "user1@example.com",
    "password": "password1",
    "name": "John",
    "lastName": "Doe",
    "birthday": "1990-05-15"
  }
  ```
- **Response**:
  ```json
  {
    "idUser": 1,
    "userName": "user1",
    "email": "user1@example.com",
    "name": "John",
    "lastName": "Doe",
    "birthday": "1990-05-15"
  }
  ```

#### 2. Obtener Todos los Usuarios
- **GET** `/api/users`
- **Response**:
  ```json
  [
    {
      "idUser": 1,
      "userName": "user1",
      "email": "user1@example.com",
      "name": "John",
      "lastName": "Doe",
      "birthday": "1990-05-15"
    },
    {
      "idUser": 2,
      "userName": "user2",
      "email": "user2@example.com",
      "name": "Jane",
      "lastName": "Smith",
      "birthday": "1992-08-20"
    }
  ]
  ```

#### 3. Crear una Lista de Usuarios
- **POST** `/api/users/batch`
- **Body JSON**:
  ```json
  [
    {
      "userName": "user1",
      "email": "user1@example.com",
      "password": "password1",
      "name": "John",
      "lastName": "Doe",
      "birthday": "1990-05-15"
    },
    {
      "userName": "user2",
      "email": "user2@example.com",
      "password": "password2",
      "name": "Jane",
      "lastName": "Smith",
      "birthday": "1992-08-20"
    }
  ]
  ```
- **Response**:
  ```json
  [
    {
      "idUser": 1,
      "userName": "user1",
      "email": "user1@example.com",
      "name": "John",
      "lastName": "Doe",
      "birthday": "1990-05-15"
    },
    {
      "idUser": 2,
      "userName": "user2",
      "email": "user2@example.com",
      "name": "Jane",
      "lastName": "Smith",
      "birthday": "1992-08-20"
    }
  ]
  ```


## Arquitectura

- **Framework**: Spring Boot
- **Base de Datos**: MySQL
- **Autenticación y Seguridad**: Spring Security (Bcrypt para encriptación de contraseñas)
- **Documentación**: Swagger (Springdoc OpenAPI)

## Tecnologías Usadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Security**
- **Springdoc OpenAPI**
- **MySQL**

## Autor

- **Nombre**: Arturo Solares
- **Email**: [asolares.devml@gmail.com](Arturo:asolares.devml@gmail.com)

¡Gracias por permitirme estar en este proceso!
