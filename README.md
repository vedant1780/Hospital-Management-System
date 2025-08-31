# 🏥 Hospital Management System (JDBC + SQL)

## 📌 Overview
This project is a Java-based Hospital Management System that uses JDBC to interact with a relational SQL database. It provides core hospital functionalities like patient registration, doctor scheduling, appointment tracking, and billing—all through modular Java classes and secure SQL queries.

## 🧱 Features
- 👨‍⚕️ **Doctor Management**: Add, update, and retrieve doctor profiles and availability.
- 🧑‍🦽 **Patient Records**: Store and manage patient details and medical history.
- 📅 **Appointments**: Book, update, and cancel appointments with conflict resolution.


## 🛠️ Technologies Used
- **Java (JDK 8+)**
- **JDBC API**
- **MySQL / PostgreSQL / SQLite**

## 🗃️ Database Schema

| Table Name       | Description                                 |
|------------------|---------------------------------------------|
| `Doctors`        | Stores doctor details and specialization    |
| `Patients`       | Stores patient personal and medical data    |
| `Appointments`   | Links patients with doctors and time slots  |


## 🚀 Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/hospital-management-jdbc.git
cd Hospital-Management-System
```
### 2. Setup Database
- Import hospital_schema.sql into your SQL database.
- Update DBConfig.java with your database credentials.
### 3. Compile and Run
```bash
javac -cp .:mysql-connector-java.jar Main.java
java -cp .:mysql-connector-java.jar Main
```
### 4. Sample JDBC Connection
```java
Connection conn = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/hospital_db", "username", "password");

PreparedStatement stmt = conn.prepareStatement(
    "SELECT * FROM Doctors WHERE department = ?");
stmt.setString(1, "Cardiology");

ResultSet rs = stmt.executeQuery();
while (rs.next()) {
    System.out.println("Dr. " + rs.getString("name"));
}
```
### 📂 Folder Structure
```
├── src/
│   ├── Main.java
│   ├── DBConfig.java
│   ├── models/
│   │   ├── Doctors.java
│   │   ├── Patient.java
│   │   └── Appointment.java
├── hospital_schema.sql
├── README.md
└── lib/
    └── mysql-connector-java.jar
```


