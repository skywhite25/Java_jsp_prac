package com.webjjang.notice1.service;

import com.webjjang.main.controller.Service;
import com.webjjang.notice1.dao.NoticeDAO;


public class NoticeListService implements Service{

	NoticeDAO dao = new NoticeDAO();
	
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	public void setDAO(Object dao) {
		this.dao=(NoticeDAO)dao;
		
	}

}
