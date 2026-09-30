
## Project Description

We built a centralized campus placement platform to simplify and efficiently manage the placement process for students and management.
It brings student profiles, resumes, forms, hiring updates, and placement activities together on a single platform.
Previously, information was scattered across spreadsheets, emails, WhatsApp groups, and different forms, making the process difficult to manage.
We integrated an email notification service to deliver important placement updates to students in real time.
The platform reduces manual effort, improves visibility, and makes the overall placement process more organized and efficient.


##  Technology Stack

### Backend

* **Java 8** – Core programming language
* **OOP** – Object-Oriented Programming principles
* **Spring Core** – Dependency Injection and IoC
* **Spring Web / REST APIs** – Building RESTful APIs
* **Spring Data JPA** – Database interaction and ORM
* **Spring Security** – Authentication and authorization
* **JWT** – Stateless authentication and secure API access
* **JavaMailSender** – Email notification and communication

### Database

* **MySQL** – Storing student, company, job, application, and placement data

### Frontend

* **HTML5** – Web page structure
* **CSS3** – Styling and responsive UI
* **JavaScript** – Client-side functionality and API communication


##  Project Architecture

```text
                    ┌──────────────────────────────┐
                    │          Frontend            │
                    │      HTML • CSS • JavaScript │
                    └──────────────┬───────────────┘
                                   │
                                   │ HTTP / REST API
                                   ▼
                    ┌──────────────────────────────┐
                    │       Spring Backend         │
                    │                              │
                    │  Controllers → Services      │
                    │       → Repositories         │
                    └───────┬──────────┬───────────┘
                            │          │
                 ┌──────────┘          └──────────────┐
                 ▼                                     ▼
      ┌─────────────────────┐              ┌─────────────────────┐
      │   Spring Security   │              │   JavaMailSender    │
      │       + JWT         │              │                     │
      │ Authentication &    │              │ Email Notifications │
      │   Authorization     │              └─────────────────────┘
      └─────────────────────┘
                            │
                            ▼
                 ┌─────────────────────┐
                 │    Spring Data JPA  │
                 │   ORM / Repository  │
                 └──────────┬──────────┘
                            │
                            ▼
                 ┌─────────────────────┐
                 │        MySQL        │
                 │   Persistent Data   │
                 └─────────────────────┘
```

###  Application Flow

**Frontend → REST API → Spring Backend → Business Logic → JPA → MySQL**

The backend uses **Spring Security + JWT** to authenticate users and protect APIs, while **JavaMailSender** handles email notifications such as placement announcements and hiring updates.
