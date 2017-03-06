<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/mypage.css">

<article>
	<table class="table table-striped">
		<th colspan="3">
			<h1 class="text-center">${loginUser.mem_nick}님의 스크랩 내역</h1>
		</th>
		<tr class="text-center" style="font-size:16pt;">
			<td colspan="3">내용</td>
		</tr>
		<c:choose>
			<c:when test="${scrapListSize<=0 || scrapListSize == null}">
				<tr>
					<td width="100%" colspan="3" align="center" height="23">
						스크랩 내역이 없습니다.
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${scrapList}" var="scrap">
					<c:if test="${loginUser.mem_mail ==scrap.mem_mail}"> 
					<tr id="pointhover">
						<td style="text-align: center;">${scrap.title}</td>
						<td style="text-align: center;">${scrap.company}</td>
						<td style="text-align: center;">${scrap.mem_mail}</td>
					</tr>
					</c:if>
				</c:forEach>
				<tr>
					<td colspan="4" style="text-align: center;">${paging}</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
</article>