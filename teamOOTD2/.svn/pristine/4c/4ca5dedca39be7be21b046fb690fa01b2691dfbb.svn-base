package com.OOTD.image.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.OOTD.image.vo.ImageVO;
import com.OOTD.main.controller.Beans;
import com.OOTD.main.controller.Controller;
import com.OOTD.main.controller.ExeService;
import com.OOTD.util.PageObject;
import com.OOTD.util.filter.AuthorityFilter;


public class ImageController implements Controller{

	private final String MODULE = "image";
	private String jspInfo = null;
	
	@Override
	public String execute(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ImageController.execute() 실행 중-----------------------------------------------------------");
		
		// 페이지를 위한 처리
		PageObject pageObject = PageObject.getInstance(request);
		request.setAttribute("pageObject", pageObject);
		
		switch (AuthorityFilter.url) {
		case "/" + MODULE + "/list.do":
			list(request, pageObject);
			jspInfo = MODULE + "/list";
			break;

		default:
			break;
		}
		
		return jspInfo;
	}
	
	// 1. 이미지 게시판 리스트 처리
	private void list(HttpServletRequest request, PageObject pageObject) throws Exception {
		// DB에서 데이터 가져오기
		@SuppressWarnings("unchecked")
		List<ImageVO> list = (List<ImageVO>) ExeService.execute(Beans.getService(AuthorityFilter.url), pageObject);
		// 가져온 데이터 서버 객체에 담기 - list를 서버객체에 넣어준다.
		request.setAttribute("list", list);
		
	}
	
	
	
}
