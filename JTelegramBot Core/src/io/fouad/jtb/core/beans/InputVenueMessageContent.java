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
 * Represents the content of a venue message to be sent as the result
 * of an inline query.
 */
public class InputVenueMessageContent extends InputMessageContent
{
	/**
	 * Latitude of the venue in degrees.
	 */
	@JsonProperty("latitude")
	private double latitude;
	
	/**
	 * Longitude of the venue in degrees.
	 */
	@JsonProperty("longitude")
	private double longitude;
	
	/**
	 * Name of the venue.
	 */
	@JsonProperty("title")
	private String title;
	
	/**
	 * Address of the venue.
	 */
	@JsonProperty("address")
	private String address;
	
	/**
	 * Optional. Foursquare identifier of the venue, if known.
	 */
	@JsonProperty("foursquare_id")
	private String foursquareId;
	
	public InputVenueMessageContent(){}
	
	public InputVenueMessageContent(double latitude, double longitude, String title, String address,
	                                String foursquareId)
	{
		this.latitude = latitude;
		this.longitude = longitude;
		this.title = title;
		this.address = address;
		this.foursquareId = foursquareId;
	}
	
	public double getLatitude(){return latitude;}
	public void setLatitude(double latitude){this.latitude = latitude;}
	
	public double getLongitude(){return longitude;}
	public void setLongitude(double longitude){this.longitude = longitude;}
	
	public String getTitle(){return title;}
	public void setTitle(String title){this.title = title;}
	
	public String getAddress(){return address;}
	public void setAddress(String address){this.address = address;}
	
	public String getFoursquareId(){return foursquareId;}
	public void setFoursquareId(String foursquareId){this.foursquareId = foursquareId;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof InputVenueMessageContent)) return false;
		
		InputVenueMessageContent that = (InputVenueMessageContent) o;
		
		if(Double.compare(that.latitude, latitude) != 0) return false;
		if(Double.compare(that.longitude, longitude) != 0) return false;
		if(title != null ? !title.equals(that.title) : that.title != null) return false;
		if(address != null ? !address.equals(that.address) : that.address != null) return false;
		return foursquareId != null ? foursquareId.equals(that.foursquareId) : that.foursquareId == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (address != null ? address.hashCode() : 0);
		result = 31 * result + (foursquareId != null ? foursquareId.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "InputVenueMessageContent{" +
				"latitude=" + latitude +
				", longitude=" + longitude +
				", title='" + title + '\'' +
				", address='" + address + '\'' +
				", foursquareId='" + foursquareId + '\'' +
				"}";
	}
}