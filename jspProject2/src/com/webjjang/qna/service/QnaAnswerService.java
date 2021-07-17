package com.webjjang.qna.service;

import com.webjjang.qna.dao.QnaDAO;
import com.webjjang.qna.vo.QnaVO;
import com.webjjang.main.controller.Service;

public class QnaAnswerService implements  Service{

	// dao가 필요하다. 밖에서 생성한 후  넣어준다. - 1.생성자, 2.setter()
	QnaDAO dao;
	
	// 기본 생성자 만들기 -> 확인 시 필요하다.
	public QnaAnswerService() {
		System.out.println("QnaAnswerService.QnaAnswerService() - 생성완료");
	}
	
	@Override
	public void setDAO(Object dao) {
		System.out.println("QnaAnswerService.setDAO().dao : " + dao);
		this.dao = (QnaDAO)dao;
	}
	
	
	// url요청에 따른 처리
	// 넘어오는 데이터가 QnaVO ==> obj
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		// 넘어오는 데이터 확인
		System.out.println("QnaAnswerService.obj : " + obj);
		// 전체데이터를 가져오기
		// 넘어오는 obj가 object타입으로 넘어오지만 PageObject가 들어있어서 PageObject를 캐스팅해서 사용한다.
		// 전체 페이지 셋팅 후 페이지 객체 출력
		dao.ordNoIncrease((QnaVO) obj); // 순서번호에 맞는 자리를 비워놓는다.
		return dao.answer((QnaVO) obj);
	}
}