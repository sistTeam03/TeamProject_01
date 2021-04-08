<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<style type="text/css">
.mypage_row{
  margin: 0px auto;
  width: 960px;
}
</style>
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
<div class="contact-form spad">
        <div class="container">
            <div class="wrapper row3 mypage_row">
                <div class="col-lg-12">
                    <div class="contact__form__title">
                        <h2 class="sectiontitle">답변하기</h2>
                    </div>
                </div>
            </div>
            

    <div class="row" style="margin:0px auto">
      <form method=post action="../boardreply/reply_ok.do">
      <table class="table">
        <tr class="col-lg-6">
          <th width=20% class="text-right">이름</th>
          <td width=80%>
            <input type=text name=name class="input-sm" value="관리자" readonly="readonly">
            <input type=hidden name=no value="${no }">
            <input type=hidden name=group_id value="${group_id }">
          </td>
        </tr>
        <tr class="col-lg-6">
          <th width=20% class="text-right">비밀번호</th>
          <td width=80%>
            <input type=password name=pwd size=10 class="input-sm">
          </td>
        </tr>
        <tr class="col-lg-6">
          <th width=20% class="text-right">제목</th>
          <td width=80%>
            <input type=text name=subject class="input-sm">
          </td>
        </tr>
        <tr class="col-lg-12">
          <th width=20% class="text-right">내용</th>
          <td width=80%>
            <textarea rows="10" name=content></textarea>
          </td>
        </tr>
        <tr>
          <td colspan="12" class="text-center">
            <input type=submit value="답변" class="btn btn-sm btn-danger">
            <input type=button value="취소" onclick="javascript:history.back()"
             class="btn btn-sm btn-success">
          </td>
        </tr>
      </table>
      </form>
    </div>
  </div>
</body>
</html>