package com.webjjang.image.service;

import com.webjjang.image.dao.ImageDAO;
import com.webjjang.image.vo.ImageVO;
import com.webjjang.main.controller.Service;

public class ImageWriteService implements Service{

	// dao가 필요하다. 밖에서 생성한 후  넣어준다. - 1.생성자, 2.setter()
	private ImageDAO dao;
	
	// 기본 생성자 만들기 -> 확인 시 필요하다.
	public ImageWriteService() {
		System.out.println("ImageWriteService.ImageWriteService() - 생성완료");
	}
	
	@Override
	public void setDAO(Object dao) {
		System.out.println("ImageWriteService.setDAO().dao : " + dao);
		this.dao = (ImageDAO)dao;
	}
	
	
	// url요청에 따른 처리
	// 넘어오는 데이터가  ImageVO == > obj
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		// 넘어오는 데이터 확인
		System.out.println("ImageWriteService.obj : " + obj);
		return dao.write((ImageVO) obj);
	}

}
