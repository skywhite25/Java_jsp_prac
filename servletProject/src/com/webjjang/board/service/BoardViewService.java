package com.webjjang.board.service;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.main.controller.Service;

public class BoardViewService implements Service{

	// dao가 필요하다. 밖에서 생성한 후  넣어준다. - 1.생성자, 2.setter()
	private BoardDAO dao;
	
	@Override
	public void setDAO(Object dao) {
		this.dao = (BoardDAO)dao;
	}
	
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		// 글보기와 글수정도 사용을 한다. 
        // 글보기(list->view)할 때는 조회수 1 증가를 해야햐고 글수정(update->view)은 하지 않는다.
		// ->> 데이터가 2개 넘어오게 된다.(클래스, 배열(o)) 
		// obj[0] - no / obj[1] - increase
		Object[] objs = (Object[]) obj;
		Long no = (Long) objs[0];
		Long inc = (Long) objs[1];
		
		if(inc == 1) dao.increase(no);
		return dao.view(no);
	}

}
