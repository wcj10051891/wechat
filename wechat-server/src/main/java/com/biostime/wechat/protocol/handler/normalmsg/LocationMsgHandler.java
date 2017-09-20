package com.biostime.wechat.protocol.handler.normalmsg;

import org.springframework.stereotype.Component;

import com.biostime.wechat.protocol.handler.MsgHandler;
import com.biostime.wechat.protocol.up.UpMessage;

/**
 * 用户发送位置消息<br/>
ToUserName	开发者微信号<br/>
FromUserName	发送方帐号（一个OpenID）<br/>
CreateTime	消息创建时间 （整型）<br/>
MsgType	location<br/>
Location_X	地理位置维度<br/>
Location_Y	地理位置经度<br/>
Scale	地图缩放大小<br/>
Label	地理位置信息<br/>
MsgId	消息id，64位整型<br/>
 * @author wcj10051891
 * @date 2017年9月8日 下午8:35:43
 */
@Component
public class LocationMsgHandler implements MsgHandler {

	@Override
	public boolean canHandle(UpMessage message) {
		return "location".equals(message.getMsgType());
	}

	@Override
	public String handle(UpMessage message) {
		return null;
	}

}
