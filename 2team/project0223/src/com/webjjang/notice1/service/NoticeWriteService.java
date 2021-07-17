package com.webjjang.notice1.service;

import com.webjjang.main.controller.Service;
import com.webjjang.notice1.dao.NoticeDAO;
import com.webjjang.notice1.vo.NoticeVO;


public class NoticeWriteService implements Service {

	
	private NoticeDAO dao;
	
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.write((NoticeVO)obj);
	}

	@Override
	public void setDAO(Object dao) {
		// TODO Auto-generated method stub
		this.dao =(NoticeDAO) dao;
	}

}
