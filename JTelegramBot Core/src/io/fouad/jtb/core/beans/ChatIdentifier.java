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

/**
 * This class represents a chat identifier, either by its ID or by its @username.
 */
public class ChatIdentifier
{
	private final Long id;
	private final String username;
	
	private ChatIdentifier(Long id, String username)
	{
		this.id = id;
		this.username = username;
	}
	
	public static ChatIdentifier byId(long id)
	{
		return new ChatIdentifier(id, null);
	}
	
	public static ChatIdentifier byUsername(String username)
	{
		return new ChatIdentifier(null, username);
	}
	
	public Long getId(){return id;}
	public String getUsername(){return username;}
	
	public String getIdentifier()
	{
		if(id != null) return String.valueOf(id);
		else return username;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		
		ChatIdentifier that = (ChatIdentifier) o;
		
		if(id != null ? !id.equals(that.id) : that.id != null) return false;
		return username != null ? username.equals(that.username) : that.username == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (username != null ? username.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "ChatIdentifier{" +
				"id=" + id +
				", username='" + username + '\'' +
				'}';
	}
}