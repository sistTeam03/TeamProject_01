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
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<!-- <script type="text/javascript">
$(function(){
	$('.chef_tr').click(function(){
		$(this).next().show();
		let name=$(this).attr('data-name');
		console.log(name);
		$.ajax({
			type:'post',
			url:'../board/qna_board.do',
			data:{'name':name},
			success:function(result){
				$('.list_span').html(result);
				return;
			}
			
		})
		
	});
});
</script> -->
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
                        <!-- <h2>문의 게시판</h2> -->
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Blog Details Hero End -->
    
    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>문의 게시판</h2>
                        <div class="breadcrumb__option">
                            <!-- <a href="./index.html">Home</a>
                            <span>Checkout</span> -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->
    
    <!-- Checkout Section Begin -->
    <section class="checkout spad">
        <div class="container">
            <div class="row">
                <!-- <div class="col-lg-12">
                    <h6><span class="icon_tag_alt"></span> Have a coupon? <a href="#">Click here</a> to enter your code
                    </h6>
                </div> -->
            </div>
            <div class="checkout__form">
              <h4>문의하기</h4>
                <form action="#">
                    <div class="row">
                        <div class="col-lg-8 col-md-6">
                            <div class="row">
                              <c:forEach var="vo" items="${list }">
                                <table class="table table-borderless">
                                  <tr class="info">
                                    <th scope="col" class="text-center" width=10%>#</th>
                                    <th class="text-center" width=45%>제목</th>
                                    <th class="text-center" width=15%>이름</th>
                                    <th class="text-center" width=20%>작성일</th>
                                    <th class="text-center" width=10%>조회수</th> 
                                  </tr>
                                  <tr>
                                    <td class="text-center">
                                      <a href="#">${vo.no }</a>
                                    </td>
                                    <td class="text-center">
                                      <a href="#">${vo.title }</a>
                                    </td>
                                    <td class="text-center">
                                      <a href="#">${vo.name }</a>
                                    </td>
                                    <td class="text-center">
                                      <a href="#">${vo.regdate }</a>
                                    </td>
                                    <td class="text-center">
                                      <a href="#">${vo.hit }</a>
                                    </td>
                                  </tr>
                                </table>
                              </c:forEach>
                            </div>
                        </div>
                    <table class="table">
                      <tr>
                        <td class="text-right">
                          <a href="../recipe/chef_list.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-lg btn-danger">이전</a>
                            ${curpage } page / ${totalpage } pages
                          <a href="../recipe/chef_list.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-lg btn-info">다음</a>
                        </td>
                      <tr>
                    </table>
                    </div>
                </form>
        </div>
      </div>
    </section>
</body>
</html>