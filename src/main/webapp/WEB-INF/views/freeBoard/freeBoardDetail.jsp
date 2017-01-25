
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<%-- <%@ include file="/admin/header.jsp"%> --%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/freeBoard.css">
<article>
<div>
		<a href="<%=request.getContextPath()%>/free/freeBoardList.do"><img id="freeLogo" src="<%= request.getContextPath() %>/resources/images/freeboard.png"></a>
	</div> 
<!-- <h1>게시글 상세보기</h1>  -->
<form name="form" method="post">
<table class="table table-condensed" id="bdt">
  <tr style="background-color: #8bdb69">
   <th>SUBJECT</th>
   <td>${freeBoardVO.freeboard_title }</td>
   <td></td>
   <td></td>
   <td></td>
   <td></td>
   <td style="float:right;">추천 비추천</td>
  </tr>
  
  <tr> 
   <th>NAME</th>
   <td style="color:#a31313">(Level)${freeBoardVO.mem_nick }(POINT)</td>
   <td></td>
   <td></td>
   <td></td>
   <td></td>
   <td style="float:right;">${freeBoardVO.freeboard_wridate }</td>
   <td style="float:right;">DATE : </td>
  </tr>
  
  <tr>
  <th>CONTENT</th>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  </tr>
  <tr>
 
    <td colspan="11">${freeBoardVO.freeboard_cont }</td>

    
  </tr> 
   
</table>

<!--[8] 수정 버튼이 눌리면 상품 수정 페이지로 이동하되 현재 페이지와 상품 일련번호 값을 전달해 준다. --> 
</article>
<div id="btn">
<input class="btn"  type="button" value="수정" 
   onClick="location.href='/world/free/freeBoardUpdateForm.do?freeboard_posting_no=${freeBoardVO.freeboard_posting_no}'">
<input class="btn"  type="button" value="삭제" 
   onClick="location.href='/world/free/deleteFreeBoard.do?freeboard_posting_no=${freeBoardVO.freeboard_posting_no}'">
<!--[9] 목록 버튼이 눌리면 상품 리스트 페이지로 이동하되 현재 페이지를 전달해 준다. --> 
<input class="btn"  type="button" value="목록" onclick="location.href='<%=request.getContextPath()%>/free/freeBoardList.do'">  </form>
</div>
<%-- <%@ include file="/admin/footer.jsp"%> --%>
</body>
</html>
