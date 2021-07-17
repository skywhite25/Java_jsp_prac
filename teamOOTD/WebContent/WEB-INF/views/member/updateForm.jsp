<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 수정</title>

<!-- formUtil.js 등로 -->
<script type="text/javascript" src="../js/formUtil.js"></script>

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
  width: 32.5%;
  padding: 0px 20px;
  height: 51px;
  margin: 4px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
input[type=email]{
  width: 100%;
  padding: 0px 20px;
  height: 51px;
  margin: 4px 0;
  border: 1px solid #ccc;
  border-radius: 4px;
}
.updateBtn {
  width: 100%;
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
select{
  width: 33%;
  padding: 0px 15px;
  height: 51px;
  margin: 2px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
.gender {
  width: 100%;
}
</style>
<script type="text/javascript">
// 객체 선택에 문제가 있다. 아래 Document가 다 로딩이 되면 실행되는 스크립트 작성
// jquery -> $(function(){처리문 만들기;}) = jquery(function(){처리문 만들기;})
$(function(){ // jquery에서 익명함수를 전달해서 저장해놨다가 Document가 로딩이 다되면 호출해서 처리해준다.
	$("#updateBtn").click(function(){
		if($("#checkBt").hasClass("alert-warning")) return false;
		return true;
	});
    var bt_error = "태어난 년도와 전화번호를 정확하게 입력하세요.";
    var btday1_error = "미래에서 오셨군요. ^^";
    var bt_success = "";
    $("#yy, #mm, #dd, #tel2, #tel3").keyup(function(){
    	//alert("값변경"); 태어난 년도와 전화번호를 정확하게 입력하세요.
    	$("#checkBt").removeClass("alert-warning alert-success").show();
    	var yy_val = $("#yy").val();
    	var mm_val = $("#mm").val();
    	var dd_val = $("#dd").val();
    	var bir_val = (yy_val + mm_val + dd_val);
    	let today = new Date();   
    	let year = today.getFullYear();
    	let month = today.getMonth() + 1;
    	let date = today.getDate();
    	var tod_val =(year + '' + month + '' + date);
    	var tel2_val = $("#tel2").val();
    	var tel3_val = $("#tel3").val();
    	if(yy_val.length < 4 || tel2_val.length < 4 || tel3_val.length < 4){
    		$("#checkBt").text(bt_error).addClass("alert-warning");
    		return false;
    	}
    	if(tod_val < bir_val){
    		$("#checkBt").text(btday1_error).addClass("alert-warning");
    		return false;
    	}
   		$("#checkBt").text(bt_success).addClass("alert-success").hide();
   		return true;
    });
});
</script>

</head>
<body>
<div id="wrap">
	<div id="container">
		<form action="update.do" id="updateForm" method="post">
			<div class="form-group">
				<label for="id">아이디</label>
				<input pattern="[A-Za-z][A-Za-z0-9]{2,19}" type="text" id="id" name="id" class="form-control" required="required" readonly="readonly" value="${vo.id }">
			</div>
			<div class="form-group">
				<label for="name">이름</label>
				<input type="text" id="name" name="name" maxlength="20" class="form-control" autocomplete="off" required="required" value="${vo.name }">
			</div>
			<div class="form-group">
				<label for="alias">닉네임</label>
				<input type="text" id="alias" name="alias" maxlength="20" class="form-control" autocomplete="off" required="required" value="${vo.alias }">
			</div>
			<div class="form-group">
				<label for="gender">성별</label><br>
					<select id="gender" name="gender" class="gender" required="required">
						<option value="남자">남자</option>
						<option value="여자">여자</option>
						<option value="선택안함">선택 안함</option>
					</select>
			</div>
			<div class="form-group">
				<label for="birth">생년월일</label><br>
					<input type="datetime" id="yy" name="birth" maxlength="4" class="form-control" placeholder="년(4자)" autocomplete="off" required="required" pattern="[0-9]+">
						<select id="mm" name="birth" class="class">
							<option value="01">01</option>
							<option value="02">02</option>
							<option value="03">03</option>
							<option value="04">04</option>
							<option value="05">05</option>
							<option value="06">06</option>
							<option value="07">07</option>
							<option value="08">08</option>
							<option value="09">09</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
						</select>
					<input type="datetime" id="dd" name="birth" maxlength="2" class="form-control" placeholder="일" autocomplete="off" required="required" pattern="[0-9]+">
			</div>
			<div class="form-group">
				<label for="tel">전화번호</label><br>
					<select id="tel1" name="tel" class="class">
							<option selected>010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="017">017</option>
							<option value="018">018</option>
							<option value="019">019</option>
						</select>
					<input type="datetime" id="tel2" name="tel" size="4" maxlength="4" class="form-control" autocomplete="off" required="required" pattern="[0-9]+">
					<input type="datetime" id="tel3" name="tel" size="4" maxlength="4" class="form-control" autocomplete="off" required="required" pattern="[0-9]+">
				<div id="checkBt" class="alert alert-warning" style="display:none;">태어난 년도와 전화번호를 정확하게 입력하세요.</div>
			</div>
			<div class="form-group">
				<label for="email">이메일</label>
				<input type="email" id="email" name="email" maxlength="20" class="form-control" required="required" value="${vo.email }">
			</div>
				<button id="updateBtn" class="updateBtn">수정하기</button>
		</form>
	</div>
</div>
</body>
</html>
