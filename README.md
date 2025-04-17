# Real-Time Vehicle Tracking System 🚗📍  

## Overview  
The **Real-Time Vehicle Tracking System** is a pure backend application built using **Java Spring Boot** and MySQL, designed to efficiently track, manage, and store vehicle location data. It allows you to associate vehicles, fetch real-time locations, reverse-geocode coordinates to addresses using Google Maps API, and generate PDF reports of location history. 

## Features  
🚗 **Vehicle Management** — Add and manage vehicles.

📍 **Location Tracking** — Create, fetch, and store real-time locations of vehicles.

🗺️ **Reverse Geocoding** — Convert latitude and longitude into human-readable addresses using the Google Geocoding API.

📄 **PDF Report Generation** — Download vehicle location histories in a professional PDF format.

🛡️ **Exception Handling** — Robust handling of failures when fetching addresses or saving data.

🔥 **Spring Boot Best Practices** — Layered architecture (Controller, Service, Repository), dependency injection, DTO usage.

## Tech Stack  
**Backend**              : Java 17, Spring Boot, Spring Data JPA

**Database**             : MySQL

**PDF Generation**       : iText

**Reverse Geocoding**    : Google Maps Geocoding API

**Build Tool**           : Maven

**Version Control**      : Git, GitHub


## Project Structure

**src/
 
 ├── controller/    --> Exposes REST APIs
 
 ├── service/       --> Business logic
 
 ├── repository/    --> Database access (JPA)
 
 ├── model/         --> Entity classes
 
 └── util/          --> Utility classes for PDF generation, API integration**


 ## Setup Instructions

 **Clone the repository**  :  git clone https://github.com/kalyanram003/Vehicle-Tracking-System.git

**Build the project**      :  mvn clean install

**Run the application**    :  mvn spring-boot:run

**Access the APIs at**     :  http://localhost:8080/api/...


## Important APIs

Endpoint                             ------>   Description

POST /api/vehicles                   ------>   Add a new vehicle

POST /api/locations                  ------>   Create a new location entry (with optional vehicle association)

GET /api/locations/{id}              ------>   Fetch a location by ID

GET /api/vehicles/{id}/locations     ------>   Fetch all locations for a vehicle

GET /api/vehicles/{id}/locations/pdf ------>   Generate and download a PDF report
