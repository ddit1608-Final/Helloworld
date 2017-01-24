<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<%-- <%@ include file="/admin/header.jsp"%> --%>

<article>
<h1>게시글 상세보기</h1> 
<form name="form" method="post">
<table id="list">
  <tr>
   <th>제목</th>
   <td>${freeboard_title }</td>
   <th>내용</th>
   <td>${freeboard_cont }</td>
   <th>작성날짜</th>
   <td>${freeboard_wridate }</td>
   
   
</table>
<!--[8] 수정 버튼이 눌리면 상품 수정 페이지로 이동하되 현재 페이지와 상품 일련번호 값을 전달해 준다. --> 
<input class="btn"  type="button" value="수정" onClick="go_mod('${tpage}','${productVO.pseq}')">
<!--[9] 목록 버튼이 눌리면 상품 리스트 페이지로 이동하되 현재 페이지를 전달해 준다. --> 
<input class="btn"  type="button" value="목록" onClick="go_list('${tpage}')">           
</form>
</article>
<%-- <%@ include file="/admin/footer.jsp"%> --%>
</body>
</html>