<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#login_input{
	display: none;
}
#login_div{
	display: table;
	 
	width:10px;
	height:10px;
	position: relative;
	top: -34em;
	left: -5.5em;
	float: right;
	
}
#login_div input{
	font-size: 12pt;
	 height: 23px;
	border: 0.5px solid #7fad39;
	border-radius: 15px;
	line-height: 23px;		
}
#login_div #login_go{
		width: 40px;
		height: 27px;
		color: #ffffff;
		border-radius: 35px;
		background-color:#7fad39;
		text-align: center;
		position: relative;
		right: -4.3em;
		top: -3.2em;
		opacity:0.9;
} 
</style>
</head>
<body>
	   <!-- Hero Section Begin -->
    <section class="hero">
        <div class="container">
            <div class="row" >
                <div class="col-lg-3">
                    <!--
                    <div class="hero__categories">
                        <div class="hero__categories__all">
                            <i class="fa fa-bars"></i>
                            <span>All departments</span>
                        </div>
                        <ul>
                            <li><a href="#">Fresh Meat</a></li>
                            <li><a href="#">Vegetables</a></li>
                            <li><a href="#">Fruit & Nut Gifts</a></li>
                            <li><a href="#">Fresh Berries</a></li>
                            <li><a href="#">Ocean Foods</a></li>
                            <li><a href="#">Butter & Eggs</a></li>
                            <li><a href="#">Fastfood</a></li>
                            <li><a href="#">Fresh Onion</a></li>
                            <li><a href="#">Papayaya & Crisps</a></li>
                            <li><a href="#">Oatmeal</a></li>
                            <li><a href="#">Fresh Bananas</a></li>
                        </ul>
                    </div>-->
                </div>
                <div class="col-lg-12">
                   
                    <div class="hero__item set-bg" data-setbg="../img/hero/banner.jpg" >
                    	
                        <div class="hero__text">
                          <!--  <span>FRUIT FRESH</span>-->
                            <h2>냉장고 재료<br />레시피추천</h2>
                            <p>냉장고에 있는 재료로 레시피를 활용해보세요!</p>
                            <a href="#" class="primary-btn">GO</a>
                        </div>
                    </div>
                </div>
            </div>
            <div id="login_input">
	            <div id="login_div">
	            <input type="text" size=15 placeholder="ID" style="padding-left: 10px;">           
	            <input type="text" size=15 placeholder="비밀번호" style="padding-left: 10px;">
	           	<button id="login_go">go</button>
	           </div>
	           
            </div>
            
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Categories Section Begin -->
    <section class="categories">
        <div class="container">
            <div class="row">
                <div class="categories__slider owl-carousel">
                    <div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="../img/categories/cat-1.jpg">
                            <h5><a href="#">Fresh Fruit</a></h5>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="../img/categories/cat-2.jpg">
                            <h5><a href="#">Dried Fruit</a></h5>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="../img/categories/cat-3.jpg">
                            <h5><a href="#">Vegetables</a></h5>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="../img/categories/cat-4.jpg">
                            <h5><a href="#">drink fruits</a></h5>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="../img/categories/cat-5.jpg">
                            <h5><a href="#">drink fruits</a></h5>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Categories Section End -->
    
        <!-- Blog Section Begin -->
        
    <section class="from-blog spad">
        <div class="container">
           <section class="categories">
        <div class="container">
            <div class="row">
                <div class="categories__slider owl-carousel">
                </div>
                </div>
                </div>
                </section>
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title from-blog__title">
                        <h2>오늘의 레시피</h2>
                    </div>
                </div> 
            </div>
            <div class="row">
             
            <c:forEach var="vo" items="${list }" begin="0" end="8">
                
                <div class="col-lg-3 col-md-3 col-sm-5">
                    <div class="blog__item">
                        <div class="blog__item__pic">
                            <img src="${vo.poster }" alt="">
                        </div>
                        <div class="blog__item__text">
                        <c:if test="${fn:length(vo.title)<30 }">  
                            <h5><a href="#">${vo.title }</a></h5>      
                        </c:if>
                        <c:if test="${fn:length(vo.title)>=30 }">  
                            <h5><a href="#">${fn:substring(vo.title,0,25) }...</a></h5>      
                        </c:if>
                        </div>
                    </div>
                </div>
             </c:forEach>   
               
                    </div>
                </div>
        
    </section>
   

    <!-- Latest Product Section Begin -->
    <section class="latest-product spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-6">

                </div>
                <div class="col-lg-4 col-md-6">

                </div>
                <div class="col-lg-4 col-md-6">

                </div>
            </div>
        </div>
    </section>
    <!-- Latest Product Section End -->
</body>
</html>