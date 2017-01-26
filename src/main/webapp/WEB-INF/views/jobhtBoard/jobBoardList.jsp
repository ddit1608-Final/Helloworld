<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/freeBoard.css">
<article>
	<div>
		<a href="<%=request.getContextPath()%>/free/freeBoardList.do"><img id="freeLogo" src="<%= request.getContextPath() %>/resources/images/freeboard.png"></a>
	</div> 
	<form name="form" method="post">
		<table class="table table-condensed" id="blt">
			<tr style="background-color: gray; font-size:15pt; color:white; font-family:;">
				<td style="text-align: center;">NO</td>
				<td style="text-align: center;">SUBJECT</td>
				<!-- <th>내용</th> -->
				<td style="text-align: center;">NAME</td>
				<!-- <th>작성자</th> -->
				<td style="text-align: center;">DATE</td>
			</tr>
			<c:forEach items="${JobhtBoardList}" var="jobhtBoardVO">
				<tr>
					<td>${jobhtBoardVO.jobhtboard_title }</td>
				</tr>
				<tr>
					<td><fmt:formatDate value="${jobhtBoardVO.jobhtboard_wri_date}" type="date" /></td>
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
