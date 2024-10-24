# Device REST API

This is a REST service that supports the management of a device database, allowing clients to create, read, update, and delete devices. It also supports querying devices by brand.

The project is implemented using Spring Boot v3.3.4 and Java 17, following best practices for building scalable, maintainable REST APIs.

## Technologies Used

- **Java**: 17
- **Spring Boot**: 3.3.4
- **JPA (Hibernate)**: For ORM and database interactions
- **IntelliJ IDEA**: Community Edition
- **H2 Database**: In-memory database for development and testing
- **Maven**: Build and dependency management
- **JUnit/Mockito**: For unit testing
- **Postman**: For API testing

## Prerequisites

- **JDK 17 or later**: [Download and install JDK](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- **Maven 3.8+**: [Download and install Maven](https://maven.apache.org/install.html)

## How to Run Locally

1. **Clone the repository:**
    ```bash
    git clone https://github.com/ahmedse1/restapi.git
    ```

2. **Navigate to the project directory:**
    ```bash
    cd restapi
    ```

3. **Build the project using Maven:**
    ```bash
    mvn clean install
    ```

4. **Run the Spring Boot application:**
    ```bash
    mvn spring-boot:run
    ```

5. **Access the application:**
    - API Base URL: `http://localhost:8080/api/devices`
    - Swagger Documentation: `http://localhost:8080/swagger-ui/index.html`

6. **H2 Database Console:**
    - URL: `http://localhost:8080/h2-console`
    - JDBC URL: `jdbc:h2:mem:devicedb`
    - Username: `sa`
    - Password:

## API Documentation

You can explore the API documentation via Swagger at:

- **Swagger UI**: `http://localhost:8080/swagger-ui/index.html`

## API Endpoints

| Method | Endpoint                                                                 | Description                          |
|--------|--------------------------------------------------------------------------|--------------------------------------|
| POST   | `/api/devices`                                                           | Create a new device                  |
| GET    | `/api/devices/{id}`                                                      | Get device by ID                     |
| GET    | `/api/devices`                                                           | Get all devices                      |
| PUT    | `/api/devices/{id}`                                                      | Update a device (full or partial)    |
| DELETE | `/api/devices/{id}`                                                      | Delete a device                      |
| GET    | `/api/devices/brand?brand={brandName}&page={pageNumber}&size={pageSize}` | Get devices by brand with pagination |

## Running Tests

Run the unit tests with:

```bash
mvn test

