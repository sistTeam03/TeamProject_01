<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    
	<!-- Contact Form Begin -->
    <div class="contact-form spad">
        <div class="container">
            <div class="wrapper row3 mypage_row">
                <div class="col-lg-12">
                    <div class="contact__form__title">
                        <h2 class="sectiontitle">????????????</h2>
                    </div>
                </div>
            </div>
            
    <!-- <div style="overflow-y:auto;margin:0px auto"> -->
    <div>
      <form method=post action="../boardreply/insert_ok.do">
                <div class="row">
                    <div class="col-lg-6">
                        <input type="text" id="id" placeholder="??????" name="name" class="input-sm">
                    </div>
                    <div class="col-lg-6">
                        <input type="password" id="pwd" placeholder="????????????" name="pwd" class="input-sm">
                    </div>
                    <div class="col-lg-12">
                        <input type="text" id="subject" placeholder="??????" name="subject" class="input-sm text-left">
                    </div>
                    <div class="col-lg-12 text-center">
                        <textarea placeholder="??????" name="content"></textarea>
                        <button type="submit" class="site-btn">??????</button>
                          &nbsp;
                        <button type="button" onclick="javascript:history.back()"
                         class="site-btn">??????</button>
                    </div>
                </div>
            </form>
          </div>
      <%-- <table class="table">
        <tr>
          <th width=20% class="text-right">??????</th>
          <td width=80%>
            <input type=text name=name size=15 class="input-sm">  size??? width
          </td>
        </tr>
        <tr>
          <th width=20% class="text-right">??????</th>
          <td width=80%>
            <input type=text name=subject size=50 class="input-sm">
          </td>
        </tr>
        <tr>
          <th width=20% class="text-right">??????</th>
          <td width=80%>
            <textarea rows="10" cols="52" name=content></textarea>
          </td>
        </tr>
        <tr>
          <th width=20% class="text-right">????????????</th>
          <td width=80%>
            <input type=password name=pwd size=10 class="input-sm">
          </td>
        </tr>
        <tr>
          <td colspan="2" class="text-center">
            <input type=submit value="??????" class="btn btn-sm btn-danger">
            <input type=button value="??????" onclick="javascript:history.back()"
            								  =========== ??? ?????? ???
             class="btn btn-sm btn-success">
          </td>
        </tr>
      </table> --%>
      </form>
    </div>
  </div>
</body>
</html>