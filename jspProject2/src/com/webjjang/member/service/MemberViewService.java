package com.webjjang.member.service;

import com.webjjang.main.controller.Service;
import com.webjjang.member.dao.MemberDAO;

public class MemberViewService implements Service{

	// dao가 필요하다. 밖에서 생성한 후  넣어준다. - 1.생성자, 2.setter()
	MemberDAO dao = new MemberDAO();

	@Override
	// 넘어오는 데이터 : 아이디 - 타입 : String
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MemberViewService.service().dao : " + dao);
		// 글보기 vo 데이터를 가져와서 넘겨준다.
		return dao.view((String) obj);
	}
	@Override
	public void setDAO(Object dao) {
		// TODO Auto-generated method stub
		System.out.println("MemberViewService.service().dao : " + dao);
		this.dao = (MemberDAO) dao;
	}


}
