<%@page import="com.OOTD.main.controller.Service"%>
<%@page import="com.OOTD.main.controller.Beans"%>
<%@page import="com.OOTD.main.controller.ExeService"%>
<%@page import="com.OOTD.member.vo.MemberVO"%>
<%@page import="com.OOTD.member.vo.LoginVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 보기</title>
  
  <!-- 부트스트랩 라이브러리와 마우스가 올라 갔을 때의 CSS는 default_decorator.jsp 에서 전체적으로 잡음. -->
<script type="text/javascript">
$(function(){
	$("#updateBtn").click(function(){
// 		alert("클릭함.");
// 		alert($("#accept_box").is(":checked"));
		location = "updateForm.do";
	});
	$("#changeBtn").click(function(){
		location = "changeForm.do";
	});
	$("#deleteBtn").click(function(){
		location = "deleteForm.do";
	});
});
</script>
<style>
html{background-color:#f5f6f7;}#wrap{background-color:#f5f6f7;}
#container{width:500px;height:100%;margin:0 auto;text-align:left;padding:20px 20px 0 20px;}
input[type=text]{
  width: 100%;
  padding: 0px 20px;
  height: 51px;
  margin: 4px 0;
  border: 1px solid #ccc;
  border-radius: 4px;
}
input[type=datetime]{
  width: 32.72%;
  padding: 0px 20px;
  height: 51px;
  margin: 4px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
input[type=tel]{
  width: 100%;
  padding: 0px 20px;
  height: 51px;
  margin: 2px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
.updateBtn {
  width: 32.72%;
  background-color: #03C75A;
  color: #ffffff;
  padding: 0px 20px;
  height: 51px;
  margin: 4px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size:18px;
  font-weight:700;
}
.changeBtn {
  width: 32.72%;
  background-color: #1E90FF;
  color: #ffffff;
  padding: 0px 20px;
  height: 51px;
  margin: 4px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size:18px;
  font-weight:700;
}
.deleteBtn {
  width: 32.72%;
  background-color: #8E8E8E;
  color: #ffffff;
  padding: 0px 20px;
  height: 51px;
  margin: 4px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size:18px;
  font-weight:700;
}
</style>
</head>
<body>
<div id="wrap">
	<div id="container">
			<div class="form-group">
				<label for="id">아이디</label>
				<input type="text" class="form-control" readonly="readonly" value="${vo.id }">
			</div>
			<div class="form-group">
				<label for="name">이름</label>
				<input type="text" class="form-control" readonly="readonly" value="${vo.name }">
			</div>
			<div class="form-group">
				<label for="alias">닉네임</label>
				<input type="text" class="form-control" readonly="readonly" value="${vo.alias }">
			</div>
			<div class="form-group">
				<label for="gender">성별</label><br>
				<input type="tel" class="form-control" readonly="readonly" value="${vo.gender }">
			
			</div>
			<div class="form-group">
				<label for="birth">생년월일</label><br>
					<input type="datetime" class="form-control" readonly="readonly" value='${(!empty vo.birth) ? vo.birth.split("-")[0] : "" }'>
					<input type="datetime" class="form-control" readonly="readonly" value='${(!empty vo.birth) ? vo.birth.split("-")[1] : "" }'>
					<input type="datetime" class="form-control" readonly="readonly" value='${(!empty vo.birth) ? vo.birth.split("-")[2] : "" }'>
			</div>
			<div class="form-group">
				<label for="tel">전화번호</label><br>
					<input type="datetime" class="form-control" readonly="readonly" value='${(!empty vo.tel) ? vo.tel.split("-")[0] : "" }'>
					<input type="datetime" class="form-control" readonly="readonly" value='${(!empty vo.tel) ? vo.tel.split("-")[1] : "" }'>
					<input type="datetime" class="form-control" readonly="readonly" value='${(!empty vo.tel) ? vo.tel.split("-")[2] : "" }'>
			</div>
			<div class="form-group">
				<label for="email">이메일</label>
				<input type="text" class="form-control" readonly="readonly" value="${vo.email }">
			</div>
				<button id="updateBtn" class="updateBtn">내 정보 수정</button>
				<button id="changeBtn" class="changeBtn">비밀번호변경</button>
				<button id="deleteBtn" class="deleteBtn">회원 탈퇴</button>
	</div>
</div>
</body>
</html>