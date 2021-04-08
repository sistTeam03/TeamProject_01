<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Q & A</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
</head>
<body>    
    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="../img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
           
                <div class="col-lg-12">
                    <div class="blog__details__hero__text">
                        <h2>Q & A</h2>
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
  <%-- <%= application.getRealPath("/") %> --%>
  <!-- <section class="checkout spad">
  <div class="container">
    <div class="checkout__form wrapper row3 mypage_row">
      <h4 class="sectiontitle text-left">등록하기</h4>
      <form method=post action="../board/qnaInsert_ok.do"> -->
      
	<!-- Contact Form Begin -->
    <div class="contact-form spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="contact__form__title">
                        <h2>답변하기</h2>
                    </div>
                </div>
            </div>
            <form method=post action="../board/qnaReply_ok.do" id="frm" autocomplete="on">
                <div class="row">
                    <div class="col-lg-6">
                        <!-- <input type=text name=name class="input-sm" value="관리자" readonly="readonly"> -->
			            <input type=text name=name class="input-sm" id="name" placeholder="이름">
			            <input type=hidden name=no value="${vo.no }">
			            <input type=hidden name=group_id value="${vo.group_id }">
                    </div>
                    <div class="col-lg-6">
                        <input type="password" id="pwd" placeholder="비밀번호"  name="pwd">
                    </div>
                    <div class="col-lg-12">
                        <input type="text" id="subject" placeholder="제목" name="subject">
                    </div>
                    <div class="col-lg-12 text-center">
                        <textarea placeholder="내용" name="content"></textarea>
                        <input type="button" class="site-btn sendBtn" value="답변" >답변
                          &nbsp;
                        <input type="button" value="취소" onclick="javascript:history.back()"
                         class="site-btn">취소
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>