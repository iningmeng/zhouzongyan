package com.inm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inm.util.CharacterUtil;

import com.inm.db.ConnDB;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String TAG = "RegisterServlet\t";
    public RegisterServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		//�ǳ� ��Ϊ�� 
		String username = CharacterUtil.urlChineseStr(request.getParameter("username"));
		System.out.println(TAG + account + ".." + password + ".." + username);
		//����ע��
		attemptRegister(request, response, account, password, username);
	}
	/**
	 * ���Ե�¼
	 * @param out
	 * @param account       ��ѡ
	 * @param password      ��ѡ
	 * @param username      ��ѡ
	 * @throws IOException 
	 */
	private void attemptRegister(HttpServletRequest request, HttpServletResponse response, String account, String password, String username) throws IOException {
		//�õ������
		PrintWriter out = response.getWriter();
		if ( !isEmpty(account, password) ) {
			if (isAccountExisted(account)) {
				out.println("The account already exists.");
				response.sendRedirect(request.getContextPath()+"/login.jsp?msg=21");
			} else {
				if( !register(account, password, username) ) {
					out.println("Create account failure.");
					response.sendRedirect(request.getContextPath()+"/login.jsp?msg=22");
				} else {
					out.println("Create account success.");
					response.sendRedirect(request.getContextPath()+"/login.jsp?msg=23");
				}
			}
		}else {
			out.println("Account or password is empty.");
			response.sendRedirect(request.getContextPath()+"/login.jsp?msg=24");
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
	/**
	 * ����ע�� 
	 * 		ע��ɹ� ����true
	 */
	private boolean register(String account, String password, String username) {
		String sql = null;
		if (username != null) {
			sql = getSQL(account, password, username);
		} else {
			sql = getSQL(account, password);
		}
		//�������
		ConnDB connDB = new ConnDB();
		try {
			connDB.openConn();
			connDB.createStmt();
			if(connDB.Update(sql) == 1) {
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
	 * �õ�register��SQL���
	 * @param account
	 * @param password
	 * @param username
	 * @return
	 */
	private String getSQL(String account, String password, String username) {
		return "insert into users(account, password, username) values('"+account+"','"+password+"',"+"'"+username+"')"; 
	}
	private String getSQL(String account, String password) {
		return "insert into users(account, password) values('"+account+"', '"+password+"')"; 
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
}
