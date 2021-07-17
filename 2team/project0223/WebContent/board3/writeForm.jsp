<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판3 글쓰기</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>



<style type="text/css">
.dataRow:hover{
	cursor: pointer;
	background: #eee;
</style>
<!-- fromUtil.js 등록 -->
<script type="text/javascript" src="../js3/formUtil.js"></script>

<script type="text/javascript">
$(function(){ 
	
	// submit() 이벤트에 데이터 검사
	$("#writeForm").submit(function(){
// 		alert("데이터 전달 이벤트");
		
		// 필수 입력
		// 제목
		if(!require($("#title"),"제목")) return false;
		if(!require($("#content"),"내용")) return false;
		if(!require($("#writer"),"작성자")) return false;
		// 길이
		if(!checkLength($("#title"), "제목", 4)) return false;
		if(!checkLength($("#content"), "내용", 4)) return false;
		if(!checkLength($("#writer"), "작성자", 2)) return false;
	});
		//submit 이벤트 취소
	$("#cancelBtn").click(function(){
		history.back();
	});	
});
</script>
</head>
<body>
<div class="container">
	<h1>게시판3 글쓰기</h1>
	<form action="write.jsp" method="post" id="writeForm">
		<div class="form-group">
			<label for="title">제목</label>
			<input name="title" class="form-control" id="title" required="required" />
		</div>	
		<div class="form-group">
			<label for="content">내용</label>
			<textarea rows="7" name="content" class="form-control" id="content" required="required" ></textarea>
		</div>	
		<div class="form-group">
			<label for="writer">작성자</label>
			<input name="writer" class="form-control" id="writer" required="required" />
		</div>	
	<button>등록</button>
	<button type="reset">새로입력</button>
	<button type="button" id="cancelBtn">취소</button>
	</form>
</div>
</body>
</html>