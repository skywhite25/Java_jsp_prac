package com.OOTD.main.controller;

import javax.servlet.http.HttpServletRequest;

import com.OOTD.util.filter.AuthorityFilter;

public class MainController implements Controller {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
		String jspInfo = null;
		switch(AuthorityFilter.url) {
		case "/main.do" : // 실제적으로 localhost로 입력한 결과
			jspInfo = "redirect:/main/main.do";
			break;
			
		case "/main/main.do":
			list(request);
			jspInfo = "main/main";
			
			break;
			
		default:
			throw new Exception("MainController - 페이지오류 404 - 존재하지 않는 페이지입니다.");
		}
		
		return jspInfo;
	}

	private void list(HttpServletRequest request) throws Exception{
		// TODO Auto-generated method stub
		
	}

	
}
