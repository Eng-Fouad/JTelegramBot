/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Fouad Almalki
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.fouad.jtb.core;

import io.fouad.jtb.core.beans.BooleanOrMessageResult;
import io.fouad.jtb.core.beans.Chat;
import io.fouad.jtb.core.beans.ChatIdentifier;
import io.fouad.jtb.core.beans.ChatMember;
import io.fouad.jtb.core.beans.InlineKeyboardMarkup;
import io.fouad.jtb.core.beans.InlineQueryResult;
import io.fouad.jtb.core.beans.MediaIdentifier;
import io.fouad.jtb.core.beans.Message;
import io.fouad.jtb.core.beans.ReplyMarkup;
import io.fouad.jtb.core.beans.TelegramFile;
import io.fouad.jtb.core.beans.User;
import io.fouad.jtb.core.beans.UserProfilePhotos;
import io.fouad.jtb.core.enums.ChatAction;
import io.fouad.jtb.core.enums.ParseMode;
import io.fouad.jtb.core.exceptions.NegativeResponseException;

import java.io.IOException;

/**
 * This interface represents Telegram Bot APIs.
 */
public interface TelegramBotApi
{
	String API_URL_PREFIX = "https://api.telegram.org/bot";
	String FILE_API_URL_PREFIX = "https://api.telegram.org/file/bot";
	
	/**
	 * @return token used to authenticate with bot API
	 */
	String getApiToken();
	
