<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<title>Ogani | Template</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">

</style>
</head>
<body>
    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="../img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>${vo.chef }</h2>
                        <div class="breadcrumb__option">
                            <!-- <a href="./index.html">Home</a> -->
                            <span>의 레시피</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->
	<section class="blog spad" style="padding-top: 0px;">
        <div class="container">
                    <div class="row">
                        
                          <c:forEach var="vo" items="${list }">
                          <div class="col-3">
                            <div class="blog__item">
                                <div class="blog__item__pic">
                                    <a href="../recipe/recipe_detail.do?no=${vo.no}"><img src="${vo.poster }"></a>
                                </div>
                                <div class="blog__item__text">
                                    <ul>
                                        <!-- <li><i class="fa fa-calendar-o"></i> May 4,2019</li> -->
                                        <li><i class="fa fa-comment-o"></i> ${vo.hit }</li>
                                    </ul>
                                    <h5><a href="../recipe/recipe_detail.do?no=${vo.no}">${vo.title }</a></h5>
                                    <!-- <p>Sed quia non numquam modi tempora indunt ut labore et dolore magnam aliquam
                                        quaerat </p> -->
                                    <!-- <a href="#" class="blog__btn">READ MORE <span class="arrow_right"></span></a> -->
                                
                                
                                </div>
                            </div>
                             </div>	<!-- ===== 여기 링크 수정필요 -->
                          </c:forEach>
                       	<div class="product__pagination" style="margin-left: 17em;">
                    	<c:if test="${startPage>1 }">
                       <a href="../recipe/chefs_recipe.do?page=${startPage-10}&name=${name}"><i class="fa fa-long-arrow-left"></i></a>
                        </c:if>
                        <c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" >
                        	<a href="../recipe/chefs_recipe.do?page=${i }&name=${name}">${i }</a>
                      	</c:forEach>
                      	<c:if test="${endPage<totalpage }">
                        <a href="../recipe/chefs_recipe.do?page=${endPage+10}&name=${name}"><i class="fa fa-long-arrow-right"></i></a>
                    	</c:if>
                    </div>
                        
                       
             </div>
         </div>
    </section>
    <!-- Blog Section End -->
    
  </body>
</html>