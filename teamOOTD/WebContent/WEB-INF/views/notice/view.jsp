<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice</title>
<!--   부트스트랩 라이브러리 등록 - CDN 방식 -->
<!--   <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!--   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> -->
<!--   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
  
<script type="text/javascript">
// 객체 선택에 문제가 있다. 아래 Document가 다 로딩이 되면 실행되는 스크립트 작성
// jQuery -> $(function(){처리문 만들기}); = jQuery(function(){처리문 만들기});
$(function(){ // jQuery에서 익명함수를 전달해서 저장해놨다가 Document가 로딩이 다 되면 호출해서 처리해준다.
	// 삭제버튼을 클릭하면 실제적으로 삭제를 진행할 건지에 대한 여부를 물어본다.
	$("#deleteBtn").click(function(){
		if(!confirm("정말로 삭제하시겠습니까?")) return false; // a tag의 이동 취소
	});
});	
</script>
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
<h1>Notice</h1>
<table class="table">
	<thead>
	</thead>	
	<tbody>
		<tr>
			<th>글번호</th>
			<td class="no">${vo.no }</td>
		</tr>
		<tr>	
			<th>제목</th>
			<td>${vo.title }</td>
		</tr>
		<tr>	
			<th></th>
			<td ><pre style="background: #fff; border: none; font-family: 'Hana_handwriting'; font-size: 20px; padding: 0px; ">${vo.content }</pre></td>
		</tr>
		<tr>	
			<th>공지시작일</th>
			<td>${vo.startDate }</td>
		</tr>
		<tr>	
			<th>공지종료일</th>
			<td>${vo.endDate }</td>
		</tr>
		<tr>	
			<th>작성일</th>
			<td>${vo.writeDate }</td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
		<tr>
			<td colspan="5">
			<!-- 관리자로 로그인이 되어 있을 경우 -->
			<c:if test="${login.gradeNo == 9 }">
			<div>
				<a href="updateForm.do?no=${vo.no }&page=${pageObject.page }&perPageNum=${pageObject.perPageNum}" class="btn btn-default" style="font-size: 20px;">Modify</a>
				<a href="delete.do?no=${vo.no }&perPageNum=${pageObject.perPageNum}" class="btn btn-default" 
				id="deleteBtn" style="font-size: 20px;">Delete</a>
				<a href="list.do?&page=${pageObject.page }&perPageNum=${pageObject.perPageNum}" class="btn btn-default" style="font-size: 20px;">List</a>
			</div>
			</c:if>
			<!-- 일반회원으로 로그인이 되어 있을 경우 -->
			<c:if test="${login.gradeNo == 1 }">
			<a href="list.do?&page=${pageObject.page }&perPageNum=${pageObject.perPageNum}" class="btn btn-default" style="font-size: 20px;">List</a>
			</c:if>
			<!-- 로그인을 하지 않은 경우 -->
			<c:if test="${empty login }">
			<a href="list.do?&page=${pageObject.page }&perPageNum=${pageObject.perPageNum}" class="btn btn-default" style="font-size: 20px;">List</a>
			</c:if>
			</td>
		</tr>
	</tfoot>
</table>
</div>
</body>
</html>