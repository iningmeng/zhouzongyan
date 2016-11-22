package com.inm.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inm.util.TimeUtil;

import com.inm.db.ConnDB;

public class AddComment extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ConnDB con = new ConnDB();
		String userName = "'"+request.getParameter("account")+"'";
		String Index = "'"+request.getParameter("indexs")+"'";
		String Time = "'"+TimeUtil.getNowTime()+"'";
		String Message = "'"+request.getParameter("Comment")+"'";
		try {
			con.openConn();
			con.createStmt();
			String sql = "INSERT INTO comments VALUES (NULL,+"+userName+","+Index+","+Time+","+Message+")";
			con.Update(sql);
			con.closeStmt();
			con.closeConn();
			response.getWriter().print("Success!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
