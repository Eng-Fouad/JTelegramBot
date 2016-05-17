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
 * This object represents a sticker.
 */
public class Sticker
{
	/**
	 * Unique identifier for this file.
	 */
	@JsonProperty("file_id")
	private String fileId;
	
	/**
	 * Sticker width.
	 */
	@JsonProperty("width")
	private int width;
	
	/**
	 * Sticker height.
	 */
	@JsonProperty("height")
	private int height;
	
	/**
	 * Optional. Sticker thumbnail in .webp or .jpg format.
	 */
	@JsonProperty("thumb")
	private PhotoSize thumb;
	
	/**
	 * Optional. Emoji associated with the sticker.
	 */
	@JsonProperty("emoji")
	private String emoji;
	
	/**
	 * Optional. TelegramFile size.
	 */
	@JsonProperty("file_size")
	private Integer fileSize;
	
	public Sticker(){}
	
	public Sticker(String fileId, int width, int height, PhotoSize thumb, String emoji, Integer fileSize)
	{
		this.fileId = fileId;
		this.width = width;
		this.height = height;
		this.thumb = thumb;
		this.emoji = emoji;
		this.fileSize = fileSize;
	}
	
	public String getFileId(){return fileId;}
	public int getWidth(){return width;}
	public int getHeight(){return height;}
	public PhotoSize getThumb(){return thumb;}
	public String getEmoji(){return emoji;}
	public Integer getFileSize(){return fileSize;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof Sticker)) return false;
		
		Sticker sticker = (Sticker) o;
		
		if(width != sticker.width) return false;
		if(height != sticker.height) return false;
		if(fileId != null ? !fileId.equals(sticker.fileId) : sticker.fileId != null) return false;
		if(thumb != null ? !thumb.equals(sticker.thumb) : sticker.thumb != null) return false;
		if(emoji != null ? !emoji.equals(sticker.emoji) : sticker.emoji != null) return false;
		return fileSize != null ? fileSize.equals(sticker.fileSize) : sticker.fileSize == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = fileId != null ? fileId.hashCode() : 0;
		result = 31 * result + width;
		result = 31 * result + height;
		result = 31 * result + (thumb != null ? thumb.hashCode() : 0);
		result = 31 * result + (emoji != null ? emoji.hashCode() : 0);
		result = 31 * result + (fileSize != null ? fileSize.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "Sticker{" +
				"fileId='" + fileId + '\'' +
				", width=" + width +
				", height=" + height +
				", thumb=" + thumb +
				", emoji='" + emoji + '\'' +
				", fileSize=" + fileSize +
				'}';
	}
}