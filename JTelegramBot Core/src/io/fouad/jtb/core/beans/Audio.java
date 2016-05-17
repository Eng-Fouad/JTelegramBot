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
 * This object represents an audio file to be treated as music
 * by the Telegram clients.
 */
public class Audio
{
	/**
	 * Unique identifier for this file.
	 */
	@JsonProperty("file_id")
	private String fileId;
	
	/**
	 * Duration of the audio in seconds as defined by sender.
	 */
	@JsonProperty("duration")
	private int duration;
	
	/**
	 * Optional. Performer of the audio as defined by sender
	 * or by audio tags.
	 */
	@JsonProperty("performer")
	private String performer;
	
	/**
	 * Optional. Title of the audio as defined by sender or
	 * by audio tags.
	 */
	@JsonProperty("title")
	private String title;
	
	/**
	 * Optional. MIME type of the file as defined by sender.
	 */
	@JsonProperty("mime_type")
	private String mimeType;
	
	/**
	 * Optional. TelegramFile size.
	 */
	@JsonProperty("file_size")
	private Integer fileSize;
	
	public Audio(){}
	
	public Audio(String fileId, int duration, String performer, String title, String mimeType, Integer fileSize)
	{
		this.fileId = fileId;
		this.duration = duration;
		this.performer = performer;
		this.title = title;
		this.mimeType = mimeType;
		this.fileSize = fileSize;
	}
	
	public String getFileId(){return fileId;}
	public int getDuration(){return duration;}
	public String getPerformer(){return performer;}
	public String getTitle(){return title;}
	public String getMimeType(){return mimeType;}
	public Integer getFileSize(){return fileSize;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		
		Audio audio = (Audio) o;
		
		if(duration != audio.duration) return false;
		if(fileId != null ? !fileId.equals(audio.fileId) : audio.fileId != null) return false;
		if(performer != null ? !performer.equals(audio.performer) : audio.performer != null) return false;
		if(title != null ? !title.equals(audio.title) : audio.title != null) return false;
		if(mimeType != null ? !mimeType.equals(audio.mimeType) : audio.mimeType != null) return false;
		return fileSize != null ? fileSize.equals(audio.fileSize) : audio.fileSize == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = fileId != null ? fileId.hashCode() : 0;
		result = 31 * result + duration;
		result = 31 * result + (performer != null ? performer.hashCode() : 0);
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (mimeType != null ? mimeType.hashCode() : 0);
		result = 31 * result + (fileSize != null ? fileSize.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "Audio{" +
				"fileId='" + fileId + '\'' +
				", duration=" + duration +
				", performer='" + performer + '\'' +
				", title='" + title + '\'' +
				", mimeType='" + mimeType + '\'' +
				", fileSize=" + fileSize +
				'}';
	}
}