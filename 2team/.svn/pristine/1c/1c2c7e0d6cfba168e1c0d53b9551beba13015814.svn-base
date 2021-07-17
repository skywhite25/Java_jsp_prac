<%@page import="com.webjjang.notice3.vo.NoticeVO"%>
<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.sun.rmi.rmid.ExecOptionPermission"%>
<%@page import="com.webjjang.notice3.service.NoticeWriteService"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// 자바 부분 입니다.

// 한글처리
request.setCharacterEncoding("utf-8");

// 1. 데이터 수집
String title = request.getParameter("title");
String content = request.getParameter("content");
String startDate = request.getParameter("startDate");
String endDate = request.getParameter("endDate");
String writeDate = request.getParameter("writeDate");
String updateDate = request.getParameter("updateDate");

NoticeVO vo = new NoticeVO();
vo.setTitle(title);
vo.setContent(content);
vo.setStartDate(startDate);
vo.setEndDate(endDate);
vo.setWriteDate(writeDate);
vo.setUpdateDate(updateDate);

// 2. DB 처리 - write.jsp -> service -> dao
String url = request.getServletPath();
Integer result = (Integer) ExeService.execute(Beans.get(url), vo);

// 3. list로 자동 이동
response.sendRedirect("list.jsp");
%>

<%= vo %>
