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

package io.fouad.jtb.core.builders;

import io.fouad.jtb.core.*;
import io.fouad.jtb.core.beans.*;
import io.fouad.jtb.core.enums.ChatAction;
import io.fouad.jtb.core.enums.ParseMode;
import io.fouad.jtb.core.exceptions.NegativeResponseException;
import io.fouad.jtb.core.utils.HttpClient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * A helper class which can wrap <code>TelegramBotApi</code> and provide a more simple
 * API in style of "Builder Design Pattern".
 */
public class ApiBuilder
{
	private ApiBuilder(){}
	
	/**
	 * Wraps the <code>TelegramBotApi</code> object to provide a simple API.
	 * 
	 * @param telegramBotApi the <code>TelegramBotApi</code> object, or the <code>JTelegramBot</code> object
	 */
	public static ApiTopLevel api(TelegramBotApi telegramBotApi)
	{
		return new ApiTopLevel(telegramBotApi);
	}
	
	public static class ApiTopLevel
	{
		private TelegramBotApi telegramBotApi;
		
		private ApiTopLevel(TelegramBotApi telegramBotApi)
		{
			this.telegramBotApi = telegramBotApi;
		}
		
		/**
		 * Gets basic info about the current bot as <code>User</code> object.
		 */
		public AsUserReady asUser()
		{
			return new AsUserReady(telegramBotApi);
		}
		
		/**
		 * Sends text message.
		 * 
		 * @param text the text message to be sent
		 */
		public MessageSendingNoTarget sendMessage(String text)
		{
			if(text == null) throw new IllegalArgumentException("\"text\" cannot be null.");
			
			return new MessageSendingNoTarget(telegramBotApi, text);
		}
		
		/**
		 * Forward a message of any kind.
		 * 
		 * @param messageId id of the message to be forwarded
		 */
		public MessageForwardingNoSourceNoTarget forwardMessage(int messageId)
		{
			return new MessageForwardingNoSourceNoTarget(telegramBotApi, messageId);
		}
		
		/**
		 * Sends a photo as a file.
		 * 
		 * @param photoFile photo file to be sent
		 */
		public PhotoSendingNoTarget sendPhoto(File photoFile) throws FileNotFoundException
		{
			if(photoFile == null) throw new IllegalArgumentException("\"photoFile\" cannot be null.");
			
			return new PhotoSendingNoTarget(telegramBotApi, MediaIdentifier.byFile(photoFile));
		}
		
		/**
		 * Sends a photo as an input stream.
		 * 
		 * @param photoInputStream <code>InputStream</code> of the photo to be sent
		 * @param photoName to name the photo file
		 */
		public PhotoSendingNoTarget sendPhoto(InputStream photoInputStream, String photoName)
		{
			if(photoInputStream == null) throw new IllegalArgumentException("\"photoInputStream\" cannot be null.");
			if(photoName == null) throw new IllegalArgumentException("\"photoName\" cannot be null.");
			
			return new PhotoSendingNoTarget(telegramBotApi, MediaIdentifier.byInputStream(photoInputStream, photoName));
		}
		
		/**
		 * Re-sends an existing photo.
		 * 
		 * @param photoId id of the photo to be re-sent
		 */
		public PhotoSendingNoTarget resendPhoto(String photoId)
		{
			if(photoId == null) throw new IllegalArgumentException("\"photoId\" cannot be null.");
			
			return new PhotoSendingNoTarget(telegramBotApi, MediaIdentifier.byId(photoId));
		}
		
		/**
		 * Sends an audio as a file. Telegram clients will display the audio file in the music player. Your audio
		 * must be in the .mp3 format. Bots can currently send audio files of up to 50 MB in size, this limit may
		 * be changed in the future.
		 *
		 * @param audioFile audio file to be sent
		 */
		public AudioSendingNoTarget sendAudio(File audioFile) throws FileNotFoundException
		{
			if(audioFile == null) throw new IllegalArgumentException("\"audioFile\" cannot be null.");
			
			return new AudioSendingNoTarget(telegramBotApi, MediaIdentifier.byFile(audioFile));
		}
		
		/**
		 * Sends an audio as an input stream. Telegram clients will display the audio file in the music player.
		 * Your audio must be in the .mp3 format. Bots can currently send audio files of up to 50 MB in size,
		 * this limit may be changed in the future.
		 *
		 * @param audioInputStream <code>InputStream</code> of the audio to be sent
		 * @param audioName to name the audio file
		 */
		public AudioSendingNoTarget sendAudio(InputStream audioInputStream, String audioName)
		{
			if(audioInputStream == null) throw new IllegalArgumentException("\"audioInputStream\" cannot be null.");
			if(audioName == null) throw new IllegalArgumentException("\"audioName\" cannot be null.");
			
			return new AudioSendingNoTarget(telegramBotApi, MediaIdentifier.byInputStream(audioInputStream, audioName));
		}
		
		/**
		 * Re-sends an existing audio. Telegram clients will display the audio file in the music player. Your audio
		 * must be in the .mp3 format. Bots can currently send audio files of up to 50 MB in size, this limit may
		 * be changed in the future.
		 *
		 * @param audioId id of the audio to be re-sent
		 */
		public AudioSendingNoTarget resendAudio(String audioId)
		{
			if(audioId == null) throw new IllegalArgumentException("\"audioId\" cannot be null.");
			
			return new AudioSendingNoTarget(telegramBotApi, MediaIdentifier.byId(audioId));
		}
		
		/**
		 * Sends a document as a file. Bots can currently send files of any type of up to 50 MB in size, this
		 * limit may be changed in the future.
		 *
		 * @param documentFile document file to be sent
		 */
		public DocumentSendingNoTarget sendDocument(File documentFile) throws FileNotFoundException
		{
			if(documentFile == null) throw new IllegalArgumentException("\"documentFile\" cannot be null.");
			
			return new DocumentSendingNoTarget(telegramBotApi, MediaIdentifier.byFile(documentFile));
		}
		
		/**
		 * Sends a document as an input stream. Bots can currently send files of any type of up to 50 MB in size,
		 * this limit may be changed in the future.
		 *
		 * @param documentInputStream <code>InputStream</code> of the document to be sent
		 * @param documentName to name the document file
		 */
		public DocumentSendingNoTarget sendDocument(InputStream documentInputStream, String documentName)
		{
			if(documentInputStream == null) throw new IllegalArgumentException("\"documentInputStream\" cannot be null.");
			if(documentName == null) throw new IllegalArgumentException("\"documentName\" cannot be null.");
			
			return new DocumentSendingNoTarget(telegramBotApi, MediaIdentifier.byInputStream(documentInputStream, documentName));
		}
		
		/**
		 * Re-sends an existing document. Bots can currently send files of any type of up to 50 MB in size, this
		 * limit may be changed in the future.
		 *
		 * @param documentId id of the document to be re-sent
		 */
		public DocumentSendingNoTarget resendDocument(String documentId)
		{
			if(documentId == null) throw new IllegalArgumentException("\"documentId\" cannot be null.");
			
			return new DocumentSendingNoTarget(telegramBotApi, MediaIdentifier.byId(documentId));
		}
		
		/**
		 * Sends a sticker as a .webp file.
		 *
		 * @param stickerFile sticker file to be sent
		 */
		public StickerSendingNoTarget sendSticker(File stickerFile) throws FileNotFoundException
		{
			if(stickerFile == null) throw new IllegalArgumentException("\"stickerFile\" cannot be null.");
			
			return new StickerSendingNoTarget(telegramBotApi, MediaIdentifier.byFile(stickerFile));
		}
		
		/**
		 * Sends a sticker as an input stream of .webp file.
		 *
		 * @param stickerInputStream <code>InputStream</code> of the sticker to be sent
		 * @param stickerName to name the sticker file
		 */
		public StickerSendingNoTarget sendSticker(InputStream stickerInputStream, String stickerName)
		{
			if(stickerInputStream == null) throw new IllegalArgumentException("\"stickerInputStream\" cannot be null.");
			if(stickerName == null) throw new IllegalArgumentException("\"stickerName\" cannot be null.");
			
			return new StickerSendingNoTarget(telegramBotApi, MediaIdentifier.byInputStream(stickerInputStream, stickerName));
		}
		
		/**
		 * Re-sends an existing sticker (.webp file).
		 *
		 * @param stickerId id of the sticker to be re-sent
		 */
		public StickerSendingNoTarget resendSticker(String stickerId)
		{
			if(stickerId == null) throw new IllegalArgumentException("\"stickerId\" cannot be null.");
			
			return new StickerSendingNoTarget(telegramBotApi, MediaIdentifier.byId(stickerId));
		}
		
		/**
		 * Sends a video as a file. Telegram clients support mp4 videos (other formats may be sent as Document).
		 * Bots can currently send video files of up to 50 MB in size, this limit may be changed in the future.
		 *
		 * @param videoFile video file to be sent
		 */
		public VideoSendingNoTarget sendVideo(File videoFile) throws FileNotFoundException
		{
			if(videoFile == null) throw new IllegalArgumentException("\"videoFile\" cannot be null.");
			
			return new VideoSendingNoTarget(telegramBotApi, MediaIdentifier.byFile(videoFile));
		}
		
		/**
		 * Sends a video as an input stream. Telegram clients support mp4 videos (other formats may be sent as
		 * Document). Bots can currently send video files of up to 50 MB in size, this limit may be changed in
		 * the future.
		 *
		 * @param videoInputStream <code>InputStream</code> of the video to be sent
		 * @param videoName to name the video file
		 */
		public VideoSendingNoTarget sendVideo(InputStream videoInputStream, String videoName)
		{
			if(videoInputStream == null) throw new IllegalArgumentException("\"videoInputStream\" cannot be null.");
			if(videoName == null) throw new IllegalArgumentException("\"videoName\" cannot be null.");
			
			return new VideoSendingNoTarget(telegramBotApi, MediaIdentifier.byInputStream(videoInputStream, videoName));
		}
		
		/**
		 * Re-sends an existing video. Telegram clients support mp4 videos (other formats may be sent as Document).
		 * Bots can currently send video files of up to 50 MB in size, this limit may be changed in the future.
		 *
		 * @param videoId id of the video to be re-sent
		 */
		public VideoSendingNoTarget resendVideo(String videoId)
		{
			if(videoId == null) throw new IllegalArgumentException("\"videoId\" cannot be null.");
			
			return new VideoSendingNoTarget(telegramBotApi, MediaIdentifier.byId(videoId));
		}
		
