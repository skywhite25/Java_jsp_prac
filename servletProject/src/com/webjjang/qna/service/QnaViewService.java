package com.webjjang.qna.service;

import com.webjjang.qna.dao.QnaDAO;
import com.webjjang.main.controller.Service;

public class QnaViewService implements Service{

	// dao가 필요하다. 밖에서 생성한 후  넣어준다. - 1.생성자, 2.setter()
	private QnaDAO dao;
	
	public QnaViewService() {
		System.out.println("QnaViewService.QnaViewService() - 질문답변 보기 객체 생성");
	}

	@Override
	public void setDAO(Object dao) {
		System.out.println("QnaViewService.setDAO().dao : " + dao);
		this.dao = (QnaDAO)dao;
	}
	
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		// 글보기와 글수정도 사용을 한다. 
        // 글보기(list->view)할 때는 조회수 1 증가를 해야햐고 글수정(update->view)은 하지 않는다.
		// ->> 데이터가 2개 넘어오게 된다.[글번호, 증가여부] 
		// obj[0] - no / obj[1] - increase
		Object[] objs = (Object[]) obj;
		Long no = (Long) objs[0];
		Long inc = (Long) objs[1];
		
		if(inc == 1) dao.increase(no);
		return dao.view(no);
	}

}
