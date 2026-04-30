package com.felipemovio.bootTelegram.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BotService {

    public String processarMensagem(String texto) {

        if (texto == null) return "Erro na mensagem.";

        String original = texto.trim();
        String textoNormalizado = original.toLowerCase();

        //  DATA (botão ou texto)
        if (textoNormalizado.equals("📅 data") || textoNormalizado.equals("data")) {
            return "📅 Data atual: " + LocalDate.now();
        }

        //  HORA (botão ou texto)
        if (textoNormalizado.equals("⏰ hora") || textoNormalizado.equals("hora")) {
            return "⏰ Hora atual: " + LocalTime.now();
        }

        //  SOBRE
        if (textoNormalizado.equals("🙋 sobre") || textoNormalizado.contains("quem é você") || textoNormalizado.contains("quem e voce") || textoNormalizado.contains("sobre")) {
            return "🤖 Eu sou um bot criado com Java + Spring Boot e banco de dados!";
        }

        //  HELP
        if (textoNormalizado.equals("❓ help") || textoNormalizado.equals("/help")) {
            return """
                    📋 Comandos disponíveis:

                    📅 Data → mostra a data
                    ⏰ Hora → mostra a hora
                    🙋 Sobre → sobre o bot

                    Ou use os botões abaixo 👇
                    """;
        }

        //  SAUDAÇÃO
        if (textoNormalizado.startsWith("ola") || textoNormalizado.startsWith("olá") || textoNormalizado.startsWith("oi")) {
            return "🤖 Olá! Use o menu abaixo 👇";
        }

        //  DEFAULT
        return "❌ Não entendi. Use os botões abaixo 👇";
    }

    public ReplyKeyboardMarkup criarMenu() {

        KeyboardRow row1 = new KeyboardRow();
        row1.add("📅 Data");
        row1.add("⏰ Hora");

        KeyboardRow row2 = new KeyboardRow();
        row2.add("🙋 Sobre");
        row2.add("❓ Help");

        List<KeyboardRow> teclado = new ArrayList<>();
        teclado.add(row1);
        teclado.add(row2);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(teclado);
        markup.setResizeKeyboard(true);

        return markup;
    }
}