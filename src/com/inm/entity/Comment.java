package com.inm.entity;

public class Comment {
	private int id;
	private String account;
	private String indexs;
	private String time;
	private String message;
	
	public Comment(int id, String account, String indexs, String time,
			String message) {
		super();
		this.id = id;
		this.account = account;
		this.indexs = indexs;
		this.time = time;
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getIndexs() {
		return indexs;
	}
	public void setIndexs(String indexs) {
		this.indexs = indexs;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
