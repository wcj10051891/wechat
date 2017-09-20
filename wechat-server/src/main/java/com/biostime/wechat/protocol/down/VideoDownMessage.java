package com.biostime.wechat.protocol.down;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.biostime.wechat.protocol.up.UpMessage;

/**
 * 回复视频消息<br/>
ToUserName	是	接收方帐号（收到的OpenID）<br/>
FromUserName	是	开发者微信号<br/>
CreateTime	是	消息创建时间 （整型）<br/>
MsgType	是	video<br/>
MediaId	是	通过素材管理中的接口上传多媒体文件，得到的id<br/>
Title	否	视频消息的标题<br/>
Description	否	视频消息的描述<br/>
 * @author wcj10051891
 * @date 2017年9月8日 下午9:41:07
 */
@XmlRootElement(name="xml")
public class VideoDownMessage extends DownMessage {
	private String MsgType = "video";
	private Video Video = new Video();

	@XmlAccessorType(XmlAccessType.FIELD)
	static class Video {
		public String MediaId;
		public String Title;
		public String Description;
	}
	
	public VideoDownMessage() {
	}

	public VideoDownMessage(UpMessage upMesage) {
		super(upMesage);
	}
	
	public VideoDownMessage(UpMessage upMesage, String media_id, String Title, String Description) {
		super(upMesage);
		Video.MediaId = media_id;
		Video.Title = Title;
		Video.Description = Description;
	}

	public VideoDownMessage(String ToUserName, String FromUserName, String CreateTime, String media_id, String Title, String Description) {
		super(ToUserName, FromUserName, CreateTime);
		Video.MediaId = media_id;
		Video.Title = Title;
		Video.Description = Description;
	}
	
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	
	public static void main(String[] args) {
		VideoDownMessage msg = new VideoDownMessage("ToUserName", "FromUserName", "CreateTime", "media_id", "Title", "Description");
		System.out.println(msg);
	}
}
