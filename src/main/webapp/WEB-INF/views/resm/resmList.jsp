<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<article>
	<div style="background-color:black; width:50%; margin:0 auto; color:white;">
		<h2>이력서</h2>
		<h3></h3>
	</div> 
	<form name="form" method="post">
		<table style="background-color:black; width:50%; margin:0 auto; color:white;">
			<tr>
				<th>등록일</th>
			</tr>
			<c:forEach items="${resmList}" var="ResmVO">
				<tr>
					<td>
					<fmt:formatDate value="${ResmVO.resm_wri_date}" type="date" />
					</td>
				</tr>
			</c:forEach>
			</table >
			<table style="margin:0 auto;">
			<tr>
			<td><input type="button" class="btn btn-success btn-sm" value="글쓰기"
				  	onclick="location.href='<%=request.getContextPath()%>/resm/resmWriteForm.do'">
				<input type="button" class="btn btn-success btn-sm" value="메인"
				  	onclick="location.href='<%=request.getContextPath()%>/index2.jsp'">
			</td>
			</tr>
		</table>
	</form>
</article>
