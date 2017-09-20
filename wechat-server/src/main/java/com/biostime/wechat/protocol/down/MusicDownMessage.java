package com.biostime.wechat.protocol.down;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.biostime.wechat.protocol.up.UpMessage;

/**
 * 回复音乐消息<br/>
ToUserName	是	接收方帐号（收到的OpenID）<br/>
FromUserName	是	开发者微信号<br/>
CreateTime	是	消息创建时间 （整型）<br/>
MsgType	是	music<br/>
Title	否	音乐标题<br/>
Description	否	音乐描述<br/>
MusicURL	否	音乐链接<br/>
HQMusicUrl	否	高质量音乐链接，WIFI环境优先使用该链接播放音乐<br/>
ThumbMediaId	是	缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id<br/>
 * @author wcj10051891
 * @date 2017年9月8日 下午9:41:07
 */
@XmlRootElement(name="xml")
public class MusicDownMessage extends DownMessage {
	private String MsgType = "music";
	private Music Music = new Music();

	@XmlAccessorType(XmlAccessType.FIELD)
	static class Music {
		public String Title;
		public String Description;
		public String MusicURL;
		public String HQMusicUrl;
		public String ThumbMediaId;
	}
	
	public MusicDownMessage() {
	}
	
	public MusicDownMessage(UpMessage upMesage) {
		super(upMesage);
	}

	public MusicDownMessage(UpMessage upMesage, String Title, String Description, String MusicURL, String HQMusicUrl, String ThumbMediaId) {
		super(upMesage);
		Music.Title = Title;
		Music.Description = Description;
		Music.MusicURL = MusicURL;
		Music.HQMusicUrl = HQMusicUrl;
		Music.ThumbMediaId = ThumbMediaId;
	}

	public MusicDownMessage(String ToUserName, String FromUserName, String CreateTime, String Title, String Description, String MusicURL, String HQMusicUrl, String ThumbMediaId) {
		super(ToUserName, FromUserName, CreateTime);
		Music.Title = Title;
		Music.Description = Description;
		Music.MusicURL = MusicURL;
		Music.HQMusicUrl = HQMusicUrl;
		Music.ThumbMediaId = ThumbMediaId;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	
	public static void main(String[] args) {
		MusicDownMessage msg = new MusicDownMessage("ToUserName", "FromUserName", "CreateTime", "Title", "Description", "MusicURL", "HQMusicUrl", "ThumbMediaId");
		System.out.println(msg);
	}
}
