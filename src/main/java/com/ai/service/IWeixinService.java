package com.ai.service;

import com.ai.web.model.CheckResultModel;
import com.ai.web.model.IdCardModel;

public interface IWeixinService {
	/**
	 * 创建订单
	 * @return
	 * @throws Exception
	 */
	public String insertOrder() throws Exception;
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getOrderByOrderId() throws Exception;
	/**
	 * 更新订单
	 * @return
	 * @throws Exception
	 */
	public String updateOrder() throws Exception;
	
	/**
	 * 校验车架号
	 * @param vin
	 * @return
	 * @throws Exception
	 */
	public CheckResultModel getVin(String vin) throws  Exception;
	
	/**
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public CheckResultModel getIdCard(IdCardModel model) throws Exception;
	
}
