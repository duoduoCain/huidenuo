package com.hdn.zp.model;

import com.google.gson.annotations.SerializedName;

/**
 * 微信接口，通用返回参数
 * @author  Jack
 * @version   1.0
 */
public class WechatCommonResultDto {

	public boolean isSuccess(){
		return 0 == this.errcode;
	}
	
	@SerializedName("errcode")
	private int errcode;
	
	@SerializedName("errmsg")
	private String errmsg;
	
	public int getErrcode() {
		return errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	
	public WechatCommonResultDto setErrcode(int errcode) {
		this.errcode = errcode;
		return this;
	}
	public WechatCommonResultDto setErrmsg(String errmsg) {
		this.errmsg = errmsg;
		return this;
	}
	
	@Override
	public String toString() {
		return "ResultCommonDto [errcode=" + errcode + ", errmsg=" + errmsg + "]";
	}
	
	
}
