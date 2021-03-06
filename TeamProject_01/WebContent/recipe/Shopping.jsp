<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.sort{

 cursor: pointer;
width: 4em;
float: left;

background-color: #ddf2bc;
border-bottom-left-radius: 16px;
margin-left: 6px;
position: relative;
right: -8em;
top: -2.8em;
border-bottom-right-radius: 16px;
}
.sort:hover{
	color: #fff;
    background-color: #7fad39;
    border-color: #7fad39;
}
.sort:focus{
	box-shadow: 0 0 0 .2rem #ddf2bc;
}
#sort_new{
margin-left: 0.5px;
}
.list_img{
	cursor: pointer;
}
#card_img{
	width: 110px;
	height: 110px;
	
}
.sidebar__item{
	position: relative;
	width: 17em;
}
#card_img,#card_title{

	position: relative;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let poster=${cvo.poster }
$(function(){
	$('#card_full div').hover(function(){
		$(this).children("#card_title").hide();
		$(this).children("#card_title").css("width","0px");
		$(this).children("#card_img_div").css("width","260px");
		$(this).children("#card_img").css("width","110px");
		$(this).children("#card_img").css("border-radius","100px");
	},function(){
		$(this).children("#card_title").show();
		$(this).children("#card_title").css("width","150px");
		$(this).children("#card_img_div").css("width","110px");
		$(this).children("#card_img").css("width","110px");
		$(this).children("#card_img").css("border-radius","10px");
	});
	
 	$('.list_img').click(function(){
		let link=$(this).attr("list_link");
		console.log(link);
		 location.href=link;
	}); 
 	//$("#id").val("1").prop("selected", true);

 	$('.sort').click(function(){
 		let sort=$(this).attr('data');
 		
 		location.href="../recipe/recipe.do?sort="+sort;
 		
 	});
 	
});
</script>
</head>
<meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ogani | Template</title>

   
<body>
<!-- 0406 ?????? ????????? ?????? -->
<section class="blog-details-hero set-bg" data-setbg="../img/blog/details/details-hero.jpg">
	<div class="container">
	            <div class="row">
	            <div id="login_input">
		            <div id="login_div">
		            <input type="text" size=20 placeholder="ID" style="padding-left: 10px;">           
		            <input type="text" size=20 placeholder="????????????" style="padding-left: 10px;">
		           	<button id="login_go">go</button>
		           </div>
	            </div>
	             <div class="col-lg-12">
                    <div class="blog__details__hero__text">
                        <h2>?????????</h2> 
                        <figure>
				          <header class="heading" style="color:white"> <span style="color:yellow;font-weight:bold;"></span>????????? ????????? ???????????? ?????? ??? ?????????!</header>
				        </figure>
                    </div>
                </div>
	            </div>
	</div>
 </section>
    <!-- ????????? -->

    
    <section class="product spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-5">
                    <div class="sidebar">             
                        <div class="sidebar__item">
                         <h4 style="margin-top: 4em;">???????????? ??????</h4>
                            <div class="latest-product__text">
                            
                                    <div class="latest-prdouct__slider__item" id="card_full">
                                        <c:forEach var="cvo" items="${printulist }" varStatus="c">       
                                       	<a href="../recipe/cart_delete.do?no=${cvo.no }&page=${curpage}" style="width: 260px;">
                                      		 <div id="card_tr" style="width: 260px;height: 110px;margin-top: 15px;">    
                                          	   <div id="card_img_div" style="width: 110px;height: 110px;float: left;">
                                          	      <img src="${cvo.poster }" alt="" id="card_img" style="border-radius: 10px; ">
                                           	   </div>
                                               <div class="card_title_title" id="card_title"style="height: 110px;width: 150px;float: left;">
                                                  <h6 style="padding-top: 15px;" >${cvo.title }</h6>
                                                  <h6 style="padding-top: 15px;" ><fmt:formatNumber value="${cvo.price }" pattern="0,000"/>???</h6>
                                               </div>
                                         	</div>
                                       	   </a>
                                  </c:forEach>
                                      </div>
                                  
                                
                                </div>
                            </div>
                        </div>
                    </div>
               
                
                <div class="col-lg-9 col-md-7">
                    
                    <div class="filter__item">
                        <div class="row" >
                        <div class="col-lg-8 col-md-7"></div>
                            <div class="col-lg-4 col-md-5" id="sort_tab">
                            </div>
                        </div>
                    
        			 <div class="row">
                       <c:forEach var="lvo" items="${list }">
                        <div class="col-lg-3 col-md-5 col-sm-5">
                            <div class="product__item">             
                                <div class="product__item__pic set-bg list_img" data-setbg="${lvo.poster }" style="border-radius: 10px;" list_link="../recipe/shop_cart.do?no=${lvo.no }">
                                    
                                </div>
                                <div class="product__item__text">
                                    <h6><a href="#" style="font-weight: bold;">${lvo.title }</a></h6>
                                    <h6><a href="#"><fmt:formatNumber value="${lvo.price }" pattern="0,000"/>???</a></h6>
                                </div>
                            </div>
                        </div>
                       </c:forEach>
                       </div>
                    </div>
                    <div class="product__pagination">
                    	<c:if test="${startPage>1 }">
                       <a href="../recipe/shop.do?page=${startPage-10}"><i class="fa fa-long-arrow-left"></i></a>
                        </c:if>
                        <c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" >
                        	<a href="../recipe/shop.do?page=${i }">${i }</a>
                      	</c:forEach>
                      	<c:if test="${endPage<totalpage }">
                        <a href="../recipe/shop.do?page=${endPage+1}"><i class="fa fa-long-arrow-right"></i></a>
                    	</c:if>
                    </div>
                </div>
            </div>
       
        </div>
    </section>
  
</body>
</html>