<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
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
		$(this).children("#card_img").css("width","260px");
	},function(){
		$(this).children("#card_title").show();
		$(this).children("#card_title").css("width","150px");
		$(this).children("#card_img_div").css("width","110px");
		$(this).children("#card_img").css("width","110px");
	});
	
/* 	$('#card_img_div img').click(function(){
		let link=$('#detail_link a').attr("href")
		console.log(link);
		 location.href=link;
	}); */
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
<div class="container">
            <div class="row">
            <div id="login_input">
	            <div id="login_div">
	            <input type="text" size=15 placeholder="ID" style="padding-left: 10px;">           
	            <input type="text" size=15 placeholder="비밀번호" style="padding-left: 10px;">
	           	<button id="login_go">go</button>
	           </div>
	           
            </div>
            </div>
</div>
    <!-- 나누기 -->
    
    <section class="product spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-5">
                    <div class="sidebar">             
                        <div class="sidebar__item">
                        <h4>최근 방문한 레시피</h4>
                            <div class="latest-product__text">
                            
                                    <div class="latest-prdouct__slider__item" id="card_full">
                                        <c:forEach var="cvo" items="${cList }" varStatus="c">       
                                       	<a href="../recipe/recipe_detail.do?no=${cvo.no }" style="width: 260px;">
                                      		 <div id="card_tr" style="width: 260px;height: 110px;margin-top: 15px;">    
                                          	   <div id="card_img_div" style="width: 110px;height: 110px;float: left;">
                                          	      <img src="${cvo.poster }" alt="" id="card_img" style="border-radius: 10px;">
                                           	   </div>
                                               <div class="card_title_title" id="card_title"style="height: 110px;width: 150px;float: left;">
                                                  <h6 style="padding-top: 15px;" >${cvo.title }</h6>
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
                        <div class="row">
                            <div class="col-lg-4 col-md-5">
                                <div class="filter__sort">
                                    <span>Sort By</span>
                                    <select>
                                        <option value="0">Default</option>
                                        <option value="0">Default</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4">
                                <div class="filter__found">
                                    <h6><span>16</span> Products found</h6>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-3">
                                <div class="filter__option">
                                    <span class="icon_grid-2x2"></span>
                                    <span class="icon_ul"></span>
                                </div>
                            </div>
                        </div>
                    
        			 <div class="row">
                       <c:forEach var="lvo" items="${list }">
                        <div class="col-lg-3 col-md-5 col-sm-5">
                            <div class="product__item">             
                                <div class="product__item__pic set-bg" data-setbg="${lvo.poster }">
                                    <ul class="product__item__pic__hover">
                                        <li><a href="#" class="pop"><i class="fa fa-heart"></i></a></li>
                                        <li><a href="#" class="pop"><i class="fa fa-retweet"></i></a></li>
                                        <li><a href="#" class="pop"><i class="fa fa-shopping-cart"></i></a></li>
                                    </ul>
                                </div>
                                <div class="product__item__text">
                                    <h6><a href="../recipe/detail_before.do?no=${lvo.no }">${lvo.title }</a></h6>
                                    
                                </div>
                            </div>
                        </div>
                       </c:forEach>
                       </div>
                    </div>
                    <div class="product__pagination">
                    	<c:if test="${startPage>1 }">
                       <a href="../recipe/recipe.do?page=${startPage-10}"><i class="fa fa-long-arrow-left"></i></a>
                        </c:if>
                        <c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" >
                        	<a href="../recipe/recipe.do?page=${i }">${i }</a>
                      	</c:forEach>
                      	<c:if test="${endPage<totalpage }">
                        <a href="../recipe/recipe.do?page=${endPage+10}"><i class="fa fa-long-arrow-right"></i></a>
                    	</c:if>
                    </div>
                </div>
            </div>
       
        </div>
    </section>
  
</body>
</html>