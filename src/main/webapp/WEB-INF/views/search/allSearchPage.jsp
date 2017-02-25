<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/freeBoard.css">
<article>
	<div>
		<a href="<%=request.getContextPath()%>/search/allSearchPage">
		<img id="freeLogo"src="<%=request.getContextPath()%>/resources/images/allboard.gif"></a>
	</div>
	<table class="table table-condensed" id="blt">
		<c:choose>
			<c:when test="${allBoardListSize<=0}">
				<tr>
					<td width="100%" colspan="6" align="center" height="23">
						There are no registered allBoard.</td>
				</tr>
			</c:when>
			<c:otherwise>
					<tr style="background-color: gray; font-size: 15pt; color: white; font-family:;">
						<td style="text-align: center;">게시판</td>
						<td style="text-align: center;">제목</td>
						<td style="text-align: center;">내용</td>
						<td style="text-align: center;">작성날짜</td>
					</tr>
					<c:forEach items="${allBoardList}" var="all">
					<tr>
						<td style="text-align: center;"><span class="label label-default">${all.typ }</span></td>
						<td style="text-align: center;"><a href="#">${all.title }</a></td>
						<td style="text-align: center;">${all.cont }</td>
						<td style="text-align: center;">${all.wridate }</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4" style="text-align: center;"><span>총 (${searchCnt})개의 게시물</span>
						${paging}</td>
				</tr>
				<tr>
					
				</tr>
		</c:otherwise>
		</c:choose>
	</table>
</article>