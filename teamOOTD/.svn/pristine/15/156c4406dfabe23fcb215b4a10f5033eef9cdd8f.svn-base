<%@page import="com.OOTD.util.filter.AuthorityFilter"%>
<%@page import="com.OOTD.main.controller.Beans"%>
<%@page import="com.OOTD.main.controller.ExeService"%>
<%@page import="com.OOTD.timeline.vo.TimelineVO"%>
<%@page import="java.util.List"%>
<%@page import="com.OOTD.util.PageObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pageObject" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TimeLine</title>
<style type="text/css">
	.dataRow:hover{
		background-color: #c7ad08;
		cursor: pointer;
/* 		border: 3px dotted #888; */
	}
	#timeline_gallery, .line{
		clear: both;
	}
	.line{
		height: 20px;
	}
	@font-face {
    font-family: 'Hana_handwriting';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/naverfont_05@1.0/Hana_handwriting.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

.main_title{
		max-width: 100%;
		overflow: hidden;
		text-overflow: ellipsis;
		white-space: nowrap
	}
	#desktop_layout .title{
		width : 200px;
/* 		white-space: nowrap; */
/* 		overflow : hidden; */
/* 		text-overflow: ellipsis; */
	}

.f {
	font-family:'Hana_handwriting';
	font-size: 60px;
}
.c {
	font-family:'Hana_handwriting';
	font-size: 20px;
}
</style>
<script type="text/javascript">
$(function(){
	$(".dataRow").click(function(){
// 		alert("click");
		var no = $(this).find(".no").text();
		location = "view.do?no=" + no + "&inc=1&page=${pageObject.page}&perPageNum=${pageObject.perPageNum}";
	});
	
	// 한페이지에 보여주는 데이터 선택의 이벤트 처리 -> 변경이 일어나면 처리
	$("#sel_perPageNum").change(function(){
		// alert("값 변경");
		// 다시 리스트 불러오기 - 전달 정보는 페이지:1, perPageNum을 선택된 값을 전달.
		location = "list.do?page=1&perPageNum=" + $(this).val();
	});
});
</script>
</head>
<body>
	<div class="container">
		<h1 class= "f">TimeLine</h1>
		
		<div style="padding: 10px; border-bottom: 2px solid #eee; height: 50px;">
			<div class="pull-right form-inline">
				<label> </label> <select class="form-control"
					id="sel_perPageNum">
					<option ${(pageObject.perPageNum == 4)?"selected":"" }>4</option>
					<option ${(pageObject.perPageNum == 8)?"selected":"" }>8</option>
					<option ${(pageObject.perPageNum == 12)?"selected":"" }>12</option>
					<option ${(pageObject.perPageNum == 16)?"selected":"" }>16</option>
				</select>
			</div>
			<c:if test="${!empty login }">
				<div class= "pull-left">
					<a href="writeForm.do?perPageNum=${pageObject.perPageNum }"
						class="btn btn-default">Upload</a>
				</div>
			</c:if>
		</div>
		<div class="line"></div>
		<div id="timeline_gallery">

			<div class="row">
				<c:forEach items="${list }" var="vo" varStatus="vs">
					<!-- c:forEach 속성 중에서 varStatus="vs" => index나 count를 사용할 수 있는 객체 -->
					<c:if test="${(vs.index  > 0) && (vs.index % 4 == 0)}">
						<!-- 인덱스 번호가 0이상이고 4의 배수이면 한줄(class="row")을 만든다. -->
						${"</div>"}
						${"<div class='row'>"}
					</c:if>
					<!-- BootStrap Grid : 한줄은 12칸으로 나눠서 운영하는 시스템 -->
					<div class="col-md-3 dataRow">
						<div class="thumbnail c">
							<img src="${path }${vo.fileName}" alt="Lights" style="width: 100%; height: 400px;">
							<div class="caption">
								<p class="main_title"><span class="no">${vo.no }</span>. ${vo.title }</p> 
								
								| ${vo.id } | <br/>
								<span class="glyphicon glyphicon-eye-open"></span> ${vo.hit } | <span class="glyphicon glyphicon-calendar"></span> ${vo.writeDate }
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div>
				<pageObject:pageNav listURI="list.do" pageObject="${pageObject }" />
			</div>
		</div>
	</div>
</body>
</html>