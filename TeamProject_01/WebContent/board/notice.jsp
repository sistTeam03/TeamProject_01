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
                        <h2>공지사항</h2>
                        <figure>
				          <header class="heading" style="color:white"> <span style="color:yellow;font-weight:bold;"></span></header>
				        </figure>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    
    <!-- ------------------------------------------------------------------------------- -->
    
     <section class="blog-details spad">
       
               <div class="container">
             
                    <div class="blog__details__content">
                    	
                        <div class="row">
                        <c:if test="${sessionScope.sesson_id=='admin' }">
                        <a href="../board/notice_write.do" style="float:left;margin-bottom: 10px;margin-left: 10px;">
                        	<div class="btn btn-sm btn-primary">공지사항 등록</div></a>
                        </c:if>
							  <table class="table table-hover" id="chef_table">
								<tr border=1>
									<th style="text-align:center;">글번호</th>
									<th style="text-align:center;">제목</th>
									<th style="text-align:center;">조회수</th>
								</tr>
								<c:forEach var="nvo" items="${nList }" varStatus="s">
									<tr>
									  <td>${nvo.no }</td>
									
									  <td style="text-align:left;"> <a href="../board/notice_detail.do?no=${nvo.no }">${nvo.subject }</a></td>
									 
									  <td>${nvo.hit }</td>
									</tr>
								</c:forEach> 
							</table>
						</div>
					</div>
				</div>
	</section>
							
</body>
</html>