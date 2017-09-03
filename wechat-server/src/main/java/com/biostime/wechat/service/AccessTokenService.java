package com.biostime.wechat.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.biostime.wechat.bean.AccessTokenResponse;

@Service
public class AccessTokenService extends AbstractAccessTokenService {
	
	@Value("${wechat.appid}")
	private String appid;
	@Value("${wechat.appsecret}")
	private String appsecret;
	
	private AccessTokenResponse token;
	private long expireTime;
	
	@Override
	protected AccessTokenResponse getFromCache() {
		if (token != null) {
			if (System.currentTimeMillis() >= expireTime) {
				this.token = null;
				this.expireTime = 0;
			}
		}
		return token;
	}
	@Override
	protected void putToCache(AccessTokenResponse accessToken) {
		this.token = accessToken;
		this.expireTime = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(Long.valueOf(accessToken.getExpires_in()));
	}
	
	@Override
	protected String getAppid() {
		return this.appid;
	}
	@Override
	protected String getAppsecret() {
		return this.appsecret;
	}
}
