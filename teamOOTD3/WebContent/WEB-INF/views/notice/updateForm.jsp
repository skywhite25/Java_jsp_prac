<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">



<title>공지사항 글수정</title>
<!--   <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!--   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> -->
<!--   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->



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
	$("#writeForm").submit(function(){
// 		alert("데이터 전달 이벤트");
		
		// 필수 입력
		// 제목
		if(!require($("#title"),"제목")) return false;
		// 내용
		if(!require($("#content"),"내용")) return false;
		// 작성자
		if(!require($("#startDate"),"공지시작일")) return false;
		if(!require($("#endDate"),"공지종료일")) return false;
		// 길이
		// 제목 4자 이상
		if(!checkLength($("#title"), "제목", 5)) return false;
		// 내용 4자 이상
		if(!checkLength($("#content"), "내용", 5)) return false;
		// 작성자 2자 이상
		
		//submit 이벤트 취소
		return false;
		
	});
});
</script>
</head>
<body>
<div class="container">
	<h1>공지사항 글수정</h1>
	<form action="update.do" method="post" id="updateForm">
	<input name="page" type="hidden" value="${pageObject.page }"/>
	<input name="perPageNum" type="hidden" value="${pageObject.perPageNum }"/>	
		<div class="form-group">
			<label for="no">번호</label>
			<input name="no" class="form-control" id="no" readonly="readonly" value="${vo.no}"/>
		</div>	
		<div class="form-group">
			<label for="title">제목</label>
			<input name="title" class="form-control" id="title"  required="required" placeholder="5글자 이상 20자 이내 입력" value="${vo.title}" />
		</div>
		<div class="form-group">
			<label for="content">내용</label>
			<textarea rows="7" name="content" class="form-control" id="content" required="required" placeholder="5글자 이상 1000자 이내 입력">${vo.content}</textarea>
		</div>	
		<div class="form-group">
			<label for="startDate">공지시작일</label>
			<input name="startDate" class="form-control" id="startDate" required="required" type="date" value="${vo.startDate}">
		</div>	
		<div class="form-group">
			<label for="endDate">공지종료일</label>
			<input name="endDate" class="form-control" id="endDate" required="required" type="date" value="${vo.endDate}">
		</div>	
		<div class="form-group">
			<label for="writeDate">작성일</label>
			<input name="writeDate" class="form-control" id="writeDate" readonly="readonly"  type="date" value="${vo.writeDate}">
		</div>	
	<button class="btn btn-default">수정</button>
	<button class="btn btn-default" type="reset">새로입력</button>
	<button class="btn btn-default" type="button" id="cancelBtn">취소</button>
	</form>
</div>
</body>
</html>