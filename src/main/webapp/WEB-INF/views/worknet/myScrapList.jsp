<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/mypage.css">
<article>
출력해줘!!!
<table class="table table-striped">
	<th colspan="3">
		<h1 class="text-center">회원님의 스크랩 내역입니다</h1>
	</th>
	<c:if test="${loginUser!=null}">
	<c:forEach items="${scrapList }" var="scrap" varStatus="status">
	<tr style="font-size:16pt;">
			<td style="width:20%">회사명</td>
			<td style="width:50%; text-align:center;">제목/내용</td>
			<td style="width:20%">기간</td>
			<td style="width:10%">삭제</td>
	</tr>
	<tr id="pointhover">
		<td>
			${scrap.company }
		</td>
		<td style="text-align:center;">
			<a href="#">${scrap.title }</a><br/>
			${scrap.salTpNm } ${scrap.sal }<br/>
			${scrap.region }
		</td>
		<td>${scrap.regDt } ~<br/> ${scrap.closeDt }</td>
		<td><input type="button" class="btn btn-default btn-sm" value="삭제"	onclick="scrap_del()"></td>
	</tr>
	</c:forEach>
	</c:if>
	<c:if test="${loginUser==null }">
	<tr>
		<td width="100%" colspan="6" align="center" height="23">
		There are no registered scraplist</td>
	</tr>
	</c:if>
</table>
</article>