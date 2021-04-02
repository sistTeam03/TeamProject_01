<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>

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
                        
                        <a href="#" class="primary-btn" style="background-color: lightred;margin:0px auto;">찜하기 28</a>&nbsp;&nbsp;
    
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__text">
                        <h3>${vo.title }</h3>
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
                        <p>${vo.info }</p>

                        <ul>
                            <li><b>양</b> <span>${vo.info1 }</span></li>
                            <li><b>소요시간</b> <span>${vo.info2 }</span></li>
                            <li><b>난이도</b> <span>${vo.info3 }</span></li>
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
                        <div class="tab-content">
                            <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                <div class="product__details__tab__desc">  
                                <c:forEach var="a" begin="0" end="${length }" >
                                
                                	<c:forEach var="i" varStatus="s" items="${ poslist}">
                                		<c:if test="${s.index==a }">
                                			<span><img src="${i }" style="margin:30px"></span><br>
                                		</c:if>
                                	</c:forEach>
                                	
                                	<c:forEach var="i" varStatus="s" items="${ conlist}">
                                		<c:if test="${s.index==a }">
                                			<span>${i }</span><br>
                                		</c:if>
                                	</c:forEach>
                                	
                                </c:forEach>
                                
                                <ul class="nav nav-tabs" role="tablist">
                            <li class="nav-item">
                            </li>
                        </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Product Details Section End -->

</body>


</html>