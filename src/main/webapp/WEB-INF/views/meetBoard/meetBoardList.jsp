<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/meetBoard.css">
<article>
	<div>
		<a href="<%=request.getContextPath()%>/meet/meetBoardList.do"><img
			id="meetLogo"
			src="<%=request.getContextPath()%>/resources/images/meetLogo.png"></a>
	</div>
	<div style="overflow-y:auto; overflow-x:hidden; width:100%; height:700px;">
	<form name="form" method="post">
		<table class="table table-condensed" id="blt">
			<tr
				style="background-color: gray; font-size: 15pt; color: white; font-family:;">
				<td style="text-align: center;">번호</td>
				<td style="text-align: center; width:7%;">지역</td>
				<td style="text-align: center; width:55%; float:left;">제목</td>
				<!-- <th>내용</th> -->
				<td style="text-align: center;">작성자</td>
				<!-- <th>작성자</th> -->
				<td style="text-align: center;">날짜</td>
			</tr>
			<c:choose>
				<c:when test="${meetBoardListSize<=0}">
					<tr>
						<td width="100%" colspan="5" align="center" height="23">
							There are no registered meetboard.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${meetBoardList}" var="meetBoardVO">
						<tr>
							<td style="text-align: center;">${meetBoardVO.meet_board_posting_no}</td>
							<td style="text-align: center;"><c:forEach var="flow"
									items="${flowList }" varStatus="status">
									<c:if test="${status.count == meetBoardVO.flow_code}">
										<%-- <c:set value="${flow.flow_cont }" var="flow_cont" /> --%>
										${flow.flow_cont }
									</c:if>
								</c:forEach></td>
							<td style="text-align: left; padding-left:5%;"><a
								href="/world/meet/meetBoardDetail.do?meet_board_posting_no=${meetBoardVO.meet_board_posting_no}">
								${meetBoardVO.meet_board_title}</a>
							</td>
							<%-- <td>${freeBoardVO.freeboard_cont}</td> --%>
							<td style="text-align: center;">${meetBoardVO.mem_nick}</td>
							<%-- <td>${loginUser.mem_nick}</td> --%>
							<td style="text-align: center;"><fmt:formatDate
									value="${meetBoardVO.meet_board_wri_date}" type="date" /></td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="5" style="text-align: center;">${paging}</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
		<div id="divdiv" >
			<table style="margin: 0 auto;">
				<tr>
					<td><c:if test="${loginUser != null}">
							<input type="button" class="btn btn-success btn-sm" value="글쓰기"
								onclick="location.href='<%=request.getContextPath()%>/meet/meetBoardWriteForm.do'">
						</c:if> <input type="button" class="btn btn-success btn-sm" value="메인"
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
	</div>
</article>