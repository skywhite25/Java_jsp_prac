package com.OOTD.like.service;

import com.OOTD.like.DAO.LikeDAO;
import com.OOTD.like.vo.LikeVO;
import com.OOTD.main.controller.Service;

public class FashionLikeService implements Service{

	private LikeDAO dao;
	
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.fashionLike((LikeVO)obj);
	}

	@Override
	public void setDAO(Object dao) {
		// TODO Auto-generated method stub
		this.dao = (LikeDAO)dao;
	}

	
}
