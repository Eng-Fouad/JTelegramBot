JTelegramBot is a Java library that wraps Telegram Bot API with a simple API using [Builder design pattern](https://en.wikipedia.org/wiki/Builder_pattern#Java_example).

TelegramBot library consists of 3 modules:

 - Core (mandatory): This module contains the minimum required classes to use the library.
 - Builders (optional): An optional wrapper that makes Telegram Bot API much easier to use.
 - Webhook (optional): An optional wrapper that enables "Webhook" mode (coming soon).

# Dependencies

 - Java 6+
 - commons-logging-1.2.jar
 - jackson-annotations-2.7.2.jar
 - jackson-core-2.7.2.jar
 - jackson-databind-2.7.2.jar
 
# Installation Instructions


# How Telegram Bot works?

.....

# Usage

 - First of all, you need to create a new Telegram Bot and get an *access token* as described [here](https://core.telegram.org/bots#3-how-do-i-create-a-bot).
 - Start writing Java code by defining an instance of the interface `UpdateHandler` which contains callbacks methods called upon getting new updates from Telegram server. For simplicity, you can use `SimpleUpdateHandler` (which provides empty implementaions) and ovveride the callback methods you need. `UpdateHandler` provides the following callback methods:
 
   - `onMessageReceived(TelegramBotApi telegramBotApi, int id, Message message)`: Invoked on receiving new incoming [message](https://core.telegram.org/bots/api#message) of any kind — text, photo, sticker, etc, sticker, etc.
   - `onInlineQueryReceived(TelegramBotApi telegramBotApi, int id, InlineQuery inlineQuery)`: Invoked on receiving new incoming [inline query](https://core.telegram.org/bots/api#inlinequery).
   - `onChosenInlineResultReceived(TelegramBotApi telegramBotApi, int id, ChosenInlineResult chosenInlineResult)`: Invoked on receiving the [result](https://core.telegram.org/bots/api#choseninlineresult) of an inline query that was chosen by a user and sent to their chat partner.
   - `onCallbackQueryReceived(TelegramBotApi telegramBotApi, int id, CallbackQuery callbackQuery)`: Invoked on receiving new incoming [callback query](https://core.telegram.org/bots/api#callbackquery).
   - `onGetUpdatesFailure(Exception e)`: Invoked in case of an exception occurs when trying to get the new update.


# Copyright and Licensing Information

This project is licensed under The MIT License (MIT). See [LICENSE](LICENSE) for more details.
