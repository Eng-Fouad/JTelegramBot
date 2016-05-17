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

package io.fouad.jtb.core.exceptions;

import com.fasterxml.jackson.core.type.TypeReference;
import io.fouad.jtb.core.beans.TelegramResult;
import io.fouad.jtb.core.utils.JsonUtils;

import java.io.IOException;

/**
 * This exception represents the negative (non-OK) response of a Telegram API request.
 */
public class NegativeResponseException extends Exception
{
	private static class Wrapper
	{
		private TelegramResult<?> telegramResult;
		private String message;
		
		public Wrapper(TelegramResult<?> telegramResult, String message)
		{
			this.telegramResult = telegramResult;
			this.message = message;
		}
	}
	
	private int httpResponseCode;
	private Integer errorCode;
	private String description;
	
	private NegativeResponseException(int httpResponseCode, Wrapper wrapper)
	{
		super(wrapper.message);
		
		this.httpResponseCode = httpResponseCode;
		
		TelegramResult<?> telegramResult = wrapper.telegramResult;
		if(telegramResult != null) this.errorCode = telegramResult.getErrorCode();
		if(telegramResult != null) this.description = telegramResult.getDescription();
	}
	
	public NegativeResponseException(int httpResponseCode, String response)
	{
		this(httpResponseCode, buildWrapper(response));
	}
	
	public NegativeResponseException(int httpResponseCode, TelegramResult<?> telegramResult)
	{
		this(httpResponseCode, buildWrapper(telegramResult));
	}
	
	public int getHttpResponseCode(){return httpResponseCode;}
	public Integer getErrorCode(){return errorCode;}
	public String getDescription(){return description;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		
		NegativeResponseException that = (NegativeResponseException) o;
		
		if(httpResponseCode != that.httpResponseCode) return false;
		if(errorCode != null ? !errorCode.equals(that.errorCode) : that.errorCode != null) return false;
		return description != null ? description.equals(that.description) : that.description == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = httpResponseCode;
		result = 31 * result + (errorCode != null ? errorCode.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "NegativeResponseException{" +
				"httpResponseCode=" + httpResponseCode +
				", errorCode=" + errorCode +
				", description='" + description + '\'' +
				"} " + super.toString();
	}
	
	private static Wrapper buildWrapper(String response)
	{
		String message = null;
		TelegramResult<Void> telegramResult = null;
		
		try
		{
			telegramResult = JsonUtils.toJavaObject(response, new TypeReference<TelegramResult<Void>>(){});
			Integer errorCode = telegramResult.getErrorCode();
			String description = telegramResult.getDescription();
			
			message = "Error Code = " + errorCode + " | Description = " + description;
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return new Wrapper(telegramResult, message);
	}
	
	private static Wrapper buildWrapper(TelegramResult<?> telegramResult)
	{
		Integer errorCode = telegramResult.getErrorCode();
		String description = telegramResult.getDescription();
		
		String message = "Error Code = " + errorCode + " | Description = " + description;
		
		return new Wrapper(telegramResult, message);
	}
}