		/**
		 * Sends a voice as a file. Telegram clients will display it as playable voice message. For this to work,
		 * your audio must be in an .ogg file encoded with OPUS (other formats may be sent as Audio or Document).
		 * Bots can currently send voice messages of up to 50 MB in size, this limit may be changed in the future.
		 *
		 * @param voiceFile voice file to be sent
		 */
		public VoiceSendingNoTarget sendVoice(File voiceFile) throws FileNotFoundException
		{
			if(voiceFile == null) throw new IllegalArgumentException("\"voiceFile\" cannot be null.");
			
			return new VoiceSendingNoTarget(telegramBotApi, MediaIdentifier.byFile(voiceFile));
		}
		
		/**
		 * Sends a voice as an input stream. Telegram clients will display it as playable voice message. For this
		 * to work, your audio must be in an .ogg file encoded with OPUS (other formats may be sent as Audio or
		 * Document). Bots can currently send voice messages of up to 50 MB in size, this limit may be changed in
		 * the future.
		 *
		 * @param voiceInputStream <code>InputStream</code> of the voice to be sent
		 * @param voiceName to name the voice file
		 */
		public VoiceSendingNoTarget sendVoice(InputStream voiceInputStream, String voiceName)
		{
			if(voiceInputStream == null) throw new IllegalArgumentException("\"voiceInputStream\" cannot be null.");
			if(voiceName == null) throw new IllegalArgumentException("\"voiceName\" cannot be null.");
			
			return new VoiceSendingNoTarget(telegramBotApi, MediaIdentifier.byInputStream(voiceInputStream, voiceName));
		}
		
		/**
		 * Re-sends an existing voice. Telegram clients will display it as playable voice message. For this to work,
		 * your audio must be in an .ogg file encoded with OPUS (other formats may be sent as Audio or Document).
		 * Bots can currently send voice messages of up to 50 MB in size, this limit may be changed in the future.
		 *
		 * @param voiceId id of the voice to be re-sent
		 */
		public VoiceSendingNoTarget resendVoice(String voiceId)
		{
			if(voiceId == null) throw new IllegalArgumentException("\"voiceId\" cannot be null.");
			
			return new VoiceSendingNoTarget(telegramBotApi, MediaIdentifier.byId(voiceId));
		}
		
		/**
		 * Sends point on the map.
		 * 
		 * @param latitude latitude of location
		 * @param longitude longitude of location
		 */
		public LocationSendingNoTarget sendLocation(int latitude, int longitude)
		{
			return new LocationSendingNoTarget(telegramBotApi, latitude, longitude);
		}
		
		/**
		 * Use this method when you need to tell the user that something is happening on the bot's side.
		 * The status is set for 5 seconds or less (when a message arrives from your bot, Telegram clients
		 * clear its typing status).
		 * 
		 * @param chatAction the type of chat action to be sent
		 */
		public ChatActionSendingNoTarget sendChatAction(ChatAction chatAction)
		{
			if(chatAction == null) throw new IllegalArgumentException("\"chatAction\" cannot be null.");
			
			return new ChatActionSendingNoTarget(telegramBotApi, chatAction);
		}
		
		/**
		 * Gets a list of profile pictures for a user by his id.
		 * 
		 * @param userId the user id
		 */
		public UserProfilePhotosRetrieving getUserProfilePhotos(int userId)
		{
			return new UserProfilePhotosRetrieving(telegramBotApi, userId);
		}
		
		/**
		 * Gets a list of profile pictures for a <code>User</code>.
		 * 
		 * @param user the <code>User</code> object
		 */
		public UserProfilePhotosRetrieving getUserProfilePhotos(User user)
		{
			if(user == null) throw new IllegalArgumentException("\"user\" cannot be null.");
			
			return new UserProfilePhotosRetrieving(telegramBotApi, user.getId());
		}
		
		/**
		 * Gets basic info about a file and prepare it for downloading. For the moment, bots can download files
		 * of up to 20MB in size
		 *
		 * @param fileId file identifier to get info about
		 */
		public FileInfoRetrieving getFileInfo(String fileId)
		{
			if(fileId == null) throw new IllegalArgumentException("\"fileId\" cannot be null.");
			
			return new FileInfoRetrieving(telegramBotApi, fileId);
		}
		
		/**
		 * Downloads a Telegram file. For the moment, bots can download files of up to 20MB in size.
		 * 
		 * @param telegramFile the Telegram file to be downloaded
		 */
		public FileDownloadingNoOutputStream downloadFile(TelegramFile telegramFile)
		{
			if(telegramFile == null) throw new IllegalArgumentException("\"telegramFile\" cannot be null.");
			
			return new FileDownloadingNoOutputStream(telegramBotApi, telegramFile);
		}
		
		/**
		 * Kicks a user from a group or a supergroup. In the case of supergroups, the user will not be
		 * able to return to the group on their own using invite links, etc., unless unbanned first.
		 * The bot must be an administrator in the group for this to work.
		 * 
		 * @param userId id of user that would be kicked
		 */
		public KickingChatMemberNoTarget kickChatMember(int userId)
		{
			return new KickingChatMemberNoTarget(telegramBotApi, userId);
		}
		
		/**
		 * Use this method for your bot to leave a group, supergroup or channel.
		 */
		public LeavingChatNoTarget leaveChat()
		{
			return new LeavingChatNoTarget(telegramBotApi);
		}
		
		/**
		 * Unbans a previously kicked user in a supergroup. The user will not return to the group
		 * automatically, but will be able to join via link, etc. The bot must be an administrator
		 * in the group for this to work. 
		 *
		 * @param userId id of user that would be unbanned
		 */
		public UnbanningChatMemberNoTarget unbanChatMember(int userId)
		{
			return new UnbanningChatMemberNoTarget(telegramBotApi, userId);
		}
		
		/**
		 * Use this method to get up to date information about the chat (current name of the user for one-on-one
		 * conversations, current username of a user, group or channel, etc.).
		 */
		public GettingChatNoTarget getChat()
		{
			return new GettingChatNoTarget(telegramBotApi);
		}
		
		/**
		 * Use this method to get a list of administrators in a chat.
		 */
		public GettingChatAdministratorsNoTarget getChatAdministrators()
		{
			return new GettingChatAdministratorsNoTarget(telegramBotApi);
		}
		
		/**
		 * Use this method to get the number of members in a chat.
		 */
		public GettingChatMembersCountNoTarget getChatMembersCount()
		{
			return new GettingChatMembersCountNoTarget(telegramBotApi);
		}
		
		/**
		 * Use this method to get information about a member of a chat.
		 * 
		 * @param userId id of the user
		 */
		public GettingChatMemberNoTarget getChatMember(int userId)
		{
			return new GettingChatMemberNoTarget(telegramBotApi, userId);
		}
		
		/**
		 * Sends answer to callback query sent from inline keyboard. The answer will be displayed
		 * to the user as a notification at the top of the chat screen or as an alert.
		 */
		public AnsweringCallbackQueryNoId answerCallbackQuery()
		{
			return new AnsweringCallbackQueryNoId(telegramBotApi);
		}
		
		public EditingNormalMessageNoIdNoTarget editMessage()
		{
			return new EditingNormalMessageNoIdNoTarget(telegramBotApi);
		}
		
		public EditingInlineMessageNoId editInlineMessage()
		{
			return new EditingInlineMessageNoId(telegramBotApi);
		}
		
		/**
		 * Sends answers to an inline query.
		 */
		public AnsweringInlineQueryNoIdNoResults answerInlineQuery()
		{
			return new AnsweringInlineQueryNoIdNoResults(telegramBotApi);
		}
	}
	
	public static class AsUserReady
	{
		private TelegramBotApi telegramBotApi;
		
		private AsUserReady(TelegramBotApi telegramBotApi)
		{
			this.telegramBotApi = telegramBotApi;
		}
		
		/**
		 * Builds the request and sends it.
		 * 
		 * @return basic information about the bot in form of a <code>User</code> object
		 * 
		 * @throws IOException if an I/O exception occurs
		 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
		 */
		public User execute() throws IOException, NegativeResponseException
		{
			return telegramBotApi.getMe();
		}
	}
	
	public static class MessageSendingNoTarget
	{
		private TelegramBotApi telegramBotApi;
		private String text;
		
		private MessageSendingNoTarget(TelegramBotApi telegramBotApi, String text)
		{
			this.telegramBotApi = telegramBotApi;
			this.text = text;
		}
		
		/**
		 * sends the message to super-group or channel by using its @username.
		 * 
		 * @param chatUsername username of the super-group or the channel (syntax @username)
		 */
		public MessageSendingReady toChatUsername(String chatUsername)
		{
			if(chatUsername == null) throw new IllegalArgumentException("\"chatUsername\" cannot be null.");
			
			return new MessageSendingReady(telegramBotApi, ChatIdentifier.byUsername(chatUsername), text);
		}
		
		/**
		 * sends the message to any kind of chats by using its id.
		 *
		 * @param chatId chat id where the message will be sent to
		 */
		public MessageSendingReady toChatId(long chatId)
		{
			return new MessageSendingReady(telegramBotApi, ChatIdentifier.byId(chatId), text);
		}
	}
	
	public static class MessageSendingReady
	{
		private TelegramBotApi telegramBotApi;
		private ChatIdentifier targetChatIdentifier;
		private String text;
		private ParseMode parseMode;
		private Boolean disableLinkPreviews;
		private Boolean silentMessage;
		private Integer replyToMessageId;
		private ReplyMarkup replyMarkup;
		
		private MessageSendingReady(TelegramBotApi telegramBotApi, ChatIdentifier targetChatIdentifier, String text)
		{
			this.telegramBotApi = telegramBotApi;
			this.targetChatIdentifier = targetChatIdentifier;
			this.text = text;
		}
		
		/**
		 * Sends Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width
		 * text or inline URLs in your bot's message
		 * 
		 * @param parseMode either Markdown or HTML
		 */
		public MessageSendingReady parseMessageAs(ParseMode parseMode)
		{
			this.parseMode = parseMode;
			return this;
		}
		
