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

package io.fouad.jtb.core.utils;

import io.fouad.jtb.core.exceptions.NegativeResponseException;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;

/**
 * Utility class to handle HTTP client job. It sends HTTP POST requests and downloads a file from the internet as well.
 */
public class HttpClient
{
	/**
	 * Represents a pair of key/value to be sent as normal parameter within HTTP POST body. 
	 */
	public static class NameValueParameter<K, V>
	{
		private final K name;
		private final V value;
		
		public NameValueParameter(K name, V value)
		{
			this.name = name;
			this.value = value;
		}
		
		public K getName(){return name;}
		public V getValue(){return value;}
		
		@Override
		public boolean equals(Object o)
		{
			if(this == o) return true;
			if(o == null || getClass() != o.getClass()) return false;
			
			NameValueParameter<?, ?> that = (NameValueParameter<?, ?>) o;
			
			if(name != null ? !name.equals(that.name) : that.name != null) return false;
			return value != null ? value.equals(that.value) : that.value == null;
			
		}
		
		@Override
		public int hashCode()
		{
			int result = name != null ? name.hashCode() : 0;
			result = 31 * result + (value != null ? value.hashCode() : 0);
			return result;
		}
		
		@Override
		public String toString()
		{
			return "NameValueParameter{" +
					"name=" + name +
					", value=" + value +
					'}';
		}
	}
	
	/**
	 * Represents a file field to be sent within HTTP POST (multipart/form-data content type). 
	 */
	public static class FileField
	{
		private final String fileName;
		private final InputStream inputStream;
		
		public FileField(String fileName, InputStream inputStream)
		{
			this.fileName = fileName;
			this.inputStream = inputStream;
		}
		
		public FileField(File file) throws FileNotFoundException
		{
			this.fileName = file.getName();
			this.inputStream = new FileInputStream(file);
		}
		
		public String getFileName(){return fileName;}
		public InputStream getInputStream(){return inputStream;}
		
		@Override
		public boolean equals(Object o)
		{
			if(this == o) return true;
			if(o == null || getClass() != o.getClass()) return false;
			
			FileField fileField = (FileField) o;
			
			if(fileName != null ? !fileName.equals(fileField.fileName) : fileField.fileName != null) return false;
			return inputStream != null ? inputStream.equals(fileField.inputStream) : fileField.inputStream == null;
			
		}
		
		@Override
		public int hashCode()
		{
			int result = fileName != null ? fileName.hashCode() : 0;
			result = 31 * result + (inputStream != null ? inputStream.hashCode() : 0);
			return result;
		}
		
		@Override
		public String toString()
		{
			return "FileField{" +
					"fileName='" + fileName + '\'' +
					", inputStream=" + inputStream +
					'}';
		}
	}
	
	/**
	 * Represents HTTP responseBody (HTTP code + responseBody body). 
	 */
	public static class HttpResponse
	{
		private final int httpStatusCode;
		private final String responseBody;
		
		public HttpResponse(int httpStatusCode, String responseBody)
		{
			this.httpStatusCode = httpStatusCode;
			this.responseBody = responseBody;
		}
		
		public int getHttpStatusCode(){return httpStatusCode;}
		public String getResponseBody(){return responseBody;}
		
		@Override
		public boolean equals(Object o)
		{
			if(this == o) return true;
			if(!(o instanceof HttpResponse)) return false;
			
			HttpResponse that = (HttpResponse) o;
			
			if(httpStatusCode != that.httpStatusCode) return false;
			return responseBody != null ? responseBody.equals(that.responseBody) : that.responseBody == null;
			
		}
		
		@Override
		public int hashCode()
		{
			int result = httpStatusCode;
			result = 31 * result + (responseBody != null ? responseBody.hashCode() : 0);
			return result;
		}
		
		@Override
		public String toString()
		{
			return "HttpResponse{" +
					"httpStatusCode=" + httpStatusCode +
					", responseBody='" + responseBody + '\'' +
					'}';
		}
	}
	
