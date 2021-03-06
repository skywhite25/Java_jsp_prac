<%@page import="com.OOTD.image.vo.ImageVO"%>
<%@page import="com.OOTD.util.filter.AuthorityFilter"%>
<%@page import="com.OOTD.main.controller.Beans"%>
<%@page import="com.OOTD.main.controller.ExeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	System.out.println("/image/view.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>coordination</title>

<script type="text/javascript">
//허용되는 이미지 파일 형식들
var imageExt = ["JPG", "JPEG", "GIF", "PNG"];

$(function(){
	// 이미지 바꾸기 모달창의 바꾸기 버튼 이벤트 처리
	$("#changeBtn").click(function(){
		//alert("change");
		// 파일이 비어있는지 확인
		var fileName = $("#imageFile").val();
		//alert(fileName);
		
		// 바꿀 파일 란이 비어 있는 경우의 이벤트 처리
		if(!fileName){
			alert("바꿀 파일을 선택하세요.");
			$("#imageFile").focus();
			return false;
			}
		
		// 바꿀 파일란이 비어있지 않는 경우의 처리 - 지원하는 이미지 확인 처리를 해야 한다.
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
		
		// 강제적으로 폼 데이터를 전송한다.
		$("#updateFileForm").submit();
	});
	
	$(".delete").click(function(){
		if(!confirm("정말 삭제하시겠습니까?"))
			return false;
	});
	
	$(".replyDeleteBtn").click(function(){
		if(!confirm("정말 삭제하시겠습니까?"))
			return false;
	});

	$(".listBtn").click(function(){
		history.back();
	});
	
	// 댓글 등록 모달창 열기
	$("#writeReplyBtn").click(function(){
		//alert("댓글 달기");
		// 모달창의 제목 바꾸기
		$(".modal-title").text("댓글 달기");
		// 댓글 번호 안 보이기
		$("#modal_rno_div").hide();
		// 댓글 쓰기 처리 URL 설정
		// attr("action", "replyWrite.do") => action 속성을 replyWrite.do로 변경한다.
		$("#replyForm").attr("action", "replyWrite.do");
		// 댓글 내용과 작성자를 비워둔다 -> 수정을 하다가 취소를 누르면 내용이 그대로 남아있기 때문에 비워줘야 한다.
		$("#modal_content").val("");
// 		$("#modal_alias").val("");
		// 2개(등록, 수정)의 버튼을 보이지 않게
		$("#modal_replyWriteBtn, #modal_replyUpdateBtn").hide();
		// 등록 버튼을 보이게
		$("#modal_replyWriteBtn").show();
	});
	
	// 댓글 수정 모달창 열기
	$(".replyUpdateBtn").click(function(){
		//alert("댓글 수정");
		// 모달창의 제목 바꾸기
		$(".modal-title").text("댓글 수정하기");
		// 수정이 포함된 댓글의 내용 가져와서 모달창에 표시하기
		// closest(".dataRow") : 위로 올라가면서 클래스이름이 dataRow인 곳을 찾는다.
		var dataRow = $(this).closest(".dataRow");
		//alert(dataRow);
		// js - parseInt : 위로 올라가면서 맨 처음 만나는 숫자를 숫자로 가져온다.
		var rno = parseInt(dataRow.find(".rno").text());
		$("#modal_rno").val(rno);
		var content = dataRow.find(".content").text();
		$("#modal_content").val(content);
		var alias = dataRow.find(".alias").text();
		$("#modal_alias").val(alias);
		// 2개(등록, 수정)의 버튼을 보이지 않게
		$("#modal_replyWriteBtn, #modal_replyUpdateBtn").hide();
		// 수정 버튼을 보이게
		$("#modal_replyUpdateBtn").show();
		// 댓글 번호 보이게
		$("#modal_rno_div").show();
	});
	
	// 모달창 안에 입력한 데이터를 댓글 등록으로 처리
	$("#modal_replyWriteBtn").click(function(){
		//alert("등록 전송");
		// 데이터 유효성 검사 -> 생략
		// 데이터를 받는 URL설정
		$("#replyForm").attr("action", "replyWrite.do?page=1&perPageNum=10&no=${vo.no}");
		// 페이지 이동을 시키면서 데이터 전송 -> submit()
		$("#replyForm").submit();
	});
	
	// 모달창 안에 입력한 데이터 수정 처리
	$("#modal_replyUpdateBtn").click(function(){
		//alert("등록 전송");
		// 데이터 유효성 검사 -> 생략
		// 데이터를 받는 URL설정
		$("#replyForm").attr("action", "replyUpdate.do");
		// 페이지 이동을 시키면서 데이터 전송 -> submit()
		$("#replyForm").submit();
		
	});
	
	
});
</script>

<style type="text/css">
.table {
	width: 50%;
}

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

</head>


<body>
<div class="container f">
<h1 style="font-size: 50px;">coordination</h1>
<div class="row">
<div class="col-sm-3">
<div>
	<img src="${path }${vo.fileName }" style="width: 200%;" />
</div>
<div>
<jsp:include page="/WEB-INF/views/like/fashionView.jsp" />
</div>
</div>
<div class="col-sm-9">

