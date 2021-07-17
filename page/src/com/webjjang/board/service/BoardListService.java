package com.webjjang.board.service;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.main.controller.Service;
import com.webjjang.util.PageObject;

public class BoardListService implements Service{
	
	private BoardDAO dao;
	
	// 서비스를 실행하는 메소드
	// PageObject가 넘어온다(obj) -> 넘어오는 PageObject에 전체 데이터의 갯수를 셋팅 - dao
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		PageObject pageObject = (PageObject) obj;
		pageObject.setTotalRow(dao.getTotalRow());
		return dao.list(pageObject);
	}

	// dao를 셋팅하는 메소드
	@Override
	public void setDAO(Object dao) {
		// TODO Auto-generated method stub
		this.dao = (BoardDAO) dao;
	}

	
}
