package com.webjjang.board3.service;

import com.webjjang.board3.dao.BoardDAO;
import com.webjjang.board3.vo.BoardVO;
import com.webjjang.main.controller.Service;

public class BoardWriteService implements  Service{

	// dao가 필요하다. 밖에서 생성한 후  넣어준다. - 1.생성자, 2.setter()
	private BoardDAO dao;
	
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.write((BoardVO) obj);
	}
	@Override
	public void setDAO(Object dao) {
		this.dao = (BoardDAO)dao;
	}
	

}
