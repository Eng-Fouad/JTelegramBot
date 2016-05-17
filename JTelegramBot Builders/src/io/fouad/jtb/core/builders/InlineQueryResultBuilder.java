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

package io.fouad.jtb.core.builders;

import io.fouad.jtb.core.beans.*;
import io.fouad.jtb.core.enums.ResultDocumentMimeType;
import io.fouad.jtb.core.enums.ResultVideoMimeType;

/**
 * A builder class to build one of the following 19 types:
 *
 * - InlineQueryResultCachedAudio
 * - InlineQueryResultCachedDocument
 * - InlineQueryResultCachedGif
 * - InlineQueryResultCachedMpeg4Gif
 * - InlineQueryResultCachedPhoto
 * - InlineQueryResultCachedSticker
 * - InlineQueryResultCachedVideo
 * - InlineQueryResultCachedVoice
 * - InlineQueryResultArticle
 * - InlineQueryResultPhoto
 * - InlineQueryResultContact
 * - InlineQueryResultDocument
 * - InlineQueryResultGif
 * - InlineQueryResultLocation
 * - InlineQueryResultMpeg4Gif
 * - InlineQueryResultPhoto
 * - InlineQueryResultVenue
 * - InlineQueryResultVideo
 * - InlineQueryResultVoice
 * - InlineQueryResultArticle
 */
public class InlineQueryResultBuilder
{
	/**
	 * Represents a link to an article or web page.
	 */
	public static ResultArticleNoIdNoTitleNoMessageContent asArticle()
	{
		return new ResultArticleNoIdNoTitleNoMessageContent();
	}
	
	/**
	 * Represents a link to a photo. By default, this photo will be sent by the user with optional caption.
	 * Alternatively, you can provide messageContent to send it instead of photo.
	 */
	public static ResultPhotoNoIdNoPhotoUrlNoThumbUrl asPhoto()
	{
		return new ResultPhotoNoIdNoPhotoUrlNoThumbUrl();
	}
	
	/**
	 * Represents a link to an animated GIF file. By default, this animated GIF file will be sent by the user
	 * with optional caption. Alternatively, you can provide messageContent to send it instead of the animation.
	 */
	public static ResultGifNoIdNoGifUrlNoThumbUrl asGif()
	{
		return new ResultGifNoIdNoGifUrlNoThumbUrl();
	}
	
	/**
	 * Represents a link to a video animation (H.264/MPEG-4 AVC video without sound). By default, this animated
	 * MPEG-4 file will be sent by the user with optional caption. Alternatively, you can provide messageContent
	 * to send it instead of the animation.
	 */
	public static ResultMpeg4NoIdNoMpeg4UrlNoThumbUrl asMpeg4Gif()
	{
		return new ResultMpeg4NoIdNoMpeg4UrlNoThumbUrl();
	}
	
	/**
	 * Represents a link to a page containing an embedded video player or a video file. By default, this video
	 * file will be sent by the user with an optional caption. Alternatively, you can use messageContent to send
	 * a message with the specified content instead of the video.
	 */
	public static ResultVideoNoIdNoVideoUrlNoMimeTypeNoThumbUrlNoTitle asVideo()
	{
		return new ResultVideoNoIdNoVideoUrlNoMimeTypeNoThumbUrlNoTitle();
	}
	
	/**
	 * Represents a link to an mp3 audio file. By default, this audio file will be sent by the user. Alternatively,
	 * you can use messageContent to send a message with the specified content instead of the audio.
	 */
	public static ResultAudioNoIdNoAudioUrlNoTitle asAudio()
	{
		return new ResultAudioNoIdNoAudioUrlNoTitle();
	}
	
	/**
	 * Represents a link to a voice recording in an .ogg container encoded with OPUS. By default, this voice
	 * recording will be sent by the user. Alternatively, you can use messageContent to send a message
	 * with the specified content instead of the the voice message.
	 */
	public static ResultVoiceNoIdNoVoiceUrlNoTitle asVoice()
	{
		return new ResultVoiceNoIdNoVoiceUrlNoTitle();
	}
	
	/**
	 * Represents a link to a file. By default, this file will be sent by the user with an optional caption.
	 * Alternatively, you can use messageContent to send a message with the specified content instead
	 * of the file. Currently, only .PDF and .ZIP files can be sent using this method.
	 */
	public static ResultDocumentNoIdNoTitleNoDocumentUrlNoMimeType asDocument()
	{
		return new ResultDocumentNoIdNoTitleNoDocumentUrlNoMimeType();
	}
	
	/**
	 * Represents a location on a map. By default, the location will be sent by the user. Alternatively,
	 * you can use messageContent to send a message with the specified content instead of the location.
	 */
	public static ResultLocationNoIdNoLatitudeNoLongitudeNoTitle asLocation()
	{
		return new ResultLocationNoIdNoLatitudeNoLongitudeNoTitle();
	}
	
	/**
	 * Represents a venue. By default, the venue will be sent by the user. Alternatively, you can use
	 * messageContent to send a message with the specified content instead of the venue.
	 */
	public static ResultVenueNoIdNoLatitudeNoLongitudeNoTitleNoAddress asVenue()
	{
		return new ResultVenueNoIdNoLatitudeNoLongitudeNoTitleNoAddress();
	}
	
	/**
	 * Represents a contact with a phone number. By default, this contact will be sent by the user.
	 * Alternatively, you can use messageContent to send a message with the specified content
	 * instead of the contact.
	 */
	public static ResultContactNoIdNoPhoneNumberNoFirstName asContact()
	{
		return new ResultContactNoIdNoPhoneNumberNoFirstName();
	}
	
	/**
	 * Represents a link to a photo stored on the Telegram servers. By default, this photo will be
	 * sent by the user with an optional caption. Alternatively, you can use messageContent to
	 * send a message with the specified content instead of the photo.
	 */
	public static ResultCachedPhotoNoIdNoPhotoFileId asCachedPhoto()
	{
		return new ResultCachedPhotoNoIdNoPhotoFileId();
	}
	
	/**
	 * Represents a link to an animated GIF file stored on the Telegram servers. By default, this
	 * animated GIF file will be sent by the user with an optional caption. Alternatively, you can
	 * use messageContent to send a message with specified content instead of the animation.
	 */
	public static ResultCachedGifNoIdNoGifFileId asCachedGif()
	{
		return new ResultCachedGifNoIdNoGifFileId();
	}
	
	/**
	 * Represents a link to a video animation (H.264/MPEG-4 AVC video without sound) stored on the
	 * Telegram servers. By default, this animated MPEG-4 file will be sent by the user with an
	 * optional caption. Alternatively, you can use messageContent to send a message with the
	 * specified content instead of the animation.
	 */
	public static ResultCachedMpeg4GifNoIdNoMpeg4FileId asCachedMpeg4Gif()
	{
		return new ResultCachedMpeg4GifNoIdNoMpeg4FileId();
	}
	
	/**
	 * Represents a link to a sticker stored on the Telegram servers. By default, this sticker will
	 * be sent by the user. Alternatively, you can use messageContent to send a message with the
	 * specified content instead of the sticker.
	 */
	public static ResultCachedStickerNoIdNoStickerFileId asCachedSticker()
	{
		return new ResultCachedStickerNoIdNoStickerFileId();
	}
	
	/**
	 * Represents a link to a file stored on the Telegram servers. By default, this file will be sent
	 * by the user with an optional caption. Alternatively, you can use messageContent to send
	 * a message with the specified content instead of the file. Currently, only pdf-files and zip
	 * archives can be sent using this method.
	 */
	public static ResultCachedDocumentNoIdNoTitleNoDocumentFileId asCachedDocument()
	{
		return new ResultCachedDocumentNoIdNoTitleNoDocumentFileId();
	}
	
	/**
	 * Represents a link to a video file stored on the Telegram servers. By default, this video file
	 * will be sent by the user with an optional caption. Alternatively, you can use messageContent
	 * to send a message with the specified content instead of the video.
	 */
	public static ResultCachedVideoNoIdNoVideoFileIdNoTitle asCachedVideo()
	{
		return new ResultCachedVideoNoIdNoVideoFileIdNoTitle();
	}
	
	/**
	 * Represents a link to a voice message stored on the Telegram servers. By default, this voice
	 * message will be sent by the user. Alternatively, you can use messageContent to send a message
	 * with the specified content instead of the voice message.
	 */
	public static ResultCachedVoiceNoIdNoVoiceFileIdNoTitle asCachedVoice()
	{
		return new ResultCachedVoiceNoIdNoVoiceFileIdNoTitle();
	}
	
	/**
	 * Represents a link to an mp3 audio file stored on the Telegram servers. By default, this audio
	 * file will be sent by the user. Alternatively, you can use messageContent to send a message
	 * with the specified content instead of the audio.
	 */
	public static ResultCachedAudioNoIdNoAudioFileId asCachedAudio()
	{
		return new ResultCachedAudioNoIdNoAudioFileId();
	}
	
	public static class ResultArticleNoIdNoTitleNoMessageContent
	{
		public ResultArticleNoIdNoTitleNoMessageContent(){}
		
		/**
		 * Sets unique identifier for this result, 1-64 bytes.
		 * 
		 * @param id the unique identifier
		 */
		public ResultArticleNoTitleNoMessageContent withId(String id)
		{
			return new ResultArticleNoTitleNoMessageContent(id);
		}
	}
	
	public static class ResultArticleNoTitleNoMessageContent
	{
		private String id;
		
