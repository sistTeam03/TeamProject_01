<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	   <!-- Hero Section Begin -->
    <section class="hero">
        <div class="container">
            <div class="row">
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
                   
                    <div class="hero__item set-bg" data-setbg="../img/hero/banner.jpg">
                        <div class="hero__text">
                          <!--  <span>FRUIT FRESH</span>-->
                            <h2>냉장고 재료<br />레시피추천</h2>
                            <p>냉장고에 있는 재료로 레시피를 활용해보세요!</p>
                            <a href="#" class="primary-btn">GO</a>
                        </div>
                    </div>
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
                            <ul>
                                <li><i class="fa fa-calendar-o"></i> 5 4,2019</li>
                                <li><i class="fa fa-comment-o"></i> 5</li>
                            </ul>
                            <h5><a href="#">${vo.title }</a></h5>
                           
                        </div>
                    </div>
                </div>
             </c:forEach>   
                
                    </div>
                </div>
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