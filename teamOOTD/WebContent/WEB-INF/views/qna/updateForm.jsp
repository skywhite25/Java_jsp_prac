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
  <style>
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
  <!-- 부트스트랩 라이브러리와 마우스가 올라 갔을 때의 CSS는 default_decorator.jsp 에서 전체적으로 잡음. -->

<!-- formUtil.js 등록 -->
<script type="text/javascript" src="../js/formUtil.js"></script>

<script type="text/javascript">
$(function(){ 

	$("#writeForm").submit(function(){

		if(!require($("#title"), "제목")) return false;
		// 내용
		if(!require($("#content"), "내용")) return false;

		// 제목 4자 이상
		if(!checkLength($("#title"), "제목", 4)) return false;
		// 내용 4자 이상
		if(!checkLength($("#content"), "내용", 4)) return false;
		
	});
	
});
</script>

</head>
<body>
<div class="container f">
<h1>답변</h1>
<form action="update.do" id="writeForm" method="post">
	<!-- 안보이면서 넘겨가는 데이터 셋팅 -->
	<input name="page" value="${pageObject.page }" type="hidden">
	<input name="perPageNum" value="${pageObject.perPageNum }" type="hidden">
	<!-- 보여지는 데이터 -->
	<div class="form-group">
		<label for="no">번호</label>
		<input name="no" id="no" class="form-control" readonly="readonly"
		value="${vo.no }"
		placeholder="제목은  4글자이상 입력해야 합니다."/>
	</div>
	<div class="form-group">
		<label for="title">제목</label>
		<input name="title" id="title" class="form-control" required="required"
		value="${vo.title }"
		placeholder="제목은 4글자이상 입력해야 합니다."/>
	</div>
	<div class="form-group">
		<label for="content">내용</label>
		<textarea name="content" id="content" rows="10" required="required"
		placeholder="내용은 4글자이상 입력해야 합니다." class="form-control">${vo.content }</textarea>
	</div>
	<button class="btn btn-default">수정</button>
	<button type="reset" class="btn btn-default">새로입력</button>
	<button type="button" class="btn btn-default cancelBackBtn">취소</button>
</form>
</div>
</body>
</html>