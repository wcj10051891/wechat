package com.biostime.wechat.protocol.down;

import javax.xml.bind.annotation.XmlRootElement;

import com.biostime.wechat.protocol.up.UpMessage;

/**
 * 回复文本消息<br/>
ToUserName	是	接收方帐号（收到的OpenID）<br/>
FromUserName	是	开发者微信号<br/>
CreateTime	是	消息创建时间 （整型）<br/>
MsgType	是	text<br/>
Content	是	回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）<br/>
 * @author wcj10051891
 * @date 2017年9月8日 下午9:41:07
 */
@XmlRootElement(name="xml")
public class TextDownMessage extends DownMessage {
	private String MsgType = "text";
	private String Content;
	
	public TextDownMessage() {
	}

	public TextDownMessage(UpMessage upMesage) {
		super(upMesage);
	}

	public TextDownMessage(UpMessage upMesage, String content) {
		super(upMesage);
		Content = content;
	}
	
	public TextDownMessage(String ToUserName, String FromUserName, String CreateTime, String content) {
		super(ToUserName, FromUserName, CreateTime);
		Content = content;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}	
	
	public static void main(String[] args) {
		TextDownMessage msg = new TextDownMessage("ToUserName", "FromUserName", "CreateTime", "media_id");
		System.out.println(msg);
	}
}
