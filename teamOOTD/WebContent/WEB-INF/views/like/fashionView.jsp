<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	System.out.println("fashionView.jsp");
%>
<style>
#like{
	color: red;
}
</style>



	<table>
	<tr>
		<c:if test="${empty login || login.id != likevo.id }">
		<!-- 로그인을 안했거나 좋아요를 클릭하지 않은 사람  -->
		<td colspan="2">
		<a href="/like/fashionLike.do?no=${param.no }&page=${param.page }&perPageNum=${param.perPageNum }" type="button" class="btn btn-default btn" id="like2" >
          <span class="glyphicon glyphicon-heart-empty" id="like"></span> 
          <span>${likevo.likeCnt }</span>
        </a>
        </td>
        </c:if>
        
        <c:if test="${!empty login && login.id == likevo.id }">
		<!-- 로그인을 했고 좋아요 클릭한 사람  -->
		<td colspan="2">
			<a href="/like/fashionDelete.do?no=${param.no }&page=${param.page }&perPageNum=${param.perPageNum }" type="button" class="btn btn-default btn" id="like2">
          <span class="glyphicon glyphicon-heart" id="like"></span> 
          <span>${likevo.likeCnt }</span>
          
        </a>
        </td>
        </c:if>
    </tr>
    </table>

