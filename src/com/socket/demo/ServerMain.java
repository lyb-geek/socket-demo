package com.socket.demo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
	public static void main(String[] args) {
		int port = 2030;
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port);
			ServerHandlerPool serverHandlerPool = new ServerHandlerPool(50, 1000);
			System.out.println("server start...");
			while (true) {
				Socket socket = serverSocket.accept();
				serverHandlerPool.sumbit(new ServerHandler(socket));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
