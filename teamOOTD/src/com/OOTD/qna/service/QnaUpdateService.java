package com.OOTD.qna.service;

import com.OOTD.qna.dao.QnaDAO;
import com.OOTD.qna.vo.QnaVO;
import com.OOTD.main.controller.Service;

public class QnaUpdateService implements Service{

QnaDAO dao;

	public QnaUpdateService() {
		// TODO Auto-generated constructor stub
		System.out.println("QnaUpdateService.QnaUpdateService() - 생성 완료");
	}
	
	@Override
	public void setDAO(Object dao) {
		System.out.println("QnaUpdateService.setDAO().dao : " + dao);
		this.dao = (QnaDAO) dao;
	}

	@Override
	public Object service(Object obj) throws Exception {

		System.out.println("QnaUpdateService.obj : " + obj);
		return dao.update((QnaVO) obj);
	}

}
