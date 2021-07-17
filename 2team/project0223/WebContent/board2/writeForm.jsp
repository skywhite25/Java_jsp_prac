<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 글쓰기</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!--  -->
<script type="text/javascript" src="../js/formUtil.js"></script>
<style type="text/css">
.dataRow:hover{
	cursor: pointer;
	background: #eee;
}
</style>

<script type="text/javascript">

$(function(){ 
	
	$("#cancleBtn").click(function(){

		histroy.back();
	});
	

	$("#writeForm").submit(function(){
		alert("데이터 전달 이벤트");
		
			if(!require($("#title"),"제목"))return false; 
			//내용
			if(!require($("#content"),"내용"))return false; 
			//작성자
			if(!require($("#writer"),"작성자"))return false; 
		//길이
		//제목 4자 
		if(!checkLength("#title"), "제목", 4) return false;
		//내용 4자 
		if(!checkLength("#content"), "내용", 4) return false;
		//작성자 2자 
		if(!checkLength("#writer"), "작성자", 2) return false;
		
		return false;
	});
	
});
</script>

</head>
<body>
<div class="container">
<h1>글쓰기 </h1>
<form action="write.jsp" id="writeForm" method="post">
<div class="form-group">
	<label for="title">제목</label>
	<input name="title" id="title" class="form-control" required="required"
		placeholder="제목을 입력하세요"	/>
		</div>
<div class="form-group">
	<label for="content">내용</label>
	<textarea name="content" id="content" rows="5"required="required"
	placeholder="내용을 입력하세요" class="form-control"></textarea>
</div>
<div class="form-group">
	<label for="writer">작성자</label>
	<input name="writer" id="writer" class="form-control"required="required"
	placeholder="이름을 입력하세요."	/>
</div>		
<button>등록</button>
<button type="reset">새로입력</button>
<button type="button" id="cancelBtn">취소</button>
</Form>
</div>
</body>
</html>