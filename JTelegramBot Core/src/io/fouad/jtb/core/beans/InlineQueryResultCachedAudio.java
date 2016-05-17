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
 * Represents a link to an mp3 audio file stored on the Telegram servers.
 * By default, this audio file will be sent by the user. Alternatively,
 * you can use input_message_content to send a message with the specified
 * content instead of the audio.
 */
public class InlineQueryResultCachedAudio extends InlineQueryResult
{
	/**
	 * A valid file identifier for the audio file.
	 */
	@JsonProperty("audio_file_id")
	private String audioFileId;
	
	/**
	 * Optional. Content of the message to be sent instead of the audio.
	 */
	@JsonProperty("input_message_content")
	private InputMessageContent inputMessageContent;
	
	public InlineQueryResultCachedAudio(){}
	
	public InlineQueryResultCachedAudio(String id, InlineKeyboardMarkup replyMarkup, String audioFileId,
	                                    InputMessageContent inputMessageContent)
	{
		super("audio", id, replyMarkup);
		this.audioFileId = audioFileId;
		this.inputMessageContent = inputMessageContent;
	}
	
	public String getAudioFileId(){return audioFileId;}
	public void setAudioFileId(String audioFileId){this.audioFileId = audioFileId;}
	
	public InputMessageContent getInputMessageContent(){return inputMessageContent;}
	public void setInputMessageContent(InputMessageContent inputMessageContent){this.inputMessageContent = inputMessageContent;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof InlineQueryResultCachedAudio)) return false;
		if(!super.equals(o)) return false;
		
		InlineQueryResultCachedAudio that = (InlineQueryResultCachedAudio) o;
		
		if(audioFileId != null ? !audioFileId.equals(that.audioFileId) : that.audioFileId != null) return false;
		return inputMessageContent != null ? inputMessageContent.equals(that.inputMessageContent)
		                                   : that.inputMessageContent == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + (audioFileId != null ? audioFileId.hashCode() : 0);
		result = 31 * result + (inputMessageContent != null ? inputMessageContent.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "InlineQueryResultCachedAudio{" +
				"audioFileId='" + audioFileId + '\'' +
				", inputMessageContent=" + inputMessageContent +
				"} " + super.toString();
	}
}