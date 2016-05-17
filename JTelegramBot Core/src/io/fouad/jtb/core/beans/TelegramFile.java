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
 * This object represents a file ready to be downloaded.
 * The file can be downloaded via the link
 * https://api.telegram.org/file/bot<token>/<file_path>.
 * It is guaranteed that the link will be valid for at
 * least 1 hour. When the link expires, a new one can be
 * requested by calling getFile.
 * Maximum file size to download is 20 MB.
 */
public class TelegramFile
{
	/**
	 * Unique identifier for this file.
	 */
	@JsonProperty("file_id")
	private String fileId;
	
	/**
	 * Optional. TelegramFile size, if known.
	 */
	@JsonProperty("file_size")
	private Integer fileSize;
	
	/**
	 * Optional. TelegramFile path. Use
	 * https://api.telegram.org/file/bot<token>/<file_path>
	 * to get the file.
	 */
	@JsonProperty("file_path")
	private String filePath;
	
	public TelegramFile(){}
	
	public TelegramFile(String fileId, Integer fileSize, String filePath)
	{
		this.fileId = fileId;
		this.fileSize = fileSize;
		this.filePath = filePath;
	}
	
	public String getFileId(){return fileId;}
	public Integer getFileSize(){return fileSize;}
	public String getFilePath(){return filePath;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		
		TelegramFile telegramFile = (TelegramFile) o;
		
		if(fileId != null ? !fileId.equals(telegramFile.fileId) : telegramFile.fileId != null) return false;
		if(fileSize != null ? !fileSize.equals(telegramFile.fileSize) : telegramFile.fileSize != null) return false;
		return filePath != null ? filePath.equals(telegramFile.filePath) : telegramFile.filePath == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = fileId != null ? fileId.hashCode() : 0;
		result = 31 * result + (fileSize != null ? fileSize.hashCode() : 0);
		result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "TelegramFile{" +
				"fileId='" + fileId + '\'' +
				", fileSize=" + fileSize +
				", filePath='" + filePath + '\'' +
				'}';
	}
}