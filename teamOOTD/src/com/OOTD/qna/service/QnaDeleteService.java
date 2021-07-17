package com.OOTD.qna.service;

import com.OOTD.qna.dao.QnaDAO;
import com.OOTD.main.controller.Service;

public class QnaDeleteService implements Service{

	private QnaDAO dao;
	
	public QnaDeleteService() {
		System.out.println("QnaDeleteService.QnaDeleteService() - 질문답변보기 객체 생성");
	}

	@Override
	public void setDAO(Object dao) {
		System.out.println("QnaDeleteService.setDAO().dao : " + dao);
		this.dao = (QnaDAO) dao;
	}
	
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.delete((Long) obj);
	}

}
