package com.inm.util;

import java.io.UnsupportedEncodingException;

/**
 * �ַ���
 */
public class CharacterUtil {
	//��������url��������
	public static String urlChineseStr(String inStr) {
		if (inStr == null) {
			return null;
		}
		try {
			return new String(inStr.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
