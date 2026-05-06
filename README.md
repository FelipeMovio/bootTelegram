# 🤖 BootTelegram - Bot com IA (Spring Boot + Telegram + OpenAI)

Projeto de um bot para Telegram desenvolvido com **Java + Spring Boot**, integrado com **OpenAI** para gerar respostas inteligentes em tempo real.

---

## 🚀 Tecnologias utilizadas

* ☕ Java 21
* 🌱 Spring Boot 3
* 🤖 Telegram Bots API
* 🧠 OpenAI API
* 🗄️ H2 Database (em memória)
* 🔗 RestTemplate (consumo de API)

---

## 📌 Funcionalidades

* Recebe mensagens via Telegram
* Processa o texto do usuário
* Envia para a API da OpenAI
* Retorna uma resposta inteligente no chat

---

## ⚙️ Como rodar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/FelipeMovio/bootTelegram.git
cd bootTelegram
```

---

### 2. Configurar variáveis de ambiente

⚠️ Este projeto usa API da OpenAI, então você precisa de uma chave.

No Windows (PowerShell):

```bash
setx OPENAI_API_KEY "sua-chave-aqui"
```

---

### 3. Configurar o Telegram Bot

No arquivo de configuração (ou variável de ambiente), informe:

```properties
telegram.bot.token=SEU_TOKEN
telegram.bot.username=SEU_USERNAME
```

Você pode criar um bot no Telegram com o **@BotFather**

---

### 4. Rodar o projeto

```bash
./mvnw spring-boot:run
```

ou pela sua IDE (IntelliJ)

---

## 🌐 Acessos

* API rodando em:

```
http://localhost:8080
```

* Console do banco H2:

```
http://localhost:8080/h2-console
```

---

## ⚠️ Observações importantes

* É necessário ter créditos na OpenAI para usar a API
* Nunca suba sua API Key no repositório
* Utilize variáveis de ambiente para segurança

---

## 🧠 Melhorias futuras

* [ ] Cache de respostas
* [ ] Histórico de conversa por usuário
* [ ] Deploy em nuvem (Render, Railway, AWS)
* [ ] Integração com banco persistente (PostgreSQL)
* [ ] Tratamento avançado de erros da API

---

## 📷 Exemplo de uso

Usuário:

```
Oi, tudo bem?
```

Bot:

```
Olá! Tudo ótimo 😊 Como posso te ajudar hoje?
```

---

## 👨‍💻 Autor

Desenvolvido por Felipe Movio 🚀
🔗 https://github.com/FelipeMovio

---

## 📄 Licença

Este projeto é livre para estudos e aprendizado.
