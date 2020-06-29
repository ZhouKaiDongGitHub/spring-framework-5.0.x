package com.kzhou.distribute.nio.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.Set;

public class ChatClient1 {

	public static final String host = "localhost";
	public static final int port = 8888;

	//用于接收数据的缓冲区
	private static ByteBuffer readBuffer = ByteBuffer.allocate(1024);
	//用于发送数据的缓冲区
	private static ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
	//用于字符集解码
	private static Charset charset = Charset.forName("UTF-8");
	public static Selector selector;

	public static void main(String[] args) {
		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void init() throws IOException {
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.configureBlocking(false);
		selector = Selector.open();
		socketChannel.register(selector, SelectionKey.OP_CONNECT);
		socketChannel.connect(new InetSocketAddress(host,port));
		while (true){
			selector.select();
			Set<SelectionKey> selectionKeys = selector.selectedKeys();
			selectionKeys.forEach(selectionKey -> {
				if(selectionKey.isConnectable()){
					//可连接状态
					SocketChannel channel = (SocketChannel) selectionKey.channel();
					if(channel.isConnectionPending()){
						try {
							channel.finishConnect();
							//启动线程侦听客户端的输入
							new Thread(new Runnable() {
								@Override
								public void run() {
									while (true){
										writeBuffer.clear();
										Scanner scanner = new Scanner(System.in);
										String sendText = scanner.next();
										writeBuffer.put(charset.encode(sendText));
										writeBuffer.flip();
										try {
											channel.write(writeBuffer);
										}catch (Exception e){
											System.out.println(("输入消息异常..."));
										}
									}
								}
							}).start();

							channel.register(selector,SelectionKey.OP_READ);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				if(selectionKey.isReadable()){
					SocketChannel channel = (SocketChannel) selectionKey.channel();
					readBuffer.clear();
					try {
						int bytes = channel.read(readBuffer);
						if(bytes>0){
							readBuffer.flip();
							String receiveText = new String(readBuffer.array(),0,bytes);
							System.out.println(receiveText);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			selectionKeys.clear();
		}
	}
}
