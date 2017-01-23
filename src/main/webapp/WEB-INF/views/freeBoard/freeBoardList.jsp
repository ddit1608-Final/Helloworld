<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<article>
	<h2>자유게시판</h2>
	<h3>자유스럽게 게시글을 작성,소통의 공간</h3>
	<form name="formm" method="post">
		<table id="cartList">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>등록일</th>
				<th>답변 여부</th>
			</tr>
			<c:forEach items="${freeBoardList}" var="qnaVO">
				<tr>
					<td>${qnaVO.qseq}</td>
					<td><a href="/freeboard/freeBoardView.do?qseq=${freeBoardVO.qseq}">
							${freeBoardVO.subject}</a></td>
					<td><fmt:formatDate value="${freeBoardVO.indate}" type="date" /></td>
					<td><c:choose>
							<c:when test="${freeBoardVO.rep==1}"> no </c:when>
							<c:when test="${freeBoardVO.rep==2}"> yes </c:when>
						</c:choose></td>
				</tr>
			</c:forEach>
		</table>
		<div class="clear"></div>
		<div id="buttons" style="float: right">
			<input type="button" value="1:1 질문하기" class="submit"
				onclick="location.href='/freeboard/freeBoardWriteForm.do'"> <input
				type="button" value="쇼핑 계속하기" class="cancel"
				onclick="location.href='<%=request.getContextPath()%>/index.do'">
		</div>
	</form>
</article>
