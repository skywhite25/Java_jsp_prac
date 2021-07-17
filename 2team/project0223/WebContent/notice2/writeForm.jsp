<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항2 글쓰기 폼</title>

  <!-- Bootstrap 라이브러리 등록 - CDN방식 -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/formUtil.js"></script>
<script type="text/javascript">
$(function(){
	// 이벤트 처리
	$("#writeForm").submit(function(){
		if(!require($("#title"), "제목")) return false;
		if(!require($("#content"), "내용")) return false;
		if(!checkLength($("#title"), "제목", 2)) return false;
		if(!checkLength($("#content"), "내용", 2)) return false;
		
	});
	$("#cancelBtn").click(function(){
		// alert("취소");
		history.back();
	});
});
</script>
</head>

<body>
<div class="container">
<h1>공지사항2 글쓰기 </h1>
	<form action="write.jsp" id="writeForm" method="post">
		<div class="form-group">
			<!-- 제목 -->
			<label for="title">제목</label>
			<!-- input tag의 기본 type을 text입니다. 그래서 생략 가능하다. -->
			<input name="title" class="form-control" id="title"
			 required="required" placeholder="제목을(를) 입력해주세요.">
		</div>
		<div class="form-group">
			<!-- 내용 -->
			<label for="content">내용</label>
			<textarea rows="7" name="content" class="form-control" id="content"
			 required="required" placeholder="내용을(를) 입력해주세요."></textarea>
		</div>
		<div class="form-group">
			<!-- -->
			<label for="startDate" >공지시작일</label>
			<!-- input tag의 기본 type을 text입니다. 그래서 생략 가능하다. -->
			<input name="startDate" class="form-control" id="startDate"
			 required="required" type="date">
		</div>
		<div class="form-group">
			<!-- -->
			<label for="endDate" >공지종료일</label>
			<!-- input tag의 기본 type을 text입니다. 그래서 생략 가능하다. -->
			<input name="endDate" class="form-control" id="endDate"
			 required="required" type="date">
		</div>
		<button class="btn btn-default">등록</button>
		<button type="reset" class="btn btn-default">초기화</button>
		<button type="button" id="cancelBtn" class="btn btn-default">취소</button>
	</form>
</div>
</body>
</html>