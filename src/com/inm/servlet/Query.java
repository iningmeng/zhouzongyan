package com.inm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.inm.util.CharacterUtil;

import com.inm.entity.*;

import com.inm.db.*;

public class Query extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private  final int LATEST_COUNT = 5;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//获取参数并判断
		String sql = getParams(request);
		if (sql == null || sql.equals("")) {
			out.println("查询条件有误。。查询条件为空");
		} else {
			String jsonResult;
			//数据库查询
			ArrayList<Article> result = getAllArticles(sql);
			if (result.size() > 0) {
				jsonResult = getJsonStr(result);
				out.println(jsonResult);
			}
		}
	}
	/**
	 *  根据request获取参数 并判断 
	 */
	private String getParams(HttpServletRequest request) {
		//参数
		String allData = request.getParameter("allData");
		//分页查询
		String page = request.getParameter("page");
		
		String by = request.getParameter("by");
		String account =request.getParameter("account");
		String indexs = request.getParameter("indexs");
		String category = request.getParameter("category");
		
		String title = request.getParameter("title");
		System.err.println(by);
		//各种判断
		if (allData!=null && allData.equals("true")) {    //如果有allData参数就取出所有。。然后结束
			//得到所有数据
			return getSql();
		} else if (page != null) {
			//
			return getSql(Integer.parseInt(page));
		} else if (by != null) {  
			if (by.equals("and")) {
				return getSqlByAnd(account, indexs, category, title);
			} else if (by.equals("or")) {
				return getSqlByOr(account, indexs, category, title);
			} else {
				return "";
			}
		} else {
			return "";
		}
	}
	
	private String getSql() {
		return "select * from articles";
	}
	
	private String getSql(int page) {
		return "select * from articles order by time desc limit " + (page-1)*LATEST_COUNT  + ", " + page*LATEST_COUNT;
	}
	
	private String getSqlByAnd(String account, String indexs, String category, String title) {
		String sql = "select * from articles where ";
		if (account != null) {
			sql += ("account='" + account + "' and ");
		}
		if (indexs != null) {
			sql += ("indexs='" + indexs + "' and ");
		}
		if (category != null) {
			sql += ("category='" + category + "' and ");
		}
		if (title != null) {
			sql += ("title LIKE '%" + title + "%" + "' and ");
		}
		
		if (sql.endsWith(" and ")) {
			sql = sql.substring(0, sql.length() - 5);
		}
		
		return sql;
	}
	
	private String getSqlByOr(String account, String indexs, String category, String title) {
		String sql = "select * from articles where ";
		if (account != null) {
			sql += ("account='" + account + "' or ");
		}
		if (indexs != null) {
			sql += ("indexs='" + indexs + "' or ");
		}
		if (category != null) {
			sql += ("category='" + category + "' or ");
		}
		if (title != null) {
			sql += ("title LIKE '%" + title + "%" + "' or ");
		}
		//������'or'ȥ��
		if (sql.endsWith(" or ")) {
			sql = sql.substring(0, sql.length() - 4);
		}
		System.out.println("�ڷ���֮ǰ�Ҳ���sql  " + sql);
		return sql;
	}
	
	private ArrayList<Article> getAllArticles(String sql) {
		ConnDB connDB = new ConnDB();
		ArrayList<Article> articles = null;
		try {
			connDB.openConn();
			connDB.createStmt();
			articles = new ArrayList<Article>();
			ResultSet rs = connDB.Query(sql);
			while(rs.next()) {
				Article article = new Article()
					.setId(rs.getInt("id"))
					.setAccount(rs.getString("account"))
					.setIndexs(rs.getString("indexs"))
					.setTitle(rs.getString("title"))
					.setCategory(rs.getString("category"))
					.setTime(rs.getTimestamp("time"))
					.setMessage(rs.getString("message"))
					.setFormtext(rs.getString("formtext"));
				articles.add(article);
			}//while
			System.out.println("�õ��Ľ��Ϊ" + articles.toString());     //����ݻ�ȡ��û�������
			return articles;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			connDB.closeStmt();
			connDB.closeConn();
			System.out.println("finally" + "....");
		}
	}
	
	private String getJsonStr(ArrayList<Article> articles) {
		if (articles.size() > 0) {
			Gson gson = new GsonBuilder()  
			  .setDateFormat("yyyy-MM-dd HH:mm:ss")  
			  .create();  
			return gson.toJson(articles);
		}else {
			return null;
		}
		
	}
}
