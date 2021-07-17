<%@page import="com.webjjang.util.filter.AuthorityFilter"%>
<%@page import="com.webjjang.member.vo.LoginVO"%>
<%@page import="com.webjjang.util.PageObject"%>
<%@page import="com.webjjang.message.vo.MessageVO"%>
<%@page import="java.util.List"%>
<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="pageObject" tagdir="/WEB-INF/tags" %> 
<%
//여기가 자바 코드 입니다. JSP - service - DAO, 페이지 처리 : 페이지와 한페이지당 표시데이터의 갯수를 전달받아야한다.
// 넘어오는 데이터 받기
String strCurPage = request.getParameter("page");
long curPage = 1; // 현재 페이지의 기본값 셋팅
if(strCurPage != null) curPage = Long.parseLong(strCurPage);
String strPerPageNum = request.getParameter("perPageNum");
long perPageNum = 10;
if(strPerPageNum != null) perPageNum = Long.parseLong(strPerPageNum);

// 내 아이디를 가져와서 pageObject에 저장해둔다.
PageObject pageObject = new PageObject();
pageObject.setAccepter(((LoginVO)session.getAttribute("login")).getId());

//DB에서 데이터 가져오기
@SuppressWarnings("unchecked")
List<MessageVO> list = (List<MessageVO>)ExeService.execute(Beans.get(AuthorityFilter.url), pageObject);

//서버객체 request에 담는다.
request.setAttribute("list", list);
request.setAttribute("pageObject", pageObject);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메시지 리스트</title>

<style type="text/css">
tr{
	color: #777;
}
.noread{
	color: #4d0026;
}
.dataRow:hover{
	cursor:  pointer;
	background:  #eee;
	
}
</style>
<script type="text/javascript">
// 객체 선택에 문제가 있다. 아래 Document가 다 로딩이 되면 실행되는 스크립트 작성
// jQuery -> $(function(){처리문 만들기}); = jQuery(function(){처리문 만들기});
$(function(){ // jQuery에서 익명함수를 전달해서 저장해놨다가 Document가 로딩이 다 되면 호출해서 처리해준다.
	// 데이터 한 줄 선택하기와 이벤트처리
	// 메시지 보기로 이동
	$(".dataRow").click(function(){
// 		alert("sd");
		// $(this) : 자기 자신(이벤트가 일어난 곳 - 현재는 tr) - 클래스가 no인 객체를 찾아라. 태그안에 있는 글자 가져오기
		var no = $(this).find(".no").text();
		location = "view.do?no=" + no + "&page=${pageObject.page}"
		});
});
</script>
</head>
<body>
<div class="container">
<h1>메시지 리스트</h1>
<table class="table">
	<!-- 제목 -->
	<thead>
		<tr>
			<th>번호</th>
			<th>발신자</th>
			<th>발신일</th>
			<th>수신자</th>
			<th>수신일</th>
		</tr>
	</thead>
	<tbody>
		<!-- 데이터가 있는 만큼 반복이 되어지는 시작 부분 -->
		<c:forEach items="${list }" var="vo">
		<tr class='dataRow ${(empty vo.acceptDate)?"noread":"" }'>
			<td class="no">${vo.no }</td>
			<td>${vo.sender }</td>
			<td>${vo.sendDate }</td>
			<td>${vo.accepter}</td>
			<td>${(empty vo.acceptDate) ? "읽지않음":vo.acceptDate }</td>
		</tr>
		</c:forEach>
		<!-- 데이터가 있는 만큼 반복이 되어지는 끝 부분 -->
	</tbody>
	<tfoot>
		<tr>
			<td colspan="5">
				<a href="writeForm.do" class="btn btn-default">글쓰기</a><br/>
				<pageObject:pageNav listURI="list.jsp" pageObject="${pageObject }" />
			</td>
		</tr>
	</tfoot>
</table>
</div>
</body>
</html>