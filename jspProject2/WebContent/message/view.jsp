<%@page import="com.webjjang.util.filter.AuthorityFilter"%>
<%@page import="com.webjjang.member.vo.LoginVO"%>
<%@page import="com.webjjang.message.vo.MessageVO"%>
<%@page import="java.util.List"%>
<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%

// 넘어오는 데이터 받기 
// 글번호
String strNo = request.getParameter("no");
// Long no = Long.parseLong(strNo); ==> 더 간단하게 만든 vo.setNo(Long.parseLong(strNo));가 아래에 있다.

// 내 아이디 정보를 꺼내야한다.
String id = ((LoginVO)session.getAttribute("login")).getId();
// vo 객체 생성
MessageVO vo = new MessageVO();
vo.setNo(Long.parseLong(strNo));
vo.setAccepter(id); // 받는 사람이 본인인 데이터를 읽기 표시하기 위해서

// 1. 받은사람이 로그인한 사람과 같아야하고 번호가 같고 받은 날짜가 null인 데이터 메시지를 
//    (읽지않은) 받은 메시지는 읽음표시를 한다.(acceptDate를 현재 날짜로 넣어준다 - update)
// 2. 메시지 번호에 맞는 전체 메시지 정보 가져오기
MessageVO viewVO = (MessageVO)ExeService.execute(Beans.get(AuthorityFilter.url), vo);

// 서버객체 request에 담는다.
request.setAttribute("vo", viewVO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메시지 보기</title>
<!--   부트스트랩 라이브러리 등록 - CDN 방식 -->
<!--   <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!--   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> -->
<!--   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
  
<script type="text/javascript">
// 객체 선택에 문제가 있다. 아래 Document가 다 로딩이 되면 실행되는 스크립트 작성
// jQuery -> $(function(){처리문 만들기}); = jQuery(function(){처리문 만들기});
$(function(){ // jQuery에서 익명함수를 전달해서 저장해놨다가 Document가 로딩이 다 되면 호출해서 처리해준다.
	// 삭제버튼을 클릭하면 실제적으로 삭제를 진행할 건지에 대한 여부를 물어본다.
	$("#deleteBtn").click(function(){
		if(!confirm("정말로 삭제하시겠습니까?")) return false; // a tag의 이동 취소
	});
});	
</script>
</head>
<body>
<div class="container">
<h1>메시지 글보기</h1>
<table class="table">
	<tbody>
		<tr>
			<th>글번호</th>
			<td class="no">${vo.no }</td>
		</tr>
		<tr>	
			<th>내용</th>
			<td><pre style="background: #fff; border: none; padding: 0px; ">${vo.content }</pre></td>
		</tr>
		<tr>	
			<th>발신자</th>
			<td>${vo.sender}</td>
		</tr>
		<tr>	
			<th>발신일</th>
			<td>${vo.sendDate}</td>
		</tr>
		<tr>	
			<th>수신자</th>
			<td>${vo.accepter}</td>
		</tr>
		<tr>	
			<th>수신일</th>
			<td>${vo.acceptDate}</td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="2">
				<c:if test="${! (vo.sender == login.id && !empty vo.acceptDate) }">
					<a href="delete.jsp?no=${vo.no }" class="btn btn-default">삭제</a>
				</c:if>
				<a href="list.jsp" class="btn btn-default">리스트</a>
			</td>
		</tr>
	</tfoot>
</table>
</div>
</body>
</html>