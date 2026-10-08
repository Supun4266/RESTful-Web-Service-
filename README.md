# Spring Boot Customer CRUD

A customer management web application built with **Spring Boot 3** and **Java 17**. Users can add, view, edit and delete customers, with server-side validation on every form.

## Features

- Create, list, view, edit and delete customers
- Server-side validation with Jakarta Bean Validation (required fields, minimum length, email format)
- Flash messages after create and delete actions
- Layered architecture: **Controller → Service → Repository**
- MySQL persistence with Spring Data JPA (schema created automatically)

## Tech stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 3.4 (Web, Data JPA, Validation) |
| Views | Thymeleaf |
| Database | MySQL 8 |
| Build | Maven (wrapper included) |

## Project structure

```
SpringBootCrud/src/main/java/com/learn/SpringBootCrud
├── controller/HomeController.java     # routes and form handling
├── service/CustomerService.java       # business logic
├── repository/CustomerRepository.java # Spring Data JPA repository
└── model/Customer.java                # JPA entity with validation rules
```

## Run locally

1. Create a MySQL database:
   ```sql
   CREATE DATABASE spring_crud;
   ```
2. Set your database credentials as environment variables (they are not stored in the code):
   ```bash
   export DB_USERNAME=root
   export DB_PASSWORD=your_password
   # optional: export DB_URL=jdbc:mysql://localhost:3306/spring_crud
   ```
   On Windows PowerShell use `$env:DB_PASSWORD="your_password"`.
3. Start the app:
   ```bash
   cd SpringBootCrud
   ./mvnw spring-boot:run
   ```
4. Open http://localhost:8080

## Endpoints

| Method | Path | Description |
|---|---|---|
| GET | `/` | List all customers |
| GET | `/create` | New customer form |
| POST | `/save` | Save a customer (validated) |
| GET | `/customer/{id}` | View one customer |
| GET | `/customer/{id}/edit` | Edit form |
| GET | `/customer/{id}/delete` | Delete a customer |

## What I'd add next

- A JSON REST API (`@RestController`) alongside the web pages
- Unit tests for the service layer with JUnit and Mockito
- Docker Compose for the app and MySQL
