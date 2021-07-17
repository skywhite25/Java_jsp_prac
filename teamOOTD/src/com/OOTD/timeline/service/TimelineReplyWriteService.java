package com.OOTD.timeline.service;

import com.OOTD.main.controller.Service;
import com.OOTD.timeline.dao.TimelineDAO;
import com.OOTD.timeline.vo.TimelineReplyVO;

public class TimelineReplyWriteService implements Service{

	//dao가 필요하다. 밖에서 생성한 후 넣어준다. - 1. 생성자. 2. setter()
	private TimelineDAO dao;
	
	@Override
	public void setDAO(Object dao) {
		System.out.println("TimelineReplyWriteService.setDAO().doa : " + dao);
		this.dao = (TimelineDAO) dao;
	}
	
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.replyWrite((TimelineReplyVO) obj);
	}

}
