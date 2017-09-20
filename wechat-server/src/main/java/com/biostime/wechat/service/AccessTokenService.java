package com.biostime.wechat.service;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.biostime.wechat.bean.AccessTokenResponse;

@Service
public class AccessTokenService extends AbstractAccessTokenService {
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@Value("${wechat.appid}")
	private String appid;
	@Value("${wechat.appsecret}")
	private String appsecret;
	
	private AccessTokenResponse token;
	private long expireTime;
	
	@Override
	protected AccessTokenResponse getFromCache() {
		logger.info("getFromCache, token:{}, expireTime:{}", token, expireTime);
		if (token != null) {
			if (System.currentTimeMillis() >= expireTime) {
				logger.info("token:{}, expired, clear", token);
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
		logger.info("putToCache, token:{}, expireTime:{}", token, expireTime);
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
