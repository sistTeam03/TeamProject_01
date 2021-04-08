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
<section class="blog-details-hero set-bg" data-setbg="../img/blog/details/details-hero.jpg">
<div class="contact-form spad" style="margin:0px auto;"">
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
                        <h2 ">이벤트 게시판</h2>
                        <figure>
				          <header class="heading" style="color:white"> <span style="color:yellow;font-weight:bold;"></span></header>
				        </figure>
                    </div>
                </div>
            </div>
        </div>
        </div>
    </section>
	    <div class="contact-form spad">
        <div class="container">
        <div class="row">
                <div class="col-lg-12">
                    <div class="contact__form__title">
                        <h2>공지사항 등록</h2>
                    </div>
                </div>
            </div>
              <form method=post action="../board/event_insert_ok.do"
	     enctype="multipart/form-data">
	   <table class="table">
	    <tr>
	      <th width=20% class="text-right">이름</th>
	      <td width=80%>
	        <input type=text name=name size=15 class="input-sm">
	      </td>
	    </tr>
	    <tr>
	      <th width=20% class="text-right">제목</th>
	      <td width=80%>
	        <input type=text name=subject size=50 class="input-sm">
	      </td>
	    </tr>
	    <tr>
	      <th width=20% class="text-right">내용</th>
	      <td width=80%>
	        <textarea rows="10" cols="52" name=content></textarea>
	      </td>
	    </tr>
	    <tr>
	      <th width=20% class="text-right">첨부파일</th>
	      <td width=80%>
	        <input type=file name=upload size=20>
	      </td>
	    </tr>
	    <tr>
	      <th width=20% class="text-right">비밀번호</th>
	      <td width=80%>
	        <input type=password name=pwd size=10 class="input-sm">
	      </td>
	    </tr>
	    <tr>
	      
	    </tr>
	   </table>
	   <button type="submit" class="site-btn">등록</button>
	   </form>
            </div>
           </div>
</body>
</html>