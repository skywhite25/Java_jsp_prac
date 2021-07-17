package com.webjjang.main.controller;

public class ExeService {

	//execute(실행할 service, 넘겨줄 데이터)
	public static Object execute(Service service, Object obj) throws Exception{
		// 실행되는 객체 정보 출력 -> Service에 해당된다.
		System.out.println("실행되는 객체 : " + service.getClass().getSimpleName() + ".service() 실행중");
		
		// 넘어가는 데이터 출력
		System.out.println("전달되는 데이터 : " + obj);
		
		// 실행해서 결과를 받는다.
		Object result = service.service(obj);
		
		// 결과를 출력해서 확인
		System.out.println("실행한 결과 : " + result);
		
		// 결과를 넘겨준다.
		return result;
	}
	
}
