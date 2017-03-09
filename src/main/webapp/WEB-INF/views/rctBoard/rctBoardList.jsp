<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/freeBoard.css">
<meta charset="UTF-8">
<style>
#titlehover:hover {
	background-color: #e5e5e5;
}

#nohover:hover {
	background-color: white !important;
}
</style>
<article>
	<div>
		<a href="<%=request.getContextPath()%>/rct/rctBoardList.do"> <img
			id="freeLogo"
			src="<%=request.getContextPath()%>/resources/images/guin.png	"></a>
	</div>

	<form name="ara">
		<table class="table table-condensed" id="blt">
			<tr id="titlehover" style="background-color: #e5e5e5;">
				<td>
					<h2>지역</h2>
				</td>
				<td><input type="checkbox" name="rctboard_workp" value="서울">서울
					<input type="checkbox" name="rctboard_workp" value="대전">대전
					<input type="checkbox" name="rctboard_workp" value="인천">인천 
					<input type="checkbox" name="rctboard_workp" value="대구">대구 
					<input type="checkbox" name="rctboard_workp" value="부산">부산 
					<input type="checkbox" name="rctboard_workp" value="광주">광주
				</td>
				</tr>
			<tr id="titlehover" style="background-color: #e5e5e5;">
			<td>
				<h2>학력</h2>
			</td>
			<td>
				<input type="checkbox" name="rctboard_acdmcr" value="고졸">고졸
				<input type="checkbox" name="rctboard_acdmcr" value="초대졸">초대졸
				<input type="checkbox" name="rctboard_acdmcr" value="대졸">대졸
			</td>
			</tr>
			<tr id="titlehover" style="background-color: #e5e5e5;">
			<td>
				<h2>연봉</h2>
			</td>
			<td>
				<input type="text" name="rctboard_year_sal">
			</td>
			</tr>
			<tr id="titlehover" style="background-color: #e5e5e5;">
			<td>
				<h2>모집유형</h2>
			</td>
			<td>
				<input type="checkbox" name="rctboard_emp_kind" value="인턴">인턴
				<input type="checkbox" name="rctboard_emp_kind" value="계약직">계약직
				<input type="checkbox" name="rctboard_emp_kind" value="정규직">정규직
 			</td>
			</tr>
			<tr id="titlehover" style="background-color: #e5e5e5;">
			<td>
				<h2>근무시간</h2>
			</td>
			<td>
				<input type="checkbox" name="rctboard_work_time" value="0">9시~6시
				<input type="checkbox" name="rctboard_work_time" value="1">저녁7시~9시
 			</td>
			</tr>
			<tr id="titlehover" style="background-color: #e5e5e5;">
			<td>
				<h2>글제목</h2>
			</td>
			<td>
				<input type="text" name="rctboard_title">
 			</td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="찾기">
				</td>
			</tr>
			
		</table>
	</form>




	<form name="form" method="post">
		<table class="table table-condensed" id="blt">
			<tr id="titlehover" style="background-color: #e5e5e5;">
				<th>회사명</th>
				<th style="width: 30%;">제목/임금/근무지역</th>
				<th>학력/경력</th>
				<th>등록일자</th>
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
							<td style="text-align: left;"><label
								for="${rctBoardVO.compmem_comp_nm}"><input
									type="checkbox" name="cpnm" id="${rctBoardVO.compmem_comp_nm}">${rctBoardVO.compmem_comp_nm}</label></td>
							<td><a
								href="/world/rct/rctBoardDetail.do?rctboard_posting_no=${rctBoardVO.rctboard_posting_no}"><font
									style="font-size: 16pt;">${rctBoardVO.rctboard_title}</font> <br>
									(연봉)${rctBoardVO.rctboard_year_sal }<br> (지역)${rctBoardVO.rctboard_workp }</a></td>
							<td>${rctBoardVO.compmem_comp_nm}</td>
							<td><fmt:formatDate value="${rctBoardVO.rctboard_wri_date}"
									type="date" /></td>

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
				<td>
					<input type="button" class="btn btn-success btn-sm"
						value="글쓰기"
						onclick="location.href='<%=request.getContextPath()%>/rct/rctBoardWriteForm.do'">
						<input type="button" class="btn btn-success btn-sm" value="메인"
						onclick="location.href='<%=request.getContextPath()%>/index'">
					</td>
				</tr>
			</table>
		</div>
	</form>

</article>
<script>
	function rct_src() {
		formm.action = "rctBoardSearch.do";
		formm.submit();
	}
</script>
