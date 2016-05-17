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
 * This class represents the response received from Telegram
 * upon sending requests through the API.
 */
public class TelegramResult<R>
{
	/**
	 * indicates whether the request was successful or not.
	 */
	@JsonProperty("ok")
	private boolean ok;
	
	/**
	 * optional. the error code when ok == false.
	 */
	@JsonProperty("error_code")
	private Integer errorCode;
	
	/**
	 * result of the query.
	 */
	@JsonProperty("result")
	private R result;
	
	/**
	 * optional. a human-readable description of the result.
	 */
	@JsonProperty("description")
	private String description;
	
	public TelegramResult(){}
	
	public TelegramResult(boolean ok, Integer errorCode, R result, String description)
	{
		this.ok = ok;
		this.errorCode = errorCode;
		this.result = result;
		this.description = description;
	}
	
	public boolean isOk(){return ok;}
	public Integer getErrorCode(){return errorCode;}
	public R getResult(){return result;}
	public String getDescription(){return description;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		
		TelegramResult<?> that = (TelegramResult<?>) o;
		
		if(ok != that.ok) return false;
		if(errorCode != null ? !errorCode.equals(that.errorCode) : that.errorCode != null) return false;
		if(result != null ? !result.equals(that.result) : that.result != null) return false;
		return description != null ? description.equals(that.description) : that.description == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result1 = (ok ? 1 : 0);
		result1 = 31 * result1 + (errorCode != null ? errorCode.hashCode() : 0);
		result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
		result1 = 31 * result1 + (description != null ? description.hashCode() : 0);
		return result1;
	}
	
	@Override
	public String toString()
	{
		return "TelegramResult{" +
				"ok=" + ok +
				", errorCode=" + errorCode +
				", result=" + result +
				", description='" + description + '\'' +
				'}';
	}
}