		/**
		 * Disables link previews for links in this message.
		 */
		public MessageSendingReady disableLinkPreviews()
		{
			this.disableLinkPreviews = true;
			return this;
		}
		
		/**
		 * sends the message silently. iOS users will not receive a notification, Android
		 * users will receive a notification with no sound.
		 */
		public MessageSendingReady asSilentMessage()
		{
			this.silentMessage = true;
			return this;
		}
		
		/**
		 * Make this message a reply to another message.
		 * 
		 * @param messageId id of the message to be replied to
		 */
		public MessageSendingReady asReplyToMessage(int messageId)
		{
			this.replyToMessageId = messageId;
			return this;
		}
		
		/**
		 * Applies additional instructions to create/hide custom keyboard or to force a reply from the user.
		 * 
		 * @param replyMarkup use <code>io.fouad.jtb.core.builders.ReplyMarkupBuilder</code> build the <code>ReplyMarkup</code>
		 */
		public MessageSendingReady applyReplyMarkup(ReplyMarkup replyMarkup)
		{
			this.replyMarkup = replyMarkup;
			return this;
		}
		
		/**
		 * Builds the request and sends it.
		 *
		 * @return the sent <code>Message</code>
		 *
		 * @throws IOException if an I/O exception occurs
		 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
		 */
		public Message execute() throws IOException, NegativeResponseException
		{
			return telegramBotApi.sendMessage(targetChatIdentifier, text, parseMode, disableLinkPreviews, silentMessage, replyToMessageId, replyMarkup);
		}
	}
	
	public static class MessageForwardingNoSourceNoTarget
	{
		private TelegramBotApi telegramBotApi;
		private int messageId;
		
		private MessageForwardingNoSourceNoTarget(TelegramBotApi telegramBotApi, int messageId)
		{
			this.telegramBotApi = telegramBotApi;
			this.messageId = messageId;
		}
		
		/**
		 * forwards the message from super-group or channel by using its @username.
		 *
		 * @param chatUsername username of the super-group or the channel (syntax @username)
		 */
		public MessageForwardingNoTarget fromChatUsername(String chatUsername)
		{
			if(chatUsername == null) throw new IllegalArgumentException("\"chatUsername\" cannot be null.");
			
			return new MessageForwardingNoTarget(telegramBotApi, messageId, ChatIdentifier.byUsername(chatUsername));
		}
		
		/**
		 * forwards the message from any kind of chats by using its id.
		 *
		 * @param chatId chat id where the message will be sent to
		 */
		public MessageForwardingNoTarget fromChatId(long chatId)
		{
			return new MessageForwardingNoTarget(telegramBotApi, messageId, ChatIdentifier.byId(chatId));
		}
	}
	
	public static class MessageForwardingNoTarget
	{
		private TelegramBotApi telegramBotApi;
		private int messageId;
		private ChatIdentifier sourceChatIdentifier;
		
		private MessageForwardingNoTarget(TelegramBotApi telegramBotApi, int messageId, ChatIdentifier sourceChatIdentifier)
		{
			this.telegramBotApi = telegramBotApi;
			this.messageId = messageId;
			this.sourceChatIdentifier = sourceChatIdentifier;
		}
		
		/**
		 * forwards the message to super-group or channel by using its @username.
		 *
		 * @param chatUsername username of the super-group or the channel (syntax @username)
		 */
		public MessageForwardingReady toChatUsername(String chatUsername)
		{
			if(chatUsername == null) throw new IllegalArgumentException("\"chatUsername\" cannot be null.");
			
			return new MessageForwardingReady(telegramBotApi, messageId, sourceChatIdentifier, ChatIdentifier.byUsername(chatUsername));
		}
		
		/**
		 * forwards the message to any kind of chats by using its id.
		 *
		 * @param chatId chat id where the message will be forwarded to
		 */
		public MessageForwardingReady toChatId(long chatId)
		{
			return new MessageForwardingReady(telegramBotApi, messageId, sourceChatIdentifier, ChatIdentifier.byId(chatId));
		}
	}
	
	public static class MessageForwardingReady
	{
		private TelegramBotApi telegramBotApi;
		private int messageId;
		private ChatIdentifier sourceChatIdentifier;
		private ChatIdentifier targetChatIdentifier;
		private Boolean silentMessage;
		
		private MessageForwardingReady(TelegramBotApi telegramBotApi, int messageId, ChatIdentifier sourceChatIdentifier, ChatIdentifier targetChatIdentifier)
		{
			this.telegramBotApi = telegramBotApi;
			this.messageId = messageId;
			this.sourceChatIdentifier = sourceChatIdentifier;
			this.targetChatIdentifier = targetChatIdentifier;
		}
		
		/**
		 * sends the message silently. iOS users will not receive a notification, Android
		 * users will receive a notification with no sound.
		 */
		public MessageForwardingReady asSilentMessage()
		{
			this.silentMessage = true;
			return this;
		}
		
		/**
		 * Builds the request and sends it.
		 *
		 * @return the sent <code>Message</code>
		 *
		 * @throws IOException if an I/O exception occurs
		 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
		 */
		public Message execute() throws IOException, NegativeResponseException
		{
			return telegramBotApi.forwardMessage(targetChatIdentifier, sourceChatIdentifier, silentMessage, messageId);
		}
	}
	
	public static class PhotoSendingNoTarget
	{
		private TelegramBotApi telegramBotApi;
		private MediaIdentifier mediaIdentifier;
		
		private PhotoSendingNoTarget(TelegramBotApi telegramBotApi, MediaIdentifier mediaIdentifier)
		{
			this.telegramBotApi = telegramBotApi;
			this.mediaIdentifier = mediaIdentifier;
		}
		
		/**
		 * sends the message to super-group or channel by using its @username.
		 *
		 * @param chatUsername username of the super-group or the channel (syntax @username)
		 */
		public PhotoSendingReady toChatUsername(String chatUsername)
		{
			if(chatUsername == null) throw new IllegalArgumentException("\"chatUsername\" cannot be null.");
			
			return new PhotoSendingReady(telegramBotApi, mediaIdentifier, ChatIdentifier.byUsername(chatUsername));
		}
		
		/**
		 * sends the message to any kind of chats by using its id.
		 *
		 * @param chatId chat id where the message will be sent to
		 */
		public PhotoSendingReady toChatId(long chatId)
		{
			return new PhotoSendingReady(telegramBotApi, mediaIdentifier, ChatIdentifier.byId(chatId));
		}
	}
	
	public static class PhotoSendingReady
	{
		private TelegramBotApi telegramBotApi;
		private MediaIdentifier mediaIdentifier;
		private ChatIdentifier targetChatIdentifier;
		private String photoCaption;
		private Boolean silentMessage;
		private Integer replyToMessageId;
		private ReplyMarkup replyMarkup;
		
		private PhotoSendingReady(TelegramBotApi telegramBotApi, MediaIdentifier mediaIdentifier, ChatIdentifier targetChatIdentifier)
		{
			this.telegramBotApi = telegramBotApi;
			this.mediaIdentifier = mediaIdentifier;
			this.targetChatIdentifier = targetChatIdentifier;
		}
		
		/**
		 * Sets caption for the photo.
		 * 
		 * @param photoCaption photo caption, 0-200 characters
		 */
		public PhotoSendingReady withPhotoCaption(String photoCaption)
		{
			this.photoCaption = photoCaption;
			return this;
		}
		
		/**
		 * sends the message silently. iOS users will not receive a notification, Android
		 * users will receive a notification with no sound.
		 */
		public PhotoSendingReady asSilentMessage()
		{
			this.silentMessage = true;
			return this;
		}
		
		/**
		 * Make this message a reply to another message.
		 *
		 * @param messageId id of the message to be replied to
		 */
		public PhotoSendingReady asReplyToMessage(int messageId)
		{
			this.replyToMessageId = messageId;
			return this;
		}
		
		/**
		 * Applies additional instructions to create/hide custom keyboard or to force a reply from the user.
		 *
		 * @param replyMarkup use <code>io.fouad.jtb.core.builders.ReplyMarkupBuilder</code> to build <code>ReplyMarkup</code>
		 */
		public PhotoSendingReady applyReplyMarkup(ReplyMarkup replyMarkup)
		{
			this.replyMarkup = replyMarkup;
			return this;
		}
		
		/**
		 * Builds the request and sends it.
		 *
		 * @return the sent <code>Message</code>
		 *
		 * @throws IOException if an I/O exception occurs
		 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
		 */
		public Message execute() throws IOException, NegativeResponseException
		{
			return telegramBotApi.sendPhoto(targetChatIdentifier, mediaIdentifier, photoCaption, silentMessage, replyToMessageId, replyMarkup);
		}
	}
	
	public static class AudioSendingNoTarget
	{
		private TelegramBotApi telegramBotApi;
		private MediaIdentifier mediaIdentifier;
		
		private AudioSendingNoTarget(TelegramBotApi telegramBotApi, MediaIdentifier mediaIdentifier)
		{
			this.telegramBotApi = telegramBotApi;
			this.mediaIdentifier = mediaIdentifier;
		}
		
		/**
		 * sends the message to super-group or channel by using its @username.
		 * 
		 * @param chatUsername username of the super-group or the channel (syntax @username)
		 */
		public AudioSendingReady toChatUsername(String chatUsername)
		{
			if(chatUsername == null) throw new IllegalArgumentException("\"chatUsername\" cannot be null.");
			
			return new AudioSendingReady(telegramBotApi, mediaIdentifier, ChatIdentifier.byUsername(chatUsername));
		}
		
		/**
		 * sends the message to any kind of chats by using its id.
		 *
		 * @param chatId chat id where the message will be sent to
		 */
		public AudioSendingReady toChatId(long chatId)
		{
			return new AudioSendingReady(telegramBotApi, mediaIdentifier, ChatIdentifier.byId(chatId));
		}
	}
	
	public static class AudioSendingReady
	{
		private TelegramBotApi telegramBotApi;
		private MediaIdentifier mediaIdentifier;
		private ChatIdentifier targetChatIdentifier;
		private Integer duration;
		private String performer;
		private String title;
		private Boolean silentMessage;
		private Integer replyToMessageId;
		private ReplyMarkup replyMarkup;
		
