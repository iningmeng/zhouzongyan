package com.inm.entity;

import java.util.List;
/**
 * 
         10010  "����˺Ų�ѯ�������۵Ĳ��͵ı���..û�����"
		 10011  "articles��ȡ�ɹ�" 
         10012  "����˺Ų�ѯ�������۵Ĳ��͵ı���..ʧ��!!"
 *
 */
public class QueryArticleResult {
	private List<Article> data;
	private String message;
	private int code;
	
	public QueryArticleResult(List<Article> data, String message, int code) {
		super();
		this.data = data;
		this.message = message;
		this.code = code;
	}
	public List<Article> getData() {
		return data;
	}
	public void setData(List<Article> data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "QueryArticleResult [data=" + data + ", message=" + message
				+ ", code=" + code + "]";
	}
	
}