		public ResultArticleNoTitleNoMessageContent(String id)
		{
			this.id = id;
		}
		
		/**
		 * Sets title of the result.
		 * 
		 * @param title the title
		 */
		public ResultArticleNoMessageContent withTitle(String title)
		{
			return new ResultArticleNoMessageContent(id, title);
		}
	}
	
	public static class ResultArticleNoMessageContent
	{
		private String id;
		private String title;
		
		public ResultArticleNoMessageContent(String id, String title)
		{
			this.id = id;
			this.title = title;
		}
		
		/**
		 * Content of the message to be sent.
		 * 
		 * @param messageContent the message content
		 */
		public ResultArticleReady withMessageContent(InputMessageContent messageContent)
		{
			return new ResultArticleReady(id, title, messageContent);
		}
	}
	
	public static class ResultArticleReady
	{
		private String id;
		private String title;
		private InputMessageContent messageContent;
		private InlineKeyboardMarkup inlineKeyboard;
		private String url;
		private Boolean hideUrl;
		private String description;
		private String thumbUrl;
		private Integer thumbWidth;
		private Integer thumbHeight;
		
		public ResultArticleReady(String id, String title, InputMessageContent messageContent)
		{
			this.id = id;
			this.title = title;
			this.messageContent = messageContent;
		}
		
		/**
		 * Attaches an inline keyboard to the sending message.
		 * 
		 * @param inlineKeyboard the inline keyboard
		 */
		public ResultArticleReady attachInlineKeyboard(InlineKeyboardMarkup inlineKeyboard)
		{
			this.inlineKeyboard = inlineKeyboard;
			return this;
		}
		
		/**
		 * URL of the result.
		 * 
		 * @param url the url
		 */
		public ResultArticleReady withUrl(String url)
		{
			this.url = url;
			return this;
		}
		
		/**
		 * Hides the URL from the message.
		 */
		public ResultArticleReady hideUrl()
		{
			this.hideUrl = true;
			return this;
		}
		
		/**
		 * Short description of the result.
		 * 
		 * @param description the description
		 */
		public ResultArticleReady withDescription(String description)
		{
			this.description = description;
			return this;
		}
		
		/**
		 * Url of the thumbnail for the result.
		 *
		 * @param thumbUrl the url
		 */
		public ResultArticleReady withThumbnailUrl(String thumbUrl)
		{
			this.thumbUrl = thumbUrl;
			return this;
		}
		
		/**
		 * Sets the thumbnail width.
		 *
		 * @param thumbWidth the thumbnail width
		 */
		public ResultArticleReady withThumbnailWidth(int thumbWidth)
		{
			this.thumbWidth = thumbWidth;
			return this;
		}
		
		/**
		 * Sets the thumbnail height.
		 *
		 * @param thumbHeight the thumbnail height
		 */
		public ResultArticleReady withThumbnailHeight(int thumbHeight)
		{
			this.thumbHeight = thumbHeight;
			return this;
		}
		
		/**
		 * Builds the <code>InlineQueryResult</code> object.
		 */
		public InlineQueryResult buildResult()
		{
			return new InlineQueryResultArticle(id, inlineKeyboard, title, messageContent, url, hideUrl,
			                                    description, thumbUrl, thumbWidth, thumbHeight);
		}
	}
	
	public static class ResultPhotoNoIdNoPhotoUrlNoThumbUrl
	{
		public ResultPhotoNoIdNoPhotoUrlNoThumbUrl(){}
		
		/**
		 * Sets unique identifier for this result, 1-64 bytes.
		 *
		 * @param id the unique identifier
		 */
		public ResultPhotoNoPhotoUrlNoThumbUrl withId(String id)
		{
			return new ResultPhotoNoPhotoUrlNoThumbUrl(id);
		}
	}
	
	public static class ResultPhotoNoPhotoUrlNoThumbUrl
	{
		private String id;
		
		public ResultPhotoNoPhotoUrlNoThumbUrl(String id)
		{
			this.id = id;
		}
		
		/**
		 * 	A valid URL of the photo. Photo must be in jpeg format. Photo size must not exceed 5MB.
		 * 	
		 * @param photoUrl photo url
		 */
		public ResultPhotoNoThumbUrl withPhotoUrl(String photoUrl)
		{
			return new ResultPhotoNoThumbUrl(id, photoUrl);
		}
	}
	
	public static class ResultPhotoNoThumbUrl
	{
		private String id;
		private String photoUrl;
		
		public ResultPhotoNoThumbUrl(String id, String photoUrl)
		{
			this.id = id;
			this.photoUrl = photoUrl;
		}
		
		/**
		 * URL of the thumbnail for the photo.
		 * 
		 * @param thumbUrl thumbnail url
		 */
		public ResultPhotoReady withThumbnailUrl(String thumbUrl)
		{
			return new ResultPhotoReady(id, photoUrl, thumbUrl);
		}
	}
	
	public static class ResultPhotoReady
	{
		private String id;
		private String photoUrl;
		private String thumbUrl;
		private Integer photoWidth;
		private Integer photoHeight;
		private String title;
		private String description;
		private String caption;
		private InlineKeyboardMarkup inlineKeyboard;
		private InputMessageContent messageContent;
		
		public ResultPhotoReady(String id, String photoUrl, String thumbUrl)
		{
			this.id = id;
			this.photoUrl = photoUrl;
			this.thumbUrl = thumbUrl;
		}
		
		/**
		 * Sets width of the photo.
		 * 
		 * @param photoWidth photo width
		 */
		public ResultPhotoReady withPhotoWidth(int photoWidth)
		{
			this.photoWidth = photoWidth;
			return this;
		}
		
		/**
		 * Sets height of the photo.
		 * 
		 * @param photoHeight photo height
		 */
		public ResultPhotoReady withPhotoHeight(int photoHeight)
		{
			this.photoHeight = photoHeight;
			return this;
		}
		
		/**
		 * Sets title of the result.
		 *
		 * @param title the title
		 */
		public ResultPhotoReady withTitle(String title)
		{
			this.title = title;
			return this;
		}
		
		/**
		 * Short description of the result.
		 *
		 * @param description the description
		 */
		public ResultPhotoReady withDescription(String description)
		{
			this.description = description;
			return this;
		}
		
		/**
		 * Caption of the photo to be sent, 0-200 characters.
		 *
		 * @param caption the caption
		 */
		public ResultPhotoReady withCaption(String caption)
		{
			this.caption = caption;
			return this;
		}
		
		/**
		 * Attaches an inline keyboard to the sending message.
		 *
		 * @param inlineKeyboard the inline keyboard
		 */
		public ResultPhotoReady attachInlineKeyboard(InlineKeyboardMarkup inlineKeyboard)
		{
			this.inlineKeyboard = inlineKeyboard;
			return this;
		}
		
		/**
		 * Content of the message to be sent instead of the photo.
		 *
		 * @param messageContent the message content
		 */
		public ResultPhotoReady withMessageContent(InputMessageContent messageContent)
		{
			this.messageContent = messageContent;
			return this;
		}
		
		/**
		 * Builds the <code>InlineQueryResult</code> object.
		 */
		public InlineQueryResult buildResult()
		{
			return new InlineQueryResultPhoto(id, inlineKeyboard, photoUrl, thumbUrl, photoWidth,
			                                  photoHeight, title, description, caption, messageContent);
		}
	}
	
	public static class ResultGifNoIdNoGifUrlNoThumbUrl
	{
		public ResultGifNoIdNoGifUrlNoThumbUrl(){}
		
		/**
		 * Sets unique identifier for this result, 1-64 bytes.
		 *
		 * @param id the unique identifier
		 */
		public ResultGifNoGifUrlNoThumbUrl withId(String id)
		{
			return new ResultGifNoGifUrlNoThumbUrl(id);
		}
	}
	
	public static class ResultGifNoGifUrlNoThumbUrl
	{
		private String id;
		
		public ResultGifNoGifUrlNoThumbUrl(String id)
		{
			this.id = id;
		}
		
		/**
		 * 	A valid URL for the GIF file. File size must not exceed 1MB.
		 *
		 * @param gifUrl gif url
		 */
		public ResultGifNoThumbUrl withGifUrl(String gifUrl)
		{
			return new ResultGifNoThumbUrl(id, gifUrl);
		}
	}
	
	public static class ResultGifNoThumbUrl
	{
		private String id;
		private String gifUrl;
		
		public ResultGifNoThumbUrl(String id, String gifUrl)
		{
			this.id = id;
			this.gifUrl = gifUrl;
		}
		
		/**
		 * URL of the static thumbnail for the result (jpeg or gif).
		 *
		 * @param thumbUrl thumbnail url
		 */
		public ResultGifReady withThumbnailUrl(String thumbUrl)
		{
			return new ResultGifReady(id, gifUrl, thumbUrl);
		}
	}
	
	public static class ResultGifReady
	{
		private String id;
		private String gifUrl;
		private String thumbUrl;
		private Integer gifWidth;
		private Integer gifHeight;
		private String title;
		private String caption;
		private InlineKeyboardMarkup inlineKeyboard;
		private InputMessageContent messageContent;
		
		public ResultGifReady(String id, String gifUrl, String thumbUrl)
		{
			this.id = id;
			this.gifUrl = gifUrl;
			this.thumbUrl = thumbUrl;
		}
		
		/**
		 * Sets width of the GIF.
		 * 
		 * @param gifWidth gif width
		 */
		public ResultGifReady withGifWidth(int gifWidth)
		{
			this.gifWidth = gifWidth;
			return this;
		}
		
