package com.OOTD.image.service;


import com.OOTD.image.dao.ImageDAO;
import com.OOTD.image.vo.ImageReplyVO;
import com.OOTD.main.controller.Service;

public class ImageReplyDeleteService implements Service{
	
	// dao가 필요하다. 밖에서 생성한 후 넣어준다.
	// 1.생성자 2.setter()이용
	private ImageDAO dao;
	
	public void setDAO(Object dao) {
		this.dao = (ImageDAO) dao;
	}

	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.replyDelete((ImageReplyVO) obj);
	}
	
	
	
}
