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
<!-- 	 <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!-- 	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<!-- 	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> -->
<!-- 	 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->

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
// 		alert("등급변경 버튼 클릭");
		// id 찾기와 셋팅
		var id = $(this).closest(".dataRow").find(".id").text();
		// id는 #
		$("#formId").val(id);
		// 등급번호 찾기
		var gradeNo = $(this).closest(".dataRow").find(".gradeNo").text();
		// class는 .
		$(".formGradeNo").val([gradeNo]);
	});
	
	// 등급수정 폼의 전달 버튼 이벤트
	// 객체의 선택이 잘 되는지 확인
// 	alert($("#formGradeModifyBtn"));
// 	alert($("#formGradeModifyBtn").prop("tagName"));
	// 폼의 전달 버튼의 이벤트 붙이기
	$("#formGradeModifyBtn").click(function(){
// 		alert("formGradeModifyBtn click");
		// 폼의 데이터 넘기기
		// 폼 객체 확인
// 		alert($("#gradeModifyForm"));
		// 폼의 데이터 전송하기 -> 폼객체.submit()
		$("#gradeModifyForm").submit();
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
				<!-- 나의 계정이 아니면 변경버튼이 나타난다. -->
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


</body>
</html>