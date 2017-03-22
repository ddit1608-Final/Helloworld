<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/cstBoard.css">
<article>

	<form id="fdf" name="form" method="post">
		<table class="table .table-condensed">
			<tr>
				<th>상담제목</th>
				<td>${cstBoardVO.cstboard_counsel_title }</td>
				<c:forEach var="flow" items="${flowList }" varStatus="status">
					<c:if test="${status.count == cstBoardVO.flow_code}">
						<c:set value="${flow.flow_cont }" var="flow_cont" />

					</c:if>
				</c:forEach>
				<td><b>진행상황</b> &nbsp;${flow_cont}</td>
				<td><b>상담접수</b> &nbsp;<fmt:formatDate
						value="${cstBoardVO.cstboard_counsel_wridate }"
						pattern="yyyy-MM-dd  HH시 mm분" /></td>

			</tr>

			<tr>
				<th>상담내용</th>
				<td>신청유저 <input type="button" class="btn xs"
					value="${cstBoardVO.mem_mail }" data-toggle="modal"
					data-target="#myModal">
				</td>

				<!-- 상담 신청한 유저 연락처 뜨는 모달  -->
				<td>
					<div class="modal fade" id="myModal" role="dialog">
						<div class="modal-dialog">
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">이메일: ${cstBoardVO.mem_mail }님께서 상담요청하셨습니다.</h4>
									<h4 class="modal-title">닉네임: ${cstBoardVO.mem_nick }님께서 상담요청하셨습니다.</h4>
								</div>
								<div class="modal-body">
									<p>회원님의 연락처 <span style="font-size:20pt; color:green;"> ${cstBoardVO.mem_phn }</span></p>
									<p>☎정확하고 신속한 상담 부탁드립니다☎</p>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
				</td>






				<!-- 상담 신청한 유저 연락처 뜨는 모달  -->








			</tr>
			<tr>
				<td colspan="3">${cstBoardVO.cstboard_counsel_cont }</td>

			</tr>
		</table>
		<div id="divdiv">
			<input class="btn" type="button" value="수정"
				onClick="location.href='<%=request.getContextPath()%>/mypage/cstBoardUpdate?cstboard_counsel_posting_no=${cstBoardVO.cstboard_counsel_posting_no}'">
			<input class="btn" type="button" value="목록"
				onclick="location.href='<%=request.getContextPath()%>/admin/cstManage'">
		</div>
	</form>

	<form action="writeComm" id="writeComm" name="formm" method="post">
		<table class="table table-condensed">
			<thead>
				<tr>
					<td colspan="3"><span class="badge">댓글
							${cstBoardCommListCnt}</span></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="width: 100px; text-align: center;">작성자</td>
					<td style="width: 1000px;">내용</td>
					<td style="width: 200px;">작성날짜</td>
					<td style="width: 90px;">비고</td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table class="table table-condensed" id="cstcomm_go">
			<c:forEach items="${cstBoardCommList}" var="cstBoardComm"
				varStatus="status">
				<input type="hidden" id="cstboard_ans_code${status.count}"
					value="${cstBoardComm.cstboard_ans_code }">
				<tbody>
					<tr id="cstboard_ans_code${status.count}" class="cstcoment">
						<td style="width: 100px; text-align: center;"><span
							class="glyphicon glyphicon-user"></span></td>
						<td style="width: 70%; word-break: break-all;"
							id="cstBoard_ans_cont${status.count}"
							name="cstBoard_ans_cont${status.count}">${ cstBoardComm.cstboard_ans_cont}</td>
						<td><fmt:formatDate value="${ cstBoardComm.cstboard_ans_wridate }" pattern="yy-MM-dd a hh시 mm분"/></td>
						<c:if test="${loginUser.mem_mail eq 'a'}">
							<c:set value="${cstBoardComm.cstboard_ans_cont}"
								var="cstboard_ans_cont" />
							<c:set value="${status.count}" var="indexTd" />
							<c:set value="${cstBoardComm.cstboard_ans_code}"
								var="cstboard_ans_code" />
							<c:set value="cstboard_ans_code${status.count}" var="indexTdd" />
							<td><a href="#"
								onclick="updateCstCommForm('${indexTd }', event )" id="aa">수정</a>
								/ <a href="#"
								onclick="deleteCstComm('${cstboard_ans_code}','${indexTdd }',event )"
								id="aa">삭제</a></td>
							<td></td>
						</c:if>
					</tr>
				</tbody>
			</c:forEach>
		</table>
		<c:if test="${loginUser!=null}">
			<textarea rows="2" cols="150" id="cstboard_ans_contt"
				name="cstboard_ans_cont"></textarea>
			<input type="hidden" id="cstboard_counsel_posting_no"
				name="cstboard_counsel_posting_no"
				value="${cstBoardVO.cstboard_counsel_posting_no }">
			<input type="hidden" id="mem_nick" name="mem_nick"
				value="${loginUser.mem_nick}">
			<input type="button" value="댓글등록"
				onclick="cstwriteComm_go($('#mem_nick').val(),$('#cstboard_counsel_posting_no').val(),$('#cstboard_ans_contt').val(),event)">
		</c:if>
	</form>
</article>
