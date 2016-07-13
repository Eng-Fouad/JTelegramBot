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

package io.fouad.jtb.core.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * This class represents a Telegram message.
 */
public class Message
{
	/**
	 * Unique message identifier.
	 */
	@JsonProperty("message_id")
	private int messageId;
	
	/**
	 * Optional. Sender, can be empty for messages sent to channels.
	 */
	@JsonProperty("from")
	private User from;
	
	/**
	 * Date the message was sent in Unix time.
	 */
	@JsonProperty("date")
	private int date;
	
	/**
	 * Conversation the message belongs to.
	 */
	@JsonProperty("chat")
	private Chat chat;
	
	/**
	 * Optional. For forwarded messages, sender of the original message.
	 */
	@JsonProperty("forward_from")
	private User forwardFrom;
	
	/**
	 * Optional. For messages forwarded from a channel, information about
	 * the original channel.
	 */
	@JsonProperty("forward_from_chat")
	private Chat forwardFromChat;
	
	/**
	 * Optional. For forwarded messages, date the original message was sent
	 * in Unix time.
	 */
	@JsonProperty("forward_date")
	private Integer forwardDate;
	
	/**
	 * Optional. For replies, the original message. Note that the Message
	 * object in this field will not contain further reply_to_message fields
	 * even if it itself is a reply.
	 */
	@JsonProperty("reply_to_message")
	private Message replyToMessage;
	
	/**
	 * Optional. Date the message was last edited in Unix time.
	 */
	@JsonProperty("edit_date")
	private int editDate;
	
	/**
	 * Optional. For text messages, the actual UTF-8 text of the message,
	 * 0-4096 characters.
	 */
	@JsonProperty("text")
	private String text;
	
	/**
	 * Optional. For text messages, special entities like usernames, URLs,
	 * bot commands, etc. that appear in the text.
	 */
	@JsonProperty("entities")
	private MessageEntity[] entities;
	
	/**
	 * Optional. Message is an audio file, information about the file.
	 */
	@JsonProperty("audio")
	private Audio audio;
	
	/**
	 * Optional. Message is a general file, information about the file.
	 */
	@JsonProperty("document")
	private Document document;
	
	/**
	 * Optional. Message is a photo, available sizes of the photo.
	 */
	@JsonProperty("photo")
	private PhotoSize[] photo;
	
	/**
	 * Optional. Message is a sticker, information about the sticker.
	 */
	@JsonProperty("sticker")
	private Sticker sticker;
	
	/**
	 * Optional. Message is a video, information about the video.
	 */
	@JsonProperty("video")
	private Video video;
	
	/**
	 * Optional. Message is a voice message, information about the file.
	 */
	@JsonProperty("voice")
	private Voice voice;
	
	/**
	 * Optional. Caption for the photo or video, 0-200 characters.
	 */
	@JsonProperty("caption")
	private String caption;
	
	/**
	 * Optional. Message is a shared contact, information about the contact.
	 */
	@JsonProperty("contact")
	private Contact contact;
	
	/**
	 * Optional. Message is a shared location, information about the location.
	 */
	@JsonProperty("location")
	private Location location;
	
	/**
	 * Optional. Message is a venue, information about the venue.
	 */
	@JsonProperty("venue")
	private Venue venue;
	
	/**
	 * Optional. A new member was added to the group, information about them
	 * (this member may be the bot itself).
	 */
	@JsonProperty("new_chat_member")
	private User newChatMember;
	
	/**
	 * Optional. A member was removed from the group, information about them
	 * (this member may be the bot itself).
	 */
	@JsonProperty("left_chat_member")
	private User leftChatMember;
	
	/**
	 * Optional. A chat title was changed to this value.
	 */
	@JsonProperty("new_chat_title")
	private String newChatTitle;
	
	/**
	 * Optional. A chat photo was change to this value.
	 */
	@JsonProperty("new_chat_photo")
	private PhotoSize[] newChatPhoto;
	
	/**
	 * Optional. Service message: the chat photo was deleted.
	 */
	@JsonProperty("delete_chat_photo")
	private Boolean deleteChatPhoto;
	
	/**
	 * Optional. Service message: the group has been created.
	 */
	@JsonProperty("group_chat_created")
	private Boolean groupChatCreated;
	
