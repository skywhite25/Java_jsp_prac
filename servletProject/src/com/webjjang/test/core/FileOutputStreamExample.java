package com.webjjang.test.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

// 자바에서 파일을 읽어 들여와서 byte 단위의 데이터들을 차례대로 지정된 파일에 저장하는 프로그램
public class FileOutputStreamExample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("FileOutputStreamExample.main()");
		// 드라이버:/폴더/폴더../파일 : 구분의 의미 / 한 개를 사용한다.
		// 드라이버:\폴더 --> \n : 줄바꿈의 특수문자 --> \ 뒤에 오는 글자 한 개와 특수문자로 인식이 된다.
		// 그래서 \\ 를 사용해서 \로 인식을 시킨다.
		// 읽어 들여오는 파일의 정보 -> 절대 위치 --> 드라이버:/폴더.../파일
//		String originalFileName = "C:/Temp/name.txt";
		String originalFileName = "C:/Temp/icon.gif"; // 이미지 파일명 작성 -> 반드시 파일이 존재해야한다.
		// 저장할 파일의 정보 - 프로그램을 실행하기 전에는 존재하지 않는다.
		// 저장을 하려면 파일은 없어도 가능하지만 폴더는 반드시 존재해야한다(또는 만들어야한다).
//		String targetFileName = "C:/Temp/out/name.txt";
		String targetFileName = "C:/Temp/out/i.gif";
		
		// 만약에 저장하려는 파일이 존재하면 파일이 존재한다고 출력하고 빠져나온다(return).
		// 저장하려는 파일명으로 파일 객체를 만든다.
		File outFile = new File(targetFileName);
		// 존재하면(중복) 중복됨을 출력하고 프로그램을 종료한다.
		if(outFile.exists()) {
			System.out.println("파일의 이름이 중복입니다. 파일명 : " + outFile.getName());
			return;
		}
		
		
		// 파일 읽기 객체와 저장객체를 생성해 준다.
		FileInputStream fis = new FileInputStream(originalFileName);
		FileOutputStream fos = new FileOutputStream(targetFileName);
		
		int readByteNo = 0; // byte(char) -> 숫자로 운영 : int에 넣을 수 있다. 아래 readBytes에 읽어온 데이터의 갯수를 저장 변수. 한 개를 읽어서 저장하는 변수
		
		// 한번에 읽는 문자의 수를 배열 - 100개
		byte[] readBytes = new byte[100];
		
		// 데이터를 읽어와서 저장하는 반복문 - 데이터가 있는 만큼 처리하도록 한다.
		// 1바이트씩 읽기 : read(), buffer(byte[100])단위만큼 한꺼번에 읽는다. 처리는 한 개씩 : read(byte[])
		// readByteNo - 읽어온 데이터의 길이
		// 문자열인 경우 모두 + 숫자이거나 0이 나와야 한다. 읽었을 때 -1 이면 모두 읽어서 읽을 것이 더 이상 없다.
		while((readByteNo = fis.read(readBytes)) != -1) {
			// 불러온 데이터를 저장한다.
			fos.write(readBytes,0,readByteNo);
		}
		// 버퍼에 남은 데이터를 파일로 보내서 저장하게 한다.
		fos.flush();
		// 자원 반환
		fos.close();
		fis.close();
		
		System.out.println("복사가 완료되었습니다.");
		
	}

}
