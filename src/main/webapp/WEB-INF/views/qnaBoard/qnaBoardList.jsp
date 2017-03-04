<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/freeBoard.css">
<article>
	<div>
		<a href="<%=request.getContextPath()%>/qna/qnaBoardList.do"><img
			id="freeLogo"
			src="<%=request.getContextPath()%>/resources/images/qnaLogo.png"></a>
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
				<td style="text-align: center;">추천</td>
				<td style="text-align: center;">비추천</td>
				<td style="text-align: center;">조회수</td>
			</tr>
			
			
			<c:choose>
				<c:when test="${qnaBoardListSize<=0}">
					<tr>
						<td width="100%" colspan="6" align="center" height="23">
							There are no registered freeboard.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${qnaBoardList}" var="qnaBoardVO">
						<tr>
							<td style="text-align: center;">${qnaBoardVO.qnaboard_posting_no}</td>
							<td><a
								href="/world/qna/qnaBoardDetail.do?qnaboard_posting_no=${qnaBoardVO.qnaboard_posting_no}">${qnaBoardVO.qnaboard_title}</a>
							</td>
							
							<td style="text-align: center;">${qnaBoardVO.mem_nick}</td>
							<td style="text-align: center;"><fmt:formatDate
									value="${qnaBoardVO.qnaboard_wridate}" type="date" /></td>
							
							<c:forEach items="${qnaBChuList}" var="qnaBChuVo">
								<c:if test="${qnaBoardVO.qnaboard_posting_no == qnaBChuVo.qnaboard_posting_no }">
									<td style="text-align: center;">${qnaBChuVo.qnaboard_board_chu}</td>
									<td style="text-align: center;">${qnaBChuVo.qnaboard_board_bchu}</td>	
								</c:if>
							</c:forEach>	
							<td style="text-align: center;">${qnaBoardVO.qnaboard_hits}</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="6" style="text-align: center;">${paging}</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
		<div id="divdiv">
		<table style="margin: 0 auto;">
			<tr>
				<td><input type="button" class="btn btn-success btn-sm"
					value="글쓰기"
					onclick="location.href='<%=request.getContextPath()%>/qna/qnaBoardWriteForm.do'">
					<input type="button" class="btn btn-success btn-sm" value="메인"
					onclick="location.href='<%=request.getContextPath()%>/index'">
					<%-- <input type="button" value="글쓰기" class="submit"onclick="location.href='<%=request.getContextPath()%>/free/freeBoardWriteForm.do'"> --%>
				</td>
				<td>
					<%-- <input type="button" value="메인" class="cancel"
				onclick="location.href='<%=request.getContextPath()%>/index'"> --%>
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
					<option value="qnaboard_title" selected="selected">제목</option>
					<option value="qnaboard_cont">내용</option>
					<option value="mem_nick">작성자</option>
				</select>
				<input type="text" name="key" id="key" placeholder="검색어를 입력해주세요"/>
				<input type="button" class="btn btn-success btn-sm" value="검색"	onclick="qna_src()">
				<marquee behavior=alternate width="300" scrollamount="5">
				<span>
				총 (${searchCnt})개의 게시물
				</span>
				</marquee>
				</td>
				</tr>
		</table>
		</div>
	</form>
</article>
<script>
function qna_src(){
	formm.action =  "qnaBoardSearch.do";
	formm.submit();
}
</script>
