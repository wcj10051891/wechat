package com.biostime.wechat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.biostime.wechat.bean.Menu;
import com.biostime.wechat.bean.WechatResponse;
import com.biostime.wechat.constant.WechatUrl;

@Service
public class MenuService {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private AccessTokenService accessTokenService;
	
	public WechatResponse create(Menu menu) {
		return this.restTemplate.postForObject(WechatUrl.MENU_CREATE_URL, menu, WechatResponse.class, this.accessTokenService.get(false).getAccess_token());
	}
}
