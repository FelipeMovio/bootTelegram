package com.felipemovio.bootTelegram.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class BotService {

    public String processarMensagem(String texto) {

        texto = texto.toLowerCase();

        if (texto.equals("data")) {
            return getData();
        }

        if (texto.startsWith("hora")) {
            return getHora();
        }

        if (texto.startsWith("ola") || texto.startsWith("olá") || texto.startsWith("oi")) {
            return "🤖 Olá! Como posso te ajudar?";
        }

        if (texto.contains("quem é você") || texto.contains("quem e voce")) {
            return "🤖 Eu sou um bot criado em Java com Spring Boot!";
        }

        if (texto.equals("/help")) {
            return """
                    Comandos disponíveis:
                    - olá
                    - data
                    - hora
                    - quem é você
                    """;
        }

        return "Não entendi! Digite /help.";
    }

    private String getData() {
        return "A data atual é: " + LocalDate.now();
    }

    private String getHora() {
        return "A hora atual é: " + LocalTime.now();
    }
}
