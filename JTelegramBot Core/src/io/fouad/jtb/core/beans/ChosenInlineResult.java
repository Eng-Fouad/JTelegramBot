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
 * This object represents a result of an inline
 * query that was chosen by the user and sent to
 * their chat partner.
 */
public class ChosenInlineResult
{
	/**
	 * The unique identifier for the result that was chosen.
	 */
	@JsonProperty("result_id")
	private String resultId;
	
	/**
	 * The user that chose the result.
	 */
	@JsonProperty("from")
	private User from;
	
	/**
	 * Optional. Sender location, only for bots that require user location.
	 */
	@JsonProperty("location")
	private Location location;
	
	/**
	 * Optional. Identifier of the sent inline message. Available only if
	 * there is an inline keyboard attached to the message. Will be also
	 * received in callback queries and can be used to edit the message.
	 */
	@JsonProperty("inline_message_id")
	private String inlineMessageId;
	
	/**
	 * The query that was used to obtain the result.
	 */
	@JsonProperty("query")
	private String query;
	
	public ChosenInlineResult(){}
	
	public ChosenInlineResult(String resultId, User from, Location location, String inlineMessageId, String query)
	{
		this.resultId = resultId;
		this.from = from;
		this.location = location;
		this.inlineMessageId = inlineMessageId;
		this.query = query;
	}
	
	public String getResultId(){return resultId;}
	public User getFrom(){return from;}
	public Location getLocation(){return location;}
	public String getInlineMessageId(){return inlineMessageId;}
	public String getQuery(){return query;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof ChosenInlineResult)) return false;
		
		ChosenInlineResult that = (ChosenInlineResult) o;
		
		if(resultId != null ? !resultId.equals(that.resultId) : that.resultId != null) return false;
		if(from != null ? !from.equals(that.from) : that.from != null) return false;
		if(location != null ? !location.equals(that.location) : that.location != null) return false;
		if(inlineMessageId != null ? !inlineMessageId.equals(that.inlineMessageId) : that.inlineMessageId != null)
			return false;
		return query != null ? query.equals(that.query) : that.query == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = resultId != null ? resultId.hashCode() : 0;
		result = 31 * result + (from != null ? from.hashCode() : 0);
		result = 31 * result + (location != null ? location.hashCode() : 0);
		result = 31 * result + (inlineMessageId != null ? inlineMessageId.hashCode() : 0);
		result = 31 * result + (query != null ? query.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "ChosenInlineResult{" +
				"resultId='" + resultId + '\'' +
				", from=" + from +
				", location=" + location +
				", inlineMessageId='" + inlineMessageId + '\'' +
				", query='" + query + '\'' +
				'}';
	}
}