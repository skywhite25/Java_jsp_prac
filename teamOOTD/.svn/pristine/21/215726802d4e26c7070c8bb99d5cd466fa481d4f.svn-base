<%@page import="com.OOTD.main.controller.Service"%>
<%@page import="com.OOTD.main.controller.Beans"%>
<%@page import="com.OOTD.main.controller.ExeService"%>
<%@page import="com.OOTD.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// 자바 부분 -----------------
// 실행여부 확인 - 이클립스 Console 창에서 확인하세요.
String id = request.getParameter("id");
// 등급 문자열 받아내기 - 데이터가 안나오면 list.jsp에서 부터 실행을 했었어야 한다.
//               list.jsp의 form안에 input의 name="gradeNo"이여야만하고 실제적으로 데이터가 셋팅되어 있어야한다.
String status = request.getParameter("status");

// 저장할 VO객체 생성
MemberVO vo = new MemberVO();
// 생성된 vo객체에 데이터 넣기 - setter() - 아이디, 등급번호
vo.setId(id);
vo.setStatus(status);

// MemberGradeModifyService, MemberDAO.gradeModify(vo), DBSQL.MEMBER_GRADE_MODIFY 작성하세요.
// Init.init() - 생성하고 조립하세요.

// 수집한 데이터를 service로 넘겨서 실행한다. : jsp - service - dao - member DB
// Service 선택해서 가져오기 : Beans.get(url)
String url = request.getServletPath();

Service service = Beans.get(url);

ExeService.execute(service, vo);

// 자동으로 /member/list.jsp로 이동이 되어야 한다.
response.sendRedirect("list.jsp");
%>
