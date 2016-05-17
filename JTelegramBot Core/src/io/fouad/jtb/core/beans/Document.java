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
 * This object represents a general file (as opposed to photos,
 * voice messages and audio files).
 */
public class Document
{
	/**
	 * Unique file identifier.
	 */
	@JsonProperty("file_id")
	private String fileId;
	
	/**
	 * Optional. Document thumbnail as defined by sender.
	 */
	@JsonProperty("thumb")
	private PhotoSize thumb;
	
	/**
	 * Optional. Original filename as defined by sender.
	 */
	@JsonProperty("file_name")
	private String fileName;
	
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
	
	public Document(){}
	
	public Document(String fileId, PhotoSize thumb, String fileName, String mimeType, Integer fileSize)
	{
		this.fileId = fileId;
		this.thumb = thumb;
		this.fileName = fileName;
		this.mimeType = mimeType;
		this.fileSize = fileSize;
	}
	
	public String getFileId(){return fileId;}
	public PhotoSize getThumb(){return thumb;}
	public String getFileName(){return fileName;}
	public String getMimeType(){return mimeType;}
	public Integer getFileSize(){return fileSize;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		
		Document document = (Document) o;
		
		if(fileId != null ? !fileId.equals(document.fileId) : document.fileId != null) return false;
		if(thumb != null ? !thumb.equals(document.thumb) : document.thumb != null) return false;
		if(fileName != null ? !fileName.equals(document.fileName) : document.fileName != null) return false;
		if(mimeType != null ? !mimeType.equals(document.mimeType) : document.mimeType != null) return false;
		return fileSize != null ? fileSize.equals(document.fileSize) : document.fileSize == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = fileId != null ? fileId.hashCode() : 0;
		result = 31 * result + (thumb != null ? thumb.hashCode() : 0);
		result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
		result = 31 * result + (mimeType != null ? mimeType.hashCode() : 0);
		result = 31 * result + (fileSize != null ? fileSize.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "Document{" +
				"fileId='" + fileId + '\'' +
				", thumb=" + thumb +
				", fileName='" + fileName + '\'' +
				", mimeType='" + mimeType + '\'' +
				", fileSize=" + fileSize +
				'}';
	}
}