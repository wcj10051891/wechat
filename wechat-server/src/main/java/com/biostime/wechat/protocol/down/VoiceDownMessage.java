package com.biostime.wechat.protocol.down;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.biostime.wechat.protocol.up.UpMessage;

/**
 * 回复声音消息<br/>
ToUserName	是	接收方帐号（收到的OpenID）<br/>
FromUserName	是	开发者微信号<br/>
CreateTime	是	消息创建时间戳 （整型）<br/>
MsgType	是	语音，voice<br/>
MediaId	是	通过素材管理中的接口上传多媒体文件，得到的id<br/>
 * @author wcj10051891
 * @date 2017年9月8日 下午9:41:07
 */
@XmlRootElement(name="xml")
public class VoiceDownMessage extends DownMessage {
	private String MsgType = "voice";
	private Voice Voice = new Voice();

	@XmlAccessorType(XmlAccessType.FIELD)
	static class Voice {
		public String MediaId;
	}
	
	public VoiceDownMessage() {
	}

	public VoiceDownMessage(UpMessage upMesage) {
		super(upMesage);
	}

	public VoiceDownMessage(UpMessage upMesage, String media_id) {
		super(upMesage);
		Voice.MediaId = media_id;
	}

	public VoiceDownMessage(String ToUserName, String FromUserName, String CreateTime, String media_id) {
		super(ToUserName, FromUserName, CreateTime);
		Voice.MediaId = media_id;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	
	public static void main(String[] args) {
		VoiceDownMessage msg = new VoiceDownMessage("ToUserName", "FromUserName", "CreateTime", "media_id");
		System.out.println(msg);
	}
}
