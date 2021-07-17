

<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@page import="com.webjjang.notice1.vo.NoticeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%

//@SuppressWarnings("unchecked")
 

request.setAttribute("list", ExeService.execute(Beans.get(request.getServletPath()), null));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록</title>
  <!-- BootStrap CDN 방식 -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
  
</head>
<body>
<div class="container">
<h1>공지사항 목록</h1>
<table class = "table">
	<thead>
	<tr>
	<th>번호</th>
	<th>제목</th>
	<th>공지시작일</th>
	<th>공지종료일</th>
	<th>최종수정일</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items = "${list }" var="vo">
	<tr class="dataRow"></tr>
	<td class="no">${vo.no }</td>
	<td>${vo.title }</td>
	<td>${vo.startDate }</td>
	<td>${vo.endDate }</td>
	<td>${vo.updateDate }</td>
	</c:forEach>
	</tbody>
	<tfoot>
		<tr>
		<td colspan="6">
		<a href="writeForm.jsp" class="btn btn-default">글쓰기</a>
		</td>
		</tr>
	</tfoot>
</table>
</div>
</body>
</html>