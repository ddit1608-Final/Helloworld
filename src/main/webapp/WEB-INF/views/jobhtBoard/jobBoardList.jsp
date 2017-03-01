<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/freeBoard.css">
<article>
	<div>
		<a href="<%=request.getContextPath()%>/jobht/jobhtBoardList.do"> 
		<img id="freeLogo" src="<%= request.getContextPath() %>/resources/images/guin.png	"></a>
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
					<td style="text-align: center;">${jobhtBoardVO.jobhtboard_posting_no }</td>
					<td>${jobhtBoardVO.jobhtboard_title }</td>
					<td style="text-align: center;" >${loginUser.mem_nm }</td>				
					<td style="text-align: center;"><fmt:formatDate value="${jobhtBoardVO.jobhtboard_wri_date}" type="date" /></td>
				</tr>
			</c:forEach>
			<tr>
						<td colspan="5" style="text-align: center;">${paging}</td>
					</tr>
			</table >
			<table style="margin:0 auto;">
			<tr>
			<td><input type="button" class="btn btn-success btn-sm" value="글쓰기"
				  	onclick="location.href='<%=request.getContextPath()%>/jobht/jobhtForm.do'">
				<input type="button" class="btn btn-success btn-sm" value="메인"
				  	onclick="location.href='<%=request.getContextPath()%>/index'">
			
			</td>
			</tr>
		</table>
	</form>
</article>
