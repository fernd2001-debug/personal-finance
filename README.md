# Personal Finance API

REST API for tracking personal income and expenses. Built with **Java 21**, **Spring Boot 4**, **Spring Data JPA**, and **MySQL**.

This is a backend portfolio project: layered architecture, local setup with Docker, and no secrets in the repository.

## Stack

- Java 21
- Spring Boot 4 (Web + Data JPA)
- MySQL 8
- Maven Wrapper
- Docker Compose for the database
- H2 for tests

## Architecture

```text
controller  →  service  →  repository  →  entity
```

| Layer | Responsibility |
|---|---|
| `controller` | HTTP endpoints |
| `service` | business rules |
| `repository` | persistence |
| `entity` | JPA model |

## Requirements

- JDK 21+
- Docker (for MySQL), or a local MySQL 8 instance
- Maven Wrapper (`mvnw` / `mvnw.cmd`) — no global Maven install required

## Quick start

```bash
git clone https://github.com/fernd2001-debug/personal-finance.git
cd personal-finance
copy .env.example .env   # Windows
# cp .env.example .env   # macOS / Linux
```

Edit `.env` and set `DB_PASSWORD`. Then start MySQL and the API:

```bash
docker compose --env-file .env up -d
mvnw.cmd spring-boot:run
```

The API listens on `http://localhost:8080`.

## Endpoints

### Categories

| Method | Path | Description |
|---|---|---|
| `GET` | `/api/categorias` | List categories |
| `POST` | `/api/categorias` | Create a category |

```json
{
  "nombre": "Supermercado",
  "descripcion": "Compras de alimento",
  "tipo": "GASTO"
}
```

### Transactions

| Method | Path | Description |
|---|---|---|
| `GET` | `/api/transacciones` | List transactions |
| `POST` | `/api/transacciones` | Create a transaction |

Create a transaction with query params:

```http
POST /api/transacciones?categoriaId=1&tipo=GASTO&descripcion=Mercado&monto=85000
```

`tipo` should be `GASTO` or `INGRESO`. Missing categories return HTTP 404.

## Configuration

Database settings come from environment variables, never from committed secrets:

| Variable | Default |
|---|---|
| `DB_URL` | `jdbc:mysql://localhost:3306/personal_finance?...` |
| `DB_USERNAME` | `root` |
| `DB_PASSWORD` | empty |

If you cloned an older copy of this repo, rotate any password that was previously committed.

## Tests

Tests use an in-memory H2 database, so they do not need MySQL:

```bash
mvnw.cmd test
```

## Next steps

- Request body DTOs and Bean Validation
- Auth (JWT or session)
- Pagination and date filters on the public API
- CI workflow on GitHub Actions
