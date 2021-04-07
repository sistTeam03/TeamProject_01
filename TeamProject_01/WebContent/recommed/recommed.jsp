<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#img_list{
	position: relative;
    padding-right: 15px;
    padding-left: 15px;
    display: block;
    width: 100%;
    border-radius: 31px;
    height: 13em;
	
}
</style>
</head>
<body>
	    <section class="product spad">
        <div class="container" style="margin-left: 33em;">
           	 	<div class="row" style="margin: 0px auto;">
           	 	<h1 >관심 분야 저장</h1>
           	 	
           	 	<div class="col-lg-9 col-md-7">
                    
                    <div class="filter__item">
                        <div class="row" >
                        <div class="col-lg-8 col-md-7"></div>
                            <div class="col-lg-4 col-md-5" id="sort_tab">
                                
                            </div>
                        </div>
                    
        			 <div class="row">
                       <c:forEach var="lvo" items="${list }">
                        <div class="col-lg-3 col-md-4 col-sm-5">
                            <div class="product__item">             
                                <div id="imagebox"><img src="${lvo.poster }" id="img_list"></div>
                               
                                <div class="product__item__text">
                                    <h6><a href="../recom/recomlist.do?no=${lvo.no }" >${lvo.title }</a></h6>
                                    
                                </div>
                            </div>
                        </div>
                       </c:forEach>
                       </div>
                    </div>
                    
                </div>
            	</div>
            </div>
        </section>
</body>
</html>