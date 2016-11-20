package com.inm.entity;

import java.sql.Timestamp;

public class Article {
	private int id;
	private String account;
	private String indexs;
	private String title;
	private String category;
	private Timestamp time;
	private String message;
	private String formtext;
	public Article() {}
	public Article(int id, String account, String indexs, String title,
			Timestamp time, String message,String formtext) {
		super();
		this.id = id;
		this.account = account;
		this.indexs = indexs;
		this.title = title;
		this.time = time;
		this.message = message;
		this.formtext = formtext;
	}
	
	public int getId() {
		return id;
	}
	public Article setId(int id) {
		this.id = id;
		return this;
	}
	public String getAccount() {
		return account;
	}
	public Article setAccount(String account) {
		this.account = account;
		return this;
	}
	public String getIndexs() {
		return indexs;
	}
	public Article setIndexs(String indexs) {
		this.indexs = indexs;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public Article setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getCategory() {
		return category;
	}
	public Article setCategory(String category) {
		this.category = category;
		return this;
	}
	public Timestamp getTime() {
		return time;
	}
	public Article setTime(Timestamp time) {
		this.time = time;
		return this;
	}
	public String getMessage() {
		return message;
	}
	public Article setMessage(String message) {
		this.message = message;
		return this;
	}
	public String getFormtext() {
		return formtext;
	}
	public Article setFormtext(String formtext) {
		this.formtext = formtext;
		return this;
	}
	
	@Override
	public String toString() {
		return "Article [id=" + id + ", account=" + account + ", indexs="
				+ indexs + ", title=" + title + ", category=" + category
				+ ", time=" + time + ", message=" + message +"formtext="+formtext+ "]";
	}	
}
