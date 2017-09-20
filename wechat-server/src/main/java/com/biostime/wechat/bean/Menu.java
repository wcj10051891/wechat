package com.biostime.wechat.bean;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.biostime.wechat.util.JsonUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class Menu {
	private List<ButtonItem> button = new ArrayList<ButtonItem>();

	public List<ButtonItem> getButton() {
		return button;
	}

	public void setButton(List<ButtonItem> button) {
		this.button = button;
	}
	
	public static void main(String[] args) {
		
		System.out.println(URLEncoder.encode("http://216.250.105.7/wechat/authorize"));
		Menu menu = new Menu();
		List<ButtonItem> buttons = menu.getButton();
		
		ButtonItem button1 = new ButtonItem("健康&快乐");
		ButtonItem subItem1 = new ButtonItem("澳洲传奇");
		subItem1.setType("click");
		subItem1.setKey("key11");
		ButtonItem subItem2 = new ButtonItem("品牌动态");
		subItem2.setType("click");
		subItem2.setKey("key12");
		ButtonItem subItem3 = new ButtonItem("产品课堂");
		subItem3.setType("click");
		subItem3.setKey("key13");
		button1.getSub_button().add(subItem1);
		button1.getSub_button().add(subItem2);
		button1.getSub_button().add(subItem3);
		buttons.add(button1);
		
		ButtonItem button2 = new ButtonItem("购物");
		button2.setType("view");
		button2.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx573ff934f27fd0f6&redirect_uri=216.250.105.7&response_type=code&scope=snsapi_userinfo&state=wcj#wechat_redirect");
		buttons.add(button2);

		ButtonItem button3 = new ButtonItem("会员");
		ButtonItem subItem31 = new ButtonItem("Swisse健康说");
		subItem31.setType("click");
		subItem31.setKey("key31");
		ButtonItem subItem32 = new ButtonItem("我的Swisse");
		subItem32.setType("click");
		subItem32.setKey("key32");
		ButtonItem subItem33 = new ButtonItem("Swisse顾问");
		subItem33.setType("click");
		subItem33.setKey("key33");
		button3.getSub_button().add(subItem31);
		button3.getSub_button().add(subItem32);
		button3.getSub_button().add(subItem33);
		buttons.add(button3);
		
		System.out.println(JsonUtils.toJson(menu));
	}
}
