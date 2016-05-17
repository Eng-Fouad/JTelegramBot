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
 * Represents the content of a location message to be sent as the
 * result of an inline query.
 */
public class InputLocationMessageContent extends InputMessageContent
{
	/**
	 * Latitude of the location in degrees.
	 */
	@JsonProperty("latitude")
	private double latitude;
	
	/**
	 * Longitude of the location in degrees.
	 */
	@JsonProperty("longitude")
	private double longitude;
	
	public InputLocationMessageContent(){}
	
	public InputLocationMessageContent(double latitude, double longitude)
	{
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public double getLatitude(){return latitude;}
	public void setLatitude(double latitude){this.latitude = latitude;}
	
	public double getLongitude(){return longitude;}
	public void setLongitude(double longitude){this.longitude = longitude;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof InputLocationMessageContent)) return false;
		
		InputLocationMessageContent that = (InputLocationMessageContent) o;
		
		if(Double.compare(that.latitude, latitude) != 0) return false;
		return Double.compare(that.longitude, longitude) == 0;
		
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
		return result;
	}
	
	@Override
	public String toString()
	{
		return "InputLocationMessageContent{" +
				"latitude=" + latitude +
				", longitude=" + longitude +
				"}";
	}
}