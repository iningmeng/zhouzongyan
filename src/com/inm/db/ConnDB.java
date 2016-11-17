package com.inm.db;

import java.sql.*;

public class ConnDB {
	//��ݿ���
	private static final String DB = "library";
	//��ݿ��û���
	private static final String DB_USER = "root";
	//��ݿ�����
	private static final String DB_PASSWORD = "root";
	
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private Connection conn = null;
	ResultSet rs = null;
	int result = 0;
	public ConnDB() {}
	public void openConn() throws Exception {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			String url = "jdbc:mysql://localhost/" + DB + "?user=" + DB_USER + "&password=" + DB_PASSWORD + "&useUnicode=true&characterEncoding=utf-8";
			conn = DriverManager.getConnection(url);
			// stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			System.err.println("data.executeQuery:" + e.getMessage());
		}
	}
	public void createStmt() throws Exception {
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			System.err.println("data.executeQuery:" + e.getMessage());
		}
	}
	public PreparedStatement createPStmt(String sql) throws Exception {
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			System.err.println("data.executeQuery:" + e.getMessage());
		}
		return pstmt;
	}  
	//��ѯ���
	public ResultSet Query(String sql) {
		System.out.println(sql);
		rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.err.println("data.executeQuery:" + e.getMessage());
		}
		return rs;
	}
	//�������
	public int Update(String sql) {
		System.out.println(sql);
		try {
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println("data.executeUpdate:" + e.getMessage());
		}
		return result;
	}
	public Connection getConn() {
		return conn;
	}
	/**
	 *  Close
	 */
	public void closeStmt() {
		try {
			if( stmt != null && ! stmt.isClosed())
				stmt.close();
		} catch (SQLException e) {
			System.err.println("closeStmt:" + e.getMessage());
		}
	}
	public void closeConn() {
		try {
			if(conn != null && ! conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			System.err.println("closeConn:" + e.getMessage());
		}
	}
}
