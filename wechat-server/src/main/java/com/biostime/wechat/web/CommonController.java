package com.biostime.wechat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biostime.wechat.bean.AccessTokenResponse;
import com.biostime.wechat.service.AccessTokenService;

@RestController
@RequestMapping("/common")
public class CommonController {

	@Autowired
	private AccessTokenService accessTokenService;
	
	@RequestMapping(value="/accesstoken", method=RequestMethod.GET)
	public AccessTokenResponse accesstoken(@RequestParam(required = false) Integer refresh) {
		return this.accessTokenService.get(refresh != null && refresh == 1);
	}
}
