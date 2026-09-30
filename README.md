## 🛠️ Technology Stack

### Backend Technologies

| Technology                            | Description                                                                                                                                                                    |
| ------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **Java 8**                            | Core programming language used to develop the backend application and implement business logic.                                                                                |
| **Object-Oriented Programming (OOP)** | Used to design the application using classes, objects, inheritance, encapsulation, abstraction, and polymorphism.                                                              |
| **Spring Core**                       | Used for Dependency Injection (DI) and Inversion of Control (IoC) to manage application components and their dependencies.                                                     |
| **Spring Web / REST API**             | Used to build RESTful APIs that allow the frontend to communicate with the backend for operations such as managing students, companies, jobs, applications, and announcements. |
| **Spring Data JPA**                   | Used for database interaction and ORM, allowing Java objects to be mapped to MySQL database tables and reducing the need for manual SQL queries.                               |
| **Spring Security**                   | Used to secure the application by implementing authentication and authorization and controlling access to protected resources.                                                 |
| **JWT (JSON Web Token)**              | Used for stateless authentication. After successful login, a JWT is generated and used to authenticate subsequent API requests.                                                |
| **JavaMailSender**                    | Used to integrate email functionality and send placement announcements, hiring updates, and other important notifications to students.                                         |

### Database

| Technology | Description                                                                                                                                                   |
| ---------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **MySQL**  | Relational database used to store and manage student profiles, companies, jobs, applications, announcements, user accounts, and other placement-related data. |

### Frontend Technologies

| Technology     | Description                                                                                                                                         |
| -------------- | --------------------------------------------------------------------------------------------------------------------------------------------------- |
| **HTML5**      | Used to create the structure and layout of the placement management portal.                                                                         |
| **CSS3**       | Used to style the application and create a clean and user-friendly interface.                                                                       |
| **JavaScript** | Used to implement client-side functionality, handle user interactions, communicate with backend REST APIs, and dynamically update application data. |

### Architecture & Communication

The application follows a **client-server architecture**, where the frontend communicates with the Spring Boot backend through REST APIs. The backend handles business logic, authentication, database operations, and email notifications, while MySQL is used for persistent data storage.

```text
Frontend
HTML + CSS + JavaScript
          ↓
       REST APIs
          ↓
Spring Backend
          ↓
 ┌────────┼─────────┐
 ↓        ↓         ↓
JPA    Security   Mail
 ↓        ↓         ↓
MySQL     JWT    Email Service
```
