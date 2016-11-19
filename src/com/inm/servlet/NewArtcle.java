package com.inm.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.inm.db.ConnDB;
import com.inm.entity.Article;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class NewArtcle extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
		StringBuffer sb = new StringBuffer();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String temp = null;
		String sql = null;
		while ((temp = bReader.readLine()) != null) {
			sb.append(temp);
		}
		bReader.close();
		Gson gson = new Gson();
		Article article = new Article();
		article = gson.fromJson(sb.toString(), Article.class);
		ConnDB connDB = new ConnDB();
		try {
			connDB.openConn();
			Statement stmt = connDB.getConn().createStatement();
			sql = "insert into artcles values(null,1,'"+UUID.randomUUID()+"','"+article.getTitle()+"','"+article.getCategory()+format.format(new Date())+"','"+article.getMessage()+"')";
			stmt.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
