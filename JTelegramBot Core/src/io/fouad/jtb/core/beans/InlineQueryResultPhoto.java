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
 * Represents a link to a photo. By default, this photo
 * will be sent by the user with optional caption.
 * Alternatively, you can use input_message_content to
 * send a message with the specified content instead of
 * the photo.
 */
public class InlineQueryResultPhoto extends InlineQueryResult
{
	/**
	 * A valid URL of the photo. Photo must be in jpeg
	 * format. Photo size must not exceed 5MB.
	 */
	@JsonProperty("photo_url")
	private String photoUrl;
	
	/**
	 * URL of the thumbnail for the photo.
	 */
	@JsonProperty("thumb_url")
	private String thumbUrl;
	
	/**
	 * Optional. Width of the photo.
	 */
	@JsonProperty("photo_width")
	private Integer photoWidth;
	
	/**
	 * Optional. Height of the photo.
	 */
	@JsonProperty("photo_height")
	private Integer photoHeight;
	
	/**
	 * Optional. Title for the result.
	 */
	@JsonProperty("title")
	private String title;
	
	/**
	 * Optional. Short description of the result.
	 */
	@JsonProperty("description")
	private String description;
	
	/**
	 * Optional. Caption of the photo to be sent, 0-200 characters.
	 */
	@JsonProperty("caption")
	private String caption;
	
	/**
	 * Optional. Content of the message to be sent instead of the photo.
	 */
	@JsonProperty("input_message_content")
	private InputMessageContent inputMessageContent;
	
	public InlineQueryResultPhoto(){}
	
	public InlineQueryResultPhoto(String id, InlineKeyboardMarkup replyMarkup, String photoUrl,
	                              String thumbUrl, Integer photoWidth, Integer photoHeight, String title,
	                              String description, String caption, InputMessageContent inputMessageContent)
	{
		super("photo", id, replyMarkup);
		this.photoUrl = photoUrl;
		this.thumbUrl = thumbUrl;
		this.photoWidth = photoWidth;
		this.photoHeight = photoHeight;
		this.title = title;
		this.description = description;
		this.caption = caption;
		this.inputMessageContent = inputMessageContent;
	}
	
	public String getPhotoUrl(){return photoUrl;}
	public void setPhotoUrl(String photoUrl){this.photoUrl = photoUrl;}
	
	public String getThumbUrl(){return thumbUrl;}
	public void setThumbUrl(String thumbUrl){this.thumbUrl = thumbUrl;}
	
	public Integer getPhotoWidth(){return photoWidth;}
	public void setPhotoWidth(Integer photoWidth){this.photoWidth = photoWidth;}
	
	public Integer getPhotoHeight(){return photoHeight;}
	public void setPhotoHeight(Integer photoHeight){this.photoHeight = photoHeight;}
	
	public String getTitle(){return title;}
	public void setTitle(String title){this.title = title;}
	
	public String getDescription(){return description;}
	public void setDescription(String description){this.description = description;}
	
	public String getCaption(){return caption;}
	public void setCaption(String caption){this.caption = caption;}
	
	public InputMessageContent getInputMessageContent(){return inputMessageContent;}
	public void setInputMessageContent(InputMessageContent inputMessageContent){this.inputMessageContent = inputMessageContent;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof InlineQueryResultPhoto)) return false;
		if(!super.equals(o)) return false;
		
		InlineQueryResultPhoto that = (InlineQueryResultPhoto) o;
		
		if(photoUrl != null ? !photoUrl.equals(that.photoUrl) : that.photoUrl != null) return false;
		if(thumbUrl != null ? !thumbUrl.equals(that.thumbUrl) : that.thumbUrl != null) return false;
		if(photoWidth != null ? !photoWidth.equals(that.photoWidth) : that.photoWidth != null) return false;
		if(photoHeight != null ? !photoHeight.equals(that.photoHeight) : that.photoHeight != null) return false;
		if(title != null ? !title.equals(that.title) : that.title != null) return false;
		if(description != null ? !description.equals(that.description) : that.description != null) return false;
		if(caption != null ? !caption.equals(that.caption) : that.caption != null) return false;
		return inputMessageContent != null ? inputMessageContent.equals(that.inputMessageContent)
		                                   : that.inputMessageContent == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + (photoUrl != null ? photoUrl.hashCode() : 0);
		result = 31 * result + (thumbUrl != null ? thumbUrl.hashCode() : 0);
		result = 31 * result + (photoWidth != null ? photoWidth.hashCode() : 0);
		result = 31 * result + (photoHeight != null ? photoHeight.hashCode() : 0);
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (caption != null ? caption.hashCode() : 0);
		result = 31 * result + (inputMessageContent != null ? inputMessageContent.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "InlineQueryResultPhoto{" +
				"photoUrl='" + photoUrl + '\'' +
				", thumbUrl='" + thumbUrl + '\'' +
				", photoWidth=" + photoWidth +
				", photoHeight=" + photoHeight +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				", caption='" + caption + '\'' +
				", inputMessageContent=" + inputMessageContent +
				"} " + super.toString();
	}
}