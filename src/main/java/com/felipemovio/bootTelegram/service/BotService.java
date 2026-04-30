package com.felipemovio.bootTelegram.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class BotService {

    public String processarMensagem(String texto) {

        texto = texto.toLowerCase();

        if (texto.equals("📅 data")) {
            return "📅 Data atual: " + LocalDate.now();
        }

        if (texto.equals("⏰ hora")) {
            return "⏰ Hora atual: " + LocalTime.now();
        }

        if (texto.equals("🙋 sobre")) {
            return "🤖 Eu sou um bot com banco de dados!";
        }

        if (texto.equals("❓ help") || texto.equals("/help")) {
            return """
                    Comandos disponíveis:
                    📅 Data
                    ⏰ Hora
                    🙋 Sobre
                    """;
        }

        if (texto.startsWith("ola") || texto.startsWith("olá") || texto.startsWith("oi")) {
            return "🤖 Olá! Use o menu abaixo 👇";
        }

        return "Use os botões abaixo 👇";
    }
}