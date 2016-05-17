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
 * This object represents a point on the map.
 */
public class Location
{
	/**
	 * Longitude as defined by sender.
	 */
	@JsonProperty("longitude")
	private float longitude;
	
	/**
	 * Latitude as defined by sender.
	 */
	@JsonProperty("latitude")
	private float latitude;
	
	public Location(){}
	
	public Location(float longitude, float latitude)
	{
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public float getLongitude(){return longitude;}
	public float getLatitude(){return latitude;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		
		Location location = (Location) o;
		
		if(Float.compare(location.longitude, longitude) != 0) return false;
		return Float.compare(location.latitude, latitude) == 0;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = (longitude != +0.0f ? Float.floatToIntBits(longitude) : 0);
		result = 31 * result + (latitude != +0.0f ? Float.floatToIntBits(latitude) : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "Location{" +
				"longitude=" + longitude +
				", latitude=" + latitude +
				'}';
	}
}