package com.biostime.wechat.protocol.handler.normalmsg;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.biostime.wechat.protocol.down.VideoDownMessage;
import com.biostime.wechat.protocol.handler.MsgHandler;
import com.biostime.wechat.protocol.up.UpMessage;

/**
 * 用户发送视频消息<br/>
ToUserName	开发者微信号<br/>
FromUserName	发送方帐号（一个OpenID）<br/>
CreateTime	消息创建时间 （整型）<br/>
MsgType	视频为video<br/>
MediaId	视频消息媒体id，可以调用多媒体文件下载接口拉取数据。<br/>
ThumbMediaId	视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。<br/>
MsgId	消息id，64位整型<br/>
 * @author wcj10051891
 * @date 2017年9月8日 下午8:35:43
 */
@Component
public class VideoMsgHandler implements MsgHandler {
	private static final Logger logger = LogManager.getLogger(VideoMsgHandler.class);

	@Override
	public boolean canHandle(UpMessage message) {
		return "video".equals(message.getMsgType());
	}

	@Override
	public String handle(UpMessage message) {
		VideoDownMessage result = new VideoDownMessage(message, message.getMediaId(), "标题", "描述");
		logger.info("处理上传视频消息：{}", result);
		return result.toString();
	}

}
