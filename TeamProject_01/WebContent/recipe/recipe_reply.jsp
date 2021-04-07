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
    height:110px; width: 970px; 
}
.replyPageBtn:hover{
	background-color: #7fad39;
	border-color: #7fad39;
	color: #ffffff;
}
.replyPageBtn{
	display: inline-block;
	width: 45px;
	height: 30px;
	border: 1px solid #b2b2b2;
	font-size: 14px;
	font-weight: 700;
	line-height: 28px;
	text-align: center;
	margin-right: 16px;
	transition: all, 0.3s;
	background: #f8fdf7;
	border-radius: 6px;
}
</style>
</head>
<body>	
		<div style="height: 330px;">
			<c:forEach var="rvo" items="${rList }" begin="0" end="2" varStatus="s">
			<table class="detail_reply"	 >

	        <tr>
	        	<td colspan="2" style="padding-left: 100px;">${rvo.regdate }</td>
	        </tr>
	        <tr>
	        	<td width="20%" rowspan="2">${rvo.nickname }</td>
	        	<td style="width: 30em;">
	        		<div id="replyshow">${rvo.msg }</div>
	  
	        	</td>
	        	<td id="temp${s.index }" width=20% rowspan="2">
		        			<input type=button id="" class="updatOkBtn btn-info" value="완료 " style="width: 40px;height: 20px;font-size: 9pt;display: none;" data-no="${rvo.no }">
		        			 <input type=button id="" class="updateBtn btn-info" value="수정 " style="width: 40px;height: 20px;font-size: 9pt" data-no="${rvo.no }"> 
		        			<input type=button id="" class="delBtn btn-danger" value=삭제  style="width: 40px;height: 20px;font-size: 9pt"  data-no="${rvo.no } " reply-page="${curpage }">
		        			<!-- 수정 삭제.. 버튼이 안눌립니다 -->
		        		</td>
	        	</tr>
	         </table>	
     </c:forEach>
     </div>
        <table style="width: 970px;height: 50px;margin: 0px auto;">
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