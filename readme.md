
# Order service

## Overview

This project is a simple order service that allows users to create orders and products. The application is built using 
Spring Boot and uses an H2 in-memory database for testing and a PostgreSQL database for production.
I have also experimented with a non-relational database, MongoDB, to store the orders. I have left this implementation in a ss separate branch.
## Database Configuration

### H2 Database (Test Server)

H2 is an in-memory database used for testing purposes. It is configured in the `application.yml` file under the `test` profile.

```yaml
spring:
  profiles: test
  datasource:
    url: jdbc:h2:mem:testdb
    driver-class-name: org.h2.Driver
    username: sa
    password: password
  h2:
    console:
      enabled: true
      path: /h2-console
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: update
```

### PostgreSQL (Production Server)

PostgreSQL is used as the production database. It is configured in the `application.yml` file under the `prod` profile.

```yaml
spring:
  profiles: prod
  datasource:
    url: jdbc:postgresql://localhost:5432/your_database_name
    driver-class-name: org.postgresql.Driver
    username: your_username
    password: your_password
  jpa:
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    hibernate:
      ddl-auto: update
```

## Swagger Documentation

Swagger is used to generate API documentation for the application. The Swagger configuration is defined in the `SwaggerConfiguration` class.

### Accessing Swagger UI

You can access the Swagger UI at the following URL:

```
http://localhost:8080/swagger-ui.html
```

### Security

The Swagger configuration includes security schemes for JWT authentication.

## Controllers

The application includes several controllers to handle different endpoints. Here are some of the main controllers:

### OrderController

Handles endpoints related to orders.

### ProductController

Handles endpoints related to products.

## Running the Application

To run the application with the H2 database (test server), use the following command:

```sh
mvn spring-boot:run -Dspring-boot.run.profiles=test
```

To run the application with the PostgreSQL database (production server), use the following command:

```sh
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```

## License

This project is licensed under the Apache 2.0 License. See the LICENSE file for details.