# Bike Point

A full-stack web application built with **Java Spring Boot** for the backend, **MySQL** as the database, and **React** for the frontend.

---

## Table of Contents


- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Using Lombok](#using-lombok)
  - [Backend Setup](#backend-setup)
  - [Frontend Setup](#frontend-setup)
- [License](#license)

---


## Technologies Used

### Backend
- **Java Spring Boot**
- **MySQL**
- **Hibernate/JPA** (for ORM)
- **Maven** (build tool)

### Frontend
- **React**
- **Axios** (for API requests)
- **Tailwind CSS** or **CSS Modules** (for styling)

---

## Getting Started

### Prerequisites

Make sure you have the following installed:

- **Java 11+**
- **Maven**
- **MySQL** (local or remote instance)
- **Node.js** (v14+ recommended)
- **npm** or **yarn**

---

### Using Lombok
Lombok is a Java library that helps reduce boilerplate code by generating getter, setter, constructor, toString, and other methods at compile time. Here's how to set it up:

Step 1: Add Lombok to the pom.xml
Add the Lombok dependency to the dependencies section:
  ```xml
  <dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.28</version>
    <scope>provided</scope>
  </dependency>
 ```

Step 2: Enable Lombok in Your IDE
- **Spring Tool Suite (STS) or Eclipse:**

  1. Install the Lombok plugin from Lombok's website.
  2. Run the downloaded lombok.jar file:
    ```bash
    Copy code
    java -jar lombok.jar
    ```
    
  3. Select the IDE installation directory and install.
  4. Restart the IDE.
  
  

### Backend Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/taradgaonkartejas/Bike-Point.git
   cd myapp/Bike_Point/Bike Point



2. Update the application.properties or application.yml file in src/main/resources:
   ```bash
   spring.datasource.url=jdbc:mysql://localhost:3306/myapp_db?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update

3. Import the project into Spring Tool Suite (STS):

- **Open STS and select File > Import > Maven > Existing Maven Projects.**
- **Browse to the backend directory and import it.**

4. Run the Spring Boot application:

- **In STS, right-click on the main application class (e.g., MyAppApplication.java) located in src/main/java.**
- **Select Run As > Spring Boot App.**

The backend should now be running on http://localhost:8080.

### Frontend Setup
1. Navigate to the frontend directory:
   ```bash
   cd ../FrontEnd/bikepoint

2. Install dependencies:
   ```bash
   npm install
   # or
   yarn install

3. Start the development server:
   ```bash
   npm start
   # or
   yarn start

The frontend should now be running on http://localhost:3000.

### License

This project is licensed under the MIT License.

This version provides clear instructions for setting up and running the backend using **Spring Tool Suite (STS)**. Let me know if you need any further refinements!


