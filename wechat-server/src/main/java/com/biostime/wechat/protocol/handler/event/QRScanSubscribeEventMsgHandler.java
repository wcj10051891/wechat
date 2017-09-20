package com.biostime.wechat.protocol.handler.event;

import org.springframework.stereotype.Component;

import com.biostime.wechat.protocol.handler.MsgHandler;
import com.biostime.wechat.protocol.up.UpMessage;

/**
 * 用户未关注时，扫描带参数二维码并且成功关注<br/>
ToUserName	开发者微信号<br/>
FromUserName	发送方帐号（一个OpenID）<br/>
CreateTime	消息创建时间 （整型）<br/>
MsgType	消息类型，event<br/>
Event	事件类型，subscribe<br/>
EventKey	事件KEY值，qrscene_为前缀，后面为二维码的参数值<br/>
Ticket	二维码的ticket，可用来换取二维码图片<br/>
 * @author wcj10051891
 * @date 2017年9月8日 下午8:55:57
 */
@Component
public class QRScanSubscribeEventMsgHandler implements MsgHandler {

	@Override
	public boolean canHandle(UpMessage message) {
		return "event".equals(message.getMsgType()) && "subscribe".equals(message.getEvent()) && message.getEventKey().startsWith("qrscene_");
	}

	@Override
	public String handle(UpMessage message) {
		return null;
	}

}
