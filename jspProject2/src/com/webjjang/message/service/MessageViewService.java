package com.webjjang.message.service;

import com.webjjang.main.controller.Service;
import com.webjjang.message.dao.MessageDAO;
import com.webjjang.message.vo.MessageVO;

public class MessageViewService implements Service{

	// dao가 필요하다. 밖에서 생성한 후  넣어준다. - 1.생성자, 2.setter()
	private MessageDAO dao;

	public MessageViewService() {
		// 서버가 시작될 때 확인한다.
		// TODO Auto-generated constructor stub
		System.out.println("MessageViewService.MessageWriteService() - 생성 완료 ");
	}
	
	
	@Override
	// 넘어오는 데이터 : MessageVO => obj : no, accepter
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MessageViewService.obj : " + obj);
		// 메시지 읽음 처리
		MessageVO vo = (MessageVO) obj;
		dao.viewUpdateReaded(vo);
		// 글보기 vo 데이터를 가져와서 넘겨준다.
		return dao.view(vo.getNo());
	}
	@Override
	public void setDAO(Object dao) {
		// 서버가 시작될 때 확인한다.
		// TODO Auto-generated method stub
		System.out.println("MessageViewService.service().dao : " + dao);
		this.dao = (MessageDAO) dao;
	}

}
