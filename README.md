# Auth API — JWT Authentication (English)
 
A backend REST API for user authentication and authorization built with Java and Spring Boot, using JWT tokens and role-based access control.
 
## Technologies
 
- Java 21
- Spring Boot 4.0.5
- Spring Security 7.0.4
- PostgreSQL 18
- Maven
- JWT (jjwt)
- Lombok
- Docker
- Docker Compose
## Features
 
- User registration with BCrypt password encryption
- Login with JWT token generation
- Role-based authorization (USER and ADMIN)
- Protected and public endpoints
- Standardized API responses
- Global exception handling
- Bean Validation on request fields
- API documentation with Swagger/OpenAPI
## Project Structure
 
```
authapi/
├── src/
│   └── main/
│       └── java/
│           └── br/com/marcossouza/authapi/
│               ├── config/        → Spring Security configuration
│               ├── controller/    → receives HTTP requests
│               ├── dto/           → request and response objects
│               ├── exception/     → global exception handling
│               ├── model/         → User entity and Role enum
│               ├── repository/    → database communication
│               ├── security/      → JWT filter and JWT utilities
│               └── service/       → business logic
├── Dockerfile
├── docker-compose.yaml
├── pom.xml
└── AuthapiApplication.java
```
 
## How to Run
 
### Option 1 — Docker (Recommended)
 
**Prerequisites:** Docker and Docker Compose
 
1. Clone the repository
2. Create a `.env` file in the root folder
3. Run:
```bash
docker compose up --build
```
 
4. The API will be available at `http://localhost:8080`
5. API documentation available at `http://localhost:8080/swagger-ui/index.html`
---
 
### Option 2 — Local
 
**Prerequisites:** Java 21, Maven, PostgreSQL
 
1. Clone the repository
2. Create a database
3. Configure the environment variables
4. Run `AuthapiApplication.java`
5. The API will be available at `http://localhost:8080`
## API Endpoints
 
### Auth (Public)
 
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /auth/register | Register a new user |
| POST | /auth/login | Login and receive a JWT token |
 
### User (Requires authentication)
 
| Method | Endpoint | Description | Required Role |
|--------|----------|-------------|---------------|
| GET | /user/profile | Access user area | USER or ADMIN |
| GET | /admin/dashboard | Access admin area | ADMIN only |
 
### Authentication
 
All protected endpoints require the JWT token in the request header:
 
```
Authorization: Bearer <your_token>
```
 
---
 
# Auth API — Autenticação JWT (Português)
 
API REST backend de autenticação e autorização de usuários construída com Java e Spring Boot, utilizando tokens JWT e controle de acesso por roles.
 
## Tecnologias
 
- Java 21
- Spring Boot 4.0.5
- Spring Security 7.0.4
- PostgreSQL 18
- Maven
- JWT (jjwt)
- Lombok
- Docker
- Docker Compose
## Funcionalidades
 
- Registro de usuário com senha criptografada via BCrypt
- Login com geração de token JWT
- Autorização por roles (USER e ADMIN)
- Endpoints protegidos e públicos
- Respostas padronizadas da API
- Tratamento global de exceções
- Validação de campos com Bean Validation
- Documentação da API com Swagger/OpenAPI
## Estrutura do Projeto
 
```
authapi/
├── src/
│   └── main/
│       └── java/
│           └── br/com/marcossouza/authapi/
│               ├── config/        → configuração do Spring Security
│               ├── controller/    → recebe as requisições HTTP
│               ├── dto/           → objetos de request e response
│               ├── exception/     → tratamento global de exceções
│               ├── model/         → entidade User e enum Role
│               ├── repository/    → comunicação com o banco
│               ├── security/      → filtro JWT e utilitários JWT
│               └── service/       → lógica de negócio
├── Dockerfile
├── docker-compose.yaml
├── pom.xml
└── AuthapiApplication.java
```
 
## Como Executar
 
### Opção 1 — Docker (Recomendado)
 
**Pré-requisitos:** Docker e Docker Compose
 
1. Clone o repositório
2. Crie um arquivo `.env` na raiz do projeto
3. Execute:
```bash
docker compose up --build
```
 
4. A API estará disponível em `http://localhost:8080`
5. Documentação da API disponível em `http://localhost:8080/swagger-ui/index.html`
---
 
### Opção 2 — Local
 
**Pré-requisitos:** Java 21, Maven, PostgreSQL
 
1. Clone o repositório
2. Crie um banco de dados.
3. Configure as variáveis de ambiente
4. Execute o arquivo `AuthapiApplication.java`
5. A API estará disponível em `http://localhost:8080`
## Endpoints da API
 
### Auth (Público)
 
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | /auth/register | Registra um novo usuário |
| POST | /auth/login | Realiza login e retorna o token JWT |
 
### Usuário (Requer autenticação)
 
| Método | Endpoint | Descrição | Role necessária |
|--------|----------|-----------|-----------------|
| GET | /user/profile | Acessa a área do usuário | USER ou ADMIN |
| GET | /admin/dashboard | Acessa a área do administrador | Somente ADMIN |
 
### Autenticação
 
Todos os endpoints protegidos requerem o token JWT no header da requisição:
 
```
Authorization: Bearer <seu_token>
```
