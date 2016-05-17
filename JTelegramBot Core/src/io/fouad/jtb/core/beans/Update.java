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

/**
 * This object represents an incoming update.
 * Only one of the optional parameters can be present in any given update.
 */
public class Update
{
	/**
	 * The update‘s unique identifier. Update identifiers start from a certain
	 * positive number and increase sequentially. This ID becomes especially
	 * handy if you’re using Webhooks, since it allows you to ignore repeated
	 * updates or to restore the correct update sequence, should they get out
	 * of order.
	 */
	@JsonProperty("update_id")
	private int updateId;
	
	/**
	 * Optional. New incoming message of any kind — text, photo, sticker, etc.
	 */
	@JsonProperty("message")
	private Message message;
	
	/**
	 * Optional. New incoming inline query.
	 */
	@JsonProperty("inline_query")
	private InlineQuery inlineQuery;
	
	/**
	 * Optional. The result of an inline query that was chosen by a user and
	 * sent to their chat partner.
	 */
	@JsonProperty("chosen_inline_result")
	private ChosenInlineResult chosenInlineResult;
	
	/**
	 * Optional. New incoming callback query.
	 */
	@JsonProperty("callback_query")
	private CallbackQuery callbackQuery;
	
	public Update(){}
	
	public Update(int updateId, Message message, InlineQuery inlineQuery, ChosenInlineResult chosenInlineResult,
	              CallbackQuery callbackQuery)
	{
		this.updateId = updateId;
		this.message = message;
		this.inlineQuery = inlineQuery;
		this.chosenInlineResult = chosenInlineResult;
		this.callbackQuery = callbackQuery;
	}
	
	public int getUpdateId(){return updateId;}
	public Message getMessage(){return message;}
	public InlineQuery getInlineQuery(){return inlineQuery;}
	public ChosenInlineResult getChosenInlineResult(){return chosenInlineResult;}
	public CallbackQuery getCallbackQuery(){return callbackQuery;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof Update)) return false;
		
		Update update = (Update) o;
		
		if(updateId != update.updateId) return false;
		if(message != null ? !message.equals(update.message) : update.message != null) return false;
		if(inlineQuery != null ? !inlineQuery.equals(update.inlineQuery) : update.inlineQuery != null) return false;
		if(chosenInlineResult != null ? !chosenInlineResult.equals(update.chosenInlineResult)
		                              : update.chosenInlineResult != null) return false;
		return callbackQuery != null ? callbackQuery.equals(update.callbackQuery) : update.callbackQuery == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = updateId;
		result = 31 * result + (message != null ? message.hashCode() : 0);
		result = 31 * result + (inlineQuery != null ? inlineQuery.hashCode() : 0);
		result = 31 * result + (chosenInlineResult != null ? chosenInlineResult.hashCode() : 0);
		result = 31 * result + (callbackQuery != null ? callbackQuery.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "Update{" +
				"updateId=" + updateId +
				", message=" + message +
				", inlineQuery=" + inlineQuery +
				", chosenInlineResult=" + chosenInlineResult +
				", callbackQuery=" + callbackQuery +
				'}';
	}
}