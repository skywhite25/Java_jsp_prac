<%@page import="com.webjjang.board3.service.BoardWriteService"%>
<%@page import="com.webjjang.board3.vo.BoardVO"%>
<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 자바 부분입니다.

// 한글 처리
request.setCharacterEncoding("utf-8");

// 1. 데이터 수집
String title = request.getParameter("title");
String content = request.getParameter("content");
String writer = request.getParameter("writer");


BoardVO vo = new BoardVO();
vo.setTitle(title);
vo.setContent(content);
vo.setWriter(writer);


// 2. DB 처리 - write.jsp -> service - dao
ExeService.execute(Beans.get(request.getServletPath()), vo);

// 3. list로 자동 이동
response.sendRedirect("list.jsp");
%>

