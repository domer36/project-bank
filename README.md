# Atlas Bank

Proyecto base de una API REST para gestión de cuentas bancarias, desarrollado con Java y Spring Boot.

## Descripción

Atlas Bank es una aplicación backend que permite registrar y consultar cuentas bancarias. Actualmente incluye la estructura inicial del proyecto con persistencia, capa de servicio y endpoints REST para manejar cuentas.

## Tecnologías

- Java 21
- Spring Boot 4.0.8
- Spring Web MVC
- Spring Data JPA
- H2 Database
- Maven
- Lombok

## Estructura principal

```text
src/
├── main/
│   ├── java/
│   │   └── com/dotcomits/atlas_bank/
│   │       ├── AtlasBankApplication.java
│   │       ├── controller/
│   │       │   └── AccountController.java
│   │       ├── model/
│   │       │   └── Account.java
│   │       ├── repository/
│   │       │   └── AccountRepository.java
│   │       └── service/
│   │           └── AccountService.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── com/dotcomits/atlas_bank/
```

## Funcionalidades actuales

- Crear una cuenta bancaria
- Listar todas las cuentas
- Consultar una cuenta por su ID
- Persistencia con base de datos en memoria H2
- Acceso a la consola H2 para consultas rápidas

## Endpoints disponibles

### Cuentas

- `POST /api/accounts` - Crear una cuenta
- `GET /api/accounts` - Obtener todas las cuentas
- `GET /api/accounts/{id}` - Obtener una cuenta por ID

### Consola H2

- `http://localhost:8080/h2-console`

## Configuración

La aplicación usa H2 en memoria configurado en:

```properties
spring.datasource.url=jdbc:h2:mem:atlasbank
spring.datasource.username=sa
spring.datasource.password=sa
server.port=8080
```

## Ejecutar el proyecto

Desde la raíz del proyecto:

```bash
./mvnw spring-boot:run
```

O usando Maven:

```bash
mvn spring-boot:run
```

## Estado

Proyecto en desarrollo inicial con la base de la API funcionando y preparada para seguir agregando más funcionalidades bancarias.
