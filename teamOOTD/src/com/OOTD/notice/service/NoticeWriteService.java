package com.OOTD.notice.service;

import com.OOTD.notice.dao.NoticeDAO;
import com.OOTD.notice.vo.NoticeVO;
import com.OOTD.main.controller.Service;

public class NoticeWriteService implements Service{

	// dao가 필요하다. 밖에서 생성한 후  넣어준다. - 1.생성자, 2.setter()
	private NoticeDAO dao;
	
	@Override
	public void setDAO(Object dao) {
		System.out.println("NoticeWriteService.setDAO().dao : " + dao);
		this.dao = (NoticeDAO)dao;
	}
	
	
	// url요청에 따른 처리
	// 넘어오는 데이터가 PageObject NoticeVO == > obj
	@Override
	public Object service(Object obj) throws Exception {
		// 넘어오는 데이터 확인
		System.out.println("NoticeWriteService.obj : " + obj);
		// 전체 페이지 셋팅 후 페이지 객체 출력
		System.out.println("NoticeWriteService.obj : " + obj);
		return dao.write((NoticeVO) obj);
	}

}
