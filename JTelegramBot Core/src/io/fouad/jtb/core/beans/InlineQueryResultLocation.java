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
import io.fouad.jtb.core.enums.ResultDocumentMimeType;

/**
 * Represents a location on a map. By default, the location will be sent
 * by the user. Alternatively, you can use input_message_content to send
 * a message with the specified content instead of the location.
 */
public class InlineQueryResultLocation extends InlineQueryResult
{
	/**
	 * Location latitude in degrees.
	 */
	@JsonProperty("latitude")
	private double latitude;
	
	/**
	 * Location longitude in degrees.
	 */
	@JsonProperty("longitude")
	private double longitude;
	
	/**
	 * Location title.
	 */
	@JsonProperty("title")
	private String title;
	
	/**
	 * Optional. Content of the message to be sent instead of the location.
	 */
	@JsonProperty("input_message_content")
	private InputMessageContent inputMessageContent;
	
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
	
	public InlineQueryResultLocation(){}
	
	public InlineQueryResultLocation(String id, InlineKeyboardMarkup replyMarkup, double latitude,
	                                 double longitude, String title, InputMessageContent inputMessageContent,
	                                 String thumbUrl, Integer thumbWidth, Integer thumbHeight)
	{
		super("location", id, replyMarkup);
		this.latitude = latitude;
		this.longitude = longitude;
		this.title = title;
		this.inputMessageContent = inputMessageContent;
		this.thumbUrl = thumbUrl;
		this.thumbWidth = thumbWidth;
		this.thumbHeight = thumbHeight;
	}
	
	public double getLatitude(){return latitude;}
	public void setLatitude(double latitude){this.latitude = latitude;}
	
	public double getLongitude(){return longitude;}
	public void setLongitude(double longitude){this.longitude = longitude;}
	
	public String getTitle(){return title;}
	public void setTitle(String title){this.title = title;}
	
	public InputMessageContent getInputMessageContent(){return inputMessageContent;}
	public void setInputMessageContent(InputMessageContent inputMessageContent){this.inputMessageContent = inputMessageContent;}
	
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
		if(!(o instanceof InlineQueryResultLocation)) return false;
		if(!super.equals(o)) return false;
		
		InlineQueryResultLocation that = (InlineQueryResultLocation) o;
		
		if(Double.compare(that.latitude, latitude) != 0) return false;
		if(Double.compare(that.longitude, longitude) != 0) return false;
		if(title != null ? !title.equals(that.title) : that.title != null) return false;
		if(inputMessageContent != null ? !inputMessageContent.equals(that.inputMessageContent)
		                               : that.inputMessageContent != null) return false;
		if(thumbUrl != null ? !thumbUrl.equals(that.thumbUrl) : that.thumbUrl != null) return false;
		if(thumbWidth != null ? !thumbWidth.equals(that.thumbWidth) : that.thumbWidth != null) return false;
		return thumbHeight != null ? thumbHeight.equals(that.thumbHeight) : that.thumbHeight == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (inputMessageContent != null ? inputMessageContent.hashCode() : 0);
		result = 31 * result + (thumbUrl != null ? thumbUrl.hashCode() : 0);
		result = 31 * result + (thumbWidth != null ? thumbWidth.hashCode() : 0);
		result = 31 * result + (thumbHeight != null ? thumbHeight.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "InlineQueryResultLocation{" +
				"latitude=" + latitude +
				", longitude=" + longitude +
				", title='" + title + '\'' +
				", inputMessageContent=" + inputMessageContent +
				", thumbUrl='" + thumbUrl + '\'' +
				", thumbWidth=" + thumbWidth +
				", thumbHeight=" + thumbHeight +
				"} " + super.toString();
	}
}