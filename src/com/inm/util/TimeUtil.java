package com.inm.util;

import java.util.Calendar;

public class TimeUtil {
	public static void main(String[] args) {
		System.out.println(getNowTime());
	}

	public static String getNowTime() {
		// 2016-10-01 09:31:33
		String nowTime = null;
		Calendar ca = Calendar.getInstance();
		int year = ca.get(Calendar.YEAR);// ��ȡ���
		int month = ca.get(Calendar.MONTH);// ��ȡ�·�
		int day = ca.get(Calendar.DATE);// ��ȡ��
		int minute = ca.get(Calendar.MINUTE);// ��
		int hour = ca.get(Calendar.HOUR);// Сʱ
		int second = ca.get(Calendar.SECOND);// ��
		nowTime = year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
		return nowTime;
	}

}
