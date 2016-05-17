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
 * Represents the content of a contact message to be sent as the
 * result of an inline query.
 */
public class InputContactMessageContent extends InputMessageContent
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
	
	public InputContactMessageContent(){}
	
	public InputContactMessageContent(String phoneNumber, String firstName, String lastName)
	{
		this.phoneNumber = phoneNumber;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getPhoneNumber(){return phoneNumber;}
	public void setPhoneNumber(String phoneNumber){this.phoneNumber = phoneNumber;}
	
	public String getFirstName(){return firstName;}
	public void setFirstName(String firstName){this.firstName = firstName;}
	
	public String getLastName(){return lastName;}
	public void setLastName(String lastName){this.lastName = lastName;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof InputContactMessageContent)) return false;
		
		InputContactMessageContent that = (InputContactMessageContent) o;
		
		if(phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
		if(firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
		return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = phoneNumber != null ? phoneNumber.hashCode() : 0;
		result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "InputContactMessageContent{" +
				"phoneNumber='" + phoneNumber + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				"}";
	}
}