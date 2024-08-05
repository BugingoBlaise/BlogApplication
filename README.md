# BlogApplication
Blog App built using Angular and Springboot


# Blog Application

This blog application allows users to create, view, search, and like blog posts. It is built using Spring Boot for the backend and Angular for the frontend.

## Table of Contents

1. [Backend (Spring Boot)](#backend-spring-boot)
    - [Setup](#setup)
    - [Endpoints](#endpoints)
2. [Frontend (Angular)](#frontend-angular)
    - [Setup](#setup-1)
    - [Components](#components)
3. [Running the Application](#running-the-application)

## Backend (Spring Boot)

### Setup

1. **Clone the repository**:
    ```bash
    git clone https://github.com/BugingoBlaise/BlogApplication.git
    cd <repository_directory>
    ```

2. **Dependencies**: Ensure the following dependencies are included in your `pom.xml`:
    ```xml
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.postgres</groupId>
            <artifactId>postgres</artifactId>
        </dependency>
    </dependencies>
    ```

3. **Application Properties**: Configure the database in `src/main/resources/application.properties`:
    ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/blog_db
   spring.datasource.username=postgres
   spring.datasource.password=xxx
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    ```

4. **Run the application**:
    ```bash
    mvn spring-boot:run
    ```

### Endpoints

- **Create Post**: `POST /api/posts`
- **Get All Posts**: `GET /api/posts`
- **Get Post by ID**: `GET /api/posts/{postId}`
- **Like Post**: `PUT /api/posts/{postId}/like`
- **Search Post by Name**: `GET /api/posts/search/{name}`

## Frontend (Angular)

### Setup

1. **Clone the repository**:
    ```bash
    git clone <repository_url>
    cd <repository_directory>/frontend
    ```

2. **Install dependencies**:
    ```bash
    npm install
    ```

3. **Run the application**:
    ```bash
    ng serve
    ```

### Components

- **Create Post**: `create-post.component.ts`
- **View Posts**: `post-list.component.ts`
- **Search Posts**: `search-by-name.component.ts`

## Running the Application

1. **Start the backend**:
    ```bash
    cd <repository_directory>
    mvn spring-boot:run
    ```

2. **Start the frontend**:
    ```bash
    cd <repository_directory>/frontend
    ng serve
    ```

3. **Access the application**:
   Open a browser and navigate to `http://localhost:4200`.

---

This documentation provides a brief overview and setup instructions for both the backend and frontend of the blog application. 
