package com.OOTD.like.service;

import com.OOTD.like.DAO.LikeDAO;
import com.OOTD.like.vo.LikeVO;
import com.OOTD.main.controller.Service;

public class FashionViewService implements Service{

	private LikeDAO dao;
	
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		LikeVO vo = dao.fashionView((LikeVO)obj);
		vo.setLikeCnt(dao.fashionCnt(((LikeVO)obj).getNo()));
		return vo;
	}

	@Override
	public void setDAO(Object dao) {
		// TODO Auto-generated method stub
		this.dao = (LikeDAO)dao;
	}

	
}
