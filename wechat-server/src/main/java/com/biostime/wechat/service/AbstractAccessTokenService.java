package com.biostime.wechat.service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.biostime.wechat.bean.AccessTokenResponse;
import com.biostime.wechat.constant.WechatUrl;

public abstract class AbstractAccessTokenService {
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Lock lock = new ReentrantLock();
	
	public AccessTokenResponse get(boolean refresh) {
		lock.lock();
		try {
			AccessTokenResponse result = null;
			if (refresh || (result = getFromCache()) == null) {
				logger.info("refresh:{}, result:{}", refresh, result);
				AccessTokenResponse token = getFromWechat();
				logger.info("getFromWechat:{}", token);
				if (token == null)
					return null;
				logger.info("putToCache:{}", token);
				putToCache(token);
				result = token;
			}
			return result;
		} finally {
			lock.unlock();
		}
	}
	
	protected AccessTokenResponse getFromWechat() {
		AccessTokenResponse response = this.restTemplate.getForObject(WechatUrl.ACCESS_TOKEN_URL, AccessTokenResponse.class, getAppid(), getAppsecret());
		logger.info("getFromWechat, response:{}", response);
		if (response.success())
			return response;
		return null;
	}

	protected abstract AccessTokenResponse getFromCache();
	protected abstract void putToCache(AccessTokenResponse accessToken);
	protected abstract String getAppid();
	protected abstract String getAppsecret();
}
