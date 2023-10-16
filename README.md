# Spring Boot Store Application

This is a simple Spring Boot application for managing products in a store.

## Table of Contents

- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
  - [Endpoints](#endpoints)
- [Development](#development)
  - [Running Locally](#running-locally)
  - [Testing](#testing)
- [Docker](#docker)
- [CI/CD](#cicd)
- [Swagger Documentation](#swagger-documentation)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- Docker (optional)

### Installation

1. Clone the repository:

```bash
git clone https://github.com/achrafelbihi/spring-boot-store.git
```

2. Navigate to the project directory:

```bash
cd spring-boot-store
```

3. Build the project:

```bash
mvn clean package
```

## Usage

### Endpoints

The application provides the following endpoints:

- `GET /api/v1/products`: Get all products.
- `GET /api/v1/products/{sku}`: Get product by SKU.
- `POST /api/v1/products/add`: Add a new product.
- `PATCH /api/v1/products/update/{sku}`: Partially update a product (name, description, price).

Refer to the Swagger documentation for more details.

## Development

### Running Locally

To run the application locally, use the following command:

```bash
mvn spring-boot:run
```

The application will start at `http://localhost:8080`.

### Testing

To run the unit tests, use the following command:

```bash
mvn test
```

## Docker

To build a Docker image of the application, use the following command:

```bash
docker build -t imedia-store:1.0 .
```

To run the Docker container, use:

```bash
docker run -p 8080:8080 imedia-store:1.0
```

## CI/CD

The project is set up with GitLab CI/CD. The pipeline includes building and running tests. Refer to the `.gitlab-ci.yml` file for configuration.

## Swagger Documentation

The API is documented using Swagger. You can access the documentation at `http://localhost:8080/swagger-ui.html`.

## Contributing

Feel free to open issues or pull requests for any improvements or bug fixes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.