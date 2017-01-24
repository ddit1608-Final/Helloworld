<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
  <title>자유게시판</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<article>
	<div style="background-color:black; width:50%; margin:0 auto; color:white;">
		<h2> 자유게시판 </h2>
		<h3> 자유롭게...머문자리는 아름답게</h3>
	</div> 
	<form name="formm" method="post">
		<table style="background-color:black; width:50%; margin:0 auto; color:white;">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th>등록일</th>
			</tr>
			<c:forEach items="${freeBoardList}" var="freeBoardVO">
				<tr>
					<td>${freeBoardVO.freeboard_posting_no}</td>
					<td>${freeBoardVO.freeboard_title}</td>
					<td>${freeBoardVO.freeboard_cont}</td>
					<td>${freeBoardVO.mem_mail}</td>
					<td>
					<fmt:formatDate value="${freeBoardVO.freeboard_wridate}" type="date" /></td>
				</tr>
			</c:forEach>
			</table >
			<table style="margin:0 auto;">
			<tr>
			<td><input type="button" class="btn btn-success btn-sm" value="글쓰기"
				  	onclick="location.href='<%=request.getContextPath()%>/free/freeBoardWriteForm.do'">
				<input type="button" class="btn btn-success btn-sm" value="메인"
				  	onclick="location.href='<%=request.getContextPath()%>/index2.jsp'">
			<%-- <input type="button" value="글쓰기" class="submit"onclick="location.href='<%=request.getContextPath()%>/free/freeBoardWriteForm.do'"> --%>
			</td>
			<td>
			<%-- <input type="button" value="메인" class="cancel"
				onclick="location.href='<%=request.getContextPath()%>/index2.jsp'"> --%>
			</td>
			</tr>
		</table>
	</form>
</article>