		/**
		 * Sets height of the GIF.
		 * 
		 * @param gifHeight gif height
		 */
		public ResultGifReady withGifHeight(int gifHeight)
		{
			this.gifHeight = gifHeight;
			return this;
		}
		
		/**
		 * Sets title of the result.
		 *
		 * @param title the title
		 */
		public ResultGifReady withTitle(String title)
		{
			this.title = title;
			return this;
		}
		
		/**
		 * Caption of the GIF file to be sent, 0-200 characters.
		 *
		 * @param caption the caption
		 */
		public ResultGifReady withCaption(String caption)
		{
			this.caption = caption;
			return this;
		}
		
		/**
		 * Attaches an inline keyboard to the sending message.
		 *
		 * @param inlineKeyboard the inline keyboard
		 */
		public ResultGifReady attachInlineKeyboard(InlineKeyboardMarkup inlineKeyboard)
		{
			this.inlineKeyboard = inlineKeyboard;
			return this;
		}
		
		/**
		 * Content of the message to be sent instead of the photo.
		 *
		 * @param messageContent the message content
		 */
		public ResultGifReady withMessageContent(InputMessageContent messageContent)
		{
			this.messageContent = messageContent;
			return this;
		}
		
		/**
		 * Builds the <code>InlineQueryResult</code> object.
		 */
		public InlineQueryResult buildResult()
		{
			return new InlineQueryResultGif(id, inlineKeyboard, gifUrl, gifWidth, gifHeight,
			                                thumbUrl, title, caption, messageContent);
		}
	}
	
	public static class ResultMpeg4NoIdNoMpeg4UrlNoThumbUrl
	{
		public ResultMpeg4NoIdNoMpeg4UrlNoThumbUrl(){}
		
		/**
		 * Sets unique identifier for this result, 1-64 bytes.
		 *
		 * @param id the unique identifier
		 */
		public ResultMpeg4NoMpeg4UrlNoThumbUrl withId(String id)
		{
			return new ResultMpeg4NoMpeg4UrlNoThumbUrl(id);
		}
	}
	
	public static class ResultMpeg4NoMpeg4UrlNoThumbUrl
	{
		private String id;
		
		public ResultMpeg4NoMpeg4UrlNoThumbUrl(String id)
		{
			this.id = id;
		}
		
		/**
		 * 	A valid URL for the MP4 file. File size must not exceed 1MB.
		 *
		 * @param mpeg4Url mpeg4 url
		 */
		public ResultMpeg4NoThumbUrl withMpeg4Url(String mpeg4Url)
		{
			return new ResultMpeg4NoThumbUrl(id, mpeg4Url);
		}
	}
	
	public static class ResultMpeg4NoThumbUrl
	{
		private String id;
		private String mpeg4Url;
		
		public ResultMpeg4NoThumbUrl(String id, String mpeg4Url)
		{
			this.id = id;
			this.mpeg4Url = mpeg4Url;
		}
		
		/**
		 * URL of the static thumbnail for the result (jpeg or gif).
		 *
		 * @param thumbUrl thumbnail url
		 */
		public ResultMpeg4Ready withThumbnailUrl(String thumbUrl)
		{
			return new ResultMpeg4Ready(id, mpeg4Url, thumbUrl);
		}
	}
	
	public static class ResultMpeg4Ready
	{
		private String id;
		private String mpeg4Url;
		private String thumbUrl;
		private Integer mpeg4Width;
		private Integer mpeg4Height;
		private String title;
		private String caption;
		private InlineKeyboardMarkup inlineKeyboard;
		private InputMessageContent messageContent;
		
		public ResultMpeg4Ready(String id, String mpeg4Url, String thumbUrl)
		{
			this.id = id;
			this.mpeg4Url = mpeg4Url;
			this.thumbUrl = thumbUrl;
		}
		
		/**
		 * Sets width of the video.
		 *
		 * @param mpeg4Width video width
		 */
		public ResultMpeg4Ready withMpeg4Width(int mpeg4Width)
		{
			this.mpeg4Width = mpeg4Width;
			return this;
		}
		
		/**
		 * Sets height of the video.
		 *
		 * @param mpeg4Height video height
		 */
		public ResultMpeg4Ready withMpeg4Height(int mpeg4Height)
		{
			this.mpeg4Height = mpeg4Height;
			return this;
		}
		
		/**
		 * Sets title of the result.
		 *
		 * @param title the title
		 */
		public ResultMpeg4Ready withTitle(String title)
		{
			this.title = title;
			return this;
		}
		
		/**
		 * Caption of the MPEG-4 file to be sent, 0-200 characters.
		 *
		 * @param caption the caption
		 */
		public ResultMpeg4Ready withCaption(String caption)
		{
			this.caption = caption;
			return this;
		}
		
		/**
		 * Attaches an inline keyboard to the sending message.
		 *
		 * @param inlineKeyboard the inline keyboard
		 */
		public ResultMpeg4Ready attachInlineKeyboard(InlineKeyboardMarkup inlineKeyboard)
		{
			this.inlineKeyboard = inlineKeyboard;
			return this;
		}
		
		/**
		 * Content of the message to be sent instead of the photo.
		 *
		 * @param messageContent the message content
		 */
		public ResultMpeg4Ready withMessageContent(InputMessageContent messageContent)
		{
			this.messageContent = messageContent;
			return this;
		}
		
		/**
		 * Builds the <code>InlineQueryResult</code> object.
		 */
		public InlineQueryResult buildResult()
		{
			return new InlineQueryResultMpeg4Gif(id, inlineKeyboard, mpeg4Url, mpeg4Width, mpeg4Height,
			                                     thumbUrl, title, caption, messageContent);
		}
	}
	
	public static class ResultVideoNoIdNoVideoUrlNoMimeTypeNoThumbUrlNoTitle
	{
		public ResultVideoNoIdNoVideoUrlNoMimeTypeNoThumbUrlNoTitle(){}
		
		/**
		 * Sets unique identifier for this result, 1-64 bytes.
		 *
		 * @param id the unique identifier
		 */
		public ResultVideoNoVideoUrlNoMimeTypeNoThumbUrlNoTitle withId(String id)
		{
			return new ResultVideoNoVideoUrlNoMimeTypeNoThumbUrlNoTitle(id);
		}
	}
	
	public static class ResultVideoNoVideoUrlNoMimeTypeNoThumbUrlNoTitle
	{
		private String id;
		
		public ResultVideoNoVideoUrlNoMimeTypeNoThumbUrlNoTitle(String id)
		{
			this.id = id;
		}
		
		/**
		 * 	A valid URL for the embedded video player or video file.
		 *
		 * @param videoUrl video url
		 */
		public ResultVideoNoMimeTypeNoThumbUrlNoTitle withVideoUrl(String videoUrl)
		{
			return new ResultVideoNoMimeTypeNoThumbUrlNoTitle(id, videoUrl);
		}
	}
	
	public static class ResultVideoNoMimeTypeNoThumbUrlNoTitle
	{
		private String id;
		private String videoUrl;
		
		public ResultVideoNoMimeTypeNoThumbUrlNoTitle(String id, String videoUrl)
		{
			this.id = id;
			this.videoUrl = videoUrl;
		}
		
		/**
		 * 	Mime type of the content of video url, TEXT_HTML (“text/html”) or VIDEO_MP4 (“video/mp4”).
		 *
		 * @param mimeType the MIME type
		 */
		public ResultVideoNoThumbUrlNoTitle withMimeType(ResultVideoMimeType mimeType)
		{
			return new ResultVideoNoThumbUrlNoTitle(id, videoUrl, mimeType);
		}
	}
	
	public static class ResultVideoNoThumbUrlNoTitle
	{
		private String id;
		private String videoUrl;
		private ResultVideoMimeType mimeType;
		
		public ResultVideoNoThumbUrlNoTitle(String id, String videoUrl, ResultVideoMimeType mimeType)
		{
			this.id = id;
			this.videoUrl = videoUrl;
			this.mimeType = mimeType;
		}
		
		/**
		 * URL of the thumbnail (jpeg only) for the video.
		 *
		 * @param thumbUrl thumbnail url
		 */
		public ResultVideoNoTitle withThumbnailUrl(String thumbUrl)
		{
			return new ResultVideoNoTitle(id, videoUrl, mimeType, thumbUrl);
		}
	}
	
	public static class ResultVideoNoTitle
	{
		private String id;
		private String videoUrl;
		private ResultVideoMimeType mimeType;
		private String thumbUrl;
		
		public ResultVideoNoTitle(String id, String videoUrl, ResultVideoMimeType mimeType, String thumbUrl)
		{
			this.id = id;
			this.videoUrl = videoUrl;
			this.mimeType = mimeType;
			this.thumbUrl = thumbUrl;
		}
		
		/**
		 * Sets title of the result.
		 *
		 * @param title the title
		 */
		public ResultVideoReady withTitle(String title)
		{
			return new ResultVideoReady(id, videoUrl, mimeType, thumbUrl, title);
		}
	}
	
	public static class ResultVideoReady
	{
		private String id;
		private String videoUrl;
		private ResultVideoMimeType mimeType;
		private String thumbUrl;
		private String title;
		private String caption;
		private Integer videoWidth;
		private Integer videoHeight;
		private Integer videoDuration;
		private String description;
		private InlineKeyboardMarkup inlineKeyboard;
		private InputMessageContent messageContent;
		
