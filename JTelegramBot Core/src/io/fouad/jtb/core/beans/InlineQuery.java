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
 * This object represents an incoming inline query.
 * When the user sends an empty query, your bot
 * could return some default or trending results.
 */
public class InlineQuery
{
	/**
	 * Unique identifier for this query.
	 */
	@JsonProperty("id")
	private String id;
	
	/**
	 * Sender.
	 */
	@JsonProperty("from")
	private User from;
	
	/**
	 * Optional. Sender location, only for bots that request user location.
	 */
	@JsonProperty("location")
	private Location location;
	
	/**
	 * Text of the query (up to 512 characters).
	 */
	@JsonProperty("query")
	private String query;
	
	/**
	 * Offset of the results to be returned,
	 * can be controlled by the bot.
	 */
	@JsonProperty("offset")
	private String offset;
	
	public InlineQuery(){}
	
	public InlineQuery(String id, User from, Location location, String query, String offset)
	{
		this.id = id;
		this.from = from;
		this.location = location;
		this.query = query;
		this.offset = offset;
	}
	
	public String getId(){return id;}
	public User getFrom(){return from;}
	public Location getLocation(){return location;}
	public String getQuery(){return query;}
	public String getOffset(){return offset;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof InlineQuery)) return false;
		
		InlineQuery that = (InlineQuery) o;
		
		if(id != null ? !id.equals(that.id) : that.id != null) return false;
		if(from != null ? !from.equals(that.from) : that.from != null) return false;
		if(location != null ? !location.equals(that.location) : that.location != null) return false;
		if(query != null ? !query.equals(that.query) : that.query != null) return false;
		return offset != null ? offset.equals(that.offset) : that.offset == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (from != null ? from.hashCode() : 0);
		result = 31 * result + (location != null ? location.hashCode() : 0);
		result = 31 * result + (query != null ? query.hashCode() : 0);
		result = 31 * result + (offset != null ? offset.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "InlineQuery{" +
				"id='" + id + '\'' +
				", from=" + from +
				", location=" + location +
				", query='" + query + '\'' +
				", offset='" + offset + '\'' +
				'}';
	}
}