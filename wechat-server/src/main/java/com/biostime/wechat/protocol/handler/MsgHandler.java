package com.biostime.wechat.protocol.handler;

import com.biostime.wechat.protocol.up.UpMessage;

public interface MsgHandler {
	boolean canHandle(UpMessage message);
	String handle(UpMessage message);
}
