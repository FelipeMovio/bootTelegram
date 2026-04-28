package com.felipemovio.bootTelegram.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/webhook")
public class BotController {

    private final String tokenBot = "8692997347:AAHHaYd62eS8RVJOd8mHBjTBS9YR_fNXDtc";

    @PostMapping
    public void receberMensagem(@RequestBody Map<String, Object> update) {

        Map message = (Map) update.get("message");
        Map chat = (Map) message.get("chat");

        String texto = (String) message.get("text");
        Long chatId = Long.valueOf(chat.get("id").toString());

        if (texto.equalsIgnoreCase("oi")) {
            enviarMensagem(chatId, "Olá! Como posso ajudar?");
        } else if (texto.equalsIgnoreCase("horario")) {
            enviarMensagem(chatId, "Atendemos das 08h às 18h.");
        } else {
            enviarMensagem(chatId, "Não entendi sua mensagem 😅");
        }
    }

    public void enviarMensagem(Long chatId, String texto) {

        String url = "https://api.telegram.org/bot8692997347:AAHHaYd62eS8RVJOd8mHBjTBS9YR_fNXDtc/sendMessage";

        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> body = new HashMap<>();
        body.put("chat_id", chatId);
        body.put("text", texto);

        restTemplate.postForObject(url, body, String.class);
    }
}
