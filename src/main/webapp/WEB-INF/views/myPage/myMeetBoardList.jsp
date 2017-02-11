<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/freeBoard.css">
<article>

	<form name="form" method="post">
		<table class="table table-condensed" id="blt">
			<tr
				style="background-color: gray; font-size: 15pt; color: white; font-family:;">
				<td style="text-align: right:;">TYPE</td>
				<td style="text-align: left:;"><select id="board_type"
					name="board_type" onchange="select_type(this.value)"
					style="background-color: gray; font-size: 15pt; color: white; font-family:;">
						<option value="FreeBoard">자유게시판</option>
						<option value="QnaBoard">QnA게시판</option>
						<option value="Meet_Board" selected="selected">모임게시판</option>
						<option value="IfshrBoard">정보공유게시판</option>
				</select></td>
				<td style="text-align: center;">SUBJECT</td>
				<!-- <th>내용</th> -->
				<td style="text-align: center;">NAME</td>
				<!-- <th>작성자</th> -->
				<td style="text-align: center;">DATE</td>
				<td style="text-align: center;">HITS</td>
			</tr>

			<c:choose>
				<c:when test="${total<=0}">
					<tr>
						<td width="100%" colspan="6" align="center" height="23">
							There are no registered meetboard.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${meetBoardList}" var="myBoardVO">
						<tr>
							<td style="text-align: center;" colspan="2">모임게시판</td>
							<td style="text-align: center;"><a
								href="/world/free/freeBoardDetail.do?freeboard_posting_no=${myBoardVO.meet_board_posting_no}">${myBoardVO.meet_board_title}</a>
							</td>
							<%-- <td>${myBoardVO.freeboard_cont}</td> --%>
							<td style="text-align: center;">${myBoardVO.mem_nick}</td>
							<%-- <td>${loginUser.mem_nick}</td> --%>
							<td style="text-align: center;"><fmt:formatDate
									value="${myBoardVO.meet_board_wri_date}" /></td>
							<td style="text-align: center;">${ myBoardVO.meet_hits}</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="6" style="text-align: center;">${meetPaging}</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
		<div id="divdiv"></div>
	</form>
</article>
