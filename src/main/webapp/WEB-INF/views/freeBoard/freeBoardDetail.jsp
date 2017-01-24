<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<%-- <%@ include file="/admin/header.jsp"%> --%>

<article>
<h1>게시글 상세보기</h1> 
<form name="form" method="post">
<table id="list">
  <tr>
   <th>제목</th>
   <td>${freeBoardVO.freeboard_title }</td>
  </tr>
  
  <tr> 
   <th>작성날짜</th>
   <td>${freeBoardVO.freeboard_wridate }</td>
   <th>작성자</th>
   <td>${freeBoardVO.mem_nick }</td>
  </tr>
  
  <tr>
  <th>내용</th>
   <td>${freeBoardVO.freeboard_cont }</td>
  </tr>
   
</table>
<!--[8] 수정 버튼이 눌리면 상품 수정 페이지로 이동하되 현재 페이지와 상품 일련번호 값을 전달해 준다. --> 
<input class="btn"  type="button" value="수정" 
	onClick="location.href='/world/free/freeBoardUpdateForm.do?freeboard_posting_no=${freeBoardVO.freeboard_posting_no}'">
<input class="btn"  type="button" value="삭제" 
	onClick="location.href='/world/free/freeBoardDelete.do?freeboard_posting_no=${freeBoardVO.freeboard_posting_no}'">
<!--[9] 목록 버튼이 눌리면 상품 리스트 페이지로 이동하되 현재 페이지를 전달해 준다. --> 
<input class="btn"  type="button" value="목록" onclick="location.href='<%=request.getContextPath()%>/free/freeBoardList.do'">         
</form>
</article>
<%-- <%@ include file="/admin/footer.jsp"%> --%>
</body>
</html>