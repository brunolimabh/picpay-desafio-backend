# Desafio PicPay

Desafio backend do PicPay
Repositório: https://github.com/PicPay/picpay-desafio-backend


## 📃 Postman collection: 

#### 🟨 Endpoint para criar usuário
- **Método HTTP:** POST
- **URL:** `http://localhost:8080/users`

#### Body da Requisição (JSON):
```json
{
    "firstName": "Bruno",
    "lastName": "Henrique",
    "document": "123456789",
    "email": "bruno@example.com",
    "password": "1234",
    "balance": 10,
    "userType": "COMMON"
}
```

#### 🟩 Endpoint para listas todas os usuários
- **Método HTTP:** GET
- **URL:** `http://localhost:8080/users`

#### 🟨 Endpoint para criar transação
- **Método HTTP:** POST
- **URL:** `http://localhost:8080/transactions`

#### Body da Requisição (JSON):
```json
{
    "senderId": 2,
    "receiverId": 1,
    "value": 10
}
```