		private AudioSendingReady(TelegramBotApi telegramBotApi, MediaIdentifier mediaIdentifier, ChatIdentifier targetChatIdentifier)
		{
			this.telegramBotApi = telegramBotApi;
			this.mediaIdentifier = mediaIdentifier;
			this.targetChatIdentifier = targetChatIdentifier;
		}
		
		/**
		 * Sets duration of the audio in seconds.
		 * 
		 * @param duration duration of the audio in seconds
		 */
		public AudioSendingReady withAudioDuration(int duration)
		{
			this.duration = duration;
			return this;
		}
		
		/**
		 * Sets the performer.
		 * 
		 * @param performer the performer
		 */
		public AudioSendingReady withAudioPerformer(String performer)
		{
			this.performer = performer;
			return this;
		}
		
		/**
		 * Sets the track title.
		 * 
		 * @param title the track title
		 */
		public AudioSendingReady withAudioTitle(String title)
		{
			this.title = title;
			return this;
		}
		
		/**
		 * sends the message silently. iOS users will not receive a notification, Android
		 * users will receive a notification with no sound.
		 */
		public AudioSendingReady asSilentMessage()
		{
			this.silentMessage = true;
			return this;
		}
		
		/**
		 * Make this message a reply to another message.
		 * 
		 * @param messageId id of the message to be replied to
		 */
		public AudioSendingReady asReplyToMessage(int messageId)
		{
			this.replyToMessageId = messageId;
			return this;
		}
		
		/**
		 * Applies additional instructions to create/hide custom keyboard or to force a reply from the user.
		 *
		 * @param replyMarkup use <code>io.fouad.jtb.core.builders.ReplyMarkupBuilder</code> to build <code>ReplyMarkup</code>
		 */
		public AudioSendingReady applyReplyMarkup(ReplyMarkup replyMarkup)
		{
			this.replyMarkup = replyMarkup;
			return this;
		}
		
		/**
		 * Builds the request and sends it.
		 *
		 * @return the sent <code>Message</code>
		 *
		 * @throws IOException if an I/O exception occurs
		 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
		 */
		public Message execute() throws IOException, NegativeResponseException
		{
			return telegramBotApi.sendAudio(targetChatIdentifier, mediaIdentifier, duration, performer, title, silentMessage, replyToMessageId, replyMarkup);
		}
	}
	
	public static class DocumentSendingNoTarget
	{
		private TelegramBotApi telegramBotApi;
		private MediaIdentifier mediaIdentifier;
		
		private DocumentSendingNoTarget(TelegramBotApi telegramBotApi, MediaIdentifier mediaIdentifier)
		{
			this.telegramBotApi = telegramBotApi;
			this.mediaIdentifier = mediaIdentifier;
		}
		
		/**
		 * sends the message to super-group or channel by using its @username.
		 * 
		 * @param chatUsername username of the super-group or the channel (syntax @username)
		 */
		public DocumentSendingReady toChatUsername(String chatUsername)
		{
			if(chatUsername == null) throw new IllegalArgumentException("\"chatUsername\" cannot be null.");
			
			return new DocumentSendingReady(telegramBotApi, mediaIdentifier, ChatIdentifier.byUsername(chatUsername));
		}
		
		/**
		 * sends the message to any kind of chats by using its id.
		 *
		 * @param chatId chat id where the message will be sent to
		 */
		public DocumentSendingReady toChatId(long chatId)
		{
			return new DocumentSendingReady(telegramBotApi, mediaIdentifier, ChatIdentifier.byId(chatId));
		}
	}
	
	public static class DocumentSendingReady
	{
		private TelegramBotApi telegramBotApi;
		private MediaIdentifier mediaIdentifier;
		private ChatIdentifier targetChatIdentifier;
		private String documentCaption;
		private Boolean silentMessage;
		private Integer replyToMessageId;
		private ReplyMarkup replyMarkup;
		
		private DocumentSendingReady(TelegramBotApi telegramBotApi, MediaIdentifier mediaIdentifier, ChatIdentifier targetChatIdentifier)
		{
			this.telegramBotApi = telegramBotApi;
			this.mediaIdentifier = mediaIdentifier;
			this.targetChatIdentifier = targetChatIdentifier;
		}
		
		/**
		 * Sets document caption, 0-200 characters.
		 * 
		 * @param documentCaption the document caption
		 */
		public DocumentSendingReady withDocumentCaption(String documentCaption)
		{
			this.documentCaption = documentCaption;
			return this;
		}
		
		/**
		 * sends the message silently. iOS users will not receive a notification, Android
		 * users will receive a notification with no sound.
		 */
		public DocumentSendingReady asSilentMessage()
		{
			this.silentMessage = true;
			return this;
		}
		
		/**
		 * Make this message a reply to another message.
		 * 
		 * @param messageId id of the message to be replied to
		 */
		public DocumentSendingReady asReplyToMessage(int messageId)
		{
			this.replyToMessageId = messageId;
			return this;
		}
		
		/**
		 * Applies additional instructions to create/hide custom keyboard or to force a reply from the user.
		 *
		 * @param replyMarkup use <code>io.fouad.jtb.core.builders.ReplyMarkupBuilder</code> to build <code>ReplyMarkup</code>
		 */
		public DocumentSendingReady applyReplyMarkup(ReplyMarkup replyMarkup)
		{
			this.replyMarkup = replyMarkup;
			return this;
		}
		
		/**
		 * Builds the request and sends it.
		 *
		 * @return the sent <code>Message</code>
		 *
		 * @throws IOException if an I/O exception occurs
		 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
		 */
		public Message execute() throws IOException, NegativeResponseException
		{
			return telegramBotApi.sendDocument(targetChatIdentifier, mediaIdentifier, documentCaption, silentMessage, replyToMessageId, replyMarkup);
		}
	}
	
	public static class StickerSendingNoTarget
	{
		private TelegramBotApi telegramBotApi;
		private MediaIdentifier mediaIdentifier;
		
		private StickerSendingNoTarget(TelegramBotApi telegramBotApi, MediaIdentifier mediaIdentifier)
		{
			this.telegramBotApi = telegramBotApi;
			this.mediaIdentifier = mediaIdentifier;
		}
		
		/**
		 * sends the message to super-group or channel by using its @username.
		 * 
		 * @param chatUsername username of the super-group or the channel (syntax @username)
		 */
		public StickerSendingReady toChatUsername(String chatUsername)
		{
			if(chatUsername == null) throw new IllegalArgumentException("\"chatUsername\" cannot be null.");
			
			return new StickerSendingReady(telegramBotApi, mediaIdentifier, ChatIdentifier.byUsername(chatUsername));
		}
		
		/**
		 * sends the message to any kind of chats by using its id.
		 *
		 * @param chatId chat id where the message will be sent to
		 */
		public StickerSendingReady toChatId(long chatId)
		{
			return new StickerSendingReady(telegramBotApi, mediaIdentifier, ChatIdentifier.byId(chatId));
		}
	}
	
	public static class StickerSendingReady
	{
		private TelegramBotApi telegramBotApi;
		private MediaIdentifier mediaIdentifier;
		private ChatIdentifier targetChatIdentifier;
		private Boolean silentMessage;
		private Integer replyToMessageId;
		private ReplyMarkup replyMarkup;
		
		private StickerSendingReady(TelegramBotApi telegramBotApi, MediaIdentifier mediaIdentifier, ChatIdentifier targetChatIdentifier)
		{
			this.telegramBotApi = telegramBotApi;
			this.mediaIdentifier = mediaIdentifier;
			this.targetChatIdentifier = targetChatIdentifier;
		}
		
		/**
		 * sends the message silently. iOS users will not receive a notification, Android
		 * users will receive a notification with no sound.
		 */
		public StickerSendingReady asSilentMessage()
		{
			this.silentMessage = true;
			return this;
		}
		
		/**
		 * Make this message a reply to another message.
		 * 
		 * @param messageId id of the message to be replied to
		 */
		public StickerSendingReady asReplyToMessage(int messageId)
		{
			this.replyToMessageId = messageId;
			return this;
		}
		
		/**
		 * Applies additional instructions to create/hide custom keyboard or to force a reply from the user.
		 *
		 * @param replyMarkup use <code>io.fouad.jtb.core.builders.ReplyMarkupBuilder</code> to build <code>ReplyMarkup</code>
		 */
		public StickerSendingReady applyReplyMarkup(ReplyMarkup replyMarkup)
		{
			this.replyMarkup = replyMarkup;
			return this;
		}
		
		/**
		 * Builds the request and sends it.
		 *
		 * @return the sent <code>Message</code>
		 *
		 * @throws IOException if an I/O exception occurs
		 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
		 */
		public Message execute() throws IOException, NegativeResponseException
		{
			return telegramBotApi.sendSticker(targetChatIdentifier, mediaIdentifier, silentMessage, replyToMessageId, replyMarkup);
		}
	}
	
	public static class VideoSendingNoTarget
	{
		private TelegramBotApi telegramBotApi;
		private MediaIdentifier mediaIdentifier;
		
		private VideoSendingNoTarget(TelegramBotApi telegramBotApi, MediaIdentifier mediaIdentifier)
		{
			this.telegramBotApi = telegramBotApi;
			this.mediaIdentifier = mediaIdentifier;
		}
		
		/**
		 * sends the message to super-group or channel by using its @username.
		 * 
		 * @param chatUsername username of the super-group or the channel (syntax @username)
		 */
		public VideoSendingReady toChatUsername(String chatUsername)
		{
			if(chatUsername == null) throw new IllegalArgumentException("\"chatUsername\" cannot be null.");
			
			return new VideoSendingReady(telegramBotApi, mediaIdentifier, ChatIdentifier.byUsername(chatUsername));
		}
		
		/**
		 * sends the message to any kind of chats by using its id.
		 *
		 * @param chatId chat id where the message will be sent to
		 */
		public VideoSendingReady toChatId(long chatId)
		{
			return new VideoSendingReady(telegramBotApi, mediaIdentifier, ChatIdentifier.byId(chatId));
		}
	}
	
	public static class VideoSendingReady
	{
		private TelegramBotApi telegramBotApi;
		private MediaIdentifier mediaIdentifier;
		private ChatIdentifier targetChatIdentifier;
		private Integer duration;
		private Integer width;
		private Integer height;
		private String videoCaption;
		private Boolean silentMessage;
		private Integer replyToMessageId;
		private ReplyMarkup replyMarkup;
		
