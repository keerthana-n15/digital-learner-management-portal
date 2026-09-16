# 🎓 College Project — Spring Boot REST API

A **Spring Boot** REST API for managing college records, built as part of the Advanced Java course by Akash Bhaiya. The application exposes CRUD endpoints to add and query colleges stored in a **MySQL** database.

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 4.1.0 |
| Web | Spring MVC (spring-boot-starter-webmvc) |
| Persistence | Spring Data JPA + Hibernate |
| Database | MySQL 8+ |
| Utilities | Apache Commons Lang3 3.20.0 |
| Boilerplate reduction | Lombok 1.18.46 |
| Build tool | Maven (Maven Wrapper included) |

---

## 📂 Project Structure

```
MySecondProject/
├── src/
│   ├── main/
│   │   ├── java/com/project/
│   │   │   ├── CollegeprojectApplication.java        # Spring Boot entry point
│   │   │   └── collegeproject/
│   │   │       ├── controller/
│   │   │       │   └── CollegeController.java        # REST endpoints
│   │   │       ├── service/
│   │   │       │   └── CollegeService.java           # Business logic & validation
│   │   │       ├── repository/
│   │   │       │   └── CollegeRepository.java        # JPA repository
│   │   │       ├── model/
│   │   │       │   └── CollegeEntity.java            # JPA entity (college_table)
│   │   │       ├── dto/
│   │   │       │   └── AddCollegeRequestDTO.java     # Request DTO
│   │   │       └── enums/
│   │   │           ├── Status.java                   # ACITVE | CLOSED | INACTIVE | SUSPENDED
│   │   │           └── Type.java                     # PRIVATE | GOVERNMENT | SEMI_GOVERNMENT
│   │   └── resources/
│   │       └── application.properties                # App configuration
│   └── test/
│       └── java/                                     # Unit & integration tests
├── pom.xml
├── mvnw / mvnw.cmd                                   # Maven wrapper scripts
└── README.md
```

---

## ⚙️ Prerequisites

- **Java 17** or higher installed and `JAVA_HOME` configured
- **MySQL 8+** running locally
- A MySQL database named `college_db` already created

```sql
CREATE DATABASE college_db;
```

---

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/Shivansh1146/MySecondProject.git
cd MySecondProject
```

### 2. Configure the database

Open `src/main/resources/application.properties` and update with your MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/college_db
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

> The schema is auto-created/updated via `spring.jpa.hibernate.ddl-auto=update`.  
> No manual SQL migration is required.

### 3. Run the application

**Using Maven Wrapper (recommended):**
```bash
./mvnw spring-boot:run        # Linux / macOS
mvnw.cmd spring-boot:run      # Windows
```

**Or with Maven directly:**
```bash
mvn spring-boot:run
```

The server starts on **port `8082`** by default.

---

## 📡 API Reference

Base URL: `http://localhost:8082`

### ➕ Add a College

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/addCollege` | Add a new college record |

**Request Body (JSON):**

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

**Validation Rules:**
- `collegeCode` — alphanumeric only (`^[a-zA-Z0-9]+$`)
- `collegeName` — letters and spaces only (`^[a-zA-Z ]+$`)
- `collegeEmail` — basic email format (`username@domain.tld`)
- `collegePhoneNumber` — 10-digit Indian mobile number starting with 6–9
- `collegeAddress` — alphanumeric and spaces only

**Response:**
- `201 Created` → `"Congrats !! Your College is saved"`
- `201` with validation error message if any field is invalid

---

### 📋 Get All Colleges

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/getAllColleges` | Returns a list of all college records |

**Response:** `200 OK` with a JSON array of college objects.

---

### 🔍 Query Colleges

| Method | Endpoint | Param Type | Description |
|--------|----------|-----------|-------------|
| `GET` | `/getCollegeByCode/{collegeCode}` | Path Variable | Find college by its code |
| `GET` | `/getCollegeByName?collegeName=` | Query Param | Find college by name |
| `GET` | `/getCollegeByEmail/{collegeEmail}` | Path Variable | Find college by email |
| `GET` | `/getCollegeByPhoneNumber?collegePhoneNumber=` | Query Param | Find college by phone |
| `GET` | `/getCollegeByAddress/{collegeAddress}` | Path Variable | Find college by address |

**Response:** `200 OK` with a single college JSON object, or `null` if not found / blank input.

---

## 🗃️ Data Model

### `CollegeEntity` (maps to `college_table`)

| Field | Type | Description |
|---|---|---|
| `id` | `String` (UUID) | Auto-generated primary key |
| `collegeCode` | `String` | Unique short code for the college |
| `collegeName` | `String` | Full name of the college |
| `collegeEmail` | `String` | Official email address |
| `collegePhoneNumber` | `String` | Contact phone number |
| `collegeAddress` | `String` | Physical address |
| `collegeType` | `Type` (enum) | `PRIVATE` / `GOVERNMENT` / `SEMI_GOVERNMENT` |
| `collegeStatus` | `Status` (enum) | `ACITVE` / `CLOSED` / `INACTIVE` / `SUSPENDED` |
| `startDate` | `Date` | Auto-set to current date on creation |

---

## 🧪 Running Tests

```bash
./mvnw test        # Linux / macOS
mvnw.cmd test      # Windows
```

---

## 🏗️ Building for Production

```bash
./mvnw clean package -DskipTests
```

The JAR will be generated at:

```
target/collegeproject-0.0.1-SNAPSHOT.jar
```

Run it with:

```bash
java -jar target/collegeproject-0.0.1-SNAPSHOT.jar
```

---

## 📝 Configuration Reference

| Property | Default | Description |
|---|---|---|
| `server.port` | `8082` | HTTP port the server listens on |
| `spring.jpa.hibernate.ddl-auto` | `update` | Schema auto-management strategy |
| `spring.jpa.show-sql` | `true` | Prints SQL queries to console |
| `spring.jpa.properties.hibernate.format_sql` | `true` | Pretty-prints SQL output |
| `spring.jpa.database-platform` | `MySQLDialect` | Hibernate dialect for MySQL |

---

## 👨‍💻 Author

**Shivansh** — Advanced Java project developed under the guidance of **Akash Bhaiya**.

---

## 📄 License

This project is for **educational purposes** only.
