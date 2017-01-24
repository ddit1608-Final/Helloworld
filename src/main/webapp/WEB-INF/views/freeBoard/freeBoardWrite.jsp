<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<article>
	<h2>자유게시판</h2>
	<h3>자유롭게...머문자리는 아름답게</h3>
	<form name="form" method="post" action="freeBoardWrite.do">
			<!-- freeboard_posting_no,mem_mail,freeboard_title,freeboard_cont -->
		<table style="boader: 1px solid black;">
		<tr>
			<td>
			이메일:<input type="text" name="mem_mail">비번:<input type="text" name="freeboard_pwd"><br>
			제목:<input type="text" name="freeboard_title"><br>
			내용:<textarea rows="8" cols="65" name="freeboard_cont"></textarea>
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
