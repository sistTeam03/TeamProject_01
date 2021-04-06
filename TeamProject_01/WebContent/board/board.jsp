<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
</style>
</head>
<body>
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
                        <h2>자유게시판</h2>
                        <figure>
				          <header class="heading" style="color:white"> <span style="color:yellow;font-weight:bold;"></span></header>
				        </figure>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    <!-- ----------------------------------------------------------------------------- -->
<section class="blog-details spad">
<table class="table_insert">
		<tr>
		  <td width=80px; style="background-color: pink;text-align: center;height:40px; size:15;vertical-align: middle;diplay:inline;">
		    <a href="../board/board_write.do">새글</a>
		  </td>
		</tr>
	</table>
<center>
	<div>
		
	</div>
	
	<div class="container" ">
		<div class="row">
		<table class="table table-hover">
			<tr height=80px  style="border-color: black; background-color: orange;vertical-align:middle;">
			  <th width=10% style="text-align:center">번호</th>  	
			  <th width=45% style="text-align:center">제목</th>
			  <th width=15% style="text-align:center">이름</th>
			  <th width=20% style="text-align:center">작성일</th>
			  <th width=10% style="text-align:center">조회수</th>	
			</tr>
			<c:forEach var="vo" items="${bList }">
				<tr>
				  <td style="text-align:center">${vo.no }</td>
				  <a href="#">
				  <td>${vo.subject }</td></a>
				  <td style="text-align:center">${vo.name }</td>
				  <td style="text-align:center">${vo.regdate }</td>
				  <td style="text-align:center">${vo.hit }</td>
				</tr>
			</c:forEach>
			</table>
		</div>	
	</div>
</center>	
</section>
<div class=row style="margin: 0px auto;">
                       	 <div  style="margin: 0px auto;">
                       	 	<ul class="pagination">
					          <c:if test="${startPage>1 }">
					            <li><a href="board.do?page=${startPage-1 }">&laquo; 이전</a></li>
					          </c:if>
					            <c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
					              <c:if test="${i==curpage }">
					                <c:set var="type" value="class=current"/>
					              </c:if>
					              <c:if test="${i!=curpage }">
					                <c:set var="type" value=""/>
					              </c:if>
					              <li ${type }><a href="board.do?page=${i }">${i }</a></li>
					            </c:forEach>
					          <c:if test="${endPage<totalpage }">   <!-- 다음을 눌렀을 때의 첫번째 번호 -->
					            <li><a href="board.do?page=${endPage+1 }">다음 &raquo;</a></li>
					          </c:if>
					        </ul>
					      </div>
					    </div>
</body>
</html>