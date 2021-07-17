<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<style>
@charset "utf-8";
html{
height: 916px;
}
*{margin:0;padding:0;}
body,button,input,select,table,textarea{width:100%;height:100%;font-family:Dotum,'돋움',Helvetica,sans-serif;font-size:15px;}
#wrap{width:100%;height:896.5px;margin:0 0;background-color:#f5f6f7;}
#container{width:500px;height:auto;margin:0 auto;text-align:left;padding:20px 20px 0 20px;padding-top:250px;}
input[type=text]{
  width: 100%;
  padding: 0px 20px;
  height: 51px;
  margin: 4px 0;
  border: 1px solid #ccc;
  border-radius: 4px;
}
input[type=password]{
  padding: 0px 20px;
  height: 51px;
  margin: 4px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
.button {
  width: 100%;
  background-color: #03C75A;
  color: #ffffff;
  padding: 0px 20px;
  height: 51px;
  margin: 4px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size:15px;
  font-weight:700;
}
</style>
</head>
<body>
<div id="wrap">
	<div id="container">
		<form action="login.do" method="post">
			<div class="form-group">
				<input pattern="[A-Za-z][A-Za-z0-9]{2,19}" type="text" id="id" name="id" class="form-control" autocomplete="off" required="required" maxlength="20" placeholder="아이디">
		</div>
		<div class="form-group">
			<input name="pw" id="pw" type="password" type="text" class="form-control" placeholder="비밀번호"/>
		</div>
		<button class="button">로그인</button>
	</form>
	</div>
</div>
</body>
</html>