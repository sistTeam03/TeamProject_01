<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
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
                                <li><a href="../mypage/mypage.do" >나의 정보</a></li>
                            	<li  class="sidebar__item__active"><a href="#">나의 재료</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                
      
                <!-- ##############내 정보############# -->
                <div class="col-lg-9 col-md-7">
                
                
              <!--  <div class="row">
	                 <div class="section-title product__discount__title">
	                           <h2>재료 입력하기</h2>
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
	                 		<td>닉넴데이터</td>
	                 		<td class="text-center">일반사용자</td>
	                 	</tr>
	                 </table>
                        
                           
                 </div> -->
                
                 <!-- ##############찜 목록############# -->
                
                
                
                    <div class="product__discount">
                        <div class="section-title product__discount__title">
                            <h2>재료 목록</h2>
                        </div>
                        
                        <div class=page>
                        	<ul class="pagination">
                        	<c:if test="${ko==1 }">
							  <li class=active><a href="../mypage/ingrelist.do?kono=1">가</a></li>
							 </c:if>
							 <c:if test="${ko!=1 }">
							  <li><a href="../mypage/ingrelist.do?kono=1">가</a></li>
							</c:if>
							<c:if test="${ko==2 }">
							  <li class=active><a href="../mypage/ingrelist.do?kono=2">나</a></li>
							 </c:if>
							 <c:if test="${ko!=2 }">
							  <li><a href="../mypage/ingrelist.do?kono=2">나</a></li>
							</c:if>
							<c:if test="${ko==3 }">
							  <li class=active><a href="../mypage/ingrelist.do?kono=3">다</a></li>
							 </c:if>
							 <c:if test="${ko!=3 }">
							  <li><a href="../mypage/ingrelist.do?kono=3">다</a></li>
							</c:if>
							<c:if test="${ko==4 }">
							  <li class=active><a href="../mypage/ingrelist.do?kono=4">라</a></li>
							 </c:if>
							 <c:if test="${ko!=4 }">
							  <li><a href="../mypage/ingrelist.do?kono=4">라</a></li>
							</c:if>
							<c:if test="${ko==5 }">
							  <li class=active><a href="../mypage/ingrelist.do?kono=5">마</a></li>
							 </c:if>
							 <c:if test="${ko!=5 }">
							  <li><a href="../mypage/ingrelist.do?kono=5">마</a></li>
							</c:if>
							<c:if test="${ko==6 }">
							  <li class=active><a href="../mypage/ingrelist.do?kono=6">바</a></li>
							 </c:if>
							 <c:if test="${ko!=6 }">
							  <li><a href="../mypage/ingrelist.do?kono=6">바</a></li>
							</c:if>
							<c:if test="${ko==7 }">
							  <li class=active><a href="../mypage/ingrelist.do?kono=7">사</a></li>
							 </c:if>
							 <c:if test="${ko!=7 }">
							  <li><a href="../mypage/ingrelist.do?kono=7">사</a></li>
							</c:if>
							<c:if test="${ko==8 }">
							  <li class=active><a href="../mypage/ingrelist.do?kono=8">아</a></li>
							 </c:if>
							 <c:if test="${ko!=8 }">
							  <li><a href="../mypage/ingrelist.do?kono=8">아</a></li>
							</c:if>
							<c:if test="${ko==9 }">
							  <li class=active><a href="../mypage/ingrelist.do?kono=9">자</a></li>
							 </c:if>
							 <c:if test="${ko!=9 }">
							  <li><a href="../mypage/ingrelist.do?kono=9">자</a></li>
							</c:if>
							<c:if test="${ko==10 }">
							  <li class=active><a href="../mypage/ingrelist.do?kono=10">차</a></li>
							 </c:if>
							 <c:if test="${ko!=10 }">
							  <li><a href="../mypage/ingrelist.do?kono=10">차</a></li>
							</c:if>
							<c:if test="${ko==11 }">
							  <li class=active><a href="../mypage/ingrelist.do?kono=11">카</a></li>
							 </c:if>
							 <c:if test="${ko!=11 }">
							  <li><a href="../mypage/ingrelist.do?kono=11">카</a></li>
							</c:if>
							<c:if test="${ko==12 }">
							  <li class=active><a href="../mypage/ingrelist.do?kono=12">타</a></li>
							 </c:if>
							 <c:if test="${ko!=12 }">
							  <li><a href="../mypage/ingrelist.do?kono=12">타</a></li>
							</c:if>
							<c:if test="${ko==13 }">
							  <li class=active><a href="../mypage/ingrelist.do?kono=13">파</a></li>
							 </c:if>
							 <c:if test="${ko!=13 }">
							  <li><a href="../mypage/ingrelist.do?kono=13">파</a></li>
							</c:if>
							<c:if test="${ko==14 }">
							  <li class=active><a href="../mypage/ingrelist.do?kono=14">하</a></li>
							 </c:if>
							 <c:if test="${ko!=14 }">
							  <li><a href="../mypage/ingrelist.do?kono=14">하</a></li>
							</c:if>
							</ul>
                        </div>
                        <div class=row >
                        	<ul>
                        	<c:forEach var="vo" items="${ilist}"> 
                        		<c:if test="${vo.ingre_count==0}">
                        			<a href="../mypage/useringreinsert.do?ino=${vo.num }"><li class="btn btn-default">${vo.ingre }</li></a><!-- 추가버튼 -->
                        		</c:if>
                        		<c:if test="${vo.ingre_count==1}">
                        			<a href="../mypage/useringredelete.do?ino=${vo.num }&no=${vo.usr_num}"><li class="btn btn-success ">${vo.ingre }</li></a><!-- 삭제버튼 -->
                        		</c:if>
                        	</c:forEach>
                        	</ul>
                        </div>
                   

            			</div>
                <div style="height: 20px"></div>
                 
                    </div>
                 
                </div>
            </div>
    </section>
</body>

</html>