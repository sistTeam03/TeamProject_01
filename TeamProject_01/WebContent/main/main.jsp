
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">



<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ogani | Template</title> 

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="../css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="../css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="../css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="../css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="../css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="../css/style.css" type="text/css">
    
<style type="text/css">
 
.fa{
    	color:black;
    }
    
.fa-hover{
    	color:black;
    }
    
a.loginco{
    	color:black;
    }
    
 a.loginco-hover{
    	color:black;
    }
    #login_input{
	display: none;
}
#login_div{
	display: table;
	 
	width:10px;
	height:10px;
	position:absolute;
	top: 3em;
	left: 81.5em;
	float: right;
	
}
#login_div input{
	font-size: 12pt;
	 height: 2em;
	border: 0.5px solid #7fad39;
	border-radius: 15px;
	line-height: 23px;		
}
#login_div #login_go{
		width: 37px;
		height: 34px;
		color: #ffffff;
		border-radius: 35px;
		background-color:#7fad39;
		text-align: center;
		position: relative;
		right: -4.3em;
		top: -2.7em;
		opacity:0.9;
} 

    </style>
 <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
 <script type="text/javascript">
 let i=0;
 $(function(){
	 
	 $('#logout_logo').click(function(){//로그아웃
		 location.href="../member/logout.do";
	 });
 	$('#login_logo').click(function(){
 		if(i==0){
 			$('#login_input').show();
 			i=1;
 		}
 		else{
 			$('#login_input').hide();
 			
 			i=0;
 		}
 	});
 	$('#login_go').click(function(){
 		let id=$('#login_id').val();
 		let pwd=$('#login_pwd').val();
 		$.ajax({
			type:'post',
			url:'../member/login.do',
			data:{"id":id,"pwd":pwd},
			success:function(result)
			{
				let msg=result.trim();
				if(msg=="NOID")
				{		
					$('#login_id').val("");
					$('#login_pwd').val("")
					$('#login_id').attr("placeholder","ID가 존재하지 않습니다.");
					
					
				}
				else if(msg=="NOPWD")
				{	
					$('#login_pwd').val("");
					$('#login_pwd').attr("placeholder","패스워드가 다릅니다.");
				}else{
					
					location.href="../main/main.do";
					
				}
			}
			
		});
 		
 	});
 });
 </script>
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Humberger Begin -->
    <div class="humberger__menu__overlay"></div>
    <div class="humberger__menu__wrapper">
        <div class="humberger__menu__logo">
            <a href="../main/main.do"><img src="../img/logo1.png" alt=""></a>
        </div>
       
        <div class="humberger__menu__widget">
            
            <div class="header__top__right__auth">
                <a href="#"><i class="fa fa-user"></i> Login</a>
               
            </div>
        </div>
        <nav class="humberger__menu__nav mobile-menu">
            <ul>
                <li class="active"><a href="../main/main.do">홈</a></li>
                <li><a href="../recipe/recipe.jsp">레시피</a></li>
                <li><a href="../main/chef.do">쉐프</a>
                </li>
                <li><a href="../board/notice.do">커뮤니티</a>
                <ul class="header__menu__dropdown">
                        <li><a href="../board/notice.do">공지사항</a></li>
                        <li><a href="../admin/event.jsp">이벤트</a></li>
<!-- <<<<<<< HEAD -->
                        <li><a href="../boardreply/list.do">문의 게시판</a></li>
                       
<!-- >>>>>>> branch 'master' of https://github.com/sistTeam03/TeamProject_01.git -->
                    </ul>
                    </li>
                <li><a href="../mypage/mypage.jsp">마이페이지</a></li>
            </ul>
        </nav>
        <div id="mobile-menu-wrap"></div>
        <div class="header__top__right__social">
            <a href="#"><i class="fa fa-facebook"></i></a>
            <a href="#"><i class="fa fa-twitter"></i></a>
            <a href="#"><i class="fa fa-linkedin"></i></a>
            <a href="#"><i class="fa fa-pinterest-p"></i></a>
        </div>
        <div class="humberger__menu__contact">
            <ul>
                <li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
                
            </ul>
        </div>
    </div>
    <!-- Humberger End -->

    <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="header__logo">
                        <a href="../main/main.do"><img src="../img/logo1.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <nav class="header__menu">
                        <ul>
                            <li class="active"><a href="../main/main.do">홈</a></li>
                            <li><a href="../recipe/recipe.do">레시피</a></li>
                            <li><a href="../main/chef.do">쉐프</a> </li>
                            
                            <li><a href="../board/notice.do">커뮤니티</a>
                            	 <ul class="header__menu__dropdown">
                                    <li><a href="../board/notice.do">공지사항</a></li>
                                    <li><a href="../board/eventboard.do">이벤트</a></li>
                                    <li><a href="../board/board.do">자유게시판</a></li>