		public ResultVideoReady(String id, String videoUrl, ResultVideoMimeType mimeType, String thumbUrl, String title)
		{
			this.id = id;
			this.videoUrl = videoUrl;
			this.mimeType = mimeType;
			this.thumbUrl = thumbUrl;
			this.title = title;
		}
		
		/**
		 * Caption of the photo to be sent, 0-200 characters.
		 *
		 * @param caption the caption
		 */
		public ResultVideoReady withCaption(String caption)
		{
			this.caption = caption;
			return this;
		}
		
		/**
		 * Sets width of the video.
		 *
		 * @param videoWidth video width
		 */
		public ResultVideoReady withVideoWidth(int videoWidth)
		{
			this.videoWidth = videoWidth;
			return this;
		}
		
		/**
		 * Sets height of the video.
		 *
		 * @param videoHeight video height
		 */
		public ResultVideoReady withVideoHeight(int videoHeight)
		{
			this.videoHeight = videoHeight;
			return this;
		}
		
		/**
		 * Sets duration of the video.
		 *
		 * @param videoDuration video duration in seconds
		 */
		public ResultVideoReady withVideoDuration(int videoDuration)
		{
			this.videoDuration = videoDuration;
			return this;
		}
		
		/**
		 * Short description of the result.
		 *
		 * @param description the description
		 */
		public ResultVideoReady withDescription(String description)
		{
			this.description = description;
			return this;
		}
		
		/**
		 * Attaches an inline keyboard to the sending message.
		 *
		 * @param inlineKeyboard the inline keyboard
		 */
		public ResultVideoReady attachInlineKeyboard(InlineKeyboardMarkup inlineKeyboard)
		{
			this.inlineKeyboard = inlineKeyboard;
			return this;
		}
		
		/**
		 * Content of the message to be sent instead of the video.
		 *
		 * @param messageContent the message content
		 */
		public ResultVideoReady withMessageContent(InputMessageContent messageContent)
		{
			this.messageContent = messageContent;
			return this;
		}
		
		/**
		 * Builds the <code>InlineQueryResult</code> object.
		 */
		public InlineQueryResult buildResult()
		{
			return new InlineQueryResultVideo(id, inlineKeyboard, videoUrl, mimeType, thumbUrl, title, caption,
			                                  videoWidth, videoHeight, videoDuration, description, messageContent);
		}
	}
	
	public static class ResultAudioNoIdNoAudioUrlNoTitle
	{
		public ResultAudioNoIdNoAudioUrlNoTitle(){}
		
		/**
		 * Sets unique identifier for this result, 1-64 bytes.
		 *
		 * @param id the unique identifier
		 */
		public ResultAudioNoAudioUrlNoTitle withId(String id)
		{
			return new ResultAudioNoAudioUrlNoTitle(id);
		}
	}
	
	public static class ResultAudioNoAudioUrlNoTitle
	{
		private String id;
		
		public ResultAudioNoAudioUrlNoTitle(String id)
		{
			this.id = id;
		}
		
		/**
		 * Sets a valid URL for the audio file.
		 *
		 * @param audioUrl the audio URL
		 */
		public ResultAudioNoTitle withAudioUrl(String audioUrl)
		{
			return new ResultAudioNoTitle(id, audioUrl);
		}
	}
	
	public static class ResultAudioNoTitle
	{
		private String id;
		private String audioUrl;
		
		public ResultAudioNoTitle(String id, String audioUrl)
		{
			this.id = id;
			this.audioUrl = audioUrl;
		}
		
		/**
		 * Sets title of the result.
		 *
		 * @param title the title
		 */
		public ResultAudioReady withTitle(String title)
		{
			return new ResultAudioReady(id, audioUrl, title);
		}
	}
	
	public static class ResultAudioReady
	{
		private String id;
		private String audioUrl;
		private String title;
		private String performer;
		private Integer audioDuration;
		private InlineKeyboardMarkup inlineKeyboard;
		private InputMessageContent messageContent;
		
		public ResultAudioReady(String id, String audioUrl, String title)
		{
			this.id = id;
			this.audioUrl = audioUrl;
			this.title = title;
		}
		
		/**
		 * Sets performer of the audio.
		 *
		 * @param performer the performer
		 */
		public ResultAudioReady withPerformer(String performer)
		{
			this.performer = performer;
			return this;
		}
		
		/**
		 * Sets duration of the audio.
		 *
		 * @param audioDuration audio duration in seconds
		 */
		public ResultAudioReady withAudioDuration(int audioDuration)
		{
			this.audioDuration = audioDuration;
			return this;
		}
		
		/**
		 * Attaches an inline keyboard to the sending message.
		 *
		 * @param inlineKeyboard the inline keyboard
		 */
		public ResultAudioReady attachInlineKeyboard(InlineKeyboardMarkup inlineKeyboard)
		{
			this.inlineKeyboard = inlineKeyboard;
			return this;
		}
		
		/**
		 * Content of the message to be sent instead of the audio.
		 *
		 * @param messageContent the message content
		 */
		public ResultAudioReady withMessageContent(InputMessageContent messageContent)
		{
			this.messageContent = messageContent;
			return this;
		}
		
		/**
		 * Builds the <code>InlineQueryResult</code> object.
		 */
		public InlineQueryResult buildResult()
		{
			return new InlineQueryResultAudio(id, inlineKeyboard, audioUrl, title, performer,
			                                  audioDuration, messageContent);
		}
	}
	
	public static class ResultVoiceNoIdNoVoiceUrlNoTitle
	{
		public ResultVoiceNoIdNoVoiceUrlNoTitle(){}
		
		/**
		 * Sets unique identifier for this result, 1-64 bytes.
		 *
		 * @param id the unique identifier
		 */
		public ResultVoiceNoVoiceUrlNoTitle withId(String id)
		{
			return new ResultVoiceNoVoiceUrlNoTitle(id);
		}
	}
	
	public static class ResultVoiceNoVoiceUrlNoTitle
	{
		private String id;
		
		public ResultVoiceNoVoiceUrlNoTitle(String id)
		{
			this.id = id;
		}
		
		/**
		 * Sets a valid URL for the voice recording.
		 *
		 * @param voiceUrl the voice recording URL
		 */
		public ResultVoiceNoTitle withVoiceUrl(String voiceUrl)
		{
			return new ResultVoiceNoTitle(id, voiceUrl);
		}
	}
	
	public static class ResultVoiceNoTitle
	{
		private String id;
		private String voiceUrl;
		
		public ResultVoiceNoTitle(String id, String voiceUrl)
		{
			this.id = id;
			this.voiceUrl = voiceUrl;
		}
		
		/**
		 * Sets title of the recording.
		 *
		 * @param title the title
		 */
		public ResultVoiceReady withTitle(String title)
		{
			return new ResultVoiceReady(id, voiceUrl, title);
		}
	}
	
	public static class ResultVoiceReady
	{
		private String id;
		private String voiceUrl;
		private String title;
		private Integer voiceDuration;
		private InlineKeyboardMarkup inlineKeyboard;
		private InputMessageContent messageContent;
		
		public ResultVoiceReady(String id, String voiceUrl, String title)
		{
			this.id = id;
			this.voiceUrl = voiceUrl;
			this.title = title;
		}
		
		/**
		 * Sets duration of the recording.
		 *
		 * @param voiceDuration recording duration in seconds
		 */
		public ResultVoiceReady withVoiceDuration(int voiceDuration)
		{
			this.voiceDuration = voiceDuration;
			return this;
		}
		
		/**
		 * Attaches an inline keyboard to the sending message.
		 *
		 * @param inlineKeyboard the inline keyboard
		 */
		public ResultVoiceReady attachInlineKeyboard(InlineKeyboardMarkup inlineKeyboard)
		{
			this.inlineKeyboard = inlineKeyboard;
			return this;
		}
		
		/**
		 * Content of the message to be sent instead of the voice recording.
		 *
		 * @param messageContent the message content
		 */
		public ResultVoiceReady withMessageContent(InputMessageContent messageContent)
		{
			this.messageContent = messageContent;
			return this;
		}
		
		/**
		 * Builds the <code>InlineQueryResult</code> object.
		 */
		public InlineQueryResult buildResult()
		{
			return new InlineQueryResultVoice(id, inlineKeyboard, voiceUrl, title, voiceDuration, messageContent);
		}
	}
	
	public static class ResultDocumentNoIdNoTitleNoDocumentUrlNoMimeType
	{
		public ResultDocumentNoIdNoTitleNoDocumentUrlNoMimeType(){}
		
		/**
		 * Sets unique identifier for this result, 1-64 bytes.
		 *
		 * @param id the unique identifier
		 */
		public ResultDocumentNoTitleNoDocumentUrlNoMimeType withId(String id)
		{
			return new ResultDocumentNoTitleNoDocumentUrlNoMimeType(id);
		}
	}
	
	public static class ResultDocumentNoTitleNoDocumentUrlNoMimeType
	{
		private String id;
		
		public ResultDocumentNoTitleNoDocumentUrlNoMimeType(String id)
		{
			this.id = id;
		}
		
		/**
		 * Sets title of the result.
		 *
		 * @param title the title
		 */
		public ResultDocumentNoDocumentUrlNoMimeType withTitle(String title)
		{
			return new ResultDocumentNoDocumentUrlNoMimeType(id, title);
		}
	}
	
	public static class ResultDocumentNoDocumentUrlNoMimeType
	{
		private String id;
		private String title;
		
		public ResultDocumentNoDocumentUrlNoMimeType(String id, String title)
		{
			this.id = id;
			this.title = title;
		}
		
