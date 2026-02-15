# 📇 Smart Contact Directory (CLI)

A lightweight **Command Line Interface (CLI)** application built with **Java** and **MySQL** to manage personal and professional contacts. This project demonstrates core backend engineering principles including **CRUD operations**, **Database Persistence via JDBC**, and **Object-Oriented Programming (OOP)**.

## 🚀 Features

* **Persistent Storage:** Contacts are saved in a MySQL database.
* **CRUD Functionality:**
* **Create:** Add new contacts with name, phone, and type (Work/Personal).
* **Read:** Display all contacts in a formatted tabular view.
* **Delete:** Remove specific contacts using their unique ID.


* **SQL Injection Protection:** Utilizes `PreparedStatements` for secure database interactions.
* **Clean Architecture:** Separated concerns between Application Logic (`Main`) and Database Logic (`DatabaseManager`).

---

## 🛠 Tech Stack

* **Language:** Java 17+
* **Build Tool:** Maven
* **Database:** MySQL 8.0+
* **Driver:** MySQL Connector/J

---

## 📂 Project Structure

```text
.
├── pom.xml                 # Maven dependencies (MySQL Connector)
├── src
│   ├── main
│   │   ├── java
│   │   │   └── org
│   │   │       └── example
│   │   │           ├── Main.java            # CLI Menu & User Input
│   │   │           └── DatabaseManager.java # JDBC Implementation
│   │   └── resources
│   │       └── init.sql                     # Database Schema
└── README.md

```

---

## ⚙️ Setup & Installation

### 1. Database Configuration

Run the following SQL script in your MySQL terminal to set up the environment:

```sql
CREATE DATABASE contact_db;
USE contact_db;

CREATE TABLE contacts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    type VARCHAR(20)
);

```

### 2. Update Credentials

Open `src/main/java/org/example/DatabaseManager.java` and update your MySQL credentials:

```java
private static final String USER = "your_username";
private static final String PASS = "your_password";

```

### 3. Build & Run (via Terminal)

Navigate to the project root and execute:

```bash
# Clean and compile the project
mvn clean compile

# Run the application
mvn exec:java -Dexec.mainClass="org.example.Main"

```

---

## 🖥️ Demo Preview

```text
--- SMART CONTACT DIRECTORY ---
1. Add Contact
2. View All Contacts
3. Delete Contact
4. Exit

Enter choice: 2

ID    | Name            | Phone           | Type      
---------------------------------------------------------
1     | John Doe        | +2348012345678  | Work      
2     | Jane Smith      | +2349087654321  | Personal  

```
