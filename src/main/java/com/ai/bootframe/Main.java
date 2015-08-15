package com.ai.bootframe;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	private static final String[] DUBBO_PROVIDER_FILE = new String[] { "dubbo-provider.xml" };
	private static boolean running = true;

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(DUBBO_PROVIDER_FILE);
		context.start();
		InitParam it = (InitParam)context.getBean("initParam");
		System.out.println(it.getMy());
		synchronized (Main.class) {
			while (running)
				try {
					Main.class.wait();
				} catch (Throwable e) {
					e.printStackTrace();
				}
		}

	}
}
