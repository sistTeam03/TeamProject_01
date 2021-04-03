<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#postfind{
	height:350px;
	overflow:auto;
}
#result_table tr:hover{
	background-color: #ddf2bc;
}
#result_table{
	cursor: pointer;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">


</script>
</head>
<body>
	<div id=postfind>
	<table id="result_table">
		<c:forEach var="vo" items="${list }">
			<tr id="post_tr">
				<td width="30%" id="zip">${vo.zipcode }</td>
				<td width="70%" id="addr">${vo.address }</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>