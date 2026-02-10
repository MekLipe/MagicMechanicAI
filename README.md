# 🔧 MagicMechanicAI

O **MagicMechanicAI** é uma aplicação fullstack que utiliza **Inteligência Artificial (Google Gemini)** para recomendar **peças automotivas ideais** com base no carro selecionado pelo usuário.

O sistema simula o comportamento de um **mecânico experiente**, analisando informações como marca, modelo, versão, motorização e ano do veículo para gerar recomendações precisas e objetivas.

---

## 🧠 Funcionalidades

### 🚗 Cadastro de carros
- Cadastrar carros com:
  - Marca
  - Modelo
  - Ano
  - Versão
  - Motorização
- Persistência em banco de dados

### 📋 Listagem de carros
- Visualizar todos os carros cadastrados
- Selecionar um carro para consulta

### 🤖 Recomendações com IA
- Usuário informa qual **peça deseja consultar** (ex: pneu, freio, suspensão, óleo)
- A aplicação envia os dados do carro + peça para a API do **Google Gemini**
- A IA retorna uma recomendação personalizada
- Apenas o **texto final da IA** é exibido ao usuário

---

## 🏗️ Arquitetura do Projeto

### Backend
- Java 21
- Spring Boot
- Spring WebFlux
- Spring Data JPA
- Banco de dados relacional
- Integração com Google Gemini API
- Programação reativa com `Mono`

### Frontend
- React
- Vite
- Axios
- CSS puro
- Interface simples e responsiva

---

## 🔁 Fluxo da Aplicação

1. Usuário cadastra um carro
2. Carros são listados na tela principal
3. Usuário seleciona um carro
4. Usuário informa a peça desejada
5. Frontend envia:
   - ID do carro (URL)
   - Peça (body)
6. Backend:
   - Busca o carro no banco
   - Monta o prompt dinamicamente
   - Envia para o Gemini
7. IA retorna a recomendação
8. Texto final é exibido na interface

---

## 📡 Endpoints Principais

### 🚗 Carros

| Método | Endpoint | Descrição |
|------|--------|----------|
| GET | `/carro/Listar` | Lista todos os carros |
| POST | `/carro/Criar` | Cadastra um novo carro |

### 🤖 IA

| Método | Endpoint | Descrição |
|------|--------|----------|
| POST | `/gerar/{id}` | Gera recomendação de peça para o carro |

Body da requisição:
```json
{
  "peca": "pneu"
}
🧪 Exemplo de Prompt Gerado
"Atue como um mecânico experiente. Tenho um Volkswagen Polo 2.0 TSI GTS 2022.
Quais são as melhores opções de pneu para esse carro?"

🖥️ Interface
Tela única com:

Formulário de cadastro de carro
Lista de carros cadastrados
Seleção de carro
Campo para informar a peça
Botão para gerar recomendação
Destaque visual do carro selecionado
Resposta da IA exibida de forma clara e legível

🚀 Como rodar o projeto
Backend
bash
Copiar código
./mvnw spring-boot:run
O backend estará disponível em:


http://localhost:8080
Frontend
bash
Copiar código
npm install
npm run dev
O frontend estará disponível em:


http://localhost:5173
🔐 Variáveis de Ambiente
No backend, configure sua chave da API do Gemini:


GEMINI_API_KEY=SUACHAVEAQUI
🎯 Objetivo do Projeto
Este projeto foi desenvolvido com foco em:

Estudo de Spring WebFlux

Integração com IA generativa

Comunicação frontend ↔ backend

Boas práticas de arquitetura

Construção de projeto para portfólio

👨‍💻 Autor
Desenvolvido por Luis Felipe Machado Kopper
Projeto educacional e de portfólio 🚀
