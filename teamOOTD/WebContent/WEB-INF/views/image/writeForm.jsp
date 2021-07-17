<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write Form</title>

<script type="text/javascript">
// 허용되는 이미지 파일 형식들
var imageExt = ["JPG", "JPEG", "GIF", "PNG"];

$(function(){
	// 전달할 때의 데이터 찍기
	$("#writeForm").submit(function(){
		
		// 첨부파일이 이미지 파일인지 알아내는 프로그램 작성 -> 확장자 = 파일명의 마지막 .이후의 글자
		var fileName = $("#imageFile").val();
		// substring(시작위치, 끝위치)(끝위치를 생략하면 마지막위치까지 찾는다.) : 부분 문자열 잘라내기
		// lastIndeOf(찾는 문자열) : 뒤에서부터 조건에 맞는 문자열까지 찾는다. 찾는 문자열이 없으면 -1이 된다.
		// toUpperCase() : 모든 영문자를 대문자로 만든다. <-> toLowerCase()
		var ext = fileName.substring(fileName.lastIndexOf(".")+1).toUpperCase();
		//alert(ext);
		
		// 이미지 확장자인지 확인하는 반복문
		var checkExt = false; // 지원하지 않는 확장자를 기본으로 셋팅
		
		for(i = 0; i < imageExt.length; i++){
			if(ext == imageExt[i]) { // 업로드한 이미지파일의 확장자가 imageExt배열에 있는 확장자이면
				checkExt = true; // 지원하는 확장자로 바꾼다.
				break;
			}
		}
		// 지원하지 않는 이미지 파일이 선택되었을 때의 처리
		if(!checkExt){
			alert("지원하지 않는 이미지 파일입니다.");
			$("#imageFile").focus();
			return false;
		}
		
	});
	
	$("#cancelBtn").click(function(){
		history.back();
	});
	
	$("#seasonNo").click(function(){
		// 클릭한 라디오 버튼의 값을 변수 seasonNo에 넣는다.
 		var seasonNo = $("#seasonNo input:radio:checked").val();
//  		alert(seasonNo);
 		$("#seasonNo").val([seasonNo]);

		
	});

	
	
});
</script>

<style type="text/css">
@font-face {
font-family: 'UhBeemysen';
src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_five@.2.0/UhBeemysen.woff') format('woff');
font-weight: normal;
font-style: normal;
}

.f {
	font-family: 'UhBeemysen';
	font-size: 28px;
}

.f2 {
	font-size: 30px;
}
</style>
</head>


<body>
<div class="container f">
<h1>[Write Form]</h1>
<!-- 파일 첨부를 하는 입력에는 반드시 post방식이어야 하고 enctype을 지정해야만 한다.
	input tag의 type="file"로 지정한다. -->
<form action="write.do" method="post" enctype="multipart/form-data" id="writeForm">
	<input name="perPageNum" value="${param.perPageNum }" type="hidden">
	<div class="form-group" id="seasonNo">
		<label for="season">SEASON</label><br>
			<input type="radio" id="spring" name="seasonNo" value="1">
			<label for="spring">spring</label>
			<input type="radio" id="summer" name="seasonNo" value="2">
			<label for="summer">summer</label>
			<input type="radio" id="autumn" name="seasonNo" value="3">
			<label for="autumn">autumn</label>
			<input type="radio" id="winter" name="seasonNo" value="4">
			<label for="winter">winter</label>
	</div>
	<div class="form-group">
		<label for="imageFile">Coordination FIle</label>
		<input type="file" id="imageFile" name="imageFile" class="form-control">
	</div>
	<div class="form-group">
		<label for="name1">Product name</label>
		<input id="name1" name="name1" class="form-control f2">
	</div>
	<div class="form-group">
		<label for="link1">Link</label>
		<input id="link1" name="link1" class="form-control f2">
	</div>
	<div class="form-group">
		<label for="name2">Product name</label>
		<input id="name2" name="name2" class="form-control f2">
	</div>
	<div class="form-group">
		<label for="link2">Link</label>
		<input id="link2" name="link2" class="form-control f2">
	</div>
	<div class="form-group">
		<label for="name3">Product name</label>
		<input id="name3" name="name3" class="form-control f2">
	</div>
	<div class="form-group">
		<label for="link3">Link</label>
		<input id="link3" name="link3" class="form-control f2">
	</div>
	<div class="form-group">
		<label for="name4">Product name</label>
		<input id="name4" name="name4" class="form-control f2">
	</div>
	<div class="form-group">
		<label for="link4">Link</label>
		<input id="link4" name="link4" class="form-control f2">
	</div>
	<div id="imageDiv">
		<img alt="" src="">
	</div>
	
	<button class="btn btn-default" style="font-size: 23px;">submit</button>
	<button type="reset" class="btn btn-default" style="font-size: 23px;">reset</button>
	<button type="button" id="cancelBtn" class="btn btn-default" style="font-size: 23px;">cancel</button>
</form>
</div>
</body>
</html>