		/**
		 * Sets a valid URL for the file.
		 *
		 * @param documentUrl the file URL
		 */
		public ResultDocumentNoMimeType withDocumentUrl(String documentUrl)
		{
			return new ResultDocumentNoMimeType(id, title, documentUrl);
		}
	}
	
	public static class ResultDocumentNoMimeType
	{
		private String id;
		private String title;
		private String documentUrl;
		
		public ResultDocumentNoMimeType(String id, String title, String documentUrl)
		{
			this.id = id;
			this.title = title;
			this.documentUrl = documentUrl;
		}
		
		/**
		 * Sets mime type of the content of the file, either “application/pdf” or “application/zip”.
		 *
		 * @param mimeType the mime type
		 */
		public ResultDocumentReady withMimeType(ResultDocumentMimeType mimeType)
		{
			return new ResultDocumentReady(id, title, documentUrl, mimeType);
		}
	}
	
	public static class ResultDocumentReady
	{
		private String id;
		private String title;
		private String documentUrl;
		private ResultDocumentMimeType mimeType;
		private String caption;
		private String description;
		private InlineKeyboardMarkup inlineKeyboard;
		private InputMessageContent messageContent;
		private String thumbUrl;
		private Integer thumbWidth;
		private Integer thumbHeight;
		
		public ResultDocumentReady(String id, String title, String documentUrl, ResultDocumentMimeType mimeType)
		{
			this.id = id;
			this.title = title;
			this.documentUrl = documentUrl;
			this.mimeType = mimeType;
		}
		
		/**
		 * Caption of the document to be sent, 0-200 characters.
		 *
		 * @param caption the caption
		 */
		public ResultDocumentReady withCaption(String caption)
		{
			this.caption = caption;
			return this;
		}
		
		/**
		 * Short description of the result.
		 *
		 * @param description the description
		 */
		public ResultDocumentReady withDescription(String description)
		{
			this.description = description;
			return this;
		}
		
		/**
		 * Attaches an inline keyboard to the sending message.
		 *
		 * @param inlineKeyboard the inline keyboard
		 */
		public ResultDocumentReady attachInlineKeyboard(InlineKeyboardMarkup inlineKeyboard)
		{
			this.inlineKeyboard = inlineKeyboard;
			return this;
		}
		
		/**
		 * Content of the message to be sent instead of the file.
		 *
		 * @param messageContent the message content
		 */
		public ResultDocumentReady withMessageContent(InputMessageContent messageContent)
		{
			this.messageContent = messageContent;
			return this;
		}
		
		/**
		 * URL of the thumbnail (jpeg only) for the file.
		 *
		 * @param thumbUrl the url
		 */
		public ResultDocumentReady withThumbnailUrl(String thumbUrl)
		{
			this.thumbUrl = thumbUrl;
			return this;
		}
		
		/**
		 * Sets the thumbnail width.
		 *
		 * @param thumbWidth the thumbnail width
		 */
		public ResultDocumentReady withThumbnailWidth(int thumbWidth)
		{
			this.thumbWidth = thumbWidth;
			return this;
		}
		
		/**
		 * Sets the thumbnail height.
		 *
		 * @param thumbHeight the thumbnail height
		 */
		public ResultDocumentReady withThumbnailHeight(int thumbHeight)
		{
			this.thumbHeight = thumbHeight;
			return this;
		}
		
		/**
		 * Builds the <code>InlineQueryResult</code> object.
		 */
		public InlineQueryResult buildResult()
		{
			return new InlineQueryResultDocument(id, inlineKeyboard, title, caption, documentUrl, mimeType,
			                                     description, messageContent, thumbUrl, thumbWidth, thumbHeight);
		}
	}
	
	public static class ResultLocationNoIdNoLatitudeNoLongitudeNoTitle
	{
		public ResultLocationNoIdNoLatitudeNoLongitudeNoTitle(){}
		
		/**
		 * Sets unique identifier for this result, 1-64 bytes.
		 *
		 * @param id the unique identifier
		 */
		public ResultLocationNoLatitudeNoLongitudeNoTitle withId(String id)
		{
			return new ResultLocationNoLatitudeNoLongitudeNoTitle(id);
		}
	}
	
	public static class ResultLocationNoLatitudeNoLongitudeNoTitle
	{
		private String id;
		
		public ResultLocationNoLatitudeNoLongitudeNoTitle(String id)
		{
			this.id = id;
		}
		
		/**
		 * Sets location latitude.
		 *
		 * @param latitude location latitude in degrees
		 */
		public ResultLocationNoLongitudeNoTitle withLatitude(double latitude)
		{
			return new ResultLocationNoLongitudeNoTitle(id, latitude);
		}
	}
	
	public static class ResultLocationNoLongitudeNoTitle
	{
		private String id;
		private double latitude;
		
		public ResultLocationNoLongitudeNoTitle(String id, double latitude)
		{
			this.id = id;
			this.latitude = latitude;
		}
		
		/**
		 * Sets location longitude.
		 *
		 * @param longitude location longitude in degrees
		 */
		public ResultLocationNoTitle withLongitude(double longitude)
		{
			return new ResultLocationNoTitle(id, latitude, longitude);
		}
	}
	
	public static class ResultLocationNoTitle
	{
		private String id;
		private double latitude;
		private double longitude;
		
		public ResultLocationNoTitle(String id, double latitude, double longitude)
		{
			this.id = id;
			this.latitude = latitude;
			this.longitude = longitude;
		}
		
		/**
		 * Sets title of the location.
		 *
		 * @param title location title
		 */
		public ResultLocationReady withTitle(String title)
		{
			return new ResultLocationReady(id, latitude, longitude, title);
		}
	}
	
	public static class ResultLocationReady
	{
		private String id;
		private double latitude;
		private double longitude;
		private String title;
		private InlineKeyboardMarkup inlineKeyboard;
		private InputMessageContent messageContent;
		private String thumbUrl;
		private Integer thumbWidth;
		private Integer thumbHeight;
		
		public ResultLocationReady(String id, double latitude, double longitude, String title)
		{
			this.id = id;
			this.latitude = latitude;
			this.longitude = longitude;
			this.title = title;
		}
		
		/**
		 * Attaches an inline keyboard to the sending message.
		 *
		 * @param inlineKeyboard the inline keyboard
		 */
		public ResultLocationReady attachInlineKeyboard(InlineKeyboardMarkup inlineKeyboard)
		{
			this.inlineKeyboard = inlineKeyboard;
			return this;
		}
		
		/**
		 * Content of the message to be sent instead of the location.
		 *
		 * @param messageContent the message content
		 */
		public ResultLocationReady withMessageContent(InputMessageContent messageContent)
		{
			this.messageContent = messageContent;
			return this;
		}
		
		/**
		 * Url of the thumbnail for the result.
		 *
		 * @param thumbUrl the url
		 */
		public ResultLocationReady withThumbnailUrl(String thumbUrl)
		{
			this.thumbUrl = thumbUrl;
			return this;
		}
		
		/**
		 * Sets the thumbnail width.
		 *
		 * @param thumbWidth the thumbnail width
		 */
		public ResultLocationReady withThumbnailWidth(int thumbWidth)
		{
			this.thumbWidth = thumbWidth;
			return this;
		}
		
		/**
		 * Sets the thumbnail height.
		 *
		 * @param thumbHeight the thumbnail height
		 */
		public ResultLocationReady withThumbnailHeight(int thumbHeight)
		{
			this.thumbHeight = thumbHeight;
			return this;
		}
		
		/**
		 * Builds the <code>InlineQueryResult</code> object.
		 */
		public InlineQueryResult buildResult()
		{
			return new InlineQueryResultLocation(id, inlineKeyboard, latitude, longitude, title,
			                                     messageContent, thumbUrl, thumbWidth, thumbHeight);
		}
	}
	
	public static class ResultVenueNoIdNoLatitudeNoLongitudeNoTitleNoAddress
	{
		public ResultVenueNoIdNoLatitudeNoLongitudeNoTitleNoAddress(){}
		
		/**
		 * Sets unique identifier for this result, 1-64 bytes.
		 *
		 * @param id the unique identifier
		 */
		public ResultVenueNoLatitudeNoLongitudeNoTitleNoAddress withId(String id)
		{
			return new ResultVenueNoLatitudeNoLongitudeNoTitleNoAddress(id);
		}
	}
	
	public static class ResultVenueNoLatitudeNoLongitudeNoTitleNoAddress
	{
		private String id;
		
		public ResultVenueNoLatitudeNoLongitudeNoTitleNoAddress(String id)
		{
			this.id = id;
		}
		
		/**
		 * Sets location latitude of the venue.
		 *
		 * @param latitude location latitude in degrees
		 */
		public ResultVenueNoLongitudeNoTitleNoAddress withLatitude(double latitude)
		{
			return new ResultVenueNoLongitudeNoTitleNoAddress(id, latitude);
		}
	}
	
	public static class ResultVenueNoLongitudeNoTitleNoAddress
	{
		private String id;
		private double latitude;
		
		public ResultVenueNoLongitudeNoTitleNoAddress(String id, double latitude)
		{
			this.id = id;
			this.latitude = latitude;
		}
		
		/**
		 * Sets location longitude of the venue.
		 *
		 * @param longitude location longitude in degrees
		 */
		public ResultVenueNoTitleNoAddress withLongitude(double longitude)
		{
			return new ResultVenueNoTitleNoAddress(id, latitude, longitude);
		}
	}
	
