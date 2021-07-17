<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@page import="com.webjjang.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
// 여기가 자바 코드입니다. JSP-Service-DAO
String url = request.getServletPath();
@SuppressWarnings("unchecked")
List<MemberVO> list = (List<MemberVO>) ExeService.execute(Beans.get(url), null);
// 서버객체 request에 담는다.
request.setAttribute("list", list);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
  
  <!-- 부트스트랩 라이브러리 등록 - CDN 방식 -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
.dataRow:hover{
	cursor: pointer;
	background: #eee;
}
</style>

<script type="text/javascript">
// 객체 선택에 문제가 있다. 아래 Document가 다 로딩이 되면 실행되는 스크립트 작성
// jquery -> $(function(){처리문 만들기;}) = jquery(function(){처리문 만들기;})
$(function(){ // jquery에서 익명함수를 전달해서 저장해놨다가 Document가 로딩이 다되면 호출해서 처리해준다.
	$(".gradeModifyBtn").click(function(){
		// alert("등급변경 버튼 클릭");
		// id 찾기와 셋팅
		var id = $(this).closest(".dataRow").find(".id").text();
		$("#formId").val(id);
		// 등급번호 찾기와 셋팅
		var gradeNo = $(this).closest(".dataRow").find(".gradeNo").text();
		// alert(gradeNo);
		$(".formGradeNo").val(["1"]);
	});
});
</script>

</head>
<body>
<div class="container">
<h1>회원 리스트</h1>
<table class="table">
	<!-- 제목 -->
	<thead>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>성별</th>
			<th>생년월일</th>
			<th>연락처</th>
			<th>상태</th>
			<th>등급번호</th>
			<th>등급이름</th>
		</tr>
	</thead>
	<tbody>
		<!-- 데이터가 있는 만큼 반복이 되어 지는 시작 부분 -->
		<c:forEach items="${list }" var="vo">
		<tr class="dataRow">
			<td class="id">${vo.id }</td>
			<td>${vo.name }</td>
			<td>${vo.gender }</td>
			<td>${vo.birth }</td>
			<td>${vo.tel }</td>
			<td>${vo.status }</td>
			<td class="gradeNo">${vo.gradeNo }</td>
			<td>${vo.gradeName }
				<c:if test="${vo.id != login.id }">
					<!-- 내 계정이 아니면 변경버튼이 나타난다. -->
					<button class="gradeModifyBtn" 
						data-toggle="modal" data-target="#myModal">변경</button>
				</c:if>
			</td>
		</tr>
		</c:forEach>
		<!-- 데이터가 있는 만큼 반복이 되어 지는 끝 부분 -->
	</tbody>
</table>
</div>


<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">등급 수정</h4>
      </div>
      <div class="modal-body">
        <p>
        	<form action="gradeModify.jsp" method="post" id="gradeModifyForm">
        		<div class="form-group">
        			<label for="id">아이디</label>
        			<input name="id" id="formId" readonly="readonly" class="form-control"/>
        		</div>
        		<div>
        			<div><label>등급</label></div>
        			<label class="radio-inline">
        				<input type="radio" name="gradeNo" value="1"
        				 class="formGradeNo">일반회원</label>
					<label class="radio-inline">
						<input type="radio" name="gradeNo" value="9"
						 class="formGradeNo">관리자</label>
        		</div>
        	</form>
        </p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>

</body>
</html>