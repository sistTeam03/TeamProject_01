<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

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
	<div class="contact-form spad" style="margin:0px auto;">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="contact__form__title">
                        <h2>이벤트 참여</h2>
                    </div>
                </div>
            </div>
            <div class="wrapper row3 mypage_row">
	  <h2 class="sectiontitle">등록하기</h2>
	  <div style="height: 500px;width:750px;margin:0px auto">
	 
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
	      <td colspan="2" class="text-center">
	        <input type=submit value="등록" class="btn btn-sm btn-danger">
	        <input type=button value="취소" onclick="javascript:history.back()"
	         class="btn btn-sm btn-success"
	        >
	      </td> 
	    </tr>
	   </table>
	   </form>
	  </div>
	</div>
        </div>
    </div>
</body>
</html>