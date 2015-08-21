package com.ai.service.impl;

import org.springframework.stereotype.Service;

import com.ai.service.IWeixinService;
import com.ai.web.model.CheckResultModel;
import com.ai.web.model.IdCardModel;

@Service("weixinService")
public class WeixinServiceImpl implements IWeixinService {

	@Override
	public String insertOrder() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOrderByOrderId() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateOrder() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CheckResultModel getVin(String vin) throws Exception {
		// TODO Auto-generated method stub
		CheckResultModel result = new CheckResultModel();
		/**
		 * 此处增加校验逻辑，返回校验结果及原因
		 */
		return result;
	}

	@Override
	public CheckResultModel getIdCard(IdCardModel model) throws Exception {
		// TODO Auto-generated method stub
		CheckResultModel result = new CheckResultModel();
		/**
		 * 此处增加校验逻辑，返回校验结果及原因
		 */
		return result;
	}

}
