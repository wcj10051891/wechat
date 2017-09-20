package com.biostime.wechat.protocol.handler.event;

import org.springframework.stereotype.Component;

import com.biostime.wechat.protocol.handler.MsgHandler;
import com.biostime.wechat.protocol.up.UpMessage;

/**
 * 用户已关注时，扫描带参数二维码<br/>
ToUserName	开发者微信号<br/>
FromUserName	发送方帐号（一个OpenID）<br/>
CreateTime	消息创建时间 （整型）<br/>
MsgType	消息类型，event<br/>
Event	事件类型，SCAN<br/>
EventKey	二维码场景值<br/>
Ticket	二维码的ticket，可用来换取二维码图片<br/>
 * @author wcj10051891
 * @date 2017年9月8日 下午8:55:57
 */
@Component
public class QRScanEventMsgHandler implements MsgHandler {

	@Override
	public boolean canHandle(UpMessage message) {
		return "event".equals(message.getMsgType()) && "SCAN".equals(message.getEvent());
	}

	@Override
	public String handle(UpMessage message) {
		return null;
	}

}
