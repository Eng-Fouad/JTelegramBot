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
 * This object represents one size of a photo or
 * a file / sticker thumbnail.
 */
public class PhotoSize
{
	/**
	 * Unique identifier for this file.
	 */
	@JsonProperty("file_id")
	private String fileId;
	
	/**
	 * Photo width.
	 */
	@JsonProperty("width")
	private int width;
	
	/**
	 * Photo height.
	 */
	@JsonProperty("height")
	private int height;
	
	/**
	 * Optional. TelegramFile size.
	 */
	@JsonProperty("file_size")
	private Integer fileSize;
	
	/**
	 * Optional. File path. Use https://api.telegram.org/file/bot<token>/<file_path> to get the file.
	 */
	@JsonProperty("file_path")
	private String filePath;
	
	public PhotoSize(){}
	
	public PhotoSize(String fileId, int width, int height, Integer fileSize, String filePath)
	{
		this.fileId = fileId;
		this.width = width;
		this.height = height;
		this.fileSize = fileSize;
		this.filePath = filePath;
	}
	
	public String getFileId(){return fileId;}
	public int getWidth(){return width;}
	public int getHeight(){return height;}
	public Integer getFileSize(){return fileSize;}
	public String getFilePath(){return filePath;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		
		PhotoSize photoSize = (PhotoSize) o;
		
		if(width != photoSize.width) return false;
		if(height != photoSize.height) return false;
		if(fileId != null ? !fileId.equals(photoSize.fileId) : photoSize.fileId != null) return false;
		if(fileSize != null ? !fileSize.equals(photoSize.fileSize) : photoSize.fileSize != null) return false;
		return filePath != null ? filePath.equals(photoSize.filePath) : photoSize.filePath == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = fileId != null ? fileId.hashCode() : 0;
		result = 31 * result + width;
		result = 31 * result + height;
		result = 31 * result + (fileSize != null ? fileSize.hashCode() : 0);
		result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "PhotoSize{" +
				"fileId='" + fileId + '\'' +
				", width=" + width +
				", height=" + height +
				", fileSize=" + fileSize +
				", filePath='" + filePath + '\'' +
				'}';
	}
}