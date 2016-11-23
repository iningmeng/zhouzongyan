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
import com.sun.org.apache.bcel.internal.generic.NEW;

import com.inm.entity.Article;
import com.inm.entity.QueryArticleResult;
import com.inm.db.ConnDB;

import com.inm.util.CharacterUtil;

/**
 * Servlet implementation class QueryTitleByAccount
 */
public class QueryTitleByAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public QueryTitleByAccount() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = CharacterUtil.urlChineseStr(request.getParameter("account"));
		if (account != null) {
			judgeResult(request, response, getTitleByAccount(account));
		} else {
			judgeResult(request, response, null);
		}
	}
	private void judgeResult(HttpServletRequest request, HttpServletResponse response, ArrayList<Article> list) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (list != null) {
			if (list.size() == 0) {
				list2Json(out, new QueryArticleResult(list, "根据账号查询他所评论的博客的标题..没有数据", 10010));
			} else {
				list2Json(out, new QueryArticleResult(list, "articles获取成功", 10011));
			}
		} else {
			list2Json(out, new QueryArticleResult(list, "根据账号查询他所评论的博客的标题..失败!!", 10012));
		}
	}
	private void list2Json(PrintWriter out, QueryArticleResult result) {
		System.err.println(result);
		out.println(new Gson().toJson(result));
	}
	private String getSql(String account) {
		return"select * from articles " + 
				   "where indexs = ("       +
				        "select indexs "    +
				        "from comments "    +
				        "where account='"   + account +"')";
	}
	private ArrayList<Article> getTitleByAccount(String account) {
		ArrayList<Article> articles = new ArrayList<Article>();
		String sql = getSql(account);
		ConnDB connDB = new ConnDB();
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
					.setMessage(rs.getString("message"));
				articles.add(article);
			}//while
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
}
