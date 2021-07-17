<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test like</title>
	<!-- BootStrap CDN 방식 -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	var list = {
			1:{"button":"glyphicon glyphicon-heart"},
			2:{"button":"glyphicon glyphicon-heart-empty"}
	}
	var num =1 ;
	
	
$(function () {
	

	
	$("#like2").click(function () {
		if(num==1){
			$("#like").attr("class",list[num]["button"])
			num ++;
			//alert(num);
			
		}else if(num==2){
			$("#like").attr("class",list[num]["button"])
			num--;
			//alert(num);
		}
	});
});
</script>
</head>
<body>
<h1>test like</h1>

	<table>
	<tr>
	<td colspan="2">
			<button type="button" class="btn btn-default btn-sm" id="like2">
          <span class="glyphicon glyphicon-heart-empty" id="like"></span> 
        </button>
        </td>
    </tr>
    </table>
</body>
</html>