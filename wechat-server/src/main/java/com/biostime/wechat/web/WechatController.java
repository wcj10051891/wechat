package com.biostime.wechat.web;

import java.io.StringReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXB;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.biostime.wechat.bean.AuthorizeAccessTokenResponse;
import com.biostime.wechat.bean.AuthorizeUserInfo;
import com.biostime.wechat.bean.WxValidBean;
import com.biostime.wechat.constant.WechatUrl;
import com.biostime.wechat.protocol.handler.MsgHandler;
import com.biostime.wechat.protocol.up.UpMessage;
import com.biostime.wechat.util.JsonUtils;

@RestController
@RequestMapping("/wechat")
public class WechatController {
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@Value("${wechat.valid.token}")
	private String validToken;
	
	@Value("${wechat.appid}")
	private String appid;
	@Value("${wechat.appsecret}")
	private String appsecret;
	
	@Autowired
	private ApplicationContext ctx;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String get(WxValidBean bean) {
		logger.info("received param:{}", JsonUtils.toJson(bean));
		if (isValueRequest(bean.getSignature(), bean.getTimestamp(), bean.getNonce()))
			return bean.getEchostr();
		return "";
	}
	
	private boolean isValueRequest(String signature, String timestamp, String nonce) {
		List<String> params = Arrays.asList(validToken, timestamp, nonce);
		Collections.sort(params);
		String join = StringUtils.join(params, "");
		join = DigestUtils.sha1Hex(join);
		return join.equals(signature);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST, produces=MediaType.TEXT_XML_VALUE)
	public String post(String signature, String timestamp, String nonce, @RequestBody String req) {
		logger.info("receive signature:{}, timestamp:{}, nonce:{}, req:{}", signature, timestamp, nonce, req);
		if (!isValueRequest(signature, timestamp, nonce))
			return "illegal request";
		UpMessage message = JAXB.unmarshal(new StringReader(req), UpMessage.class);
		logger.info("unmarshal message:{}", message);
		for (MsgHandler handler : ctx.getBeansOfType(MsgHandler.class).values()) {
			if (handler.canHandle(message))
				return handler.handle(message);
		};
		return "";
	}

	@RequestMapping(value="/authorize", method=RequestMethod.GET)
	public String authorize(String code, String state, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		logger.info("receive authorize code:{}, state:{}", code, state);
		String result = this.restTemplate.getForObject(WechatUrl.AUTHORIZE_ACCESS_TOKEN_URL, String.class, this.appid, this.appsecret, code);
		AuthorizeAccessTokenResponse token = JsonUtils.fromJson(result, AuthorizeAccessTokenResponse.class);
		logger.info("result:{}", token);
		if (token.success()) {
			String userinfoJson = this.restTemplate.getForObject(WechatUrl.AUTHORIZE_USER_INFO_URL, String.class, token.getAccess_token(), token.getOpenid());
			AuthorizeUserInfo userinfo = JsonUtils.fromJson(userinfoJson, AuthorizeUserInfo.class);
			if (userinfo.success()) {
				Cookie openid = new Cookie("openid", userinfo.getOpenid());
				logger.info("openid cookie:{}", JsonUtils.toJson(openid));
				resp.addCookie(openid);
				
				Cookie nickname = new Cookie("nickname", userinfo.getNickname());
				logger.info("nickname cookie:{}", JsonUtils.toJson(nickname));
				resp.addCookie(nickname);
				return "获取用户成功：" + userinfo;
			} else {
				return "获取用户失败：" + userinfo;
			}
		} else {
			return "获取网页授权accesstoken失败：" + token;
		}
	}
}
