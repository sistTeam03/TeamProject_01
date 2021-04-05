<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<style type="text/css">
#info{
	margin:0px auto;
	padding: 0px 35px;
}
.content1, .content2{
width:1140px;
height: 20em;
display: block;

}
.content_img2{
	border-radius:32px;
    position: relative;
    width: 26em;
}
.content_img1{
 position: relative;
 width: 26em;
 border-radius:32px;
}
.content2{
	text-align: left;
}
.content1{
text-align: right;
}
.content_p1,.content_p2{
	width:20em;
	    font-size: 20pt;
	    line-height: 34px;
}
.content_p1{
	top: -7em;
    left: -18em;
}
.content_p2{
	 top: -8em;
    left: 9em;
 }
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let i=0;
$(function(){
	$(document).on('click','.delBtn',function(){
		let no=$(this).attr("data-no");//data-no 값 속성 추가
		let recipeno=$(this).attr("recipe-no");
		location.href="../recipe/recipe_reply_delete.do?no="+no+"&recipeno="+recipeno;
	});
	$('.delBtn').click(function(){
		//Dummy
	});
	
	$(document).on('click','.updateBtn',function(){
		$('.updateli').hide();//updateli 수정칸 추가
		$('.updateBtn').text("수정");
		let no=$(this).attr("data-no");
		if(i==0)
		{
			$(this).text("취소");
			$('#m'+no).show("slow");
			i=1;
		}
		else
		{
			$(this).text("수정");
			$('#m'+no).hide("slow");
			i=0;
		}
		
	});
	
	$('.updateBtn').click(function(){
		//Dummy
	});
});
</script>
</head>
<body>

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="../img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>레시피</h2>
                        <div class="breadcrumb__option">
                            <a href="./index.html">Home</a>
                            <a href="./index.html">Vegetables</a>
                            <span>Vegetable’s Package</span>
                        </div>
                    </div>
                </div>
            </div> 
        </div>
       
    </section>
    <!-- Breadcrumb Section End -->
	<!-- 
		/*
		 * private int no, hit2;
			private String title, poster, chef, chef_poster, info, info1, info2, info3, ingre,
			content_poster, liked, regdate, chef_msg, content;
		 */
	 -->
    <!-- Product Details Section Begin -->
    <section class="product-details spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__pic">
                        <div class="product__details__pic__item">
                            <img class="product__details__pic__item--large"
                                src="${vo.poster }" alt="">
                        </div>
                        
                       <c:if test="${sessionScope.sesson_id!=null }">
	                        <c:if test="${count==0 }">
	                        	<a href="../recipe/bookmark.do?no=${vo.no }" class="primary-btn" style="background-color: lightred;margin:0px auto;">찜하기</a>&nbsp;&nbsp;
	    					</c:if>
	    					
	    					<c:if test="${count!=0 }">
	    						<span class="primary-btn" style="background-color: lightred;margin:0px auto;">찜 완료</span>&nbsp;&nbsp;
	    					</c:if>
    					</c:if>
    					
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__text">
                        <h3>${vo.title }</h3>
                        <div class="product__details__rating" style="color:gray">
                            <span style="color:gray">${vo.regdate }</span>
                            <span style="color:gray">조회수&nbsp;${vo.hit2 }</span>
                        </div>
                        <div class="product__details__price" style="color: green">
                        	<div>
                        	<img src="${vo.chef_poster }" width=50px height=50px>&nbsp;
                        	<span style="font-size: 13pt">${vo.chef }</span><br>
                        	<span style="font-size:9pt">${vo.chef_msg }</span>
                        	</div>
                        </div>
                        <p id="info">${vo.info }</p>

                        <ul>
                            <li><b>양</b> <span>${vo.info1 }</span></li>
                            <li><b>소요시간</b> <span>${vo.info2 }</span></li>
                            <li><b>난이도</b> <span>${vo.info3 }</span></li>
                            <li valign="top"><b>재료</b>
                                <div class="share">
                                    <!-- 재료 출력 부분 -->
                                    <c:forEach var="i" items="${ inglist}">
                                    	<span>${i }</span>,&nbsp; 
                                    </c:forEach>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-12">
                    <div class="product__details__tab">
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="nav-item">
                                레시피 상세
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                <div class="product__details__tab__desc">  
                                <c:forEach var="i" items="${poslist }" varStatus="s">
                                	<c:if test="${s.index%2==1 }">
                                	<div class="content1">
                                	<img  src="${i}" class="content_img1">
                                	<p class="content_p1">${conlist[s.index] }</p></div>
                                	</c:if>
                                	
                                	<c:if test="${s.index%2==0 }">
                                	<div class="content2">
                                	<img  src="${i}" class="content_img2">
                                	<p class="content_p2">${conlist[s.index] }</p></div>
                                	</c:if>
                                </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div style="height:50px"></div>
        
         <ul class="nav nav-tabs" role="tablist">
         <li class="nav-item"></li>
       </ul>
        
        <!-- 댓글 목록 출력 -->
        <table style="margin:0px auto;width:1200px;text-align: middle;vertical-align: middle;background-color: #F3F6FA;"class=table-condensed>
        <c:forEach var="rvo" items="${rList }">
	        	<tr  style="margin:0px auto;width:1200px;text-align: middle;vertical-align: middle;background-color: #F3F6FA;">
	        		<td width=20% style="text-align: left">${rvo.nickname }</td>
	        		<td rowspan=2 width=80%><pre>${rvo.msg }</pre></td>
	        	</tr>
	        	<tr  style="margin:0px auto;width:1200px;text-align: middle;vertical-align: middle;background-color: #F3F6FA;">
	        		<td width=20% style="text-align: left;font-size: 10pt">${rvo.regdate }</td>
	        		<c:if test="${sessionScope.sesson_id==rvo.id }">
		        		<td>
		        			<input type=button class="updateBtn btn-info" value="수정 " style="width: 40px;height: 20px;font-size: 9pt" data-no="${rvo.no }">
		        			<input type=button class="delBtn btn-danger" value=삭제  style="width: 40px;height: 20px;font-size: 9pt"  data-no="${rvo.no } " recipe-no="${vo.no }">
		        			<!-- 수정 삭제.. 버튼이 안눌립니다 -->
		        		</td>
		        	</c:if>
	        	</tr>
	        	<form action="../recipe/recipe_reply_update.do" method="post" >
			        	<table style="margin:0px auto;display:none" id="m${rvo.no }" class=updateli>
			        		<tr>
				                <td><textarea cols=100 rows=3></textarea>
				                	<input type="hidden" name=recipeno value="${vo.no }">
		             				<input type="hidden" name=no value="${rvo.no }">
				                 </td>
				                <td><input type=submit value=댓글수정 class="btn btn-md btn-success" style="height:80px"></td>
			                </tr>
			            </table>
			   </form>
        	</c:forEach>
        </table>
        
      <ul class="nav nav-tabs" role="tablist">
         <li class="nav-item"></li>
       </ul>
      
      	
	        <div style="height:50px"></div>
	        
	         <c:if test="${sessionScope.sesson_id!=null }"> 
			        <div class=reply>
			        <form action="../recipe/recipe_reply_insert.do" method="post" >
			        	<table style="margin:0px auto;">
			        		<tr>
				                <td><textarea cols=100 rows=3 name=msg></textarea> 
				                	<input type=hidden name=no value="${vo.no }">
				                </td>
				                <td><input type=submit value=댓글작성 class="btn btn-md btn-success" style="height:80px"></td>
			                </tr>
			            </table>
			            </form>
			      </div>
		       </c:if> 

    </section>
    <!-- Product Details Section End -->

</body>


</html>