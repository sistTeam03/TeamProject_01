<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
   
    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>

<body>
    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                      <c:forEach var="vo" items="dList">
                        <h2>${dList.chef }</h2>
                        <div class="breadcrumb__option">
                            <!-- <a href="./index.html">Home</a> -->
                            <span>의 레시피</span>
                        </div>
                      </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

<!-- Blog Section Begin  -->
    <section class="blog spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-5">
                    <div class="sidebar">             
                        <div class="sidebar__item">
                        <h4 style="margin-top: 4em;">최근 방문한 쉐프</h4>
                          <div class="latest-product__text">
                            <div class="latest-prdouct__slider__item" id="card_full">
                              <c:forEach var="cvo" items="${dList }" varStatus="c">       
                                <a href="../recipe/recipe_detail.do?no=${cvo.no }" style="width: 260px;">
                                  <div id="card_tr" style="width: 260px;height: 110px;margin-top: 15px;">    
                                    <div id="card_img_div" style="width: 110px;height: 110px;float: left;">
                                       <img src="${dvo.poster }" alt="" id="card_img" style="border-radius: 10px; ">
                                         </div>
                                       <div class="card_title_title" id="card_title"style="height: 110px;width: 150px;float: left;">
                                         <h6 style="padding-top: 15px;" >${dvo.title }</h6>
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
                     </div>
        			 <div class="row">
                       <c:forEach var="lvo" items="${list }">
                        <div class="col-lg-3 col-md-5 col-sm-5">
                            <div class="product__item">             
                                <div class="product__item__pic set-bg list_img" data-setbg="${lvo.poster }" style="border-radius: 10px;" list_link="../recipe/detail_before.do?no=${lvo.no }">
                                </div>
                                <div class="chef_recipes_text">
                                    <!-- <ul>
                                        <li><i class="fa fa-calendar-o"></i> May 4,2019</li>
                                        <li><i class="fa fa-comment-o"></i> 5</li>
                                    </ul> -->
                                    <h5><a href="#">${dList.title }</a></h5>
                                    <p>${dList.info }</p>
                                    <a href="#" class="chef_recipe_detail">READ MORE <span class="arrow_right"></span></a>
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
        </div>
    </section>
    <!-- Blog Section End -->
  </body>
</html>