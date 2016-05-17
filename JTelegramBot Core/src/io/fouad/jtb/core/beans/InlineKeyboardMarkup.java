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
 * This object represents an inline inlineKeyboard that appears
 * right next to the message it belongs to.
 */
public class InlineKeyboardMarkup extends ReplyMarkup
{
	/**
	 * Array of button rows, each represented by an Array of
	 * InlineKeyboardButton objects
	 */
	@JsonProperty("inline_keyboard")
	private InlineKeyboardButton[][] inlineKeyboard;
	
	public InlineKeyboardMarkup(){}
	
	public InlineKeyboardMarkup(InlineKeyboardButton[][] inlineKeyboard)
	{
		this.inlineKeyboard = inlineKeyboard;
	}
	
	public InlineKeyboardButton[][] getInlineKeyboard(){return inlineKeyboard;}
	public void setInlineKeyboard(InlineKeyboardButton[][] inlineKeyboard){this.inlineKeyboard = inlineKeyboard;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof InlineKeyboardMarkup)) return false;
		
		InlineKeyboardMarkup that = (InlineKeyboardMarkup) o;
		
		return Arrays.deepEquals(inlineKeyboard, that.inlineKeyboard);
		
	}
	
	@Override
	public int hashCode()
	{
		return Arrays.deepHashCode(inlineKeyboard);
	}
	
	@Override
	public String toString()
	{
		return "InlineKeyboardMarkup{" +
				"inlineKeyboard=" + Arrays.deepToString(inlineKeyboard) +
				"}";
	}
}