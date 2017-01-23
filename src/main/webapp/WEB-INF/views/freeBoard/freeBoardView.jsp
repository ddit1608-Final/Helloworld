<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="decorator"uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<article>
	<h2>자유게시판</h2>
	<h3>자유스럽게 게시글을 작성,소통의 공간</h3>
	<form name="formm" method="post">
		<table id="notice">
			<tr>
				<th>제목</th>
				<td>${FreeBoardVO.freeboard_title}</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td><fmt:formatDate value="${FreeBoardVO.}" type="date" /></td>
			</tr>
			<tr>
				<th>작성내용</th>
				<td>${FreeBoardVO.freeboard_cont}
			</tr>
			<%-- <tr>
				<th>답변 내용</th>
				<td>${FreeBoardVO.}
			</tr> --%>
		</table>
		<div class="clear"></div>
		<div id="buttons" style="float: right">
			<input type="button" value="목록보기" class="submit"
				onclick="location.href='<%=request.getContextPath()%>/freeboard/freeBoardList.do'">
			<input type="button" value="메인" class="cancel"
				onclick="location.href='<%=request.getContextPath()%>/index.do'">
		</div>
	</form>
</article>
