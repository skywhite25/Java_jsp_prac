<%@page import="com.OOTD.image.vo.ImageVO"%>
<%@page import="com.OOTD.util.filter.AuthorityFilter"%>
<%@page import="com.OOTD.main.controller.Beans"%>
<%@page import="com.OOTD.main.controller.ExeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
// 자바부분
// 넘어오는 데이터 받기 - 번호(, 페이지, 한 페이지당 이미지 갯수 : 나중에 처리)
String strNo = request.getParameter("no");
Long no = Long.parseLong(strNo);

// DB에서 데이터 가져오기
ImageVO vo = (ImageVO) ExeService.execute(Beans.getService(AuthorityFilter.url), no);

// 프로젝트 path 구하기
String path = request.getContextPath();

// 서버객체(reauest)에 저장하기
request.setAttribute("vo", vo);
request.setAttribute("path", path);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 보기</title>

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
	})
});
</script>

<style type="text/css">
.table {
	width: 50%;
}
</style>

</head>


<body>
<div class="container">
<h1>이미지 보기</h1>
<!-- <table class="table" align="right"> -->
<!-- 	<tr> -->
<!-- 		<td> -->
			<!-- 게시물 작성자가 로그인한 회원(자기자신)인 경우와 관리자인 경우에만 나타나는 메뉴 -->
<!-- <table class="table" align="right"> -->

<!-- </table> -->
<!-- 		</td> -->
<!-- 	</tr> -->
<!-- </table> -->
<!-- <table class="table"> -->
<!-- 	<tr> -->
<!-- 		<th>코디</th> -->
<%-- 		<td><img src="${path }${vo.fileName }" style="width: 50%" /></td> --%>
<!-- 	</tr> -->
<!-- </table> -->
<div class="row">
<div class="col-sm-3">
<div>
	<img src="${path }${vo.fileName }" style="width: 200%;" />
</div>
</div>

<div class="col-sm-9">
<table class="table" align="right">	
	<tr>
		<td colspan="2">
<%-- 			<c:if test="${vo.id == login.id || login.gradeNo == 9}"> --%>
				<a href = "updateForm.jsp?no=${vo.no }" class="btn btn-default">수정(제목, 내용)</a>
				<button type="button" class="btn btn-default"
				 data-toggle="modal" data-target="#myModal">파일 바꾸기</button>
				<a href = "delete.jsp?no=${vo.no }&perPageNum=${param.perPageNum}&deleteFile=${vo.fileName}"
				 class="btn btn-default delete" >삭제</a>
<%-- 			</c:if> --%>
			<!-- EL 객체 - param.page -> request.getParameter("page") -->
			<a href = "list.jsp?page=${param.page }&perPageNum=${param.perPageNum}" class="btn btn-default">리스트</a>
		</td>
	</tr>
	<tr>
		<th style="width: 100px;">번호</th>
		<td>${vo.no }</td>
	</tr>
	<tr>
		<th>모자</th>
		<td>${vo.name1 }</td>
	</tr>
	<tr>
		<th>모자 링크</th>
		<td>${vo.link1 }</td>
	</tr>
	<tr>
		<th>상의</th>
		<td>${vo.name2 }</td>
	</tr>
	<tr>
		<th>상의 링크</th>
		<td>${vo.link2 }</td>
	</tr>
	<tr>
		<th>하의</th>
		<td>${vo.name3 }</td>
	</tr>
	<tr>
		<th>하의 링크</th>
		<td>${vo.link3 }</td>
	</tr>
	<tr>
		<th>신발</th>
		<td>${vo.name4 }</td>
	</tr>
	<tr>
		<th>신발 링크</th>
		<td>${vo.link4 }</td>
	</tr>
	<tr>
		<td colspan="2">
			<a href=""></a>
		</td>
	</tr>
</table>
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
			<form action="updateFile.jsp" method="post" enctype="multipart/form-data" id="updateFileForm">
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

</body>
</html>