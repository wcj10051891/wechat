package com.biostime.wechat.protocol.down;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.biostime.wechat.protocol.up.UpMessage;

/**
 * 回复图文消息<br/>
ToUserName	是	接收方帐号（收到的OpenID）<br/>
FromUserName	是	开发者微信号<br/>
CreateTime	是	消息创建时间 （整型）<br/>
MsgType	是	news<br/>
ArticleCount	是	图文消息个数，限制为8条以内<br/>
Articles	是	多条图文消息信息，默认第一个item为大图,注意，如果图文数超过8，则将会无响应<br/>
Title	是	图文消息标题<br/>
Description	是	图文消息描述<br/>
PicUrl	是	图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200<br/>
Url	是	点击图文消息跳转链接<br/>
 * @author wcj10051891
 * @date 2017年9月8日 下午9:41:07
 */
@XmlRootElement(name="xml")
public class ArticlesDownMessage extends DownMessage {
	private String MsgType = "news";
	private String ArticleCount;
	private Articles Articles;
	
	public ArticlesDownMessage() {
	}

	public ArticlesDownMessage(UpMessage upMesage) {
		super(upMesage);
	}

	public ArticlesDownMessage(UpMessage upMesage, List<Item> articleItems) {
		super(upMesage);
		this.Articles = new Articles();
		this.Articles.items = articleItems;
		this.ArticleCount = String.valueOf(this.Articles.items.size());
	}
	
	public ArticlesDownMessage(String ToUserName, String FromUserName, String CreateTime, List<Item> articleItems) {
		super(ToUserName, FromUserName, CreateTime);
		this.Articles = new Articles();
		this.Articles.items = articleItems;
		this.ArticleCount = String.valueOf(this.Articles.items.size());
	}
	
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public String getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(String articleCount) {
		ArticleCount = articleCount;
	}

	public Articles getArticles() {
		return Articles;
	}

	public void setArticles(Articles articles) {
		Articles = articles;
	}
	
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlRootElement(name="item")
	public static class Item {
		public String Title;
		public String Description;
		public String PicUrl;
		public String Url;
		public Item() {
		}
		public Item(String title, String description, String picUrl, String url) {
			super();
			Title = title;
			Description = description;
			PicUrl = picUrl;
			Url = url;
		}
	}
	
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Articles {
		@XmlElement(name="item")
		public List<Item> items;
	}

	
	public static void main(String[] args) {
		List<Item> items = new ArrayList<ArticlesDownMessage.Item>();
		Item item1 = new Item("标题1", "描述1", "picUrl1", "URL1");
		items.add(item1);
		Item item2 = new Item("标题2", "描述2", "picUrl2", "URL2");
		items.add(item2);
		ArticlesDownMessage msg = new ArticlesDownMessage("ToUserName", "FromUserName", "CreateTime", items);
		System.out.println(msg);
	}
}