	/**
	 * Optional. Service message: the supergroup has been created.
	 * This field can‘t be received in a message coming through updates,
	 * because bot can’t be a member of a supergroup when it is created.
	 * It can only be found in reply_to_message if someone replies to
	 * a very first message in a directly created supergroup.
	 */
	@JsonProperty("supergroup_chat_created")
	private Boolean superGroupChatCreated;
	
	/**
	 * Optional. Service message: the channel has been created. This field
	 * can‘t be received in a message coming through updates, because bot
	 * can’t be a member of a channel when it is created. It can only be
	 * found in reply_to_message if someone replies to a very first message
	 * in a channel.
	 */
	@JsonProperty("channel_chat_created")
	private Boolean channelChatCreated;
	
	/**
	 * Optional. The group has been migrated to a supergroup with the specified
	 * identifier. This number may be greater than 32 bits and some programming
	 * languages may have difficulty/silent defects in interpreting it. But it
	 * smaller than 52 bits, so a signed 64 bit integer or double-precision float
	 * type are safe for storing this identifier.
	 */
	@JsonProperty("migrate_to_chat_id")
	private Long migrateToChatId;
	
	/**
	 * Optional. The supergroup has been migrated from a group with the specified
	 * identifier. This number may be greater than 32 bits and some programming
	 * languages may have difficulty/silent defects in interpreting it. But it
	 * smaller than 52 bits, so a signed 64 bit integer or double-precision float
	 * type are safe for storing this identifier.
	 */
	@JsonProperty("migrate_from_chat_id")
	private Long migrateFromChatId;
	
	/**
	 * Optional. Specified message was pinned. Note that the Message object
	 * in this field will not contain further reply_to_message fields even
	 * if it is itself a reply.
	 */
	@JsonProperty("pinned_message")
	private Message pinnedMessage;
	
	public Message(){}
	
	public Message(int messageId, User from, int date, Chat chat, User forwardFrom, Chat forwardFromChat,
	               Integer forwardDate, Message replyToMessage, int editDate, String text, MessageEntity[] entities,
	               Audio audio, Document document, PhotoSize[] photo, Sticker sticker, Video video, Voice voice,
	               String caption, Contact contact, Location location, Venue venue, User newChatMember,
	               User leftChatMember, String newChatTitle, PhotoSize[] newChatPhoto, Boolean deleteChatPhoto,
	               Boolean groupChatCreated, Boolean superGroupChatCreated, Boolean channelChatCreated,
	               Long migrateToChatId, Long migrateFromChatId, Message pinnedMessage)
	{
		this.messageId = messageId;
		this.from = from;
		this.date = date;
		this.chat = chat;
		this.forwardFrom = forwardFrom;
		this.forwardFromChat = forwardFromChat;
		this.forwardDate = forwardDate;
		this.replyToMessage = replyToMessage;
		this.editDate = editDate;
		this.text = text;
		this.entities = entities;
		this.audio = audio;
		this.document = document;
		this.photo = photo;
		this.sticker = sticker;
		this.video = video;
		this.voice = voice;
		this.caption = caption;
		this.contact = contact;
		this.location = location;
		this.venue = venue;
		this.newChatMember = newChatMember;
		this.leftChatMember = leftChatMember;
		this.newChatTitle = newChatTitle;
		this.newChatPhoto = newChatPhoto;
		this.deleteChatPhoto = deleteChatPhoto;
		this.groupChatCreated = groupChatCreated;
		this.superGroupChatCreated = superGroupChatCreated;
		this.channelChatCreated = channelChatCreated;
		this.migrateToChatId = migrateToChatId;
		this.migrateFromChatId = migrateFromChatId;
		this.pinnedMessage = pinnedMessage;
	}
	
