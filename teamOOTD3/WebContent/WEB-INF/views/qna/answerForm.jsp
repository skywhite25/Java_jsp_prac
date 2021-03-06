<%@page import="com.OOTD.util.filter.AuthorityFilter"%>
<%@page import="com.OOTD.main.controller.Beans"%>
<%@page import="com.OOTD.main.controller.ExeService"%>
<%@page import="com.OOTD.qna.vo.QnaVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변</title>
  

<!-- formUtil.js 등로 -->
<script type="text/javascript" src="../js/formUtil.js"></script>

<script type="text/javascript">
$(function(){ 
	$("#cancelBtn").click(function(){

		history.back();
	});

	$("#writeForm").submit(function(){
		if(!require($("#title"), "제목")) return false;
		// 내용
		if(!require($("#content"), "내용")) return false;
		
		// 제목 
		if(!checkLength($("#title"), "제목", 4)) return false;
		// 내용
		if(!checkLength($("#content"), "내용", 4)) return false;
		
	});
	
});
</script>

</head>
<body>
<div class="container">
<h1>대답하기</h1>
<form action="answer.do" id="writeForm" method="post">
	<input name="refNo" value="${vo.refNo }" type="hidden">
	<input name="ordNo" value="${vo.ordNo }" type="hidden">
	<input name="levNo" value="${vo.levNo }" type="hidden">

	<div class="form-group">
		<label for="no">번호</label>
		<input name="no" id="no" class="form-control" readonly="readonly"
		value="${vo.no }"
		placeholder="제목을 4자이상 입력하셔야 합니다."/>
	</div>
	<div class="form-group">
		<label for="title">제목</label>
		<input name="title" id="title" class="form-control" required="required"
		value="[답변]${vo.title }"
		placeholder="제목을 4자이상 입력하셔야 합니다."/>
	</div>
	<div class="form-group">
		<label for="content">내용</label>
		<textarea name="content" id="content" rows="10" required="required"
		placeholder="내용은 4자 이상 입력하셔야 합니다." class="form-control">


-----질문-------------------------------------------
${vo.content }
</textarea>
	</div>
	<button class="btn btn-default">등록</button>
	<button type="reset" class="btn btn-default">새로입력</button>
	<button type="button" id="cancelBtn" class="btn btn-default">취소</button>
</form>
</div>
</body>
</html>