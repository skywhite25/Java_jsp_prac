<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판1 글쓰기</title>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript" src="../js/formUtil.js"></script>
<script type="text/javascript">
$(function(){
	// 이벤트 처리
	// 데이터 전송 시 데이터의 유효성 검사 처리 이벤트
	$("#writeForm").submit(function(){
		// 비어 있는 항목 검사
		if(!require($("#title"), "제목")) return false;
		if(!require($("#content"), "내용")) return false;
		if(!require($("#writer"), "작성자")) return false;
		// 데이터의 길이 검사
		if(!checkLength($("#title"), "제목", 4)) return false;
		if(!checkLength($("#content"), "내용", 4)) return false;
		if(!checkLength($("#writer"), "작성자", 2)) return false;
	});
	
	// 취소 버튼
	$("#cancelBtn").click(function(){
		history.back();
	});
});
</script>

</head>
<body>
<div class="container">
	<h1>게시판1 글쓰기</h1>
	<form action="write.jsp" method="post" id="writeForm">
		<div class="form-group">
			<label for="title">제목</label>
			<input name="title" id="title" required="required" class="form-control" />
		</div>
		<div class="form-group">
			<label for="content">내용</label>
			<textarea name="content" id="content" required="required" rows="5"
			 class="form-control" ></textarea>
		</div>
		<div class="form-group">
			<label for="writer">작성자</label>
			<input name="writer" id="writer" required="required" class="form-control" />
		</div>
		<button>전송</button>
		<button type="reset">새로입력</button>
		<button type="button" id="cancelBtn">취소</button>
	</form>
</div>
</body>
</html>