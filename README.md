# Atlas Bank

API REST bancaria construida con Java 21 y Spring Boot 4 para gestionar cuentas y transferencias entre cuentas.

## Descripción

Atlas Bank es un backend de ejemplo para una solución bancaria simple. El proyecto incluye operaciones para crear cuentas, consultar su información, registrar movimientos y ejecutar transferencias con validaciones de negocio como saldo insuficiente y cuentas inactivas.

## Stack tecnológico

- Java 21
- Spring Boot 4.0.8
- Spring Web MVC
- Spring Data JPA
- Hibernate / H2
- Maven Wrapper
- Lombok
- MapStruct

## Estructura del proyecto

```text
src/
├── main/
│   ├── java/
│   │   └── com/dotcomits/atlas_bank/
│   │       ├── AtlasBankApplication.java
│   │       ├── account/
│   │       │   ├── controller/
│   │       │   ├── dto/
│   │       │   ├── exception/
│   │       │   ├── model/
│   │       │   ├── repository/
│   │       │   └── service/
│   │       ├── shared/
│   │       │   └── exception/
│   │       └── transaction/
│   │           ├── controller/
│   │           ├── dto/
│   │           ├── exception/
│   │           ├── model/
│   │           ├── repository/
│   │           ├── service/
│   │           └── validation/
│   └── resources/
│       └── application.properties
├── test/
│   └── java/
│       └── com/dotcomits/atlas_bank/
└── pom.xml
```

## Funcionalidades actuales

- Registro y consulta de cuentas bancarias
- Almacenamiento persistente en base de datos H2 en memoria
- Transferencias entre cuentas
- Validación de cuenta activa
- Validación de saldo disponible
- Registro de movimientos/transacciones con cálculo de comisiones por tipo de cuenta
- Manejo centralizado de errores con `@RestControllerAdvice`
- Acceso a consola H2 para consultar datos de prueba

## Endpoints disponibles

### Cuentas

- `POST /api/v1/accounts` - Crear una cuenta
- `GET /api/v1/accounts` - Listar todas las cuentas
- `GET /api/v1/accounts/{id}` - Consultar una cuenta por ID

### Transferencias

- `POST /api/v1/transactions/transfer` - Transferir saldo entre dos cuentas
- `GET /api/v1/transactions/{accountId}/transactions` - Obtener historial de transacciones de una cuenta

### Consola H2

- `http://localhost:8080/h2-console`

## Configuración

La aplicación usa H2 en memoria con las siguientes configuraciones por defecto:

```properties
spring.application.name=atlas-bank
spring.datasource.url=jdbc:h2:mem:atlasbank
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=sa
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
server.port=8080
```

## Requisitos

- JDK 21+
- Maven 3.9+ o wrapper incluido (`./mvnw`)

## Ejecutar el proyecto

Desde la raíz del proyecto:

```bash
./mvnw spring-boot:run
```

O con Maven:

```bash
mvn spring-boot:run
```

## Estado actual

El proyecto ya incluye la base funcional de una API bancaria con manejo de cuentas y transferencias, validaciones de negocio y persistencia H2. Está preparado para continuar con nuevas reglas bancarias, más servicios y pruebas automatizadas.
