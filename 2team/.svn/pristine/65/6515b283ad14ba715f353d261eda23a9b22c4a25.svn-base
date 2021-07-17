<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@page import="com.webjjang.notice2.vo.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
	// 여기가 자바 코드입니다. JSP-Service-DAO
// 한글 처리
request.setCharacterEncoding("utf-8");
// 1. 데이터 수집
String title = request.getParameter("title");
String content = request.getParameter("content");
String startDate = request.getParameter("startDate");
String endDate = request.getParameter("endDate");

NoticeVO vo = new NoticeVO();
vo.setTitle(title);
vo.setContent(content);
vo.setStartDate(startDate);
vo.setEndDate(endDate);
// 2. DB 처리 - write.jsp-Service-DAO
// 방법 1
//String url = request.getServletPath();
//Integer result = (Integer) ExeService.execute(Beans.get(url), vo);
// 방법 2
Integer result = (Integer) ExeService.execute(Beans.get(request.getServletPath()), vo);
// 3. list로 자동 이동
response.sendRedirect("list.jsp");
%>
