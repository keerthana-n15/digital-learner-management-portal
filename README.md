# 🎓 Digital Learner Management Portal

A **Spring Boot REST API** designed to manage college and learner-related records through a structured backend application. The project provides REST endpoints for creating, retrieving, and searching college information, with **MySQL** used for persistent data storage.

## ✨ Key Features

* Create and store college records
* Retrieve all available college records
* Search colleges using code, name, email, phone number, or address
* Perform CRUD-based data operations
* Validate incoming request data
* Persist application data using Spring Data JPA
* Follow a layered backend architecture
* Use RESTful APIs for application communication

## 🔧 Technologies Used

| Category             | Technology           |
| -------------------- | -------------------- |
| Programming Language | Java 17              |
| Backend Framework    | Spring Boot          |
| Web Layer            | Spring MVC           |
| Data Access          | Spring Data JPA      |
| ORM                  | Hibernate            |
| Database             | MySQL 8+             |
| Build Tool           | Maven                |
| Utility Library      | Apache Commons Lang3 |
| Code Simplification  | Lombok               |

## 📁 Application Structure

```text
src/
├── main/
│   ├── java/com/project/
│   │   ├── CollegeprojectApplication.java
│   │   └── collegeproject/
│   │       ├── controller/
│   │       │   └── CollegeController.java
│   │       ├── service/
│   │       │   └── CollegeService.java
│   │       ├── repository/
│   │       │   └── CollegeRepository.java
│   │       ├── model/
│   │       │   └── CollegeEntity.java
│   │       ├── dto/
│   │       │   └── AddCollegeRequestDTO.java
│   │       └── enums/
│   │           ├── Status.java
│   │           └── Type.java
│   └── resources/
│       └── application.properties
│
└── test/
    └── java/

pom.xml
mvnw
mvnw.cmd
README.md
```

### Layer Responsibilities

**Controller**
Handles HTTP requests and exposes the REST API endpoints.

**Service**
Contains application logic and performs input validation.

**Repository**
Uses Spring Data JPA to communicate with the database.

**Model**
Defines the college entity mapped to the MySQL table.

**DTO**
Represents the data received when adding a college.

**Enums**
Defines supported college types and status values.

## 🗄️ Database Setup

This project uses **MySQL** for storing college information.

Create the database before starting the application:

```sql
CREATE DATABASE college_db;
```

Update your local MySQL credentials in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/college_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

The application uses Hibernate's schema update configuration, so the required table structure can be created or updated automatically.

## ▶️ Running the Application

### Requirements

Make sure the following are installed:

* Java 17 or later
* MySQL 8+
* Maven (optional because the project includes Maven Wrapper)

### Start with Maven Wrapper

**Windows:**

```bash
mvnw.cmd spring-boot:run
```

**Linux/macOS:**

```bash
./mvnw spring-boot:run
```

You can also run:

```bash
mvn spring-boot:run
```

The application runs on:

```text
http://localhost:8082
```

## 🌐 REST API Endpoints

### Create College

```text
POST /addCollege
```

Example request:

```json
{
  "collegeCode": "ABC123",
  "collegeName": "Example College",
  "collegeEmail": "info@example.com",
  "collegePhoneNumber": "9876543210",
  "collegeAddress": "123 Main Street",
  "collegeType": "PRIVATE",
  "collegeStatus": "ACITVE"
}
```

The API validates important fields such as the college code, name, email, phone number, and address before processing the request.

### Retrieve Colleges

```text
GET /getAllColleges
```

Returns the college records available in the database.

### Search by College Code

```text
GET /getCollegeByCode/{collegeCode}
```

### Search by College Name

```text
GET /getCollegeByName?collegeName=
```

### Search by Email

```text
GET /getCollegeByEmail/{collegeEmail}
```

### Search by Phone Number

```text
GET /getCollegeByPhoneNumber?collegePhoneNumber=
```

### Search by Address

```text
GET /getCollegeByAddress/{collegeAddress}
```

## 📊 College Data Fields

The college entity contains the following information:

| Field                | Data Type     | Purpose                     |
| -------------------- | ------------- | --------------------------- |
| `id`                 | String / UUID | Unique identifier           |
| `collegeCode`        | String        | College identification code |
| `collegeName`        | String        | Name of the college         |
| `collegeEmail`       | String        | College email address       |
| `collegePhoneNumber` | String        | Contact number              |
| `collegeAddress`     | String        | College location/address    |
| `collegeType`        | Enum          | College category            |
| `collegeStatus`      | Enum          | Current college status      |
| `startDate`          | Date          | Record creation date        |

### College Type

```text
PRIVATE
GOVERNMENT
SEMI_GOVERNMENT
```

### College Status

```text
ACITVE
CLOSED
INACTIVE
SUSPENDED
```

## 🧪 Testing

Run the available tests with:

```bash
mvnw.cmd test
```

or:

```bash
./mvnw test
```

## 📦 Create the Application JAR

To build the project:

```bash
./mvnw clean package -DskipTests
```

The generated JAR will be available inside:

```text
target/
```

It can then be started using:

```bash
java -jar target/collegeproject-0.0.1-SNAPSHOT.jar
```

## ⚙️ Application Configuration

The main application settings include:

| Configuration      | Value    |
| ------------------ | -------- |
| Server Port        | `8082`   |
| Hibernate DDL Mode | `update` |
| SQL Logging        | Enabled  |
| Formatted SQL      | Enabled  |
| Database           | MySQL    |

## 🎯 Project Purpose

The project was developed to practice building a backend application using **Java and Spring Boot**, including REST API development, database connectivity, JPA-based persistence, request validation, and separation of responsibilities through a layered architecture.
