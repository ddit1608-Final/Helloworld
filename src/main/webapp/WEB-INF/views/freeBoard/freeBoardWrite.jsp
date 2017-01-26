<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/freeBoard.css">
<article>
<div>
		<a href="<%=request.getContextPath()%>/free/freeBoardList.do"><img id="freeLogo" src="<%= request.getContextPath() %>/resources/images/freeboard.png"></a>
	</div> 
	
	<form name="form" method="post" action="freeBoardWrite.do">
			<!-- freeboard_posting_no,mem_mail,freeboard_title,freeboard_cont -->
		<table style="boader: 1px solid black;">
		<tr>
			<td>
			작성자:<label>${loginUser.mem_nick}</label><br>
			제목:<input type="text" name="freeboard_title"><br>
			내용:<textarea rows="8" cols="65" name="freeboard_cont"></textarea><br>
			게시글 비밀번호:<input type="text" name="freeboard_pwd"><!-- type password로 바뀔것임 테스트보기위해 당분간 text -->
			</td>
		</tr>
		</table>
	<table>
		<tr>
			<td>
				<input type="submit" value="글쓰기"> 
				<input type="reset" value="취소"> 
				<input type="button" value="메인" onclick="location.href='<%=request.getContextPath()%>/index2.jsp'">
			</td>
		</tr>
	</table>
</form>
</article>
