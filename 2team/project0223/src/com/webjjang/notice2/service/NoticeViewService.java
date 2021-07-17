/*
 * 공지 글보기를 해결하기 위한 객체
 * - NoticeDAO 객체를 사용해서 DB에서 데이터를 수집해 온다.
 */
package com.webjjang.notice2.service;

import com.webjjang.notice2.dao.NoticeDAO;
import com.webjjang.main.controller.Service;


public class NoticeViewService implements Service{
	
	NoticeDAO dao = new NoticeDAO();

	@Override
	public void setDAO(Object dao) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		// 글보기 vo 데이터를 가져와서 넘겨준다.
		return dao.view((Long) obj);
	}

}
