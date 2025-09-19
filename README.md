# 🌟 Plataforma de Gestão de Freelancers | Freelancer Management Platform  

<p align="center">  
  <img src="https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java" />  
  <img src="https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=for-the-badge&logo=springboot" />  
  <img src="https://img.shields.io/badge/PostgreSQL-15-blue?style=for-the-badge&logo=postgresql" />  
  <img src="https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge" />  
  <img src="https://img.shields.io/badge/Status-In%20Development-lightgrey?style=for-the-badge" />  
</p>  

Uma plataforma completa que conecta **clientes** e **freelancers**, permitindo cadastro de projetos, envio e negociação de propostas, acompanhamento de status e simulação de pagamentos.  
A complete platform that connects **clients** and **freelancers**, allowing project creation, proposal submission and negotiation, project tracking, and payment simulation.  

---

## 📑 Sumário | Table of Contents  
- [🇧🇷 Português](#-português)  
  - [✨ Funcionalidades Principais](#-funcionalidades-principais)  
- [🇬🇧 English](#-english)  
  - [✨ Main Features](#-main-features)  
- [🛠️ Tecnologias | Technologies](#️-tecnologias--technologies)  
- [🚀 Objetivo | Goal](#-objetivo--goal)  
- [📅 Status](#-status)  
- [🤝 Contribuição | Contributing](#-contribuição--contributing)  

---

## 🇧🇷 Português  

### ✨ Funcionalidades Principais  
- 👤 **Cadastro de Usuários**  
  - Dois tipos: **Cliente** e **Freelancer**  
  - Dados obrigatórios: Nome, CPF/CNPJ, E-mail único, Senha  
  - Um usuário pode atuar nos dois papéis  

- 📌 **Cadastro de Projetos** *(somente clientes)*  
  - Campos: **Título**, **Descrição**, **Prazo**, **Orçamento**  
  - Status: `Aberto`, `Em negociação`, `Em andamento`, `Concluído`, `Cancelado`  

- 💼 **Propostas de Freelancers**  
  - Freelancers podem enviar valor ofertado e prazo estimado  
  - Clientes podem **aceitar** ou **recusar**  
  - Aceitando, o status muda para **Em andamento**  

- ✅ **Entrega & Conclusão**  
  - Freelancer marca como **Concluído**  
  - Cliente valida antes de finalizar  
  - Ajustes possíveis (volta para **Em andamento**)  

- 💳 **Pagamentos (simulação)**  
  - Mock de **gateway de pagamentos** (`POST /pagamento/autorizar`)  
  - Liberação só após aprovação do cliente  
  - Retentativa automática em falhas  

- 🔔 **Notificações**  
  - Via **e-mail** ou **webhook** para:  
    - Proposta enviada  
    - Proposta aceita  
    - Projeto concluído  
  - Mock externo (`POST /notificacao/enviar`)  

---

## 🇬🇧 English  

### ✨ Main Features  
- 👤 **User Registration**  
  - Two types: **Client** and **Freelancer**  
  - Required fields: Full Name, CPF/CNPJ (or ID), Unique Email, Password  
  - A user can act as both roles  

- 📌 **Project Management** *(clients only)*  
  - Fields: **Title**, **Description**, **Deadline**, **Estimated Budget**  
  - Status: `Open`, `Negotiating`, `In Progress`, `Completed`, `Canceled`  

- 💼 **Freelancer Proposals**  
  - Freelancers submit price and estimated deadline  
  - Clients can **accept** or **reject**  
  - If accepted → status changes to **In Progress**  

- ✅ **Delivery & Completion**  
  - Freelancer marks as **Completed**  
  - Client validates before finalizing  
  - Adjustments possible (status returns to **In Progress**)  

- 💳 **Payments (simulation)**  
  - Mock **payment gateway** (`POST /payment/authorize`)  
  - Released only after client approval  
  - Automatic retries on failures  

- 🔔 **Notifications**  
  - Via **email** or **webhook** for:  
    - Proposal submitted  
    - Proposal accepted  
    - Project completed  
  - Mock service (`POST /notification/send`)  

---

## 🛠️ Tecnologias | Technologies  
- Java + Spring Boot ☕  
- PostgreSQL 🐘  
- Arquitetura Hexagonal + DDD 📐  
- Mock Services  

---

## 🚀 Objetivo | Goal  
🇧🇷 Fornecer uma simulação ponta a ponta do fluxo de contratação de freelancers, com foco em **boas práticas de arquitetura** e **regras de negócio**.  
🇬🇧 Provide an end-to-end simulation of the freelancer hiring flow, with focus on **clean architecture** and **business domain rules**.  

---

## 📅 Status  
🇧🇷 🔧 Em desenvolvimento – novas features em andamento.  
🇬🇧 🔧 In development – new features coming soon.  

---

## 🤝 Contribuição | Contributing  
🇧🇷 Pull Requests são bem-vindos! Abra uma issue para sugestões ou melhorias.  
🇬🇧 Pull Requests are welcome! Open an issue for suggestions or improvements.  
