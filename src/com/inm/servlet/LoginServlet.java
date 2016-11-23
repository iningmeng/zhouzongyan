package com.inm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inm.util.C;

import com.inm.entity.Users;

import com.sun.jmx.snmp.UserAcl;

import com.inm.db.ConnDB;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String TAG = "LoginServlet";
    public LoginServlet() {super();}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		System.out.println(TAG + account + ".." + password);
		//���Ե�¼
		attemptLogin(request, response, account, password);
	}
	/**
	 * ���Ե�¼ 
	 * @param out
	 * @param account
	 * @param password
	 * @throws IOException 
	 */
	private void attemptLogin(HttpServletRequest request, HttpServletResponse response, String account, String password) throws IOException {
		//�õ������
		PrintWriter out = response.getWriter();
		if ( !isEmpty(account, password) ) {
			if(isAccountExisted(account)) {
				if (login(response, account, password)) {
					out.print("Login Success!");
					//�ض���  ����½�����
					response.sendRedirect("./index.html");
				} else {
					out.print("Account or password is error");
					response.sendRedirect(request.getContextPath()+"/login.jsp?msg=1");
				}
			} else {
				out.print("The account is not exists.");
				response.sendRedirect(request.getContextPath()+"/login.jsp?msg=2");
			}
		} else {
			out.println("Account or password is empty.");
			response.sendRedirect(request.getContextPath()+"/login.jsp?msg=3");
		}
	}
	/**
	 * �ж���ݿ����Ƿ��Ѿ�����account
	 * @param account
	 * @return
	 */
	private boolean isAccountExisted(String account) {
		//��ѯ���
		String sql = "select * from users where account='" + account + "'";
		ConnDB connDB = new ConnDB();
		try {
			connDB.openConn();
			connDB.createStmt();
			ResultSet rs =  connDB.Query(sql);
			//�ж��Ƿ����
			if(rs.first()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connDB.closeStmt();
			connDB.closeConn();
		}
		return false; 
	}
	/**
	 * ��½
	 * 		���ǲ�ѯ��ݿ��˺������Ƿ���ȷ
	 * @param response
	 * @param account
	 * @param password
	 * @return
	 */
	private boolean login(HttpServletResponse response, String account, String password) {
		//��ѯ���
		String sql = "select * from users where account='" + account + "'"+" and password="+ "'"+password+"'";
		ConnDB connDB = new ConnDB();
		ResultSet rs = null;
		try {
			connDB.openConn();
			connDB.createStmt();
			rs =  connDB.Query(sql);
			if (rs.next()) {
				//д��cookies��
				addData2Cookies(response, account, password, rs.getString("username"));
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connDB.closeStmt();
			connDB.closeConn();
		}
		return false;
	}
	/**
	 * ���û������� д�� cookies��
	 */
	private void addData2Cookies(HttpServletResponse response, String account, String password, String username) {
		String value = account + ";" + password;
		if (username == null) {
			value += "; ";
		} else {
			value += (";" + username);
		}
		//������ı��� cookie����
		try {
			value = URLEncoder.encode(value, "utf-8");
			Cookie cookie = new Cookie(C.USERS, value);
			System.out.println("Cookies�е�����Ϊ     " + cookie.toString());
			response.addCookie(cookie);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	/**
	 *   �ж��˺Ż������Ƿ�Ϊ��
	 *   	��ʵ�ϣ�ǰ̨�Ѿ��жϹ�
	 */
	private boolean isEmpty(String account, String password) {
		if (account==null || account.equals("")) {
			return true;
		}
		if (password==null || password.equals("")) {
			return true;
		}
		return false;
	}
}
