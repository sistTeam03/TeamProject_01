<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>Insert title here</title>
<head>
<style type="text/css">
.checkout__input input{
	color:black;
}
</style>
</head>

<body>
  
    <!-- 위에 사진섹션 -->
    <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>회원가입</h2>
                        <div class="breadcrumb__option">
                            <a href="./index.html">Home</a>
                            <span>sign up</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- 사진섹션 여기까지 -->

    <!-- 회원가입 섹션 -->
    <section class="checkout spad">
        <div class="container">
   
            <div class="checkout__form">
                <h4>회원가입</h4>
                <form action="#">
                    <div class="row">
                        <div class="col-lg-12 col-md-12">
                            <div class="row">
                            	<!-- 아이디####################################### -->
                                <div class="col-lg-4">
                                    <div class="checkout__input">
                                        <p>ID<span>*</span></p>
                                       <input type="text" name="id" id="id" class="input-sm" style="float:left" readonly placeholder="아이디">
                                    </div>
                                </div>
                                <!-- 중복체크 버튼#######################################-->
                                <div class="col-lg-2">
                                    <div class="checkout__input">
                                        <p><span>&nbsp;</span></p>
                                       <input type="button" value="중복체크" class="btn btn-sm btn-danger" style="float:left" id="checkBtn" >
                                    </div>
                                </div>
                            </div>
                            <!-- password####################################### -->
                            <div class="row">
                            	<div class="col-lg-6">
		                            <div class="checkout__input">
		                                <p>Password<span>*</span></p>
		                                	<input type="password" name="pwd" id="pwd" class="input-sm"  style="float:left" placeholder="비밀번호 입력">
		                            		<input type="password" name="pwd" id="pwd1" class="input-sm"  style="float:left" placeholder="재입력">
		                            </div>
	                            </div>
	                        </div>
							<!-- 이메일 #######################################-->
							
							<div class="row">
                            <div class="col-lg-4">
                                <div class="checkout__input">
                                    <p>email<span>*</span></p>
                                   	<input type="text" size=45 name="email" id="email" class="input-sm" placeholder="test@organi.com" >
                                </div>
                            </div>
                            </div>
							
             				<!--생일 #######################################-->
                            <div class="row">
                              <div class="col-lg-6">
                                  <div class="checkout__input">
                                      <p>생년월일<span>*</span></p>
                                  <input type="date" size=20 name="birthday" >
                                  </div>
                              </div>
                            </div>
              				<!-- 주소 1우편번호2주소 3상세주소  #######################################-->
                            <div class="checkout__input">
                                <p>Address<span>*</span></p>
                                <input type="text" name="post" id="post" class="checkout__input__add col-lg-3" placeholder="우편번호(000-000)">
                             	<input type="button" value="우편번호 검색" class="btn btn-sm btn-danger col-lg-2" id="postBtn">
                                &nbsp;
                                <input type="text"  placeholder="주소" name="addr1" id="addr1"class="col-lg-7">
                                &nbsp;
                                <input type="text"  placeholder="상세주소" name="addr2" id="addr2"class="col-lg-7">
                            </div>
     
                            
                          	<!-- 닉네임 #######################################-->
                          	<div class="row">
                            <div class="col-lg-4">
                                <div class="checkout__input">
                                    <p>닉네임<span>*</span></p>
                                   <input type="text" name="id" id="id" class="input-sm" style="float:left" placeholder="사용하실 닉네임">
                                </div>
                            </div>
                            </div>
                            
                            <!-- 전화번호####################################### -->
                            
                            <div class="row">
                                <div class="col-lg-2">
                                    <div class="checkout__input">
                                        <p>TEL</p>
                                       	<input type="text" size=5 name="tel1" id="tel1" class="input-sm" readonly value="010" style="float: left">
                                    </div>
                                    </div>
                                    <div class="col-lg-4">
                                    <div class="checkout__input">
                                        <p>&nbsp;</p>
                                       	<input type="text" size=10 name="tel2" id="tel2" class="input-sm" style="float: left">
                                    </div>
  										
                                </div>
                            </div>
                            <!-- 핸드폰 번호####################################### -->
                            <div class="row">
                                <div class="col-lg-2">
                                    <div class="checkout__input">
                                        <p>Phone<span>*</span></p>
                                       	<input type="text" size=5 name="phone1" id="phone1" class="input-sm" readonly value="010" style="float: left">
                                    </div>
                                    </div>
                                    <div class="col-lg-4">
                                    <div class="checkout__input">
                                        <p>&nbsp;</p>
                                       	<input type="text" size=10 name="phone2" id="phone2" class="input-sm" style="float: left">
                                    </div>
                                </div>
                            </div>
               
                            
                            <div style="height: 30px"></div>
                            
                            <!-- 버튼####################################### -->
                            <div class="row">
	                           <div class="checkout__input col-lg-2">
	                            	<input type="submit" value="회원가입" class="btn btn-sm btn-success">
	                           </div>
	                           <div class="checkout__input col-lg-2">
	  								<input type="button" value="취소"class="btn btn-sm btn-success" onclick="javascript:history.back()">
	                           </div>
                      		</div>
                       </div>
				</div>
                </form>
            </div>
        </div>
    </section>
    <!-- 회원가입섹션 여기까지 -->



</body>

</html>