		private VideoSendingReady(TelegramBotApi telegramBotApi, MediaIdentifier mediaIdentifier, ChatIdentifier targetChatIdentifier)
		{
			this.telegramBotApi = telegramBotApi;
			this.mediaIdentifier = mediaIdentifier;
			this.targetChatIdentifier = targetChatIdentifier;
		}
		
		/**
		 * Sets the video duration.
		 * 
		 * @param duration the video duration in seconds
		 */
		public VideoSendingReady withVideoDuration(int duration)
		{
			this.duration = duration;
			return this;
		}
		
		/**
		 * Sets the video width.
		 * 
		 * @param width video width
		 */
		public VideoSendingReady withVideoWidth(int width)
		{
			this.width = width;
			return this;
		}
		
		/**
		 * Sets the video height.
		 * 
		 * @param height video height
		 */
		public VideoSendingReady withVideoHeight(int height)
		{
			this.height = height;
			return this;
		}
		
		/**
		 * Sets video caption, 0-200 characters.
		 * 
		 * @param videoCaption the video caption
		 */
		public VideoSendingReady withVideoCaption(String videoCaption)
		{
			this.videoCaption = videoCaption;
			return this;
		}
		
		/**
		 * sends the message silently. iOS users will not receive a notification, Android
		 * users will receive a notification with no sound.
		 */
		public VideoSendingReady asSilentMessage()
		{
			this.silentMessage = true;
			return this;
		}
		
		/**
		 * Make this message a reply to another message.
		 * 
		 * @param messageId id of the message to be replied to
		 */
		public VideoSendingReady asReplyToMessage(int messageId)
		{
			this.replyToMessageId = messageId;
			return this;
		}
		
		/**
		 * Applies additional instructions to create/hide custom keyboard or to force a reply from the user.
		 *
		 * @param replyMarkup use <code>io.fouad.jtb.core.builders.ReplyMarkupBuilder</code> to build <code>ReplyMarkup</code>
		 */
		public VideoSendingReady applyReplyMarkup(ReplyMarkup replyMarkup)
		{
			this.replyMarkup = replyMarkup;
			return this;
		}
		
		/**
		 * Builds the request and sends it.
		 *
		 * @return the sent <code>Message</code>
		 *
		 * @throws IOException if an I/O exception occurs
		 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
		 */
		public Message execute() throws IOException, NegativeResponseException
		{
			return telegramBotApi.sendVideo(targetChatIdentifier, mediaIdentifier, duration, width, height, videoCaption, silentMessage, replyToMessageId, replyMarkup);
		}
	}
	
	public static class VoiceSendingNoTarget
	{
		private TelegramBotApi telegramBotApi;
		private MediaIdentifier mediaIdentifier;
		
		private VoiceSendingNoTarget(TelegramBotApi telegramBotApi, MediaIdentifier mediaIdentifier)
		{
			this.telegramBotApi = telegramBotApi;
			this.mediaIdentifier = mediaIdentifier;
		}
		
		/**
		 * sends the message to super-group or channel by using its @username.
		 * 
		 * @param chatUsername username of the super-group or the channel (syntax @username)
		 */
		public VoiceSendingReady toChatUsername(String chatUsername)
		{
			if(chatUsername == null) throw new IllegalArgumentException("\"chatUsername\" cannot be null.");
			
			return new VoiceSendingReady(telegramBotApi, mediaIdentifier, ChatIdentifier.byUsername(chatUsername));
		}
		
		/**
		 * sends the message to any kind of chats by using its id.
		 *
		 * @param chatId chat id where the message will be sent to
		 */
		public VoiceSendingReady toChatId(long chatId)
		{
			return new VoiceSendingReady(telegramBotApi, mediaIdentifier, ChatIdentifier.byId(chatId));
		}
	}
	
	public static class VoiceSendingReady
	{
		private TelegramBotApi telegramBotApi;
		private MediaIdentifier mediaIdentifier;
		private ChatIdentifier targetChatIdentifier;
		private Integer duration;
		private Boolean silentMessage;
		private Integer replyToMessageId;
		private ReplyMarkup replyMarkup;
		
		private VoiceSendingReady(TelegramBotApi telegramBotApi, MediaIdentifier mediaIdentifier, ChatIdentifier targetChatIdentifier)
		{
			this.telegramBotApi = telegramBotApi;
			this.mediaIdentifier = mediaIdentifier;
			this.targetChatIdentifier = targetChatIdentifier;
		}
		
		/**
		 * Sets duration of sent audio in seconds.
		 * 
		 * @param duration the voice duration
		 */
		public VoiceSendingReady withVoiceDuration(int duration)
		{
			this.duration = duration;
			return this;
		}
		
		/**
		 * sends the message silently. iOS users will not receive a notification, Android
		 * users will receive a notification with no sound.
		 */
		public VoiceSendingReady asSilentMessage()
		{
			this.silentMessage = true;
			return this;
		}
		
		/**
		 * Make this message a reply to another message.
		 * 
		 * @param messageId id of the message to be replied to
		 */
		public VoiceSendingReady asReplyToMessage(int messageId)
		{
			this.replyToMessageId = messageId;
			return this;
		}
		
		/**
		 * Applies additional instructions to create/hide custom keyboard or to force a reply from the user.
		 *
		 * @param replyMarkup use <code>io.fouad.jtb.core.builders.ReplyMarkupBuilder</code> to build <code>ReplyMarkup</code>
		 */
		public VoiceSendingReady applyReplyMarkup(ReplyMarkup replyMarkup)
		{
			this.replyMarkup = replyMarkup;
			return this;
		}
		
		/**
		 * Builds the request and sends it.
		 *
		 * @return the sent <code>Message</code>
		 *
		 * @throws IOException if an I/O exception occurs
		 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
		 */
		public Message execute() throws IOException, NegativeResponseException
		{
			return telegramBotApi.sendVoice(targetChatIdentifier, mediaIdentifier, duration, silentMessage, replyToMessageId, replyMarkup);
		}
	}
	
	public static class LocationSendingNoTarget
	{
		private TelegramBotApi telegramBotApi;
		private int latitude;
		private int longitude;
		
		private LocationSendingNoTarget(TelegramBotApi telegramBotApi, int latitude, int longitude)
		{
			this.telegramBotApi = telegramBotApi;
			this.latitude = latitude;
			this.longitude = longitude;
		}
		
		/**
		 * sends the message to super-group or channel by using its @username.
		 * 
		 * @param chatUsername username of the super-group or the channel (syntax @username)
		 */
		public LocationSendingReady toChatUsername(String chatUsername)
		{
			if(chatUsername == null) throw new IllegalArgumentException("\"chatUsername\" cannot be null.");
			
			return new LocationSendingReady(telegramBotApi, ChatIdentifier.byUsername(chatUsername), latitude, longitude);
		}
		
		/**
		 * sends the message to any kind of chats by using its id.
		 *
		 * @param chatId chat id where the message will be sent to
		 */
		public LocationSendingReady toChatId(long chatId)
		{
			return new LocationSendingReady(telegramBotApi, ChatIdentifier.byId(chatId), latitude, longitude);
		}
	}
	
	public static class LocationSendingReady
	{
		private TelegramBotApi telegramBotApi;
		private ChatIdentifier targetChatIdentifier;
		private int latitude;
		private int longitude;
		private Boolean silentMessage;
		private Integer replyToMessageId;
		private ReplyMarkup replyMarkup;
		
		private LocationSendingReady(TelegramBotApi telegramBotApi, ChatIdentifier targetChatIdentifier, int latitude, int longitude)
		{
			this.telegramBotApi = telegramBotApi;
			this.targetChatIdentifier = targetChatIdentifier;
			this.latitude = latitude;
			this.longitude = longitude;
		}
		
		/**
		 * sends the message silently. iOS users will not receive a notification, Android
		 * users will receive a notification with no sound.
		 */
		public LocationSendingReady asSilentMessage()
		{
			this.silentMessage = true;
			return this;
		}
		
		/**
		 * Make this message a reply to another message.
		 * 
		 * @param messageId id of the message to be replied to
		 */
		public LocationSendingReady asReplyToMessage(int messageId)
		{
			this.replyToMessageId = messageId;
			return this;
		}
		
		/**
		 * Applies additional instructions to create/hide custom keyboard or to force a reply from the user.
		 *
		 * @param replyMarkup use <code>io.fouad.jtb.core.builders.ReplyMarkupBuilder</code> to build <code>ReplyMarkup</code>
		 */
		public LocationSendingReady applyReplyMarkup(ReplyMarkup replyMarkup)
		{
			this.replyMarkup = replyMarkup;
			return this;
		}
		
		/**
		 * Builds the request and sends it.
		 *
		 * @return the sent <code>Message</code>
		 *
		 * @throws IOException if an I/O exception occurs
		 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
		 */
		public Message execute() throws IOException, NegativeResponseException
		{
			return telegramBotApi.sendLocation(targetChatIdentifier, latitude, longitude, silentMessage, replyToMessageId, replyMarkup);
		}
	}
	
	public static class ChatActionSendingNoTarget
	{
		private TelegramBotApi telegramBotApi;
		private ChatAction chatAction;
		
		private ChatActionSendingNoTarget(TelegramBotApi telegramBotApi, ChatAction chatAction)
		{
			this.telegramBotApi = telegramBotApi;
			this.chatAction = chatAction;
		}
		
		/**
		 * sends the message to super-group or channel by using its @username.
		 * 
		 * @param chatUsername username of the super-group or the channel (syntax @username)
		 */
		public ChatActionSendingReady toChatUsername(String chatUsername)
		{
			if(chatUsername == null) throw new IllegalArgumentException("\"chatUsername\" cannot be null.");
			
			return new ChatActionSendingReady(telegramBotApi, ChatIdentifier.byUsername(chatUsername), chatAction);
		}
		
		/**
		 * sends the message to any kind of chats by using its id.
		 *
		 * @param chatId chat id where the message will be sent to
		 */
		public ChatActionSendingReady toChatId(long chatId)
		{
			return new ChatActionSendingReady(telegramBotApi, ChatIdentifier.byId(chatId), chatAction);
		}
	}
	
	public static class ChatActionSendingReady
	{
		private TelegramBotApi telegramBotApi;
		private ChatIdentifier targetChatIdentifier;
		private ChatAction chatAction;
		
