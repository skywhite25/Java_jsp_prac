package com.webjjang.main.controller;

public interface Service {

	// 처리문 실행
	public Object service(Object obj) throws Exception;
	
	// dao 넣기
	public void setDAO(Object dao);
	
}
