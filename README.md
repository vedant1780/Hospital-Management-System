# 🏥 Hospital Management System (SQL-Based)

## 📌 Overview
This project is a relational database-driven Hospital Management System designed to streamline operations such as patient registration, doctor scheduling, appointment tracking, billing, and medical records. Built entirely using SQL, it emphasizes data integrity, modular schema design, and efficient query handling.

## 🧱 Features
- 👨‍⚕️ **Doctor Management**: Add, update, and view doctor profiles, specialties, and availability.
- 🧑‍🦽 **Patient Records**: Maintain detailed patient information including demographics, medical history, and visit logs.
- 📅 **Appointments**: Schedule, update, and cancel appointments with conflict checks.

## 🗃️ Database Schema

| Table Name       | Description                                 |
|------------------|---------------------------------------------|
| `Doctors`        | Stores doctor details and specialization    |
| `Patients`       | Stores patient personal and medical data    |
| `Appointments`   | Links patients with doctors and time slots  |

## 🛠️ Technologies Used
- **SQL (MySQL / PostgreSQL / SQLite)** – Core database logic
- **ER Diagrams** – For schema visualization
- *(Optional)* Integration-ready with Python, Java, or Flutter for frontend/backend

## 🚀 Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/vedant1780/hospital-management-sql.git
cd Hospital-Management-System
```
### 2. Import the SQL Schema
Use your preferred SQL client to import the hospital_schema.sql file.
#### 3. Run Sample Queries
Try out the queries in sample_queries.sql to test the system.
#### 4. Customize
Modify the schema or queries to suit your hospital’s specific needs
## Folder Structure
```
├── hospital_schema.sql
├── sample_queries.sql
├── ER_diagram.png
├── README.md
└── docs/
    └── schema_explanation.md
````
