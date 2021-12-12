package ru.vadim.weather.bot.config.Context;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.vadim.weather.bot.config.BotState;
import ru.vadim.weather.service.WeatherService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BotContext {
    // пиши в ручную сонтекст из https://github.com/dwerd101/george_bot/blob/master/src/main/java/ru/mephi/config/context/BotStateContext.java
    private Map<BotState, WeatherService> messageHandlers = new HashMap<>();

   public BotStateContext(List<WeatherService> messageHandlers) {
       messageHandlers.forEach(handler -> this.messageHandlers.put(handler.getHandlerName(), handler));
    }

   public SendMessage processInputMessage(BotState currentState, Message message) {
       WeatherService currentService = findService(currentState); // gthtbvtyeq dtplt nfr
        return currentMessageHandler.handle(message);
    }
    public SendMessage processButton(BotState currentState, long chatId) {
        WeatherService currentService = findService(currentState);
       if(currentState.equals(BotState.MOSCOW)) {
            todayHandler = (TodayHandler) currentMessageHandler;
           return todayHandler.handle(chatId);
       }


       else return null;
   }

   private WeatherService findService(BotState currentState) {
       if (isUsertTelegramState(currentState)) {
           return messageHandlers.get(BotState.NEW_USER);
       }
       return messageHandlers.get(currentState);
    }

   private boolean isUsertTelegramState(BotState currentState) {
        switch (currentState) {
           case NEW_USER:
                return true;
            default:
               return false;
       }
    }
}
