<%@page import="com.OOTD.member.vo.LoginVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="login_error.jsp" %>
<%
// 여기가 자바 입니다.
// 로그인 정보를 가져오는데 성공하는 로그인 처리를 한다.
// 데이터 받기
String id = request.getParameter("id");
String pw = request.getParameter("pw");

// 받은 데이터를 VO 객체이 저장을 한다.(한개를 넘겨야 해서)
LoginVO vo = new LoginVO();
vo.setId(id);
vo.setPw(pw);

// DB 처리 - 아이디, 이름, 등급번호, 등급이름을 가져온다.
// jsp - service - dao

session.setAttribute("login", vo);
response.sendRedirect("main.jsp");
%>