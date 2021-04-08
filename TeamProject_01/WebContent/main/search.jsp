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
				<section class="product spad">
        <div class="container">
            <div class="row">
                
                <div class="col-lg-9 col-md-7">
                    
                    <div class="filter__item">
                        <div class="row" >
                        <div class="col-lg-8 col-md-7"></div>
                            <div class="col-lg-4 col-md-5" id="sort_tab">
                               
                            </div>
                        </div>
                    
        			 <div class="row">
                       <c:forEach var="lvo" items="${sList }">
                        <div class="col-lg-3 col-md-5 col-sm-5">
                            <div class="product__item">             
                                <div class="product__item__pic set-bg list_img" data-setbg="${lvo.poster }" style="border-radius: 10px;" list_link="../recipe/detail_before.do?no=${lvo.no }">
                                    
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
                       <a href="../main/search.do?page=${startPage-10}&?msg=${msg}"><i class="fa fa-long-arrow-left"></i></a>
                        </c:if>
                        <c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" >
                        	<a href="../main/search.do?page=${i }&?msg=${msg}">${i }</a>
                      	</c:forEach>
                      	<c:if test="${endPage<totalpage }">
                        <a href="../main/search.do?page=${endPage+10}&?msg=${msg}"><i class="fa fa-long-arrow-right"></i></a>
                    	</c:if>
                    </div>
                </div>
            </div>
       
        </div>
    </section>
</body>
</html>