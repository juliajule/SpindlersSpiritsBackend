# Spindlers Spirits - WhiskyApp Backend

This is the backend component of **Spindlers Spirits**, a minimalist whisky tasting app. 
It is built with **Spring Boot** and provides a RESTful API for managing whisky tastings, whiskys, and images. 
It supports secure admin operations using **JWT authentication** and can be deployed as a service on a Linux server.

---

## Features

- REST API for:
      - Managing whisky tastings and whiskys
      - Uploading and serving tasting images
- JWT-based authentication for admin access
- Version checking between frontend and backend
- Server-side image storage (static URLs)

---

## Technologies

- Java 17
- Spring Boot
- Spring Data JPA
- MariaDB / MySQL
- JWT (JSON Web Tokens)

---

## Authentication

Admin routes (all under `/admin/**`) are protected via JWT.  
A fixed admin user is configured in the `application.properties`:

```properties
auth.admin.username=your_username
auth.admin.password=your_password
jwt.secret=your_very_secret_key
```

To obtain a token, send a POST request to:
```
POST /auth/login
Content-Type: application/json
```
```json
{
"username": "your_username",
"password": "your_password"
}
```
The response will contain a JWT token. 
Include it in the Authorization header when calling admin endpoints:

`Authorization: Bearer your_token`
---
## API Overview

### Public Endpoints

- `GET /whiskys` – Get all whiskys
- `GET /tastings` – Get all tastings
- `GET /images/{filename}` – Serve uploaded tasting images

### Admin Endpoints (JWT required)

- `POST /admin/whiskys` – Create new whisky
- `PUT /admin/whiskys/{id}` – Update whisky
- `DELETE /admin/whiskys/{id}` – Delete whisky

- `POST /admin/tastings` – Create new tasting
- `PUT /admin/tastings/{id}` – Update tasting
- `DELETE /admin/tastings/{id}` – Delete tasting

- `POST /admin/images/upload` – Upload an image file

---

## Image Uploads

Images are uploaded via:
```
POST /admin/images/upload
Content-Type: multipart/form-data
```

The server stores the file in `/images` and returns a relative URL like:

`/images/your_uploaded_file.jpg`

This URL can be stored in the database and accessed publicly.

---

## Version Compatibility

The backend checks the frontend version via an HTTP header:

`X-App-Version: 1.0.0`

A minimum supported version is configured via:
```properties
app.min-version=1.0.0
```
If the version is outdated, the backend responds with status code 426 Upgrade Required.

---

## Directory Structure on Server

```
/opt/whiskyapp/
├── whiskyapp.jar            # Spring Boot executable JAR
├── images/                  # Uploaded images
└── application.properties   # Configuration file
```
---

## Author

Developed by Julia Puhlmann

---

## License

GNU GENERAL PUBLIC LICENSE
Version 3

---