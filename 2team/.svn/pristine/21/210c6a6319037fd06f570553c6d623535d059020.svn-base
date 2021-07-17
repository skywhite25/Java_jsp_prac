package com.webjjang.board1.service;

import com.webjjang.board1.dao.BoardDAO;
import com.webjjang.board1.vo.BoardVO;
import com.webjjang.main.controller.Service;

public class BoardWriteService implements Service{

	BoardDAO dao;
	
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.write((BoardVO) obj);
	}

	@Override
	public void setDAO(Object dao) {
		// TODO Auto-generated method stub
		this.dao = (BoardDAO) dao;
	}

	
}
