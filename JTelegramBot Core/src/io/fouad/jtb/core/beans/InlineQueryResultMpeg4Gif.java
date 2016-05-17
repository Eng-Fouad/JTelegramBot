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
 * Represents a link to a video animation (H.264/MPEG-4 AVC video without sound).
 * By default, this animated MPEG-4 file will be sent by the user with optional
 * caption. Alternatively, you can use input_message_content to send a message
 * with the specified content instead of the animation.
 */
public class InlineQueryResultMpeg4Gif extends InlineQueryResult
{
	/**
	 * A valid URL for the MP4 file. File size must not exceed 1MB.
	 */
	@JsonProperty("mpeg4_url")
	private String mpeg4Url;
	
	/**
	 * Optional. Video width.
	 */
	@JsonProperty("mpeg4_width")
	private Integer mpeg4Width;
	
	/**
	 * Optional. Video height.
	 */
	@JsonProperty("mpeg4_height")
	private Integer mpeg4Height;
	
	/**
	 * URL of the static thumbnail (jpeg or gif) for the result.
	 */
	@JsonProperty("thumb_url")
	private String thumbUrl;
	
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
	@JsonProperty("inputMessageContent")
	private InputMessageContent inputMessageContent;
	
	public InlineQueryResultMpeg4Gif(){}
	
	public InlineQueryResultMpeg4Gif(String id, InlineKeyboardMarkup replyMarkup, String mpeg4Url,
	                                 Integer mpeg4Width, Integer mpeg4Height, String thumbUrl, String title,
	                                 String caption, InputMessageContent inputMessageContent)
	{
		super("mpeg4_gif", id, replyMarkup);
		this.mpeg4Url = mpeg4Url;
		this.mpeg4Width = mpeg4Width;
		this.mpeg4Height = mpeg4Height;
		this.thumbUrl = thumbUrl;
		this.title = title;
		this.caption = caption;
		this.inputMessageContent = inputMessageContent;
	}
	
	public String getMpeg4Url(){return mpeg4Url;}
	public void setMpeg4Url(String mpeg4Url){this.mpeg4Url = mpeg4Url;}
	
	public Integer getMpeg4Width(){return mpeg4Width;}
	public void setMpeg4Width(Integer mpeg4Width){this.mpeg4Width = mpeg4Width;}
	
	public Integer getMpeg4Height(){return mpeg4Height;}
	public void setMpeg4Height(Integer mpeg4Height){this.mpeg4Height = mpeg4Height;}
	
	public String getThumbUrl(){return thumbUrl;}
	public void setThumbUrl(String thumbUrl){this.thumbUrl = thumbUrl;}
	
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
		if(!(o instanceof InlineQueryResultMpeg4Gif)) return false;
		if(!super.equals(o)) return false;
		
		InlineQueryResultMpeg4Gif that = (InlineQueryResultMpeg4Gif) o;
		
		if(mpeg4Url != null ? !mpeg4Url.equals(that.mpeg4Url) : that.mpeg4Url != null) return false;
		if(mpeg4Width != null ? !mpeg4Width.equals(that.mpeg4Width) : that.mpeg4Width != null) return false;
		if(mpeg4Height != null ? !mpeg4Height.equals(that.mpeg4Height) : that.mpeg4Height != null) return false;
		if(thumbUrl != null ? !thumbUrl.equals(that.thumbUrl) : that.thumbUrl != null) return false;
		if(title != null ? !title.equals(that.title) : that.title != null) return false;
		if(caption != null ? !caption.equals(that.caption) : that.caption != null) return false;
		return inputMessageContent != null ? inputMessageContent.equals(that.inputMessageContent)
		                                   : that.inputMessageContent == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + (mpeg4Url != null ? mpeg4Url.hashCode() : 0);
		result = 31 * result + (mpeg4Width != null ? mpeg4Width.hashCode() : 0);
		result = 31 * result + (mpeg4Height != null ? mpeg4Height.hashCode() : 0);
		result = 31 * result + (thumbUrl != null ? thumbUrl.hashCode() : 0);
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (caption != null ? caption.hashCode() : 0);
		result = 31 * result + (inputMessageContent != null ? inputMessageContent.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "InlineQueryResultMpeg4Gif{" +
				"mpeg4Url='" + mpeg4Url + '\'' +
				", mpeg4Width=" + mpeg4Width +
				", mpeg4Height=" + mpeg4Height +
				", thumbUrl='" + thumbUrl + '\'' +
				", title='" + title + '\'' +
				", caption='" + caption + '\'' +
				", inputMessageContent=" + inputMessageContent +
				"} " + super.toString();
	}
}