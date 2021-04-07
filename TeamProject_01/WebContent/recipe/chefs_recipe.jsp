<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<title>Ogani | Template</title>

<script type="text/javascript">
				document.getElementById("page1").style.backgroundColor="#7fad39";
				/* var button = document.getElementsByClassName("cheflistBtn");
				function click(e){
						 진행중 chef 메뉴색변경
				} */ 
</script>
<style type="text/css">
.cheflistBtn{
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

	border-radius: 6px;

}
.cheflistBtn:hover{
	background-color: #7fad39;
	border-color: #7fad39;
	color: #ffffff;
}
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
                       <button class="cheflist_beforeBtn" startpage="${startPage}" chefname="${name }"><i class="fa fa-long-arrow-left"></i></button>
                        </c:if>
                        <c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" >
                        	<button class="cheflistBtn" id="page${i }" style="background-color:#f8fdf7; ">${i }</button>
                      	</c:forEach>

                      	<c:if test="${endPage<totalpage }">
                        <button class="cheflist_nextBtn" endpage="${endPage}" chefname="${name }"><i class="fa fa-long-arrow-right"></i></button>
                    	</c:if>
                    </div>
                        
                       
             </div>
         </div>
    </section>
    <!-- Blog Section End -->
    
  </body>
</html>