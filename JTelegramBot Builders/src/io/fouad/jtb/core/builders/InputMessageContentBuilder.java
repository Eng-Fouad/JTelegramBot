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

import io.fouad.jtb.core.enums.ParseMode;
import io.fouad.jtb.core.beans.InputContactMessageContent;
import io.fouad.jtb.core.beans.InputLocationMessageContent;
import io.fouad.jtb.core.beans.InputMessageContent;
import io.fouad.jtb.core.beans.InputTextMessageContent;
import io.fouad.jtb.core.beans.InputVenueMessageContent;

/**
 * A builder class to build one of the following 4 types:
 *
 * - InputTextMessageContent
 * - InputLocationMessageContent
 * - InputVenueMessageContent
 * - InputContactMessageContent
 */
public class InputMessageContentBuilder
{
	/**
	 * Represents the content of a text message to be sent as the result of an inline query.
	 */
	public static InputTextMessageContentNoText asTextMessage()
	{
		return new InputTextMessageContentNoText();
	}
	
	/**
	 * Represents the content of a location message to be sent as the result of an inline query.
	 */
	public static InputLocationMessageContentNoLatitudeNoLongitude asLocationMessage()
	{
		return new InputLocationMessageContentNoLatitudeNoLongitude();
	}
	
	/**
	 * Represents the content of a venue message to be sent as the result of an inline query.
	 */
	public static InputVenueMessageContentNoLatitudeNoLongitudeNoTitleNoAddress asVenueMessage()
	{
		return new InputVenueMessageContentNoLatitudeNoLongitudeNoTitleNoAddress();
	}
	
	/**
	 * Represents the content of a contact message to be sent as the result of an inline query.
	 */
	public static InputContactMessageContentNoPhoneNumberNoFirstName asContactMessage()
	{
		return new InputContactMessageContentNoPhoneNumberNoFirstName();
	}
	
	public static class InputTextMessageContentNoText
	{
		public InputTextMessageContentNoText(){}
		
		/**
		 * Text of the message to be sent, 1-4096 characters.
		 *
		 * @param text the message text
		 */
		public InputTextMessageContentReady withText(String text)
		{
			return new InputTextMessageContentReady(text);
		}
	}
	
	public static class InputTextMessageContentReady
	{
		private String text;
		private ParseMode parseMode;
		private Boolean disableLinkPreviews;
		
		public InputTextMessageContentReady(String text)
		{
			this.text = text;
		}
		
		/**
		 * Sends Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width
		 * text or inline URLs in your bot's message
		 *
		 * @param parseMode either Markdown or HTML
		 */
		public InputTextMessageContentReady parseMessageAs(ParseMode parseMode)
		{
			this.parseMode = parseMode;
			return this;
		}
		
		/**
		 * Disables link previews for links in this message.
		 */
		public InputTextMessageContentReady disableLinkPreviews()
		{
			this.disableLinkPreviews = true;
			return this;
		}
		
		/**
		 * Builds the <code>InputMessageContent</code> object.
		 */
		public InputMessageContent buildMessageContent()
		{
			return new InputTextMessageContent(text, parseMode, disableLinkPreviews);
		}
	}
	
	public static class InputLocationMessageContentNoLatitudeNoLongitude
	{
		public InputLocationMessageContentNoLatitudeNoLongitude(){}
		
		/**
		 * Latitude of the location.
		 *
		 * @param latitude latitude of the location in degrees
		 */
		public InputLocationMessageContentNoLongitude withLatitude(double latitude)
		{
			return new InputLocationMessageContentNoLongitude(latitude);
		}
	}
	
	public static class InputLocationMessageContentNoLongitude
	{
		
		private double latitude;
		
		public InputLocationMessageContentNoLongitude(double latitude)
		{
			this.latitude = latitude;
		}
		
		/**
		 * Longitude of the location.
		 *
		 * @param longitude longitude of the location in degrees
		 */
		public InputLocationMessageContentReady withLongitude(double longitude)
		{
			return new InputLocationMessageContentReady(latitude, longitude);
		}
	}
	
	public static class InputLocationMessageContentReady
	{
		private double latitude;
		private double longitude;
		
		public InputLocationMessageContentReady(double latitude, double longitude)
		{
			this.latitude = latitude;
			this.longitude = longitude;
		}
		
		/**
		 * Builds the <code>InputMessageContent</code> object.
		 */
		public InputMessageContent buildMessageContent()
		{
			return new InputLocationMessageContent(latitude, longitude);
		}
	}
	
