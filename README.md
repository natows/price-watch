# Price Watch

*Still in progress..*

Price Watch is a Spring Boot application designed to track and monitor product prices from various online retailers.

## Technologies Used

- **Backend:**
  - Java 17
  - Spring Boot 3.5.2
  - Spring Security (for authentication and authorization)
  - Spring Data JPA (for database management)
  - Spring Web (for REST APIs)
  - Spring Validation (for data validation)
- **Database:**
  - H2 Database (for development and testing)
- **Web Scraping:**
  - Jsoup (for HTML parsing)
  - Selenium (for dynamic content scraping)
- **Utilities:**
  - Project Lombok (to reduce boilerplate code)
  - Maven (for dependency management)

## Features (Planned & In Progress)

- User authentication and authorization.
- Adding products to watch lists via URLs.
- Automated price scraping using Jsoup and Selenium.
- Price change notifications (planned).

## Getting Started

To run the project locally:

1. Clone the repository.
2. Ensure you have Java 17 and Maven installed.
3. Run `mvn spring-boot:run`.