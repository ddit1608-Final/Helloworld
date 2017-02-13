<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/freeBoard.css">
<article>
	<div>
		<a href="<%=request.getContextPath()%>/free/freeBoardList.do"><img
			id="freeLogo"
			src="<%=request.getContextPath()%>/resources/images/freeboard3.png"></a>
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
				<c:when test="${freeBoardListSize<=0}">
					<tr>
						<td width="100%" colspan="6" align="center" height="23">
							There are no registered freeboard.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${freeBoardList}" var="freeBoardVO">
						<tr>
							<td style="text-align: center;">${freeBoardVO.freeboard_posting_no}</td>
							<td style="text-align: center;">
							<a href="/world/free/freeBoardDetail.do?freeboard_posting_no=${freeBoardVO.freeboard_posting_no}"
							data-toggle="tooltip" data-placement="right"
									title="${freeBoardVO.freeboard_cont}" class="test">
								${freeBoardVO.freeboard_title}
								<span class="label label-danger">new</span>
								</a>
							</td>
							<%-- <td>${freeBoardVO.freeboard_cont}</td> --%>
							<td style="text-align: center;">${freeBoardVO.mem_nick}</td>
							<%-- <td>${loginUser.mem_nick}</td> --%>
							<td style="text-align: center;"><fmt:formatDate
									value="${freeBoardVO.freeboard_wridate}"  /></td>
							<td style="text-align: center;">${ freeBoardVO.freeboard_hits}</td>
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
	<form name="formm" id="formm" method="post">
		<div id="divdiv">
		<table class="table table-condensed" id="blt" style="margin: 0 auto;">
			<tr id="nohover">
				<td id="nohover">
				<select id="type" name="type">
					<option value="freeboard_title" selected="selected">제목</option>
					<option value="freeboard_cont">내용</option>
					<option value="mem_nick">작성자</option>
				</select>
				<input type="text" name="key" id="key" placeholder="검색어를 입력해주세요"/>
				<%-- <input type="button" class="btn btn-success btn-sm" value="검색"	onclick="is_src('${is_key}',event)"> --%>
				<input type="button" class="btn btn-success btn-sm" value="검색"	onclick="free_src()">
				<marquee behavior=alternate width="300" scrollamount="5">
				<span>
				총 (${searchCnt})개의 게시물
				</span>
				</marquee>
				<marquee width="300">←<font color="pink">♥</font>--&lt;</marquee><font size="5">{＼((￣<font color="red">■</font> ￣)</font>
				</td>
				</tr>
		</table>
		</div>
	</form>
	
	
	
</article>