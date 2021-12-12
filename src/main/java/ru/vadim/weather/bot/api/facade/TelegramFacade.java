package ru.vadim.weather.bot.api.facade;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.vadim.weather.bot.config.BotState;
import ru.vadim.weather.bot.config.Context.BotContext;

import java.util.Optional;
@Slf4j
@Component
@AllArgsConstructor
public class TelegramFacade {
        private final BotContext botStateContext;
        private final UserDataCache userDataCache;

        public Optional<BotApiMethod<?>> handleUpdate(Update update) {
//если пользователь нажал на кнопку, идет срабатывание, вызывает процес коллбэкквери, и по кнопке начинает искать функционал
            if (update.hasCallbackQuery()) {
                CallbackQuery callbackQuery = update.getCallbackQuery();
                log.info("New callbackQuery from User: {}, userId: {}, with data1: {}", update.getCallbackQuery().getFrom().getUserName(),
                        callbackQuery.getFrom().getId(), update.getCallbackQuery().getData());
                return processCallbackQuery(callbackQuery);
            }
// если пользователь не нажал кнопку, а сообщение написал, то начинаем хэндить сообщение в свитче (там функционал)
            Message message = update.getMessage();
            if (message != null && message.hasText()) {
                log.info("New message from User:{}, chatId: {},  with text: {}",
                        message.getFrom().getUserName(), message.getChatId(), message.getText());
                Optional<SendMessage> optionalSendMessage = handleInputMessage(message);
                if(optionalSendMessage.isPresent()) {
                    return Optional.of(optionalSendMessage.get());
                }
            }

            return Optional.empty();
        }

        private Optional<SendMessage> handleInputMessage(Message message) {
            String inputMsg = message.getText();
            final Long userId = message.getFrom().getId();
            BotState botState;
            SendMessage replyMessage;

            switch (inputMsg) {
                case "/start":
                    botState = BotState.MOSCOW;
                    break;
                case "/Moscow":
                case "/moscow":
               // case "/today@hse_ebot":
                    // case "СЕГОДНЯ":
                    botState = BotState.MOSCOW;
                    break;
//                case "/Tomorrow":
//                case "/tomorrow":
//                case "/tomorrow@hse_ebot":
//                    botState = BotState.TOMMOROW;
//                    break;
//                case "/week":
//                case "/week@hse_ebot":
//                    botState = BotState.WEEK;
//                    break;
//                case "/wmn":
//                case "/wmn@hse_ebot":
//                    botState = BotState.WEATHER_TODAY;
//                    break;
//                case "/wmtodtom":
//                case "/wmtodtom@hse_ebot":
//                    botState = BotState.WEATHER_TODAY_AND_TOMORROW;
//                    break;
                default:
                    return Optional.empty();

            }

            //userDataCache.setUsersCurrentBotState(userId, botState);

            replyMessage = botStateContext.processInputMessage(botState, message);

            return Optional.of(replyMessage);
        }
// кнопки
        private Optional<BotApiMethod<?>> processCallbackQuery(CallbackQuery buttonQuery) {
            final long chatId = buttonQuery.getMessage().getChatId();
            final Long userId = buttonQuery.getFrom().getId();

            switch (buttonQuery.getData()) {
                case "buttonMoscow":
                    userDataCache.getUsersCurrentBotState(userId);
                    SendMessage replyMessage= botStateContext.processButton(BotState.MOSCOW, chatId);
                    return Optional.of(replyMessage);
//                case "buttonTomorrow":
//                    userDataCache.getUsersCurrentBotState(userId);
//                    replyMessage = botStateContext.processButton(BotState.TOMMOROW, chatId);
//                    return Optional.of(replyMessage);
//                case "buttonWeek":
//                    userDataCache.getUsersCurrentBotState(userId);
//                    replyMessage = botStateContext.processButton(BotState.WEEK, chatId);
//                    return Optional.of(replyMessage);
//                case "buttonWeatherToday":
//                    userDataCache.getUsersCurrentBotState(userId);
//                    replyMessage = botStateContext.processButton(BotState.WEATHER_TODAY, chatId);
//                    return Optional.of(replyMessage);
//                case "buttonWeatherTodayAndTomorrow":
//                    userDataCache.getUsersCurrentBotState(userId);
//                    replyMessage = botStateContext.processButton(BotState.WEATHER_TODAY_AND_TOMORROW, chatId);
//                    return Optional.of(replyMessage);
            }
            return Optional.empty();
        }

    }
}
