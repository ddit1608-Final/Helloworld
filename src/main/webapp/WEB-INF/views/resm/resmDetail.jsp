<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<%-- <%@ include file="/admin/header.jsp"%> --%>

<article>
<h1>게시글 상세보기</h1> 
<form name="form" method="post">
<table id="list">
  <tr>
   <th>이메일</th>
   <td>${resmVO.mem_mail }</td>
  </tr>
   <tr>
  	<th>취미</th>
  	<td>${resmVO.resm_hob }</td>
  </tr>
  <tr>	
   <th>주민등록번호</th>
   <td>${resmVO.resm_regno }</td>
  </tr>
  <tr>
   <th>병역</th>
   <td>${resmVO.milt_code }</td>
  </tr>
  <tr>
   <th>취미</th>
   <td>${resmVO.resm_hob }</td>
  </tr>
  <tr>
   <th>특기</th>
   <td>${resmVO.resm_like }</td>
  </tr>
  <tr>
   <th>사진</th>
   <td>${resmVO.idpic_code }</td>
  </tr>
  <tr>
   <th>자격증</th>
   <td>${resmVO.lcse_code }</td>
  </tr>
  <tr>
   <th>학력</th>
   <td>${resmVO.acdmcr_code }</td>
  </tr>   
</table>
<!--[8] 수정 버튼이 눌리면 상품 수정 페이지로 이동하되 현재 페이지와 상품 일련번호 값을 전달해 준다. --> 
<input class="btn"  type="button" value="수정" 
	onClick="location.href='/world/resm/resmUpdateForm.do?resm_id=${resmVO.resm_id}'">
<input class="btn"  type="button" value="삭제" 
	onClick="location.href='/world/resm/resmDelete.do?resm_id=${resmVO.resm_id}'">
<!--[9] 목록 버튼이 눌리면 상품 리스트 페이지로 이동하되 현재 페이지를 전달해 준다. --> 
<input class="btn"  type="button" value="목록" onclick="location.href='<%=request.getContextPath()%>/resm/resmList.do'">         
</form>
</article>
<%-- <%@ include file="/admin/footer.jsp"%> --%>
</body>
</html>