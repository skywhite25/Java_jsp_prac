package com.OOTD.image.service;

import java.util.Arrays;

import com.OOTD.image.dao.ImageDAO;
import com.OOTD.main.controller.Service;
import com.OOTD.util.PageObject;

public class ImageReplyListService implements Service{
	
	ImageDAO dao;

	@Override
	// 넘어오는 데이터가 []{no, PageObject} ==> obj
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		// 넘어오는 데이터 확인 
		Object[] objs = (Object[]) obj;
		System.out.println("ImageReplyListService.obj : " + Arrays.toString(objs));
		
		// 배열로 되어 있는 것은 순서에 맞게 데이터 분할 [0]:no, [1]:pageObject
		Long no = (Long) objs[0];
		PageObject pageObject = (PageObject) objs[1];
		
		// 전체 데이터를 가져오기
		int replyTotalRow = (int) dao.getReplyTotalRow(no);
		pageObject.setTotalRow(replyTotalRow);
		
		// 전체 페이지 셋팅 후 페이지 객체 출력
		System.out.println("BoardReplyListService.pageObject : " + pageObject);
		
		return dao.replyList(no, pageObject);
	}

	@Override
	public void setDAO(Object dao) {
		// TODO Auto-generated method stub
		this.dao = (ImageDAO) dao;
	}
	
	
	
}
