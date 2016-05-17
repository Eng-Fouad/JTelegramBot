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
import io.fouad.jtb.core.enums.ChatType;

/**
 * This object represents a chat.
 */
public class Chat
{
	/**
	 * Unique identifier for this chat, not exceeding 1e13 by absolute value.
	 */
	@JsonProperty("id")
	private long id;
	
	/**
	 * Type of chat, can be either “private”, “group”, “supergroup” or “channel”.
	 */
	@JsonProperty("type")
	private ChatType type;
	
	/**
	 * Optional. Title, for channels and group chats.
	 */
	@JsonProperty("title")
	private String title;
	
	/**
	 * Optional. Username, for private chats and channels if available.
	 */
	@JsonProperty("username")
	private String username;
	
	/**
	 * Optional. First name of the other party in a private chat.
	 */
	@JsonProperty("first_name")
	private String firstName;
	
	/**
	 * Optional. Last name of the other party in a private chat.
	 */
	@JsonProperty("last_name")
	private String lastName;
	
	public Chat(){}
	
	public Chat(long id, ChatType type, String title, String username, String firstName, String lastName)
	{
		this.id = id;
		this.type = type;
		this.title = title;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public long getId(){return id;}
	public ChatType getType(){return type;}
	public String getTitle(){return title;}
	public String getUsername(){return username;}
	public String getFirstName(){return firstName;}
	public String getLastName(){return lastName;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		
		Chat chat = (Chat) o;
		
		if(id != chat.id) return false;
		if(type != chat.type) return false;
		if(title != null ? !title.equals(chat.title) : chat.title != null) return false;
		if(username != null ? !username.equals(chat.username) : chat.username != null) return false;
		if(firstName != null ? !firstName.equals(chat.firstName) : chat.firstName != null) return false;
		return lastName != null ? lastName.equals(chat.lastName) : chat.lastName == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (type != null ? type.hashCode() : 0);
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (username != null ? username.hashCode() : 0);
		result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "Chat{" +
				"id=" + id +
				", type=" + type +
				", title='" + title + '\'' +
				", username='" + username + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}
}