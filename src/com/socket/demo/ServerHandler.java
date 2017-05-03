package com.socket.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerHandler implements Runnable {

	private Socket socket;

	private BufferedReader reader;

	private PrintWriter writer;

	public ServerHandler(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		handler();
	}

	private void handler() {
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);
			while (true) {
				String response = reader.readLine();
				if (response == null)
					break;
				System.out.println("接收到客户端的消息为：" + response);
				writer.println("服务端已经接受到客户端消息...");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (writer != null) {
				writer.close();
			}
			try {
				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
