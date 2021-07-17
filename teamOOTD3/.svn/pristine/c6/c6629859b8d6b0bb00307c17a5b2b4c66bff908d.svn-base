package com.OOTD.image.service;

import com.OOTD.image.dao.ImageDAO;
import com.OOTD.main.controller.Service;


public class ImageViewService implements Service{
	
	// dao가 필요하다. 밖에서 생성한 후 넣어준다.
	// 1.생성자 2.setter()이용
	private ImageDAO dao;
	
	// 기본 생성자 만들기 -> 확인시 필요하다.
	public ImageViewService() {
		// TODO Auto-generated constructor stub
		System.out.println("ImageViewService.ImageViewService() 생성 완료");
	}
	
	public void setDAO(Object dao) {
		System.out.println("ImageViewService.setDAO().dao : " + dao);
		this.dao = (ImageDAO) dao;
	}
	
	// url 요청에 따른 처리
	// 넘어오는 데이터가  no ==> obj
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		// NullPointerException이 발생되는 이유
		// => dao가 Null일 수도 있다. 그러나 list()를 호출할 수 없어서  NullPointerException이 발생된다.
		// setDao에 의해서 dao를 넣는데 이상이 생겼다. -> Init.init()를 가서 확인해야 한다.
		
		// 넘어오는 데이터 확인
		System.out.println("ImageViewtService.obj : " + obj);
		
		// 넘어오는 데이터가 Long이므로 캐스팅하기
		return dao.view((Long) obj);
	}
	
	
}
