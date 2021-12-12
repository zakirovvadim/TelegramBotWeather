package ru.vadim.weather.service;


import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.vadim.weather.bot.config.BotState;

public interface WeatherService {
    SendMessage handle(Message message);

    BotState getHandlerName();
}
