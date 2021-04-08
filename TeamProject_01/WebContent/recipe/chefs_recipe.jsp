<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




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
                                    <a href="../recipe/recipe_detail.do?no=${vo.no}"><img src="${vo.poster }" style="border-radius: 20px;"></a>
                                </div>
                                <div class="blog__item__text">
                                    <%-- <ul>
                                        <!-- <li><i class="fa fa-calendar-o"></i> May 4,2019</li> -->
                                        <li>조회수 ${vo.hit }</li>
                                    </ul> --%>
                                    <h5><a href="../recipe/recipe_detail.do?no=${vo.no}">${vo.title }</a></h5>
                                    <!-- <p>Sed quia non numquam modi tempora indunt ut labore et dolore magnam aliquam
                                        quaerat </p> -->
                                    <!-- <a href="#" class="blog__btn">READ MORE <span class="arrow_right"></span></a> -->
                                
                                
                                </div>
                            </div>
                             </div>	
                          </c:forEach>
                          
                       	<div class="product__pagination" style="margin-left: 17em;">
                    	<c:if test="${startPage>1 }">
                       <button class="cheflist_beforeBtn" startpage="${startPage}" chefname="${name }"><i class="fa fa-long-arrow-left"></i></button>
                        </c:if>
                        <c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" >
                        	<button class="cheflistBtn" id="page${i }"    >${i }</button>
                      	</c:forEach>
						 <!-- <script type="text/javascript"> 현재페이지 색깔넣기 실패
						function color(id)			{<!-- onclick="javascript:color(id);" 
						  	let a=id;
						  	console.log(a);
						  
						  		$('#'+a).css("color","red");
						  		let b=$('#'+a).attr("test");
						  		console.log(b);
						 
						}  
						</script>--> 
                      	<c:if test="${endPage<totalpage }">
                        <button class="cheflist_nextBtn" endpage="${endPage}" chefname="${name }"><i class="fa fa-long-arrow-right"></i></button>
                    	</c:if>
                    </div>
                        
                       
             </div>
         </div>
    </section>
    <!-- Blog Section End -->