<!-- <<<<<<< HEAD
                                    <li><a href="../board/qna_board.do">문의 게시판</a></li>
======= -->
                                    <li><a href="../boardreply/list.do">문의 게시판</a></li>

<!-- >>>>>>> branch 'master' of https://github.com/sistTeam03/TeamProject_01.git -->
                                </ul>
                            </li>
                            <c:if test="${sessionScope.sesson_id!=null }"><!-- 로그인하면 -->
                            	<li><a href="../mypage/mypage.do">마이페이지</a></li>
                            </c:if>
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3">
                	 <div class="header__cart">
                        <ul>
                        	<li>
                        	<c:if test="${empty sesson_id}">
                            	<span class=loginco id="login_logo" style="cursor: pointer;"><i class="fa fa-user"></i>Login</span>
                            </c:if>
                            <c:if test="${not empty sesson_id}">
                            	<span class=loginco id="logout_logo" style="cursor: pointer;"><i class="fa fa-user"></i>Logout</span>
                             </c:if>	
                             <c:if test="${empty sesson_id}">
                            	<a href="../member/join.do" class=loginco><i class="fa fa-user"></i> SignUp</a>
                             </c:if>
                           </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
                <div class="col-lg-12">
                    <div class="hero__search">
                        <div class="hero__search__form">
                            <form action="../main/search.do"  method="get">
                                <div class="hero__search__categories">
                                    T i t l e
                                    <span class="arrow_carrot-down"></span>
                                </div>
                                <input type="text" placeholder="검색 내용을 입력해주세요" name="msg" autocomplete="off">
                                <button type="submit" class="site-btn" >SEARCH</button>
                            </form>
                        </div>
                    </div>
              
                </div>
        </div>
    </header>
    <!-- Header Section End -->
	
 	
	<!-- 본문 내용 인클루드 영역-->
	<jsp:include page="${main_jsp }"></jsp:include>

    <!-- Footer Section Begin -->
    <footer class="footer spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="footer__about">
                        <div class="footer__about__logo">
                            <a href="./index.html"><img src="../img/logo1.png" alt=""></a>
                        </div>
                        <ul>
                            <li>Address: 60-49 Road 11378 New York</li>
                            <li>Phone: +65 11.188.888</li>
                            <li>Email: hello@colorlib.com</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
                    <div class="footer__widget">
                        <h6>Useful Links</h6>
                        <ul>
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">About Our Shop</a></li>
                            <li><a href="#">Secure Shopping</a></li>
                            <li><a href="#">Delivery infomation</a></li>
                            <li><a href="#">Privacy Policy</a></li>
                            <li><a href="#">Our Sitemap</a></li>
                        </ul>
                        <ul>
                            <li><a href="#">Who We Are</a></li>
                            <li><a href="#">Our Services</a></li>
                            <li><a href="#">Projects</a></li>
                            <li><a href="#">Contact</a></li>
                            <li><a href="#">Innovation</a></li>
                            <li><a href="#">Testimonials</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-12">
                    <div class="footer__widget">
                        <h6>Join Our Newsletter Now</h6>
                        <p>Get E-mail updates about our latest shop and special offers.</p>
                        <form action="#">
                            <input type="text" placeholder="Enter your mail">
                            <button type="submit" class="site-btn">Subscribe</button>
                        </form>
                        <div class="footer__widget__social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-pinterest"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="footer__copyright">
                       <div class="footer__copyright__text"><p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p></div>
                        <div class="footer__copyright__payment"><img src="../img/payment-item.png" alt=""></div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="../js/jquery-3.3.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/jquery.nice-select.min.js"></script>
    <script src="../js/jquery-ui.min.js"></script>
    <script src="../js/jquery.slicknav.js"></script>
    <script src="../js/mixitup.min.js"></script>
    <script src="../js/owl.carousel.min.js"></script>
    <script src="../js/main.js"></script>



</body>

</html>