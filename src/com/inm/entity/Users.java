package com.inm.entity;

public class Users {
	private int id;
	private String account;
	private String password;
	//ѡ��
	private String username;
	
	public Users() {}
	public Users(int id, String account, String password, String username) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public Users setId(int id) {
		this.id = id;
		return this;
	}
	public String getAccount() {
		return account;
	}
	public Users setAccount(String account) {
		this.account = account;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public Users setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getUsername() {
		return username;
	}
	public Users setUsername(String username) {
		this.username = username;
		return this;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", account=" + account + ", password="
				+ password + ", username=" + username + "]";
	}
	
	
}
