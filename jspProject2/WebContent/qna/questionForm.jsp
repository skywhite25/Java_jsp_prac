<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문하기</title>
<!-- 	 <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!-- 	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<!-- 	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> -->
<!-- 	 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->



<!-- fromUtil.js 등록 -->
<script type="text/javascript" src="../js/formUtil.js"></script>
<style type="text/css">
.dataRow:hover{
	cursor: pointer;
	background: #eee;
</style>

<script type="text/javascript">
$(function(){ 
	$("#cancelBtn").click(function(){
		history.back();
	});	
	
	// submit() 이벤트에 데이터 검사
	$("writeForm").submit(function(){
		alert("데이터 전달 이벤트");
		
		// 필수 입력
		// 제목
		if(!require($("#title"),"제목")) return false;
		// 내용
		if(!require($("#content"),"내용")) return false;
		// 길이
		// 제목 4자 이상
		if(!checkLength($("#title"), "제목", 4)) return false;
		// 내용 4자 이상
		if(!checkLength($("#content"), "내용", 4)) return false;
		
	});
		//submit 이벤트 취소
		return true;
});
</script>
</head>
<body>
<div class="container">
	<h1>질문하기</h1>
	<form action="question.jsp" method="post" id="writeForm">
		<div class="form-group">
			<label for="title">제목</label>
			<input name="title" class="form-control" id="title" placeholder="3글자 이상 20자 이내 입력" required="required">
		</div>	
		<div class="form-group">
			<label for="content">내용</label>
			<textarea rows="7" name="content" class="form-control" id="content" placeholder="10글자 이상 1000자 이내 입력" required="required"></textarea>
		</div>	
	<button class="btn btn-default">등록</button>
	<button class="btn btn-default" type="reset">새로입력</button>
	<button class="btn btn-default" type="button" id="cancelBtn">취소</button>
	</form>
</div>
</body>
</html>