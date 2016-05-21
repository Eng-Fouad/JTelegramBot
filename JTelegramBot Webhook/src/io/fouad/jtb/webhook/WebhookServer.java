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

package io.fouad.jtb.webhook;

import com.fasterxml.jackson.databind.JsonMappingException;
import io.fouad.jtb.core.JTelegramBot;
import io.fouad.jtb.core.TelegramBotConfig;
import io.fouad.jtb.core.beans.TelegramResult;
import io.fouad.jtb.core.beans.Update;
import io.fouad.jtb.core.exceptions.NegativeResponseException;
import io.fouad.jtb.core.utils.JsonUtils;
import io.fouad.jtb.webhook.enums.TelegramPort;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpHeaders.Values;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.SslProvider;
import io.netty.handler.ssl.util.SelfSignedCertificate;
import io.netty.util.CharsetUtil;

import javax.net.ssl.SSLException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.cert.CertificateException;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_LENGTH;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpResponseStatus.CONTINUE;
import static io.netty.handler.codec.http.HttpResponseStatus.FORBIDDEN;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * This is a local server that can be used as a webhook server
 * to receive incoming updates from Telegram server.
 */
public class WebhookServer
{
	private JTelegramBot bot;
	private String hostname;
	private TelegramPort port;
	private String path;
	
	private File certificate;
	private SslContext sslCtx;
	private EventLoopGroup bossGroup;
	private EventLoopGroup workerGroup;
	
	public WebhookServer(JTelegramBot bot, String hostname, TelegramPort port, String path)
	{
		this.bot = bot;
		this.hostname = hostname;
		this.port = port;
		this.path = path != null && path.startsWith("/") ? path : "/" + path;
	}
	
	public JTelegramBot getBot(){return bot;}
	public void setBot(JTelegramBot bot){this.bot = bot;}
	
	public String getHostname(){return hostname;}
	public void setHostname(String hostname){this.hostname = hostname;}
	
	public TelegramPort getPort(){return port;}
	public void setPort(TelegramPort port){this.port = port;}
	
	public String getPath(){return path;}
	public void setPath(String path){this.path = path;}
	
	/**
	 * Generates a self-signed SSL certificate to be used by Telegram server
	 * to connect to your server over secure HTTPS connection.
	 * 
	 * @throws CertificateException this exception indicates one of a variety of certificate problems
	 * @throws SSLException this exception occurs if building the certificate fails
	 */
	public void useGeneratedSelfSignedSslCertificate() throws CertificateException, SSLException
	{
		SelfSignedCertificate ssc = new SelfSignedCertificate(hostname);
		certificate = ssc.certificate();
		sslCtx = SslContextBuilder.forServer(certificate, ssc.privateKey()).build();
	}
	
	/**
	 * Register a webhook to receive new updates from Telegram server.
	 * 
	 * @return response from Telegram server to the webhook request
	 *
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	public TelegramResult<String> registerWebhook() throws IOException, NegativeResponseException
	{
		if(certificate == null) throw new IllegalStateException("SSL Certificate is not setup.");
		
		String listenUrl = "https://" + hostname + ":" + port.getPortNumber() + path;
		TelegramResult<String> result = bot.registerWebhook(listenUrl, certificate);
		if("true".equals(result.getResult())) System.out.println(result.getDescription());
		
		return result;
	}
	
	/**
	 * Unregister the webhook if exists.
	 * 
	 * @return response from Telegram server to the webhook removing request
	 *
	 * @throws IOException if an I/O exception occurs
	 * @throws NegativeResponseException if 4xx-5xx HTTP response is received from Telegram server
	 */
	public TelegramResult<String> unregisterWebhook() throws IOException, NegativeResponseException
	{
		return bot.unregisterWebhook();
	}
	
	/**
	 * Starts receiving requests from Telegram server (WEBHOOK mode). This is a blocking method.
	 */
	public void start() throws InterruptedException
	{
		bossGroup = new NioEventLoopGroup();
		workerGroup = new NioEventLoopGroup();
		
		try
		{
			ServerBootstrap server = new ServerBootstrap();
			
			server.group(bossGroup, workerGroup)
			      .channel(NioServerSocketChannel.class)
			      .childHandler(new ServerInitializer(sslCtx, path))
			      .option(ChannelOption.SO_BACKLOG, 128)
			      .childOption(ChannelOption.SO_KEEPALIVE, true);
			
			// Bind and start to accept incoming connections.
			ChannelFuture f = server.bind(port.getPortNumber()).sync();
			
			// Wait until the server socket is closed.
			f.channel().closeFuture().sync();
		}
		finally
		{
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}
	
	/**
	 * Starts receiving requests from Telegram server (WEBHOOK mode). This method returns immediately.
	 */
	public void startAsync()
	{
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					start();
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	/**
	 * Stops the local server.
	 */
	public void stop()
	{
		workerGroup.shutdownGracefully();
		bossGroup.shutdownGracefully();
	}
	
	private class ServerHandler extends SimpleChannelInboundHandler<FullHttpRequest>
	{
		private final String path;
		
		public ServerHandler(String path)
		{
			this.path = path;
		}
		
		@Override
		public void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws IOException
		{
			if(msg.getUri().equals(path)) // to make sure it's coming from Telegram server
			{
				String requestAsJson = msg.content().toString(CharsetUtil.UTF_8);
				
				try
				{
					Update update = JsonUtils.toJavaObject(requestAsJson, Update.class);
					bot.onUpdateReceived(update);
					
					FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer("{}".getBytes("UTF-8")));
					response.headers().set(CONTENT_TYPE, "application/json");
					response.headers().set(CONTENT_LENGTH, response.content().readableBytes());
					
					ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
				}
				catch(JsonMappingException e) // most likely invalid (non-Telegram) request
				{
					ctx.close();
					e.printStackTrace();
				}
			}
			else
			{
				FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, FORBIDDEN);
				ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
			}
		}
	}
	
	private class ServerInitializer extends ChannelInitializer<SocketChannel>
	{
		private final SslContext sslCtx;
		private final String path;
		
		public ServerInitializer(SslContext sslCtx, String path)
		{
			this.sslCtx = sslCtx;
			this.path = path;
		}
		
		@Override
		protected void initChannel(SocketChannel ch) throws Exception
		{
			ChannelPipeline pipeline = ch.pipeline();
			
			if(sslCtx != null) pipeline.addLast(sslCtx.newHandler(ch.alloc()));
			
			pipeline.addLast(new HttpServerCodec());
			pipeline.addLast(new HttpObjectAggregator(65536));
			pipeline.addLast(new ServerHandler(path));
		}
	}
}