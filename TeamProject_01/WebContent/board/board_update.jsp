<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
#login_div {
    display: table;
    width: 10px;
    height: 10px;
    position: absolute;
    top: 3em;
    left: 90.2em;
    float: right;
}
#login_div input {
    font-size: 12pt;
    height: 23px;
    border: 0.5px solid #7fad39;
    border-radius: 15px;
    line-height: 23px;
    width: 11em;
    margin-top: 1px;
}
#login_div #login_go {
    width: 37px;
    height: 34px;
    color: #ffffff;
    border-radius: 35px;
    background-color: #7fad39;
    text-align: center;
    position: relative;
    right: -4.8em;
    top: -2.7em;
    opacity: 0.9;
}
</style>
</head>
<body>
    <center>
     <h1>글쓰기</h1>
     <form method="post" action="../board/board_write.do">
     <table class="table_content" width=500>
       <tr>
         <th width=15% align=right>이름</th>
         <td width=85%>
           <input type=text name=name size=15 required>
         </td>
       </tr>
       <tr>
         <th width=15% align=right>제목</th>
         <td width=85%>
           <input type=text name=subject size=45 required>
         </td>
       </tr>
       <tr>
         <th width=15% align=right>내용</th>
         <td width=85%>
           <textarea rows="7" cols="55" name="content" required></textarea>
         </td>
       </tr>
       <tr>
         <th width=15% align=right>비밀번호</th>
         <td width=85%>
           <input type=password name=pwd size=10 required>
         </td>
       </tr>
       <tr>
         <td colspan="2" align=center>
          <input type=submit value="글쓰기">
          
         </td>
       </tr>
     </table>
     </form>
   </center>

</body>
</html>