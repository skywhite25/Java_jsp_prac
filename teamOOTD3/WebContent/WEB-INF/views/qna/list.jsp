<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pageObject" tagdir="/WEB-INF/tags" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문답변 리스트</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<style type="text/css">
.dataRow:hover{
	cursor: pointer;
	background: #eee;
}
</style>

<script type="text/javascript">
$(function(){ // 문서가 로딩이 다된 후에 처리하도록 한다.
	$(".dataRow").click(function(){
		// alert("click");
		// 보기 페이지로 이동
		var no = $(this).find(".no").text();
		location = "view.do?no=" + no;
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
		</tr>
		<c:forEach items="${list }" var="vo">
			<tr class="dataRow">
				<td class="no">${vo.no }</td>
				<td>
					<c:forEach begin="1" end="${vo.levNo }">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:forEach>
					<c:if test="${vo.levNo > 0 }">
						<i class="material-icons">subdirectory_arrow_right</i>
					</c:if>${vo.title }
				</td>
				<td>${vo.name }(${vo.id })</td>
				<td>${vo.writeDate }</td>

			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
				<pageObject:pageNav listURI="list.do" pageObject="${pageObject }" />
			</td>
		</tr>
		<c:if test="${!empty login }">
			<tr>
				<td colspan="5">
					<a href="questionForm.do" class="btn btn-default">질문하기</a>
				</td>
			</tr>
		</c:if>
	</table>
</div>
</body>
</html>