	/**
	 * Send HTTP POST request using multipart/form-data content type.
	 * 
	 * @param requestUrl url to send the request to
	 * @param formFields pairs of Key/Value HTTP POST parameters
	 * @param files list of files
	 *    
	 * @return responseBody for the request
	 * 
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP responseBody is received from Telegram server
	 */
	public static HttpResponse sendHttpPost(String requestUrl, List<NameValueParameter<String, String>> formFields, List<NameValueParameter<String, FileField>> files)
			throws IOException, NegativeResponseException
	{
		String boundary = String.valueOf(System.currentTimeMillis());
		
		URL url = new URL(requestUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);
		connection.setUseCaches(false);
		connection.setChunkedStreamingMode(1024);
		connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
		connection.setRequestProperty("User-Agent", "Java Agent");
		OutputStream outputStream = connection.getOutputStream();
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
		
		writer.append("--")
		      .append(boundary)
		      .append("\r\n");
		
		for(NameValueParameter<String, String> parameter : formFields)
		{
			writer.append("Content-Disposition: form-data; name=\"")
			      .append(parameter.getName())
			      .append("\"\r\nContent-Type: text/plain; charset=UTF-8\r\n\r\n")
			      .append(parameter.getValue())
			      .append("\r\n");
		}
		
		for(NameValueParameter<String, FileField> parameter : files)
		{
			FileField fileField = parameter.getValue();
			String fileName = fileField.getFileName();
			String contentType = URLConnection.guessContentTypeFromName(fileName);
			if(contentType == null) contentType = "";
			
			writer.append("--")
			      .append(boundary)
			      .append("\r\nContent-Disposition: form-data; name=\"")
			      .append(parameter.getName())
			      .append("\"; filename=\"")
			      .append(fileName)
			      .append("\"\r\nContent-Type: ")
			      .append(contentType)
			      .append("\r\nContent-Transfer-Encoding: binary\r\n\r\n")
				  .flush();
			
			BufferedInputStream bis = new BufferedInputStream(fileField.getInputStream());
			BufferedOutputStream bos = new BufferedOutputStream(outputStream);
			
			
			int theByte;
			while((theByte = bis.read()) != -1) bos.write(theByte);
			bos.flush();
			bis.close();
			
			writer.append("\r\n");
		}
		
		writer.append("\r\n--")
		      .append(boundary)
		      .append("--\r\n")
		      .close();
		
		return readResponse(connection);
	}
	
	/**
	 * Send HTTP POST request using application/x-www-form-urlencoded content type.
	 * 
	 * @param requestUrl url to send the request to
	 * @param formFields pairs of Key/Value HTTP POST parameters
	 * 
	 * @return responseBody for the request
	 * 
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP responseBody is received from Telegram server
	 */
	public static HttpResponse sendHttpPost(String requestUrl, List<NameValueParameter<String, String>> formFields)
			throws IOException, NegativeResponseException
	{
		URL url = new URL(requestUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);
		connection.setUseCaches(false);
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		connection.setRequestProperty("User-Agent", "Java Agent");
		OutputStream outputStream = connection.getOutputStream();
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
		
		boolean prefixAnd = false;
		for(NameValueParameter<String, String> parameter : formFields)
		{
			if(prefixAnd) writer.append("&");
			else prefixAnd = true;
			
			writer.append(URLEncoder.encode(parameter.getName(), "UTF-8"))
			      .append("=")
			      .append(URLEncoder.encode(parameter.getValue(), "UTF-8"));
		}
		
		writer.close();
		
		return readResponse(connection);
	}
	
	/**
	 * Read HTTP responseBody.
	 * 
	 * @param connection the HTTP connection which we read the responseBody from
	 * 
	 * @return the responseBody
	 * 
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP responseBody is received from Telegram server
	 */
	private static HttpResponse readResponse(HttpURLConnection connection) throws IOException, NegativeResponseException
	{
		int status = connection.getResponseCode();
		if(status >= HttpURLConnection.HTTP_OK && status < HttpURLConnection.HTTP_BAD_REQUEST)
		{
			StringBuilder sb = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			String line;
			while((line = reader.readLine()) != null) sb.append(line).append("\r\n");
			
			reader.close();
			connection.disconnect();
			
			return new HttpResponse(status, sb.toString());
		}
		else
		{
			StringBuilder sb = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
			
			String line;
			while((line = reader.readLine()) != null) sb.append(line).append("\r\n");
			
			reader.close();
			connection.disconnect();
			
			String response = sb.toString();
			
			throw new NegativeResponseException(status, response);
		}
	}
	
	/**
	 * Download a file from the internet.
	 * 
	 * @param fileUrl the url where we download the file from
	 * @param saveToOutputStream the output stream where the file will be saved/streamed
	 * 
	 * @throws IOException if an I/O exception occurs
	 */
	public static void downloadFile(String fileUrl, OutputStream saveToOutputStream) throws IOException
	{
		BufferedInputStream bis = new BufferedInputStream(new URL(fileUrl).openStream());
		BufferedOutputStream bos = new BufferedOutputStream(saveToOutputStream);
		
		int theByte;
		while((theByte = bis.read()) != -1) bos.write(theByte);
		bis.close();
		bos.close();
	}
}