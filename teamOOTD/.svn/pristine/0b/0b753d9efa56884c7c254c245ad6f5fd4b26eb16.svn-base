package com.OOTD.qna.service;

import com.OOTD.qna.dao.QnaDAO;
import com.OOTD.main.controller.Service;

public class QnaViewService implements Service{

	//dao가 필요하다. 밖에서 생성한 후 넣어준다. - 1. 생성자. 2. setter()
	private QnaDAO dao;
	
	public QnaViewService() {
		System.out.println("QnaViewService.QnaViewService() - 질문답변보기 객체 생성");
	}

	@Override
	public void setDAO(Object dao) {
		System.out.println("QnaViewService.setDAO().dao : " + dao);
		this.dao = (QnaDAO) dao;
	}
	
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		Object[] objs = (Object[]) obj;
		Long no = (Long) objs[0];
		
		return dao.view(no);
	}

}
