package com.socket.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientMain {

	public static void main(String[] args) {
		String url = "127.0.0.1";
		int port = 2030;
		Socket socket = null;
		BufferedReader reader = null;

		PrintWriter writer = null;
		try {

			socket = new Socket(url, port);
			System.out.println("client start ....");
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);

			writer.println("客户端已经接收到服务端消息...");
			String response = reader.readLine();
			System.out.println("接收到服务端的消息为：" + response);

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
