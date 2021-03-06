<%@page import="com.OOTD.util.filter.AuthorityFilter"%>
<%@page import="com.OOTD.main.controller.Beans"%>
<%@page import="com.OOTD.main.controller.ExeService"%>
<%@page import="com.OOTD.timeline.vo.TimelineVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TimeLine</title>
<style> -->
 @font-face {
 font-family: 'Hana_handwriting'; 
 src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/naverfont_05@1.0/Hana_handwriting.woff') format('woff');
font-weight: normal;
 font-style: normal; 


.f { 
font-family: 'Hana_handwriting';
font-size: 20px; 
 </style> 
<script type="text/javascript">
$(function(){
//하용되는 이미지 파일 형식들
var imageExt = ["JPG", "JPEG", "GIF", "PNG"];

	// 이벤트 처리
	// 이미지 바꾸기 모달창의 바꾸기 버튼
	$("#changeBtn").click(function(){
		// alert("change");
		// 파일이 비어 있는지 확인
		var fileName = $("#imageFile").val();
		// alert(fileName);
		// 바꿀 파일란이 비어 있는 경우의 처리
		if(!fileName){
			alert("바꿀 이미지를 반드시 선택하셔야 합니다.");
			$("#imageFile").focus();
			return false;
		}
		// 바꿀 파일란이 비어 있지 않는 경우의 처리 - 지원하는 이미지 확인 처리
		// substring(시작[, 끝]) - 부분 문자열 잘라내기
		// lastIndexOf(찾는 문자열) - 뒤에서 부터 찾는 문자열의 위치. 찾는 문자열이 없으면 -1이 된다.
		// toUpperCase -> 모든 영문자를 대문자로 만들어준다. <--> toLowerCase()
		var ext = fileName.substring(fileName.lastIndexOf(".")+1).toUpperCase();
		// alert(ext);
		
		// 이미지 확장자인지 확인하는 반복문 -imageExt가 위에 배열로 선언이 되어져 있어야만 한다.
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
			$("#imageFile").focus();
			return false;
		}
		
		// 강제적으로 폼 데이터를 전송한다.
		$("#updateFileForm").submit();
	});
	
	$(".delete").click(function(){
		if(!confirm("정말 삭제하시겠습니까?"))
			return false;
	})
	$(".replyDeleteBtn").click(function(){
		if(!confirm("정말 삭제하시겠습니까?"))
			return false;
	});
	
	// 댓글 등록 모달창 열기
	$("#replyWriteBtn").click(function(){
		// alert("댓글달기");
		// 모달창의 제목 바꾸기
		$(".modal-title").text("댓글 달기");
		// 댓글 번호 / 작성자 아이디 안보이기
		$("#modal_rno_div").hide();
		$("#modal_id").hide();
		
		// 댓글 쓰기 처리 URL 설정
		$("#replyForm").attr("action","replyWrite.do");
		// 댓글 내용과 작성자를 비워 둔다. - 수정을 하다가 취소를 누르면 내용이 있기 때문에
		$("#modal_content").val("");
		// 2개-등록과 수정 버튼을 안보이게
		$("#modal_replyWriteBtn, #modal_replyUpdateBtn").hide();
		// 등록 버튼을 보이게
		$("#modal_replyWriteBtn").show();
	});
	
	// 댓글 수정 모달창 열기
	$(".replyUpdateBtn").click(function(){
// 		alert("댓글 수정");
		// 모달 제목 바꾸기
		$(".modal-title").text("댓글 수정");
		// 수정이 포함된 댓글의 내용을 가져와서 모달창에 셋팅하기
		var dataRow = $(this).closest(".dataRow");
// 		alert(dataRow);
		// js : parseInt(str) -> str안에 처음 만나는 정수형 숫자를 숫자로 꺼낸다.  
		var rno = parseInt(dataRow.find(".rno").text());
		$("#modal_rno").val(rno);
		var content = dataRow.find(".content").text();
		$("#modal_content").val(content);
		
		// var id = dataRow.find(".id").text();
		// $("#modal_id").val(id);
		// 2개-등록과 수정 버튼을 안보이게
		$("#modal_replyWriteBtn, #modal_replyUpdateBtn").hide();
		// 수정 버튼을 보이게
		$("#modal_replyUpdateBtn").show();
		// 댓글 번호 보이게
		$("#modal_rno_div").show();
		
	});
	
	// 모달 창 안에 입력한 데이터를 댓글 등록처리
	$("#modal_replyWriteBtn").click(function(){
 		// alert("등록 전송");
		// 데이터 유효성 검사. -> 생략
		// 데이터를 받는 URL 정한다.
		$("#replyForm").attr("action", "replyWrite.do?page=1&perPageNum=10&no=${vo.no}");
		// 페이지 이동을 시키면서 데이터 전송 -> submit()
		$("#replyForm").submit();
	});

	// 모달 창 안에 입력한 데이터를 댓글 수정처리
	$("#modal_replyUpdateBtn").click(function(){
// 		alert("수정 전송");
		// 데이터 유효성 검사. -> 생략
		// 데이터를 받는 URL 정한다.
		$("#replyForm").attr("action", "replyUpdate.do");
		// 페이지 이동을 시키면서 데이터 전송 -> submit()
		$("#replyForm").submit();
	});
	
});
</script>

</head>
<body>
<div class="container f">
	<h1>TimeLine</h1>
		<div>
				<c:if test="${vo.id == login.id || login.gradeNo == 9}">
					<!-- 작성자가 로그인한 사람인 회원인 경우와 관리자에게만 나타나는 메뉴 -->
					<a href="updateForm.do?no=${vo.no }" class="btn btn-default">Modify</a>
					<button type="button" class="btn btn-default" 
					data-toggle="modal" data-target="#myModal">File Modify</button>
					<a href="delete.do?no=${vo.no }&perPageNum=${param.perPageNum}&deleteFile=${vo.fileName}" class="btn btn-default">Delete</a>
				</c:if>
				<!-- EL 객체 - param.page -> request.getParameter("") -->
				<a href="list.do?page=${param.page }&perPageNum=${param.perPageNum}" 
				class="btn btn-default">list</a>
			
		</div>
	<table class = "table">
		<tr>
			<th style="width: 100px">번호</th>
			<td>${vo.no }</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${vo.hit }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${vo.title }</td>
		</tr>
		<tr>
			<td colspan="2"><img src="${path }${vo.fileName }"  /></td>
		</tr>
		<tr><td>
		<div>
<jsp:include page="/WEB-INF/views/like2/timeView.jsp" />
</div></td>
</tr>
		<tr>
			<th>내용</th>
			<td ><pre style="background: #fff; border: none; font-family: 'Hana_handwriting'; font-size: 20px; padding: 0px; ">${vo.content }</pre></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${vo.id }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${vo.writeDate }</td>
		</tr>
		
	</table>
	
	<!-- 댓글 처리 -->
<h2>Reply <button class="pull-right btn btn-default"
  data-toggle="modal" data-target="#replyModal" id="replyWriteBtn">write</button></h2>
<ul class="list-group">
	<c:if test="${empty list }">
  		<li class="list-group-item">댓글이 존재하지 않습니다.</li>
  	</c:if>
  	<c:if test="${!empty list }">
  	<c:forEach items="${list }" var="vo">
	  <li class="list-group-item dataRow">
	  	<pre style="border: none; padding: 0px;background: none;  font-family: 'Hana_handwriting'; font-size: 20px;"><span class="rno">${vo.rno }. </span><span class="content">${vo.content }</span></pre>
		<span class="writer">${vo.id } - ${vo.writeDate }</span>
		<c:if test="${login.id == vo.id }">
		<span class="pull-right" style="margin-top: -10px;">
			<button class="btn btn-default replyUpdateBtn" data-toggle="modal"
			 data-target="#replyModal">수정</button>
			<a href="replyDelete.do?rno=${vo.rno }&no=${vo.no }" class="btn btn-default" 
			  id="replyDeleteBtn">삭제</a>
		</span>
		</c:if>
	  </li>
	  </c:forEach>
	 </c:if>
</ul>
</div>

<!-- Modal : 댓글 쓰기, 수정에서 폼 사용 -->
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
        	<div class='form-group' id="modal_rno_div">
        		<label for="rno">댓글번호</label>
        		<input name="rno" readonly="readonly" id="modal_rno" class="form-control">
        	</div>
        	<div class="form-group">
        		<label for="content">내용</label>
        		<textarea name="content" rows="3" class="form-control" id="modal_content"></textarea>
        	</div>
        	<div class='form-group'>
        		<input name="id" id="modal_id" type="hidden" readonly="readonly" value="${login.id }" class="form-control">
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
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">이미지 바꾸기</h4>
      </div>
      <div class="modal-body">
        <p>바꿀 이미지 파일을 선택하세요.</p>
        <form action="updateFile.do" method="post" enctype="multipart/form-data" 
        id="updateFileForm">
        <!--  페이지 정보를 숨겨서 넘긴다. -->
        <input name="page" value="${param.page }" type="hidden"/>
        <input name="perPageNum" value="${param.perPageNum }" type="hidden"/>
			<div class="form-group">
				<label for="no">번호</label>
				<input name="no" id="no" class="form-control" 
				value="${vo.no }" readonly="readonly"/>
			</div>
			<div class="form-group">
				<label for="deleteFile">원본파일</label>
				<input name="deleteFile" id="deleteFile" class="form-control" 
				value="${vo.fileName }" readonly="readonly"/>
			</div>
			<div class="form-group">
				<label for="imageFile">바꿀 파일 선택</label>
				<input name="imageFile" id="imageFile" class="form-control" type="file" />
			</div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" id="changeBtn">변경</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
      </div>
    </div>
	</div>
</div>
</body>
</html>