<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<style type="text/css">
	.noticeDataRow:hover, .boardDataRow:hover {
		background: #eee;
		cursor: pointer;
		
	}
</style>
<script type="text/javascript">
$(function(){
	// 클릭 이벤트 처리
	$(".noticeDataRow, .boardDataRow").click(function(){
// 		alert("클릭");
		var no = $(this).find(".no").text();
// 		alert(no);
		// 클래스를 확인해서 어디로 갈지를 정한다.
		if($(this).hasClass("noticeDataRow")){
// 			alert("공지사항 클릭");
			location = "/notice/view.do?no=" + no;
		}	else if($(this).hasClass("boardDataRow")){
// 			alert("일반게시판 클릭");
			location = "/board/view.do?no=" + no + "&inc=1";
		}	
	});
});
</script>
<!--   <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!--   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> -->
<!--   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->

</head>
<body>
<div class="container">
<h1>메인 페이지</h1>
<!-- 공지사항 -->
<div class="panel panel-default">
  	<div class="panel-heading">공지사항</div>
  	<div class="panel-body">
	  	<table class="table">
		<!-- 제목 -->
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>공지시작일</th>
				<th>공지종료일</th>
				<th>최근수정일</th>
			</tr>
		</thead>
		<tbody>
			<!-- 데이터가 있는 만큼 반복이 되어지는 시작 부분 -->
			<c:forEach items="${noticeList }" var="vo">
			<tr class="noticeDataRow">
				<td class="no">${vo.no }</td>
				<td>${vo.title }</td>
				<td>${vo.startDate }</td>
				<td>${vo.endDate }</td>
				<td>${vo.updateDate }</td>
			</tr>
			</c:forEach>
			<!-- 데이터가 있는 만큼 반복이 되어지는 끝 부분 -->
		</tbody>
		</table>
  	</div>
</div>

<!-- 일반게시판-->
<div class="panel panel-default">
  <div class="panel-heading">일반게시판</div>
  <div class="panel-body">
  <table class="table">
	<!-- 제목 -->
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<!-- 데이터가 있는 만큼 반복이 되어 지는 시작 부분 -->
		<c:forEach items="${boardList }" var="vo">
		<tr class="boardDataRow">
			<td class="no">${vo.no }</td>
			<td>${vo.title }</td>
			<td>${vo.writer }</td>
			<td>${vo.writeDate }</td>
			<td>${vo.hit }</td>
		</tr>
		</c:forEach>
		<!-- 데이터가 있는 만큼 반복이 되어 지는 끝 부분 -->
	</tbody>
	
	</table>
  </div>
</div>

</div>
</body>
</html>