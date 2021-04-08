<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.mypage_row{
  margin: 0px auto;
  width: 960px;
}
</style>
</head>
<body>
  <div class="wrapper row3 mypage_row">
    <h2 class="sectiontitle">내용보기</h2>
    <div style="height:500px;width:750px;overflow-y:auto;margin:0px auto">
      <table class="table">
        <tr>
          <th width=20% class="text-center">번호</th>
          <td width=30% class="text-center">${vo.no }</td>
          <th width=20% class="text-center">작성일</th>
          <td width=30% class="text-center">${vo.regdate }</td>
        </tr>
        <tr>
          <th width=20% class="text-center">이름</th>
          <td width=30% class="text-center">${vo.name }</td>
          <th width=20% class="text-center">조회수</th>
          <td width=30% class="text-center">${vo.hit }</td>
        </tr>
        <tr>
          <th width=20% class="text-center">제목</th>
          <td colspan="3">${vo.subject }</td>
        </tr>
        <tr>
          <td colspan="4" class="text-left" valign="top" height="200">
            <pre style="white-space: pre-wrap;border:none;">${vo.content }</pre>
          </td>
        </tr>
        <tr>
          <td class="text-right" colspan="4">
            <ul class="inline">
              <c:if test="${sessionScope.id!=null && sessionScope.admin=='y' }">
                                           <%-- admin일 때만 답변 쓸 수 있게 보이게 함 --%>
                <c:if test="${bCheck==false }">  <!-- 답변이 이미 적혀져 있을 땐 안보이게 함 -->
                  <a href="../board/qnaReply.do?no=${vo.no }" class="btn btn-sm btn-danger">답변</a>
                </c:if>
              </c:if>
              <a href="../board/qnaInsert.do" class="btn btn-sm btn-success">수정</a>
              <a href="#" class="btn btn-sm btn-info">삭제</a>
              <a href="../board/qnaList.do" class="btn btn-sm btn-warning">목록</a>
            </ul>
          </td>
        </tr>
      </table>
    </div>
  </div>
</body>
</html>