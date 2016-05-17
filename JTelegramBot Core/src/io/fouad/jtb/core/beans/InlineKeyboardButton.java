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
 * This object represents one button of an inline keyboard.
 * You must use exactly one of the optional fields.
 */
public class InlineKeyboardButton
{
	/**
	 * Label text on the button.
	 */
	@JsonProperty("text")
	private String text;
	
	/**
	 * Optional. HTTP url to be opened when button is pressed.
	 */
	@JsonProperty("url")
	private String url;
	
	/**
	 * Optional. Data to be sent in a callback query to the bot
	 * when button is pressed.
	 */
	@JsonProperty("callback_data")
	private String callbackData;
	
	/**
	 * Optional. If set, pressing the button will prompt the user
	 * to select one of their chats, open that chat and insert the
	 * bot‘s username and the specified inline query in the input
	 * field. Can be empty, in which case just the bot’s username
	 * will be inserted.
	 * 
	 * Note: This offers an easy way for users to start using your bot
	 * in inline mode when they are currently in a private chat with it.
	 * Especially useful when combined with switch_pm… actions – in this
	 * case the user will be automatically returned to the chat they
	 * switched from, skipping the chat selection screen.
	 */
	@JsonProperty("switch_inline_query")
	private String switchInlineQuery;
	
	public InlineKeyboardButton(){}
	
	public InlineKeyboardButton(String text, String url, String callbackData, String switchInlineQuery)
	{
		this.text = text;
		this.url = url;
		this.callbackData = callbackData;
		this.switchInlineQuery = switchInlineQuery;
	}
	
	public String getText(){return text;}
	public void setText(String text){this.text = text;}
	
	public String getUrl(){return url;}
	public void setUrl(String url){this.url = url;}
	
	public String getCallbackData(){return callbackData;}
	public void setCallbackData(String callbackData){this.callbackData = callbackData;}
	
	public String getSwitchInlineQuery(){return switchInlineQuery;}
	public void setSwitchInlineQuery(String switchInlineQuery){this.switchInlineQuery = switchInlineQuery;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof InlineKeyboardButton)) return false;
		
		InlineKeyboardButton that = (InlineKeyboardButton) o;
		
		if(text != null ? !text.equals(that.text) : that.text != null) return false;
		if(url != null ? !url.equals(that.url) : that.url != null) return false;
		if(callbackData != null ? !callbackData.equals(that.callbackData) : that.callbackData != null) return false;
		return switchInlineQuery != null ? switchInlineQuery.equals(that.switchInlineQuery)
		                                 : that.switchInlineQuery == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = text != null ? text.hashCode() : 0;
		result = 31 * result + (url != null ? url.hashCode() : 0);
		result = 31 * result + (callbackData != null ? callbackData.hashCode() : 0);
		result = 31 * result + (switchInlineQuery != null ? switchInlineQuery.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "InlineKeyboardButton{" +
				"text='" + text + '\'' +
				", url='" + url + '\'' +
				", callbackData='" + callbackData + '\'' +
				", switchInlineQuery='" + switchInlineQuery + '\'' +
				'}';
	}
}