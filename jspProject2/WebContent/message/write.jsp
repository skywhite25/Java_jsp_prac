<%@page import="com.webjjang.util.filter.AuthorityFilter"%>
<%@page import="com.webjjang.member.vo.LoginVO"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.message.vo.MessageVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 자바 부분입니다.

// 한글 처리 -> 필터에서 처리
// request.setCharacterEncoding("utf-8");
// System.out.println("EncodingFilter에서 한글처리 완료 : " + request.getCharacterEncoding());

// 1. 데이터 수집
// 넘어오는 데이터 수집 - 받는 사람 아이디, 내용
String accepter = request.getParameter("accepter");
String content = request.getParameter("content");

// session에서 내 아이디 가져오기
// session의 내용은 /member.login.jsp를 확인하세요 - 이 때 key = login이 다르면 null이 나온다.
LoginVO vo = (LoginVO) session.getAttribute("login");
String sender = vo.getId();

// vo 객체를 생성하고 데이터를 넣는다.
MessageVO messageVO = new MessageVO();
messageVO.setContent(content);
messageVO.setSender(sender);
messageVO.setAccepter(accepter);

// 2. DB 처리 - write.jsp -> service - dao - db
// ExeService.execute(실행할 service, service에 전달되는 데이터)
ExeService.execute(Beans.get(AuthorityFilter.url), messageVO);

// 3. list로 자동 이동
response.sendRedirect("list.jsp");
%>