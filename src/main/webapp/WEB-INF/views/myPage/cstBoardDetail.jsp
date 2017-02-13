<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/cstBoard.css">
<article>

	<form id="fdf" name="form" method="post">
		<table class="table .table-condensed">
			<tr>
				<th>TITLE</th>
				<td>${cstBoardVO.cstboard_counsel_title }</td>
				<c:forEach var="flow" items="${flowList }" varStatus="status">
					<c:if test="${status.count == cstBoardVO.flow_code}">
						<c:set value="${flow.flow_cont }" var="flow_cont" />

					</c:if>
				</c:forEach>
				<td><b>STATUS</b> &nbsp;${flow_cont}</td>
				<td><b>DATE</b> &nbsp;${cstBoardVO.cstboard_counsel_wridate }</td>

			</tr>

			<tr>
				<th>CONTENT</th>
				<td></td>
				<td></td>

			</tr>
			<tr>
				<td colspan="3">${cstBoardVO.cstboard_counsel_cont }</td>

			</tr>
		</table>
		<div id="divdiv">

			<input class="btn" type="button" value="수정"
				onClick="location.href='<%=request.getContextPath()%>/mypage/cstBoardUpdate?cstboard_counsel_posting_no=${cstBoardVO.cstboard_counsel_posting_no}'">
			<input class="btn" type="button" value="목록"
				onclick="location.href='<%=request.getContextPath()%>/mypage/cstBoardList'">
		</div>
	</form>
</article>
