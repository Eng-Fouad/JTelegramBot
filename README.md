JTelegramBot is a Java library that wraps Telegram BOT API with a simple API using [Builder design pattern](https://en.wikipedia.org/wiki/Builder_pattern#Java_example).

# Dependencies

 - Java 6+
 - commons-logging-1.2.jar
 - jackson-annotations-2.7.2.jar
 - jackson-core-2.7.2.jar
 - jackson-databind-2.7.2.jar
 

# Usage (Polling mode)

    public class Main
    {
        public static void main(String[] args) throws Exception
        {
            final String API_TOKEN = "XXXXXXXXXXXXXXXXXXXXXXXXX";
            
            JTelegramBot bot = new JTelegramBot("Test Bot", API_TOKEN, new SimpleUpdateHandler()
            {
                @Override
                public void onMessageReceived(TelegramBotApi telegramBotApi, int id, Message message)
                {
                    System.out.println("message = " + message);
                    
                    try
                    {
                        ApiBuilder.api(telegramBotApi)
                                  .sendMessage("Some message")
                                  .toChatId(message.getChat().getId())
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
            });
            
            bot.start();
        }
    }
    
    
# Webhook is coming soon.


# Description will be updated later.
