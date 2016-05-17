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

package io.fouad.jtb.core.builders;

import io.fouad.jtb.core.beans.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

/**
 * A builder class to build 2D array of <code>InlineKeyboardButton</code> objects.
 */
public class InlineKeyboardButtonBuilder
{
	/**
	 * Starts a new row of the inline keyboard.
	 */
	public static Row newRow() // first row
	{
		List<List<InlineKeyboardButton>> twoDimensionKeyboardButtons = new ArrayList<List<InlineKeyboardButton>>();
		return new Row(twoDimensionKeyboardButtons);
	}
	
	public static class Row
	{
		private List<List<InlineKeyboardButton>> twoDimensionInlineKeyboardButtons;
		private List<InlineKeyboardButton> rowInlineKeyboardButtons = new ArrayList<InlineKeyboardButton>();
		
		private Row(List<List<InlineKeyboardButton>> twoDimensionInlineKeyboardButtons)
		{
			this.twoDimensionInlineKeyboardButtons = twoDimensionInlineKeyboardButtons;
			this.twoDimensionInlineKeyboardButtons.add(rowInlineKeyboardButtons);
		}
		
		/**
		 * Adds a new button in the row.
		 * 
		 * @param text text of the new button
		 */
		public ButtonSet newButton(String text) // first button
		{
			InlineKeyboardButton firstInlineKeyboardButton = new InlineKeyboardButton(text, null, null, null);
			
			return new ButtonSet(twoDimensionInlineKeyboardButtons, rowInlineKeyboardButtons, firstInlineKeyboardButton);
		}
		
		/**
		 * Builds the inline keyboard.
		 * 
		 * @return the inline keyboard
		 */
		public InlineKeyboardButton[][] build()
		{
			return InlineKeyboardButtonBuilder.build(twoDimensionInlineKeyboardButtons);
		}
	}
	
	public static class ButtonSet
	{
		private List<List<InlineKeyboardButton>> twoDimensionInlineKeyboardButtons;
		private List<InlineKeyboardButton> rowInlineKeyboardButtons;
		private InlineKeyboardButton currentInlineKeyboardButton;
		
		private ButtonSet(List<List<InlineKeyboardButton>> twoDimensionInlineKeyboardButtons, List<InlineKeyboardButton> rowInlineKeyboardButtons,
		                  InlineKeyboardButton firstInlineKeyboardButton)
		{
			this.twoDimensionInlineKeyboardButtons = twoDimensionInlineKeyboardButtons;
			this.rowInlineKeyboardButtons = rowInlineKeyboardButtons;
			this.currentInlineKeyboardButton = firstInlineKeyboardButton;
		}
		
		/**
		 * Adds a new button in the row.
		 *
		 * @param text text of the new button
		 */
		public ButtonSet newButton(String text)
		{
			rowInlineKeyboardButtons.add(currentInlineKeyboardButton);
			currentInlineKeyboardButton = new InlineKeyboardButton(text, null, null, null);
			
			return this;
		}
		
		/**
		 * HTTP url to be opened when button is pressed
		 * 
		 * @param url the url
		 */
		public ButtonSetWithNoOptional withUrl(String url)
		{
			currentInlineKeyboardButton.setUrl(url);
			
			return new ButtonSetWithNoOptional(this);
		}
		
		/**
		 * Data to be sent in a callback query to the bot when button is pressed, 1-64 bytes.
		 * 
		 * @param callbackData the callback data
		 */
		public ButtonSetWithNoOptional withCallbackData(String callbackData)
		{
			currentInlineKeyboardButton.setCallbackData(callbackData);
			
			return new ButtonSetWithNoOptional(this);
		}
		
		/**
		 * If set, pressing the button will prompt the user to select one of their chats, open
		 * that chat and insert the bot‘s username and the specified inline query in the input
		 * field. Can be empty, in which case just the bot’s username will be inserted.
		 * 
		 * @param switchInlineQuery the inline query
		 */
		public ButtonSetWithNoOptional withSwitchInlineQuery(String switchInlineQuery)
		{
			currentInlineKeyboardButton.setSwitchInlineQuery(switchInlineQuery);
			
			return new ButtonSetWithNoOptional(this);
		}
		
		/**
		 * Starts a new row of the inline keyboard.
		 */
		public Row newRow()
		{
			rowInlineKeyboardButtons.add(currentInlineKeyboardButton);
			
			return new Row(twoDimensionInlineKeyboardButtons);
		}
		
		/**
		 * Builds the inline keyboard.
		 *
		 * @return the inline keyboard
		 */
		public InlineKeyboardButton[][] build()
		{
			return InlineKeyboardButtonBuilder.build(twoDimensionInlineKeyboardButtons);
		}
	}
	
	public static class ButtonSetWithNoOptional
	{
		private ButtonSet currentButtonSet;
		
		private ButtonSetWithNoOptional(ButtonSet currentButtonSet)
		{
			this.currentButtonSet = currentButtonSet;
		}
		
		/**
		 * Adds a new button in the row.
		 *
		 * @param text text of the new button
		 */
		public ButtonSet newButton(String text)
		{
			return currentButtonSet.newButton(text);
		}
		
		/**
		 * Starts a new row of the inline keyboard.
		 */
		public Row newRow()
		{
			return currentButtonSet.newRow();
		}
		
		/**
		 * Builds the inline keyboard.
		 *
		 * @return the inline keyboard
		 */
		public InlineKeyboardButton[][] build()
		{
			return currentButtonSet.build();
		}
	}
		
	private static InlineKeyboardButton[][] build(List<List<InlineKeyboardButton>> twoDimensionKeyboardButtons)
	{
		int outerArrayLength = twoDimensionKeyboardButtons.size();
		InlineKeyboardButton[][] array = new InlineKeyboardButton[outerArrayLength][];
		
		for(int i = 0; i < outerArrayLength; i++)
		{
			List<InlineKeyboardButton> rowKeyboardButtons = twoDimensionKeyboardButtons.get(i);
			int innerArrayLength = rowKeyboardButtons.size();
			
			array[i] = new InlineKeyboardButton[innerArrayLength];
			
			for(int j = 0; j < innerArrayLength; j++)
			{
				array[i][j] = rowKeyboardButtons.get(j);
			}
		}
		
		return array;
	}
}