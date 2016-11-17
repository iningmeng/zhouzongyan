package com.inm.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@MultipartConfig

public class UploadImg extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 response.setContentType("textml;charset=UTF-8");
	        request.setCharacterEncoding("UTF-8");
	        Part part = request.getPart("uploadImg");// myFileName是文件域的name属性值
	        // 文件类型限制
	        String[] allowedType = { "image/bmp", "image/gif", "image/jpeg", "image/png" };
	        boolean allowed = Arrays.asList(allowedType).contains(part.getContentType());
	        if (!allowed) {
	            response.getWriter().write("error|不支持的类型");
	            return;
	        }
	        // 图片大小限制
	        if (part.getSize() > 5 * 1024 * 1024) {
	            response.getWriter().write("error|图片大小不能超过5M");
	            return;
	        }
	        // 包含原始文件名的字符串
	        String fi = part.getHeader("content-disposition");
	        // 提取文件拓展名
	        String fileNameExtension = fi.substring(fi.indexOf("."), fi.length() - 1);
	        // 生成实际存储的真实文件名
	        String realName = UUID.randomUUID().toString() + fileNameExtension;
	        // 图片存放的真实路径
	        File file = new File(getServletContext().getRealPath("/upload"));
	        if (!file.exists()) {
				file.mkdir();
			}
	        String realPath = getServletContext().getRealPath("/upload") + "/" + realName;
	        // 将文件写入指定路径下
	        part.write(realPath);

	        // 返回图片的URL地址
	        response.getWriter().write(request.getContextPath() + "/upload/" + realName);
	        System.err.println(getServletContext());
	}

}
