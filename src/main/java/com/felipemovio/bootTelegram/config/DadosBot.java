package com.felipemovio.bootTelegram.config;


import lombok.Getter;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Getter
@Component
public class DadosBot {

    @Value("${telegram.bot.token}")
    private String token;

    @Value("${telegram.bot.username}")
    private String username;
}
