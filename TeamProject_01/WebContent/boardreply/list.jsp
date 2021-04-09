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
                            <a href="../index.jsp">Home</a>
                            <span>커뮤니티</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Blog Details Section Begin -->

      <div class="contact-form spad">
        <div class="container">
           <div class="row">
                <div class="col-lg-12">
                    <div class="contact__form__title">
                        <h2>문의 게시판</h2>
                        <div align="right">
                           <a href="../boardreply/insert.do" class="btn btn-sm btn-danger">등록</a>
						</div>
                    </div>
                </div>
            </div>
    
      <div class="blog__details__content">
                        <div class="row" style="height:560px;overflow-y:auto;">
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
					            <c:if test="${vo.group_tab==1 }">
					              &nbsp;&nbsp;
					              <img src="../img/reply.png" style="width:25px;height:22px">
					              <!-- <img src="../img/question.png" style="width:5.5%"> -->
					              <!-- <img src="../img/reply_icon.png"> -->
					            </c:if>
            <a href="../boardreply/detail.do?no=${vo.no }">${vo.subject }</a>
          </td>
					          <td class="text-center" width=15%>${vo.name }</td>
					          <td class="text-center" width=20%>${vo.regdate }</td>
					          <td class="text-center" width=10%>${vo.hit }</td>
					        </tr>
					        </c:forEach>
      </table>
      </div>
      <table class="table">
        <tr>
          <td class="text-center">
            <a href="../boardreply/list.do?page=${curpage>1?curpage-1:curpage }" class="site-btn">이전</a>
             &nbsp;&nbsp; ${curpage } page / ${totalpage } pages &nbsp;&nbsp;
            <a href="../boardreply/list.do?page=${curpage<totalpage?curpage+1:curpage }" class="site-btn">다음</a>
          </td>
        </tr>
      </table>
      </div>
    </div>
  </div>
</body>
</html>