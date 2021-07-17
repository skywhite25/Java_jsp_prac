<!-- sitemesh 사용을 위한 설정 파일 -->
<!-- 작성자 : 이영환 -->
<!-- 작성일 : 2020-06-30 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
System.out.println("default_decorator.jsp [path] : " + request.getContextPath());
request.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>웹짱:<decorator:title /></title>
<!-- BootStrap 라이브러리를 전체적으로 등록 했다. filter가 적용이 되면 개별적으로 한 것은 전부 삭제를 해야한다 ==> 하지않으면 충돌이 발생할 수 있다. -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
header, footer {
	background: AntiqueWhite;
}

pre {
	background: white;
	border: 0px;
}

/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Add a gray background color and some padding to the footer */
footer {
	background-color: black;
	padding: 25px;
	color: #ddd;
}

.carousel-inner img {
	width: 100%; /* Set width to 100% */
	margin: auto;
	min-height: 200px;
}

/* Hide the carousel text when the screen is less than 600 pixels wide */
@media ( max-width : 600px) {
	.carousel-caption {
		display: none;
	}
}

article {
	min-height: 400px;
	margin-top: 80px;
	margin-bottom: 80px;
}

#welcome {
	color: grey;
	margin: 0 auto;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
	});
</script>
<decorator:head/>
</head>
<body>
	<header>
<!-- 		<div><img href="#"/></div> -->
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#myNavbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="${path }/main/main.jsp">Logo</a>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
						<li><a href="${path }/notice/list.jsp">공지사항</a></li>
						<li><a href="${path }/image/list.jsp">이미지</a></li>
						<li><a href="${path }/board/list.jsp">게시판</a></li>
						<li><a href="${path }/qna/list.jsp">Q&amp;A</a></li>
						<!-- &amp; - &, &lt; -> '<', &gt; -> '>', &nbsp; -> 'blank' -->
						<c:if test="${!empty login }">
						<!-- 로그인이 되어있는 경우의 메뉴 -->
						<li><a href="${path }/message/list.jsp">메시지</a></li>
						</c:if>
					</ul>
					<!-- 메인 메뉴 부분의 로그인 사용자 정보 -->
				    <ul class="nav navbar-nav navbar-right">
				      <c:if test="${empty login }">
				      <!-- 로그인이 안되어 있는 경우의 메뉴 -->
				      <li><a href="#">
				      	<span class="glyphicon glyphicon-user"></span> 회원가입</a>
				      </li>
				      <li><a href="${path }/member/loginForm.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
				      </c:if>
				      <c:if test="${!empty login }">
				      <!-- 로그인이 되어 있는 경우의 메뉴 -->
				      <li>
				      	<a href="${path }/member/view.jsp"><span class="glyphicon glyphicon-user"></span> ${login.name }</a>
				      </li>
				      <li><a href="${path }/member/logout.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
				      </c:if>
				    </ul>
				</div>
			</div>
		</nav>
	</header>
	<article>
		<decorator:body />
	</article>
	<footer class="container-fluid text-center navbar navbar-inverse navbar-fixed-bottom">
		<p>이 홈페이지의 저작권은 김태훈에게 있습니다.</p>
	</footer>
</body>
</html>