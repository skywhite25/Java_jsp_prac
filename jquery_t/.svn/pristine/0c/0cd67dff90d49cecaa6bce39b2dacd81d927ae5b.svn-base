<%@page import="com.webjjang.board2.vo.BoardVO"%>
<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// 한글처리
request.setCharacterEncoding("utf-8");
// 데이터 수집
String title = request.getParameter("title");
String content = request.getParameter("content");
String writer = request.getParameter("writer");

// VO 객체 생성 저장
BoardVO vo = new BoardVO();
vo.setTitle(title);
vo.setContent(content);
vo.setWriter(writer);

//DB 처리
ExeService.execute(Beans.get(request.getServletPath()), vo);

// 자동을 리스트로 이동
response.sendRedirect("list.jsp");
%>
