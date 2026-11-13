# Implementación de un servidor de configuración y un microservicio de catálogo

**Estudiante:** Dimas Mijael Flores Yerba  
**Docente:** Mtro. Noe Wilber Tipo Mamani  
**Institución:** Universidad Nacional de Juliaca

## 1. Objetivo

Implementar la centralización de configuraciones mediante Spring Cloud Config Server y desarrollar un microservicio de catálogo con operaciones de creación, consulta, actualización y eliminación de categorías, persistencia en PostgreSQL y documentación mediante Swagger.

## 2. Arquitectura de la solución

| Componente | Puerto | Función |
| --- | --- | --- |
| ms-config-server | 7070 | Obtener la configuración almacenada en GitHub |
| ms-catalogo-service | 8081 | Exponer las operaciones REST de categorías |
| PostgreSQL | 5432 | Almacenar los datos de la base ms_catalogo |

El servidor consulta el repositorio privado `dimas-flores/manufactura-config-catalogo`, en la rama `main`. El archivo de configuración se encuentra en `config-data/ms-catalogo-service-development.yml`.

## 3. Tecnologías utilizadas

Java 17 o superior, Maven Wrapper, Spring Boot 4.1.2, Spring Cloud 2025.1.4, Spring Data JPA, PostgreSQL, Lombok y springdoc-openapi 3.2.0.

## 4. Configuración del entorno

La base de datos se denomina `ms_catalogo`. Para crearla se proporciona el archivo `crear_base.sql`. La conexión de práctica utiliza `localhost:5432`, el usuario `postgres` y la contraseña `123456`.

El acceso al repositorio privado se realiza mediante las variables de entorno `GITHUB_USERNAME` y `GITHUB_TOKEN`. La primera tiene como valor predeterminado `dimas-flores`; la segunda debe contener un token con permiso de lectura del repositorio. El token no se incluye en el código fuente.

## 5. Ejecución

Se inicia primero PostgreSQL, luego `ms-config-server` y finalmente `ms-catalogo-service`. En cada proyecto se ejecuta `./mvnw spring-boot:run` desde su directorio. En Windows se utiliza `mvnw.cmd`.

| Recurso | Dirección |
| --- | --- |
| Configuración del catálogo | http://localhost:7070/ms-catalogo-service/development |
| Interfaz Swagger | http://localhost:8081/doc/swagger-ui.html |
| Especificación OpenAPI | http://localhost:8081/v3/api-docs |

La consulta al servidor de configuración requiere el usuario `root` y la contraseña de práctica `123456`.

## 6. Verificación funcional

En la ejecución previa al cambio de cuenta de GitHub se comprobaron la compilación de ambos proyectos, la lectura de configuración, la conexión con PostgreSQL y las operaciones del catálogo. Se obtuvieron respuestas HTTP 200 para creación, consulta y actualización; HTTP 204 para eliminación y HTTP 404 al consultar el registro eliminado. También se verificaron Swagger y la especificación OpenAPI.

Después de actualizar el repositorio a la cuenta `dimas-flores`, se confirmó el acceso al archivo de configuración mediante la API de GitHub. Se encuentra pendiente repetir la ejecución integral con esta cuenta. Los resultados disponibles se conservan en `verification/` y en `VERIFICACION.txt`.
