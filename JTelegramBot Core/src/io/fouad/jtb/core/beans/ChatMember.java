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
import io.fouad.jtb.core.enums.ChatMemberStatus;

/**
 * This object contains information about one member of the chat.
 */
public class ChatMember
{
	/**
	 * Information about the user.
	 */
	@JsonProperty("user")
	private User user;
	
	/**
	 * The member's status in the chat. Can be “creator”, “administrator”, “member”, “left” or “kicked”.
	 */
	@JsonProperty("status")
	private ChatMemberStatus status;
	
	public ChatMember(){}
	
	public ChatMember(User user, ChatMemberStatus status)
	{
		this.user = user;
		this.status = status;
	}
	
	public User getUser(){return user;}
	public ChatMemberStatus getStatus(){return status;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof ChatMember)) return false;
		
		ChatMember that = (ChatMember) o;
		
		if(user != null ? !user.equals(that.user) : that.user != null) return false;
		return status == that.status;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = user != null ? user.hashCode() : 0;
		result = 31 * result + (status != null ? status.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "ChatMember{" + "user=" + user + ", status='" + status + '\'' + '}';
	}
}