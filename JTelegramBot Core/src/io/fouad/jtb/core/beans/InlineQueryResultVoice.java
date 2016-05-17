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
 * Represents a link to a voice recording in an .ogg container encoded
 * with OPUS. By default, this voice recording will be sent by the user.
 * Alternatively, you can use input_message_content to send a message
 * with the specified content instead of the the voice message.
 */
public class InlineQueryResultVoice extends InlineQueryResult
{
	/**
	 * A valid URL for the voice recording.
	 */
	@JsonProperty("voice_url")
	private String voiceUrl;
	
	/**
	 * The recording title.
	 */
	@JsonProperty("title")
	private String title;
		
	/**
	 * Optional. Recording duration in seconds.
	 */
	@JsonProperty("voice_duration")
	private Integer voiceDuration;
	
	/**
	 * Optional. Content of the message to be sent instead of the
	 * voice recording.
	 */
	@JsonProperty("input_message_content")
	private InputMessageContent inputMessageContent;
	
	public InlineQueryResultVoice(){}
	
	public InlineQueryResultVoice(String id, InlineKeyboardMarkup replyMarkup, String voiceUrl, String title,
	                              Integer voiceDuration, InputMessageContent inputMessageContent)
	{
		super("voice", id, replyMarkup);
		this.voiceUrl = voiceUrl;
		this.title = title;
		this.voiceDuration = voiceDuration;
		this.inputMessageContent = inputMessageContent;
	}
	
	public String getVoiceUrl(){return voiceUrl;}
	public void setVoiceUrl(String voiceUrl){this.voiceUrl = voiceUrl;}
	
	public String getTitle(){return title;}
	public void setTitle(String title){this.title = title;}
	
	public Integer getVoiceDuration(){return voiceDuration;}
	public void setVoiceDuration(Integer voiceDuration){this.voiceDuration = voiceDuration;}
	
	public InputMessageContent getInputMessageContent(){return inputMessageContent;}
	public void setInputMessageContent(InputMessageContent inputMessageContent){this.inputMessageContent = inputMessageContent;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof InlineQueryResultVoice)) return false;
		if(!super.equals(o)) return false;
		
		InlineQueryResultVoice that = (InlineQueryResultVoice) o;
		
		if(voiceUrl != null ? !voiceUrl.equals(that.voiceUrl) : that.voiceUrl != null) return false;
		if(title != null ? !title.equals(that.title) : that.title != null) return false;
		if(voiceDuration != null ? !voiceDuration.equals(that.voiceDuration) : that.voiceDuration != null) return false;
		return inputMessageContent != null ? inputMessageContent.equals(that.inputMessageContent)
		                                   : that.inputMessageContent == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + (voiceUrl != null ? voiceUrl.hashCode() : 0);
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (voiceDuration != null ? voiceDuration.hashCode() : 0);
		result = 31 * result + (inputMessageContent != null ? inputMessageContent.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "InlineQueryResultVoice{" +
				"voiceUrl='" + voiceUrl + '\'' +
				", title='" + title + '\'' +
				", voiceDuration=" + voiceDuration +
				", inputMessageContent=" + inputMessageContent +
				"} " + super.toString();
	}
}