package com.ai.util;

import java.util.Properties;

public class SystemUtil {
	public static String getSystem(){
		Properties properties = System.getProperties();
		return properties.getProperty("os.name");
	}
	public static void main(String[] args) {
		System.out.println(getSystem());
	}
}
