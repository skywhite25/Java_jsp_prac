package com.OOTD.like.controller;

import javax.servlet.http.HttpServletRequest;

import com.OOTD.like.vo.LikeVO;
import com.OOTD.main.controller.Beans;
import com.OOTD.main.controller.Controller;
import com.OOTD.main.controller.ExeService;
import com.OOTD.util.filter.AuthorityFilter;

public class FashionLikeController implements Controller {


	private final String MODULE = "like"; 
	private String jspInfo = null;
	
	public String execute(HttpServletRequest request)throws Exception{
		System.out.println(" FashionLikeController.execute()_실행");
		
		switch (AuthorityFilter.url) {
		
		//1-1.패션 게시판 좋아요 보기 
		case "/" + MODULE + "/fashionView.do":
			System.out.println("url:" + AuthorityFilter.url);
			fashionView(request); //아래 request처리 담기 
			System.out.println("FashionLikeCoontroller[query] : " + request.getQueryString());
			jspInfo = MODULE + "/fashionView";
			System.out.println(jspInfo);
			break;
		
		//1-2.패션 게시판 좋아요 클릭
		case "/" + MODULE + "/fashionLike.do":
			System.out.println("url:" + AuthorityFilter.url);
			fashionLike(request);
			System.out.println("FashionLikeCoontroller[query] : " + request.getQueryString());
			jspInfo = MODULE + "/fashionLike";
			System.out.println(jspInfo);
			break;
			
		//1-2.패션 게시판 좋아요 취소
		case "/" + MODULE + "/fashionDelete.do":
			System.out.println("url:" + AuthorityFilter.url);
			fashionDelete(request);
			System.out.println("FashionLikeCoontroller[query] : " + request.getQueryString());
			jspInfo = MODULE + "/fashionDelete";
			System.out.println(jspInfo);
			break;
			
		default:
			throw new Exception("좋아요 처리 오류 ");
		}
		return jspInfo;
	}
	
	//1-1.패션 좋아요 보기 
	private void fashionView(HttpServletRequest request)throws Exception{
		
		String strNo = request.getParameter("no");
		String id = "admin";
		
		LikeVO vo = new LikeVO();
		vo.setNo(Long.parseLong(strNo));
		vo.setId(id);
		LikeVO likevo = (LikeVO)ExeService.execute(Beans.getService(AuthorityFilter.url), vo);
		request.setAttribute("likevo", likevo);
	}
	
	//1-2.패션 좋아요 클릭
	private void fashionLike(HttpServletRequest request)throws Exception{
		
		String strNo = request.getParameter("no");
		String id = "admin";
		
		LikeVO vo = new LikeVO();
		vo.setNo(Long.parseLong(strNo));
		vo.setId(id);
		ExeService.execute(Beans.getService(AuthorityFilter.url), vo);
		
	}
	
	//1-3.패션 좋아요 취소
	private void fashionDelete(HttpServletRequest request)throws Exception{
		
		String strNo = request.getParameter("no");
		
		LikeVO vo = new LikeVO();
		vo.setNo(Long.parseLong(strNo));
		
		ExeService.execute(Beans.getService(AuthorityFilter.url), vo);
	}
	
}
