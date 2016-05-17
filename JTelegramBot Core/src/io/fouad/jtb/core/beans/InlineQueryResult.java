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
 * This object represents one result of an inline query.
 * Telegram clients currently support results of the following 19 types:
 * 
 * - InlineQueryResultCachedAudio
 * - InlineQueryResultCachedDocument
 * - InlineQueryResultCachedGif
 * - InlineQueryResultCachedMpeg4Gif
 * - InlineQueryResultCachedPhoto
 * - InlineQueryResultCachedSticker
 * - InlineQueryResultCachedVideo
 * - InlineQueryResultCachedVoice
 * - InlineQueryResultArticle
 * - InlineQueryResultPhoto
 * - InlineQueryResultContact
 * - InlineQueryResultDocument
 * - InlineQueryResultGif
 * - InlineQueryResultLocation
 * - InlineQueryResultMpeg4Gif
 * - InlineQueryResultPhoto
 * - InlineQueryResultVenue
 * - InlineQueryResultVideo
 * - InlineQueryResultVoice
 * - InlineQueryResultArticle
 */
public abstract class InlineQueryResult
{
	/**
	 * Type of the result.
	 */
	@JsonProperty("type")
	private String type;
	
	/**
	 * Unique identifier for this result, 1-64 bytes.
	 */
	@JsonProperty("id")
	private String id;
	
	/**
	 * Optional. Inline keyboard attached to the message.
	 */
	@JsonProperty("reply_markup")
	private InlineKeyboardMarkup replyMarkup;
	
	public InlineQueryResult(){}
	
	public InlineQueryResult(String type, String id, InlineKeyboardMarkup replyMarkup)
	{
		this.type = type;
		this.id = id;
		this.replyMarkup = replyMarkup;
	}
	
	public String getType(){return type;}
	public void setType(String type){this.type = type;}
	
	public String getId(){return id;}
	public void setId(String id){this.id = id;}
	
	public InlineKeyboardMarkup getReplyMarkup(){return replyMarkup;}
	public void setReplyMarkup(InlineKeyboardMarkup replyMarkup){this.replyMarkup = replyMarkup;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof InlineQueryResult)) return false;
		
		InlineQueryResult that = (InlineQueryResult) o;
		
		if(type != null ? !type.equals(that.type) : that.type != null) return false;
		if(id != null ? !id.equals(that.id) : that.id != null) return false;
		return replyMarkup != null ? replyMarkup.equals(that.replyMarkup) : that.replyMarkup == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = type != null ? type.hashCode() : 0;
		result = 31 * result + (id != null ? id.hashCode() : 0);
		result = 31 * result + (replyMarkup != null ? replyMarkup.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "InlineQueryResult{" +
				"type='" + type + '\'' +
				", id='" + id + '\'' +
				", replyMarkup=" + replyMarkup +
				'}';
	}
}