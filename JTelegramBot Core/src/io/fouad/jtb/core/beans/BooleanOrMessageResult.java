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

import com.fasterxml.jackson.core.type.TypeReference;
import io.fouad.jtb.core.utils.JsonUtils;

import java.io.IOException;

/**
 * A C++-like union class which can hold only one result. Either <code>Boolean</code> result
 * or <code>Message</code> result.
 */
public class BooleanOrMessageResult
{
	private Boolean booleanResult;
	private Message messageResult;
	
	public BooleanOrMessageResult(){}
	
	public BooleanOrMessageResult(Boolean booleanResult)
	{
		this.booleanResult = booleanResult;
	}
	
	public BooleanOrMessageResult(Message messageResult)
	{
		this.messageResult = messageResult;
	}
	
	public BooleanOrMessageResult(String result) throws IOException
	{
		if(result != null)
		{
			if(result.equalsIgnoreCase("true")) this.booleanResult = true;
			else if(result.equalsIgnoreCase("false")) this.booleanResult = false;
			else
			{
				TelegramResult<Message> telegramResult = JsonUtils.toJavaObject(result, new TypeReference<TelegramResult<Message>>(){});
				this.messageResult = telegramResult.getResult();
			}
		}
	}
	
	public Boolean getBooleanResult(){return booleanResult;}
	public Message getMessageResult(){return messageResult;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof BooleanOrMessageResult)) return false;
		
		BooleanOrMessageResult that = (BooleanOrMessageResult) o;
		
		if(booleanResult != null ? !booleanResult.equals(that.booleanResult) : that.booleanResult != null) return false;
		return messageResult != null ? messageResult.equals(that.messageResult) : that.messageResult == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = booleanResult != null ? booleanResult.hashCode() : 0;
		result = 31 * result + (messageResult != null ? messageResult.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "BooleanOrMessageResult{" +
				"booleanResult=" + booleanResult +
				", messageResult=" + messageResult +
				'}';
	}
}