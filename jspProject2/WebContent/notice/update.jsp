<%@page import="com.webjjang.notice.vo.NoticeVO"%>
<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 자바 부분입니다.

// 한글 처리
request.setCharacterEncoding("utf-8");

// 1. 데이터 수집
String strNo = request.getParameter("no");
long no = Long.parseLong(strNo);
String title = request.getParameter("title");
String content = request.getParameter("content");
String startDate = request.getParameter("startDate");
String endDate = request.getParameter("endDate");
String writer = request.getParameter("writer");

NoticeVO vo = new NoticeVO();
vo.setNo(no);
vo.setTitle(title);
vo.setContent(content);
vo.setStartDate(startDate);
vo.setEndDate(endDate);

// 2. DB 처리 - update.jsp -> service - dao
String url = request.getServletPath();
int result = (Integer) ExeService.execute(Beans.get(url), vo);


// 3. view로 자동 이동
response.sendRedirect("view.jsp?no=" + no + "&inc=0");
%>

