<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/freeBoard.css">
<meta charset="UTF-8">
<style>
#titlehover:hover{
background-color: #e5e5e5;
}
#nohover:hover{
background-color: white !important;
}
</style>
<article>
	<div>
		<a href="<%=request.getContextPath()%>/rct/rctBoardList.do"> 
		<img id="freeLogo" src="<%= request.getContextPath() %>/resources/images/guin.png	"></a>
	</div> 
	
	<form name="form" method="post">
		<table class="table table-condensed" id="blt">
			<tr id="titlehover" style="background-color: #e5e5e5;">
				<th>회사명</th>
				<th style="width:30%;">제목/임금/근무지역</th>
				<th>학력/경력</th>
				<th>등록일자</th>
				<th>마감일자</th>
			</tr>
			
			
			
		
		<c:choose>
				<c:when test="${rctBoardListSize<=0}">
					<tr>
						<td width="100%" colspan="6" align="center" height="23">
							There are no registered rctboard.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${rctBoardList}" var="rctBoardVO">
						<tr>
							<td style="text-align: left;"><label for="${rctBoardVO.compmem_comp_nm}"><input type="checkbox" name="cpnm" id="${rctBoardVO.compmem_comp_nm}">${rctBoardVO.compmem_comp_nm}</label></td>
							<%-- <td style="text-align: center;">${rctBoardVO.rctboard_posting_no}</td> --%>
							<td><a href="/world/rct/rctBoardDetail.do?rctboard_posting_no=${rctBoardVO.rctboard_posting_no}"><font style="font-size:16pt;">${rctBoardVO.rctboard_title}</font>
							<br>
							(연봉)<br>
							(지역)</a></td>
							<td>${rctBoardVO.compmem_comp_nm}</td>
							<td><fmt:formatDate
									value="${rctBoardVO.rctboard_wri_date}" type="date" /></td>
							
							<td style="text-align: center;">${qnaBoardVO.qnaboard_hits}</td>
						</tr>
					</c:forEach>
					<tr id="nohover">
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
					onclick="location.href='<%=request.getContextPath()%>/rct/rctBoardWriteForm.do'">
					<input type="button" class="btn btn-success btn-sm" value="메인"
					onclick="location.href='<%=request.getContextPath()%>/index'">
				</td>
			</tr>
		</table>
		</div>
	</form>
	<%-- <form name="formm" id="formm" method="post">
		<div id="divdiv">
		<table class="table table-condensed" id="blt" style="margin: 0 auto;">
			<tr id="nohover">
				<td id="nohover">
				<select id="type" name="type">
					<option value="rctboard_title" selected="selected">제목</option>
					<option value="rctboard_cont">내용</option>
					<option value="mem_nick">작성자</option>
				</select>
				<input type="text" name="key" id="key" placeholder="검색어를 입력해주세요"/>
				<input type="button" class="btn btn-success btn-sm" value="검색"	onclick="rct_src()">
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
	<form name="form" method="post">
		<table class="table table-condensed" id="blt">
			<tr
				style="background-color: gray; font-size: 15pt; color: white; font-family:;">
				<td style="text-align: center;">NO</td>
				<td style="text-align: center;">SUBJECT</td>
				<!-- <th>내용</th> -->
				<td style="text-align: center;">회사명</td>
				<!-- <th>작성자</th> -->
				<td style="text-align: center;">DATE</td>
				<td style="text-align: center;">조회수</td>
			</tr>
			<c:choose>
				<c:when test="${rctBoardListSize<=0}">
					<tr>
						<td width="100%" colspan="6" align="center" height="23">
							There are no registered rctboard.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${rctBoardList}" var="rctBoardVO">
						<tr>
							<td style="text-align: center;">${rctBoardVO.rctboard_posting_no}</td>
							<td><a
								href="/world/rct/rctBoardDetail.do?rctboard_posting_no=${rctBoardVO.rctboard_posting_no}">${rctBoardVO.rctboard_title}</a>
							</td>
							
							<td style="text-align: center;">${rctBoardVO.compmem_comp_nm}</td>
							<td style="text-align: center;"><fmt:formatDate
									value="${rctBoardVO.rctboard_wri_date}" type="date" /></td>
							
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
					onclick="location.href='<%=request.getContextPath()%>/rct/rctBoardWriteForm.do'">
					<input type="button" class="btn btn-success btn-sm" value="메인"
					onclick="location.href='<%=request.getContextPath()%>/index'">
					<input type="button" value="글쓰기" class="submit"onclick="location.href='<%=request.getContextPath()%>/free/freeBoardWriteForm.do'">
				</td>
				<td>
					<input type="button" value="메인" class="cancel"
				onclick="location.href='<%=request.getContextPath()%>/index2.jsp'">
				</td>
			</tr>
		</table>
		</div>
	</form> --%>
	
	
</article>
<script>
function rct_src(){
	formm.action =  "rctBoardSearch.do";
	formm.submit();
}
</script>
