package ru.vadim.weather.bot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import ru.vadim.weather.bot.WeatherTelegramBot;
import ru.vadim.weather.bot.api.facade.TelegramFacade;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "telegrambot")
public class BotConfig {
    @Value("${telegrambot.webHookPath}")
    private String webHookPath;
    @Value("${telegrambot.userName}")
    private String botUserName;
    @Value("${telegrambot.botToken}")
    private String botToken;
    @Bean
    public WeatherTelegramBot myWizardTelegramBot(TelegramFacade telegramFacade) {
        DefaultBotOptions options = new DefaultBotOptions();
        WeatherTelegramBot mySuperTelegramBot = new WeatherTelegramBot(options, telegramFacade);
        mySuperTelegramBot.setBotUserName(botUserName);
        mySuperTelegramBot.setBotTocken(botToken);
        mySuperTelegramBot.setWebHookPath(webHookPath);
        return mySuperTelegramBot;
    }
}
