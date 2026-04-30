package com.felipemovio.bootTelegram.config;

import com.felipemovio.bootTelegram.bot.TelegramBot;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class BotInitializer {

    @Bean
    public TelegramBotsApi telegramBotsApi(TelegramBot bot) throws Exception {
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(bot);
        return api;
    }
}
