<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>강의평가</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- 부트스트랩 CSS 추가하기 -->
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <!-- 커스텀 CSS 추가하기 -->
    <link rel="stylesheet" href="./css/custom.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="index.jsp">강의평가</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbar">
			<ul class="navbar-nav mr-auto"> 
				<li class="nav-item active">
					<a class="nav-link" href="index.jsp">메인</a>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" id="dropdown" data-toggle="dropdown">회원 관리</a>
					<div class="dropdown-menu" aria-labelledby="dropdown">
						<a class="dropdown-item" href="#">로그인</a>
						<a class="dropdown-item" href="#">회원가입</a>
						<a class="dropdown-item" href="#">로그아웃</a>
					</div>			
				</li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search" placeholder="내용을 입력하세요" aria-label="search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
			</form>
		</div>
	</nav>
	<div class="container">
		<form action="/index.jsp" method="get" class="form-inline mt-3">
			<select name="lectureDivide" class="form-control mx-1 mt-2">
				<option value="전체">전체</option>
				<option value="전공">전공</option>
				<option value="교양">교양</option>
				<option value="기타">기타</option>
			</select>
			<input type="text" name="search" class="form-control mx-1 mt-2" placeholder="내용을 입력하세요">
		    <button type="submit" class="btn btn-primary mx-1 mt-2">검색</button>
		    <a class="btn btn-primary mx-1 mt-2" data-toggle="modal" href="#registerModal">등록</a>
		    <a class="btn btn-danger mx-1 mt-2" data-toggle="modal" href="#registerModal">신고</a>
		</form>
		<div class="card bg-light mt-3">
			<div class="card-header bg-light">
				<div class="row">
					<div class="col-8 text-left">체육학개론&nbsp;<small>김태훈</small></div>
					<div class="col-8 text-right">
						종합 <span style="color : red;">A</span>
					</div>
				</div>
			</div>
				<div class="card-body">
					<h5>좋아요.&nbsp;<small>2021 1학기</small></h5>
					<p>재밌어요</p>
					<div class="row">
						<div class="col-9 text-left">
							성적<span style="color:red;">A</span>
							널널<span style="color:red;">A</span>
							강의<span style="color:red;">B</span>
							<span style="color:green;">(추천 : 15★)</span>
						</div>
						<div class="col-3 text-right">
							<a onclick="return confirm('추천하시겠습니까?')" href="/likeAction.jsp?evaluationID=">추천</a>
							<a onclick="return confirm('삭제하시겠습니까?')" href="/deleteAction.jsp?evaluationID=">삭제</a>
						</div>
					</div>
				</div>
			</div>
			<div class="card bg-light mt-3">
				<div class="card-header bg-light">
					<div class="row">
						<div class="col-8 text-left">배드민턴&nbsp;<small>태훈김</small></div>
						<div class="col-8 text-right">
							종합<span style="color:red;">B</span>
					</div>
				</div>
			</div>
			<div class="card-body">
				<h5 class="card-title">
				괜찮아요.&nbsp;<small>2021 2학기</small>
				</h5>
				<p class="card-text">괜찮았어요</p>
				<div class="row">
					<div class="col-9 text-left">
					성적<span style="color:red;">B</span>
					널널<span style="color:red;">B</span>
					강의<span style="color:red;">C</span>
					<span style="color:green;">(추천 : 5★)</span>
					</div>
					<div class="col-3 text-right">
						<a onclick="return confirm('추천하시겠습니까?')" href="/likeAction.jsp?evaluationID=">추천</a>
						<a onclick="return confirm('삭제하시겠습니까?')" href="/deleteAction.jsp?evaluationID=">삭제</a>
					</div>
				</div>
			</div>		
		</div>
		<div class="card bg-light mt-3">
			<div class="card-header bg-light">
				<div class="row">
					<div class="col-8 text-left">축구&nbsp;<small>이순신</small></div>
					<div class="col-4 text-right">
					종합<span style="color:red;">A</span>
					</div>
				</div>
			</div>
			<div class="card-body">
				<h5 class="card-title">
				별로에요&nbsp;<small>2021 여름학기</small>
				</h5>
				<p class="card-text">그냥 그래요</p>
				<div class="row">
					<div class="col-9 text-left">
			            성적 <span style="color: red;">A</span>
			            널널 <span style="color: red;">C</span>
			            강의 <span style="color: red;">A</span>
		              	<span style="color: green;">(추천:0★)</span>
					</div>
					<div class="col-3 text-right">
						<a onclick="return confirm('추천하시겠습니까?')" href="/likeAction.jsp?evaluationID=">추천</a>
						<a onclick="return confirm('삭제하시겠습니까?')" href="/deleteAction.jsp?evaluationID=">삭제</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	
    <!-- 제이쿼리 자바스크립트 추가하기 -->
    <script src="./js/jquery.min.js"></script>
    <!-- Popper 자바스크립트 추가하기 -->
    <script src="./js/popper.min.js"></script>
    <!-- 부트스트랩 자바스크립트 추가하기 -->
    <script src="./js/bootstrap.min.js"></script>
</body>
</html>