# Master Data Management API

Project ini adalah layanan **RESTful API** berbasis Spring Boot untuk mengelola data master (seperti Users, Products, atau Categories). Project ini dirancang untuk menjadi bagian dari arsitektur microservices yang terhubung ke API Gateway.

## 🚀 Fitur
* **CRUD Operations**: Create, Read, Update, Delete data master.
* **Validation**: Validasi input menggunakan Spring Boot Starter Validation.
* **Actuator**: Monitoring kesehatan aplikasi.
* **Service Discovery**: Siap diintegrasikan dengan Eureka/Consul.

## 🛠️ Tech Stack
* **Java 17** (atau versi terbaru)
* **Spring Boot 3.x**
* **Spring Data JPA** (Database ORM)
* **MySQL** (Database)
* **Lombok** (Boilerplate code reduction)
* **Maven** (Dependency Manager)

## ⚙️ Konfigurasi Database
Ubah file `src/main/resources/application.properties`:
```properties
spring.application.name=rest-api
server.port=9091

#mysql
spring.datasource.url=jdbc:mysql://localhost:3306/db_spring_boot
spring.datasource.username=root
spring.datasource.password=

#hibernate
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

#logging
logging.level.org.hibernate=DEBUG

#eureka
eureka.client.service-url.defaultZone=http://localhost:9095/eureka

eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true

#ACTUATOR
management.endpoints.web.exposure.include=*