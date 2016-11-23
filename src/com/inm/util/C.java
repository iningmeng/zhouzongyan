package com.inm.util;

import java.util.ArrayList;

public class C {
	//Cookies key
	public static final String USERS = "USERS";
	//��Ҫ�жϵ�¼״̬��jsp
	public static ArrayList<String> getLoginedJsp() {
		ArrayList<String> list = new ArrayList<String>();
		//��Ҫ��½���ܷ��ʵ�ҳ��д������
		list.add("/gallery.html");
		list.add("/charts.html");
		//TODO:........
		return list;
	}
}
