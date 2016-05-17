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

import java.util.Arrays;

/**
 * This object represents a custom keyboard with reply options.
 */
public class ReplyKeyboardMarkup extends ReplyMarkup
{
	/**
	 * Array of button rows, each represented by an Array of
	 * KeyboardButton objects.
	 */
	@JsonProperty("keyboard")
	private KeyboardButton[][] keyboard;
	
	/**
	 * Optional. Requests clients to resize the keyboard vertically
	 * for optimal fit (e.g., make the keyboard smaller if there are
	 * just two rows of buttons). Defaults to false, in which case
	 * the custom keyboard is always of the same height as the app's
	 * standard keyboard.
	 */
	@JsonProperty("resize_keyboard")
	private Boolean resizeKeyboard;
	
	/**
	 * Optional. Requests clients to hide the keyboard as soon as it's
	 * been used. The keyboard will still be available, but clients will
	 * automatically display the usual letter-keyboard in the chat – the
	 * user can press a special button in the input field to see the
	 * custom keyboard again. Defaults to false.
	 */
	@JsonProperty("one_time_keyboard")
	private Boolean oneTimeKeyboard;
	
	/**
	 * Optional. Use this parameter if you want to show the keyboard
	 * to specific users only. Targets: 1) users that are @mentioned
	 * in the text of the Message object; 2) if the bot's message is
	 * a reply (has reply_to_message_id), sender of the original message.
	 * 
	 * Example: A user requests to change the bot‘s language, bot replies
	 * to the request with a keyboard to select the new language. Other
	 * users in the group don’t see the keyboard.
	 */
	@JsonProperty("selective")
	private Boolean selective;
	
	public ReplyKeyboardMarkup(){}
	
	public ReplyKeyboardMarkup(KeyboardButton[][] keyboard, Boolean resizeKeyboard, Boolean oneTimeKeyboard,
	                           Boolean selective)
	{
		this.keyboard = keyboard;
		this.resizeKeyboard = resizeKeyboard;
		this.oneTimeKeyboard = oneTimeKeyboard;
		this.selective = selective;
	}
	
	public KeyboardButton[][] getKeyboard(){return keyboard;}
	public void setKeyboard(KeyboardButton[][] keyboard){this.keyboard = keyboard;}
	
	public Boolean getResizeKeyboard(){return resizeKeyboard;}
	public void setResizeKeyboard(Boolean resizeKeyboard){this.resizeKeyboard = resizeKeyboard;}
	
	public Boolean getOneTimeKeyboard(){return oneTimeKeyboard;}
	public void setOneTimeKeyboard(Boolean oneTimeKeyboard){this.oneTimeKeyboard = oneTimeKeyboard;}
	
	public Boolean getSelective(){return selective;}
	public void setSelective(Boolean selective){this.selective = selective;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		
		ReplyKeyboardMarkup that = (ReplyKeyboardMarkup) o;
		
		if(!Arrays.deepEquals(keyboard, that.keyboard)) return false;
		if(resizeKeyboard != null ? !resizeKeyboard.equals(that.resizeKeyboard) : that.resizeKeyboard != null)
			return false;
		if(oneTimeKeyboard != null ? !oneTimeKeyboard.equals(that.oneTimeKeyboard) : that.oneTimeKeyboard != null)
			return false;
		return selective != null ? selective.equals(that.selective) : that.selective == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = Arrays.deepHashCode(keyboard);
		result = 31 * result + (resizeKeyboard != null ? resizeKeyboard.hashCode() : 0);
		result = 31 * result + (oneTimeKeyboard != null ? oneTimeKeyboard.hashCode() : 0);
		result = 31 * result + (selective != null ? selective.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "ReplyKeyboardMarkup{" +
				"keyboard=" + Arrays.deepToString(keyboard) +
				", resizeKeyboard=" + resizeKeyboard +
				", oneTimeKeyboard=" + oneTimeKeyboard +
				", selective=" + selective +
				'}';
	}
}