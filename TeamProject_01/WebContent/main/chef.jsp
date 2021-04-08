<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<title>Ogani | Template</title>

<style type="text/css">
#login_div {
    display: table;
    width: 10px;
    height: 10px;
    position: absolute;
    top: 3em;
    left: 90.2em;
    float: right;
}
#login_div input {
    font-size: 12pt;
    height: 23px;
    border: 0.5px solid #7fad39;
    border-radius: 15px;
    line-height: 23px;
    width: 11em;
    margin-top: 1px;
}
#login_div #login_go {
    width: 37px;
    height: 34px;
    color: #ffffff;
    border-radius: 35px;
    background-color: #7fad39;
    text-align: center;
    position: relative;
    right: -4.8em;
    top: -2.7em;
    opacity: 0.9;
}
.list_tr{
    height: 36em;
    display: none;
}
.cheflistBtn,.cheflist_nextBtn,.cheflist_beforeBtn{
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
	background-color:#f8fdf7;
	border-radius: 6px;

}
.cheflistBtn:hover{
	background-color: #7fad39;
	border-color: #7fad39;
	color: #ffffff;
}
</style>
 <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('.chef_tr').click(function(){
		$(this).next().show();
		let no=$(this).attr('page');
		$('.page1').css('background-color','#7fad39');
		let name=$(this).attr('data-name');
		$.ajax({
			type:'post',
			url:'../recipe/chefs_recipe.do',
			data:{'name':name},
			success:function(result){
				$('.list_span').html(result);
				return;
			}
			
		})
	});
	$(document).on("click",".cheflistBtn",function(){
		let page=$(this).text();
		let name=$('.chef_tr').attr('data-name');
				$.ajax({
			type:'post',
			url:'../recipe/chefs_recipe.do',
			data:{'name':name,'page':page},
			success:function(result){
				$('.list_span').html(result);
				return;
			}	
		});

	});//페이지 이동
		$(document).on("click",".cheflist_nextBtn",function(){
		let endpage=$('.cheflist_nextBtn').attr('endpage');
		let name=$(this).attr('chefname');
		page=Number(endpage)+1;
		
		$.ajax({
			type:'post',
			url:'../recipe/chefs_recipe.do',
			data:{'name':name,'page':page},
			success:function(result){
				$('.list_span').html(result);
				
				return;
			}	
		});
	});//페이지 증가
		$(document).on("click",".cheflist_beforeBtn",function(){
			let startpage=$('.cheflist_beforeBtn').attr('startpage');
			let name=$(this).attr('chefname');
			page=Number(startpage)-10;
			$.ajax({
				type:'post',
				url:'../recipe/chefs_recipe.do',
				data:{'name':name,'page':page},
				success:function(result){
					$('.list_span').html(result);
					return;
				}	
			});
		});//페이지 감소
		 /* 현재 페이지 작업 */
		 
	
	
});

</script>
</head>
<body>
    <!-- Blog Details Hero Begin -->
    <section class="blog-details-hero set-bg" data-setbg="../img/blog/details/details-hero.jpg">
        <div class="container">
            <div class="row">
            <div id="login_input">
	            <div id="login_div">
	            <input type="text" size=15 id="login_id" placeholder="ID" style="padding-left: 10px;" autocomplete="off">           
	            <input type="password" size=15 id="login_pwd" placeholder="비밀번호" style="padding-left: 10px;">
	           	<button id="login_go">go</button>
	           </div>
	        </div>
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
							<table class="table table-hover" id="chef_table">
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
								    <tr height=100px class="chef_tr"  data-name="${vo.chef_name }" page="1">
								    <%-- private int id, ranking;
									     private String chef_name, chef_img, cooking_count, cooking_clip, hit, follower; --%>
										<td width=10% class=rank 
										 style="text-align:center;vertical-align: middle;font-weight:bold;font-size:18px;color:orange">${vo.ranking }</td>
										<td width=20% style="text-align:center;vertical-align: middle;">
										    <img src="${vo.chef_img }" width=80px height=80px>
										 
										</td>
										<td width=25% style="text-align: left;vertical-align: middle;font-size: 18px;font-weight:bold;" >
										 ${vo.chef_name }
										</td>
										<td width=10% style="text-align:center;vertical-align: middle;">${vo.cooking_count }개</td>
										<td width=10% style="text-align:center;vertical-align: middle;">${vo.cooking_clip }명</td>
										<td width=15% style="text-align:center;vertical-align: middle;">${vo.hit }회</td>
										<td width=10% style="text-align:center;vertical-align: middle;">${vo.follower }명</td>
								    </tr>
								    <tr class="list_tr">
								    	<td colspan="7" >
								    	<span class="list_span"></span>
								    	</td>
								    </tr>
								  </c:forEach>
								</tbody>
								
							</table>  
                        </div>
                    </div>
                 <div class=product__pagination style="margin: 0px auto;padding-left: 22em;">
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
                </div>
    </section>
    <!-- Blog Details Section End -->




</body>

</html>