package com.OOTD.like.service;

import com.OOTD.like.DAO.LikeDAO;
import com.OOTD.like.vo.LikeVO;
import com.OOTD.main.controller.Service;
import com.OOTD.util.db.DBInfo;
import com.OOTD.util.db.DBSQL;

public class TimeViewService implements Service{

	private LikeDAO dao;
	
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TimeViewService.service().obj :" + obj);
		//로그인한 사람의 정보가 있는 경우에만 id를 가져오는 처리
		LikeVO vo = dao.timeView((LikeVO)obj);
		System.out.println("TimeViewService.service().vo :" + vo);
		// 전체 갯수 처리
		vo.setLikeCnt(dao.timeCnt(((LikeVO)obj).getNo()));
		//가져온 no를 강제 셋팅 
		vo.setNo(((LikeVO)obj).getNo());
		
		return vo;
	}

	@Override
	public void setDAO(Object dao) {
		// TODO Auto-generated method stub
		this.dao = (LikeDAO)dao;
	}

	
}

