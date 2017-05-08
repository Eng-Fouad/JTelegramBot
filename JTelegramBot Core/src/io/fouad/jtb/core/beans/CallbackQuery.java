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
 * This object represents an incoming callback query from
 * a callback button in an inline keyboard. If the button
 * that originated the query was attached to a message sent
 * by the bot, the field message will be presented. If the
 * button was attached to a message sent via the bot (in
 * inline mode), the field inline_message_id will be
 * presented.
 */
public class CallbackQuery
{
	/**
	 * Unique identifier for this query.
	 */
	@JsonProperty("id")
	private String id;
	
	/**
	 * Sender.
	 */
	@JsonProperty("from")
	private User from;
	
	/**
	 * Optional. Message with the callback button that originated
	 * the query. Note that message content and message date will
	 * not be available if the message is too old.
	 */
	@JsonProperty("message")
	private Message message;
	
	@JsonProperty("chat_instance")
	private String chat_instance;
	/**
	 * Optional. Identifier of the message sent via the bot in
	 * inline mode, that originated the query.
	 */
	@JsonProperty("inline_message_id")
	private String inline_message_id;
	
	/**
	 * Data associated with the callback button. Be aware that
	 * a bad client can send arbitrary data in this field.
	 */
	@JsonProperty("data")
	private String data;
	
	public CallbackQuery(){}
	
	public CallbackQuery(String id, User from, Message message, String inline_message_id, String data, String chat_instance)
	{
		this.id = id;
		this.from = from;
		this.message = message;
		this.inline_message_id = inline_message_id;
		this.data = data;
		this.chat_instance=chat_instance;
	}
	
	public String getId(){return id;}
	public User getFrom(){return from;}
	public Message getMessage(){return message;}
	public String getInline_message_id(){return inline_message_id;}
	public String getData(){return data;}
	public String getchat_instance(){return chat_instance;}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chat_instance == null) ? 0 : chat_instance.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inline_message_id == null) ? 0 : inline_message_id.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CallbackQuery other = (CallbackQuery) obj;
		if (chat_instance == null) {
			if (other.chat_instance != null)
				return false;
		} else if (!chat_instance.equals(other.chat_instance))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inline_message_id == null) {
			if (other.inline_message_id != null)
				return false;
		} else if (!inline_message_id.equals(other.inline_message_id))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CallbackQuery [id=" + id + ", from=" + from + ", message=" + message + ", chat_instance=" + chat_instance
				+ ", inline_message_id=" + inline_message_id + ", data=" + data + "]";
	}

	
	
}