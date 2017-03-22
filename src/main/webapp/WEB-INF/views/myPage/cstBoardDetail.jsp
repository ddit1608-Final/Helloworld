<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/cstBoard.css">
<article>

	<form id="fdf" name="form" method="post">
		<table class="table .table-condensed" style="height:30%;">
			<tr>
				<th>상담제목</th>
				<td>${cstBoardVO.cstboard_counsel_title }</td>
				<c:forEach var="flow" items="${flowList }" varStatus="status">
					<c:if test="${status.count == cstBoardVO.flow_code}">
						<c:set value="${flow.flow_cont }" var="flow_cont" />

					</c:if>
				</c:forEach>
				<td><b>진행상황</b> &nbsp;<span style="color:red;font-size:13pt;">${flow_cont}</span></td>
				<td><b>상담요청</b> &nbsp;<fmt:formatDate value="${cstBoardVO.cstboard_counsel_wridate }" pattern="yyyy년  MM월  dd일  HH시  mm분"/></td>
				

			</tr>

			<tr>
				<th>상담내용</th>
				<td></td>
				<td></td>

			</tr>
			<tr>
				<td colspan="3">${cstBoardVO.cstboard_counsel_cont }</td>

			</tr>
		</table>
		<div id="divdiv">

			<input class="btn" type="button" value="수정"
				onClick="location.href='<%=request.getContextPath()%>/mypage/cstBoardUpdate?cstboard_counsel_posting_no=${cstBoardVO.cstboard_counsel_posting_no}'">
			<input class="btn" type="button" value="목록"
				onclick="location.href='<%=request.getContextPath()%>/mypage/cstBoardList'">
		</div>
	</form>
	<form action="writeComm" id="writeComm" name="formm" method="post">
		<table class="table table-condensed">
			<thead>
				<tr>
					<td colspan="3"><span class="badge">댓글  ${cstBoardCommListCnt}</span></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="width:100px;text-align:center;" >작성자</td>
					<td style="width:1000px;">내용</td>
					<td style="width:200px;">작성날짜</td>
					<td style="width:90px;">비고</td>
					<td></td>
				</tr>
			</tbody>
			</table>
		<table class="table table-condensed" id="cstcomm_go">
				<c:forEach items="${cstBoardCommList}" var="cstBoardComm" varStatus="status" >
					<input type="hidden" id="cstboard_ans_code${status.count}" value="${cstBoardComm.cstboard_ans_code }">
					<tbody>
					<tr id="cstboard_ans_code${status.count}" class="cstcoment">
						<td style="width:100px;text-align:center;">
							<span class="glyphicon glyphicon-user"></span>
						</td>
						<td style="width:70%;  word-break:break-all;" id="cstBoard_ans_cont${status.count}" name="cstBoard_ans_cont${status.count}">
								${ cstBoardComm.cstboard_ans_cont}</td>
						<td>
						<%-- <fmt:formatDate value="${ cstBoardComm.cstboard_ans_wridate }" pattern="yyyy년  MM월  dd일  hh시  mm분"/> --%>
						${ cstBoardComm.cstboard_ans_wridate }
						</td>
						<td>
						</td>
						<td></td>
					</tr>
				</tbody>
				</c:forEach>
		</table>
	</form>
</article>
