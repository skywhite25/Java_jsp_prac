<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
// 	System.out.println("default_decorator.do [path] : " + request.getContextPath());
request.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="/upload/image/favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OOTD :: <decorator:title /></title>
<!-- BootStrap 라이브러리 등록 전체적으로 진행을 했다. filter가 적용이 되면 개별적으로 한것은 다 지워야 한다. -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	});
</script>
<style type="text/css">
@font-face {
    font-family: 'Hana_handwriting';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/naverfont_05@1.0/Hana_handwriting.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

.f {
	font-family: 'Hana_handwriting';
	font-size: 20px;
}

a{
	color: whitesmoke;
	text-decoration: none;
}

header {
	height: 50px;
	padding: 1rem;
	background: #c7ad08;
	font-weight: bold;
	display: flex;
	justify-content: space-between;
	align-items: center;

	
}

.g {
	height: 100%;
	width: 100px;
 	padding: 1rem; 
	background: #c7ad08;
	font-weight: bold;
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin: 80px;
}

</style>

<decorator:head/>
</head>
<body>
	<header class="f" style="font-size: 20px;">
		<h1><a href="/">#OOTD</a></h1>
		<nav>
			<span><a href="${path }/notice/list.do">Notice</a></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<span><a href="${path }/qna/list.do">QnA</a></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<span class="season"><a href="${path }/image/list.do">Season</a></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<span><a href="${path }/timeline/list.do">TimeLine</a></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</nav>
		<!-- 메인 메뉴 부분의 로그인 사용자 정보 -->
			<!-- 로그인이 안되어 있는 경우의 메뉴 -->
		<nav>
			<form class="navbar-form navbar-right" action="#"  >
				<div class="form-group">
 					<input type="search" class="form-control" placeholder="Search" name="search" onclick="alert('개발 예정입니다.')">
				</div>
				<button type="submit" class="btn-link"><span class="glyphicon glyphicon-search" style="position: center;"></span></button>
			</form>
		</nav>
		<nav>
			<c:if test="${empty login }">
				<span><a href="${path }/member/terms.do"> <span class="glyphicon glyphicon-user"></span> Join</a></span>&nbsp;&nbsp;
				<span><a href="${path }/member/loginForm.do"><span class="glyphicon glyphicon-log-in"></span> Login</a></span>&nbsp;&nbsp;
			</c:if>
			<!-- 로그인이 되어 있는 경우의 메뉴 -->
			<c:if test="${!empty login }">
<!-- 				<form action="#"> -->
<!-- 						<input type="search" class="form-control" placeholder="Search" name="search"> -->
<!-- 						<button type="submit" class="btn-link"><span class="glyphicon glyphicon-search"></span></button> -->
<!-- 				</form> -->
				<!-- 관리자 메뉴 -->
				<c:if test="${login.gradeNo >= 9 }"><span><a href="${path }/member/list.do"> Member</a></span></c:if>
				<span><a href="${path }/member/view.do"><span class="glyphicon glyphicon-user"></span> ${login.name }</a></span>
				<span><a href="${path }/member/logout.do" onclick="alert('로그아웃을 진행합니다.')"><span class="glyphicon glyphicon-log-out"></span> Logout</a></span>
			</c:if>
		</nav>
</header>
<decorator:body />

<p class="f g" style="font-size: 20px;">by.2Team</p>
</body>
</html>