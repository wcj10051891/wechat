package com.biostime.wechat.protocol.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.biostime.wechat.protocol.up.UpMessage;
import com.biostime.wechat.util.JsonUtils;

@Component
public class SubscribeMsgHandler implements MsgHandler {
	private Logger logger = LogManager.getLogger(this.getClass());

	@Override
	public boolean canHandle(UpMessage message) {
		return "subscribe".equals(message.getEvent());
	}

	@Override
	public String handle(UpMessage message) {
		logger.info("{}关注了{}", message.getFromUserName(), message.getToUserName());
		logger.info("handle message:{}, result:{}", JsonUtils.toJson(message), "");
		return "";
	}
}
