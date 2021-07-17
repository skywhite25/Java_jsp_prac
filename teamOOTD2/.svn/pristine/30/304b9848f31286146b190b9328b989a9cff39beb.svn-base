package com.OOTD.like.controller;

import javax.servlet.http.HttpServletRequest;

import com.OOTD.like.vo.LikeVO;
import com.OOTD.main.controller.Beans;
import com.OOTD.main.controller.Controller;
import com.OOTD.main.controller.ExeService;
import com.OOTD.util.filter.AuthorityFilter;

public class TimeLikeController implements Controller {


	private final String MODULE = "like"; 
	private String jspInfo = null;
	
	public String execute(HttpServletRequest request)throws Exception{
		System.out.println("TimeLikeController.execute()_실행");
		
		switch (AuthorityFilter.url) {
		
		//1-1.타임라인 게시판 좋아요 보기 
		case "/" + MODULE + "/timeView.do":
			System.out.println("url:" + AuthorityFilter.url);
			timeView(request); //아래 request처리 담기 
			System.out.println("timeLikeCoontroller[query] : " + request.getQueryString());
			jspInfo = MODULE + "/timeView";
			System.out.println(jspInfo);
			break;
		
		//1-2.타임라인 게시판 좋아요 클릭
		case "/" + MODULE + "/timeLike.do":
			System.out.println("url:" + AuthorityFilter.url);
			timeLike(request);
			System.out.println("timeLikeCoontroller[query] : " + request.getQueryString());
			jspInfo = MODULE + "/timeLike";
			System.out.println(jspInfo);
			break;
			
		//1-2.타임라인 게시판 좋아요 취소
		case "/" + MODULE + "/timeDelete.do":
			System.out.println("url:" + AuthorityFilter.url);
			timeDelete(request);
			System.out.println("timeLikeCoontroller[query] : " + request.getQueryString());
			jspInfo = MODULE + "/timeDelete";
			System.out.println(jspInfo);
			break;
			
		default:
			throw new Exception("타임라인 좋아요 처리 오류 ");
		}
		return jspInfo;
	}
	
	//1-1.타임라인 좋아요 보기 
	private void timeView(HttpServletRequest request)throws Exception{
		
		String strNo = request.getParameter("no");
		String id = "admin";
		
		LikeVO vo = new LikeVO();
		vo.setNo(Long.parseLong(strNo));
		vo.setId(id);
		LikeVO likevo = (LikeVO)ExeService.execute(Beans.getService(AuthorityFilter.url), vo);
	}
	
	//1-2.패션 좋아요 클릭
	private void timeLike(HttpServletRequest request)throws Exception{
		
		String strNo = request.getParameter("no");
		String id = "admin";
		
		LikeVO vo = new LikeVO();
		vo.setNo(Long.parseLong(strNo));
		vo.setId(id);
		ExeService.execute(Beans.getService(AuthorityFilter.url), vo);
		
	}
	
	//1-3.패션 좋아요 취소
	private void timeDelete(HttpServletRequest request)throws Exception{
		
		String strNo = request.getParameter("no");
		
		LikeVO vo = new LikeVO();
		vo.setNo(Long.parseLong(strNo));
		
		ExeService.execute(Beans.getService(AuthorityFilter.url), vo);
	}
	
}
