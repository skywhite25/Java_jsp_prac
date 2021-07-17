package com.OOTD.notice.service;

import com.OOTD.main.controller.Service;
import com.OOTD.notice.dao.NoticeDAO;

public class NoticeViewService implements Service{

	// dao가 필요하다. 밖에서 생성한 후  넣어준다. - 1.생성자, 2.setter()
	private NoticeDAO dao;
	
	@Override
	public void setDAO(Object dao) {
		this.dao = (NoticeDAO)dao;
		System.out.println("NoticeviewService.dao : " + dao);
	}
	
	
	// url요청에 따른 처리
	// 넘어오는 데이터가 PageObject == > obj
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		// 넘어오는 데이터 확인
		// 전체데이터를 가져오기 TotalRow(totalRow);
		// 전체 페이지 셋팅 후 페이지 객체 출력
		System.out.println("NoticeviewService.obj: " + obj);
		return dao.view((long)obj);
	}

}
