package com.socket.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ServerHandlerPool {

	private ExecutorService service;

	public ServerHandlerPool(int maxPoolSize, int maxQueueSize) {
		this.service = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), maxPoolSize, 120,
				TimeUnit.SECONDS, new ArrayBlockingQueue<>(maxQueueSize));
	}

	public void sumbit(Runnable runnable) {
		service.execute(runnable);
	}

}
