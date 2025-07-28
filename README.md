# 🧑‍💻 FamilyGuyAPI - Spring Boot REST API

This is a **Spring Boot** RESTful API that allows users to interact with data about **Family Guy characters**. It includes features like:

- User registration with basic role-based authentication
- Secure endpoints using Spring Security
- H2 in-memory database for quick setup and testing
- Predefined seed data on application startup
> 🧪 This project is intended for **learning and testing** purposes. It uses Spring Security, in-memory H2 database, and role-based access to practice secure API development.
---

## 🚀 Tech Stack

- **Spring Boot**
- **Spring Security**
- **Spring Data JPA**
- **H2 In-Memory Database**
- **Maven**

---

## 📁 Project Structure

├── /api/characters # Family Guy character CRUD endpoints                                  
├── /auth/register # User registration (public)                                               
├── SecurityConfig # Security rules (roles, auth)                                              
├── H2 Console # Web DB viewer at /h2-console                                                  
├── FamilyGuyCharacter # Entity for characters                                                  
├── AppUser # Entity for authentication                                                      


---

## 🧪 Sample Endpoints

> Test these via Postman, browser, or curl.
> http://localhost:8080/api/characters

### 👤 Authentication

#### ✅ Register a new user
```http
POST /auth/register
Content-Type: application/json

{
  "username": "john",
  "password": "1234",
  "role": "USER"
}
```
## 📚 Family Guy Characters
#### 🔓 Get all characters (public)
```
GET /api/characters
```
#### 🔐 Create a character (requires authentication)
```
POST /api/characters
Authorization: Basic <username:password>
Content-Type: application/json

{
  "name": "Joe Swanson",
  "age": 45,
  "profession": "Police Officer",
  "slangUsed": "Bring it on!",
  "favoriteThing": "Wheelchair"
}
```
#### 🔐 Update a character (auth)
```
PATCH /api/characters/1
Authorization: Basic <username:password>

{
  "profession": "Retired Cop"
}
```
#### 🔐 Delete a character (admin only)
```
DELETE /api/characters/2
Authorization: Basic <adminUsername:adminPassword>
```


---

## 🛡️ Security Rules

> 👤 Authentication is done using **HTTP Basic Auth**.  
> ✍️ You can create users with either a `USER` or `ADMIN` role during registration.

| Endpoint                      | Method | Access          | Description                                 |
|------------------------------|--------|------------------|---------------------------------------------|
| `/auth/register`             | POST   | Public           | Register a new user (provide role too)      |
| `/api/characters`            | GET    | Public           | Fetch all Family Guy characters             |
| `/api/characters/{id}`       | GET    | Public           | Get a character by ID                       |
| `/api/characters`            | POST   | Authenticated    | Add a new character                         |
| `/api/characters/{id}`       | PATCH  | Authenticated    | Update a character by ID                    |
| `/api/characters/{id}`       | DELETE | ADMIN only       | Delete a character by ID                    |
| `/h2-console/**`             | GET    | Public           | Access H2 in-memory DB console              |




## 🗃️ In-Memory Database
This app uses H2 (in-memory) DB, meaning:

- Data resets on app restart
- Accessible at: http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:testdb
- Username: sa
- Password: (blank)

  ## 🛠️ How to Run
  ```
Clone project
  ```
git clone https://github.com/SAROJKARKI0321/FamilyGuyAPI.git

 Run the app

```
 
