<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	for(let i=0;i<10;i++){
		let str=$('#keyword'+i).text();
		let arr=str.split(',');
		$('#keyword'+i).text(arr[0]);
		$('#state'+i).text(arr[1]);
	}
	
	for(let j=0;j<10;j++){
		let no=$('#state'+j).text();
		console.log(no);
		if(no>0){
			$('#state'+j).text(no+"상승")
			$('#state'+j).css('color','red');
		}else if(no<0){
			$('#state'+j).text(no+"하락")
			$('#state'+j).css('color','#0080ff');
		}else if(no==0){
			$('#state'+j).text("-")
			$('#state'+j).css('color','black');
		} else{
			$('#state'+j).css('color','red');
		} 		
	}
	$('.keyword_tr').click(function(){
		let msg=$(this).children('.keyword_td').text();
		location.href="../main/search.do?msg="+msg;
	});
	$('#main_image').click(function(){
		let link=$(this).attr('list_link');
		location.href=link;
		
	})
	
	
})
</script>
<style type="text/css">
.keyword_tr{
    height: 2em;
    border-bottom: 0.5px dotted;
    border-left: 0.5px solid #00000059;
    border-right: 0.5px solid #00000059;

}
.keyword_tr:hover{
	background-color: #f6ffe9;
	cursor: pointer;
}
</style>
</head>
<body>
				<section class="product spad">
        <div class="container">
            <div class="row">
                 <div class="col-lg-3 col-md-5">
                 	<table class="top10" style="width: 17em;position: fixed;">
                 		<tr style="height: 3em;background-color: #ddf2bc;" >
                 			<th width="20%">순위</th>
                 			<th width="60%">검색어</th>
                 			<th width="20%">비고</th>
                 		</tr>
                 	<c:forEach var="key" items="${tList}" begin="0" end="9" varStatus="s">
                 				<tr class="keyword_tr" id="keyword_tr"${s.index }>
                 					<td>${s.index+1 }</td>
                 					<td id="keyword${s.index }" class="keyword_td">${key}</td>
                 					<td id="state${s.index }">      </td>
                 					
                 				</tr>
                 	</c:forEach>
                 	</table>
                 </div>
                <div class="col-lg-9 col-md-7">
                    
                    <div class="filter__item">
                        <div class="row" >
                        
                        <div class="col-lg-8 col-md-7"></div>
                            <div class="col-lg-4 col-md-5" id="sort_tab">
                               
                            </div>
                        </div>
                    
        			 <div class="row">
                       <c:forEach var="lvo" items="${sList }">
                        <div class="col-lg-3 col-md-5 col-sm-5">
                            <div class="product__item">             
                                <div class="product__item__pic set-bg list_img" data-setbg="${lvo.poster }" id="main_image" style="border-radius: 10px;cursor: pointer;" list_link="../recipe/detail_before.do?no=${lvo.no }">
                                    
                                </div>
                                <div class="product__item__text">
                                    <h6><a href="../recipe/detail_before.do?no=${lvo.no }">${lvo.title }</a></h6>
                                    
                                </div>
                            </div>
                        </div>
                       </c:forEach>
                       </div>
                    </div>
                    <div class="product__pagination">
                    	<c:if test="${startPage>1 }">
                       <a href="../main/search.do?page=${startPage-10}&?msg=${msg}"><i class="fa fa-long-arrow-left"></i></a>
                        </c:if>
                        <c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" >
                        	<a href="../main/search.do?page=${i }&?msg=${msg}">${i }</a>
                      	</c:forEach>
                      	<c:if test="${endPage<totalpage }">
                        <a href="../main/search.do?page=${endPage+10}&?msg=${msg}"><i class="fa fa-long-arrow-right"></i></a>
                    	</c:if>
                    </div>
                </div>
            </div>
       
        </div>
    </section>
</body>
</html>