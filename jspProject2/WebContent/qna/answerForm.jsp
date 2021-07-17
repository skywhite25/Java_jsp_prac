<%@page import="com.webjjang.util.filter.AuthorityFilter"%>
<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@page import="com.webjjang.qna.vo.QnaVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 자바 부분
// 질문 답변보기 처리가 필요하다.
// 데이터 수집 - 글번호, 조회수 증가는 하지 않는다.
// String strNo = request.getParameter("no");
// Long no = Long.parseLong(strNo);

// // DB에서 데이터 가져오기
// QnaVO vo = (QnaVO)ExeService.execute(Beans.get("/qna/view.jsp"), new Long[]{no, 0L});

// // 서버 객체에 저장		
// request.setAttribute("vo", vo);

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변하기</title>
<!-- 	 <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!-- 	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<!-- 	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> -->
<!-- 	 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->



<!-- fromUtil.js 등록 -->
<script type="text/javascript" src="../js/formUtil.js"></script>
<script type="text/javascript">
$(function(){ 
	$("#cancelBtn").click(function(){
		history.back();
	});	
	
	// submit() 이벤트에 데이터 검사
	$("answerForm").submit(function(){
		alert("데이터 전달 이벤트");
		
		// 필수 입력
		// 제목
		if(!require($("#title"),"제목")) return false;
		// 내용
		if(!require($("#content"),"내용")) return false;
		// 길이
		// 제목 4자 이상
		if(!checkLength($("#title"), "제목", 4)) return false;
		// 내용 4자 이상
		if(!checkLength($("#content"), "내용", 4)) return false;
		
	});
		//submit 이벤트 취소
		return true;
});
</script>
</head>
<body>
<div class="container">
	<h1>답변하기</h1>
	<form action="answer.do" method="post" id="answerForm">
	<!-- 안 보이면서 넘겨지는 데이터 셋팅 -->
	<input name="refNo" value="${vo.refNo }" type="hidden"> 
	<input name="ordNo" value="${vo.ordNo }" type="hidden"> 
	<input name="levNo" value="${vo.levNo }" type="hidden"> 
	
	<!-- 보여지는 데이터 -->
	<div class="form-group">
		<label for="no">번호</label>
		<input name="no" class="form-control" id="no" readonly="readonly"
		value="${vo.no}">
	</div>	
	<div class="form-group">
		<label for="title">제목</label>
		<input name="title" class="form-control" id="title" placeholder="3글자 이상 20자 이내 입력" required="required"
		value="[답변]${vo.title }">
	</div>	
	<div class="form-group">
		<label for="content">내용</label>
		<textarea rows="7" name="content" class="form-control" id="content" placeholder="10글자 이상 1000자 이내 입력" required="required">


================질문================	
${vo.content }
			
			</textarea>
		</div>	
	<button class="btn btn-default">등록</button>
	<button class="btn btn-default" type="reset">새로입력</button>
	<button class="btn btn-default" type="button" id="cancelBtn">취소</button>
	</form>
</div>
</body>
</html>