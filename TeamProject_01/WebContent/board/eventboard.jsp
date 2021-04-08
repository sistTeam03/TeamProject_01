<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class="contact-form spad">
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
                        <h2 style="text-align: center;">이벤트 게시판</h2>
                        <figure>
				          <header class="heading" style="color:white"> <span style="color:yellow;font-weight:bold;"></span></header>
				        </figure>
                    </div>
                </div>
            </div>
        </div>
        </div>
    </section>
    
    
    
    <div class="wrapper row3 mypage_row">
	  <h2 class="sectiontitle">자료실</h2>
	  <div style="height: 500px;width:750px;overflow-y:auto;margin:0px auto">
	   <table class="table" style="float:left;">
	     <tr>
	      <td>
	       <a href="../board/event_insert.do" class="btn btn-sm btn-danger">등록</a>
	      </td>
	     </tr>
	   </table>
	   <table class="table">
	     <tr>
	      <th class="text-center" width=10%>번호</th>
	      <th class="text-center" width=45%>제목</th>
	      <th class="text-center" width=15%>이름</th>
	      <th class="text-center" width=20%>작성일</th>
	      <th class="text-center" width=10%>조회수</th>
	     </tr>
	     <c:forEach var="vo" items="${list }">
	       <tr>
		      <td class="text-center" width=10%>${vo.no }</td>
		      <td class="text-left" width=45%>
		        <a href="../board/event_detail.do?no=${vo.no }">${vo.subject }</a>
		      </td>
		      <td class="text-center" width=15%>${vo.name }</td>
		      <td class="text-center" width=20%>${vo.regdate }</td>
		      <td class="text-center" width=10%>${vo.hit }</td>
	     </tr>
	     </c:forEach>
	   </table>
	   
	  </div>
	</div>
    
    
    
    
</body>
</html>