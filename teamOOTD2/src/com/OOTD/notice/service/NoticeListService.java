package com.OOTD.notice.service;

import com.OOTD.notice.dao.NoticeDAO;
import com.OOTD.main.controller.Service;

import com.OOTD.util.PageObject;

public class NoticeListService implements Service{

	//dao가 필요하다. 밖에서 생성한 후 넣어준다. - 1. 생성자. 2. setter()
	NoticeDAO dao;
	
	@Override
	public void setDAO(Object dao) {
		System.out.println("NoticeListService.setDAO().dao : " + dao);
		this.dao = (NoticeDAO) dao;
	}
	
	// url 요청에 따른 처리
	// 넘어오는 데이터가 PageObject ==> obj
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		// 넘어오는 데이터 확인
		System.out.println("NoticeListService.obj : " + obj);
		// 전체 데이터를 가져오기
		PageObject pageObject = (PageObject) obj;
		long totalRow = dao.getTotalRow(pageObject);
		pageObject.setTotalRow(totalRow);
		// 전체 페이지 셋팅 후 페이지 객체 출력
		System.out.println("NoticeListService.pageObject : " + pageObject);
		return dao.list(pageObject);
	}

}
