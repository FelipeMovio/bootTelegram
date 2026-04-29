package com.felipemovio.bootTelegram.config;

import com.felipemovio.bootTelegram.bot.TelegramBot;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class BotInitializer {

    private final TelegramBot bot;

    public BotInitializer(TelegramBot bot) {
        this.bot = bot;
    }

    @PostConstruct
    public void init() {
        try {
            TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
            api.registerBot(bot);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
