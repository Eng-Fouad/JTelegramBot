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

import io.fouad.jtb.core.beans.CallbackQuery;
import io.fouad.jtb.core.beans.ChosenInlineResult;
import io.fouad.jtb.core.beans.InlineQuery;
import io.fouad.jtb.core.beans.Message;

/**
 * Callbacks methods which are called on getting new updates from Telegram server.
 */
public interface UpdateHandler
{
	/**
	 * Invoked on receiving new incoming message of any kind — text, photo, sticker, etc.
	 * 
	 * @param telegramBotApi reference to the Telegram Bot API
	 * @param id The update‘s unique identifier. Update identifiers start from
	 *           a certain positive number and increase sequentially
	 * @param message the new incoming message
	 */
	void onMessageReceived(TelegramBotApi telegramBotApi, int id, Message message);
	
	/**
	 * Invoked on receiving new version of a message that is known to the bot and was edited.
	 *
	 * @param telegramBotApi reference to the Telegram Bot API
	 * @param id The update‘s unique identifier. Update identifiers start from
	 *           a certain positive number and increase sequentially
	 * @param message the message
	 */
	void onEditedMessageReceived(TelegramBotApi telegramBotApi, int id, Message message);
	
	/**
	 * Invoked on receiving new incoming inline query.
	 * 
	 * @param telegramBotApi reference to the Telegram Bot API
	 * @param id The update‘s unique identifier. Update identifiers start from
	 *           a certain positive number and increase sequentially
	 * @param inlineQuery the new incoming inline query
	 */
	void onInlineQueryReceived(TelegramBotApi telegramBotApi, int id, InlineQuery inlineQuery);
	
	/**
	 * Invoked on receiving the result of an inline query that was chosen by a user and sent to their chat partner.
	 * 
	 * @param telegramBotApi reference to the Telegram Bot API
	 * @param id The update‘s unique identifier. Update identifiers start from
	 *           a certain positive number and increase sequentially
	 * @param chosenInlineResult the result of an inline query
	 */
	void onChosenInlineResultReceived(TelegramBotApi telegramBotApi, int id, ChosenInlineResult chosenInlineResult);
	
	/**
	 * Invoked on receiving new incoming callback query.
	 * 
	 * @param telegramBotApi reference to the Telegram Bot API
	 * @param id The update‘s unique identifier. Update identifiers start from
	 *           a certain positive number and increase sequentially
	 * @param callbackQuery the new incoming callback query
	 */
	void onCallbackQueryReceived(TelegramBotApi telegramBotApi, int id, CallbackQuery callbackQuery);
	
	/**
	 * Invoked in case of an exception occurs when trying to get the new update.
	 * 
	 * @param e the exception
	 */
	void onGetUpdatesFailure(Exception e);
}