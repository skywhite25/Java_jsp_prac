<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문하기</title>
  
  <!-- 부트스트랩 라이브러리와 마우스가 올라 갔을 때의 CSS는 default_decorator.jsp 에서 전체적으로 잡음. -->

<!-- formUtil.js 등로 -->
<script type="text/javascript" src="../js/formUtil.js"></script>

<script type="text/javascript">
$(function(){ // jquery에서 익명함수를 전달해서 저장해놨다가 Document가 로딩이 다되면 호출해서 처리해준다.

	$("#questionForm").submit(function(){
		// alert("데이터 전달 이벤트");
;
		if(!require($("#title"), "제목")) return false;
		// 내용
		if(!require($("#content"), "내용")) return false;
		
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
<h1>질문하기</h1>
<form action="question.do" id="writeForm" method="post">
<div class="form-group">
	<label for="title">제목</label>
	<input name="title" id="title" class="form-control" required="required"
	placeholder="제목을 4자이상 입력하셔야 합니다."/>
</div>
<div class="form-group">
	<label for="content">내용</label>
	<textarea name="content" id="content" rows="5" required="required"
	placeholder="내용은 4자 이상 입력하셔야 합니다." class="form-control"></textarea>
</div>
<button class="btn btn-default">등록</button>
<button type="reset" class="btn btn-default">새로입력</button>
<button type="button" class="btn btn-default cancelBackBtn">취소</button>
</form>
</div>
</body>
</html>