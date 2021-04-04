<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.owl-carousel .owl-item img {
    display: block;
    width: 140px;
    padding-top: 10px;
}
</style>
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
                                
                                <div class="latest-product__slider owl-carousel">
                                    <div class="latest-prdouct__slider__item">
                                        <c:forEach var="cvo" items="${cList }" varStatus="c">
                                       
                                       <c:if test="${c.index<6 }">
                                        <a href="#" class="latest-product__item">
                                           <div class="latest-product__item__pic">
                                                <img src="${cvo.poster }" alt="">
                                            </div>
                                            <div class="latest-product__item__text">
                                                <h6>${cvo.title }</h6>
                                             
                                            </div>
                                        </a>
                                       </c:if>
                                        </c:forEach>
                                      </div>
                                  
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
  	 <script src="../js/jquery-3.3.1.min.js"></script>

    <script src="../js/jquery.nice-select.min.js"></script>
    <script src="../js/jquery-ui.min.js"></script>
    <script src="../js/jquery.slicknav.js"></script>
    <script src="../js/mixitup.min.js"></script>
   <!--  <script src="../js/owl.carousel.min.js"></script> -->
    <script src="../js/main.js"></script>
</body>
</html>