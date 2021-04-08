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
                        <h4 style="color: white;font-family: cursive;">공지사항 내용을 확인해주세요</h4>
                        <figure>
				          <header class="heading" style="color:white"> <span style="color:yellow;font-weight:bold;"></span></header>
				        </figure>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <div class="wrapper row3 mypage_row">
	  <h2 class="sectiontitle"style="margin-top:30px;margin-bottom: 30px;">공지내용</h2>
	  <div style="height: 500px;width:750px;overflow-y:auto;margin:0px auto">
	    <table class="table">
	     <tr>
	      <th width=20% class="text-center">번호</th>
	      <td width=80% class="text-center">${vo.no }</td>
	     </tr>
	     <tr>
	      <th width=20% class="text-center">조회수</th>
	      <td width=80% class="text-center">${vo.hit }</td>
	     </tr>
	     <tr>
	      <th width=20% class="text-center">제목</th>
	      <td colspan="5">${vo.subject }</td>
	      <tr>
	      <td colspan="4" class="text-left" valign="top" height="200">
	      <pre style="white-space: pre-wrap;border:none;">${vo.content }</pre>
	      </td></tr>
	     </tr>
	     <tr>
	       <td class="text-right" colspan="5">
	        <ul class="inline">
		        <a href="../board/notice.do" class="btn btn-sm btn-primary">목록</a>
	        </ul>
	       </td>
	     </tr>
	    </table>
	  </div>
	</div>
    
</body>
</html>