	public static class ResultVenueNoTitleNoAddress
	{
		private String id;
		private double latitude;
		private double longitude;
		
		public ResultVenueNoTitleNoAddress(String id, double latitude, double longitude)
		{
			this.id = id;
			this.latitude = latitude;
			this.longitude = longitude;
		}
		
		/**
		 * Sets title of the venue.
		 *
		 * @param title venue title
		 */
		public ResultVenueNoAddress withTitle(String title)
		{
			return new ResultVenueNoAddress(id, latitude, longitude, title);
		}
	}
	
	public static class ResultVenueNoAddress
	{
		private String id;
		private double latitude;
		private double longitude;
		private String title;
		
		public ResultVenueNoAddress(String id, double latitude, double longitude, String title)
		{
			this.id = id;
			this.latitude = latitude;
			this.longitude = longitude;
			this.title = title;
		}
		
		/**
		 * Sets address of the venue.
		 *
		 * @param address venue address
		 */
		public ResultVenueReady withAddress(String address)
		{
			return new ResultVenueReady(id, latitude, longitude, title, address);
		}
	}
	
	public static class ResultVenueReady
	{
		private String id;
		private double latitude;
		private double longitude;
		private String title;
		private String address;
		private String foursquareId;
		private InlineKeyboardMarkup inlineKeyboard;
		private InputMessageContent messageContent;
		private String thumbUrl;
		private Integer thumbWidth;
		private Integer thumbHeight;
		
		public ResultVenueReady(String id, double latitude, double longitude, String title, String address)
		{
			this.id = id;
			this.latitude = latitude;
			this.longitude = longitude;
			this.title = title;
			this.address = address;
		}
		
		/**
		 * Foursquare identifier of the venue.
		 *
		 * @param foursquareId foursquare id
		 */
		public ResultVenueReady withFoursquareId(String foursquareId)
		{
			this.foursquareId = foursquareId;
			return this;
		}
		
		/**
		 * Attaches an inline keyboard to the sending message.
		 *
		 * @param inlineKeyboard the inline keyboard
		 */
		public ResultVenueReady attachInlineKeyboard(InlineKeyboardMarkup inlineKeyboard)
		{
			this.inlineKeyboard = inlineKeyboard;
			return this;
		}
		
		/**
		 * Content of the message to be sent instead of the venue.
		 *
		 * @param messageContent the message content
		 */
		public ResultVenueReady withMessageContent(InputMessageContent messageContent)
		{
			this.messageContent = messageContent;
			return this;
		}
		
		/**
		 * Url of the thumbnail for the result.
		 *
		 * @param thumbUrl the url
		 */
		public ResultVenueReady withThumbnailUrl(String thumbUrl)
		{
			this.thumbUrl = thumbUrl;
			return this;
		}
		
		/**
		 * Sets the thumbnail width.
		 *
		 * @param thumbWidth the thumbnail width
		 */
		public ResultVenueReady withThumbnailWidth(int thumbWidth)
		{
			this.thumbWidth = thumbWidth;
			return this;
		}
		
		/**
		 * Sets the thumbnail height.
		 *
		 * @param thumbHeight the thumbnail height
		 */
		public ResultVenueReady withThumbnailHeight(int thumbHeight)
		{
			this.thumbHeight = thumbHeight;
			return this;
		}
		
		/**
		 * Builds the <code>InlineQueryResult</code> object.
		 */
		public InlineQueryResult buildResult()
		{
			return new InlineQueryResultVenue(id, inlineKeyboard, latitude, longitude, title,
			                                  address, foursquareId, messageContent, thumbUrl,
			                                  thumbWidth, thumbHeight);
		}
	}
	
	public static class ResultContactNoIdNoPhoneNumberNoFirstName
	{
		public ResultContactNoIdNoPhoneNumberNoFirstName(){}
		
		/**
		 * Sets unique identifier for this result, 1-64 bytes.
		 *
		 * @param id the unique identifier
		 */
		public ResultContactNoPhoneNumberNoFirstName withId(String id)
		{
			return new ResultContactNoPhoneNumberNoFirstName(id);
		}
	}
	
	public static class ResultContactNoPhoneNumberNoFirstName
	{
		private String id;
		
		public ResultContactNoPhoneNumberNoFirstName(String id)
		{
			this.id = id;
		}
		
		/**
		 * Sets contact's phone number.
		 *
		 * @param phoneNumber the phone number
		 */
		public ResultContactNoFirstName withPhoneNumber(String phoneNumber)
		{
			return new ResultContactNoFirstName(id, phoneNumber);
		}
	}
	
	public static class ResultContactNoFirstName
	{
		private String id;
		private String phoneNumber;
		
		public ResultContactNoFirstName(String id, String phoneNumber)
		{
			this.id = id;
			this.phoneNumber = phoneNumber;
		}
		
		/**
		 * Sets contact's first name.
		 *
		 * @param firstName contact's first name
		 */
		public ResultContactReady withFirstName(String firstName)
		{
			return new ResultContactReady(id, phoneNumber, firstName);
		}
	}
	
	public static class ResultContactReady
	{
		private String id;
		private String phoneNumber;
		private String firstName;
		private String lastName;
		private InlineKeyboardMarkup inlineKeyboard;
		private InputMessageContent messageContent;
		private String thumbUrl;
		private Integer thumbWidth;
		private Integer thumbHeight;
		
		public ResultContactReady(String id, String phoneNumber, String firstName)
		{
			this.id = id;
			this.phoneNumber = phoneNumber;
			this.firstName = firstName;
		}
		
		/**
		 * Sets contact's last name.
		 *
		 * @param lastName contact's last name
		 */
		public ResultContactReady withLastName(String lastName)
		{
			this.lastName = lastName;
			return this;
		}
		
		/**
		 * Attaches an inline keyboard to the sending message.
		 *
		 * @param inlineKeyboard the inline keyboard
		 */
		public ResultContactReady attachInlineKeyboard(InlineKeyboardMarkup inlineKeyboard)
		{
			this.inlineKeyboard = inlineKeyboard;
			return this;
		}
		
		/**
		 * Content of the message to be sent instead of the contact.
		 *
		 * @param messageContent the message content
		 */
		public ResultContactReady withMessageContent(InputMessageContent messageContent)
		{
			this.messageContent = messageContent;
			return this;
		}
		
		/**
		 * Url of the thumbnail for the result.
		 *
		 * @param thumbUrl the url
		 */
		public ResultContactReady withThumbnailUrl(String thumbUrl)
		{
			this.thumbUrl = thumbUrl;
			return this;
		}
		
		/**
		 * Sets the thumbnail width.
		 *
		 * @param thumbWidth the thumbnail width
		 */
		public ResultContactReady withThumbnailWidth(int thumbWidth)
		{
			this.thumbWidth = thumbWidth;
			return this;
		}
		
		/**
		 * Sets the thumbnail height.
		 *
		 * @param thumbHeight the thumbnail height
		 */
		public ResultContactReady withThumbnailHeight(int thumbHeight)
		{
			this.thumbHeight = thumbHeight;
			return this;
		}
		
		/**
		 * Builds the <code>InlineQueryResult</code> object.
		 */
		public InlineQueryResult buildResult()
		{
			return new InlineQueryResultContact(id, inlineKeyboard, phoneNumber, firstName, lastName,
			                                    messageContent, thumbUrl, thumbWidth, thumbHeight);
		}
	}
	
	public static class ResultCachedPhotoNoIdNoPhotoFileId
	{
		public ResultCachedPhotoNoIdNoPhotoFileId(){}
		
		/**
		 * Sets unique identifier for this result, 1-64 bytes.
		 *
		 * @param id the unique identifier
		 */
		public ResultCachedPhotoNoPhotoFileId withId(String id)
		{
			return new ResultCachedPhotoNoPhotoFileId(id);
		}
	}
	
	public static class ResultCachedPhotoNoPhotoFileId
	{
		private String id;
		
		public ResultCachedPhotoNoPhotoFileId(String id)
		{
			this.id = id;
		}
		
		/**
		 * A valid file identifier of the photo.
		 *
		 * @param photoFileId file id
		 */
		public ResultCachedPhotoReady withPhotoFileId(String photoFileId)
		{
			return new ResultCachedPhotoReady(id, photoFileId);
		}
	}
	
	public static class ResultCachedPhotoReady
	{
		private String id;
		private String photoFileId;
		private String title;
		private String description;
		private String caption;
		private InlineKeyboardMarkup inlineKeyboard;
		private InputMessageContent messageContent;
		
		public ResultCachedPhotoReady(String id, String photoFileId)
		{
			this.id = id;
			this.photoFileId = photoFileId;
		}
		
		/**
		 * Sets title of the result.
		 *
		 * @param title the title
		 */
		public ResultCachedPhotoReady withTitle(String title)
		{
			this.title = title;
			return this;
		}
		
		/**
		 * Short description of the result.
		 *
		 * @param description the description
		 */
		public ResultCachedPhotoReady withDescription(String description)
		{
			this.description = description;
			return this;
		}
		
		/**
		 * Caption of the photo to be sent, 0-200 characters.
		 *
		 * @param caption the caption
		 */
		public ResultCachedPhotoReady withCaption(String caption)
		{
			this.caption = caption;
			return this;
		}
		
		/**
		 * Attaches an inline keyboard to the sending message.
		 *
		 * @param inlineKeyboard the inline keyboard
		 */
		public ResultCachedPhotoReady attachInlineKeyboard(InlineKeyboardMarkup inlineKeyboard)
		{
			this.inlineKeyboard = inlineKeyboard;
			return this;
		}
		
