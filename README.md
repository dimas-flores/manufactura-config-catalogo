# Config Server y Catálogo

Práctica de la guía del curso. Config Server obtiene `config-data/ms-catalogo-service-development.yml` de este repositorio privado, rama `main`.

Requiere Java 17+, PostgreSQL 15+ y Maven Wrapper incluido. Crear `ms_catalogo` con `crear_base.sql`. La configuración de práctica usa PostgreSQL en localhost:5433, usuario postgres y clave 123456.

Definir GITHUB_TOKEN con un token que tenga permiso de lectura de este repositorio. GITHUB_USERNAME tiene como valor predeterminado dimas-flores. No guardar el token en archivos versionados. Con GitHub CLI autenticado: `export GITHUB_TOKEN="$(gh auth token)"`.

Iniciar primero ms-config-server con `./mvnw spring-boot:run` y después ms-catalogo-service con el mismo comando desde su carpeta.

Config Server: http://localhost:7070/ms-catalogo-service/development (root / 123456). Swagger: http://localhost:8081/doc/swagger-ui.html.
