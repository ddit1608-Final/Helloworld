<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/meetBoard.css">
<article>
	<div>
		<a href="<%=request.getContextPath()%>/meet/meetBoardList.do"><img
			id="meetLogo"
			src="<%=request.getContextPath()%>/resources/images/meetLogo.png"></a>
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
			</tr>
			<c:choose>
				<c:when test="${meetBoardListSize<=0}">
					<tr>
						<td width="100%" colspan="6" align="center" height="23">
							There are no registered meetboard.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${meetBoardList}" var="meetBoardVO">
						<tr>
							<td style="text-align: center;">${meetBoardVO.meet_board_posting_no}</td>
							<td><a
								href="/world/meet/meetBoardDetail.do?meet_board_posting_no=${meetBoardVO.meet_board_posting_no}">${meetBoardVO.meet_board_title}</a>
							</td>
							<%-- <td>${freeBoardVO.freeboard_cont}</td> --%>
							<td style="text-align: center;">${meetBoardVO.mem_nick}</td>
							<%-- <td>${loginUser.mem_nick}</td> --%>
							<td style="text-align: center;"><fmt:formatDate
									value="${meetBoardVO.meetboard_wri_date}" type="date" /></td>
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
				<td><input type="button" class="btn btn-success btn-sm"
					value="글쓰기"
					onclick="location.href='<%=request.getContextPath()%>/meet/meetBoardWriteForm.do'">
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