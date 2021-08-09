# Todo web application

Spring boot application.

## Installation

1. Clone this repository: `git clone https://github.com/vidomark/todo-spring.git`
2. Install postgresql
3. Create database named `todo`

## Usage

- Change into the directory of the project
- Run `mvn spring-boot:run` to start the application
- Go to `localhost:8080` to use the appication
- To close the app simply press `ctrl + c` in the terminal.

## About

On the main page, you can list your todos. The todos are listed, can be updated and deleted as well. The application is a practice project to understand Spring Data JPA and basic Spring Security.

## Structure

The application is based upon a layered architecture which implements the MVC design pattern. The endpoints are predefined in the main controller,
which then communicates the requests to the service layer. The DAO implementation handles the business logic, then the response is sent back. The data is visaulized in Thymeleaf.
