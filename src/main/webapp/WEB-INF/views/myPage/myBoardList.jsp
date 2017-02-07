<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/freeBoard.css">
<article>
	<div>
		<a href="<%=request.getContextPath()%>/free/myBoardList.do"><img
			id="freeLogo"
			src="<%=request.getContextPath()%>/resources/images/freeboard.png"></a>
	</div>
	<form name="form" method="post">
		<table class="table table-condensed" id="blt">
			<tr
				style="background-color: gray; font-size: 15pt; color: white; font-family:;">
				<td style="text-align: center;">NO</td>
				<td style="text-align: center;">SUBJECT</td>
				<!-- <th>내용</th> -->
				<td style="text-align: center;">NAME</td>
				<!-- <th>작성자</th> -->
				<td style="text-align: center;">DATE</td>
				<td style="text-align: center;">HITS</td>
			</tr>
			<c:choose>
				<c:when test="${myBoardListSize<=0}">
					<tr>
						<td width="100%" colspan="6" align="center" height="23">
							There are no registered freeboard.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${myBoardList}" var="myBoardVO">
						<tr>
							<td style="text-align: center;">${myBoardVO.freeboard_posting_no}</td>
							<td style="text-align: center;"><a
								href="/world/free/freeBoardDetail.do?freeboard_posting_no=${myBoardVO.freeboard_posting_no}">${myBoardVO.freeboard_title}</a>
							</td>
							<%-- <td>${myBoardVO.freeboard_cont}</td> --%>
							<td style="text-align: center;">${myBoardVO.mem_nick}</td>
							<%-- <td>${loginUser.mem_nick}</td> --%>
							<td style="text-align: center;"><fmt:formatDate
									value="${myBoardVO.freeboard_wridate}"  /></td>
							<td style="text-align: center;">${ myBoardVO.freeboard_hits}</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="5" style="text-align: center;">${paging}</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
		<div id="divdiv">
		<table style="margin: 0 auto;">
			<tr>
				<td>
				<c:if test="${loginUser != null}"> 
				<input type="button" class="btn btn-success btn-sm" value="글쓰기"
					onclick="location.href='<%=request.getContextPath()%>/free/freeBoardWriteForm.do'">
				</c:if>
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
		</div>
	</form>
</article>
