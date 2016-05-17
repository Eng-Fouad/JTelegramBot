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
 * This object represents a video file.
 */
public class Video
{
	/**
	 * Unique identifier for this file.
	 */
	@JsonProperty("file_id")
	private String fileId;
	
	/**
	 * Video width as defined by sender.
	 */
	@JsonProperty("width")
	private int width;
	
	/**
	 * Video height as defined by sender.
	 */
	@JsonProperty("height")
	private int height;
	
	/**
	 * Duration of the video in seconds as defined by sender.
	 */
	@JsonProperty("duration")
	private int duration;
	
	/**
	 * Optional. Video thumbnail.
	 */
	@JsonProperty("thumb")
	private PhotoSize thumb;
	
	/**
	 * Optional. Mime type of a file as defined by sender.
	 */
	@JsonProperty("mime_type")
	private String mimeType;
	
	/**
	 * Optional. TelegramFile size.
	 */
	@JsonProperty("file_size")
	private Integer fileSize;
	
	public Video(){}
	
	public Video(String fileId, int width, int height, int duration, PhotoSize thumb, String mimeType, Integer fileSize)
	{
		this.fileId = fileId;
		this.width = width;
		this.height = height;
		this.duration = duration;
		this.thumb = thumb;
		this.mimeType = mimeType;
		this.fileSize = fileSize;
	}
	
	public String getFileId(){return fileId;}
	public int getWidth(){return width;}
	public int getHeight(){return height;}
	public int getDuration(){return duration;}
	public PhotoSize getThumb(){return thumb;}
	public String getMimeType(){return mimeType;}
	public Integer getFileSize(){return fileSize;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		
		Video video = (Video) o;
		
		if(width != video.width) return false;
		if(height != video.height) return false;
		if(duration != video.duration) return false;
		if(fileId != null ? !fileId.equals(video.fileId) : video.fileId != null) return false;
		if(thumb != null ? !thumb.equals(video.thumb) : video.thumb != null) return false;
		if(mimeType != null ? !mimeType.equals(video.mimeType) : video.mimeType != null) return false;
		return fileSize != null ? fileSize.equals(video.fileSize) : video.fileSize == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = fileId != null ? fileId.hashCode() : 0;
		result = 31 * result + width;
		result = 31 * result + height;
		result = 31 * result + duration;
		result = 31 * result + (thumb != null ? thumb.hashCode() : 0);
		result = 31 * result + (mimeType != null ? mimeType.hashCode() : 0);
		result = 31 * result + (fileSize != null ? fileSize.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "Video{" +
				"fileId='" + fileId + '\'' +
				", width=" + width +
				", height=" + height +
				", duration=" + duration +
				", thumb=" + thumb +
				", mimeType='" + mimeType + '\'' +
				", fileSize=" + fileSize +
				'}';
	}
}