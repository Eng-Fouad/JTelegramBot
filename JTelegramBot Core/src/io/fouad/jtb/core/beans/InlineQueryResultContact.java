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
 * Represents a contact with a phone number. By default, this
 * contact will be sent by the user. Alternatively, you can use
 * input_message_content to send a message with the specified
 * content instead of the contact..
 */
public class InlineQueryResultContact extends InlineQueryResult
{
	/**
	 * Contact's phone number.
	 */
	@JsonProperty("phone_number")
	private String phoneNumber;
	
	/**
	 * Contact's first name.
	 */
	@JsonProperty("first_name")
	private String firstName;
	
	/**
	 * Optional. Contact's last name.
	 */
	@JsonProperty("last_name")
	private String lastName;
	
	/**
	 * Optional. Content of the message to be sent instead of the contact.
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
	
	public InlineQueryResultContact(){}
	
	public InlineQueryResultContact(String id, InlineKeyboardMarkup replyMarkup, String phoneNumber,
	                                String firstName, String lastName, InputMessageContent inputMessageContent,
	                                String thumbUrl, Integer thumbWidth, Integer thumbHeight)
	{
		super("contact", id, replyMarkup);
		this.phoneNumber = phoneNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.inputMessageContent = inputMessageContent;
		this.thumbUrl = thumbUrl;
		this.thumbWidth = thumbWidth;
		this.thumbHeight = thumbHeight;
	}
	
	public String getPhoneNumber(){return phoneNumber;}
	public void setPhoneNumber(String phoneNumber){this.phoneNumber = phoneNumber;}
	
	public String getFirstName(){return firstName;}
	public void setFirstName(String firstName){this.firstName = firstName;}
	
	public String getLastName(){return lastName;}
	public void setLastName(String lastName){this.lastName = lastName;}
	
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
		if(!(o instanceof InlineQueryResultContact)) return false;
		if(!super.equals(o)) return false;
		
		InlineQueryResultContact that = (InlineQueryResultContact) o;
		
		if(phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
		if(firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
		if(lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
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
		result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
		result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (inputMessageContent != null ? inputMessageContent.hashCode() : 0);
		result = 31 * result + (thumbUrl != null ? thumbUrl.hashCode() : 0);
		result = 31 * result + (thumbWidth != null ? thumbWidth.hashCode() : 0);
		result = 31 * result + (thumbHeight != null ? thumbHeight.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "InlineQueryResultContact{" +
				"phoneNumber='" + phoneNumber + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", inputMessageContent=" + inputMessageContent +
				", thumbUrl='" + thumbUrl + '\'' +
				", thumbWidth=" + thumbWidth +
				", thumbHeight=" + thumbHeight +
				"} " + super.toString();
	}
}