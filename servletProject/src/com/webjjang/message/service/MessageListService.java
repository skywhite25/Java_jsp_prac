package com.webjjang.message.service;

import com.webjjang.message.dao.MessageDAO;
import com.webjjang.util.PageObject;
import com.webjjang.main.controller.Service;

public class MessageListService implements Service{
	
	private MessageDAO dao;
	
	public MessageListService() {
		System.out.println("MessageListService.MessageListService() - 생성완료");
	}
	@Override
	public void setDAO(Object dao) {
		System.out.println("MessageListService.setDAO().dao : " + dao);
		this.dao = (MessageDAO)dao;
	}
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		// 넘어오는 데이터 확인
		System.out.println("MessageListService.obj : " + obj);
		// 전체데이터를 가져오기
		int totalRow = (int) dao.getTotalRow();
		PageObject pageObject = (PageObject)obj;
		pageObject.setTotalRow(totalRow);
		// 전체 페이지 셋팅 후 페이지 객체 출력
		System.out.println("MessageListService.pageObject : " + pageObject);
		return dao.list(pageObject);
	
	}
}
