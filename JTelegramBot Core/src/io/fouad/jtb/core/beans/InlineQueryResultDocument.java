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
import io.fouad.jtb.core.enums.ResultDocumentMimeType;

/**
 * Represents a link to a file. By default, this file will be sent
 * by the user with an optional caption. Alternatively, you can use
 * input_message_content to send a message with the specified content
 * instead of the file. Currently, only .PDF and .ZIP files can be
 * sent using this method.
 */
public class InlineQueryResultDocument extends InlineQueryResult
{
	/**
	 * Title for the result.
	 */
	@JsonProperty("title")
	private String title;
	
	/**
	 * Optional. Caption of the document to be sent, 0-200 characters.
	 */
	@JsonProperty("caption")
	private String caption;
	
	/**
	 * 	A valid URL for the file.
	 */
	@JsonProperty("document_url")
	private String documentUrl;
	
	/**
	 * Mime type of the content of the file, either “application/pdf”
	 * or “application/zip”.
	 */
	@JsonProperty("mime_type")
	private ResultDocumentMimeType mimeType;
	
	/**
	 * Optional. Short description of the result.
	 */
	@JsonProperty("description")
	private String description;
	
	/**
	 * Optional. Content of the message to be sent instead of the file.
	 */
	@JsonProperty("input_message_content")
	private InputMessageContent inputMessageContent;
	
	/**
	 * Optional. URL of the thumbnail (jpeg only) for the file.
	 */
	@JsonProperty("thumb_url")
	private String thumbUrl;
	
	/**
	 * Optional. Thumbnail width.
	 */
	@JsonProperty("thumb_width")
	private Integer thumbWidth;
	
	/**
	 * Optional. Thumbnail height.
	 */
	@JsonProperty("thumb_height")
	private Integer thumbHeight;
	
	public InlineQueryResultDocument(){}
	
	public InlineQueryResultDocument(String id, InlineKeyboardMarkup replyMarkup, String title,
	                                 String caption, String documentUrl, ResultDocumentMimeType mimeType,
	                                 String description, InputMessageContent inputMessageContent, String thumbUrl,
	                                 Integer thumbWidth, Integer thumbHeight)
	{
		super("document", id, replyMarkup);
		this.title = title;
		this.caption = caption;
		this.documentUrl = documentUrl;
		this.mimeType = mimeType;
		this.description = description;
		this.inputMessageContent = inputMessageContent;
		this.thumbUrl = thumbUrl;
		this.thumbWidth = thumbWidth;
		this.thumbHeight = thumbHeight;
	}
	
	public String getTitle(){return title;}
	public void setTitle(String title){this.title = title;}
	
	public String getCaption(){return caption;}
	public void setCaption(String caption){this.caption = caption;}
	
	public String getDocumentUrl(){return documentUrl;}
	public void setDocumentUrl(String documentUrl){this.documentUrl = documentUrl;}
	
	public ResultDocumentMimeType getMimeType(){return mimeType;}
	public void setMimeType(ResultDocumentMimeType mimeType){this.mimeType = mimeType;}
	
	public String getDescription(){return description;}
	public void setDescription(String description){this.description = description;}
	
	public InputMessageContent getInputMessageContent(){return inputMessageContent;}
	public void setInputMessageContent(InputMessageContent inputMessageContent){this.inputMessageContent = inputMessageContent;}
	
	public String getThumbUrl(){return thumbUrl;}
	public void setThumbUrl(String thumbUrl){this.thumbUrl = thumbUrl;}
	
	public Integer getThumbWidth(){return thumbWidth;}
	public void setThumbWidth(Integer thumbWidth){this.thumbWidth = thumbWidth;}
	
	public Integer getThumbHeight(){return thumbHeight;}
	public void setThumbHeight(Integer thumbHeight){this.thumbHeight = thumbHeight;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof InlineQueryResultDocument)) return false;
		if(!super.equals(o)) return false;
		
		InlineQueryResultDocument that = (InlineQueryResultDocument) o;
		
		if(title != null ? !title.equals(that.title) : that.title != null) return false;
		if(caption != null ? !caption.equals(that.caption) : that.caption != null) return false;
		if(documentUrl != null ? !documentUrl.equals(that.documentUrl) : that.documentUrl != null) return false;
		if(mimeType != that.mimeType) return false;
		if(description != null ? !description.equals(that.description) : that.description != null) return false;
		if(inputMessageContent != null ? !inputMessageContent.equals(that.inputMessageContent)
		                               : that.inputMessageContent != null) return false;
		if(thumbUrl != null ? !thumbUrl.equals(that.thumbUrl) : that.thumbUrl != null) return false;
		if(thumbWidth != null ? !thumbWidth.equals(that.thumbWidth) : that.thumbWidth != null) return false;
		return thumbHeight != null ? thumbHeight.equals(that.thumbHeight) : that.thumbHeight == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (caption != null ? caption.hashCode() : 0);
		result = 31 * result + (documentUrl != null ? documentUrl.hashCode() : 0);
		result = 31 * result + (mimeType != null ? mimeType.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (inputMessageContent != null ? inputMessageContent.hashCode() : 0);
		result = 31 * result + (thumbUrl != null ? thumbUrl.hashCode() : 0);
		result = 31 * result + (thumbWidth != null ? thumbWidth.hashCode() : 0);
		result = 31 * result + (thumbHeight != null ? thumbHeight.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "InlineQueryResultDocument{" +
				"title='" + title + '\'' +
				", caption='" + caption + '\'' +
				", documentUrl='" + documentUrl + '\'' +
				", mimeType=" + mimeType +
				", description='" + description + '\'' +
				", inputMessageContent=" + inputMessageContent +
				", thumbUrl='" + thumbUrl + '\'' +
				", thumbWidth=" + thumbWidth +
				", thumbHeight=" + thumbHeight +
				"} " + super.toString();
	}
}