<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.moreBtn{
	border: none;
    background: none;
    float: right;
    position: relative;
    left: -67px; 
}
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
.updateBtn{
	 background-color: #ddf2bc;
    border: #fff;
     width: 5em;
     color: #400202;
      border-radius: 9px;
}
.delBtn{
background-color: #ff7474;
    border: #fff;
     width: 5em;	
     color: #2c312b;
      border-radius: 9px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	var reply0=$('.length0').text();
	var reply1=$('.length1').text();
	var reply2=$('.length2').text();
	for(let i=0;i<3; i++){
		let str=$('.length'+i).text();
		let length=str.length;
		if(length>50){
			 strshow=str.substring(0,50)+"...";
			 strhide=str.substring(50,length)
			 
			$('.length'+i).html(strshow);
			
		}else{
			$('.moreBtn').hide();		
		}
	}//댓글 글자수 제어
	$('.moreBtn').click(function(){
		let num=$(this).attr('data');
	 	
		
		if(num==0){
			$('.length0').css("overflow-y","auto");
			$('.length'+num).text(reply0);
			$(this).hide();
		}else if(num==1){
			$('.length1').css("overflow-y","auto");
			$('.length'+num).text(reply1);
			$(this).hide();
		}else if(num==2){
			$('.length2').css("overflow-y","auto");
			$('.length'+num).text(reply2);
			$(this).hide();
		}
		
		
	})//댓글 더보기 
})
</script>
</head>
<body>	
		<div style="height: 330px;">
			<c:forEach var="rvo" items="${rList }" begin="0" end="2" varStatus="s">
			<table class="detail_reply"	>

	        <tr>
	        	<td colspan="2" style="padding-left: 100px;">${rvo.regdate }</td>
	        </tr>
	        <tr>
	        	<td width="20%" rowspan="2">${rvo.nickname }</td>
	        	<td style="width: 30em;">
	        		<div id="replyshow" style="height: 80px;text-align: left;padding-left: 35px; padding-top: 11px;" class="length${s.index }">${rvo.msg }
	        		
	        		</div>
	 				
	        	</td>
	        	<td>
	        	<input type="button" id="" class="moreBtn " value="더보기 " data="${s.index }"> 
	        	</td>
	        	<td id="temp${s.index }" width=20% rowspan="2">
	        					 
		      	  			 <input type=button id="updateBtn${s.index }" class="updateBtn " value="수정 " data-no="${rvo.no }"> 
		        			<input type=button id="" class="delBtn " value=삭제  data-no="${rvo.no } " reply-page="${curpage }">
		        			<!-- 수정 삭제.. 버튼이 안눌립니다 -->
		        		</td>
	        	</tr>
	         </table>
	         <hr style="margin:0px;border-top: 1px rgb(0 0 0 / 30%) dotted;">	
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