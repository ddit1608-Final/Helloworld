<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/cstBoard.css">
<article>
	<div>
		<a href="<%=request.getContextPath()%>/cst/cstBoardList"><img
			id="freeLogo"
			src="<%=request.getContextPath()%>/resources/images/cstboard.png"></a>
	</div>
	<form name="form" method="post">
		<table class="table table-condensed" id="blt">
			<tr
				style="background-color: gray; font-size: 15pt; color: white; font-family:;">
				<td style="text-align: center;">NO</td>
				<td style="text-align: center;">STATUS</td>
				<td style="text-align: center;">TITLE</td>
				<td style="text-align: center;">DATE</td>
			</tr>
			<c:choose>
				<c:when test="${CstBoardListSize<=0 || CstBoardListSize == null}">
					<tr>
						<td width="100%" colspan="4" align="center" height="23">작성하신
							컨설팅 게시물이 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${cstBoardList}" var="cstBoardVO">
						<tr>
							<td style="text-align: center;">${cstBoardVO.cstboard_counsel_posting_no}</td>

							<c:forEach var="flow" items="${flowList }" varStatus="status">
								<c:if test="${status.count == cstBoardVO.flow_code}">
									<c:set value="${flow.flow_cont }" var="flow_cont" />

								</c:if>
							</c:forEach>

							<td style="text-align: center;">${flow_cont}</td>
							<td><a
								href="<%=request.getContextPath()%>/cst/CstBoardDetail?cstboard_counsel_posting_no=${cstBoardVO.cstboard_counsel_posting_no}">${cstBoardVO.cstboard_counsel_title}</a></td>

							<td style="text-align: center;"><fmt:formatDate
									value="${cstBoardVO.cstboard_counsel_wridate}" type="date" /></td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="4" style="text-align: center;">${paging}</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
		<div id="divdiv">
			<table style="margin: 0 auto;">
				<tr>
					<td><input type="button" class="btn btn-success btn-sm"
						value="글쓰기"
						onclick="location.href='<%=request.getContextPath()%>/cst/cstBoardWrite'">
						<input type="button" class="btn btn-success btn-sm" value="메인"
						onclick="location.href='<%=request.getContextPath()%>/index2.jsp'">
					</td>
				</tr>
			</table>
		</div>
	</form>
</article>
