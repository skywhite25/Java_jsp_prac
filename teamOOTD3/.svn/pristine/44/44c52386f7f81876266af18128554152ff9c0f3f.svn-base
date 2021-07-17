package com.OOTD.notice.service;

import com.OOTD.main.controller.Service;
import com.OOTD.notice.dao.NoticeDAO;

public class NoticeDeleteService implements Service{

	// dao가 필요하다. 밖에서 생성한 후  넣어준다. - 1.생성자, 2.setter()
	NoticeDAO dao = new NoticeDAO();
	
	@Override
	public void setDAO(Object dao) {
		this.dao = (NoticeDAO)dao;
		System.out.println("NoticeDeleteService.dao : " + dao);
	}
	
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NoticeDeleteService.obj : " + obj);
		return dao.delete((Long) obj);
	}

}
