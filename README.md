# 🏆 CompeteLK

**A Centralized Competition Discovery and Team Collaboration Platform**

CompeteLK is a web-based platform designed to help students discover educational and technology-related competitions, connect with potential teammates, and explore opportunities for learning, innovation, and collaboration.

The platform brings competition information into one centralized location, making it easier for students to find relevant opportunities without searching through multiple websites and social media platforms.

CompeteLK also provides verified competition organizers with a dedicated space to publish and manage competition information.

## 🎯 Purpose

Competition announcements are often scattered across university websites, social media pages, and individual event platforms. As a result, students may miss valuable opportunities, struggle to find teammates, or have difficulty tracking important deadlines.

CompeteLK aims to address these challenges by providing a centralized platform for competition discovery, team formation, and competition-related information.

**Our goal is to make competitions more accessible, organized, and discoverable for students.**

## ✨ Key Features

### 🔎 Competition Discovery

- Discover educational, university, and technology-related competitions in one place.
- Search and filter competitions based on relevant criteria.
- View competition details, eligibility information, and important deadlines.
- Access official organizer registration links.
- Save interesting competitions for future reference.
- Receive reminders about upcoming competition deadlines.

### 👥 Team Formation and Collaboration

- Create teams for competitions.
- Discover teams looking for additional members.
- Send requests to join existing teams.
- Invite other registered students to join teams.
- Allow team captains to manage members, invitations, and join requests.
- Support external team members who are not registered on CompeteLK, where appropriate.

### 🏢 Organizer Management

- Register separate organizer accounts.
- Submit organizer profiles for administrator verification.
- Allow verified organizers to publish and manage competitions.
- Provide organizer dashboards for managing published competition information.
- Support collaboration between verified organizers on competition listings.

### 📅 Competition Series and Editions

- Organize recurring competitions under a common competition series.
- Maintain separate editions for different years or occurrences.
- Store edition-specific descriptions, deadlines, and registration links.
- Preserve historical competition information across editions.

For example, **HackX** can be represented as a competition series, while **HackX 2026** and **HackX 2027** are separate editions.

### 🤖 Personalized Recommendations

- Recommend competitions based on students' interests and relevant profile information.
- Help students discover opportunities aligned with their interests and skills.

### 🏅 Competition History and Results

- Explore previous competition editions.
- View historical winners, teams, and projects when information is available.
- Discover technologies and project ideas associated with past competitions.
- Preserve competition-related knowledge for future participants.

### 🔐 Authentication and Authorization

- Secure student and organizer registration.
- JWT-based authentication.
- Role-based access control for students, organizers, and administrators.
- Secure password storage using hashing.
- Organizer verification before publishing.
- Restricted administrative and organizer operations.

## 👤 User Roles

| Role | Responsibilities |
|---|---|
| Student | Discover competitions, manage a profile, save competitions, form teams, and collaborate with other students |
| Organizer | Maintain an organization profile and, after verification, publish and manage competitions |
| Admin | Review organizer verification requests and manage platform-level administrative operations |

Student and organizer accounts are maintained separately to support their different responsibilities.

## 🛠️ Technology Stack

| Technology | Purpose |
|---|---|
| React | Frontend user interface |
| Java 21 | Backend programming language |
| Spring Boot | Backend application framework |
| Spring Web MVC | REST API development |
| Spring Security | Authentication and authorization |
| JWT | Token-based authentication |
| Spring Data JPA | Database access and persistence |
| Hibernate | Object-relational mapping |
| MySQL | Relational database |
| Jakarta Bean Validation | Request data validation |
| Lombok | Reduction of repetitive Java code |
| Maven | Dependency management and build automation |
| Git and GitHub | Version control and collaboration |

The technology stack will evolve as additional features are implemented.

## 🏗️ System Architecture

CompeteLK follows a layered backend architecture:

```text
React Frontend
      |
      | HTTP / REST API
      v
Spring Boot Backend
      |
      +-- Controllers
      |
      +-- Services
      |
      +-- Repositories
      |
      +-- JPA Entities
      |
      v
    MySQL
```

**Backend layers**

- **Controller:** Handles incoming HTTP requests and returns API responses.
- **Service:** Implements application business logic.
- **Repository:** Provides database access using Spring Data JPA.
- **Entity:** Represents persistent database objects.
- **DTO:** Defines data exchanged through the API.

The backend uses validation, centralized exception handling, and transaction management to support maintainable application development.

## 📂 Backend Project Structure

```text
src/main/java/lk/competelk/competelk_backend/
|
+-- config/
+-- controller/
+-- dto/
+-- entity/
+-- exception/
+-- repository/
+-- service/
|
+-- CompetelkBackendApplication.java
```

Additional packages will be introduced as authentication, authorization, and other modules are developed.

## 🔗 Competition Registration

CompeteLK is a competition discovery and collaboration platform.

**Official competition registration takes place through the organizer's external registration website.**

CompeteLK provides competition information and links to the official registration page rather than replacing the organizer's registration system.

## 🚧 Development Status

**Status: In Active Development**

### Implemented

- [x] Spring Boot backend initialization
- [x] MySQL database integration
- [x] REST API architecture
- [x] Competition series creation
- [x] Competition edition creation
- [x] Competition edition retrieval
- [x] Paginated competition edition listing
- [x] Competition editions grouped by series
- [x] Request validation
- [x] Centralized exception handling

### Planned / In Progress

- [ ] Student and organizer account registration
- [ ] JWT authentication and role-based authorization
- [ ] Administrator verification of organizers
- [ ] Competition search and filtering
- [ ] Organizer competition management
- [ ] Student profiles
- [ ] Team creation and management
- [ ] Team invitations and join requests
- [ ] Saved competitions
- [ ] Deadline reminders and notifications
- [ ] Personalized competition recommendations
- [ ] Historical competition results
- [ ] Frontend integration
- [ ] Automated API and security tests
- [ ] Deployment

## ⚙️ Backend Setup

### Prerequisites

- Java 21
- MySQL 8
- Git

### Run Locally

**1. Clone the repository**

```bash
git clone <repository-url>
cd competelk-backend
```

**2. Create the MySQL database**

```sql
CREATE DATABASE competelk;
```

**3. Configure environment variables**

Set the database credentials using environment variables:

```text
DB_URL
DB_USERNAME
DB_PASSWORD
```

`DB_URL` defaults to `jdbc:mysql://localhost:3306/competelk` and `DB_USERNAME` defaults to `root` for local development.

**4. Run the application**

On Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

**5. Run the tests and build**

```powershell
.\mvnw.cmd clean verify
```

The application uses port `8080` by default.

> Development configuration currently uses Hibernate schema updates. Production deployment will require database migrations and completed security configuration.

## 🔮 Future Development

CompeteLK will continue evolving with improved competition discovery, intelligent recommendations, richer team collaboration, and historical competition insights.

The long-term objective is to create a reliable platform connecting students, teams, and competition organizers through a centralized competition ecosystem.

---

**CompeteLK — Discover Opportunities. Build Teams. Compete Together.**