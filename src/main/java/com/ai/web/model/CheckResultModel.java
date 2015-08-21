package com.ai.web.model;

public class CheckResultModel {
	/**
	 * 校验结果
	 * result:
	 * 		0:成功
	 * 		1:失败
	 * reason:
	 * 		错误原因
	 * 您的证件号码已经登记5张通讯卡，不能再行登记
	 * 您的实名信息未能通过校验，请核实您的姓名、证件号及有效期
	 * 您的车架号vin验证不通过，请核实您的车架号码
	 */
	private String result;
	private String reason;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
