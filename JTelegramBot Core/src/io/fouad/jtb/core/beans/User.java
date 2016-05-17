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
 * This object represents a Telegram user or bot.
 */
public class User
{
	/**
	 * Unique identifier for this user or bot.
	 */
	@JsonProperty("id")
	private int id;
	
	/**
	 * User‘s or bot’s first name.
	 */
	@JsonProperty("first_name")
	private String firstName;
	
	/**
	 * Optional. User‘s or bot’s last name.
	 */
	@JsonProperty("last_name")
	private String lastName;
	
	/**
	 * Optional. User‘s or bot’s username.
	 */
	@JsonProperty("username")
	private String username;
	
	public User(){}
	
	public User(int id, String firstName, String lastName, String username)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
	}
	
	public int getId(){return id;}
	public String getFirstName(){return firstName;}
	public String getLastName(){return lastName;}
	public String getUsername(){return username;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		
		User user = (User) o;
		
		if(id != user.id) return false;
		if(firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
		if(lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
		return username != null ? username.equals(user.username) : user.username == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = id;
		result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (username != null ? username.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "User{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", username='" + username + '\'' +
				'}';
	}
}