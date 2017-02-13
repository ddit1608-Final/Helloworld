<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/cstBoard.css">
<article>
	<div>
		<a href="<%=request.getContextPath()%>/cst/cstBoardList"><img
			id="freeLogo"
			src="<%=request.getContextPath()%>/resources/images/cstboard.png"></a>
	</div>

	<div>컨설팅 게시판에 대한 설명이 들어가야합니다. 수정해야함</div>

	<div id="divdiv">
		<table style="margin: 0 auto;">
			<tr>
				<td><c:if test="${loginUser != null }">
						<input type="button" class="btn btn-success btn-sm" value="글쓰기"
							onclick="location.href='<%=request.getContextPath()%>/cst/cstBoardWrite'">
					</c:if> <input type="button" class="btn btn-success btn-sm" value="메인"
					onclick="location.href='<%=request.getContextPath()%>/index2.jsp'">
				</td>
			</tr>
		</table>
	</div>
	</form>
</article>
