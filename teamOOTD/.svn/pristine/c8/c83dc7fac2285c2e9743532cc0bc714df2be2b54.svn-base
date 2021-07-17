<%@page import="com.OOTD.util.file.FileUtil"%> 
<%@page import="com.OOTD.util.filter.AuthorityFilter"%>
<%@page import="com.OOTD.main.controller.Beans"%>
<%@page import="com.OOTD.main.controller.ExeService"%>
<%@page import="com.OOTD.image.vo.ImageVO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/error/error_page.jsp" %>
<%
// 자바 부분
// 올라갈 파일의 서버 상대 위치
String path = "/upload/image/";
String realPath = request.getServletContext().getRealPath(path);

int fileSize = 10 * 1024 * 1024;

// 파일 올리는 라이브러리 MultipartRequest 객체 생성 -> 생성과 동시에 자동으로 파일이 올라간다.
// MultipartRequest에서 꺼내서 DefaultFileRenamePolicy를 이용해서 자동으로 올린다.
MultipartRequest multi = new MultipartRequest(request, realPath, fileSize, "utf-8", new DefaultFileRenamePolicy());

String strNo = multi.getParameter("no");
String deleteFile = multi.getParameter("deleteFile");
String fileName = multi.getFilesystemName("imageFile");

// page에 대한 정보를 문자열로 받아서 되돌아가는 view.jsp 뒤에 정보로 붙여서 이동시킨다.
String strPage = multi.getParameter("page");
String strPerPageNum = multi.getParameter("perPageNum");

// 위에서 넘겨받은 정보 확인
System.out.println("updateFile.jsp [no] : " + strNo);
System.out.println("updateFile.jsp [deleteFile] : " + deleteFile);
System.out.println("updateFile.jsp [fileName] : " + fileName);

// 파일 정보 수정 - 번호, 파일명 넘기기
ImageVO vo = new ImageVO();
vo.setNo(Long.parseLong(strNo));
vo.setFileName(path + fileName);

// DB에 파일 정보 수정
int result = (Integer) ExeService.execute(Beans.getService(AuthorityFilter.url), vo);

// 이전(원본) 파일 삭제
String deletePath = request.getServletContext().getRealPath("/");
if(FileUtil.exist(deletePath + deleteFile)){
	System.out.println(deleteFile + "파일은 존재합니다.");
} else System.out.println(deleteFile + "파일이 존재하지 않습니다.");
//실제적으로 지우는 처리
FileUtil.remove(deletePath + deleteFile);

// 자동으로 보기로 이동시킨다.
response.sendRedirect("view.jsp?no=" + strNo + "&page=" + strPage + "&perPageNum=" + strPerPageNum);

%>