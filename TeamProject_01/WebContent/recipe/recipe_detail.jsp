<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
<style type="text/css">
#replyinsert{
	height: 15em;
	margin-left: 29em;
}
#msg{
	width: 40em;
	height: 7em;
	border-radius: 13px;
	padding-left: 20px;
	padding-top: 20px;
}
.reply_print{

   
    border-radius: 23px;
    background-color: #f1e4d3;
    width: 61em;
   height: 21em;
    margin: 0px auto;
}
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
    height: 16em;
}
.content_img1{
 position: relative;
 width: 26em;
 border-radius:32px;
height: 16em;
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
 #replyBtn,.updateBtnok{
 	background-color: #ddf2bc;
 }
  #replyBtn:hover,.updateBtnok:hover{
  	  color: #fff;
    background-color: #7fad39;
    border-color: #7fad39;
  }
  <%--0409수정--%>
.categories__item{
height:150px;
position: relative;
}

a.shop{
	color:#f8f9fa;
	text-decoration:none;
	background-color:rgb(0 0 0 / 25%);
}
<%--0409수정완료--%>
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">

$(function(){
	let no=$('#detail_no').attr('data-no');//레시피 no
	$.ajax({
		type:'post',
		url:'../recipe/recipe_reply_print.do',
		data:{"no":no},
		success:function(result)
		{
			$('.reply_print').html(result);
			return;
			//$('.post').css("overflow","auto");  replyPageBtn
			  
			 
		}
	});
	$(document).on("click",".replyPageBtn",function(){
		
			let page=$(this).text();
			
			 $.ajax({
					type:'post',
					url:'../recipe/recipe_reply_print.do',
					data:{"page":page,"no":no},
					success:function(result)
					{
						$('.reply_print').html(result);
					}
			 });
		 });//페이징
		 $(document).on("click",".delBtn",function(){
			 let replyno=$(this).attr('data-no').trim();
			 let page=$(this).attr('reply-page').trim();
				 $.ajax({
						type:'post',
						url:'../recipe/recipe_reply_delete.do',
						data:{"no":no,"page":page,"replyno":replyno},
						success:function(result)
						{
							
							$('.reply_print').html(result);
						}
				 });
			 });//삭제
		  $('#replyBtn').click(function(){
			let msg=$('#msg').val().trim();
			$('#msg').val("")
			 $.ajax({
					type:'post',
					url:'../recipe/recipe_reply_insert.do',
					data:{"no":no,"msg":msg},
					success:function(result)
					{
						
						$('.reply_print').html(result);
					}
			 });
		}); //등록  

		  $(document).on("click",".updateBtn",function(){
			  		$(this).hide();
			  		let replyno=$(this).attr('data-no');	
			  		$('.updateBtnok').show();
			  		$('#replyBtn').hide();
			  		console.log("횟수");
			  		 $.ajax({
							type:'post',
							url:'../recipe/recipe_update_show.do',
							data:{"replyno":replyno},
							
							success:function(result)
							{
								$('#msg').val(result);
								
							}
					 });
			  		let count=0;
			  	 $('.updateBtnok').click(function(){
			  				let msg=$('#msg').val();
			  				let page=$('.delBtn').attr('reply-page');
			  				$(this).hide();
					  		$('.updateBtn').show();
					  		$('.updateBtnok').hide();
					  		$('#replyBtn').show();
							console.log(no);
							console.log(page);
							console.log(msg);
							console.log(replyno);
							
							if(count==1){
								return;
							}
							 $.ajax({
									type:'post',
									url:'../recipe/recipe_reply_update.do',
									data:{"page":page,"no":no,"msg":msg,"replyno":replyno},
									async: false,
									success:function(result)
									{
										$('.reply_print').html(result);
										$('#msg').val('');
										count=1;
									}
							 });
			   		
				 });
		  });//수정
});


	 
		
		

</script>
</head>
<body>
	<div class=row>
		  <div id="login_input"><!-- 로그인 div -->        	
	            	<div id="login_div">
			            <input type="text" id="login_id" size=20 placeholder="ID" style="padding-left: 10px;" autocomplete="off">           
			            <input type="password" id="login_pwd" size=20 placeholder="비밀번호" style="padding-left: 10px;">
			           	<button id="login_go">go</button>
	           		</div>          
            </div>
	</div>
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
                    <%--0409수정--%>
 					<div style="height:15px"></div>
 					<hr>
 					<h6 style="color:green;font-weight: bold;">관련 상품</h6>
                    <div style="height:15px"></div>
                    
                     <div class="categories__slider owl-carousel">
                     <c:forEach var="svo" items="${printlist }">
                     	 <div class="col-lg-3">
		                        <div class="categories__item set-bg" data-setbg="http:${svo.poster }">
		                        <!-- 링크추가 -->
		                            <h6 style="font-size: 11pt; color:white;"><a href="../recipe/shop.do" class=shop>${svo.title }<br><fmt:formatNumber value="${svo.price }" pattern="0,000"/></a></h6>
		                        </div>
		                   </div>
		             </c:forEach>
		              </div>
               	  <%--0409수정완료--%>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__text">
                        <h3 data-no=${vo.no } id="detail_no">${vo.title }</h3>
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
                            <%--0409수정--%>
                            <hr>
                            <%--0409수정완료--%>
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
                        <div class="tab-content" >
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
        
        

        <div class="comment" style="border: 1px soild black;width:960;">
        <!-- 댓글 목록 출력 -->
	        <div class="reply_print" >
	       	
	       				<!-- 출력공간 -->
	        </div>
        </div>
	
	        <div style="height:50px"></div>
	        
	   <%--       <c:if test="${sessionScope.sesson_id!=null }">  --%>
			        <div class=row id="replyinsert">
			        	<table style="margin-top: 4em;">
			        		<tr>
				                <td><textarea id="msg"></textarea> 
				                	
				                </td>
				                <td><input type=button value=댓글작성 class="btn btn-md " id="replyBtn" style="height:80px"></td>
				                <td><input type=button value=댓글수정 class="btn btn-md  updateBtnok" id="" style="height:80px;display: none;"></td>
			                </tr>
			            </table>
			      </div>
		    <%--    </c:if> --%> 

    </section>
    <!-- Product Details Section End -->

</body>


</html>