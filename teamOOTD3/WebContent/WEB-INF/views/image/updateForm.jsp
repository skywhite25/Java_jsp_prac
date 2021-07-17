<%@page import="com.OOTD.main.controller.Beans"%>
<%@page import="com.OOTD.image.vo.ImageVO"%>
<%@page import="com.OOTD.util.filter.AuthorityFilter"%>
<%@page import="com.OOTD.main.controller.ExeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ì ë³´ ìì </title>

<script type="text/javascript">
$(function(){
	$("#cancelBtn").click(function(){
		history.back();
	});

	$("#seasonNo").click(function(){
		// í´ë¦­í ë¼ëì¤ ë²í¼ì ê°ì ë³ì seasonNoì ë£ëë¤.
 		var seasonNo = $("#seasonNo input:radio:checked").val();
 		alert(seasonNo);
 		$("#seasonNo").val([seasonNo]);
	});
});
</script>

</head>


<body>
<div class="container">
<h1>ì ë³´ ìì  í¼</h1>
	<form action="update.do" method="post">
	<div class="form-group">
		<label for="no">ë²í¸</label>
		<input name="no" id="no" class="form-control" readonly="readonly" value="${vo.no }">
	</div>
	<div class="form-group" id="seasonNo">
		<label for="season">ê³ì </label><br>
			<input type="radio" id="spring" name="seasonNo" value="1">
			<label for="spring">ë´</label>
			<input type="radio" id="summer" name="seasonNo" value="2">
			<label for="summer">ì¬ë¦</label>
			<input type="radio" id="autumn" name="seasonNo" value="3">
			<label for="autumn">ê°ì</label>
			<input type="radio" id="winter" name="seasonNo" value="4">
			<label for="winter">ê²¨ì¸</label>
	</div>
	<div class="form-group">
		<label for="name1">ëª¨ì</label>
		<input name="name1" id="name1" class="form-control" value="${vo.name1 }">
	</div>
	<div class="form-group">
		<label for="link1">ëª¨ìë§í¬</label>
		<input name="link1" id="link1" class="form-control" value="${vo.link1 }">
	</div>
	<div class="form-group">
		<label for="name2">ìì</label>
		<input name="name2" id="name2" class="form-control" value="${vo.name2 }">
	</div>
	<div class="form-group">
		<label for="link2">ììë§í¬</label>
		<input name="link2" id="link2" class="form-control" value="${vo.link2 }">
	</div>
	<div class="form-group">
		<label for="name3">íì</label>
		<input name="name3" id="name3" class="form-control" value="${vo.name3 }">
	</div>
	<div class="form-group">
		<label for="link3">íìë§í¬</label>
		<input name="link3" id="link3" class="form-control" value="${vo.link3 }">
	</div>
	<div class="form-group">
		<label for="name4">ì ë°</label>
		<input name="name4" id="name4" class="form-control" value="${vo.name4 }">
	</div>
	<div class="form-group">
		<label for="link4">ì ë°ë§í¬</label>
		<input name="link4" id="link4" class="form-control" value="${vo.link4 }">
	</div>
	
	<button class="btn btn-default">ìì </button>
	<button type="reset" class="btn btn-default">ìë¡ ìë ¥</button>
	<button type="button" id="cancelBtn" class="btn btn-default">ì·¨ì</button>
	</form>
</div>
</body>
</html>