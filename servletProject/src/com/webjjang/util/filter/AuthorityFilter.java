package com.webjjang.util.filter;

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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webjjang.member.vo.LoginVO;
//import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class AuthorityFilter
 */
//@WebFilter("/AuthorityFilter")
public class AuthorityFilter implements Filter {

	// url에 대한 권한 정보를 저장하는 Map
	// Map<url, gradeNo>
	private static Map<String, Integer> authMap = new HashMap<>();
	
	// 페이지에 대한 등급 정보를 저장하는 메소드
	// 데이터를 넣는 방법 : static 초기화 블록
	// 서버가 로딩될때 정해져야한다. Init.init()에서 처리를 해준다.
	static {
		// 공지사항 - 등록, 수정, 삭제 - 관리자 : 9 -> 관리자만 가능
		authMap.put("/notice/writeForm.do", 9);
		authMap.put("/notice/write.do", 9);
		authMap.put("/notice/updateForm.do", 9);
		authMap.put("/notice/update.do", 9);
		authMap.put("/notice/delete.do", 9);
		authMap.put("/notice/view.do", 1);
		// 질문답변 - 리스트, 질문하기, 답변하기, 수정, 삭제 : 1 -> 일반회원도 답변이 가능
//		authMap.put("/qna/list.do", 1);
		authMap.put("/qna/view.do", 1);
		authMap.put("/qna/questionForm.do", 1);
		authMap.put("/qna/question.do", 1);
		authMap.put("/qna/answerForm.do", 1);
		authMap.put("/qna/answer.do", 1);
		authMap.put("/qna/updateForm.do", 1);
		authMap.put("/qna/update.do", 1);
		authMap.put("/qna/delete.do", 1);
		// 메시지 - 리스트, 보기, 보내기, 삭제 : 1 -> 일반회원도 답변이 가능
		authMap.put("/message/list.do", 1);
		authMap.put("/message/view.do", 1);
		authMap.put("/message/write.do", 1);
		authMap.put("/message/writeForm.do", 1);
		authMap.put("/message/delete.do", 1);
		// 이미지게시판 - 등록, 수정, 삭제 - 회원 : 1 -> 회원만 가능
		authMap.put("/image/writeForm.do", 1);
		authMap.put("/image/write.do", 1);
		authMap.put("/image/updateForm.do", 1);
		authMap.put("/image/update.do", 1);
		authMap.put("/image/updateFile.do", 1);
		authMap.put("/image/delete.do", 1);
		// 내정보보기
		authMap.put("/member/view.do", 1);
		
	}
	
	// 요청한 url
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		// 전처리 - 권한 체크 프로그램
		System.out.println("Authority.doFilter - 권한 처리를 한다.");
		// do의 request와 여기에 request는 같은 것이다. HTTPServletRequest가 상속을 하고있다.
		url = req.getServletPath();
		System.out.println("Authority.doFilter.url : " + url);
		
		// 로그인 객체 꺼내기
		// 로그인 정보는 session에 있다. 하지만 session이 보이지 않는다. request에서 꺼낼 수 있다.
		HttpSession session = req.getSession();
		LoginVO vo = (LoginVO) session.getAttribute("login");
		
		// 권한이 없는 경우의 처리
		if(!checkAuthority(vo)) {
			// 오류페이지로 이동시킨다.
			((HttpServletResponse)response)
			.sendRedirect(req.getContextPath() + "/error/auth_error.do");
			// 호출한 쪽으로 되돌아간다. - 없으면 계속 아래로 실행이 된다.
			return;
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
	
	private boolean checkAuthority(LoginVO vo) {
		// url 정보가 authMap에 있는지 확인한다.
		// 데이터가 없으면(null이면) 권한체크가 필요없는 페이지 요청이다.
		Integer pageGradeNo = authMap.get(url);
		if(pageGradeNo == null) {
			System.out.println("AuthorityFilter.checkAuthority() - 권한이 필요없는 페이지 입니다.");
			return true;
		}
		// 여기서 부터는 로그인이 필요한 처리. vo가 null이면 안된다.
		if(vo == null) {
			System.out.println("AuthorityFilter.checkAuthority() - 로그인이 필요합니다.");
			return false;
		}
		System.out.println("AuthorityFilter.checkAuthority().pageGradeNo : " + pageGradeNo);
		System.out.println("AuthorityFilter.checkAuthority().userGradeNo : " + vo.getGradeNo());
		// 권한이 없는 페이지요청에 대한 처리
		if(pageGradeNo > vo.getGradeNo()) {
			System.out.println("AuthorityFilter.checkAuthority() - 권한이 없습니다.");
			return false;
		}
		System.out.println("AuthorityFilter.checkAuthority() - 권한이 있습니다.");
		return true;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
