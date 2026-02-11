# 🚀 Space Mission Management System

> **A Full-stack Java Web Application for managing interstellar missions and astronaut crews.**

![Java](https://img.shields.io/badge/Java-17-orange) ![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green) ![MySQL](https://img.shields.io/badge/Database-MySQL-blue) ![Bootstrap](https://img.shields.io/badge/UI-Bootstrap_5-purple)

## 📖 Project Background & Inspiration

This project originates from a university assignment for the unit **COMP1007 - Programming Design and Implementation (PDI)** at **Curtin University**.

The original assignment required building a **Space Exploration Mission Management System** with strict academic constraints to test fundamental understanding of data structures:
*   **Platform:** Command Line Interface (CLI/Console).
*   **Constraints:** No `ArrayList`, `HashMap`, or `StringBuilder`. Manual array manipulation and file I/O were mandatory.
*   **Goal:** To manage missions and astronauts.

## 💡 The Evolution: From Console to Cloud
While the original assignment built a strong foundation in algorithmic thinking, I decided to take this project to the next level. I reimagined the system as a **Modern Enterprise Web Application** to demonstrate skills in Full-stack development and Software Architecture.

| Feature | Original Assignment (PDI) | Current Web Project |
| :--- | :--- | :--- |
| **Interface** | Console / Command Line | Web Interface (HTML5/Thymeleaf) |
| **Architecture** | Procedural | MVC (Model-View-Controller) |
| **Data Storage** | Text/CSV Files | MySQL Database |
| **Data Structures** | Fixed-size Arrays | Dynamic Collections (`List`, `JPA Repository`) |

## ✨ Key Features

1.  **Mission Management (CRUD):**
    *   View a dashboard of all space missions.
    *   Create, Edit, and Delete missions with validation.
    *   Automatic status tracking (Manned vs. Unmanned).
2.  **Crew & Astronaut Management:**
    *   One-to-Many Relationship: Assign multiple astronauts to a single mission.
    *   Manage astronaut details (Role, Nationality, Age).
    *   Data persistence ensuring crew members are linked correctly to their missions in the database.
3.  **Modern UI/UX:**
    *   Clean, responsive interface using **Bootstrap 5**.
    *   User-friendly forms and navigation.

## 🛠️ Tech Stack

*   **Backend:** Java 17, Spring Boot (Spring Web, Spring Data JPA).
*   **Frontend:** Thymeleaf (Server-side rendering), Bootstrap 5, HTML/CSS.
*   **Database:** MySQL.
*   **Tools:** Maven, Git/GitHub, Visual Studio Code.

## 📸 Screenshots

<img width="1326" height="550" alt="image" src="https://github.com/user-attachments/assets/f4f912be-6ee5-4892-9702-f0ead90a89c2" />

<img width="655" height="572" alt="image" src="https://github.com/user-attachments/assets/6d374856-5554-4e63-b05b-3cf3896d35a9" /> 

<img width="650" height="438" alt="image" src="https://github.com/user-attachments/assets/663d5c7b-6520-43bd-9aeb-5875d0cfb7d4" />

## ⚙️ Installation & Setup

Since this project uses a real MySQL database, please follow these steps to run it locally.

### 1. Prerequisites
*   Java Development Kit (JDK) 17 or higher.
*   MySQL Server installed and running.

### 2. Database Configuration
Before running the app, you need to set up the database.

**Step A: Create the Database**
Run this SQL command in your MySQL Workbench or Terminal:
```sql
CREATE DATABASE space_mission_db;
```

**Step B: Update Credentials**
Open the file **src/main/resources/application.properties** and update the username/password to match your local MySQL setup:
```sql
# Update these lines with YOUR MySQL credentials
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD_HERE
```

### 3. Run the Application
Open your terminal in the project root folder and run: **./mvnw spring-boot:run**

### 4. Access the App
Open your browser and navigate to:
👉 http://localhost:8080
