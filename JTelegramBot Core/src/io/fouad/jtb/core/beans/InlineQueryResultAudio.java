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
 * Represents a link to an mp3 audio file. By default, this audio
 * file will be sent by the user. Alternatively, you can use
 * input_message_content to send a message with the specified
 * content instead of the audio.
 */
public class InlineQueryResultAudio extends InlineQueryResult
{
	/**
	 * A valid URL for the audio file.
	 */
	@JsonProperty("audio_url")
	private String audioUrl;
	
	/**
	 * The audio title.
	 */
	@JsonProperty("title")
	private String title;
	
	/**
	 * Optional. The performer.
	 */
	@JsonProperty("performer")
	private String performer;
	
	/**
	 * Optional. Audio duration in seconds.
	 */
	@JsonProperty("audio_duration")
	private Integer audioDuration;
	
	/**
	 * Optional. Content of the message to be sent instead of the audio.
	 */
	@JsonProperty("input_message_content")
	private InputMessageContent inputMessageContent;
	
	public InlineQueryResultAudio(){}
	
	public InlineQueryResultAudio(String id, InlineKeyboardMarkup replyMarkup, String audioUrl,
	                              String title, String performer, Integer audioDuration,
	                              InputMessageContent inputMessageContent)
	{
		super("audio", id, replyMarkup);
		this.audioUrl = audioUrl;
		this.title = title;
		this.performer = performer;
		this.audioDuration = audioDuration;
		this.inputMessageContent = inputMessageContent;
	}
	
	public String getAudioUrl(){return audioUrl;}
	public void setAudioUrl(String audioUrl){this.audioUrl = audioUrl;}
	
	public String getTitle(){return title;}
	public void setTitle(String title){this.title = title;}
	
	public String getPerformer(){return performer;}
	public void setPerformer(String performer){this.performer = performer;}
	
	public Integer getAudioDuration(){return audioDuration;}
	public void setAudioDuration(Integer audioDuration){this.audioDuration = audioDuration;}
	
	public InputMessageContent getInputMessageContent(){return inputMessageContent;}
	public void setInputMessageContent(InputMessageContent inputMessageContent){this.inputMessageContent = inputMessageContent;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof InlineQueryResultAudio)) return false;
		if(!super.equals(o)) return false;
		
		InlineQueryResultAudio that = (InlineQueryResultAudio) o;
		
		if(audioUrl != null ? !audioUrl.equals(that.audioUrl) : that.audioUrl != null) return false;
		if(title != null ? !title.equals(that.title) : that.title != null) return false;
		if(performer != null ? !performer.equals(that.performer) : that.performer != null) return false;
		if(audioDuration != null ? !audioDuration.equals(that.audioDuration) : that.audioDuration != null) return false;
		return inputMessageContent != null ? inputMessageContent.equals(that.inputMessageContent)
		                                   : that.inputMessageContent == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + (audioUrl != null ? audioUrl.hashCode() : 0);
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (performer != null ? performer.hashCode() : 0);
		result = 31 * result + (audioDuration != null ? audioDuration.hashCode() : 0);
		result = 31 * result + (inputMessageContent != null ? inputMessageContent.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "InlineQueryResultAudio{" +
				"audioUrl='" + audioUrl + '\'' +
				", title='" + title + '\'' +
				", performer='" + performer + '\'' +
				", audioDuration=" + audioDuration +
				", inputMessageContent=" + inputMessageContent +
				"} " + super.toString();
	}
}