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

import io.fouad.jtb.core.beans.KeyboardButton;

import java.util.ArrayList;
import java.util.List;

/**
 * A builder class to build 2D array of <code>KeyboardButton</code> objects.
 */
public class KeyboardButtonBuilder
{
	/**
	 * Starts a new row of the keyboard.
	 */
	public static Row newRow() // first row
	{
		List<List<KeyboardButton>> twoDimensionKeyboardButtons = new ArrayList<List<KeyboardButton>>();
		return new Row(twoDimensionKeyboardButtons);
	}
	
	public static class Row
	{
		private List<List<KeyboardButton>> twoDimensionKeyboardButtons;
		private List<KeyboardButton> rowKeyboardButtons = new ArrayList<KeyboardButton>();
		
		private Row(List<List<KeyboardButton>> twoDimensionKeyboardButtons)
		{
			this.twoDimensionKeyboardButtons = twoDimensionKeyboardButtons;
			this.twoDimensionKeyboardButtons.add(rowKeyboardButtons);
		}
		
		/**
		 * Adds a new button in the row.
		 *
		 * @param text text of the new button
		 */
		public ButtonSet newButton(String text) // first button
		{
			KeyboardButton firstKeyboardButton = new KeyboardButton(text, null, null);
			
			return new ButtonSet(twoDimensionKeyboardButtons, rowKeyboardButtons, firstKeyboardButton);
		}
		
		/**
		 * Builds the keyboard.
		 *
		 * @return the keyboard
		 */
		public KeyboardButton[][] build()
		{
			return KeyboardButtonBuilder.build(twoDimensionKeyboardButtons);
		}
	}
	
	public static class ButtonSet
	{
		private List<List<KeyboardButton>> twoDimensionKeyboardButtons;
		private List<KeyboardButton> rowKeyboardButtons;
		private KeyboardButton currentKeyboardButton;
		
		private ButtonSet(List<List<KeyboardButton>> twoDimensionKeyboardButtons, List<KeyboardButton> rowKeyboardButtons, KeyboardButton firstKeyboardButton)
		{
			this.twoDimensionKeyboardButtons = twoDimensionKeyboardButtons;
			this.rowKeyboardButtons = rowKeyboardButtons;
			this.currentKeyboardButton = firstKeyboardButton;
		}
		
		/**
		 * Adds a new button in the row.
		 *
		 * @param text text of the new button
		 */
		public ButtonSet newButton(String text)
		{
			rowKeyboardButtons.add(currentKeyboardButton);
			currentKeyboardButton = new KeyboardButton(text, null, null);
			
			return this;
		}
		
		/**
		 * the user's phone number will be sent as a contact when the button
		 * is pressed. Available in private chats only.
		 * 
		 * If requestContact() is invoked, requestLocation() will be discarded.
		 */
		public ButtonSet requestContact()
		{
			currentKeyboardButton.setRequestContact(true);
			currentKeyboardButton.setRequestLocation(null);
			
			return this;
		}
		
		/**
		 * the user's current location will be sent when the button is pressed.
		 * Available in private chats only.
		 * 
		 * If requestLocation() is invoked, requestContact() will be discarded.
		 */
		public ButtonSet requestLocation()
		{
			currentKeyboardButton.setRequestLocation(true);
			currentKeyboardButton.setRequestContact(null);
			
			return this;
		}
		
		/**
		 * Starts a new row of the keyboard.
		 */
		public Row newRow()
		{
			rowKeyboardButtons.add(currentKeyboardButton);
			
			return new Row(twoDimensionKeyboardButtons);
		}
		
		/**
		 * Builds the keyboard.
		 *
		 * @return the keyboard
		 */
		public KeyboardButton[][] build()
		{
			return KeyboardButtonBuilder.build(twoDimensionKeyboardButtons);
		}
	}
	
	private static KeyboardButton[][] build(List<List<KeyboardButton>> twoDimensionKeyboardButtons)
	{
		int outerArrayLength = twoDimensionKeyboardButtons.size();
		KeyboardButton[][] array = new KeyboardButton[outerArrayLength][];
		
		for(int i = 0; i < outerArrayLength; i++)
		{
			List<KeyboardButton> rowKeyboardButtons = twoDimensionKeyboardButtons.get(i);
			int innerArrayLength = rowKeyboardButtons.size();
			
			array[i] = new KeyboardButton[innerArrayLength];
			
			for(int j = 0; j < innerArrayLength; j++)
			{
				array[i][j] = rowKeyboardButtons.get(j);
			}
		}
		
		return array;
	}
}