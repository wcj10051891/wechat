package com.biostime.wechat.protocol.handler.normalmsg;

import org.springframework.stereotype.Component;

import com.biostime.wechat.protocol.down.PicDownMessage;
import com.biostime.wechat.protocol.handler.MsgHandler;
import com.biostime.wechat.protocol.up.UpMessage;

/**
 * 用户发送图片消息<br/>
ToUserName	开发者微信号<br/>
FromUserName	发送方帐号（一个OpenID）<br/>
CreateTime	消息创建时间 （整型）<br/>
MsgType	image<br/>
PicUrl	图片链接（由系统生成）<br/>
MediaId	图片消息媒体id，可以调用多媒体文件下载接口拉取数据。<br/>
MsgId	消息id，64位整型<br/>
 * @author wcj10051891
 * @date 2017年9月8日 下午8:35:43
 */
@Component
public class PicUpMsgHandler implements MsgHandler {

	@Override
	public boolean canHandle(UpMessage message) {
		return "image".equals(message.getMsgType());
	}

	@Override
	public String handle(UpMessage message) {
		return new PicDownMessage(message, message.getMediaId()).toString();
	}

}
