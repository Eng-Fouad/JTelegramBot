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
 * Represents a link to a sticker stored on the Telegram servers.
 * By default, this sticker will be sent by the user. Alternatively,
 * you can use input_message_content to send a message with the
 * specified content instead of the sticker.
 */
public class InlineQueryResultCachedSticker extends InlineQueryResult
{
	/**
	 * A valid file identifier of the sticker.
	 */
	@JsonProperty("sticker_file_id")
	private String stickerFileId;
	
	/**
	 * Optional. Content of the message to be sent instead of the sticker.
	 */
	@JsonProperty("input_message_content")
	private InputMessageContent inputMessageContent;
	
	public InlineQueryResultCachedSticker(){}
	
	public InlineQueryResultCachedSticker(String id, InlineKeyboardMarkup replyMarkup,
	                                      String stickerFileId, InputMessageContent inputMessageContent)
	{
		super("sticker", id, replyMarkup);
		this.stickerFileId = stickerFileId;
		this.inputMessageContent = inputMessageContent;
	}
	
	public String getStickerFileId(){return stickerFileId;}
	public void setStickerFileId(String stickerFileId){this.stickerFileId = stickerFileId;}
	
	public InputMessageContent getInputMessageContent(){return inputMessageContent;}
	public void setInputMessageContent(InputMessageContent inputMessageContent){this.inputMessageContent = inputMessageContent;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof InlineQueryResultCachedSticker)) return false;
		if(!super.equals(o)) return false;
		
		InlineQueryResultCachedSticker that = (InlineQueryResultCachedSticker) o;
		
		if(stickerFileId != null ? !stickerFileId.equals(that.stickerFileId) : that.stickerFileId != null) return false;
		return inputMessageContent != null ? inputMessageContent.equals(that.inputMessageContent)
		                                   : that.inputMessageContent == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + (stickerFileId != null ? stickerFileId.hashCode() : 0);
		result = 31 * result + (inputMessageContent != null ? inputMessageContent.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "InlineQueryResultCachedSticker{" +
				"stickerFileId='" + stickerFileId + '\'' +
				", inputMessageContent=" + inputMessageContent +
				"} " + super.toString();
	}
}