	public static class InputVenueMessageContentNoLatitudeNoLongitudeNoTitleNoAddress
	{
		public InputVenueMessageContentNoLatitudeNoLongitudeNoTitleNoAddress(){}
		
		/**
		 * Latitude of the venue.
		 *
		 * @param latitude latitude of the venue in degrees
		 */
		public InputVenueMessageContentNoLongitudeNoTitleNoAddress withLatitude(double latitude)
		{
			return new InputVenueMessageContentNoLongitudeNoTitleNoAddress(latitude);
		}
	}
	
	public static class InputVenueMessageContentNoLongitudeNoTitleNoAddress
	{
		private double latitude;
		
		public InputVenueMessageContentNoLongitudeNoTitleNoAddress(double latitude)
		{
			this.latitude = latitude;
		}
		
		/**
		 * Longitude of the location.
		 *
		 * @param longitude longitude of the location in degrees
		 */
		public InputVenueMessageContentNoTitleNoAddress withLongitude(double longitude)
		{
			return new InputVenueMessageContentNoTitleNoAddress(latitude, longitude);
		}
	}
	
	public static class InputVenueMessageContentNoTitleNoAddress
	{
		private double latitude;
		private double longitude;
		
		public InputVenueMessageContentNoTitleNoAddress(double latitude, double longitude)
		{
			this.latitude = latitude;
			this.longitude = longitude;
		}
		
		/**
		 * Name of the venue.
		 *
		 * @param title the title
		 */
		public InputVenueMessageContentNoAddress withTitle(String title)
		{
			return new InputVenueMessageContentNoAddress(latitude, longitude, title);
		}
	}
	
	public static class InputVenueMessageContentNoAddress
	{
		private double latitude;
		private double longitude;
		private String title;
		
		public InputVenueMessageContentNoAddress(double latitude, double longitude, String title)
		{
			this.latitude = latitude;
			this.longitude = longitude;
			this.title = title;
		}
		
		/**
		 * Address of the venue.
		 *
		 * @param address the address
		 */
		public InputVenueMessageContentReady withAddress(String address)
		{
			return new InputVenueMessageContentReady(latitude, longitude, title, address);
		}
	}
	
	public static class InputVenueMessageContentReady
	{
		private double latitude;
		private double longitude;
		private String title;
		private String address;
		private String foursquareId;
		
		public InputVenueMessageContentReady(double latitude, double longitude, String title, String address)
		{
			this.latitude = latitude;
			this.longitude = longitude;
			this.title = title;
			this.address = address;
		}
		
		/**
		 * Foursquare identifier of the venue.
		 *
		 * @param foursquareId foursquare id
		 */
		public InputVenueMessageContentReady withFoursquareId(String foursquareId)
		{
			this.foursquareId = foursquareId;
			return this;
		}
		
		/**
		 * Builds the <code>InputMessageContent</code> object.
		 */
		public InputMessageContent buildMessageContent()
		{
			return new InputVenueMessageContent(latitude, longitude, title, address, foursquareId);
		}
	}
	
	public static class InputContactMessageContentNoPhoneNumberNoFirstName
	{
		public InputContactMessageContentNoPhoneNumberNoFirstName(){}
		
		/**
		 * Contact's phone number.
		 *
		 * @param phoneNumber contact's phone number
		 */
		public InputContactMessageContentNoFirstName withPhoneNumber(String phoneNumber)
		{
			return new InputContactMessageContentNoFirstName(phoneNumber);
		}
	}
	
	public static class InputContactMessageContentNoFirstName
	{
		private String phoneNumber;
		
		public InputContactMessageContentNoFirstName(String phoneNumber)
		{
			this.phoneNumber = phoneNumber;
		}
		
		/**
		 * Contact's first name.
		 *
		 * @param firstName contact's first name
		 */
		public InputContactMessageContentReady withFirstName(String firstName)
		{
			return new InputContactMessageContentReady(phoneNumber, firstName);
		}
	}
	
	public static class InputContactMessageContentReady
	{
		private String phoneNumber;
		private String firstName;
		private String lastName;
		
		public InputContactMessageContentReady(String phoneNumber, String firstName)
		{
			this.phoneNumber = phoneNumber;
			this.firstName = firstName;
		}
		
		/**
		 * Contact's last name.
		 *
		 * @param lastName contact's last name
		 */
		public InputContactMessageContentReady withLastName(String lastName)
		{
			this.lastName = lastName;
			return this;
		}
		
		/**
		 * Builds the <code>InputMessageContent</code> object.
		 */
		public InputMessageContent buildMessageContent()
		{
			return new InputContactMessageContent(phoneNumber, firstName, lastName);
		}
	}
}