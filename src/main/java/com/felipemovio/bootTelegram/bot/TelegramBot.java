package com.felipemovio.bootTelegram.bot;

import com.felipemovio.bootTelegram.config.DadosBot;
import com.felipemovio.bootTelegram.service.BotService;
import com.felipemovio.bootTelegram.service.UsuarioService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    private final DadosBot dadosBot;
    private final BotService botService;
    private final UsuarioService usuarioService;

    public TelegramBot(DadosBot dadosBot, BotService botService, UsuarioService usuarioService) {
        this.dadosBot = dadosBot;
        this.botService = botService;
        this.usuarioService = usuarioService;
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

            var msg = update.getMessage();

            String chatId = msg.getChatId().toString();
            String nome = msg.getFrom().getFirstName();
            String username = msg.getFrom().getUserName();

            // salva usuário
            usuarioService.salvarOuAtualizar(chatId, nome, username);

            String resposta = botService.processarMensagem(msg.getText());

            SendMessage mensagem = SendMessage.builder()
                    .chatId(chatId)
                    .text(resposta)
                    .replyMarkup(botService.criarMenu())
                    .build();

            try {
                execute(mensagem);
            } catch (Exception e) {
                System.out.println("Erro ao enviar mensagem: " + e.getMessage());;
            }
        }
    }

}