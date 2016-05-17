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
 * Represents a link to an animated GIF file. By default,
 * this animated GIF file will be sent by the user with
 * optional caption. Alternatively, you can use
 * input_message_content to send a message with the
 * specified content instead of the animation.
 */
public class InlineQueryResultGif extends InlineQueryResult
{
	/**
	 * A valid URL for the GIF file. TelegramFile size must
	 * not exceed 1MB
	 */
	@JsonProperty("gif_url")
	private String gifUrl;
	
	/**
	 * Optional. Width of the GIF.
	 */
	@JsonProperty("gif_width")
	private Integer gifWidth;
	
	/**
	 * Optional. Height of the GIF.
	 */
	@JsonProperty("gif_height")
	private Integer gifHeight;
	
	/**
	 * URL of the static thumbnail for the result (jpeg or gif).
	 */
	@JsonProperty("thumb_url")
	private String thumbUrl;
	
	/**
	 * Optional. Title for the result.
	 */
	@JsonProperty("title")
	private String title;
	
	/**
	 * Optional. Caption of the GIF file to be
	 * sent, 0-200 characters.
	 */
	@JsonProperty("caption")
	private String caption;
	
	/**
	 * Optional. Content of the message to be
	 * sent instead of the GIF animation.
	 */
	@JsonProperty("input_message_content")
	private InputMessageContent inputMessageContent;
	
	public InlineQueryResultGif(){}
	
	public InlineQueryResultGif(String id, InlineKeyboardMarkup replyMarkup, String gifUrl, Integer gifWidth,
	                            Integer gifHeight, String thumbUrl, String title, String caption,
	                            InputMessageContent inputMessageContent)
	{
		super("gif", id, replyMarkup);
		this.gifUrl = gifUrl;
		this.gifWidth = gifWidth;
		this.gifHeight = gifHeight;
		this.thumbUrl = thumbUrl;
		this.title = title;
		this.caption = caption;
		this.inputMessageContent = inputMessageContent;
	}
	
	public String getGifUrl(){return gifUrl;}
	public void setGifUrl(String gifUrl){this.gifUrl = gifUrl;}
	
	public Integer getGifWidth(){return gifWidth;}
	public void setGifWidth(Integer gifWidth){this.gifWidth = gifWidth;}
	
	public Integer getGifHeight(){return gifHeight;}
	public void setGifHeight(Integer gifHeight){this.gifHeight = gifHeight;}
	
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
		if(!(o instanceof InlineQueryResultGif)) return false;
		if(!super.equals(o)) return false;
		
		InlineQueryResultGif that = (InlineQueryResultGif) o;
		
		if(gifUrl != null ? !gifUrl.equals(that.gifUrl) : that.gifUrl != null) return false;
		if(gifWidth != null ? !gifWidth.equals(that.gifWidth) : that.gifWidth != null) return false;
		if(gifHeight != null ? !gifHeight.equals(that.gifHeight) : that.gifHeight != null) return false;
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
		result = 31 * result + (gifUrl != null ? gifUrl.hashCode() : 0);
		result = 31 * result + (gifWidth != null ? gifWidth.hashCode() : 0);
		result = 31 * result + (gifHeight != null ? gifHeight.hashCode() : 0);
		result = 31 * result + (thumbUrl != null ? thumbUrl.hashCode() : 0);
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (caption != null ? caption.hashCode() : 0);
		result = 31 * result + (inputMessageContent != null ? inputMessageContent.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "InlineQueryResultGif{" +
				"gifUrl='" + gifUrl + '\'' +
				", gifWidth=" + gifWidth +
				", gifHeight=" + gifHeight +
				", thumbUrl='" + thumbUrl + '\'' +
				", title='" + title + '\'' +
				", caption='" + caption + '\'' +
				", inputMessageContent=" + inputMessageContent +
				"} " + super.toString();
	}
}