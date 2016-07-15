[![Telegram](http://trellobot.doomdns.org/telegrambadge.svg)](https://telegram.me/JTelegramBot)

JTelegramBot is a Java library that wraps Telegram Bot API with a simpler API using [Builder design pattern](https://en.wikipedia.org/wiki/Builder_pattern#Java_example).

![](/assets/Java_logo.png)
![](/assets/telegram_logo.PNG)

TelegramBot library supports full functionality of Telegram Bot API 2.1 and it consists of 3 modules:

 - **Core (required):** This module contains the minimum required classes to use the library.
 - **Builders (recommended):** An optional wrapper that makes Telegram Bot API much easier to use.
 - **Webhook (optional):** An optional wrapper that enables "Webhook" mode.

# Dependencies

 - Java 6+
 - [commons-logging-1.2.jar](https://github.com/Eng-Fouad/JTelegramBot/raw/master/JTelegramBot%20Core/libs/commons-logging-1.2.jar)
 - [jackson-annotations-2.7.2.jar](https://github.com/Eng-Fouad/JTelegramBot/raw/master/JTelegramBot%20Core/libs/jackson-annotations-2.7.2.jar)
 - [jackson-core-2.7.2.jar](https://github.com/Eng-Fouad/JTelegramBot/raw/master/JTelegramBot%20Core/libs/jackson-core-2.7.2.jar)
 - [jackson-databind-2.7.2.jar](https://github.com/Eng-Fouad/JTelegramBot/raw/master/JTelegramBot%20Core/libs/jackson-databind-2.7.2.jar)
 - [netty-all-4.0.34.Final.jar](https://github.com/Eng-Fouad/JTelegramBot/raw/master/JTelegramBot%20Webhook/libs/netty-all-4.0.34.Final.jar) (only required if you use Webhook module)
 
# Installation Instructions

- [JTelegramBot-Core-v1.1.jar](https://github.com/Eng-Fouad/JTelegramBot/raw/master/jars/JTelegramBot-Core-v1.1.jar)
- [JTelegramBot-Builders-v1.1.jar](https://github.com/Eng-Fouad/JTelegramBot/raw/master/jars/JTelegramBot-Builders-v1.1.jar)
- [JTelegramBot-Webhook-v1.0.jar](https://github.com/Eng-Fouad/JTelegramBot/raw/master/jars/JTelegramBot-Webhook-v1.0.jar)

Other options will be added later.

# How Telegram Bot works?

See https://core.telegram.org/bots/api

# Usage

 1. First of all, you need to create a new Telegram Bot and get an *access token* as described [here](https://core.telegram.org/bots#3-how-do-i-create-a-bot).
 2. Start writing Java code by defining an instance of the interface `UpdateHandler` which contains callbacks methods called upon getting new updates from Telegram server. For simplicity, you can use `SimpleUpdateHandler` (which provides empty implementaions) and override the callback methods you need. `UpdateHandler` provides the following callback methods:
 
   - `onMessageReceived(TelegramBotApi telegramBotApi, int id, Message message)`: Invoked on receiving new incoming [message](https://core.telegram.org/bots/api#message) of any kind — text, photo, sticker, etc, sticker, etc.
   - `onInlineQueryReceived(TelegramBotApi telegramBotApi, int id, InlineQuery inlineQuery)`: Invoked on receiving new incoming [inline query](https://core.telegram.org/bots/api#inlinequery).
   - `onChosenInlineResultReceived(TelegramBotApi telegramBotApi, int id, ChosenInlineResult chosenInlineResult)`: Invoked on receiving the [result](https://core.telegram.org/bots/api#choseninlineresult) of an inline query that was chosen by a user and sent to their chat partner.
   - `onCallbackQueryReceived(TelegramBotApi telegramBotApi, int id, CallbackQuery callbackQuery)`: Invoked on receiving new incoming [callback query](https://core.telegram.org/bots/api#callbackquery).
   - `onGetUpdatesFailure(Exception e)`: Invoked in case of an exception occurs when trying to get the new update.
 3. Inside the callbck methods, wrap the low-level interface `telegramBotApi` with the high-level builder `ApiBuilder`. For example:

        @Override
        public void onMessageReceived(TelegramBotApi telegramBotApi, int id, Message message)
        {
            try
            {
                ApiBuilder.api(telegramBotApi)
                          .sendMessage("*This is a simple text message*")
                          .toChatId(message.getChat().getId())
                          .asReplyToMessage(message.getMessageId())
                          .asSilentMessage()
                          .parseMessageAs(ParseMode.MARKDOWN)
                          .execute();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            catch(NegativeResponseException e)
            {
                e.printStackTrace();
            }
        }
        
 4. There are some builder classes that facilitates the creation of complex objects:

    - `InlineKeyboardButtonBuilder` builds `InlineKeyboardButton[][]`.
    - `KeyboardButtonBuilder` builds `KeyboardButton[][]`.
    - `InlineQueryResultBuilder` builds all of 19 types of `InlineQueryResult`.
    - `InputMessageContentBuilder` builds all of 4 types of `InputMessageContent`.
    - `ReplyMarkupBuilder` builds all of 4 types of `ReplyMarkup`.

 5. After implmenting the interface `UpdateHandler`, create a new instance of `JTelegramBot` as follows:

        JTelegramBot bot = new JTelegramBot("BotName", API_TOKEN, updateHandler);

 6. After that, just start the bot in `Polling` mode:

        bot.start(); // blocking call
        // or bot.startAsync(); non-blocking call

 7. To start JTelegramBot in a `Webhook` mode, instead of starting bot directly (as in step 6), wrap it with `WebhookServer`:

        WebhookServer webhookServer = new WebhookServer(bot, "example.com", TelegramPort.PORT_8443, "/random/path");
		webhookServer.useGeneratedSelfSignedSslCertificate();
		webhookServer.registerWebhook();
		webhookServer.start();


# Exceptions Handling

Most of the APIs (methods) in this library throws 2 types of exceptions:

 - **IOException:** if an I/O exception occurs.
 - **NegativeResponseException:** if 4xx-5xx HTTP response is received from Telegram server.
 

# List of `ApiBuilder` APIs

###### Note: On each level of indentation, at least one method must be invoked. On the last level, `execute()` ends the methods chaining.

    ApiBuilder.api(TelegramBotApi telegramBotApi)

- <pre><code>.asUser()
        .execute();</code></pre>
- <pre><code>.sendMessage(String text)
        .toChatUsername(String chatUsername) or .toChatId(long chatId)
            .parseMessageAs(ParseMode parseMode)
            .disableLinkPreviews()
            .asSilentMessage()
            .asReplyToMessage(int messageId)
            .applyReplyMarkup(ReplyMarkup replyMarkup)
            .execute();</pre></code>
- <pre><code>.forwardMessage(int messageId)
        .fromChatUsername(String chatUsername) or fromChatId(long chatId)
            .toChatUsername(String chatUsername) or toChatId(long chatId)
                .asSilentMessage()
                .execute();</pre></code>
- <pre><code>.sendPhoto(File photoFile) or .sendPhoto(InputStream photoInputStream, String photoName) or .resendPhoto(String photoId)
        .toChatUsername(String chatUsername) or .toChatId(long chatId)
            .withPhotoCaption(String photoCaption)
            .asSilentMessage()
            .asReplyToMessage(int messageId)
            .applyReplyMarkup(ReplyMarkup replyMarkup)
            .execute();</pre></code>
- <pre><code>.sendAudio(File audioFile) or .sendAudio(InputStream audioInputStream, String audioName) or .resendAudio(String audioId)
        .toChatUsername(String chatUsername) or .toChatId(long chatId)
            .withAudioDuration(int duration)
            .withAudioPerformer(String performer)
            .withAudioTitle(String title)
            .asSilentMessage()
            .asReplyToMessage(int messageId)
            .applyReplyMarkup(ReplyMarkup replyMarkup)
            .execute();</pre></code>
- <pre><code>.sendDocument(File documentFile) or .sendDocument(InputStream documentInputStream, String documentName) or .resendDocument(String documentId)
        .toChatUsername(String chatUsername) or .toChatId(long chatId)
            .withDocumentCaption(String documentCaption)
            .asSilentMessage()
            .asReplyToMessage(int messageId)
            .applyReplyMarkup(ReplyMarkup replyMarkup)
            .execute();</pre></code>
- <pre><code>.sendSticker(File stickerFile) or .sendSticker(InputStream stickerInputStream, String stickerName) or .resendSticker(String stickerId)
        .toChatUsername(String chatUsername) or .toChatId(long chatId)
            .asSilentMessage()
            .asReplyToMessage(int messageId)
            .applyReplyMarkup(ReplyMarkup replyMarkup)
            .execute();</pre></code>
- <pre><code>.sendVideo(File videoFile) or .sendVideo(InputStream videoInputStream, String videoName) or .resendVideo(String videoId)
        .toChatUsername(String chatUsername) or .toChatId(long chatId)
            .withVideoDuration(int duration)
            .withVideoWidth(int width)
            .withVideoHeight(int height)
            .withVideoCaption(String videoCaption)
            .asSilentMessage()
            .asReplyToMessage(int messageId)
            .applyReplyMarkup(ReplyMarkup replyMarkup)
            .execute();</pre></code>
- <pre><code>.sendVoice(File voiceFile) or .sendVoice(InputStream voiceInputStream, String voiceName) or .resendVoice(String voiceId)
        .toChatUsername(String chatUsername) or .toChatId(long chatId)
            .withVoiceDuration(int duration)
            .asSilentMessage()
            .asReplyToMessage(int messageId)
            .applyReplyMarkup(ReplyMarkup replyMarkup)
            .execute();</pre></code>
- <pre><code>.sendLocation(int latitude, int longitude)
        .toChatUsername(String chatUsername) or .toChatId(long chatId)
            .asSilentMessage()
            .asReplyToMessage(int messageId)
            .applyReplyMarkup(ReplyMarkup replyMarkup)
            .execute();</pre></code>
- <pre><code>.sendChatAction(ChatAction chatAction)
        .toChatUsername(String chatUsername) or .toChatId(long chatId)
             .execute();</pre></code>
- <pre><code>.getUserProfilePhotos(int userId) or .getUserProfilePhotos(User user)
        .withOffset(int offset)
        .withLimit(int limit)
        .execute();</pre></code>
- <pre><code>.getFileInfo(String fileId)
        .execute();</pre></code>
- <pre><code>.downloadFile(TelegramFile telegramFile)
        .saveToOutputStream(OutputStream outputStream)
            .execute();</pre></code>
- <pre><code>.kickChatMember(int userId)
        .fromChatUsername(String chatUsername) or .fromChatId(long chatId)
            .execute();</pre></code>
- <pre><code>.leaveChat()
        .byChatUsername(String chatUsername) or .byChatId(long chatId)
            .execute()</pre></code>
- <pre><code>.unbanChatMember(int userId)
        .fromChatUsername(String chatUsername) or .fromChatId(long chatId)
            .execute();</pre></code>
- <pre><code>.getChat()
        .byChatUsername(String chatUsername) or .byChatId(long chatId)
            .execute();</pre></code>
- <pre><code>.getChatAdministrators()
        .ofChatUsername(String chatUsername) or .ofChatId(long chatId)
            .execute();</pre></code>
- <pre><code>.getChatMembersCount()
        .ofChatUsername(String chatUsername) or .ofChatId(long chatId)
            .execute();</pre></code>
- <pre><code>.getChatMember(int userId)
        .ofChatUsername(String chatUsername) or .ofChatId(long chatId)
            .execute();</pre></code>
- <pre><code>.answerCallbackQuery()
        .forQueryId(String queryId)
            .withText(String text)
            .showAsAlert()
            .execute();</pre></code>
- <pre><code>.editMessage()
        .forMessageId(int messageId)
            .fromChatUsername(String chatUsername) or .fromChatId(long chatId)
                .withNewText(String text)
                .withNewCaption(String caption)
                .withNewInlineKeyboard(InlineKeyboardMarkup inlineKeyboard)
                .execute();</pre></code>
- <pre><code>.editInlineMessage()
        .forInlineMessageId(String inlineMessageId)
            .withNewText(String text)
            .withNewCaption(String caption)
            .withNewInlineKeyboard(InlineKeyboardMarkup inlineKeyboard)
            .execute();</pre></code>
- <pre><code>.answerInlineQuery()
        .forQueryId(String queryId)
            .withResults(InlineQueryResult... results)
                .cacheResultsFor(int seconds)
                .asPersonal()
                .withNextOffset(String nextOffset)
                .showSwitchToPM(String buttonText)
                .useSwitchToPmParameter(String parameter)
                .execute();</pre></code>


# Copyright and Licensing Information

This project is licensed under The MIT License (MIT). See [LICENSE](LICENSE) for more details.
