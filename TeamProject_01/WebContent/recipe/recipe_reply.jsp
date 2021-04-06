<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.detail_reply tr{
	 display: block;
}
.detail_reply{
    margin-left: 4em;
    height: 200px; width: 400px; float: left;
}
</style>
</head>
<body>
			<c:forEach var="rvo" items="${rList }" begin="0" end="3" varStatus="s">
			<table class="detail_reply"  >

	        <tr>
	        	<td colspan="3">${rvo.regdate }</td>
	        </tr>
	        <tr>
	        	<td width="20%">${rvo.nickname }</td>
	        	<td>
	        		<div id="replyshow">${rvo.msg }</div>
	  
	        	</td>
	        </tr>
	        		<tr>
		        		<td id="temp${s.index }">
		        			<input type=button id="" class="updatOkBtn btn-info" value="완료 " style="width: 40px;height: 20px;font-size: 9pt;display: none;" data-no="${rvo.no }">
		        			 <input type=button id="" class="updateBtn btn-info" value="수정 " style="width: 40px;height: 20px;font-size: 9pt" data-no="${rvo.no }"> 
		        			<input type=button id="" class="delBtn btn-danger" value=삭제  style="width: 40px;height: 20px;font-size: 9pt"  data-no="${rvo.no } " reply-page="${curpage }">
		        			<!-- 수정 삭제.. 버튼이 안눌립니다 -->
		        		</td>
		        	</tr>
	         </table>	
     </c:forEach>
        <table style="width: 300px;height: 50px;position: relative;top: -8em;">
        <tr>	
	        		<td>
	        		<c:if test="${startPage>1 }">
                       <a href="../recipe/recipe_reply_print.do?page=${startPage-10}"><i class="fa fa-long-arrow-left"></i></a>
                        </c:if>
                        <c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" >
                        	<button  class="replyPageBtn" value="${i}">${i }</button>
                      	</c:forEach>
                      	<c:if test="${endPage<totalpage }">
                        <a href="../recipe/recipe_reply_print.do?page=${endPage+10}"><i class="fa fa-long-arrow-right"></i></a>
                    	</c:if>
	        		</td>
	        	</tr>
        </table>
</body>
</html>