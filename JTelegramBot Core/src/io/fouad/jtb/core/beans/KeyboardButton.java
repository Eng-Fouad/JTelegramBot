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
 * This object represents one button of the reply keyboard.
 * For simple text buttons String can be used instead of
 * this object to specify text of the button. Optional
 * fields are mutually exclusive.
 */
public class KeyboardButton
{
	/**
	 * Text of the button. If none of the optional fields are
	 * used, it will be sent to the bot as a message when the
	 * button is pressed.
	 */
	@JsonProperty("text")
	private String text;
	
	/**
	 * Optional. If True, the user's phone number will be sent
	 * as a contact when the button is pressed. Available in
	 * private chats only.
	 */
	@JsonProperty("request_contact")
	private Boolean requestContact;
	
	/**
	 * Optional. If True, the user's current location will be
	 * sent when the button is pressed. Available in private
	 * chats only.
	 */
	@JsonProperty("request_location")
	private Boolean requestLocation;
	
	public KeyboardButton(){}
	
	public KeyboardButton(String text, Boolean requestContact, Boolean requestLocation)
	{
		this.text = text;
		this.requestContact = requestContact;
		this.requestLocation = requestLocation;
	}
	
	public String getText(){return text;}
	public void setText(String text){this.text = text;}
	
	public Boolean getRequestContact(){return requestContact;}
	public void setRequestContact(Boolean requestContact){this.requestContact = requestContact;}
	
	public Boolean getRequestLocation(){return requestLocation;}
	public void setRequestLocation(Boolean requestLocation){this.requestLocation = requestLocation;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof KeyboardButton)) return false;
		
		KeyboardButton that = (KeyboardButton) o;
		
		if(text != null ? !text.equals(that.text) : that.text != null) return false;
		if(requestContact != null ? !requestContact.equals(that.requestContact) : that.requestContact != null)
			return false;
		return requestLocation != null ? requestLocation.equals(that.requestLocation) : that.requestLocation == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = text != null ? text.hashCode() : 0;
		result = 31 * result + (requestContact != null ? requestContact.hashCode() : 0);
		result = 31 * result + (requestLocation != null ? requestLocation.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "KeyboardButton{" +
				"text='" + text + '\'' +
				", requestContact=" + requestContact +
				", requestLocation=" + requestLocation +
				'}';
	}
}