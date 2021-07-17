package com.OOTD.member.service;

import com.OOTD.main.controller.Service;
import com.OOTD.member.dao.MemberDAO;
import com.OOTD.member.vo.MemberVO;

public class MemberStatusModifyService implements Service {

	private MemberDAO dao;
	
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MemberStatusModifyService.service().dao : " + obj);
		// dao가 null이면 dao.gradeModify() 메서드를 호출해서 사용하려고 하면 NullPointException이 일어난다.
		return dao.statusModify((MemberVO) obj);
	}

	@Override
	public void setDAO(Object dao) {
		// TODO Auto-generated method stub
		// Init.init() 객체 생성 후 조립할때 실행 - 서버가 시작이 되면서 확인 - 이클립스 console창에 확인
		System.out.println("MemberStatusModifyService.setDAO().dao : " + dao);
		this.dao = (MemberDAO) dao;

	}

}
