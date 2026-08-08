# Spring Security JWT

Projeto desenvolvido como desafio final do módulo de Spring Security da ADA.

O objetivo do projeto é implementar autenticação e autorização utilizando JWT em uma arquitetura de microsserviços composta por um API Gateway e um Order Service.

---

## Arquitetura

```
Cliente
    │
    ▼
API Gateway (8080)
    │
    ├── Autenticação
    ├── Geração do JWT
    ├── Validação do JWT
    ├── Controle de Roles
    │
    ▼
Order Service (8081)
    │
    ├── Validação de requisições vindas do Gateway
    ▼
Recursos protegidos
```

---

## Tecnologias

- Java 21
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Maven
- REST API

---

## Funcionalidades

- Login utilizando usuário e senha
- Geração de JWT
- Validação de Token
- Autenticação baseada em JWT
- Autorização baseada em Roles (RBAC)
- API Gateway protegendo os microsserviços
- Filtro personalizado para validação do JWT
- Filtro interno para aceitar apenas requisições provenientes do Gateway

---

## Estrutura do projeto

```
spring-security-jwt
│
├── gateway
│   ├── Authentication
│   ├── JWT
│   ├── Security Filter
│   └── API Gateway
│
└── order-service
    ├── OrderController
    ├── GatewayAuthenticationFilter
    └── Security Configuration
```

---

## Fluxo de autenticação

1. O cliente realiza login.

2. O Gateway valida as credenciais.

3. Um JWT é gerado.

4. O cliente envia o token nas próximas requisições.

5. O Gateway valida o JWT.

6. Caso o token seja válido, a requisição é encaminhada ao Order Service.

7. O Order Service aceita apenas requisições autenticadas pelo Gateway.

---

## Endpoints

### Login

```
POST /api/auth/login
```

Exemplo:

```json
{
  "username": "admin",
  "password": "admin"
}
```

---

### Listar pedidos

```
GET /api/orders
```

Header obrigatório:

```
Authorization: Bearer <JWT>
```

---

## Segurança implementada

- JWT Authentication
- JWT Validation
- Spring Security Filter Chain
- Security Context
- Role Based Access Control (RBAC)
- API Gateway
- Comunicação entre microsserviços
- Proteção contra acesso direto ao Order Service

---

## Autor

Matheus Rocha
