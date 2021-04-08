<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#userListTable th {
	font-weight:normal;
	font-size:small;
	padding:0;
    position: sticky;
    top: 0px;
    background-color: white !important;
}
.sidebar__item li:hover a {
	background: #b9cf7c;
	border-color: #b9cf7c;
	color:white;
	font-weight: bold;
		
}
.sidebar__item__active a
{
	background: #b9cf7c;
	border-color: #b9cf7c;
	color:white !important;
	font-weight: bold;
}
.table th
{
	text-align:center;
	padding: 0;
}
a{
	color: black;
	text-decoration: none; !important
}
a:hover{
	color: black;
	text-decoration: none; !important
}
</style>
</head>
<body>
    <section class="product spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-5">
                    <div class="sidebar">
                        <div class="sidebar__item">
                            <h4>마이페이지</h4>
                            <ul>
                                <li class="sidebar__item__active"><a href="#" >나의 정보</a></li>
                                <li><a href="#">나의 활동</a></li>
                            
                            </ul>
                        </div>
                    </div>
                </div>
                
      
                <!-- ##############내 정보############# -->
                <div class="col-lg-9 col-md-7">
                
                
                 <div class="row">
	                 <div class="section-title product__discount__title">
	                           <h2>내 정보</h2>
	                 </div>
	                 <table class="table">
	                 	<tr>
	                 		<th width="20%">사진</th>
	                 		<th width="60%">닉네임</th>
	                 		<th width="20%">회원등급</th>
	                 	</tr>
	                 	
	                 	<tr>
	                 		<td class="text-center"><img src="https://recipe1.ezmember.co.kr/cache/rpf/2017/12/06/c3e305ae9ddd252fb21ef0f02f5dd0d81.de9e26210e79e8c2fa5707df5f84c55d" 
	                 		style="height: 90px; width:90px; border-radius: 100px"></td>
	                 		<td>${sessionScope.name}</td>
	                 		<td class="text-center">${sessionScope.admin=='Y'?"관리자":"일반사용자" }</td>
	                 	</tr>
	                 </table>
                        
                           
                 </div>
                <!--   <div class="text-right">${sessionScope.name}(${sessionScope.admin=='y'?"관리자":"일반사용자" })님 로그인중입니다</div> -->
                 <!-- ##############찜 목록############# -->
                
                
                
                    <div class="product__discount">
                        <div class="section-title product__discount__title">
                            <h2>찜목록</h2>
                        </div>
                   
                        <!-- 찜목록 테이블 -->
                         <div class="row" style="height: 600px;  overflow-y:auto ">
                	<div class="col-lg-12">
                    <div class="shoping__cart__table">
                        <table id="userListTable">
                            <thead>
                                <tr>
                                    <th width="20%"></th>
                                    <th width="60%">제목</th>
                                    <th width="20%">쉐프명</th>
                                </tr>
                            </thead>
                            <tbody >
                            <!-- 데이터 for -->
                            	<c:forEach var="vo" items="${dList }" varStatus="s">
                                <tr>
                                    <td>
                                    <a href="../recipe/recipe_detail.do?no=${vo.no }">
                                        <img src="${vo.poster }" alt=""><!-- 요리 썸네일 이미지 -->
                                    </a>
                                    </td>
                                    <td>
                                    <a href="../recipe/recipe_detail.do?no=${vo.no }">
                                     ${vo.title }
                                     </a>
                                    </td>
                                    <td>
                                     ${vo.chef }
                                    </td>
                                    <td class="shoping__cart__item__close">
                                        <span class="icon_close"></span><!-- 비고버튼 취소하기 기능 넣기 -->
                                    </td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
                <div style="height: 20px"></div>
                 
                    </div>
                 
                </div>
            </div>
        </div>
    </section>
</body>
</html>