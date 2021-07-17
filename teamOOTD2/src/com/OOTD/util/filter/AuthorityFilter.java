package com.OOTD.util.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AuthorityFilter
 */
//@WebServlet("/AuthorityFilter")
public class AuthorityFilter implements Filter {
	
	//url에 대한 권한 정보를 저장하는 MAP
	private static Map<String, Integer> authMap = new HashMap<>();
	
	//요청한 URL 설정 
	public static String url;
	
	 /**
     * Default constructor. 
     */
    public AuthorityFilter() {
        // TODO Auto-generated constructor stub
    }
	
    
    /**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		// TODO Auto-generated method stub
		System.out.println("Authority.dofilter : 권한처리");
	
		url = req.getServletPath();
		System.out.println("Authority.dofilter.url : " + url);
		
		

		//로그인 객체 꺼내기
		//로그인 정보는  session에 있는데 안보일 경우 -> request 에서 꺼낼 수 있음
		HttpSession session = req.getSession();
//		LoginVO vo = (LoginVO)session.getAttribute("login");
		

		// pass the request along the filter chain
		chain.doFilter(request, response);
		

	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
