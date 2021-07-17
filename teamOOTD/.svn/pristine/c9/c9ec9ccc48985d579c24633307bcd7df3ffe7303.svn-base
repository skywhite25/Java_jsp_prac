<%@page import="com.OOTD.main.controller.Beans"%>
<%@page import="com.OOTD.image.vo.ImageVO"%>
<%@page import="com.OOTD.util.filter.AuthorityFilter"%>
<%@page import="com.OOTD.main.controller.ExeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String strNo = request.getParameter("no");
long no = Long.parseLong(strNo);

String url = "/image/view.jsp";
ImageVO vo = (ImageVO) ExeService.execute(Beans.getService(url), no);

request.setAttribute("vo", vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 수정</title>

<script type="text/javascript">
$(function(){
	$("#cancelBtn").click(function(){
		history.back();
	});

	$("#seasonNo").click(function(){
		// 클릭한 라디오 버튼의 값을 변수 seasonNo에 넣는다.
 		var seasonNo = $("#seasonNo input:radio:checked").val();
 		alert(seasonNo);
 		$("#seasonNo").val([seasonNo]);
	});
});
</script>

</head>


<body>
<div class="container">
<h1>정보 수정 폼</h1>
	<form action="update.jsp" method="post">
	<div class="form-group">
		<label for="no">번호</label>
		<input name="no" id="no" class="form-control" readonly="readonly" value="${vo.no }">
	</div>
	<div class="form-group" id="seasonNo">
		<label for="season">계절</label><br>
			<input type="radio" id="spring" name="seasonNo" value="1">
			<label for="spring">봄</label>
			<input type="radio" id="summer" name="seasonNo" value="2">
			<label for="summer">여름</label>
			<input type="radio" id="autumn" name="seasonNo" value="3">
			<label for="autumn">가을</label>
			<input type="radio" id="winter" name="seasonNo" value="4">
			<label for="winter">겨울</label>
	</div>
	<div class="form-group">
		<label for="name1">모자</label>
		<input name="name1" id="name1" class="form-control" value="${vo.name1 }">
	</div>
	<div class="form-group">
		<label for="link1">모자링크</label>
		<input name="link1" id="link1" class="form-control" value="${vo.link1 }">
	</div>
	<div class="form-group">
		<label for="name2">상의</label>
		<input name="name2" id="name2" class="form-control" value="${vo.name2 }">
	</div>
	<div class="form-group">
		<label for="link2">상의링크</label>
		<input name="link2" id="link2" class="form-control" value="${vo.link2 }">
	</div>
	<div class="form-group">
		<label for="name3">하의</label>
		<input name="name3" id="name3" class="form-control" value="${vo.name3 }">
	</div>
	<div class="form-group">
		<label for="link3">하의링크</label>
		<input name="link3" id="link3" class="form-control" value="${vo.link3 }">
	</div>
	<div class="form-group">
		<label for="name4">신발</label>
		<input name="name4" id="name4" class="form-control" value="${vo.name4 }">
	</div>
	<div class="form-group">
		<label for="link4">신발링크</label>
		<input name="link4" id="link4" class="form-control" value="${vo.link4 }">
	</div>
	
	<button class="btn btn-default">수정</button>
	<button type="reset" class="btn btn-default">새로 입력</button>
	<button type="button" id="cancelBtn" class="btn btn-default">취소</button>
	</form>
</div>
</body>
</html>