	public int getMessageId(){return messageId;}
	public User getFrom(){return from;}
	public int getDate(){return date;}
	public Chat getChat(){return chat;}
	public User getForwardFrom(){return forwardFrom;}
	public Chat getForwardFromChat(){return forwardFromChat;}
	public Integer getForwardDate(){return forwardDate;}
	public Message getReplyToMessage(){return replyToMessage;}
	public int getEditDate(){return editDate;}
	public String getText(){return text;}
	public MessageEntity[] getEntities(){return entities;}
	public Audio getAudio(){return audio;}
	public Document getDocument(){return document;}
	public PhotoSize[] getPhoto(){return photo;}
	public Sticker getSticker(){return sticker;}
	public Video getVideo(){return video;}
	public Voice getVoice(){return voice;}
	public String getCaption(){return caption;}
	public Contact getContact(){return contact;}
	public Location getLocation(){return location;}
	public Venue getVenue(){return venue;}
	public User getNewChatMember(){return newChatMember;}
	public User getLeftChatMember(){return leftChatMember;}
	public String getNewChatTitle(){return newChatTitle;}
	public PhotoSize[] getNewChatPhoto(){return newChatPhoto;}
	public Boolean getDeleteChatPhoto(){return deleteChatPhoto;}
	public Boolean getGroupChatCreated(){return groupChatCreated;}
	public Boolean getSuperGroupChatCreated(){return superGroupChatCreated;}
	public Boolean getChannelChatCreated(){return channelChatCreated;}
	public Long getMigrateToChatId(){return migrateToChatId;}
	public Long getMigrateFromChatId(){return migrateFromChatId;}
	public Message getPinnedMessage(){return pinnedMessage;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof Message)) return false;
		
		Message message = (Message) o;
		
		if(messageId != message.messageId) return false;
		if(date != message.date) return false;
		if(editDate != message.editDate) return false;
		if(from != null ? !from.equals(message.from) : message.from != null) return false;
		if(chat != null ? !chat.equals(message.chat) : message.chat != null) return false;
		if(forwardFrom != null ? !forwardFrom.equals(message.forwardFrom) : message.forwardFrom != null) return false;
		if(forwardFromChat != null ? !forwardFromChat.equals(message.forwardFromChat) : message.forwardFromChat != null)
			return false;
		if(forwardDate != null ? !forwardDate.equals(message.forwardDate) : message.forwardDate != null) return false;
		if(replyToMessage != null ? !replyToMessage.equals(message.replyToMessage) : message.replyToMessage != null)
			return false;
		if(text != null ? !text.equals(message.text) : message.text != null) return false;
		if(!Arrays.deepEquals(entities, message.entities)) return false;
		if(audio != null ? !audio.equals(message.audio) : message.audio != null) return false;
		if(document != null ? !document.equals(message.document) : message.document != null) return false;
		if(!Arrays.deepEquals(photo, message.photo)) return false;
		if(sticker != null ? !sticker.equals(message.sticker) : message.sticker != null) return false;
		if(video != null ? !video.equals(message.video) : message.video != null) return false;
		if(voice != null ? !voice.equals(message.voice) : message.voice != null) return false;
		if(caption != null ? !caption.equals(message.caption) : message.caption != null) return false;
		if(contact != null ? !contact.equals(message.contact) : message.contact != null) return false;
		if(location != null ? !location.equals(message.location) : message.location != null) return false;
		if(venue != null ? !venue.equals(message.venue) : message.venue != null) return false;
		if(newChatMember != null ? !newChatMember.equals(message.newChatMember) : message.newChatMember != null)
			return false;
		if(leftChatMember != null ? !leftChatMember.equals(message.leftChatMember) : message.leftChatMember != null)
			return false;
		if(newChatTitle != null ? !newChatTitle.equals(message.newChatTitle) : message.newChatTitle != null)
			return false;
		if(!Arrays.deepEquals(newChatPhoto, message.newChatPhoto)) return false;
		if(deleteChatPhoto != null ? !deleteChatPhoto.equals(message.deleteChatPhoto) : message.deleteChatPhoto != null)
			return false;
		if(groupChatCreated != null ? !groupChatCreated.equals(message.groupChatCreated)
		                            : message.groupChatCreated != null) return false;
		if(superGroupChatCreated != null ? !superGroupChatCreated.equals(message.superGroupChatCreated)
		                                 : message.superGroupChatCreated != null) return false;
		if(channelChatCreated != null ? !channelChatCreated.equals(message.channelChatCreated)
		                              : message.channelChatCreated != null) return false;
		if(migrateToChatId != null ? !migrateToChatId.equals(message.migrateToChatId) : message.migrateToChatId != null)
			return false;
		if(migrateFromChatId != null ? !migrateFromChatId.equals(message.migrateFromChatId)
		                             : message.migrateFromChatId != null) return false;
		return pinnedMessage != null ? pinnedMessage.equals(message.pinnedMessage) : message.pinnedMessage == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = messageId;
		result = 31 * result + (from != null ? from.hashCode() : 0);
		result = 31 * result + date;
		result = 31 * result + (chat != null ? chat.hashCode() : 0);
		result = 31 * result + (forwardFrom != null ? forwardFrom.hashCode() : 0);
		result = 31 * result + (forwardFromChat != null ? forwardFromChat.hashCode() : 0);
		result = 31 * result + (forwardDate != null ? forwardDate.hashCode() : 0);
		result = 31 * result + (replyToMessage != null ? replyToMessage.hashCode() : 0);
		result = 31 * result + editDate;
		result = 31 * result + (text != null ? text.hashCode() : 0);
		result = 31 * result + Arrays.deepHashCode(entities);
		result = 31 * result + (audio != null ? audio.hashCode() : 0);
		result = 31 * result + (document != null ? document.hashCode() : 0);
		result = 31 * result + Arrays.deepHashCode(photo);
		result = 31 * result + (sticker != null ? sticker.hashCode() : 0);
		result = 31 * result + (video != null ? video.hashCode() : 0);
		result = 31 * result + (voice != null ? voice.hashCode() : 0);
		result = 31 * result + (caption != null ? caption.hashCode() : 0);
		result = 31 * result + (contact != null ? contact.hashCode() : 0);
		result = 31 * result + (location != null ? location.hashCode() : 0);
		result = 31 * result + (venue != null ? venue.hashCode() : 0);
		result = 31 * result + (newChatMember != null ? newChatMember.hashCode() : 0);
		result = 31 * result + (leftChatMember != null ? leftChatMember.hashCode() : 0);
		result = 31 * result + (newChatTitle != null ? newChatTitle.hashCode() : 0);
		result = 31 * result + Arrays.deepHashCode(newChatPhoto);
		result = 31 * result + (deleteChatPhoto != null ? deleteChatPhoto.hashCode() : 0);
		result = 31 * result + (groupChatCreated != null ? groupChatCreated.hashCode() : 0);
		result = 31 * result + (superGroupChatCreated != null ? superGroupChatCreated.hashCode() : 0);
		result = 31 * result + (channelChatCreated != null ? channelChatCreated.hashCode() : 0);
		result = 31 * result + (migrateToChatId != null ? migrateToChatId.hashCode() : 0);
		result = 31 * result + (migrateFromChatId != null ? migrateFromChatId.hashCode() : 0);
		result = 31 * result + (pinnedMessage != null ? pinnedMessage.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "Message{" + "messageId=" + messageId + ", from=" + from + ", date=" + date + ", chat=" + chat +
				", forwardFrom=" + forwardFrom + ", forwardFromChat=" + forwardFromChat + ", forwardDate=" +
				forwardDate + ", replyToMessage=" + replyToMessage + ", editDate=" + editDate + ", text='" +
				text + '\'' + ", entities=" + Arrays.deepToString(entities) + ", audio=" + audio + ", document=" +
				document + ", photo=" + Arrays.deepToString(photo) + ", sticker=" + sticker + ", video=" + video +
				", voice=" + voice + ", caption='" + caption + '\'' + ", contact=" + contact + ", location=" +
				location + ", venue=" + venue + ", newChatMember=" + newChatMember + ", leftChatMember=" +
				leftChatMember + ", newChatTitle='" + newChatTitle + '\'' + ", newChatPhoto=" +
				Arrays.deepToString(newChatPhoto) + ", deleteChatPhoto=" + deleteChatPhoto + ", groupChatCreated=" +
				groupChatCreated + ", superGroupChatCreated=" + superGroupChatCreated + ", channelChatCreated=" +
				channelChatCreated + ", migrateToChatId=" + migrateToChatId + ", migrateFromChatId=" +
				migrateFromChatId + ", pinnedMessage=" + pinnedMessage + '}';
	}
}