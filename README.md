# Spring Security JWT

Projeto desenvolvido para demonstrar a implementação de autenticação e autorização utilizando **Spring Security** e **JWT** em uma arquitetura baseada em microsserviços.

O sistema é composto por um **API Gateway**, responsável pela autenticação dos usuários, e um **Order Service**, que disponibiliza recursos protegidos e aceita apenas requisições encaminhadas pelo Gateway.

---

## Arquitetura

```text
                +--------------------+
                |      Cliente       |
                +--------------------+
                          |
                          | POST /login
                          ▼
                +--------------------+
                |      Gateway       |
                |--------------------|
                | Authentication     |
                | JWT Validation     |
                | Role Validation    |
                +--------------------+
                          |
          X-Gateway-Authenticated
                          |
                          ▼
                +--------------------+
                |   Order Service    |
                |--------------------|
                | Gateway Filter     |
                | Protected API      |
                +--------------------+
```

---

## Tecnologias

- Java 21
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Maven
- REST APIs

---

## Funcionalidades

- Autenticação com usuário e senha
- Geração e validação de JWT
- Autorização baseada em Roles (RBAC)
- Filtro personalizado de autenticação
- API Gateway protegendo os microsserviços
- Comunicação entre microsserviços utilizando `RestClient`
- Proteção contra acesso direto ao Order Service

---

## Fluxo da autenticação

1. O cliente realiza o login.
2. O Gateway valida as credenciais.
3. Um JWT é gerado e retornado ao cliente.
4. O cliente envia o token nas próximas requisições.
5. O Gateway valida o JWT e as permissões do usuário.
6. A requisição é encaminhada ao Order Service.
7. O Order Service aceita apenas chamadas provenientes do Gateway.

---

## Endpoints

### Login

```http
POST /api/auth/login
```

```json
{
  "username": "admin",
  "password": "admin"
}
```

---

### Listar pedidos

```http
GET /api/orders
Authorization: Bearer <JWT>
```

---

## Como executar

Clone o repositório:

```bash
git clone https://github.com/Matheusrnsc/spring-security-jwt.git
```

Inicie os dois microsserviços:

- Gateway → `localhost:8080`
- Order Service → `localhost:8081`

Realize o login para obter um JWT e utilize o token nas chamadas ao Gateway.

---

## O que aprendi

- Spring Security
- JWT Authentication
- Security Filter Chain
- OncePerRequestFilter
- Role Based Access Control (RBAC)
- API Gateway
- Comunicação entre microsserviços
- Separação de responsabilidades entre serviços

---

## Próximas melhorias

- Persistência de usuários em banco de dados
- Criptografia de senhas com BCrypt
- Refresh Token
- Testes automatizados
- Docker
