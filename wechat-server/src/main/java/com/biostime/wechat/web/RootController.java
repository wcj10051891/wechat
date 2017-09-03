package com.biostime.wechat.web;

import java.io.StringReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.JAXB;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biostime.wechat.bean.WxValidBean;
import com.biostime.wechat.protocol.handler.MsgHandler;
import com.biostime.wechat.protocol.up.UpMessage;
import com.biostime.wechat.util.JsonUtils;

@RestController
public class RootController {
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@Value("${wechat.valid.token}")
	private String validToken;
	
	@Autowired
	private ApplicationContext ctx;
	
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
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String post(String signature, String timestamp, String nonce, @RequestBody String req) {
		if (!isValueRequest(signature, timestamp, nonce))
			return "illegal request";
		logger.info("receive req:{}", req);
		UpMessage message = JAXB.unmarshal(new StringReader(req), UpMessage.class);
		logger.info("unmarshal message:{}", JsonUtils.toJson(message));
		for (MsgHandler handler : ctx.getBeansOfType(MsgHandler.class).values()) {
			if (handler.canHandle(message))
				return handler.handle(message);
		};
		return "";
	}

}
