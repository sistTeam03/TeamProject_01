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
                        <h2 class="sectiontitle">문의 내용</h2>
                        <div align="right">
                          <a href="../board/qnaReply.do" class="btn btn-sm btn-danger">답변</a>
						</div>
                    </div>
                </div>
            </div>

<!--     <div style="overflow-y:auto;margin:0px auto"> -->
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
        <tr>
          <td colspan="6" class="text-left" valign="top" height="200">
            <pre style="white-space: pre-wrap;border:none;">${vo.content }</pre>
          </td>
        </tr>
        <tr>
          <td class="text-right" colspan="6">
            <ul class="inline">
              <c:if test="${sessionScope.id!=null && sessionScope.admin=='y' }">
                                           <%-- admin일 때만 답변 쓸 수 있게 보이게 함 --%>
                <c:if test="${bCheck==false }">  <!-- 답변이 이미 적혀져 있을 땐 안보이게 함 -->
                  <a href="../boardreply/reply.do?no=${vo.no }" class="btn btn-sm btn-danger">답변</a>
                </c:if>
              </c:if>
              <a href="../boardreply/update.do?no=${vo.no }" class="btn btn-sm btn-success">수정</a>
              <a href="../boardreply/delete.do" class="btn btn-sm btn-info">삭제</a>
              <a href="../boardreply/list.do" class="btn btn-sm btn-warning">목록</a>
            </ul>
          </td>
        </tr>
      </table>
    </div>
  </div>
</body>
</html>