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
 * This object represents a venue.
 */
public class Venue
{
	/**
	 * Venue location.
	 */
	@JsonProperty("location")
	private Location location;
	
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
	 * Optional. Foursquare identifier of the venue.
	 */
	@JsonProperty("foursquare_id")
	private String foursquare_id;
	
	public Venue(){}
	
	public Venue(Location location, String title, String address, String foursquare_id)
	{
		this.location = location;
		this.title = title;
		this.address = address;
		this.foursquare_id = foursquare_id;
	}
	
	public Location getLocation(){return location;}
	public String getTitle(){return title;}
	public String getAddress(){return address;}
	public String getFoursquare_id(){return foursquare_id;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof Venue)) return false;
		
		Venue venue = (Venue) o;
		
		if(location != null ? !location.equals(venue.location) : venue.location != null) return false;
		if(title != null ? !title.equals(venue.title) : venue.title != null) return false;
		if(address != null ? !address.equals(venue.address) : venue.address != null) return false;
		return foursquare_id != null ? foursquare_id.equals(venue.foursquare_id) : venue.foursquare_id == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = location != null ? location.hashCode() : 0;
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (address != null ? address.hashCode() : 0);
		result = 31 * result + (foursquare_id != null ? foursquare_id.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "Venue{" +
				"location=" + location +
				", title='" + title + '\'' +
				", address='" + address + '\'' +
				", foursquare_id='" + foursquare_id + '\'' +
				'}';
	}
}