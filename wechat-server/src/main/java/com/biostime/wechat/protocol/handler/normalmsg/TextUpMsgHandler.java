package com.biostime.wechat.protocol.handler.normalmsg;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biostime.wechat.protocol.handler.MsgHandler;
import com.biostime.wechat.protocol.up.UpMessage;
import com.biostime.wechat.service.TemplateService;
import com.biostime.wechat.service.TemplateService.ValueAndColor;

/**
 * 用户发送文本消息处理器<br/>
ToUserName	开发者微信号<br/>
FromUserName	发送方帐号（一个OpenID）<br/>
CreateTime	消息创建时间 （整型）<br/>
MsgType	text<br/>
Content	文本消息内容<br/>
MsgId	消息id，64位整型<br/>
 * @author wcj10051891
 * @date 2017年9月8日 下午8:35:43
 */
@Component
public class TextUpMsgHandler implements MsgHandler {
	private static final Logger logger = LogManager.getLogger(TextUpMsgHandler.class);
	
	@Autowired
	private TemplateService templateService;

	@Override
	public boolean canHandle(UpMessage message) {
		return "text".equals(message.getMsgType());
	}

	@Override
	public String handle(UpMessage message) {
		this.templateService.sendTemplateMessage(message.getFromUserName(),
				"mMZSXfJTaHQK19ghyTXBGpKUGMs1fiP62voVUsxr6qk",
				"www.qq.com",
				new ValueAndColor("这是first"),
				new ValueAndColor("这是remark"),
				new ValueAndColor("这是keyword1"),
				new ValueAndColor("这是keyword2"),
				new ValueAndColor("这是keyword3"),
				new ValueAndColor("这是keyword4"),
				new ValueAndColor("这是keyword5"),
				new ValueAndColor("这是keyword6"));
		return "";
	}

}
