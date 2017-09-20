package com.biostime.wechat.protocol.down;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.biostime.wechat.protocol.up.UpMessage;

/**
 * 回复图片消息<br/>
ToUserName	是	接收方帐号（收到的OpenID）<br/>
FromUserName	是	开发者微信号<br/>
CreateTime	是	消息创建时间 （整型）<br/>
MsgType	是	image<br/>
MediaId	是	<br/>
通过素材管理中的接口上传多媒体文件，得到的id。<br/>
 * @author wcj10051891
 * @date 2017年9月8日 下午9:41:07
 */
@XmlRootElement(name="xml")
public class PicDownMessage extends DownMessage {
	private String MsgType = "image";
	private Image Image = new Image();

	@XmlAccessorType(XmlAccessType.FIELD)
	static class Image {
		public String MediaId;
	}
	
	public PicDownMessage() {
	}
	
	public PicDownMessage(UpMessage upMesage) {
		super(upMesage);
	}
	public PicDownMessage(UpMessage upMesage, String media_id) {
		super(upMesage);
		Image.MediaId = media_id;
	}

	public PicDownMessage(String ToUserName, String FromUserName, String CreateTime, String media_id) {
		super(ToUserName, FromUserName, CreateTime);
		Image.MediaId = media_id;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	
	public static void main(String[] args) {
		PicDownMessage msg = new PicDownMessage("ToUserName", "FromUserName", "CreateTime", "media_id");
		System.out.println(msg);
	}
}
