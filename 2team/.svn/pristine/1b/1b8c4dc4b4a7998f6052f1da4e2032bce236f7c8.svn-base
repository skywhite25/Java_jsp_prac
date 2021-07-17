<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@page import="com.webjjang.board1.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
System.out.println("write.jsp 글쓰기 처리 완료");
request.setCharacterEncoding("utf-8");

String title = request.getParameter("title");
String content = request.getParameter("content");
String writer = request.getParameter("writer");

BoardVO vo = new BoardVO();
vo.setTitle(title);
vo.setContent(content);
vo.setWriter(writer);

String url = request.getServletPath();
Integer result = (Integer) ExeService.execute(Beans.get(url), vo);

response.sendRedirect("list.jsp");
%>