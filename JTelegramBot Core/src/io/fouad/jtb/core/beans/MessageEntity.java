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
import io.fouad.jtb.core.enums.MessageEntityType;

/**
 * This object represents one special entity in a text message. For example, hashtags,
 * usernames, URLs, etc.
 */
public class MessageEntity
{
	/**
	 * Type of the entity. One of mention (@username), hashtag, bot_command, url,
	 * email, bold (bold text), italic (italic text), code (monowidth string),
	 * pre (monowidth block), text_link (for clickable text URLs).
	 */
	@JsonProperty("type")
	private MessageEntityType type;
	
	/**
	 * Offset in UTF-16 code units to the start of the entity.
	 */
	@JsonProperty("offset")
	private int offset;
	
	/**
	 * Length of the entity in UTF-16 code units.
	 */
	@JsonProperty("length")
	private int length;
	
	/**
	 * Optional. For “text_link” only, url that will be opened after user taps on
	 * the text.
	 */
	@JsonProperty("url")
	private String url;
	
	public MessageEntity(){}
	
	public MessageEntity(MessageEntityType type, int offset, int length, String url)
	{
		this.type = type;
		this.offset = offset;
		this.length = length;
		this.url = url;
	}
	
	public MessageEntityType getType(){return type;}
	public int getOffset(){return offset;}
	public int getLength(){return length;}
	public String getUrl(){return url;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof MessageEntity)) return false;
		
		MessageEntity that = (MessageEntity) o;
		
		if(offset != that.offset) return false;
		if(length != that.length) return false;
		if(type != that.type) return false;
		return url != null ? url.equals(that.url) : that.url == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = type != null ? type.hashCode() : 0;
		result = 31 * result + offset;
		result = 31 * result + length;
		result = 31 * result + (url != null ? url.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "MessageEntity{" +
				"type=" + type +
				", offset=" + offset +
				", length=" + length +
				", url='" + url + '\'' +
				'}';
	}
}