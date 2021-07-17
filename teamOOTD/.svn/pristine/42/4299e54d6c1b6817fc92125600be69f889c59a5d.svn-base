package com.OOTD.like.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.OOTD.like.vo.LikeVO;
import com.OOTD.main.controller.Beans;
import com.OOTD.main.controller.Controller;
import com.OOTD.main.controller.ExeService;
import com.OOTD.member.vo.LoginVO;
import com.OOTD.util.filter.AuthorityFilter;

public class TimeLikeController implements Controller {

	private HttpSession session = null;
	private LoginVO loginVO = null;
	private String id = null; 
	
	private final String MODULE = "like2"; 
	private String jspInfo = null;
	
	public String execute(HttpServletRequest request)throws Exception{
		System.out.println(" TimeLineLikeController.execute()_실행");
		
		// 세션과 아이디 저장
		session = request.getSession();
		loginVO = (LoginVO) session.getAttribute("login");
		if(loginVO != null)
			id = loginVO.getId();
		
		switch (AuthorityFilter.url) {
		
		//1-1.타임라인 게시판 좋아요 보기 
		case "/" + MODULE + "/timeView.do":
			System.out.println("url:" + AuthorityFilter.url);
			timeView(request); //아래 request처리 담기 
			System.out.println("TimeLikeController[query] : " + request.getQueryString());
			jspInfo = MODULE + "/timeView";
			System.out.println(jspInfo);
			break;
		
		//1-2.타임라인 게시판 좋아요 클릭
		case "/" + MODULE + "/timeLike.do":
			System.out.println("url:" + AuthorityFilter.url);
			timeLike(request);
			jspInfo = "redirect:/timeline/view.do?" + request.getQueryString();
			
			break;
			
		//1-3.타임라인 게시판 좋아요 취소
		case "/" + MODULE + "/timeDelete.do":
			System.out.println("url:" + AuthorityFilter.url);
			timeDelete(request);
			jspInfo = "redirect:/timeline/view.do?" + request.getQueryString();
			
			break;
			
		default:
			throw new Exception("타임라인 좋아요 처리 오류 ");
		}
		return jspInfo;
	}
	
	//1-1.타임라인 좋아요 보기 
	private void timeView(HttpServletRequest request)throws Exception{
		System.out.println("TimeLikeController");
		String strNo = request.getParameter("no");
		LikeVO vo = new LikeVO();
		vo.setNo(Long.parseLong(strNo));
		vo.setId(id);
		LikeVO likevo = (LikeVO)ExeService.execute(Beans.getService(AuthorityFilter.url), vo);
		request.setAttribute("likevo", likevo);
	}
	
	//1-2.타임라인 좋아요 클릭
	private void timeLike(HttpServletRequest request)throws Exception{
		
		String strNo = request.getParameter("no");
		LikeVO vo = new LikeVO();
		vo.setNo(Long.parseLong(strNo));
		vo.setId(id);
		ExeService.execute(Beans.getService(AuthorityFilter.url), vo);
		
	}
	
	//1-3.타임라인 좋아요 취소
	private void timeDelete(HttpServletRequest request)throws Exception{
		
		String strNo = request.getParameter("no");
		System.out.println(strNo);
		System.out.println(request.getParameter("likeCnt"));
		LikeVO vo = new LikeVO();
		vo.setNo(Long.parseLong(strNo));
		vo.setId(id);
		
		ExeService.execute(Beans.getService(AuthorityFilter.url), vo);
	}
	
}
