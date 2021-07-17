<%@page import="com.OOTD.image.vo.ImageVO"%>
<%@page import="com.OOTD.util.filter.AuthorityFilter"%>
<%@page import="com.OOTD.main.controller.Beans"%>
<%@page import="com.OOTD.main.controller.ExeService"%>
<%@page import="java.util.List"%>
<%@page import="com.OOTD.util.PageObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pageObject" tagdir="/WEB-INF/tags" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트랜드 페이지</title>

<style type="text/css">
.dataRow:hover {
	background: #000;
	cursor: pointer;
	border: 3px dotted #888;
}

#image_gallery, .line {
	clear: both;
}

.line {
	height: 10px;
}
</style>

<script type="text/javascript">
$(function(){
	$(".dataRow").click(function(){
		//alert("클릭");
		var no = $(this).find(".no").text();
		location = "view.do?no=" + no +"&page=${pageObject.page}&perPageNum=${pageObject.perPageNum}";
	});
	
	// 한 페이지에 보여주는 데이터 선택의 이벤트 처리 -> 변경이 일어나면 처리한다.
	$("#sel_perPageNum").change(function(){
		//alert("값 변경");
		// 다시 리스트 불러오기 - 전달 정보는 1페이지, perPageNum을 선택된 값을 전달한다.
		location = "list.do?page=1&perPageNum=" + $(this).val();
	});
});
</script>

</head>


<body>
<div class="container">
<h1>트랜드 페이지</h1>
<div style="padding: 10px; border-bottom: 2px solid #eee; height: 75px;">
	<div class="pull-left">
		<a href="writeForm.do?perPageNum=${pageObject.perPageNum }" class="btn btn-default">등록</a>
	</div>
	<div class="pull-right form-inline">
		<label>한 페이지에 표시할 데이터</label>
		<select class="form-control" id="sel_perPageNum">
			<option ${(pageObject.perPageNum == 4)?"selected":"" }>4</option>
			<option ${(pageObject.perPageNum == 8)?"selected":"" }>8</option>
			<option ${(pageObject.perPageNum == 12)?"selected":"" }>12</option>
			<option ${(pageObject.perPageNum == 16)?"selected":"" }>16</option>
		</select>
	</div>
</div>
<div class="line"></div>
	<div id="image_gallery">
		<div class="row">
			<c:forEach items="${list }" var="vo" varStatus="vs">
			<!-- c:forEach 속성 중에서 varStatus="vs" => index나 count를 사용할 수 있는 객체 -->
			<c:if test="${(vs.index > 0) && (vs.index % 4 == 0) }">
				<!-- 인덱스 번호가 0 이상이고 4의 배수이면 한 줄(class="row")을 만든다. -->
		${"</div>"}
		${"<div class='row'>"}
			</c:if>
			
				<!-- BootStrap Grid : 한 줄을 12칸으로 나눠서 운영하는 시스템 -->
			    <div class="col-md-3 dataRow"> <!-- 한 줄을 3등분 한다. -->
			      <div class="thumbnail">
			          <img src="${path }${vo.fileName}" alt="Lights" style="width:100%">
			          <div class="caption">
			            <p>[<span class="no">${vo.no }</span>]</p>
			          </div>
			      </div>
		    	</div>
	    	</c:forEach>
	    </div>
		<div>
			<pageObject:pageNav listURI="list.jsp" pageObject="${pageObject }" />
		</div>
		<!-- 로그인이 되어 있을 경우 나타낸다. -->
		<c:if test="${!empty login }">
			<div>
				<a href="writeForm.jsp?perPageNum=${pageObject.perPageNum }">등록</a>
			</div>
		</c:if>
	</div>
	</div>
</body>
</html>