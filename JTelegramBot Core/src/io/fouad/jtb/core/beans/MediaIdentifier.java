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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * This class represents a media, either as an existing media by
 * its ID or as an <code>InputStream</code> with a file name.
 */
public class MediaIdentifier
{
	private final String mediaId;
	private final String fileName;
	private final InputStream mediaInputStream;
	
	public MediaIdentifier(String mediaId, String fileName, InputStream mediaInputStream)
	{
		this.mediaId = mediaId;
		this.fileName = fileName;
		this.mediaInputStream = mediaInputStream;
	}
	
	public static MediaIdentifier byId(String id)
	{
		return new MediaIdentifier(id,  null, null);
	}
	
	public static MediaIdentifier byFile(File file) throws FileNotFoundException
	{
		return new MediaIdentifier(null, file.getName(), new FileInputStream(file));
	}
	
	public static MediaIdentifier byInputStream(InputStream inputStream, String fileName)
	{
		return new MediaIdentifier(null, fileName, inputStream);
	}
	
	public String getMediaId(){return mediaId;}
	public String getFileName(){return fileName;}
	public InputStream getMediaInputStream(){return mediaInputStream;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		
		MediaIdentifier that = (MediaIdentifier) o;
		
		if(mediaId != null ? !mediaId.equals(that.mediaId) : that.mediaId != null) return false;
		if(fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) return false;
		return mediaInputStream != null ? mediaInputStream.equals(that.mediaInputStream)
		                                : that.mediaInputStream == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = mediaId != null ? mediaId.hashCode() : 0;
		result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
		result = 31 * result + (mediaInputStream != null ? mediaInputStream.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "MediaIdentifier{" +
				"mediaId='" + mediaId + '\'' +
				", fileName='" + fileName + '\'' +
				", mediaInputStream=" + mediaInputStream +
				'}';
	}
}