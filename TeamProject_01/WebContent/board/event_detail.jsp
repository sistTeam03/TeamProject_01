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
<section class="blog-details-hero set-bg" data-setbg="../img/blog/details/details-hero.jpg">
<div class="contact-form spad" style="margin:0px auto;">
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
                        <h2>이벤트 게시판</h2>
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
    <div style="height:30px;"></div>
	  <div style="height: 500px;width:750px;overflow-y:auto;margin:0px auto">
	    <table class="table">
	     <tr>
	      <th width=20% class="text-center">번호</th>
	      <td width=30% class="text-center">${vo.no }</td>
	      <th width=20% class="text-center">작성일</th>
	      <td width=30% class="text-center">${vo.regdate }</td>
	     </tr>
	     <tr>
	      <th width=20% class="text-center">이름</th>
	      <td width=30% class="text-center">${vo.name }</td>
	      <th width=20% class="text-center">조회수</th>
	      <td width=30% class="text-center">${vo.hit }</td>
	     </tr>
	     <tr>
	      <th width=20% class="text-center">제목</th>
	      <td colspan="3">${vo.subject }</td>
	     </tr>
	     <c:if test="${vo.filesize>0 }">
		     <tr>
		      <th width=20% class="text-center">첨부파일</th>
		      <td colspan="3"><a href="../eboard/download.do?fn=${vo.filename }">${vo.filename }</a>(${vo.filesize }Bytes)</td>
		     </tr>
	     </c:if>
	     <tr>
	      <td colspan="4" class="text-left" valign="top" height="200">
	      <pre style="white-space: pre-wrap;border:none;">${vo.content }</pre>
	      </td>
	     </tr>
	     <tr>
	       <td class="text-right" colspan="4">
	        <ul class="inline">
		        <a href="../board/eventboard.do" class="btn btn-sm btn-warning">목록</a>
	        </ul>
	       </td>
	     </tr>
	    </table>
	  </div>
	</div>
	
</body>
</html>