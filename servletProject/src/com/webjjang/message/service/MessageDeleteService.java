package com.webjjang.message.service;

import com.webjjang.main.controller.Service;
import com.webjjang.message.dao.MessageDAO;

public class MessageDeleteService implements  Service{

	// dao가 필요하다. 밖에서 생성한 후  넣어준다. - 1.생성자, 2.setter()
	MessageDAO dao = new MessageDAO();
	
	public MessageDeleteService() {
		System.out.println("MessageDeleteService.MessageDeleteService() - 생성완료");
	}
	
	@Override
	public void setDAO(Object dao) {
		this.dao = (MessageDAO)dao;
	}
	
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.delete((Long) obj);
	}

}
