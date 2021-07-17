<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기 폼</title>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript" src="../js1/formUtil.js"></script>

<script type="text/javascript">
$(function(){
	$("#writeForm").submit(function(){
		if(!require($("#title"), "제목"))
			return false;
		if(!require($("#content"), "내용"))
			return false;
		if(!require($("#writer"), "작성자"))
			return false;
	
		if(!checkLength($("#title"), "제목", 3))
			return false;
		if(!checkLength($("#content"), "내용", 3))
			return false;
		if(!checkLength($("#writer"), "작성자", 2))
			return false;
	});
});
</script>


</head>


<body>
<div class="container">
<h1>글쓰기 폼</h1>
	<form action="write.jsp" method="post" id="writeForm">
	<div class="form-group">
		<label for="title">제목</label>
		<input name="title" id="title" class="form-control">
	</div>
	<div class="form-group">
		<label for="content">내용</label>
		<textarea rows="7" name="content" id="content" class="form-control"></textarea>
	</div>
	<div class="form-group">
		<label for="writer">작성자</label>
		<input name="writer" id="writer" class="form-control">
	</div>
	
	<button class="btn btn-default">등록</button>
	<button type="reset" class="btn btn-default">새로입력</button>
	<button type="button" class="btn btn-default" onclick="history.back();">취소</button>
	</form>
	
</div>
</body>
</html>