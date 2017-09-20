package com.biostime.wechat.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.biostime.wechat.constant.WechatUrl;
import com.biostime.wechat.util.JsonUtils;

@Service
public class CustomService {
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private AccessTokenService accessTokenService;
	
	public void sendTextMessage(String openId, String content) {
		Map<String, Object> object = new HashMap<String, Object>(3);
		object.put("touser", openId);
		object.put("msgtype", "text");
		Map<String, String> txt = new HashMap<String, String>(1);
		txt.put("content", content);
		object.put("text", txt);
		String result = this.restTemplate.postForObject(WechatUrl.CUSTOM_SEND_URL, object, String.class, this.accessTokenService.get(false).getAccess_token());
		logger.info("sendTextMessage:{}, result:{}", JsonUtils.toJson(object), result);
		
	}
}
