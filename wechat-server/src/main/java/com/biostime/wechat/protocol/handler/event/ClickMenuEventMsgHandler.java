package com.biostime.wechat.protocol.handler.event;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.biostime.wechat.protocol.handler.MsgHandler;
import com.biostime.wechat.protocol.up.UpMessage;

/**
 * 点击菜单拉取消息时的事件推送<br/>
ToUserName	开发者微信号<br/>
FromUserName	发送方帐号（一个OpenID）<br/>
CreateTime	消息创建时间 （整型）<br/>
MsgType	消息类型，event<br/>
Event	事件类型，CLICK<br/>
EventKey	事件KEY值，与自定义菜单接口中KEY值对应<br/>
 * @author wcj10051891
 * @date 2017年9月8日 下午9:02:50
 */
@Component
public class ClickMenuEventMsgHandler implements MsgHandler {
	private Logger logger = LogManager.getLogger(this.getClass());

	@Override
	public boolean canHandle(UpMessage message) {
		return "event".equals(message.getMsgType()) && "CLICK".equals(message.getEvent());
	}

	@Override
	public String handle(UpMessage message) {
		return "";
	}
}
