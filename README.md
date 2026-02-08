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
* **PostgreSQL/MySQL** (Database)
* **Lombok** (Boilerplate code reduction)
* **Maven** (Dependency Manager)

## 📋 Prasyarat
Sebelum menjalankan project, pastikan Anda sudah menginstal:
* JDK 17 atau lebih baru
* Maven 3.6+
* Database (PostgreSQL/MySQL)

## ⚙️ Konfigurasi Database
Ubah file `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/db_master
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update