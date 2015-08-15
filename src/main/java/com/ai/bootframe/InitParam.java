package com.ai.bootframe;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class InitParam {
	Logger logger = Logger.getLogger(InitParam.class);  

	/**
	 * 为每一个配置新增一个变量，启动的时候会加载进来，使用的时候只需要注入InitParam
	 */
	private String my;
	@PostConstruct
	public void init() throws Exception{
		/**
		 * 加载数据库配置
		 */
		setMy("123");;
		logger.debug("myinit");
	}
	public String getMy() {
		return my;
	}
	public void setMy(String my) {
		this.my = my;
	}
	
	
}
