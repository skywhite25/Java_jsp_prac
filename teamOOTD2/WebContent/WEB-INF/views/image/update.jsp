<%@page import="com.OOTD.main.controller.Beans"%>
<%@page import="com.OOTD.util.filter.AuthorityFilter"%>
<%@page import="com.OOTD.main.controller.ExeService"%>
<%@page import="com.OOTD.image.vo.ImageVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
System.out.println("/image/update.jsp - 글수정 처리 완료");

String strNo = request.getParameter("no");
Long no = Long.parseLong(strNo);
String strSeasonNo = request.getParameter("seasonNo");
Long seasonNo = Long.parseLong(strSeasonNo);
String name1 = request.getParameter("name1");
String link1 = request.getParameter("link1");
String name2 = request.getParameter("name2");
String link2 = request.getParameter("link2");
String name3 = request.getParameter("name3");
String link3 = request.getParameter("link3");
String name4 = request.getParameter("name4");
String link4 = request.getParameter("link4");

System.out.println("update.jsp [seasonNo] : " + seasonNo);

ImageVO vo = new ImageVO();
vo.setSeasonNo(seasonNo);
vo.setName1(name1);
vo.setLink1(link1);
vo.setName2(name2);
vo.setLink2(link2);
vo.setName3(name3);
vo.setLink3(link3);
vo.setName4(name4);
vo.setLink4(link4);

System.out.println("/image/update.jsp [vo] : " + vo);

Integer result = (Integer) ExeService.execute(Beans.getService(AuthorityFilter.url), vo);

response.sendRedirect("view.jsp?no=" + no);

%>