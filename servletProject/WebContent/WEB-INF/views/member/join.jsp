<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입</h1>
<!-- url#id - [url]#id, # - 임시링크, action="url"을 생략하면 같은 url에 데이터를 전송하고 페이지 이동 -->
<form action="#">
	<label>아이디 - 문자열 - text</label> <br/>
		<input name="id" /> <br/>
	<label>비밀번호 - 보이지 않는 문자열 - password</label> <br/>
		<input name = "pw" type="password" /> <br/>
	<label>비밀번호확인 - 보이지 않는 문자열 - password</label> <br/>
		<input name = "pw2" type="password" /> <br/>
	<label>이름 - 문자열</label> <br/>
		<input name = "name" /> <br/>
	<label>성별 - 버튼 클릭(하나만 선택 - name이 같아야 한다.) - radio</label> <br/>
	<label>
		<input name = "gender" type = "radio" value = "남자" checked="checked" /> 남자
	</label>
	<label>
		<input name = "gender" type = "radio" value = "여자" /> 여자
		</label> <br/>
	<label>생년월일 - yyyy-mm-dd - 문자열 3칸 - birth[]로 받을 수 있다.</label> <br/>
	<input name="birth" />-<input name="birth" />-<input name="birth" /> <br/>
	<label>연락처 - xxx-xxxx-xxxx - 풀다운 : select tag ,text, text - tel[]로 받는다.</label> <br/>
<select name = "tel">
<option selected="selected">010</option>
<option>011</option>
<option>016</option>
<option>017</option>
<option>018</option>
<option>019</option>
<option>070</option>
</select> - <input name="tel" /> - <input name="tel" /> <br/>
<label>이메일 - xxxx @ 풀다운 - select </label> <br/>
<input name="email" /> @ 
<select name="email" > 
<option>daum.net</option>
<option>gmail.net</option>
<option>nate.com</option>
<option>naver.com</option>
<option>직접입력</option>
</select>
<input name="email" id="direct_email"/>
<br/>
<button>가입</button>

</form>
</body>
</html>