package com.webjjang.notice2.service;

import com.webjjang.main.controller.Service;
import com.webjjang.notice2.dao.NoticeDAO;
import com.webjjang.notice2.vo.NoticeVO;

public class NoticeWriteService implements Service{

	// dao가 필요하다. 밖에서 생성한 후 넣어준다. - 1. 생성자 2. setter()
	private NoticeDAO dao;
	
	@Override
	public void setDAO(Object dao) {
		this.dao = (NoticeDAO) dao;
	}
	@Override
	public Object service(Object obj) throws Exception {
		return dao.write((NoticeVO) obj);
	}

}
