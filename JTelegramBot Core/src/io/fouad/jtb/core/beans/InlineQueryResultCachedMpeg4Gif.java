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
 * Represents a link to a video animation (H.264/MPEG-4 AVC video without
 * sound) stored on the Telegram servers. By default, this animated MPEG-4
 * file will be sent by the user with an optional caption. Alternatively,
 * you can use input_message_content to send a message with the specified
 * content instead of the animation.
 */
public class InlineQueryResultCachedMpeg4Gif extends InlineQueryResult
{
	/**
	 * A valid file identifier for the MP4 file.
	 */
	@JsonProperty("mpeg4_file_id")
	private String mpeg4FileId;
	
	/**
	 * Optional. Title for the result.
	 */
	@JsonProperty("title")
	private String title;
	
	/**
	 * Optional. Caption of the MPEG-4 file to be sent, 0-200 characters.
	 */
	@JsonProperty("caption")
	private String caption;
	
	/**
	 * Optional. Content of the message to be sent instead of the video animation.
	 */
	@JsonProperty("input_message_content")
	private InputMessageContent inputMessageContent;
	
	public InlineQueryResultCachedMpeg4Gif(){}
	
	public InlineQueryResultCachedMpeg4Gif(String id, InlineKeyboardMarkup replyMarkup, String mpeg4FileId,
	                                       String title, String caption, InputMessageContent inputMessageContent)
	{
		super("mpeg4_gif", id, replyMarkup);
		this.mpeg4FileId = mpeg4FileId;
		this.title = title;
		this.caption = caption;
		this.inputMessageContent = inputMessageContent;
	}
	
	public String getMpeg4FileId(){return mpeg4FileId;}
	public void setMpeg4FileId(String mpeg4FileId){this.mpeg4FileId = mpeg4FileId;}
	
	public String getTitle(){return title;}
	public void setTitle(String title){this.title = title;}
	
	public String getCaption(){return caption;}
	public void setCaption(String caption){this.caption = caption;}
	
	public InputMessageContent getInputMessageContent(){return inputMessageContent;}
	public void setInputMessageContent(InputMessageContent inputMessageContent){this.inputMessageContent = inputMessageContent;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof InlineQueryResultCachedMpeg4Gif)) return false;
		if(!super.equals(o)) return false;
		
		InlineQueryResultCachedMpeg4Gif that = (InlineQueryResultCachedMpeg4Gif) o;
		
		if(mpeg4FileId != null ? !mpeg4FileId.equals(that.mpeg4FileId) : that.mpeg4FileId != null) return false;
		if(title != null ? !title.equals(that.title) : that.title != null) return false;
		if(caption != null ? !caption.equals(that.caption) : that.caption != null) return false;
		return inputMessageContent != null ? inputMessageContent.equals(that.inputMessageContent)
		                                   : that.inputMessageContent == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + (mpeg4FileId != null ? mpeg4FileId.hashCode() : 0);
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (caption != null ? caption.hashCode() : 0);
		result = 31 * result + (inputMessageContent != null ? inputMessageContent.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "InlineQueryResultCachedMpeg4Gif{" +
				"mpeg4FileId='" + mpeg4FileId + '\'' +
				", title='" + title + '\'' +
				", caption='" + caption + '\'' +
				", inputMessageContent=" + inputMessageContent +
				"} " + super.toString();
	}
}