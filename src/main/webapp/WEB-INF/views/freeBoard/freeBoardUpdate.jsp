<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/freeBoard.css">
<article>
<div>
		<a href="<%=request.getContextPath()%>/free/freeBoardList.do">
		<img id="freeLogo" src="<%= request.getContextPath() %>/resources/images/freeboard3.png"></a>
	</div> 
	
	<form id="fdf" name="form" method="post" action="freeBoardUpdate.do">
	<input type="hidden" value="${freeBoardVO.freeboard_posting_no}" name="freeboard_posting_no">
		<table class="table .table-condensed" id="bwt">
			<tr>
				<th>제목</th>
			    <td>${freeBoardVO.freeboard_title }</td>
			</tr>
  			<tr> 
			    <th>작성날짜</th>
   				<td>${freeBoardVO.freeboard_wridate }</td>
   				</tr>
   				<tr>
   				<th>작성자</th>
   				<td>${freeBoardVO.mem_nick }</td>
   				
  			</tr>
			<tr>
	  			<th>내용</th>
	   			<td>
	   			<textarea rows="10" cols="100" maxlength="4000" name="freeboard_cont">${freeBoardVO.freeboard_cont }</textarea></td>
	   			<%-- <input type="text" size=""value="${freeBoardVO.freeboard_cont }"> --%>
  			</tr>
		</table>
		<table>
		<tr>
		</tr>
	</table>
			<div id="divdiv">
				<input class="btn" type="submit" value="수정" >
				<input class="btn" type="reset" value="수정취소" onclick="javascript:history.back()"> 
				<input class="btn" type="button" value="메인" onclick="location.href='<%=request.getContextPath()%>/index'">
			</div>
			</form>
</article>