		private ChatActionSendingReady(TelegramBotApi telegramBotApi, ChatIdentifier targetChatIdentifier, ChatAction chatAction)
		{
			this.telegramBotApi = telegramBotApi;
			this.targetChatIdentifier = targetChatIdentifier;
			this.chatAction = chatAction;
		}
		
		/**
		 * Builds the request and sends it.
		 *
		 * @throws IOException if an I/O exception occurs
		 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
		 */
		public void execute() throws IOException, NegativeResponseException
		{
			telegramBotApi.sendChatAction(targetChatIdentifier, chatAction);
		}
	}
	
	public static class UserProfilePhotosRetrieving
	{
		private TelegramBotApi telegramBotApi;
		private int userId;
		private Integer offset;
		private Integer limit;
		
		public UserProfilePhotosRetrieving(TelegramBotApi telegramBotApi, int userId)
		{
			this.telegramBotApi = telegramBotApi;
			this.userId = userId;
		}
		
		/**
		 * Sets the offset.
		 * 
		 * @param offset sequential number of the first photo to be returned. By default, all photos are returned
		 */
		public UserProfilePhotosRetrieving withOffset(int offset)
		{
			this.offset = offset;
			return this;
		}
		
		/**
		 * limits the number of photos to be retrieved. Values between 1—100 are accepted. Defaults to 100.
		 * 
		 * @param limit the limit value
		 */
		public UserProfilePhotosRetrieving withLimit(int limit)
		{
			this.limit = limit;
			return this;
		}
		
		/**
		 * Builds the request and sends it.
		 * 
		 * @return <code>UserProfilePhotos</code> object containing list of photos
		 *
		 * @throws IOException if an I/O exception occurs
		 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
		 */
		public UserProfilePhotos execute() throws IOException, NegativeResponseException
		{
			return telegramBotApi.getUserProfilePhotos(userId, offset, limit);
		}
	}
	
	public static class FileInfoRetrieving
	{
		private TelegramBotApi telegramBotApi;
		private String fileId;
		
		public FileInfoRetrieving(TelegramBotApi telegramBotApi, String fileId)
		{
			this.telegramBotApi = telegramBotApi;
			this.fileId = fileId;
		}
		
		/**
		 * Builds the request and sends it.
		 *
		 * @return <code>TelegramFile</code> object containing basic info about the file
		 *
		 * @throws IOException if an I/O exception occurs
		 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
		 */
		public TelegramFile execute() throws IOException, NegativeResponseException
		{
			return telegramBotApi.getFile(fileId);
		}
	}
	
	public static class FileDownloadingNoOutputStream
	{
		private TelegramBotApi telegramBotApi;
		private TelegramFile file;
		
		public FileDownloadingNoOutputStream(TelegramBotApi telegramBotApi, TelegramFile file)
		{
			this.telegramBotApi = telegramBotApi;
			this.file = file;
		}
		
		/**
		 * Saves the file to an output stream.
		 * 
		 * @param outputStream the output stream where the file will be saved/streamed
		 */
		public FileDownloadingReady saveToOutputStream(OutputStream outputStream)
		{
			return new FileDownloadingReady(telegramBotApi, file, outputStream);
		}
	}
	
	public static class FileDownloadingReady
	{
		private TelegramBotApi telegramBotApi;
		private TelegramFile file;
		private OutputStream saveToOutputStream;
		
		public FileDownloadingReady(TelegramBotApi telegramBotApi, TelegramFile file, OutputStream saveToOutputStream)
		{
			this.telegramBotApi = telegramBotApi;
			this.file = file;
			this.saveToOutputStream = saveToOutputStream;
		}
		
		/**
		 * Begins downloading the file.
		 *
		 * @throws IOException if an I/O exception occurs
		 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
		 */
		public void execute() throws IOException, NegativeResponseException
		{
			String fileUrl = TelegramBotApi.FILE_API_URL_PREFIX + telegramBotApi.getApiToken() + "/" + file.getFilePath();
			HttpClient.downloadFile(fileUrl, saveToOutputStream);
		}
	}
	
	public static class KickingChatMemberNoTarget
	{
		private TelegramBotApi telegramBotApi;
		private int userId;
		
		public KickingChatMemberNoTarget(TelegramBotApi telegramBotApi, int userId)
		{
			this.telegramBotApi = telegramBotApi;
			this.userId = userId;
		}
		
		/**
		 * Kicks chat member from super-group by super-group username (@supergroupusername)
		 *
		 * @param chatUsername username of the super-group (syntax @supergroupusername)
		 */
		public KickingChatMemberReady toChatUsername(String chatUsername)
		{
			if(chatUsername == null) throw new IllegalArgumentException("\"chatUsername\" cannot be null.");
			
			return new KickingChatMemberReady(telegramBotApi, userId, ChatIdentifier.byUsername(chatUsername));
		}
		
		/**
		 * Kicks chat member from group or super-group by using its id.
		 *
		 * @param chatId chat id of the group or super-group
		 */
		public KickingChatMemberReady toChatId(long chatId)
		{
			return new KickingChatMemberReady(telegramBotApi, userId, ChatIdentifier.byId(chatId));
		}
	}
	
	public static class KickingChatMemberReady
	{
		private TelegramBotApi telegramBotApi;
		private int userId;
		private ChatIdentifier targetChatIdentifier;
		
		public KickingChatMemberReady(TelegramBotApi telegramBotApi, int userId, ChatIdentifier targetChatIdentifier)
		{
			this.telegramBotApi = telegramBotApi;
			this.userId = userId;
			this.targetChatIdentifier = targetChatIdentifier;
		}
		
		/**
		 * Builds the request and sends it.
		 *
		 * @return <code>true</code> on success
		 *
		 * @throws IOException if an I/O exception occurs
		 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
		 */
		public boolean execute() throws IOException, NegativeResponseException
		{
			return telegramBotApi.kickChatMember(targetChatIdentifier, userId);
		}
	}
	
	public static class LeavingChatNoTarget
	{
		private TelegramBotApi telegramBotApi;
		
		public LeavingChatNoTarget(TelegramBotApi telegramBotApi)
		{
			this.telegramBotApi = telegramBotApi;
		}
		
		/**
		 * leaves chat by super-group username (@supergroupusername)
		 *
		 * @param chatUsername username of the super-group (syntax @supergroupusername)
		 */
		public LeavingChatReady byChatUsername(String chatUsername)
		{
			if(chatUsername == null) throw new IllegalArgumentException("\"chatUsername\" cannot be null.");
			
			return new LeavingChatReady(telegramBotApi, ChatIdentifier.byUsername(chatUsername));
		}
		
		/**
		 * leaves chat by id of group or super-group.
		 *
		 * @param chatId chat id of the group or super-group
		 */
		public LeavingChatReady byChatId(long chatId)
		{
			return new LeavingChatReady(telegramBotApi, ChatIdentifier.byId(chatId));
		}
	}
	
	public static class LeavingChatReady
	{
		private TelegramBotApi telegramBotApi;
		private ChatIdentifier targetChatIdentifier;
		
		public LeavingChatReady(TelegramBotApi telegramBotApi, ChatIdentifier targetChatIdentifier)
		{
			this.telegramBotApi = telegramBotApi;
			this.targetChatIdentifier = targetChatIdentifier;
		}
		
		/**
		 * Builds the request and sends it.
		 *
		 * @return <code>true</code> on success
		 *
		 * @throws IOException if an I/O exception occurs
		 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
		 */
		public boolean execute() throws IOException, NegativeResponseException
		{
			return telegramBotApi.leaveChat(targetChatIdentifier);
		}
	}
	
	public static class UnbanningChatMemberNoTarget
	{
		private TelegramBotApi telegramBotApi;
		private int userId;
		
		public UnbanningChatMemberNoTarget(TelegramBotApi telegramBotApi, int userId)
		{
			this.telegramBotApi = telegramBotApi;
			this.userId = userId;
		}
		
		/**
		 * Unbans chat member from super-group by super-group username (@supergroupusername)
		 *
		 * @param chatUsername username of the super-group (syntax @supergroupusername)
		 */
		public UnbanningChatMemberReady toChatUsername(String chatUsername)
		{
			if(chatUsername == null) throw new IllegalArgumentException("\"chatUsername\" cannot be null.");
			
			return new UnbanningChatMemberReady(telegramBotApi, userId, ChatIdentifier.byUsername(chatUsername));
		}
		
		/**
		 * Unbans chat member from group or super-group by using its id.
		 *
		 * @param chatId chat id of the group or super-group
		 */
		public UnbanningChatMemberReady toChatId(long chatId)
		{
			return new UnbanningChatMemberReady(telegramBotApi, userId, ChatIdentifier.byId(chatId));
		}
	}
	
	public static class UnbanningChatMemberReady
	{
		private TelegramBotApi telegramBotApi;
		private int userId;
		private ChatIdentifier targetChatIdentifier;
		
		public UnbanningChatMemberReady(TelegramBotApi telegramBotApi, int userId, ChatIdentifier targetChatIdentifier)
		{
			this.telegramBotApi = telegramBotApi;
			this.userId = userId;
			this.targetChatIdentifier = targetChatIdentifier;
		}
		
		/**
		 * Builds the request and sends it.
		 *
		 * @return <code>true</code> on success
		 *
		 * @throws IOException if an I/O exception occurs
		 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
		 */
		public boolean execute() throws IOException, NegativeResponseException
		{
			return telegramBotApi.unbanChatMember(targetChatIdentifier, userId);
		}
	}
	
	public static class GettingChatNoTarget
	{
		private TelegramBotApi telegramBotApi;
		
		public GettingChatNoTarget(TelegramBotApi telegramBotApi)
		{
			this.telegramBotApi = telegramBotApi;
		}
		
		/**
		 * gets chat by super-group username (@supergroupusername)
		 *
		 * @param chatUsername username of the super-group (syntax @supergroupusername)
		 */
		public GettingChatReady byChatUsername(String chatUsername)
		{
			if(chatUsername == null) throw new IllegalArgumentException("\"chatUsername\" cannot be null.");
			
			return new GettingChatReady(telegramBotApi, ChatIdentifier.byUsername(chatUsername));
		}
		
