package com.inm.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inm.util.C;

public class LoginFilter implements Filter {
	private static final String TAG = "LoginFilter\t";
	//login.jsp�����·��
	public static final String login_page = "./login.jsp";
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		/**
		 * eg:·����http://localhost:8080/Blog_Project/login.jsp
		 * 		target: /login.jsp
		 */
		String currentURL = request.getRequestURI();
		String ctxPath = request.getContextPath();
		//�����Ŀ���ʱ����ҳ�浱ǰ·��
//		String targetURL = currentURL.substring(ctxPath.length());
		String targetURL = request.getServletPath();
		System.out.println(TAG +"servlet·��" + targetURL);
		//��¼ҳ���û�б�Ҫ������
		if ( ! isNeedLoginedPage(targetURL)) {
			//��������
			filterChain.doFilter(request, response);
			return;
		} else {
			if(getCookies(request) != null) {
				//�ѵ�¼״̬ �Ͳ���������~
				filterChain.doFilter(request, response);
				return;
			} else {
				//��δ��¼�� ��ת����¼ҳ��
				response.sendRedirect(login_page + "?msg=31");
			}
			return;
		}
	}
	/**
	 * �ж��Ƿ�����Ҫ�жϵ�¼���ܷ��ʵ�ҳ��
	 * @return
	 */
	private boolean isNeedLoginedPage(String targetURL) {
		ArrayList<String> list = C.getLoginedJsp();
		for (String jsp : list) {
			if (jsp.equals(targetURL)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * ���Cookies�ж��Ƿ��¼
	 * @param request
	 * @return
	 */
	private String getCookies(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies!=null) {
			for(int i = 0; i < cookies.length; i ++) {
				Cookie cookie = cookies[i];
				String name = cookie.getName();
				String value = cookie.getValue();
				if (name.equals(C.USERS)) {
					System.out.println(TAG + "cookies_value.." + value);
					return value;
				}
			}
			System.out.println(TAG + "cookies_value...null");
			return null;
		}
		return null;
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
