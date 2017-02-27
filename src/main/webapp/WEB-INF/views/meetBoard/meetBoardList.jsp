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
				<td style="text-align: center;">NO</td>
				<td style="text-align: center;">SUBJECT</td>
				<td style="text-align: center;">NAME</td>
				<td style="text-align: center;">DATE</td>
				<td style="text-align: center;">HITS</td>
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
							<td style="text-align: center;">
								<a href="/world/meet/meetBoardDetail.do?meet_board_posting_no=
									${meetBoardVO.meet_board_posting_no}"data-toggle="tooltip" data-placement="right"
									title="${meetBoardVO.meet_board_cont}">${meetBoardVO.meet_board_title}
								<c:forEach var="flow" items="${flowList }" varStatus="status">
									<c:if test="${flow.flow_code == meetBoardVO.flow_code}">
										<span class="label label-default">${flow.flow_cont }</span>
									</c:if>
								</c:forEach>
								</a>
								</td>
								<%-- <td>${freeBoardVO.freeboard_cont}</td> --%>
								<td style="text-align: center;">${meetBoardVO.mem_nick}</td>
								<%-- <td>${loginUser.mem_nick}</td> --%>
								<td style="text-align: center;"><fmt:formatDate
										value="${meetBoardVO.meet_board_wridate}" type="date" /></td>
								<td style="text-align: center;">${ meetBoardVO.meet_board_hits}</td>
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
	<form name="formm" id="formm" method="post">
		<div id="divdiv">
		<table class="table table-condensed" id="blt" style="margin: 0 auto;">
			<tr >
				<td>
				<select id="type" name="type">
					<option value="meet_board_title" selected="selected">제목</option>
					<option value="meet_board_cont">내용</option>
					<option value="mem_nick">작성자</option>
				</select>
				<input type="text" name="key" id="key" placeholder="검색어를 입력해주세요"/>
				<%-- <input type="button" class="btn btn-success btn-sm" value="검색"	onclick="is_src('${is_key}',event)"> --%>
				<input type="button" class="btn btn-success btn-sm" value="검색"	onclick="meet_src()">
				<marquee behavior=alternate width="200" scrollamount="1">
				<span>
				총 (${searchCnt})개의 게시물
				</span>
				</marquee>
				</td>
				</tr>
				<tr>
					<td style="background: white;">
						<label id="isert_key" style="color:red;"></label>
					</td>
					<td></td>
			</tr>
		</table>
		</div>
	</form>
	
</article>