<table class="table" align="right">		
	<tr class="f">
		<th style="width: 100px;">no</th>
		<td>${vo.no }</td>
	</tr>
	<tr class="f">
		<th>모자</th>
		<td><a href="${vo.link1 }" style="color: black;">${vo.name1 }</a></td>
	</tr>
	<tr class="f">
		<th>상의</th>
		<td><a href="${vo.link2 }" style="color: black;">${vo.name2 }</a></td>
	</tr>
	<tr class="f">
		<th>하의</th>
		<td><a href="${vo.link3 }" style="color: black;">${vo.name3 }</a></td>
	</tr>
	<tr class="f">
		<th>신발</th>
		<td><a href="${vo.link4 }" style="color: black;">${vo.name4 }</a></td>
	</tr>
	<tr class="f">
		<td colspan="2">
			<a href=""></a>
		</td>
	</tr>
</table>

</div>
<!-- 	<tr> -->
<!-- 		<td colspan="2"> -->
<div align="right">
			<c:if test="${login.gradeNo == 9}">
				<a href = "updateForm.do?no=${vo.no }" class="btn btn-default">modify</a>
				<button type="button" class="btn btn-default"
				 data-toggle="modal" data-target="#myModal">file modify</button>
				<a href = "delete.do?no=${vo.no }&perPageNum=${param.perPageNum}&deleteFile=${vo.fileName}"
				 class="btn btn-default delete" >delete</a>
			</c:if>
			<!-- EL 객체 - param.page -> request.getParameter("page") -->
			<a class="btn btn-default listBtn">list</a>
<!-- 		</td> -->
<!-- 	</tr> -->
</div>
</div>


<!-- 댓글 처리 (댓글 달기와 수정 버튼을 누르면 모달창이 뜨게 설정)-->
<h2>REPLY<button class="pull-right btn btn-default" data-toggle="modal"
			 data-target="#replyModal" id="writeReplyBtn" style="font-size: 19px;">write</button></h2>
<ul class="list-group">
	<c:if test="${empty list }">
		<li class="list-group-item">댓글이 존재하지 않습니다.</li>
	</c:if>
	<c:if test="${!empty list }">
	<c:forEach items="${list }" var="vo">
		<li class="list-group-item dataRow">
			<pre style="border: none; padding: 0px; background: none;"><span class="rno">${vo.rno }. </span><span class="content">${vo.content }</span></pre>
		<span class="alias" style="font-size: 25px;">${vo.alias } - ${vo.writeDate }</span>
		<c:if test="${login.id == vo.alias }">
			<span class="pull-right">
				<button class="btn btn-default replyUpdateBtn" data-toggle="modal" data-target="#replyModal">modify</button>
				<a href="replyDelete.do?rno=${vo.rno }&no=${vo.no }" class="btn btn-default replyDeleteBtn">delete</a>
			</span>
		</c:if>
		</li>
	</c:forEach>
	</c:if>
</ul>

<!-- Modal : 댓글 쓰기, 수정에서 폼으로 사용 -->
<div id="replyModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h3 class="modal-title">댓글 작성</h3>
      </div>
      
      <div class="modal-body">
        <form action="replyWrite.do" method="post" id="replyForm">
        	<input name="no" type="hidden" value="${vo.no }" />
        	<div class="form-group" id="modal_rno_div">
        		<label for="rno">댓글번호</label>
        		<input name="rno" id="modal_rno" readonly="readonly" class="form-control">
        	</div>
        	<div class="form-group">
        		<label for="content">내용</label>
        		<textarea name="content" id="modal_content" rows="3" class="form-control"></textarea>
        	</div>
        	<div class="form-group">
        		<label for="alias">작성자</label>
        		<input name="alias" id="modal_alias" class="form-control" readonly="readonly" value="${login.id }">
        	</div>
        </form>
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-default" id="modal_replyWriteBtn">등록</button>
        <button type="button" class="btn btn-default" id="modal_replyUpdateBtn">수정</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
      </div>
    </div>

  </div>
</div>

 <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">이미지 바꾸기</h4>
        </div>
        <div class="modal-body">
			<p>바꿀 이미지 파일을 선택하세요.</p>
			<form action="updateFile.do" method="post" enctype="multipart/form-data" id="updateFileForm">
				<!-- 페이지 정보를 숨겨서 넘긴다. -->
				<input name="page" value="${param.page }" type="hidden" />
				<input name="perPageNum" value="${param.perPageNum }" type="hidden" />
				
				<div class="form-group">
					<label for="no">번호</label>
					<input name="no" id="no" class="form-control" value="${vo.no }" readonly="readonly" />
				</div>
				<div class="form-group">
					<label for="deleteFile">원본파일</label>
					<input name="deleteFile" id="deleteFile" class="form-control" value="${vo.fileName }" readonly="readonly" />
				</div>
				<div class="form-group">
					<label for="imageFile">바꿀 파일 선택</label>
					<input name="imageFile" id="imageFile" class="form-control" 
					type="file" />
				</div>
			</form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" id="changeBtn">바꾸기</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  </div>
</body>
</html>