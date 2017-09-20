package com.biostime.wechat.protocol.handler.normalmsg;

import org.springframework.stereotype.Component;

import com.biostime.wechat.protocol.handler.MsgHandler;
import com.biostime.wechat.protocol.up.UpMessage;

/**
 * 用户发送链接消息<br/>
ToUserName	接收方微信号<br/>
FromUserName	发送方微信号，若为普通用户，则是一个OpenID<br/>
CreateTime	消息创建时间<br/>
MsgType	消息类型，link<br/>
Title	消息标题<br/>
Description	消息描述<br/>
Url	消息链接<br/>
MsgId	消息id，64位整型<br/>
 * @author wcj10051891
 * @date 2017年9月8日 下午8:35:43
 */
@Component
public class LinkMsgHandler implements MsgHandler {

	@Override
	public boolean canHandle(UpMessage message) {
		return "link".equals(message.getMsgType());
	}

	@Override
	public String handle(UpMessage message) {
		return null;
	}

}
