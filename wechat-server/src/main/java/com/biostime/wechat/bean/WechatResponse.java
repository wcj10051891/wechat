package com.biostime.wechat.bean;

import org.springframework.util.StringUtils;

import com.biostime.wechat.util.JsonUtils;

public class WechatResponse {
	private String errorcode;
	private String errmsg;
	
	public String getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public boolean success() {
		return !StringUtils.hasText(errorcode) || "0".equals(errorcode);
	}
	
	@Override
	public String toString() {
		return JsonUtils.toJson(this);
	}
}
