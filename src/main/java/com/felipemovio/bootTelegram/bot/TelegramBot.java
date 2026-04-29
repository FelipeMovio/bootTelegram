package com.felipemovio.bootTelegram.bot;

import com.felipemovio.bootTelegram.config.DadosBot;
import com.felipemovio.bootTelegram.service.BotService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    private final DadosBot dadosBot;
    private final BotService botService;

    public TelegramBot(DadosBot dadosBot, BotService botService) {
        this.dadosBot = dadosBot;
        this.botService = botService;
    }

    @Override
    public String getBotUsername() {
        return dadosBot.getUsername();
    }

    @Override
    public String getBotToken() {
        return dadosBot.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {

            String texto = update.getMessage().getText();
            String chatId = update.getMessage().getChatId().toString();

            String resposta = botService.processarMensagem(texto);

            SendMessage mensagem = SendMessage.builder()
                    .chatId(chatId)
                    .text(resposta)
                    .build();

            try {
                execute(mensagem);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}