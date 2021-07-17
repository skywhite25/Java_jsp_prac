package com.OOTD.member.service;

import com.OOTD.member.dao.MemberDAO;
import com.OOTD.member.vo.MemberVO;
import com.OOTD.main.controller.Service;

public class MemberWriteService implements Service {

	private MemberDAO dao;

	@Override
	// 넘어오는 데이터 : MemberVO
	public Object service(Object obj) throws Exception {
		System.out.println("MemberWriteService.service().obj : " + obj);
		// dao가 null이면 dao.gradeModify() 메서드를 호출해서 사용하려고 하면 NullPointException이 일어난다.
		return dao.write((MemberVO) obj);
	}

	@Override
	public void setDAO(Object dao) {
		// Init.init() 객체 생성 후 조립할때 실행 - 서버가 시작이 되면서 확인 - 이클립스 console창에 확인
		System.out.println("MemberWriteService.setDAO().dao : " + dao);
		this.dao = (MemberDAO) dao;

	}

}
