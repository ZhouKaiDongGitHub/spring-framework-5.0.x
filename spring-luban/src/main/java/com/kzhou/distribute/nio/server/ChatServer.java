package com.kzhou.distribute.nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.*;

public class ChatServer {
	private static final String ip = "localhost";
	private static final int port = 8888;
	private static Map<String,SocketChannel> socketChannelMaps = new HashMap<>();
	private static Selector selector;
	//用于接收数据的缓冲区
	private static ByteBuffer readBuffer = ByteBuffer.allocate(1024);
	//用于发送数据的缓冲区
	private static ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
	//用于字符集解码
	private static Charset charset = Charset.forName("UTF-8");

	public static void main(String[] args) {
		//初始化服务器端
		try {
			init();
			listen();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void init() throws IOException {
		//创建一个ServerSocketChannel
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(false);
		ServerSocket serverSocket = serverSocketChannel.socket();
		//绑定端口
		serverSocket.bind(new InetSocketAddress(8888));
		//创建一个Selector
		selector = Selector.open();
		//将serverSocketChannel注册到selector
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

	}

	public static void listen() throws IOException {
		while (true){
			//每select()一次，都会获取到注册到selector上的SocketChannel待续结果
			selector.select();
			//取得所有结果，第一次的只有accept的（可能），第二次的有accept和read的（可能）
			Set<SelectionKey> selectionKeySet = selector.selectedKeys();
			selectionKeySet.forEach(selectionKey ->{
				if(selectionKey.isAcceptable()){
					//处理请求连接的客户端
					ServerSocketChannel serverSocketChannel = (ServerSocketChannel)selectionKey.channel();
					try {
						SocketChannel socketChannel = serverSocketChannel.accept();
						socketChannel.configureBlocking(false);
						socketChannel.register(selector,SelectionKey.OP_READ);
						socketChannelMaps.put(getClientName(socketChannel),socketChannel);
						System.out.println("有客户端请求连入。。。");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(selectionKey.isReadable()){
					//处理可读的客户端信息
					SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
					readBuffer.clear();
					try {
						int bytes = socketChannel.read(readBuffer);
						if(bytes>0){
							readBuffer.flip();
							//解码缓冲区数据
							String receiveText = String.valueOf(charset.decode(readBuffer));
							System.out.println(socketChannel.toString() + "发出消息:" + receiveText);
							dispatch(socketChannel, receiveText);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			selectionKeySet.clear();
		}
	}

	public static void dispatch(SocketChannel socketChannel,String text) throws IOException {
		if(!socketChannelMaps.isEmpty()){
			for (Map.Entry<String, SocketChannel> socketChannelEntry:socketChannelMaps.entrySet()
				 ) {
				SocketChannel temp = socketChannelEntry.getValue();
				if(!socketChannel.equals(temp)){
					writeBuffer.clear();
					writeBuffer.put(charset.encode(getClientName(socketChannel)+":" +text));
					writeBuffer.flip();
					temp.write(writeBuffer);
				}
			}
		}
	}

	public static String getClientName(SocketChannel socketChannel){
		Socket socket = socketChannel.socket();
		return "[" + socket.getInetAddress().toString().substring(1) + ":" + Integer.toHexString(socketChannel.hashCode()) + "]";
	}
}
