<%@page import="com.webjjang.util.filter.AuthorityFilter"%>
<%@page import="com.webjjang.notice.vo.NoticeVO"%>
<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 자바 부분입니다.
// 넘어오는 데이터를 받는다.

// 한글 처리
request.setCharacterEncoding("utf-8");

// 1. 데이터 수집
String title = request.getParameter("title");
String content = request.getParameter("content");
String startDate = request.getParameter("startDate");
String endDate = request.getParameter("endDate");

// vo 객체를 생성하고 저장한다.
NoticeVO vo = new NoticeVO();
vo.setTitle(title);
vo.setContent(content);
vo.setStartDate(startDate);
vo.setEndDate(endDate);

// vo 객체 데이터 확인
System.out.println("/notice/write.jsp [vo] : " + vo);

// DB에 데이터를 저장 jsp(controller) - NoticeWriteService - NoticeDAO - notice table insert
ExeService.execute(Beans.get(AuthorityFilter.url), vo);

// 3. list로 자동 이동
response.sendRedirect("list.jsp");
%>

