package com.biostime.wechat.protocol.up;

import java.io.StringReader;

import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.biostime.wechat.util.JsonUtils;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE) 
public class UpMessage {
    @JsonProperty("ToUserName") 
	private String ToUserName;
    @JsonProperty("FromUserName") 
	private String FromUserName;
    @JsonProperty("CreateTime") 
	private String CreateTime;
    @JsonProperty("MsgType") 
	private String MsgType;
    @JsonProperty("Event") 
	private String Event;
    @JsonProperty("Content") 
	private String Content;
    @JsonProperty("MsgId") 
	private String MsgId;
    @JsonProperty("PicUrl") 
	private String PicUrl;
    @JsonProperty("MediaId") 
	private String MediaId;
    @JsonProperty("Format") 
	private String Format;
    @JsonProperty("ThumbMediaId") 
	private String ThumbMediaId;
    @JsonProperty("Location_X") 
	private String Location_X;
    @JsonProperty("Location_Y") 
	private String Location_Y;
    @JsonProperty("Scale") 
	private String Scale;
    @JsonProperty("Label") 
	private String Label;
    @JsonProperty("Title") 
	private String Title;
    @JsonProperty("Description") 
	private String Description;
    @JsonProperty("Url") 
	private String Url;
    @JsonProperty("EventKey") 
	private String EventKey;
    @JsonProperty("Ticket") 
	private String Ticket;
    @JsonProperty("Latitude") 
	private String Latitude;
    @JsonProperty("Longitude") 
	private String Longitude;
    @JsonProperty("Precision") 
	private String Precision;
	
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
	public String getLocation_X() {
		return Location_X;
	}
	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}
	public String getLocation_Y() {
		return Location_Y;
	}
	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}
	public String getScale() {
		return Scale;
	}
	public void setScale(String scale) {
		Scale = scale;
	}
	public String getLabel() {
		return Label;
	}
	public void setLabel(String label) {
		Label = label;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getEventKey() {
		return EventKey;
	}
	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
	public String getTicket() {
		return Ticket;
	}
	public void setTicket(String ticket) {
		Ticket = ticket;
	}
	public String getLatitude() {
		return Latitude;
	}
	public void setLatitude(String latitude) {
		Latitude = latitude;
	}
	public String getLongitude() {
		return Longitude;
	}
	public void setLongitude(String longitude) {
		Longitude = longitude;
	}
	public String getPrecision() {
		return Precision;
	}
	public void setPrecision(String precision) {
		Precision = precision;
	}
	public String getEvent() {
		return Event;
	}
	public void setEvent(String event) {
		Event = event;
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
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	
	public static void main(String[] args) {
		String msg = "<xml><ToUserName><![CDATA[gh_125f61461e8b]]></ToUserName><FromUserName><![CDATA[oD4uNwgKtiCvNg6CUCxeFG0IPLUo]]></FromUserName><CreateTime>1504458353</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[unsubscribe]]></Event><EventKey><![CDATA[]]></EventKey></xml>";
		UpMessage message = JAXB.unmarshal(new StringReader(msg), UpMessage.class);
		System.out.println(JsonUtils.toJson(message));
	}
}