		/**
		 * gets chat by id of group or super-group.
		 *
		 * @param chatId chat id of the group or super-group
		 */
		public GettingChatReady byChatId(long chatId)
		{
			return new GettingChatReady(telegramBotApi, ChatIdentifier.byId(chatId));
		}
	}
	
	public static class GettingChatReady
	{
		private TelegramBotApi telegramBotApi;
		private ChatIdentifier targetChatIdentifier;
		
		public GettingChatReady(TelegramBotApi telegramBotApi, ChatIdentifier targetChatIdentifier)
		{
			this.telegramBotApi = telegramBotApi;
			this.targetChatIdentifier = targetChatIdentifier;
		}
		
		/**
		 * Builds the request and sends it.
		 *
		 * @return <code>Chat</code> object on success
		 *
		 * @throws IOException if an I/O exception occurs
		 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
		 */
		public Chat execute() throws IOException, NegativeResponseException
		{
			return telegramBotApi.getChat(targetChatIdentifier);
		}
	}
	
	public static class GettingChatAdministratorsNoTarget
	{
		private TelegramBotApi telegramBotApi;
		
		public GettingChatAdministratorsNoTarget(TelegramBotApi telegramBotApi)
		{
			this.telegramBotApi = telegramBotApi;
		}
		
		/**
		 * gets administrators of chat by super-group username (@supergroupusername)
		 *
		 * @param chatUsername username of the super-group (syntax @supergroupusername)
		 */
		public GettingChatAdministratorsReady ofChatUsername(String chatUsername)
		{
			if(chatUsername == null) throw new IllegalArgumentException("\"chatUsername\" cannot be null.");
			
			return new GettingChatAdministratorsReady(telegramBotApi, ChatIdentifier.byUsername(chatUsername));
		}
		
		/**
		 * gets administrators of chat by id of group or super-group.
		 *
		 * @param chatId chat id of the group or super-group
		 */
		public GettingChatAdministratorsReady ofChatId(long chatId)
		{
			return new GettingChatAdministratorsReady(telegramBotApi, ChatIdentifier.byId(chatId));
		}
	}
	
	public static class GettingChatAdministratorsReady
	{
		private TelegramBotApi telegramBotApi;
		private ChatIdentifier targetChatIdentifier;
		
		public GettingChatAdministratorsReady(TelegramBotApi telegramBotApi, ChatIdentifier targetChatIdentifier)
		{
			this.telegramBotApi = telegramBotApi;
			this.targetChatIdentifier = targetChatIdentifier;
		}
		
		/**
		 * Builds the request and sends it.
		 *
		 * @return array of <code>ChatMember</code> objects on success
		 *
		 * @throws IOException if an I/O exception occurs
		 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
		 */
		public ChatMember[] execute() throws IOException, NegativeResponseException
		{
			return telegramBotApi.getChatAdministrators(targetChatIdentifier);
		}
	}
	
	public static class GettingChatMembersCountNoTarget
	{
		private TelegramBotApi telegramBotApi;
		
		public GettingChatMembersCountNoTarget(TelegramBotApi telegramBotApi)
		{
			this.telegramBotApi = telegramBotApi;
		}
		
		/**
		 * gets chat member count of chat by super-group username (@supergroupusername)
		 *
		 * @param chatUsername username of the super-group (syntax @supergroupusername)
		 */
		public GettingChatMembersCountReady ofChatUsername(String chatUsername)
		{
			if(chatUsername == null) throw new IllegalArgumentException("\"chatUsername\" cannot be null.");
			
			return new GettingChatMembersCountReady(telegramBotApi, ChatIdentifier.byUsername(chatUsername));
		}
		
		/**
		 * gets chat member count of chat by id of group or super-group.
		 *
		 * @param chatId chat id of the group or super-group
		 */
		public GettingChatMembersCountReady ofChatId(long chatId)
		{
			return new GettingChatMembersCountReady(telegramBotApi, ChatIdentifier.byId(chatId));
		}
	}
	
	public static class GettingChatMembersCountReady
	{
		private TelegramBotApi telegramBotApi;
		private ChatIdentifier targetChatIdentifier;
		
		public GettingChatMembersCountReady(TelegramBotApi telegramBotApi, ChatIdentifier targetChatIdentifier)
		{
			this.telegramBotApi = telegramBotApi;
			this.targetChatIdentifier = targetChatIdentifier;
		}
		
		/**
		 * Builds the request and sends it.
		 *
		 * @return on success, number of chat members in the chat
		 *
		 * @throws IOException if an I/O exception occurs
		 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
		 */
		public int execute() throws IOException, NegativeResponseException
		{
			return telegramBotApi.getChatMembersCount(targetChatIdentifier);
		}
	}
	
	public static class GettingChatMemberNoTarget
	{
		private TelegramBotApi telegramBotApi;
		private int userId;
		
		public GettingChatMemberNoTarget(TelegramBotApi telegramBotApi, int userId)
		{
			this.telegramBotApi = telegramBotApi;
			this.userId = userId;
		}
		
		/**
		 * gets chat member count of chat by super-group username (@supergroupusername)
		 *
		 * @param chatUsername username of the super-group (syntax @supergroupusername)
		 */
		public GettingChatMemberReady ofChatUsername(String chatUsername)
		{
			if(chatUsername == null) throw new IllegalArgumentException("\"chatUsername\" cannot be null.");
			
			return new GettingChatMemberReady(telegramBotApi, userId, ChatIdentifier.byUsername(chatUsername));
		}
		
		/**
		 * gets chat member count of chat by id of group or super-group.
		 *
		 * @param chatId chat id of the group or super-group
		 */
		public GettingChatMemberReady ofChatId(long chatId)
		{
			return new GettingChatMemberReady(telegramBotApi, userId, ChatIdentifier.byId(chatId));
		}
	}
	
	public static class GettingChatMemberReady
	{
		private TelegramBotApi telegramBotApi;
		private int userId;
		private ChatIdentifier targetChatIdentifier;
		
		public GettingChatMemberReady(TelegramBotApi telegramBotApi, int userId, ChatIdentifier targetChatIdentifier)
		{
			this.telegramBotApi = telegramBotApi;
			this.userId = userId;
			this.targetChatIdentifier = targetChatIdentifier;
		}
		
		/**
		 * Builds the request and sends it.
		 *
		 * @return <code>ChatMember</code> object on success
		 *
		 * @throws IOException if an I/O exception occurs
		 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
		 */
		public ChatMember execute() throws IOException, NegativeResponseException
		{
			return telegramBotApi.getChatMember(targetChatIdentifier, userId);
		}
	}
	
	public static class EditingNormalMessageNoIdNoTarget
	{
		private TelegramBotApi telegramBotApi;
		
		public EditingNormalMessageNoIdNoTarget(TelegramBotApi telegramBotApi)
		{
			this.telegramBotApi = telegramBotApi;
		}
		
		/**
		 * ID of the message to be edited.
		 * 
		 * @param messageId message id
		 */
		public EditingNormalMessageNoTarget forMessageId(int messageId)
		{
			return new EditingNormalMessageNoTarget(telegramBotApi, messageId);
		}
	}
	
	public static class EditingNormalMessageNoTarget
	{
		private TelegramBotApi telegramBotApi;
		private Integer messageId;
		
		public EditingNormalMessageNoTarget(TelegramBotApi telegramBotApi, Integer messageId)
		{
			this.telegramBotApi = telegramBotApi;
			this.messageId = messageId;
		}
		
		/**
		 * Edits the message inside super-group or channel by using its @username.
		 *
		 * @param chatUsername username of the super-group or the channel (syntax @username)
		 */
		public EditingMessageGeneric toChatUsername(String chatUsername)
		{
			if(chatUsername == null) throw new IllegalArgumentException("\"chatUsername\" cannot be null.");
			
			return new EditingMessageGeneric(telegramBotApi, messageId, ChatIdentifier.byUsername(chatUsername));
		}
		
		/**
		 * Edits the message inside any kind of chats by using its id.
		 *
		 * @param chatId chat id where the message will be edited
		 */
		public EditingMessageGeneric toChatId(long chatId)
		{
			return new EditingMessageGeneric(telegramBotApi, messageId, ChatIdentifier.byId(chatId));
		}
	}
	
	public static class EditingInlineMessageNoId
	{
		private TelegramBotApi telegramBotApi;
		
		public EditingInlineMessageNoId(TelegramBotApi telegramBotApi)
		{
			this.telegramBotApi = telegramBotApi;
		}
		
		/**
		 * ID of the inline message to be edited.
		 *
		 * @param inlineMessageId inline message id
		 */
		public EditingMessageGeneric forInlineMessageId(String inlineMessageId)
		{
			return new EditingMessageGeneric(telegramBotApi, inlineMessageId);
		}
	}
	
	public static class EditingMessageGeneric
	{
		private TelegramBotApi telegramBotApi;
		private Integer messageId;
		private ChatIdentifier targetChatIdentifier;
		private String inlineMessageId;
		private InlineKeyboardMarkup inlineKeyboard;
		
		public EditingMessageGeneric(TelegramBotApi telegramBotApi, Integer messageId,
		                             ChatIdentifier targetChatIdentifier)
		{
			this.telegramBotApi = telegramBotApi;
			this.messageId = messageId;
			this.targetChatIdentifier = targetChatIdentifier;
		}
		
		public EditingMessageGeneric(TelegramBotApi telegramBotApi, String inlineMessageId)
		{
			this.telegramBotApi = telegramBotApi;
			this.inlineMessageId = inlineMessageId;
		}
		
		/**
		 * Use this method to edit text messages sent by the bot or via the bot (for inline bots).
		 * 
		 * @param text the new text
		 */
		public EditingMessageWithNewText withNewText(String text)
		{
			return new EditingMessageWithNewText(telegramBotApi, messageId, targetChatIdentifier, inlineMessageId, inlineKeyboard, text);
		}
		
		/**
		 * Use this method to edit captions of messages sent by the bot or via
		 * the bot (for inline bots).
		 * 
		 * @param caption the new caption
		 */
		public EditingMessageWithNewCaption withNewCaption(String caption)
		{
			return new EditingMessageWithNewCaption(telegramBotApi, messageId, targetChatIdentifier, inlineMessageId, inlineKeyboard, caption);
		}
		