		/**
		 * Content of the message to be sent instead of the photo.
		 *
		 * @param messageContent the message content
		 */
		public ResultCachedPhotoReady withMessageContent(InputMessageContent messageContent)
		{
			this.messageContent = messageContent;
			return this;
		}
		
		/**
		 * Builds the <code>InlineQueryResult</code> object.
		 */
		public InlineQueryResult buildResult()
		{
			return new InlineQueryResultCachedPhoto(id, inlineKeyboard, photoFileId, title, description,
			                                        caption, messageContent);
		}
	}
	
	public static class ResultCachedGifNoIdNoGifFileId
	{
		public ResultCachedGifNoIdNoGifFileId(){}
		
		/**
		 * Sets unique identifier for this result, 1-64 bytes.
		 *
		 * @param id the unique identifier
		 */
		public ResultCachedGifNoGifFileId withId(String id)
		{
			return new ResultCachedGifNoGifFileId(id);
		}
	}
	
	public static class ResultCachedGifNoGifFileId
	{
		private String id;
		
		public ResultCachedGifNoGifFileId(String id)
		{
			this.id = id;
		}
		
		/**
		 * A valid file identifier of the GIF file.
		 *
		 * @param gifFileId file id
		 */
		public ResultCachedGifReady withGifFileId(String gifFileId)
		{
			return new ResultCachedGifReady(id, gifFileId);
		}
	}
	
	public static class ResultCachedGifReady
	{
		private String id;
		private String gifFileId;
		private String title;
		private String caption;
		private InlineKeyboardMarkup inlineKeyboard;
		private InputMessageContent messageContent;
		
		public ResultCachedGifReady(String id, String gifFileId)
		{
			this.id = id;
			this.gifFileId = gifFileId;
		}
		
		/**
		 * Sets title of the result.
		 *
		 * @param title the title
		 */
		public ResultCachedGifReady withTitle(String title)
		{
			this.title = title;
			return this;
		}
		
		/**
		 * Caption of the GIF file to be sent, 0-200 characters.
		 *
		 * @param caption the caption
		 */
		public ResultCachedGifReady withCaption(String caption)
		{
			this.caption = caption;
			return this;
		}
		
		/**
		 * Attaches an inline keyboard to the sending message.
		 *
		 * @param inlineKeyboard the inline keyboard
		 */
		public ResultCachedGifReady attachInlineKeyboard(InlineKeyboardMarkup inlineKeyboard)
		{
			this.inlineKeyboard = inlineKeyboard;
			return this;
		}
		
		/**
		 * Content of the message to be sent instead of the GIF animation.
		 *
		 * @param messageContent the message content
		 */
		public ResultCachedGifReady withMessageContent(InputMessageContent messageContent)
		{
			this.messageContent = messageContent;
			return this;
		}
		
		/**
		 * Builds the <code>InlineQueryResult</code> object.
		 */
		public InlineQueryResult buildResult()
		{
			return new InlineQueryResultCachedGif(id, inlineKeyboard, gifFileId, title, caption, messageContent);
		}
	}
	
	public static class ResultCachedMpeg4GifNoIdNoMpeg4FileId
	{
		public ResultCachedMpeg4GifNoIdNoMpeg4FileId(){}
		
		/**
		 * Sets unique identifier for this result, 1-64 bytes.
		 *
		 * @param id the unique identifier
		 */
		public ResultCachedMpeg4GifNoMpeg4FileId withId(String id)
		{
			return new ResultCachedMpeg4GifNoMpeg4FileId(id);
		}
	}
	
	public static class ResultCachedMpeg4GifNoMpeg4FileId
	{
		private String id;
		
		public ResultCachedMpeg4GifNoMpeg4FileId(String id)
		{
			this.id = id;
		}
		
		/**
		 * A valid file identifier of the MP4 file.
		 *
		 * @param mpeg4FileId file id
		 */
		public ResultCachedMpeg4GifReady withMpeg4FileId(String mpeg4FileId)
		{
			return new ResultCachedMpeg4GifReady(id, mpeg4FileId);
		}
	}
	
	public static class ResultCachedMpeg4GifReady
	{
		private String id;
		private String mpeg4FileId;
		private String title;
		private String caption;
		private InlineKeyboardMarkup inlineKeyboard;
		private InputMessageContent messageContent;
		
		public ResultCachedMpeg4GifReady(String id, String mpeg4FileId)
		{
			this.id = id;
			this.mpeg4FileId = mpeg4FileId;
		}
		
		/**
		 * Sets title of the result.
		 *
		 * @param title the title
		 */
		public ResultCachedMpeg4GifReady withTitle(String title)
		{
			this.title = title;
			return this;
		}
		
		/**
		 * Caption of the MPEG-4 file to be sent, 0-200 characters.
		 *
		 * @param caption the caption
		 */
		public ResultCachedMpeg4GifReady withCaption(String caption)
		{
			this.caption = caption;
			return this;
		}
		
		/**
		 * Attaches an inline keyboard to the sending message.
		 *
		 * @param inlineKeyboard the inline keyboard
		 */
		public ResultCachedMpeg4GifReady attachInlineKeyboard(InlineKeyboardMarkup inlineKeyboard)
		{
			this.inlineKeyboard = inlineKeyboard;
			return this;
		}
		
		/**
		 * Content of the message to be sent instead of the video animation.
		 *
		 * @param messageContent the message content
		 */
		public ResultCachedMpeg4GifReady withMessageContent(InputMessageContent messageContent)
		{
			this.messageContent = messageContent;
			return this;
		}
		
		/**
		 * Builds the <code>InlineQueryResult</code> object.
		 */
		public InlineQueryResult buildResult()
		{
			return new InlineQueryResultCachedMpeg4Gif(id, inlineKeyboard, mpeg4FileId, title, caption, messageContent);
		}
	}
	
	public static class ResultCachedStickerNoIdNoStickerFileId
	{
		public ResultCachedStickerNoIdNoStickerFileId(){}
		
		/**
		 * Sets unique identifier for this result, 1-64 bytes.
		 *
		 * @param id the unique identifier
		 */
		public ResultCachedStickerNoStickerFileId withId(String id)
		{
			return new ResultCachedStickerNoStickerFileId(id);
		}
	}
	
	public static class ResultCachedStickerNoStickerFileId
	{
		private String id;
		
		public ResultCachedStickerNoStickerFileId(String id)
		{
			this.id = id;
		}
		
		/**
		 * A valid file identifier of the sticker.
		 *
		 * @param stickerFileId file id
		 */
		public ResultCachedStickerReady withStickerFileId(String stickerFileId)
		{
			return new ResultCachedStickerReady(id, stickerFileId);
		}
	}
	
	public static class ResultCachedStickerReady
	{
		private String id;
		private String stickerFileId;
		private InlineKeyboardMarkup inlineKeyboard;
		private InputMessageContent messageContent;
		
		public ResultCachedStickerReady(String id, String stickerFileId)
		{
			this.id = id;
			this.stickerFileId = stickerFileId;
		}
		
		/**
		 * Attaches an inline keyboard to the sending message.
		 *
		 * @param inlineKeyboard the inline keyboard
		 */
		public ResultCachedStickerReady attachInlineKeyboard(InlineKeyboardMarkup inlineKeyboard)
		{
			this.inlineKeyboard = inlineKeyboard;
			return this;
		}
		
		/**
		 * Content of the message to be sent instead of the sticker.
		 *
		 * @param messageContent the message content
		 */
		public ResultCachedStickerReady withMessageContent(InputMessageContent messageContent)
		{
			this.messageContent = messageContent;
			return this;
		}
		
		/**
		 * Builds the <code>InlineQueryResult</code> object.
		 */
		public InlineQueryResult buildResult()
		{
			return new InlineQueryResultCachedSticker(id, inlineKeyboard, stickerFileId, messageContent);
		}
	}
	
	public static class ResultCachedDocumentNoIdNoTitleNoDocumentFileId
	{
		public ResultCachedDocumentNoIdNoTitleNoDocumentFileId(){}
		
		/**
		 * Sets unique identifier for this result, 1-64 bytes.
		 *
		 * @param id the unique identifier
		 */
		public ResultCachedDocumentNoTitleNoDocumentFileId withId(String id)
		{
			return new ResultCachedDocumentNoTitleNoDocumentFileId(id);
		}
	}
	
	public static class ResultCachedDocumentNoTitleNoDocumentFileId
	{
		private String id;
		
		public ResultCachedDocumentNoTitleNoDocumentFileId(String id)
		{
			this.id = id;
		}
		
		/**
		 * Sets title of the result.
		 *
		 * @param title the title
		 */
		public ResultCachedDocumentNoDocumentFileId withTitle(String title)
		{
			return new ResultCachedDocumentNoDocumentFileId(id, title);
		}
	}
	
	public static class ResultCachedDocumentNoDocumentFileId
	{
		private String id;
		private String title;
		
		public ResultCachedDocumentNoDocumentFileId(String id, String title)
		{
			this.id = id;
			this.title = title;
		}
		
		/**
		 * A valid file identifier of the file.
		 *
		 * @param documentFileId file id
		 */
		public ResultCachedDocumentReady withDocumentFileId(String documentFileId)
		{
			return new ResultCachedDocumentReady(id, title, documentFileId);
		}
	}
	
	public static class ResultCachedDocumentReady
	{
		private String id;
		private String title;
		private String documentFileId;
		private String description;
		private String caption;
		private InlineKeyboardMarkup inlineKeyboard;
		private InputMessageContent messageContent;
		
