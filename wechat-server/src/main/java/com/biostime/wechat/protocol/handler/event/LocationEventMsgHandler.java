package com.biostime.wechat.protocol.handler.event;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.biostime.wechat.protocol.handler.MsgHandler;
import com.biostime.wechat.protocol.up.UpMessage;

/**
 * 上报地理位置事件<br/>
ToUserName	开发者微信号<br/>
FromUserName	发送方帐号（一个OpenID）<br/>
CreateTime	消息创建时间 （整型）<br/>
MsgType	消息类型，event<br/>
Event	事件类型，LOCATION<br/>
Latitude	地理位置纬度<br/>
Longitude	地理位置经度<br/>
Precision	地理位置精度<br/>
 * @author wcj10051891
 * @date 2017年9月8日 下午9:02:50
 */
@Component
public class LocationEventMsgHandler implements MsgHandler {
	private Logger logger = LogManager.getLogger(this.getClass());

	@Override
	public boolean canHandle(UpMessage message) {
		return "event".equals(message.getMsgType()) && "LOCATION".equals(message.getEvent());
	}

	@Override
	public String handle(UpMessage message) {
		return "";
	}
}
