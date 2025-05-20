# 🍳 Aplicação Receita – Estudo com Consumo de API Pública

Este projeto foi desenvolvido como parte dos meus estudos de **Spring Boot**, visando praticar o consumo de APIs públicas, estruturação de aplicações RESTful e persistência de dados em banco local com foco didático.

---

## 📌 Objetivo

- Simular o consumo de uma **API pública de receitas**
- Estruturar a aplicação seguindo o padrão **MVC**
- Persistir as informações obtidas da API em um banco de dados relacional
- Praticar organização de camadas, controladores e modelagem simples

---

## 🛠️ Tecnologias utilizadas

- **Java 11**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **H2 Database** (em memória)
- **Maven**

---

## ✅ Funcionalidades

- Consumo de dados de uma API pública de receitas
- Conversão e armazenamento dos dados recebidos em entidades locais
- Listagem de receitas armazenadas via endpoint REST
- Organização por camadas: controller, service, model e repository

---

## 🧠 Estrutura da aplicação

src/
└── main/
└── java/
└── com/receitas/
├── controller/
├── service/
├── model/
└── repository/


- `controller/`: responsável pelos endpoints
- `service/`: lógica para consumir a API e salvar os dados
- `model/`: entidades representando a estrutura das receitas
- `repository/`: interface JPA para persistência

---

## ▶️ Como rodar o projeto

1. Clone este repositório:  
   `git clone https://github.com/Akemi-Samantha/Aplicacao-Receita-Estudo`

2. Importe na IDE (IntelliJ recomendado)

3. Rode a aplicação com:  
   `./mvnw spring-boot:run` ou diretamente pela IDE

4. Acesse os endpoints com Postman ou navegador

---

## 🧪 Exemplo de endpoint

- `GET /receitas` → lista as receitas armazenadas no banco local após consumo da API

---

## ✨ Sobre

Este projeto foi criado como uma atividade prática para treinar a estruturação de serviços backend com Java e Spring Boot, incluindo a integração com APIs externas e persistência local.  
Mesmo sendo um projeto simples, representa um passo importante na construção da minha base como desenvolvedora backend.

---

## 👩‍💻 Por Akemi Samantha Nakayama

🔗 [LinkedIn](https://www.linkedin.com/in/akemi-samantha-nakayama-121622206/)  
🐙 [GitHub](https://github.com/Akemi-Samantha)
