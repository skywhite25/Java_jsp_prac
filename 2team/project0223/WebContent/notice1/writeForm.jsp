<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 작성</title>
	<!-- BootStrap CDN 방식 -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="../js/formUtil.js"></script>
   <script type="text/javascript" src="../js/formUtil.js"></script>
  <script type="text/javascript">
  $(function () {
	$("#cancelBtn").click(function () {
		history.back();
	});
	
	$("writeFrom").submit(function () {
		if(!require($("#title"),"제목"))return false;
		if(!require($("#content"),"내용"))return false;
		if(!require($("#startDate"),"공지시작일"))return false;
		if(!require($("#endDate"),"공지종료일"))return false;
	});
});
  
  </script>
</head>
<body>
<div class="container">
<h1>공지사항 작성</h1>
<form action="write.jsp" id="writeForm" method="post">
<div class = "form-=group">
<label for="title">제목</label>
<input name="title" class="form-control" id ="title" placeholder="3글자 이상 입력" required="required">
</div>
<div class = "form-=group">
<label for="content">내용</label>
<input name="content" class="form-control" id ="content" placeholder="3글자 이상 입력" required="required">
</div>
<div class = "form-=group">
<label for="startDate">공지시작일</label>
<input name="startDate" class="form-control" id ="startDate" type="date">
</div>
<div class = "form-=group">
<label for="endDate">공지종료</label>
<input name="endDate" class="form-control" id ="endDate"  type="date">
</div>
<button>등록</button>
<button type="reset">새로입력</button>
<button type="button" id="cancelBtn">취소</button>
</form>

</div>
</body>
</html>