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
 <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
 <script type="text/javascript">
 $(function(){
	let admin=$('#test').attr('admin');
	console.log("관리자:"+admin);
 });
 
 </script>
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
                          <c:if test="${sessionScope.admin=='Y' }">
				       		<a href="../boardreply/reply.do?no=${vo.no }" class="btn btn-sm btn-danger">답변</a>
				       	</c:if>
						</div>
                    </div>
                </div>
            </div>

<!--     <div style="overflow-y:auto;margin:0px auto"> -->
      <table class="table" id="test"> <%-- admin="${sessionScope.admin } --%>
        <tr>
          <th width=20% class="text-center">번호</th>
          <td width=30% class="text-center">${vo.no }</td>
          <th width=20% class="text-center">작성일</th>
          <td width=30% class="text-center">${vo.regdate }</td>
        </tr>
        <tr>
          <th width=20% class="text-center">이름</th>
          <td width=30% class="text-center">관리자</td>
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
       </table>
       <div class="text-right">
       	
		  <a href="../boardreply/update.do?no=${vo.no }" class="btn btn-sm btn-success">수정</a>
          <a href="../boardreply/delete.do?no=${vo.no }" class="btn btn-sm btn-info">삭제</a>
          <a href="../boardreply/list.do" class="btn btn-sm btn-warning">목록</a>
		</div>
      
    </div>
  </div>
</body>
</html>