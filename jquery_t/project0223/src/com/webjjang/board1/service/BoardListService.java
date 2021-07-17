package com.webjjang.board1.service;

import com.webjjang.board1.dao.BoardDAO1;
import com.webjjang.main.controller.Service;

public class BoardListService implements Service {

	private BoardDAO1 dao;
	
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		// NullPointerException이 발생되는 이유?
		// dao가 Null일 수도 있다. 그러나 list()를 호출할수 없어서 NullPointerException이 발생된다.
		// setDAO에 의해서 dao를 넣는데 이상이 생겼다. -> Init.init()를 가서 봐야 한다.
		return dao.list();
	}

	@Override
	public void setDAO(Object dao) {
		// TODO Auto-generated method stub
		this.dao = (BoardDAO1) dao;
	}

}
