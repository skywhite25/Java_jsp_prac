package com.webjjang.board1.service;

import com.webjjang.board1.dao.BoardDAO;
import com.webjjang.main.controller.Service;

public class BoardListService implements Service{
	
	BoardDAO dao;
	
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	public void setDAO(Object dao) {
		// TODO Auto-generated method stub
		this.dao = (BoardDAO) dao;
		
	}

}
