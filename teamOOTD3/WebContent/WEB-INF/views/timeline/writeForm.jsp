<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타임라인 등록</title>

<script type="text/javascript">
// 하용되는 이미지 파일 형식들
var imageExt = ["JPG", "JPEG", "GIF", "PNG"];

$(function(){
	$("#writeForm").submit(function(){
		// 첨부파일이 이미지 파일인지 알아내는 프로그램 작성 -> 확장자 : 파일명의 마지막 "." 이후의 글자
		var fileName = $("#fileName").val();
		// substring(시작[, 끝]) - 부분 문자열 잘라내기
		// lastIndexOf(찾는 문자열) - 뒤에서 부터 찾는 문자열의 위치. 찾는 문자열이 없으면 -1이 된다.
		// toUpperCase -> 모든 영문자를 대문자로 만들어준다. <--> toLowerCase()
		var ext = fileName.substring(fileName.lastIndexOf(".")+1).toUpperCase();
		
		// 이미지 확장자인지 확인하는 반복문
		var checkExt = false; // 지원하지 않는 확장자를 기본으로 셋팅
		for(i = 0; i < imageExt.length; i++) {
			if(ext == imageExt[i]){
				checkExt = true; // 지원하는 확장자로 바꾼다.
				break;
			}
		}
		// 지원하지 않는 이미지 파일 선택경우의 처리
		if(!checkExt){
			alert("지원하지 않는 이미지 파일입니다.");
			$("#fileName").focus();
			return false;
		}
			
		// submit을 취소
		// return false;
	});
});
</script>

</head>
<body>
<div class="container">
	<h1>이미지 등록</h1>
	<!-- 파일첨부를 하는 입력에는 반드시 post방식이어야 하고 enctype 을 지정해야만 한다.
	input tag의 type="file"로 지정한다. -->
		<form action="write.do" method="post" enctype="multipart/form-data" id="writeForm">
		<input name="perPageNum" value="${param.perPageNum }" type="hidden">
			<div class="form-group">
				<label for="title">제목</label>
				<input name="title" id="title" class="form-control" />
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<textarea name="content" id="content" class="form-control" rows="5"></textarea>
			</div>
			<div class="form-group">
				<label for="fileName">이미지 파일(JPG,JPEG,GIF,PNG - 이미지 지원)</label>
				<input name="fileName" id="fileName" type="file" class="form-control" />
			</div>
			<button class="btn btn-default">올리기</button>
			<button type="reset" class="btn btn-default">새로입력</button>
			<button type="button" id="cancelBtn" class="btn btn-default">취소</button>
		</form>
</div>
</body>
</html>