<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice</title>
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
	
	@font-face {
    font-family: 'Hana_handwriting';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/naverfont_05@1.0/Hana_handwriting.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

.f {
	font-family: 'Hana_handwriting';
	font-size: 30px;
}
</style>

<script type="text/javascript">
$(function(){ 
	$("#cancelBtn").click(function(){
		history.back();
	});	
	
	// submit() 이벤트에 데이터 검사
	$("#writeForm").submit(function(){
// 		alert("데이터 전달 이벤트");
		
		// 필수 입력
		// 제목
		if(!require($("#title"),"제목")) return false;
		// 내용
		if(!require($("#content"),"내용")) return false;
		// 공지시작일
		if(!require($("#startDate"),"공지시작일")) return false;
		// 공지종료일
		if(!require($("#endDate"),"공지종료일")) return false;
		// 길이
		// 제목 4자 이상
		if(!checkLength($("#title"), "제목", 5)) return false;
		// 내용 4자 이상
		if(!checkLength($("#content"), "내용", 5)) return false;
		
	});
		//submit 이벤트 취소
		return false;
});
</script>
</head>
<body>
<div class="container f">
	<h1>Notice</h1>
	<form action="write.do" method="post" id="writeForm">
	<input name="perPageNum" type="hidden" value="${pageObject.perPageNum }">
		<div class="form-group">
			<label for="title">제목</label>
			<input name="title" class="form-control" id="title" placeholder="5글자 이상 20자 이내 입력" 
			required="required" style="font-size: 20px;">
		</div>	
		<div class="form-group">
			<label for="content">내용</label>
			<textarea rows="7" name="content" class="form-control" id="content" 
			placeholder="5글자 이상 1000자 이내 입력" required="required" style="font-size: 20px;"></textarea>
		</div>	
		<div class="form-group">
			<label for="startDate">공지시작일</label>
			<input name="startDate" class="form-control" id="startDate" required="required" 
			type="date" style="font-size: 20px;">
		</div>	
		<div class="form-group">
			<label for="endDate">공지종료일</label>
			<input name="endDate" class="form-control" id="endDate" required="required" 
			type="date" style="font-size: 20px;">
		</div>	
	<button class="btn btn-default" style="font-size: 20px;">Modify</button>
	<button class="btn btn-default" type="reset" style="font-size: 20px;">Cancel</button>
	<button class="btn btn-default" type="button" id="cancelBtn" style="font-size: 20px;">Back</button>
	</form>
</div>
</body>
</html>