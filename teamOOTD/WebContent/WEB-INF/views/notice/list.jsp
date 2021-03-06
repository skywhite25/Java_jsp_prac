<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="pageObject" tagdir="/WEB-INF/tags" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice</title>

<style type="text/css">
.dataRow:hover{
	cursor: pointer;
	background: #eee;
}	
@font-face {
    font-family: 'Hana_handwriting';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/naverfont_05@1.0/Hana_handwriting.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

.f {
	font-family: 'Hana_handwriting';
	font-size: 60px;
}

.c {
	font-family:'Hana_handwriting';
	font-size: 20px;
}
</style>
  
<script type="text/javascript">
// 객체 선택에 문제가 있다. 아래 Document가 다 로딩이 되면 실행되는 스크립트 작성
// jQuery -> $(function(){처리문 만들기}); = jQuery(function(){처리문 만들기});
$(function(){ // jQuery에서 익명함수를 전달해서 저장해놨다가 Document가 로딩이 다 되면 호출해서 처리해준다.
	// 데이터 한 줄 선택하기와 이벤트처리
	$(".dataRow").click(function(){
// 		alert($(this));
		// $(this) : 이벤트가 일어난 자신을 의미 -> 클릭이 일어난 자신, 현재 처리되고 있는 객체..
		// .find(selector) : .앞에 객체 안에서 선택한 것을 찾아라
		// .text() : 객체(태그) 사이에 문자를 가져온다.
		// .text(data) : 객체(태그)사이에 문자를 셋팅한다.
		var no = $(this).find(".no").text();
		location = "view.do?no=" + no + "&page=${pageObject.page}" + "&perPageNum=${pageObject.perPageNum}";
	});
});
</script>
</head>
<body>
<div class="container">
<h1 class="f">Notice</h1>
	<div class="pull-right" style="padding: 5px;">
		<a href="list.do?page=${pageObject.page }&perPageNum=${pageObject.perPageNum}&period=all"
		 ${pageObject.period == "all"?"Active":""} class="btn btn-default" style="font-size: 13px;">ALL</a>
		<a href="list.do?page=${pageObject.page }&perPageNum=${pageObject.perPageNum}&period=pre"
		 ${pageObject.period == "pre"?"Active":""} class="btn btn-default" style="font-size: 13px;">PRE</a>
		<a href="list.do?page=${pageObject.page }&perPageNum=${pageObject.perPageNum}&period=res"
		 ${pageObject.period == "res"?"Active":""} class="btn btn-default" style="font-size: 13px;">RES</a>
		<a href="list.do?page=${pageObject.page }&perPageNum=${pageObject.perPageNum}&period=old"
		 ${pageObject.period == "old"?"Active":""} class="btn btn-default" style="font-size: 13px;">OLD</a>
	</div>
	<div>
 </div>
<table class="table c">
	<!-- 제목 -->
	<thead>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>공지시작일</th>
		<th>공지종료일</th>
		<th>작성일</th>
	</tr>
	</thead>
	<tbody>
	<!-- 데이터가 있는 만큼 반복이 되어지는 시작 부분 -->
	<c:forEach items="${list }" var="vo">
	<tr class="dataRow">
		<td class="no">${vo.no }</td>
		<td>${vo.title }</td>
		<td>${vo.startDate }</td>
		<td>${vo.endDate }</td>
		<td>${vo.writeDate }</td>
	</tr>
	</c:forEach>
	</tbody>
	<tfoot>
	<tr>
		<td colspan="5">
			<pageObject:pageNav listURI="list.do" pageObject="${pageObject }" /><br/>
		
			<!-- 관리자로 되어 있을 경우  -->
			<c:if test="${login.gradeNo == 9 }">
			<div>
			<a href="writeForm.do?perPageNum=${pageObject.perPageNum }" class="btn btn-default" style="font-size: 20px;">Write</a>
			</div>
			</c:if>
		</td>
	</tr>
	</tfoot>
</table>
</div>
</body>
</html>