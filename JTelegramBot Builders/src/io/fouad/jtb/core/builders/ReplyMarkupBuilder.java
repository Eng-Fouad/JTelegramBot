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

import io.fouad.jtb.core.beans.ForceReply;
import io.fouad.jtb.core.beans.InlineKeyboardButton;
import io.fouad.jtb.core.beans.InlineKeyboardMarkup;
import io.fouad.jtb.core.beans.KeyboardButton;
import io.fouad.jtb.core.beans.ReplyKeyboardHide;
import io.fouad.jtb.core.beans.ReplyKeyboardMarkup;
import io.fouad.jtb.core.beans.ReplyMarkup;

/**
 * A builder class to build <code>ReplyKeyboardMarkup</code>, <code>ReplyKeyboardHide</code>,
 * <code>ForceReply</code>, or <code>InlineKeyboardMarkup</code>.
 */
public class ReplyMarkupBuilder
{
	/**
	 * Sends a custom keyboard to the target user(s).
	 *
	 * @param keyboard 2D array of buttons, each represented by <code>KeyboardButton</code>
	 */
	public static MessageWithCustomKeyboard sendCustomKeyboard(KeyboardButton[][] keyboard)
	{
		return new MessageWithCustomKeyboard(keyboard);
	}
	
	/**
	 * Hides the custom keyboard from the target user(s), if any.
	 */
	public static MessageWithHidingKeyboard hideCustomKeyboard()
	{
		return new MessageWithHidingKeyboard();
	}
	
	/**
	 * Forces the target user(s) to reply on the current message.
	 */
	public static MessageWithForceReply forceReply()
	{
		return new MessageWithForceReply();
	}
	
	/**
	 * Attaches inline keyboard with the sending message.
	 * 
	 * @param inlineKeyboard 2D array of buttons, each represented by <code>InlineKeyboardButton</code>
	 */
	public static MessageWithAttachingInlineKeyboard attachInlineKeyboard(InlineKeyboardButton[][] inlineKeyboard)
	{
		return new MessageWithAttachingInlineKeyboard(inlineKeyboard);
	}
	
	public static class MessageWithCustomKeyboard
	{
		private KeyboardButton[][] keyboard;
		private Boolean resizeKeyboard;
		private Boolean oneTimeKeyboard;
		private Boolean selective;
		
		private MessageWithCustomKeyboard(KeyboardButton[][] keyboard)
		{
			this.keyboard = keyboard;
		}
		
		/**
		 * Requests Telegram clients to resize the keyboard vertically for optimal fit (e.g., make the keyboard
		 * smaller if there are just two rows of buttons). By default, the custom keyboard is always of the same
		 * height as the app's standard keyboard.
		 */
		public MessageWithCustomKeyboard resizeKeyboard()
		{
			this.resizeKeyboard = true;
			return this;
		}
		
		/**
		 * Requests Telegram clients to hide the keyboard as soon as it's been used.
		 */
		public MessageWithCustomKeyboard asOneTimeKeyboard()
		{
			this.oneTimeKeyboard = true;
			return this;
		}
		
		/**
		 * Shows the keyboard to specific users only. Targets:
		 *
		 * 1) Users that are @mentioned in the text of the <code>Message</code> object.
		 * 2) If the bot's message is a reply, then the target is the sender of the original message.
		 */
		public MessageWithCustomKeyboard sendCustomKeyboardToMentionedUsersOnly()
		{
			this.selective = true;
			return this;
		}
		
		/**
		 * Builds the <code>ReplyMarkup</code> object.
		 */
		public ReplyMarkup toReplyMarkup()
		{
			return new ReplyKeyboardMarkup(keyboard, resizeKeyboard, oneTimeKeyboard, selective);
		}
	}
	
	public static class MessageWithHidingKeyboard
	{
		private Boolean selective;
		
		private MessageWithHidingKeyboard(){}
		
		/**
		 * Hides the keyboard from specific users only. Targets:
		 *
		 * 1) Users that are @mentioned in the text of the <code>Message</code> object.
		 * 2) If the bot's message is a reply, then the target is the sender of the original message.
		 */
		public MessageWithHidingKeyboard hideCustomKeyboardFromMentionedUsersOnly()
		{
			this.selective = true;
			return this;
		}
		
		/**
		 * Builds the <code>ReplyMarkup</code> object.
		 */
		public ReplyMarkup toReplyMarkup()
		{
			return new ReplyKeyboardHide(selective);
		}
	}
	
	public static class MessageWithForceReply
	{
		private Boolean selective;
		
		private MessageWithForceReply(){}
		
		/**
		 * Forces reply to the current message for specific users only. Targets:
		 *
		 * 1) Users that are @mentioned in the text of the <code>Message</code> object.
		 * 2) If the bot's message is a reply, then the target is the sender of the original message.
		 */
		public MessageWithForceReply forceReplyForMentionedUsersOnly()
		{
			this.selective = true;
			return this;
		}
		
		/**
		 * Builds the <code>ReplyMarkup</code> object.
		 */
		public ReplyMarkup toReplyMarkup()
		{
			return new ForceReply(selective);
		}
	}
	
	public static class MessageWithAttachingInlineKeyboard
	{
		private InlineKeyboardButton[][] inlineKeyboard;
		
		private MessageWithAttachingInlineKeyboard(InlineKeyboardButton[][] inlineKeyboard)
		{
			this.inlineKeyboard = inlineKeyboard;
		}
		
		/**
		 * Builds the <code>ReplyMarkup</code> object.
		 */
		public ReplyMarkup toReplyMarkup()
		{
			return new InlineKeyboardMarkup(inlineKeyboard);
		}
	}
}