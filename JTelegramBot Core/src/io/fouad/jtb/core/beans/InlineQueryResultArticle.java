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
 * Represents a link to an article or web page.
 */
public class InlineQueryResultArticle extends InlineQueryResult
{
	/**
	 * Title of the result.
	 */
	@JsonProperty("title")
	private String title;
	
	/**
	 * Content of the message to be sent.
	 */
	@JsonProperty("input_message_content")
	private InputMessageContent inputMessageContent;
	
	/**
	 * Optional. URL of the result.
	 */
	@JsonProperty("url")
	private String url;
	
	/**
	 * Optional. Pass True, if you don't want the URL to be shown in the message.
	 */
	@JsonProperty("hide_url")
	private Boolean hideUrl;
	
	/**
	 * Optional. Short description of the result.
	 */
	@JsonProperty("description")
	private String description;
	
	/**
	 * Optional. Url of the thumbnail for the result.
	 */
	@JsonProperty("thumb_url")
	private String thumbUrl;
	
	/**
	 * Optional. Thumbnail width.
	 */
	@JsonProperty("thumb_width")
	private Integer thumbWidth;
	
	/**
	 * Optional. Thumbnail height.
	 */
	@JsonProperty("thumb_height")
	private Integer thumbHeight;
	
	public InlineQueryResultArticle(){}
	
	public InlineQueryResultArticle(String id, InlineKeyboardMarkup replyMarkup, String title,
	                                InputMessageContent inputMessageContent, String url, Boolean hideUrl,
	                                String description, String thumbUrl, Integer thumbWidth, Integer thumbHeight)
	{
		super("article", id, replyMarkup);
		this.title = title;
		this.inputMessageContent = inputMessageContent;
		this.url = url;
		this.hideUrl = hideUrl;
		this.description = description;
		this.thumbUrl = thumbUrl;
		this.thumbWidth = thumbWidth;
		this.thumbHeight = thumbHeight;
	}
	
	public String getTitle(){return title;}
	public void setTitle(String title){this.title = title;}
	
	public InputMessageContent getInputMessageContent(){return inputMessageContent;}
	public void setInputMessageContent(InputMessageContent inputMessageContent){this.inputMessageContent = inputMessageContent;}
	
	public String getUrl(){return url;}
	public void setUrl(String url){this.url = url;}
	
	public Boolean getHideUrl(){return hideUrl;}
	public void setHideUrl(Boolean hideUrl){this.hideUrl = hideUrl;}
	
	public String getDescription(){return description;}
	public void setDescription(String description){this.description = description;}
	
	public String getThumbUrl(){return thumbUrl;}
	public void setThumbUrl(String thumbUrl){this.thumbUrl = thumbUrl;}
	
	public Integer getThumbWidth(){return thumbWidth;}
	public void setThumbWidth(Integer thumbWidth){this.thumbWidth = thumbWidth;}
	
	public Integer getThumbHeight(){return thumbHeight;}
	public void setThumbHeight(Integer thumbHeight){this.thumbHeight = thumbHeight;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof InlineQueryResultArticle)) return false;
		if(!super.equals(o)) return false;
		
		InlineQueryResultArticle that = (InlineQueryResultArticle) o;
		
		if(title != null ? !title.equals(that.title) : that.title != null) return false;
		if(inputMessageContent != null ? !inputMessageContent.equals(that.inputMessageContent)
		                               : that.inputMessageContent != null) return false;
		if(url != null ? !url.equals(that.url) : that.url != null) return false;
		if(hideUrl != null ? !hideUrl.equals(that.hideUrl) : that.hideUrl != null) return false;
		if(description != null ? !description.equals(that.description) : that.description != null) return false;
		if(thumbUrl != null ? !thumbUrl.equals(that.thumbUrl) : that.thumbUrl != null) return false;
		if(thumbWidth != null ? !thumbWidth.equals(that.thumbWidth) : that.thumbWidth != null) return false;
		return thumbHeight != null ? thumbHeight.equals(that.thumbHeight) : that.thumbHeight == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (inputMessageContent != null ? inputMessageContent.hashCode() : 0);
		result = 31 * result + (url != null ? url.hashCode() : 0);
		result = 31 * result + (hideUrl != null ? hideUrl.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (thumbUrl != null ? thumbUrl.hashCode() : 0);
		result = 31 * result + (thumbWidth != null ? thumbWidth.hashCode() : 0);
		result = 31 * result + (thumbHeight != null ? thumbHeight.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "InlineQueryResultArticle{" +
				"title='" + title + '\'' +
				", inputMessageContent=" + inputMessageContent +
				", url='" + url + '\'' +
				", hideUrl=" + hideUrl +
				", description='" + description + '\'' +
				", thumbUrl='" + thumbUrl + '\'' +
				", thumbWidth=" + thumbWidth +
				", thumbHeight=" + thumbHeight +
				"} " + super.toString();
	}
}