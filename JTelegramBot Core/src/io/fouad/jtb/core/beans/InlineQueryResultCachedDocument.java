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
 * Represents a link to a file stored on the Telegram servers.
 * By default, this file will be sent by the user with an optional
 * caption. Alternatively, you can use input_message_content to
 * send a message with the specified content instead of the file.
 * Currently, only pdf-files and zip archives can be sent using
 * this method.
 */
public class InlineQueryResultCachedDocument extends InlineQueryResult
{
	/**
	 * Title for the result.
	 */
	@JsonProperty("title")
	private String title;
	
	/**
	 * A valid file identifier for the file.
	 */
	@JsonProperty("document_file_id")
	private String documentFileId;
	
	/**
	 * Optional. Short description of the result.
	 */
	@JsonProperty("description")
	private String description;
	
	/**
	 * Optional. Caption of the document to be sent, 0-200 characters.
	 */
	@JsonProperty("caption")
	private String caption;
	
	/**
	 * Optional. Content of the message to be sent instead of the file.
	 */
	@JsonProperty("input_message_content")
	private InputMessageContent inputMessageContent;
	
	public InlineQueryResultCachedDocument(){}
	
	public InlineQueryResultCachedDocument(String id, InlineKeyboardMarkup replyMarkup, String title,
	                                       String documentFileId, String description, String caption,
	                                       InputMessageContent inputMessageContent)
	{
		super("document", id, replyMarkup);
		this.title = title;
		this.documentFileId = documentFileId;
		this.description = description;
		this.caption = caption;
		this.inputMessageContent = inputMessageContent;
	}
	
	public String getTitle(){return title;}
	public void setTitle(String title){this.title = title;}
	
	public String getDocumentFileId(){return documentFileId;}
	public void setDocumentFileId(String documentFileId){this.documentFileId = documentFileId;}
	
	public String getDescription(){return description;}
	public void setDescription(String description){this.description = description;}
	
	public String getCaption(){return caption;}
	public void setCaption(String caption){this.caption = caption;}
	
	public InputMessageContent getInputMessageContent(){return inputMessageContent;}
	public void setInputMessageContent(InputMessageContent inputMessageContent){this.inputMessageContent = inputMessageContent;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof InlineQueryResultCachedDocument)) return false;
		if(!super.equals(o)) return false;
		
		InlineQueryResultCachedDocument that = (InlineQueryResultCachedDocument) o;
		
		if(title != null ? !title.equals(that.title) : that.title != null) return false;
		if(documentFileId != null ? !documentFileId.equals(that.documentFileId) : that.documentFileId != null)
			return false;
		if(description != null ? !description.equals(that.description) : that.description != null) return false;
		if(caption != null ? !caption.equals(that.caption) : that.caption != null) return false;
		return inputMessageContent != null ? inputMessageContent.equals(that.inputMessageContent)
		                                   : that.inputMessageContent == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (documentFileId != null ? documentFileId.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (caption != null ? caption.hashCode() : 0);
		result = 31 * result + (inputMessageContent != null ? inputMessageContent.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "InlineQueryResultCachedDocument{" +
				"title='" + title + '\'' +
				", documentFileId='" + documentFileId + '\'' +
				", description='" + description + '\'' +
				", caption='" + caption + '\'' +
				", inputMessageContent=" + inputMessageContent +
				"} " + super.toString();
	}
}