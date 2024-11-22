
# Hyperflex User API

Esta API proporciona una solución para gestionar usuarios con funcionalidades como creación, actualización, eliminación y consulta. La API está construida con Spring Boot y sigue las mejores prácticas de desarrollo para la prueba técnica con HyperFlex.

## Documentación
La API está documentada con Swagger. Una vez que la aplicación esté en ejecución, puedes acceder a la documentación interactiva en: `http://localhost:8080/swagger-ui/index.html`.

## Estructura del Proyecto

### Entity
El proyecto utiliza la entidad `UserEntity` para mapear la tabla `users` en la base de datos. Cada usuario incluye los siguientes campos:
- **idUser**: Identificador único del usuario (autogenerado).
- **userName**: Nombre de usuario, obligatorio y único.
- **email**: Dirección de correo electrónico válida y obligatoria.
- **password**: Contraseña del usuario (almacenada de forma segura).
- **name**: Nombre del usuario.
- **lastName**: Apellido del usuario.
- **birthday**: Fecha de nacimiento (debe ser una fecha pasada).

### Controlador
El controlador define los endpoints RESTful para interactuar con los usuarios. Todos los endpoints están disponibles en el prefijo `/api/users`.

#### Endpoints
- **GET /api/users**: Obtiene una lista de todos los usuarios.
- **GET /api/users/{idUser}**: Obtiene un usuario por su ID.
- **GET /api/users/username/{userName}**: Obtiene un usuario por su nombre de usuario.
- **POST /api/users**: Crea un nuevo usuario (requiere un objeto `UserEntity` en el cuerpo).
- **POST /api/users/insert**: Inserta múltiples usuarios en una sola llamada.
- **PUT /api/users**: Actualiza un usuario existente.
- **DELETE /api/users/{idUser}**: Elimina un usuario por su ID.

### Servicio
La lógica de negocio se encuentra en el servicio `UserService`, que incluye métodos para gestionar usuarios de manera segura y eficiente. Se utiliza el `PasswordEncoder` de Spring Security para garantizar que las contraseñas se almacenen de forma segura.

#### Métodos del Servicio
- **getUsers()**: Devuelve todos los usuarios.
- **getUser(Long idUser)**: Devuelve un usuario por ID.
- **getByUserName(String userName)**: Devuelve un usuario por nombre de usuario.
- **save(UserEntity user)**: Guarda o actualiza un usuario.
- **saveAll(List<UserEntity> users)**: Inserta múltiples usuarios.
- **deleteUser(Long idUser)**: Elimina un usuario por ID.
- **exist(Long idUser)**: Verifica si un usuario existe.

## Configuración

### Dependencias Principales
- **Spring Boot**: Framework principal.
- **Spring Data JPA**: Para interacción con la base de datos.
- **Spring Security**: Para cifrado de contraseñas.
- **Lombok**: Para simplificar el código mediante anotaciones.
- **Jakarta Validation**: Para validaciones de datos.

### Base de Datos
La API utiliza una base de datos MySQL. Configura las credenciales de la base de datos en el archivo `application.properties`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hyperflex_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

## Instalación y Ejecución

1. Clona este repositorio.
2. Configura la base de datos y ajusta el archivo `application.properties` según tu entorno.
3. Construye el proyecto:
   ```bash
   ./gradlew build
   ```
4. Ejecuta la aplicación:
   ```bash
   ./gradlew bootRun
   ```

## Ejemplo de Peticiones

### Crear un Usuario
**POST /api/users**
```json
{
    "userName": "user123",
    "email": "user123@example.com",
    "password": "securePassword123",
    "name": "John",
    "lastName": "Doe",
    "birthday": "1990-01-01"
}
```

### Obtener Todos los Usuarios
**GET /api/users**

Respuesta:
```json
[
    {
        "idUser": 1,
        "userName": "user123",
        "email": "user123@example.com",
        "name": "John",
        "lastName": "Doe",
        "birthday": "1990-01-01"
    }
]
```

