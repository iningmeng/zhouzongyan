package com.inm.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.inm.entity.Comment;

import com.inm.db.ConnDB;

public class SearchComment extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String orderBy = request.getParameter("orderBy");
		List<Comment> result = null;
		if(orderBy != null && "account".equals(orderBy)){
			result = SearchCommentByAccount(request);
		}else if(orderBy != null && "indexs".equals(orderBy)){
			result = SearchCommentByIndex(request);
		}else{
			result = null;
		}
		Gson gson = new GsonBuilder()  
		  .setDateFormat("yyyy-MM-dd HH:mm:ss")  
		  .create();
		response.getWriter().write(gson.toJson(result));
		
	}
	private List<Comment> SearchCommentByIndex(HttpServletRequest request) {
		
		String index = request.getParameter("indexs");
//		String page = request.getParameter("page");
		int page = Integer.valueOf("1");
		String limit = " LIMIT "+(page-1)*10+","+page*10;
		ConnDB con = new ConnDB();
		List<Comment> result = null;
		try {
			con.openConn();
			con.createStmt();
			String sql = "select * from comments where indexs = '"+index+"' "+limit;
			ResultSet rs = con.Query(sql);
			result = new ArrayList<Comment>();
			while(rs.next()){
				Comment comment = new Comment(	rs.getInt("id"),
												rs.getString("account"),
												rs.getString("indexs"), 
												rs.getTimestamp("time").toString(),
												rs.getString("message")
												);
				result.add(comment);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return result;
	}
	private List<Comment> SearchCommentByAccount(HttpServletRequest request) {
		// TODO Auto-generated method stub
//		String account = request.getParameter("account");
//		String page = Integer.valueOf(request.getParameter("page"));
		int page = Integer.valueOf("1");
		String account = "test";
		String limit = " LIMIT "+(page-1)*10+","+page*10;
		ConnDB con = new ConnDB();
		List<Comment> result = null;
		try {
			con.openConn();
			con.createStmt();
			String sql = "select * from comments where account = '"+account+"' "+limit;
			ResultSet rs = con.Query(sql);
			result = new ArrayList<Comment>();
			while(rs.next()){
				Comment comment = new Comment(	rs.getInt("id"),
												rs.getString("account"),
												rs.getString("indexs"), 
												rs.getString("time"), 
												rs.getString("message")
												);
				result.add(comment);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return result;
	}

}