		public ResultCachedDocumentReady(String id, String title, String documentFileId)
		{
			this.id = id;
			this.title = title;
			this.documentFileId = documentFileId;
		}
		
		/**
		 * Short description of the result.
		 *
		 * @param description the description
		 */
		public ResultCachedDocumentReady withDescription(String description)
		{
			this.description = description;
			return this;
		}
		
		/**
		 * Caption of the document to be sent, 0-200 characters.
		 *
		 * @param caption the caption
		 */
		public ResultCachedDocumentReady withCaption(String caption)
		{
			this.caption = caption;
			return this;
		}
		
		/**
		 * Attaches an inline keyboard to the sending message.
		 *
		 * @param inlineKeyboard the inline keyboard
		 */
		public ResultCachedDocumentReady attachInlineKeyboard(InlineKeyboardMarkup inlineKeyboard)
		{
			this.inlineKeyboard = inlineKeyboard;
			return this;
		}
		
		/**
		 * Content of the message to be sent instead of the file.
		 *
		 * @param messageContent the message content
		 */
		public ResultCachedDocumentReady withMessageContent(InputMessageContent messageContent)
		{
			this.messageContent = messageContent;
			return this;
		}
		
		/**
		 * Builds the <code>InlineQueryResult</code> object.
		 */
		public InlineQueryResult buildResult()
		{
			return new InlineQueryResultCachedDocument(id, inlineKeyboard, title, documentFileId, description,
			                                           caption, messageContent);
		}
	}
	
	public static class ResultCachedVideoNoIdNoVideoFileIdNoTitle
	{
		public ResultCachedVideoNoIdNoVideoFileIdNoTitle(){}
		
		/**
		 * Sets unique identifier for this result, 1-64 bytes.
		 *
		 * @param id the unique identifier
		 */
		public ResultCachedVideoNoVideoFileIdNoTitle withId(String id)
		{
			return new ResultCachedVideoNoVideoFileIdNoTitle(id);
		}
	}
	
	public static class ResultCachedVideoNoVideoFileIdNoTitle
	{
		private String id;
		
		public ResultCachedVideoNoVideoFileIdNoTitle(String id)
		{
			this.id = id;
		}
		
		/**
		 * A valid file identifier of the video file.
		 *
		 * @param videoFileId file id
		 */
		public ResultCachedVideoNoTitle withVideoFileId(String videoFileId)
		{
			return new ResultCachedVideoNoTitle(id, videoFileId);
		}
	}
	
	public static class ResultCachedVideoNoTitle
	{
		private String id;
		private String videoFileId;
		
		public ResultCachedVideoNoTitle(String id, String videoFileId)
		{
			this.id = id;
			this.videoFileId = videoFileId;
		}
		
		/**
		 * Sets title of the result.
		 *
		 * @param title the title
		 */
		public ResultCachedVideoReady withTitle(String title)
		{
			return new ResultCachedVideoReady(id, videoFileId, title);
		}
	}
	
	public static class ResultCachedVideoReady
	{
		private String id;
		private String videoFileId;
		private String title;
		private String description;
		private String caption;
		private InlineKeyboardMarkup inlineKeyboard;
		private InputMessageContent messageContent;
		
		public ResultCachedVideoReady(String id, String videoFileId, String title)
		{
			this.id = id;
			this.videoFileId = videoFileId;
			this.title = title;
		}
		
		/**
		 * Short description of the result.
		 *
		 * @param description the description
		 */
		public ResultCachedVideoReady withDescription(String description)
		{
			this.description = description;
			return this;
		}
		
		/**
		 * Caption of the video to be sent, 0-200 characters.
		 *
		 * @param caption the caption
		 */
		public ResultCachedVideoReady withCaption(String caption)
		{
			this.caption = caption;
			return this;
		}
		
		/**
		 * Attaches an inline keyboard to the sending message.
		 *
		 * @param inlineKeyboard the inline keyboard
		 */
		public ResultCachedVideoReady attachInlineKeyboard(InlineKeyboardMarkup inlineKeyboard)
		{
			this.inlineKeyboard = inlineKeyboard;
			return this;
		}
		
		/**
		 * Content of the message to be sent instead of the video.
		 *
		 * @param messageContent the message content
		 */
		public ResultCachedVideoReady withMessageContent(InputMessageContent messageContent)
		{
			this.messageContent = messageContent;
			return this;
		}
		
		/**
		 * Builds the <code>InlineQueryResult</code> object.
		 */
		public InlineQueryResult buildResult()
		{
			return new InlineQueryResultCachedVideo(id, inlineKeyboard, videoFileId, title,
			                                        description, caption, messageContent);
		}
	}
	
	public static class ResultCachedVoiceNoIdNoVoiceFileIdNoTitle
	{
		public ResultCachedVoiceNoIdNoVoiceFileIdNoTitle(){}
		
		/**
		 * Sets unique identifier for this result, 1-64 bytes.
		 *
		 * @param id the unique identifier
		 */
		public ResultCachedVoiceNoVoiceFileIdNoTitle withId(String id)
		{
			return new ResultCachedVoiceNoVoiceFileIdNoTitle(id);
		}
	}
	
	public static class ResultCachedVoiceNoVoiceFileIdNoTitle
	{
		private String id;
		
		public ResultCachedVoiceNoVoiceFileIdNoTitle(String id)
		{
			this.id = id;
		}
		
		/**
		 * A valid file identifier of the voice message.
		 *
		 * @param voiceFileId file id
		 */
		public ResultCachedVoiceNoTitle withVoiceFileId(String voiceFileId)
		{
			return new ResultCachedVoiceNoTitle(id, voiceFileId);
		}
	}
	
	public static class ResultCachedVoiceNoTitle
	{
		private String id;
		private String voiceFileId;
		
		public ResultCachedVoiceNoTitle(String id, String voiceFileId)
		{
			this.id = id;
			this.voiceFileId = voiceFileId;
		}
		
		/**
		 * Sets title of the voice message.
		 *
		 * @param title the title
		 */
		public ResultCachedVoiceReady withTitle(String title)
		{
			return new ResultCachedVoiceReady(id, voiceFileId, title);
		}
	}
	
	public static class ResultCachedVoiceReady
	{
		private String id;
		private String voiceFileId;
		private String title;
		private InlineKeyboardMarkup inlineKeyboard;
		private InputMessageContent messageContent;
		
		public ResultCachedVoiceReady(String id, String voiceFileId, String title)
		{
			this.id = id;
			this.voiceFileId = voiceFileId;
			this.title = title;
		}
		
		/**
		 * Attaches an inline keyboard to the sending message.
		 *
		 * @param inlineKeyboard the inline keyboard
		 */
		public ResultCachedVoiceReady attachInlineKeyboard(InlineKeyboardMarkup inlineKeyboard)
		{
			this.inlineKeyboard = inlineKeyboard;
			return this;
		}
		
		/**
		 * Content of the message to be sent instead of the voice message.
		 *
		 * @param messageContent the message content
		 */
		public ResultCachedVoiceReady withMessageContent(InputMessageContent messageContent)
		{
			this.messageContent = messageContent;
			return this;
		}
		
		/**
		 * Builds the <code>InlineQueryResult</code> object.
		 */
		public InlineQueryResult buildResult()
		{
			return new InlineQueryResultCachedVoice(id, inlineKeyboard, voiceFileId, title, messageContent);
		}
	}
	
	public static class ResultCachedAudioNoIdNoAudioFileId
	{
		public ResultCachedAudioNoIdNoAudioFileId(){}
		
		/**
		 * Sets unique identifier for this result, 1-64 bytes.
		 *
		 * @param id the unique identifier
		 */
		public ResultCachedAudioNoAudioFileId withId(String id)
		{
			return new ResultCachedAudioNoAudioFileId(id);
		}
	}
	
	public static class ResultCachedAudioNoAudioFileId
	{
		private String id;
		
		public ResultCachedAudioNoAudioFileId(String id)
		{
			this.id = id;
		}
		
		/**
		 * A valid file identifier of the audio file.
		 *
		 * @param audioFileId file id
		 */
		public ResultCachedAudioReady withAudioFileId(String audioFileId)
		{
			return new ResultCachedAudioReady(id, audioFileId);
		}
	}
	
	public static class ResultCachedAudioReady
	{
		private String id;
		private String audioFileId;
		private InlineKeyboardMarkup inlineKeyboard;
		private InputMessageContent messageContent;
		
		public ResultCachedAudioReady(String id, String audioFileId)
		{
			this.id = id;
			this.audioFileId = audioFileId;
		}
		
		/**
		 * Attaches an inline keyboard to the sending message.
		 *
		 * @param inlineKeyboard the inline keyboard
		 */
		public ResultCachedAudioReady attachInlineKeyboard(InlineKeyboardMarkup inlineKeyboard)
		{
			this.inlineKeyboard = inlineKeyboard;
			return this;
		}
		
		/**
		 * Content of the message to be sent instead of the audio.
		 *
		 * @param messageContent the message content
		 */
		public ResultCachedAudioReady withMessageContent(InputMessageContent messageContent)
		{
			this.messageContent = messageContent;
			return this;
		}
		
		/**
		 * Builds the <code>InlineQueryResult</code> object.
		 */
		public InlineQueryResult buildResult()
		{
			return new InlineQueryResultCachedAudio(id, inlineKeyboard, audioFileId, messageContent);
		}
	}
}