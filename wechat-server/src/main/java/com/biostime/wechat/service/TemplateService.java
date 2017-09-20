package com.biostime.wechat.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.biostime.wechat.bean.WechatResponse;
import com.biostime.wechat.constant.WechatUrl;

@Service
public class TemplateService {
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private AccessTokenService accessTokenService;
	
	public static class ValueAndColor {
		private String value;
		private String color = "";
		public ValueAndColor(String value) {
			super();
			this.value = value;
		}
		public ValueAndColor(String value, String color) {
			super();
			this.value = value;
			this.color = color;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
	}
	
	public WechatResponse sendTemplateMessage(String openId, String templateId, String url, ValueAndColor first, ValueAndColor remark, ValueAndColor... keywords) {
		Map<String, Object> object = new LinkedHashMap<String, Object>(3);
		object.put("touser", openId);
		object.put("template_id", templateId);
		object.put("url", url);
		Map<String, ValueAndColor> data = new HashMap<String, TemplateService.ValueAndColor>(keywords.length + 2);
		if (first != null && StringUtils.hasText(first.getValue()))
			data.put("first", first);
		if (remark != null && StringUtils.hasText(remark.getValue()))
			data.put("remark", remark);
		for (int i = 0; i < keywords.length; i++) {
			data.put("keyword" + (i + 1), keywords[i]);
		}
		object.put("data", data);
		return this.restTemplate.postForObject(WechatUrl.TEMPLATE_SEND_URL, object, WechatResponse.class, this.accessTokenService.get(false).getAccess_token());
	}

}