		/**
		 * Use this method to edit only the inline keyboard of messages sent by
		 * the bot or via the bot (for inline bots).
		 * 
		 * @param inlineKeyboard the new inline keyboard
		 */
		public EditingMessageGeneric withNewInlineKeyboard(InlineKeyboardMarkup inlineKeyboard)
		{
			this.inlineKeyboard = inlineKeyboard;
			return this;
		}
		
		/**
		 * Builds the request and sends it.
		 *
		 * @return the edited <code>Message</code> if it is sent by the bot, otherwise true on success
		 *
		 * @throws IOException if an I/O exception occurs
		 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
		 */
		public BooleanOrMessageResult execute() throws IOException, NegativeResponseException
		{
			return telegramBotApi.editMessageReplyMarkup(targetChatIdentifier, messageId, inlineMessageId, inlineKeyboard);
		}
	}
	
	public static class EditingMessageWithNewText
	{
		private TelegramBotApi telegramBotApi;
		private Integer messageId;
		private ChatIdentifier targetChatIdentifier;
		private String inlineMessageId;
		private InlineKeyboardMarkup inlineKeyboard;
		private String text;
		private ParseMode parseMode;
		private Boolean disableLinkPreviews;
		
		public EditingMessageWithNewText(TelegramBotApi telegramBotApi, Integer messageId,
		                                 ChatIdentifier targetChatIdentifier, String inlineMessageId,
		                                 InlineKeyboardMarkup inlineKeyboard, String text)
		{
			this.telegramBotApi = telegramBotApi;
			this.messageId = messageId;
			this.targetChatIdentifier = targetChatIdentifier;
			this.inlineMessageId = inlineMessageId;
			this.inlineKeyboard = inlineKeyboard;
			this.text = text;
		}
		
		/**
		 * Sends Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width
		 * text or inline URLs in your bot's message
		 *
		 * @param parseMode either Markdown or HTML
		 */
		public EditingMessageWithNewText parseMessageAs(ParseMode parseMode)
		{
			this.parseMode = parseMode;
			return this;
		}
		
		/**
		 * Disables link previews for links in this message.
		 */
		public EditingMessageWithNewText disableLinkPreviews()
		{
			this.disableLinkPreviews = true;
			return this;
		}
		
		/**
		 * Updates the inline keyboard of the message.
		 * 
		 * @param inlineKeyboard the new inline keyboard
		 */
		public EditingMessageWithNewText withNewInlineKeyboard(InlineKeyboardMarkup inlineKeyboard)
		{
			this.inlineKeyboard = inlineKeyboard;
			return this;
		}
		
		/**
		 * Builds the request and sends it.
		 *
		 * @return the edited <code>Message</code> if it is sent by the bot, otherwise true on success
		 *
		 * @throws IOException if an I/O exception occurs
		 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
		 */
		public BooleanOrMessageResult execute() throws IOException, NegativeResponseException
		{
			return telegramBotApi.editMessageText(targetChatIdentifier, messageId, inlineMessageId, text, parseMode, disableLinkPreviews, inlineKeyboard);
		}
	}
	
	public static class EditingMessageWithNewCaption
	{
		private TelegramBotApi telegramBotApi;
		private Integer messageId;
		private ChatIdentifier targetChatIdentifier;
		private String inlineMessageId;
		private InlineKeyboardMarkup inlineKeyboard;
		private String caption;
		
		public EditingMessageWithNewCaption(TelegramBotApi telegramBotApi, Integer messageId,
		                                 ChatIdentifier targetChatIdentifier, String inlineMessageId,
		                                 InlineKeyboardMarkup inlineKeyboard, String caption)
		{
			this.telegramBotApi = telegramBotApi;
			this.messageId = messageId;
			this.targetChatIdentifier = targetChatIdentifier;
			this.inlineMessageId = inlineMessageId;
			this.inlineKeyboard = inlineKeyboard;
			this.caption = caption;
		}
		
		/**
		 * Updates the inline keyboard of the message.
		 *
		 * @param inlineKeyboard the new inline keyboard
		 */
		public EditingMessageWithNewCaption withNewInlineKeyboard(InlineKeyboardMarkup inlineKeyboard)
		{
			this.inlineKeyboard = inlineKeyboard;
			return this;
		}
		
		/**
		 * Builds the request and sends it.
		 *
		 * @return the edited <code>Message</code> if it is sent by the bot, otherwise true on success
		 *
		 * @throws IOException if an I/O exception occurs
		 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
		 */
		public BooleanOrMessageResult execute() throws IOException, NegativeResponseException
		{
			return telegramBotApi.editMessageCaption(targetChatIdentifier, messageId, inlineMessageId, caption, inlineKeyboard);
		}
	}
	
	public static class AnsweringCallbackQueryNoId
	{
		private TelegramBotApi telegramBotApi;
		
		public AnsweringCallbackQueryNoId(TelegramBotApi telegramBotApi)
		{
			this.telegramBotApi = telegramBotApi;
		}
		
		/**
		 * The query id which you are going to answer.
		 *
		 * @param queryId the query id
		 */
		public AnsweringCallbackQueryReady forQueryId(String queryId)
		{
			if(queryId == null) throw new IllegalArgumentException("\"queryId\" cannot be null.");
			
			return new AnsweringCallbackQueryReady(telegramBotApi, queryId);
		}
	}
	
	public static class AnsweringCallbackQueryReady
	{
		private TelegramBotApi telegramBotApi;
		private String queryId;
		private String text;
		private Boolean showAlert;
		
		public AnsweringCallbackQueryReady(TelegramBotApi telegramBotApi, String queryId)
		{
			this.telegramBotApi = telegramBotApi;
			this.queryId = queryId;
		}
		
		/**
		 * Text of the notification. If not specified, nothing will be shown to the user.
		 * 
		 * @param text text of the answer
		 */
		public AnsweringCallbackQueryReady withText(String text)
		{
			this.text = text;
			return this;
		}
		
		/**
		 * If used, an alert will be shown by the client instead of a notification at the
		 * top of the chat screen.
		 */
		public AnsweringCallbackQueryReady showAsAlert()
		{
			this.showAlert = true;
			return this;
		}
		
		/**
		 * Builds the request and sends it.
		 *
		 * @return <code>true</code> on success
		 *
		 * @throws IOException if an I/O exception occurs
		 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
		 */
		public boolean execute() throws IOException, NegativeResponseException
		{
			return telegramBotApi.answerCallbackQuery(queryId, text, showAlert);
		}
	}
	
	public static class AnsweringInlineQueryNoIdNoResults
	{
		private TelegramBotApi telegramBotApi;
		
		public AnsweringInlineQueryNoIdNoResults(TelegramBotApi telegramBotApi)
		{
			this.telegramBotApi = telegramBotApi;
		}
		
		/**
		 * The query id which you are going to answer.
		 * 
		 * @param queryId the query id
		 */
		public AnsweringInlineQueryNoResults forQueryId(String queryId)
		{
			if(queryId == null) throw new IllegalArgumentException("\"queryId\" cannot be null.");
			
			return new AnsweringInlineQueryNoResults(telegramBotApi, queryId);
		}
	}
	
	public static class AnsweringInlineQueryNoResults
	{
		private TelegramBotApi telegramBotApi;
		private String queryId;
		
		public AnsweringInlineQueryNoResults(TelegramBotApi telegramBotApi, String queryId)
		{
			this.telegramBotApi = telegramBotApi;
			this.queryId = queryId;
		}
		
		/**
		 * Results that are going to be sent as an answer to the query.
		 * 
		 * @param results var-args of <code>InlineQueryResult</code> objects
		 */
		public AnsweringInlineQueryReady withResults(InlineQueryResult... results)
		{
			if(results == null) throw new IllegalArgumentException("\"results\" cannot be null.");
			
			return new AnsweringInlineQueryReady(telegramBotApi, queryId, results);
		}
	}
	
	public static class AnsweringInlineQueryReady
	{
		private TelegramBotApi telegramBotApi;
		private String queryId;
		private InlineQueryResult[] results;
		private Integer cacheTime;
		private Boolean isPersonal;
		private String nextOffset;
		private String switchPmText;
		private String switchPmParameter;
		
		public AnsweringInlineQueryReady(TelegramBotApi telegramBotApi, String queryId, InlineQueryResult[] results)
		{
			this.telegramBotApi = telegramBotApi;
			this.queryId = queryId;
			this.results = results;
		}
		
		/**
		 * The maximum amount of time in seconds that the result of the inline query may be cached on the server.
		 * Defaults to 300.
		 * 
		 * @param seconds cache time in seconds
		 */
		public AnsweringInlineQueryReady cacheResultsFor(int seconds)
		{
			this.cacheTime = seconds;
			return this;
		}
		
		/**
		 * Using this method, results may be cached on the server side only for the user that sent the query.
		 * By default, results may be returned to any user who sends the same query.
		 */
		public AnsweringInlineQueryReady asPersonal()
		{
			this.isPersonal = true;
			return this;
		}
		
		/**
		 * Pass the offset that a client should send in the next query with the same text to receive more results.
		 * Pass an empty string if there are no more results or if you don‘t support pagination. Offset length
		 * can’t exceed 64 bytes.
		 *
		 * @param nextOffset the next offset
		 */
		public AnsweringInlineQueryReady withNextOffset(String nextOffset)
		{
			this.nextOffset = nextOffset;
			return this;
		}
		
		/**
		 * If used, clients will display a button with specified text that switches the user to a private chat with
		 * the bot and sends the bot a start message with the parameter if set.
		 * 
		 * @param buttonText the button text
		 */
		public AnsweringInlineQueryReady showSwitchToPM(String buttonText)
		{
			this.switchPmText = buttonText;
			return this;
		}
		
		/**
		 * Parameter for the start message sent to the bot when user presses the switch button.
		 *
		 * @param parameter parameter to the /start command
		 */
		public AnsweringInlineQueryReady useSwitchToPmParameter(String parameter)
		{
			this.switchPmParameter = parameter;
			return this;
		}
		
		/**
		 * Builds the request and sends it.
		 *
		 * @return <code>true</code> on success
		 *
		 * @throws IOException if an I/O exception occurs
		 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
		 */
		public boolean execute() throws IOException, NegativeResponseException
		{
			return telegramBotApi.answerInlineQuery(queryId, results, cacheTime, isPersonal, nextOffset,
			                                                                switchPmText, switchPmParameter);
		}
	}
}