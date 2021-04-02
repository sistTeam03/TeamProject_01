<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<title>Ogani | Template</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <!-- Blog Details Hero Begin -->
    <section class="blog-details-hero set-bg" data-setbg="../img/blog/details/details-hero.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="blog__details__hero__text">
                        <h2>쉐프 랭킹</h2>
                        <figure>
				          <header class="heading" style="color:white">총 <span style="color:yellow;font-weight:bold;"><fmt:formatNumber value="${count }" pattern="0,000"/></span>명의 쉐프</header>
				        </figure>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Blog Details Hero End -->

    <!-- Blog Details Section Begin -->
    <section class="blog-details spad">
               <div class="container">
                    <div class="blog__details__content">
                        <div class="row">
							<table class="table table-hover">
								<thead>
									<tr style="font-size: 16px;text-weight:bold">  
									  <th style="text-align:center;width:10%">순위</th>
									  <th style="text-align:center;width:20%"></th>
									  <th style="text-align:left;width:25%">쉐프명</th>
									  <th style="text-align:center;width:10%">레시피</th>
									  <th style="text-align:center;width:10%">소식 받기</th>
									  <th style="text-align:center;width:15%">조회수</th>
									  <th style="text-align:center;width:10%">팔로워</th>
									 </tr>
								</thead>
								<tbody>
								  <c:forEach var="vo" items="${cList }">
								    <tr height=100px>
								    <%-- private int id, ranking;
									     private String chef_name, chef_img, cooking_count, cooking_clip, hit, follower; --%>
										<td width=10% class=rank style="text-align:center;vertical-align: middle;font-weight:bold;font-size:18px;color:orange">${vo.ranking }</td>
										<td width=20% style="text-align:center;vertical-align: middle;"><a href="#"><img src="${vo.chef_img }" width=80px height=80px></a></td>
										<td width=25% style="text-align: left;vertical-align: middle;font-size: 18px;font-weight:bold;" ><a href="#">${vo.chef_name }</a></td>
										<td width=10% style="text-align:center;vertical-align: middle;">${vo.cooking_count }개</td>
										<td width=10% style="text-align:center;vertical-align: middle;">${vo.cooking_clip }명</td>
										<td width=15% style="text-align:center;vertical-align: middle;">${vo.hit }회</td>
										<td width=10% style="text-align:center;vertical-align: middle;">${vo.follower }명</td>
								    </tr>
								  </c:forEach>
								</tbody>
							</table>  
                        </div>
                    </div>
                 <div class=row style="margin: 0px auto;">
                       	 <div  style="margin: 0px auto;">
                       	 	<ul class="pagination">
					          <c:if test="${startPage>1 }">
					            <li><a href="chef.do?page=${startPage-1 }">&laquo; 이전</a></li>
					          </c:if>
					            <c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
					              <c:if test="${i==curpage }">
					                <c:set var="type" value="class=current"/>
					              </c:if>
					              <c:if test="${i!=curpage }">
					                <c:set var="type" value=""/>
					              </c:if>
					              <li ${type }><a href="chef.do?page=${i }">${i }</a></li>
					            </c:forEach>
					          <c:if test="${endPage<totalpage }">   <!-- 다음을 눌렀을 때의 첫번째 번호 -->
					            <li><a href="chef.do?page=${endPage+1 }">다음 &raquo;</a></li>
					          </c:if>
					        </ul>
					      </div>
					    </div>
                    <!-- <div class=row style="margin: 0px auto;">
                       	 <div  style="margin: 0px auto;">
                       	 	<ul class="pagination">
								<li class="active"><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
							</ul> 
                       	 </div>
                       </div>   -->  
                </div>
    </section>
    <!-- Blog Details Section End -->




</body>

</html>