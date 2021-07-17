package com.OOTD.image.service;

import com.OOTD.image.dao.ImageDAO;
import com.OOTD.image.vo.ImageReplyVO;
import com.OOTD.main.controller.Service;

public class ImageReplyWriteService implements Service {

	ImageDAO dao;
	
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.replyWrite((ImageReplyVO) obj);
	}

	@Override
	public void setDAO(Object dao) {
		// TODO Auto-generated method stub
		System.out.println("ImageReplyWriteService.setDAO().dao : " + dao);
		this.dao = (ImageDAO) dao;
		
	}
	
	
}
