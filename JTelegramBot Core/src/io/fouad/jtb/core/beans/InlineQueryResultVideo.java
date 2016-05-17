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
import io.fouad.jtb.core.enums.ResultVideoMimeType;

/**
 * Represents a link to a page containing an embedded video player or a video file.
 * By default, this video file will be sent by the user with an optional caption.
 * Alternatively, you can use input_message_content to send a message with the
 * specified content instead of the video.
 */
public class InlineQueryResultVideo extends InlineQueryResult
{
	/**
	 * A valid URL for the embedded video player or video file.
	 */
	@JsonProperty("video_url")
	private String videoUrl;
	
	/**
	 * Mime type of the content of video url, “text/html” or “video/mp4”.
	 */
	@JsonProperty("mime_type")
	private ResultVideoMimeType mimeType;
	
	/**
	 * URL of the thumbnail (jpeg only) for the video.
	 */
	@JsonProperty("thumb_url")
	private String thumbUrl;
	
	/**
	 * Title for the result.
	 */
	@JsonProperty("title")
	private String title;
	
	/**
	 * Optional. Caption of the video to be sent, 0-200 characters.
	 */
	@JsonProperty("caption")
	private String caption;
	
	/**
	 * Optional. Video width.
	 */
	@JsonProperty("video_width")
	private Integer videoWidth;
	
	/**
	 * Optional. Video height.
	 */
	@JsonProperty("video_height")
	private Integer videoHeight;
	
	/**
	 * Optional. Video duration in seconds.
	 */
	@JsonProperty("video_duration")
	private Integer videoDuration;
	
	/**
	 * Optional. Short description of the result.
	 */
	@JsonProperty("description")
	private String description;
	
	/**
	 * Optional. Content of the message to be sent instead of the video.
	 */
	@JsonProperty("input_message_content")
	private InputMessageContent inputMessageContent;
	
	public InlineQueryResultVideo(){}
	
	public InlineQueryResultVideo(String id, InlineKeyboardMarkup replyMarkup, String videoUrl,
	                              ResultVideoMimeType mimeType, String thumbUrl, String title, String caption,
	                              Integer videoWidth, Integer videoHeight, Integer videoDuration, String description,
	                              InputMessageContent inputMessageContent)
	{
		super("video", id, replyMarkup);
		this.videoUrl = videoUrl;
		this.mimeType = mimeType;
		this.thumbUrl = thumbUrl;
		this.title = title;
		this.caption = caption;
		this.videoWidth = videoWidth;
		this.videoHeight = videoHeight;
		this.videoDuration = videoDuration;
		this.description = description;
		this.inputMessageContent = inputMessageContent;
	}
	
	public String getVideoUrl(){return videoUrl;}
	public void setVideoUrl(String videoUrl){this.videoUrl = videoUrl;}
	
	public ResultVideoMimeType getMimeType(){return mimeType;}
	public void setMimeType(ResultVideoMimeType mimeType){this.mimeType = mimeType;}
	
	public String getThumbUrl(){return thumbUrl;}
	public void setThumbUrl(String thumbUrl){this.thumbUrl = thumbUrl;}
	
	public String getTitle(){return title;}
	public void setTitle(String title){this.title = title;}
	
	public String getCaption(){return caption;}
	public void setCaption(String caption){this.caption = caption;}
	
	public Integer getVideoWidth(){return videoWidth;}
	public void setVideoWidth(Integer videoWidth){this.videoWidth = videoWidth;}
	
	public Integer getVideoHeight(){return videoHeight;}
	public void setVideoHeight(Integer videoHeight){this.videoHeight = videoHeight;}
	
	public Integer getVideoDuration(){return videoDuration;}
	public void setVideoDuration(Integer videoDuration){this.videoDuration = videoDuration;}
	
	public String getDescription(){return description;}
	public void setDescription(String description){this.description = description;}
	
	public InputMessageContent getInputMessageContent(){return inputMessageContent;}
	public void setInputMessageContent(InputMessageContent inputMessageContent){this.inputMessageContent = inputMessageContent;}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof InlineQueryResultVideo)) return false;
		if(!super.equals(o)) return false;
		
		InlineQueryResultVideo that = (InlineQueryResultVideo) o;
		
		if(videoUrl != null ? !videoUrl.equals(that.videoUrl) : that.videoUrl != null) return false;
		if(mimeType != that.mimeType) return false;
		if(thumbUrl != null ? !thumbUrl.equals(that.thumbUrl) : that.thumbUrl != null) return false;
		if(title != null ? !title.equals(that.title) : that.title != null) return false;
		if(caption != null ? !caption.equals(that.caption) : that.caption != null) return false;
		if(videoWidth != null ? !videoWidth.equals(that.videoWidth) : that.videoWidth != null) return false;
		if(videoHeight != null ? !videoHeight.equals(that.videoHeight) : that.videoHeight != null) return false;
		if(videoDuration != null ? !videoDuration.equals(that.videoDuration) : that.videoDuration != null) return false;
		if(description != null ? !description.equals(that.description) : that.description != null) return false;
		return inputMessageContent != null ? inputMessageContent.equals(that.inputMessageContent)
		                                   : that.inputMessageContent == null;
		
	}
	
	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + (videoUrl != null ? videoUrl.hashCode() : 0);
		result = 31 * result + (mimeType != null ? mimeType.hashCode() : 0);
		result = 31 * result + (thumbUrl != null ? thumbUrl.hashCode() : 0);
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (caption != null ? caption.hashCode() : 0);
		result = 31 * result + (videoWidth != null ? videoWidth.hashCode() : 0);
		result = 31 * result + (videoHeight != null ? videoHeight.hashCode() : 0);
		result = 31 * result + (videoDuration != null ? videoDuration.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (inputMessageContent != null ? inputMessageContent.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "InlineQueryResultVideo{" +
				"videoUrl='" + videoUrl + '\'' +
				", mimeType=" + mimeType +
				", thumbUrl='" + thumbUrl + '\'' +
				", title='" + title + '\'' +
				", caption='" + caption + '\'' +
				", videoWidth=" + videoWidth +
				", videoHeight=" + videoHeight +
				", videoDuration=" + videoDuration +
				", description='" + description + '\'' +
				", inputMessageContent=" + inputMessageContent +
				"} " + super.toString();
	}
}