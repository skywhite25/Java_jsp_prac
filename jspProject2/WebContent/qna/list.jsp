<%@page import="com.webjjang.util.filter.AuthorityFilter"%>
<%@page import="com.webjjang.util.PageObject"%>
<%@page import="com.webjjang.qna.vo.QnaVO"%>
<%@page import="java.util.List"%>
<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="pageObject" tagdir="/WEB-INF/tags"%>
<%
// 여기가 자바 코드 입니다. JSP - service - DAO

// 기본정보 셋팅
Long curPage = 1L;
Long perPageNum = 10L;

// 넘어오는 데이터 받기 - 페이지, 한 페이지당 데이터 갯수
String strCurPage = request.getParameter("page");
String strPerPageNum = request.getParameter("perPageNum");

// PageObject 생성
PageObject pageObject = new PageObject();

// 넘어오는 데이터가 있으면 pageObject의 페이지와 한페이지당 표시 데이터 갯수의 기본정보를 바꾼다.
if(strCurPage != null)  curPage = Long.parseLong(strCurPage);
pageObject.setPage(curPage);
if(strPerPageNum!= null) perPageNum = Long.parseLong(strPerPageNum); 
pageObject.setPerPageNum(perPageNum);

// DB에서 데이터 가져오기
@SuppressWarnings("unchecked")
List<QnaVO> list = (List<QnaVO>)ExeService.execute(Beans.get(AuthorityFilter.url), pageObject);

// 서버객체에 저장
request.setAttribute("list", list);
request.setAttribute("pageObject", pageObject);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문답변 리스트</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<style type="text/css">
.dataRow:hover{
	cursor : pointer; 
	background: #eee;
	
}
</style>

<script type="text/javascript">
$(function(){ // 문서가 다 로딩이 되고 처리하도록 한다.
	$(".dataRow").click(function(){
// 		alert("click");
		// 보기 페이지로 이동
		var no = $(this).find(".no").text();
		location = "view.jsp?no=" + no + "&inc=1";
	});
});	
</script>
</head>
<body>
<div class="container">
	<h1>질문 답변 리스트</h1>
	<table class="table">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자(아이디)</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${list }" var="vo">
			<tr class="dataRow">
				<td class="no">${vo.no }</td>
				<td>
					<c:forEach begin="1" end="${vo.levNo }">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:forEach>
					<c:if test="${vo.levNo > 0 }">
						<i class="material-icons">subdirectory_arrow_right </i>
					</c:if>${vo.title }
				</td>
				<td>${vo.name }(${vo.id })</td>
				<td>${vo.writeDate }</td>
				<td>${vo.hit }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
				<pageObject:pageNav listURI="list.jsp" pageObject="${pageObject }" /><br/>
				<c:if test="${!empty login }">
					<a href="questionForm.jsp" class="btn btn-default">질문하기</a>
				</c:if>
			</td>	
		</tr>
	</table>
</div>
</body>
</html>