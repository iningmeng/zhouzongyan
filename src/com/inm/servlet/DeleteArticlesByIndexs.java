package com.inm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.inm.db.*;

public class DeleteArticlesByIndexs extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteArticlesByIndexs() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String indexs = request.getParameter("indexs");
		deleteArticle(indexs);
		String sql = "delete from articles where indexs='" + indexs + "'";
		deleteArticle(sql);
	}
	private int deleteArticle(String sql) {
		int result = 0;
		ConnDB connDB = new ConnDB();
		try {
			connDB.openConn();
			connDB.createStmt();
			result = connDB.Update(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connDB.closeStmt();
			connDB.closeConn();
			System.out.println(result);
		}
		return result;
	}
}
