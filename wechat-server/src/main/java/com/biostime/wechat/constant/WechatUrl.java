package com.biostime.wechat.constant;

public interface WechatUrl {
	String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={appid}&secret={secret}";
}
