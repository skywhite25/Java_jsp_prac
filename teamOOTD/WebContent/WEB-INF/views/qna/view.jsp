<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QNA보기</title>

<style>

@font-face {
    font-family: 'Hana_handwriting';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/naverfont_05@1.0/Hana_handwriting.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

.f {
	font-family: 'Hana_handwriting';
	font-size: 20px;
}



</style>
</head>
<body>
<div class="container f">
	<h1>QnA</h1>
	<table class="table">
		<tr>
			<th>번호</th>
			<td>${vo.no }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${vo.title }</td>
		</tr>
		<tr class="f">
			<th>내용</th>
			<td><pre style="border: none;background: white;padding: 0px; font-family: 'Hana_handwriting'; font-size: 20px; witdth : 100px;">${vo.content }</pre></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${vo.name }(${vo.id })</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${vo.writeDate }</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="answerForm.do?no=${vo.no }" class="btn btn-default" style="font-size: 20px;">Answer</a>
				<c:if test="${vo.id == login.id || login.gradeNo == 9}">
					<a href="delete.do?no=${vo.no }" class="btn btn-default" style="font-size: 20px;">Delete</a>
						<a href="updateForm.do?no=${vo.no }&page=${pageObject.page }&perPageNum=${pageObject.perPageNum}" class="btn btn-default" style="font-size: 20px;">수정</a>				
				</c:if>
				<a href="list.do?perPageNum=${pageObject.perPageNum }" class="btn btn-default" style="font-size: 20px;">List</a>
			</td>
		</tr>
	</table>
</div>
</body>
</html>