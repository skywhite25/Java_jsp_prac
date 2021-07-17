<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 글쓰기 폼</title>

	<!-- 부트스트랩 라이브러리 등록 - CDN 방식 -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
	<!-- formUtil.js 등록 -->
<script type="text/javascript" src="../js/formUtil.js"></script>
	
<script type="text/javascript">
$(function(){
	
	// 이벤트 처리
	// 취소 버튼 - 이전 페이지(리스트)로 돌아간다.
	$("#cancelBtn").click(function(){
		// alert("취소");
		// 이전페이지로 이동
		history.back();
	});
	
	// submit() 이벤트에 데이터 검사
	$("#writeForm").submit(function(){
		// alert("데이터 전달 이벤트");
		
		// 필수 입력
		// 제목
		// alert(!require($("#title"), "제목"));
		if(!require($("#title"), "제목")) return false;
		// 내용
		if(!require($("#content"), "내용")) return false;
		// 공지시작일
		if(!require($("#startDate"), "공지시작일")) return false;
		// 공지종료일
		if(!require($("#endDate"), "공지시작일")) return false;
		
		// 길이
		// 제목 4자 이상
		if(!checkLength($("#title"), "제목", 4)) return false;
		// 내용 4자 이상
		if(!checkLength($("#content"), "내용", 4)) return false;
		
	});
	
});

</script>

</head>
<body>
<div class="container">
<h1>게시판 글쓰기</h1>
	<form action="write.jsp" id="writeForm" method="post">
		<div class="form-group">
			<label for="title">제목</label>
			<input name="title" id="title" class="form-control" required="required"
			 placeholder="제목 입력 - 4자 이상 입력하셔야 합니다.">
		</div>
		
		<div class="form-group">
			<label for="content">내용</label>
			<textarea name="content" id="content" rows="5" class="form-control" required="required"
			 placeholder="내용입력 - 내용을 입력하셔야 합니다."></textarea>
		</div>
		
		<div class="form-group">
			<label for="startDate" >공지시작일</label>
			<input name="startDate" id="startDate" class="form-control"  required="required" type="date">
		</div>
		
		<div class="form-group">
			<label for="endDate" >공지종료일</label>
			<input name="endDate" id="endDate" class="form-control"  required="required" type="date">
		</div>
		
		<!-- 데이터를 전송하는 type="submit" 버튼 - 버튼의 기본이므로 생략 가능한다. -->
		<button class="btn btn-default">등록</button>
		<!-- 데이터를 새로 입력하는 type = "reset" 버튼 -->
		<button type="reset" class="btn btn-default">새로입력</button>
		<!-- 취소하려면 버튼모양으로 사용(type="button")하고 취소의 동작을 JS로 작성한다.
			history.back() : 이전 페이지로 이동 -->
		<button type="button" onclick="history.back()" class="btn btn-default">취소</button>
		
	</form>
	</div>
</body>
</html>