	/**
	 * A simple method for testing the bot's authentication token.
	 * 
	 * @return basic information about the bot in form of a <code>User</code> object
	 * 
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	User getMe() throws IOException, NegativeResponseException;
	
	/**
	 * Sends text messages.
	 * 
	 * @param targetChatIdentifier unique identifier for the target chat or username of the target channel
	 * @param text text of the message to be sent
	 * @param parseMode send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width
	 *                  text or inline URLs in your bot's message
	 * @param disableLinkPreviews disables link previews for links in this message
	 * @param silentMessage sends the message silently. iOS users will not receive a notification, Android
	 *                      users will receive a notification with no sound
	 * @param replyToMessageId if the message is a reply, id of the original message
	 * @param replyMarkup additional instructions to create inline keyboard, create/hide custom keyboard,
	 *                    or to force a reply from the user
	 * 
	 * @return the sent <code>Message</code>
	 * 
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	Message sendMessage(ChatIdentifier targetChatIdentifier, String text, ParseMode parseMode,
	                    Boolean disableLinkPreviews, Boolean silentMessage, Integer replyToMessageId,
	                    ReplyMarkup replyMarkup) throws IOException, NegativeResponseException;
	
	/**
	 * Forwards messages of any kind.
	 * 
	 * @param targetChatIdentifier unique identifier for the target chat or username of the target channel
	 * @param sourceChatIdentifier unique identifier for the chat or username of the channel where the original
	 *                             message was sent
	 * @param silentMessage sends the message silently. iOS users will not receive a notification, Android
	 *                      users will receive a notification with no sound
	 * @param messageId unique identifier for the message to be forwarded
	 * 
	 * @return the forwarded <code>Message</code>
	 * 
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	Message forwardMessage(ChatIdentifier targetChatIdentifier, ChatIdentifier sourceChatIdentifier,
	                       Boolean silentMessage, Integer messageId) throws IOException, NegativeResponseException;
	
	/**
	 * Sends photos.
	 * 
	 * @param targetChatIdentifier unique identifier for the target chat or username of the target channel
	 * @param mediaIdentifier photo to be sent
	 * @param photoCaption photo caption, 0-200 characters
	 * @param silentMessage sends the message silently. iOS users will not receive a notification, Android
	 *                      users will receive a notification with no sound
	 * @param replyToMessageId if the message is a reply, id of the original message
	 * @param replyMarkup additional instructions to create inline keyboard, create/hide custom keyboard,
	 *                    or to force a reply from the user
	 *    
	 * @return the sent <code>Message</code>
	 * 
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	Message sendPhoto(ChatIdentifier targetChatIdentifier, MediaIdentifier mediaIdentifier, String photoCaption,
	                  Boolean silentMessage, Integer replyToMessageId, ReplyMarkup replyMarkup) throws IOException,
			NegativeResponseException;
	
	/**
	 * Sends audio files that Telegram clients will display them in the music player. Your audio must be in the
	 * .mp3 format. Bots can currently send audio files of up to 50 MB in size, this limit may be changed in
	 * the future.
	 * 
	 * @param targetChatIdentifier unique identifier for the target chat or username of the target channel
	 * @param mediaIdentifier audio file to be sent
	 * @param duration duration of the audio in seconds
	 * @param performer the performer
	 * @param trackTitle the track name
	 * @param silentMessage sends the message silently. iOS users will not receive a notification, Android
	 *                      users will receive a notification with no sound
	 * @param replyToMessageId if the message is a reply, id of the original message
	 * @param replyMarkup additional instructions to create inline keyboard, create/hide custom keyboard,
	 *                    or to force a reply from the user
	 * 
	 * @return the sent <code>Message</code>   
	 * 
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	Message sendAudio(ChatIdentifier targetChatIdentifier, MediaIdentifier mediaIdentifier, Integer duration,
	                  String performer, String trackTitle, Boolean silentMessage, Integer replyToMessageId,
	                  ReplyMarkup replyMarkup) throws IOException, NegativeResponseException;
	
	/**
	 * Sends general files. Bots can currently send files of any type of up to 50 MB in size, this limit may be
	 * changed in the future.
	 * 
	 * @param targetChatIdentifier unique identifier for the target chat or username of the target channel
	 * @param mediaIdentifier file to be sent
	 * @param documentCaption document caption, 0-200 characters
	 * @param silentMessage sends the message silently. iOS users will not receive a notification, Android
	 *                      users will receive a notification with no sound
	 * @param replyToMessageId if the message is a reply, id of the original message
	 * @param replyMarkup additional instructions to create inline keyboard, create/hide custom keyboard,
	 *                    or to force a reply from the user
	 *
	 * @return the sent <code>Message</code>
	 * 
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	Message sendDocument(ChatIdentifier targetChatIdentifier, MediaIdentifier mediaIdentifier, String documentCaption,
	                     Boolean silentMessage, Integer replyToMessageId, ReplyMarkup replyMarkup) throws IOException,
			NegativeResponseException;
	
	/**
	 * Sends .webp stickers.
	 * 
	 * @param targetChatIdentifier unique identifier for the target chat or username of the target channel
	 * @param mediaIdentifier sticker to be sent
	 * @param silentMessage sends the message silently. iOS users will not receive a notification, Android
	 *                      users will receive a notification with no sound
	 * @param replyToMessageId if the message is a reply, id of the original message
	 * @param replyMarkup additional instructions to create inline keyboard, create/hide custom keyboard,
	 *                    or to force a reply from the user
	 *
	 * @return the sent <code>Message</code>
	 * 
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	Message sendSticker(ChatIdentifier targetChatIdentifier, MediaIdentifier mediaIdentifier, Boolean silentMessage,
	                    Integer replyToMessageId, ReplyMarkup replyMarkup) throws IOException,
			NegativeResponseException;
	
	/**
	 * Sends video files. Telegram clients support mp4 videos (other formats may be sent as Document). Bots can
	 * currently send video files of up to 50 MB in size, this limit may be changed in the future.
	 * 
	 * @param targetChatIdentifier unique identifier for the target chat or username of the target channel
	 * @param mediaIdentifier video to be sent
	 * @param duration duration of sent video in seconds
	 * @param width video width
	 * @param height video height
	 * @param videoCaption video caption, 0-200 characters
	 * @param silentMessage sends the message silently. iOS users will not receive a notification, Android
	 *                      users will receive a notification with no sound
	 * @param replyToMessageId if the message is a reply, id of the original message
	 * @param replyMarkup additional instructions to create inline keyboard, create/hide custom keyboard,
	 *                    or to force a reply from the user
	 *
	 * @return the sent <code>Message</code>
	 * 
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	Message sendVideo(ChatIdentifier targetChatIdentifier, MediaIdentifier mediaIdentifier, Integer duration,
	                  Integer width, Integer height, String videoCaption, Boolean silentMessage, Integer replyToMessageId,
	                  ReplyMarkup replyMarkup) throws IOException, NegativeResponseException;
	
	/**
	 * Sends audio files that Telegram clients will display them as playable voice messages. For this to work,
	 * your audio must be in an .ogg file encoded with OPUS (other formats may be sent as Audio or Document).
	 * Bots can currently send voice messages of up to 50 MB in size, this limit may be changed in the future.
	 * 
	 * @param targetChatIdentifier unique identifier for the target chat or username of the target channel
	 * @param mediaIdentifier audio file to be sent
	 * @param duration duration of sent audio in seconds
	 * @param silentMessage sends the message silently. iOS users will not receive a notification, Android
	 *                      users will receive a notification with no sound
	 * @param replyToMessageId if the message is a reply, id of the original message
	 * @param replyMarkup additional instructions to create inline keyboard, create/hide custom keyboard,
	 *                    or to force a reply from the user
	 *
	 * @return the sent <code>Message</code>
	 * 
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	Message sendVoice(ChatIdentifier targetChatIdentifier, MediaIdentifier mediaIdentifier, Integer duration, Boolean silentMessage,
	                  Integer replyToMessageId, ReplyMarkup replyMarkup) throws IOException, NegativeResponseException;
	
	/**
	 * Sends point on the map.
	 * 
	 * @param targetChatIdentifier unique identifier for the target chat or username of the target channel
	 * @param latitude latitude of location
	 * @param longitude longitude of location
	 * @param silentMessage sends the message silently. iOS users will not receive a notification, Android
	 *                      users will receive a notification with no sound
	 * @param replyToMessageId if the message is a reply, id of the original message
	 * @param replyMarkup additional instructions to create inline keyboard, create/hide custom keyboard,
	 *                    or to force a reply from the user
	 *
	 * @return the sent <code>Message</code>
	 * 
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	Message sendLocation(ChatIdentifier targetChatIdentifier, float latitude, float longitude, Boolean silentMessage,
	                     Integer replyToMessageId, ReplyMarkup replyMarkup) throws IOException,
			NegativeResponseException;
	
	/**
	 * Sends information about a venue.
	 *
	 * @param targetChatIdentifier unique identifier for the target chat or username of the target channel
	 * @param latitude latitude of the venue
	 * @param longitude longitude of the venue
	 * @param title name of the venue   
	 * @param address address of the venue
	 * @param foursquareId Foursquare identifier of the venue   
	 * @param silentMessage sends the message silently. iOS users will not receive a notification, Android
	 *                      users will receive a notification with no sound
	 * @param replyToMessageId if the message is a reply, id of the original message
	 * @param replyMarkup additional instructions to create inline keyboard, create/hide custom keyboard,
	 *                    or to force a reply from the user
	 *
	 * @return the sent <code>Message</code>
	 *
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	Message sendVenue(ChatIdentifier targetChatIdentifier, float latitude, float longitude, String title,
	                  String address, String foursquareId, Boolean silentMessage, Integer replyToMessageId,
	                  ReplyMarkup replyMarkup) throws IOException, NegativeResponseException;
	
	/**
	 * Sends phone contact.
	 *
	 * @param targetChatIdentifier unique identifier for the target chat or username of the target channel
	 * @param phoneNumber contact's phone number
	 * @param firstName contact's first name
	 * @param lastName contact's last name   
	 * @param silentMessage sends the message silently. iOS users will not receive a notification, Android
	 *                      users will receive a notification with no sound
	 * @param replyToMessageId if the message is a reply, id of the original message
	 * @param replyMarkup additional instructions to create inline keyboard, create/hide custom keyboard,
	 *                    or to force a reply from the user
	 *
	 * @return the sent <code>Message</code>
	 *
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	Message sendContact(ChatIdentifier targetChatIdentifier, String phoneNumber, String firstName,
						String lastName, Boolean silentMessage, Integer replyToMessageId,
						ReplyMarkup replyMarkup) throws IOException, NegativeResponseException;
	
	/**
	 * Use this method when you need to tell the user that something is happening on the bot's side.
	 * The status is set for 5 seconds or less (when a message arrives from your bot, Telegram clients
	 * clear its typing status).
	 * 
	 * @param targetChatIdentifier unique identifier for the target chat or username of the target channel
	 * @param action type of action to broadcast. Choose one, depending on what the user is about to receive
	 * 
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	void sendChatAction(ChatIdentifier targetChatIdentifier, ChatAction action) throws IOException,
			NegativeResponseException;
	
	/**
	 * Gets a list of profile pictures for a user.
	 * 
	 * @param userId unique identifier of the target user
	 * @param offset sequential number of the first photo to be returned. By default, all photos are returned
	 * @param limit limits the number of photos to be retrieved. Values between 1—100 are accepted. Defaults
	 *              to 100
	 * @return <code>UserProfilePhotos</code> object
	 * 
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	UserProfilePhotos getUserProfilePhotos(int userId, Integer offset, Integer limit) throws IOException,
			NegativeResponseException;
	
	/**
	 * Gets basic info about a file and prepare it for downloading. For the moment, bots can download files
	 * of up to 20MB in size.
	 * 
	 * Note: This function may not preserve original file name. Mime type of the file and its name (if available)
	 * should be saved when the File object is received.
	 * 
	 * @param fileId file identifier to get info about
	 *    
	 * @return <code>TelegramFile</code> object
	 * 
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	TelegramFile getFile(String fileId) throws IOException, NegativeResponseException;
	
	/**
	 * Kicks a user from a group or a supergroup. In the case of supergroups, the user will not be
	 * able to return to the group on their own using invite links, etc., unless unbanned first.
	 * The bot must be an administrator in the group for this to work.
	 * Note: This will method only work if the ‘All Members Are Admins’ setting is off in the target
	 * group. Otherwise members may only be removed by the group's creator or by the member that
	 * added them.
	 * 
	 * @param targetChatIdentifier unique identifier for the target group/supergroup or username of the target supergroup
	 * @param userId unique identifier of the target user
	 *                  
	 * @return <code>true</code> on success
	 * 
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	boolean kickChatMember(ChatIdentifier targetChatIdentifier, int userId) throws IOException, NegativeResponseException;
	
	/**
	 * Use this method for your bot to leave a group, supergroup or channel.
	 *
	 * @param targetChatIdentifier unique identifier for the target group/supergroup or username of the target supergroup
	 *
	 * @return <code>true</code> on success
	 *
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	boolean leaveChat(ChatIdentifier targetChatIdentifier) throws IOException, NegativeResponseException;
	
	/**
	 * Unbans a previously kicked user in a supergroup. The user will not return to the group automatically,
	 * but will be able to join via link, etc. The bot must be an administrator in the group for this to work. 
	 *
	 * @param targetChatIdentifier unique identifier for the target group/supergroup or username of the target supergroup
	 * @param userId unique identifier of the target user
	 *
	 * @return <code>true</code> on success
	 *
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	boolean unbanChatMember(ChatIdentifier targetChatIdentifier, int userId) throws IOException, NegativeResponseException;
	
	/**
	 * Use this method to get up to date information about the chat (current name of the user for one-on-one
	 * conversations, current username of a user, group or channel, etc.). 
	 *
	 * @param targetChatIdentifier unique identifier for the target group/supergroup or username of the target supergroup
	 *
	 * @return a <code>Chat</code> object on success
	 *
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	Chat getChat(ChatIdentifier targetChatIdentifier) throws IOException, NegativeResponseException;
	
	/**
	 * Use this method to get a list of administrators in a chat. 
	 *
	 * @param targetChatIdentifier unique identifier for the target group/supergroup or username of the target supergroup
	 *
	 * @return On success, returns an Array of <code>ChatMember</code> objects that contains information about all chat
	 * administrators except other bots. If the chat is a group or a supergroup and no administrators were appointed,
	 * only the creator will be returned.
	 *
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	ChatMember[] getChatAdministrators(ChatIdentifier targetChatIdentifier) throws IOException, NegativeResponseException;
	
	/**
	 * Use this method to get the number of members in a chat. 
	 *
	 * @param targetChatIdentifier unique identifier for the target group/supergroup or username of the target supergroup
	 *
	 * @return On success, number of chat members.
	 *
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	int getChatMembersCount(ChatIdentifier targetChatIdentifier) throws IOException, NegativeResponseException;
	
	/**
	 * Use this method to get information about a member of a chat. 
	 *
	 * @param targetChatIdentifier unique identifier for the target group/supergroup or username of the target supergroup
	 * @param userId unique identifier of the target user
	 *
	 * @return <code>ChatMember</code> object on success
	 *
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	ChatMember getChatMember(ChatIdentifier targetChatIdentifier, int userId) throws IOException, NegativeResponseException;
	
	/**
	 * Sends answers to callback queries sent from inline keyboards. The answer will be displayed to
	 * the user as a notification at the top of the chat screen or as an alert.
	 *
	 * @param callbackQueryId unique identifier for the query to be answered
	 * @param text text of the notification. If not specified, nothing will be shown to the user
	 * @param showAlert if true, an alert will be shown by the client instead of a notification at
	 *                  the top of the chat screen. Defaults to false   
	 *
	 * @return <code>true</code> on success
	 *
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	boolean answerCallbackQuery(String callbackQueryId, String text, Boolean showAlert) throws IOException, NegativeResponseException;
	
	/**
	 * Edits text messages sent by the bot or via the bot (for inline bots).
	 * 
	 * @param targetChatIdentifier unique identifier for the target chat or username of the target channel
	 * @param messageId unique identifier of the sent message
	 * @param inlineMessageId identifier of the inline message
	 * @param text new text of the message
	 * @param parseMode send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width
	 *                  text or inline URLs in your bot's message
	 * @param disableLinkPreviews disables link previews for links in this message
	 * @param inlineKeyboardMarkup inlineKeyboardMarkup object
	 * 
	 * @return the edited <code>Message</code> if it is sent by the bot, otherwise true on success
	 * 
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	BooleanOrMessageResult editMessageText(ChatIdentifier targetChatIdentifier, Integer messageId, String inlineMessageId,
	                                       String text, ParseMode parseMode, Boolean disableLinkPreviews,
	                                       InlineKeyboardMarkup inlineKeyboardMarkup)
			throws IOException, NegativeResponseException;
	
	/**
	 * Edits captions of messages sent by the bot or via the bot (for inline bots).
	 *
	 * @param targetChatIdentifier unique identifier for the target chat or username of the target channel
	 * @param messageId unique identifier of the sent message
	 * @param inlineMessageId identifier of the inline message
	 * @param caption new caption of the message
	 * @param inlineKeyboardMarkup inlineKeyboardMarkup object
	 *
	 * @return the edited <code>Message</code> if it is sent by the bot, otherwise true on success
	 *
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	BooleanOrMessageResult editMessageCaption(ChatIdentifier targetChatIdentifier, Integer messageId, String inlineMessageId,
	                                          String caption, InlineKeyboardMarkup inlineKeyboardMarkup)
			throws IOException, NegativeResponseException;
	
	/**
	 * Edits only the reply markup of messages sent by the bot or via the bot (for inline bots).
	 *
	 * @param targetChatIdentifier unique identifier for the target chat or username of the target channel
	 * @param messageId unique identifier of the sent message
	 * @param inlineMessageId identifier of the inline message
	 * @param inlineKeyboardMarkup inlineKeyboardMarkup object
	 *
	 * @return the edited <code>Message</code> if it is sent by the bot, otherwise true on success
	 *
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	BooleanOrMessageResult editMessageReplyMarkup(ChatIdentifier targetChatIdentifier, Integer messageId, String inlineMessageId,
	                                              InlineKeyboardMarkup inlineKeyboardMarkup)
			throws IOException, NegativeResponseException;
	
	/**
	 * Sends answers to an inline query. No more than 50 results per query are allowed.
	 *
	 * @param inlineQueryId unique identifier for the answered query
	 * @param results array of results for the inline query
	 * @param cacheTime the maximum amount of time in seconds that the result of the inline query
	 *                  may be cached on the server. Defaults to 300
	 * @param isPersonal pass <code>true</code>, if results may be cached on the server side only
	 *                   for the user that sent the query. By default, results may be returned to
	 *                   any user who sends the same query
	 * @param nextOffset the offset that a client should send in the next query with the same text
	 *                   to receive more results. Pass an empty string if there are no more results
	 *                   or if you don‘t support pagination. Offset length can’t exceed 64 bytes
	 * @param switchPmText if passed, clients will display a button with specified text that
	 *                     switches the user to a private chat with the bot and sends the bot
	 *                     a start message with the parameter switchPmParameter
	 * @param switchPmParameter parameter for the start message sent to the bot when user presses
	 *                          the switch button.
	 *                          Example: An inline bot that sends YouTube videos can ask the user
	 *                          to connect the bot to their YouTube account to adapt search results
	 *                          accordingly. To do this, it displays a ‘Connect your YouTube
	 *                          account’ button above the results, or even before showing any.
	 *                          The user presses the button, switches to a private chat with the bot
	 *                          and, in doing so, passes a start parameter that instructs the bot to
	 *                          return an oauth link. Once done, the bot can offer a switch_inline
	 *                          button so that the user can easily return to the chat where they
	 *                          wanted to use the bot's inline capabilities.
	 *
	 * @return <code>true</code> on success
	 *
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	boolean answerInlineQuery(String inlineQueryId, InlineQueryResult[] results, Integer cacheTime, Boolean isPersonal,
	                          String nextOffset, String switchPmText, String switchPmParameter) throws IOException,
			NegativeResponseException;
}