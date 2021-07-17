
<%@page import="com.OOTD.main.controller.Beans"%>
<%@page import="com.OOTD.util.filter.AuthorityFilter"%>
<%@page import="com.OOTD.main.controller.ExeService"%>
<%@page import="com.OOTD.image.vo.ImageVO"%>
<%@page import="com.OOTD.member.vo.LoginVO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 자바 부분
// 저장 위치 선언
String path = "/upload/image/"; // 이 위치 안에 파일이 존재해야 한다.
String realPath = request.getServletContext().getRealPath(path);
System.out.println("/image/write.jsp [realPath] : " + realPath);

// String strSeasonNo = request.getParameter("seasonNo");
// System.out.println("write.jsp [strSeasonNo] : " + strSeasonNo);
// int seasonNo = Integer.parseInt(strSeasonNo);
// System.out.println("write.jsp [seasonNo] : " + seasonNo);

// file size : 용량 제한 - 10MB로 제한
int fileSize = 10 * 1024 * 1024; // 1000byte => 1KB, 1000KB => 1MB, 1000MB => 1GB, 1000GB => 1TB

// 파일의 정보를 처리해 주는 객체 생성 -> 파일 업로드가 자동으로 이루어 진다.
// new MultipartRequest(request, (컴퓨터에서) 실제적인 저장위치, 파일 용량 제한, 엔코딩방식, 중복된 파일 이름을 처리하는 객체)
MultipartRequest multi = new MultipartRequest(request, realPath, fileSize, "utf-8", new DefaultFileRenamePolicy());

// MultipartRequest 생성 후에는 request에서 아무것도 나오지 않는다.
//System.out.println("/image/write.jsp [request.title] : " + request.getParameter("title")); // 서버에서 가져온 title
//System.out.println("/image/write.jsp [multi.title] : " + multi.getParameter("title")); //multi에서 가져온 title

String strSeasonNo = multi.getParameter("seasonNo");
Long seasonNo = Long.parseLong(strSeasonNo);
String name1 = multi.getParameter("name1");
String link1 = multi.getParameter("link1");
String name2 = multi.getParameter("name2");
String link2 = multi.getParameter("link2");
String name3 = multi.getParameter("link3");
String link3 = multi.getParameter("link3");
String name4 = multi.getParameter("link4");
String link4 = multi.getParameter("link4");

// String id = ((LoginVO) session.getAttribute("login")).getId();

// 서버에 저장된 파일명
String fileName = multi.getFilesystemName("imageFile");
System.out.println("/image/write.jsp [fileName] : " + fileName);
System.out.println("/image/write.jsp [seasonNo] : " + seasonNo);


// vo객체 생성 후 저장
ImageVO vo = new ImageVO();
vo.setName1(name1);
vo.setLink1(link1);
vo.setName2(name2);
vo.setLink2(link2);
vo.setName3(name3);
vo.setLink3(link3);
vo.setName4(name4);
vo.setLink4(link4);
vo.setFileName(path + fileName);
vo.setSeasonNo(seasonNo);

// DB처리
Integer result = (Integer) ExeService.execute(Beans.getService(AuthorityFilter.url), vo);

// list로 자동 이동 시키기
response.sendRedirect("list.jsp?page=1&perPageNum=" + multi.getParameter("perPageNum"));

%>