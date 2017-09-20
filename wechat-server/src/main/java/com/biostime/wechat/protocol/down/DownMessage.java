package com.biostime.wechat.protocol.down;

import java.io.StringWriter;

import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.biostime.wechat.protocol.up.UpMessage;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class DownMessage {
	private String ToUserName;
	private String FromUserName;
	private String CreateTime;
	
	public DownMessage() {
	}
	
	public DownMessage(UpMessage upMesage) {
		this.ToUserName = upMesage.getFromUserName();
		this.FromUserName = upMesage.getToUserName();
		this.CreateTime = upMesage.getCreateTime();
	}
	
	public DownMessage(String toUserName, String fromUserName, String createTime) {
		super();
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
	}
	
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}

	@Override
	public String toString() {
		StringWriter s = new StringWriter();
		JAXB.marshal(this, s);
		return s.toString();
	}
}
