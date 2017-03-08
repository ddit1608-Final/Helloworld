<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/freeBoard.css">
<article>
	<div>
		<a href="<%=request.getContextPath()%>/free/freeBoardList.do"><img
			id="freeLogo"
			src="<%=request.getContextPath()%>/resources/images/freeboard3.png"></a>
	</div>

	<form id="fdf" name="form" method="post">
		<table class="table .table-condensed">
			<thead>
				<tr style="background-color: #8bdb69; border-bottom: 2px solid #c9c9c9;">
					<th style="width:20%;">SUBJECT</th>
					<td style="width:60%;">${freeBoardVO.freeboard_title }</td>
					<th style="width:20%;"><a href="#">추천</a>(#)/ <a href="#">비추천</a>(#)조회수(${ freeBoardVO.freeboard_hits})</th>
					<td></td>
				</tr>
			</thead>

			<tr>
				<th>NAME</th>
				<td>
					<button type="button" class="btn btn-info btn-xs"
						data-toggle="modal" data-target="#myModal">
						${freeBoardVO.mem_nick}</button>
				</td>
				<td><b>DATE</b> &nbsp;${freeBoardVO.freeboard_wridate }</td>
				
				<td>
					<!-- Modal -->
					<div class="modal fade" id="myModal" role="dialog">
						<div class="modal-dialog">
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">${freeBoardVO.mem_nick}님의 정보입니다.</h4>
								</div>
								<div class="modal-body">
									<p>
										이메일:${freeBoardVO.mem_mail} <a href="#">메일보내기</a>
									</p>
									<p>
										연락처:${freeBoardVO.mem_phn} <a href="#">문자보내기</a>
									</p>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default btn-xs"
										data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
				</td>
			</tr>










			<tr>
				<th>CONTENT</th>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3">${freeBoardVO.freeboard_cont }</td>
			</tr>
		</table>
		<div id="divdiv" style="margin-left:83%;">
			<c:if test="${loginUser.mem_mail ==freeBoardVO.mem_mail }">
				<input class="btn" type="button" value="수정"
					onClick="location.href='/world/free/freeBoardUpdateForm.do?freeboard_posting_no=${freeBoardVO.freeboard_posting_no}'">
				<input class="btn" type="button" value="삭제"
					onClick="location.href='/world/free/deleteFreeBoard.do?freeboard_posting_no=${freeBoardVO.freeboard_posting_no}'">
				<!--[9] 목록 버튼이 눌리면 상품 리스트 페이지로 이동하되 현재 페이지를 전달해 준다. -->
			</c:if>
			<input class="btn" type="button" value="목록"
				onclick="location.href='<%=request.getContextPath()%>/free/freeBoardList.do'">
		</div>
	</form>

	<form action="writeComm" id="writeComm" name="formm" method="post">
		<table class="table table-condensed">
			<thead>
				<tr>
					<td colspan="3"><span class="badge">댓글
							${freeBoardCommListCnt}</span></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="width: 100px">작성자</td>
					<td style="width: 1000px">내용</td>
					<td style="width: 200px">작성날짜</td>
					<td style="width: 90px">비고</td>
				</tr>
			</tbody>
		</table>
		<table class="table table-condensed" id="freecomm_go">

			<c:forEach items="${freeBoardCommList}" var="freeBoardComm"
				varStatus="status">
				<input type="hidden" id="freeboard_ans_code${status.count}"
					value="${freeBoardComm.freeboard_ans_code }">
				<tbody>
					<tr id="freeboard_ans_code${status.count}" class="freecoment">
						<td style="width: 100px; text-align: center;">
							<button type="button" class="btn btn-default btn-xs"
								data-toggle="modal" data-target="#myModal2">${ freeBoardComm.freeboard_comm_wri}</button>
						

						<!-- 일단 댓글에서는 쪽지 기능  -->
						<div class="modal fade" id="myModal2" role="dialog">
							<div class="modal-dialog">
								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<c:set value="${freeboardCommVO.getFreeboard_comm_wri}"
											var="freeboard_comm_wri" />
										<h4 class="modal-title">freeboard_comm_wri 님에게 쪽지 보내기</h4>
									</div>
									<div class="modal-body">
										<textarea class="form-control" rows="7" name="freeboard_cont"
											id="freeboard_cont"></textarea>
										<input type="button" class="btn btn-default btn-xs"
											value="쪽지전송"> <input type="button"
											class="btn btn-default btn-xs" value="취소">
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default btn-xs"
											data-dismiss="modal">Close</button>
									</div>
								</div>
							</div>
						</div></td>
						<!-- 쪽지 모달 끝 -->
						<td style="width: 70%; word-break: break-all;"
							id="freeBoardComm_cont${status.count}"
							name="freeBoardComm_cont${status.count}">${ freeBoardComm.freeboard_comm_cont}
							<input type="button" value="추천"> <input type="button"
							value="비추천">
						</td>
						<td>${ freeBoardComm.freeboard_comm_wridate }</td>
						<c:if
							test="${loginUser.mem_nick ==freeBoardComm.freeboard_comm_wri }">

							<c:set value="${freeBoardComm.freeboard_comm_cont}"
								var="freeboard_comm_cont" />
							<c:set value="${status.count}" var="indexTd" />
							<c:set value="${freeBoardComm.freeboard_ans_code}"
								var="freeboard_ans_code" />
							<c:set value="freeboard_ans_code${status.count}" var="indexTdd" />

							<td><a href="#"
								onclick="updateFreeCommForm('${indexTd }','${indexTd }', event )"
								id="aa">수정</a> <%-- id=${ifShrBoardComm.ifshrboard_ans_code}; --%>
								<a href="#"
								onclick="deleteFreeComm('${freeboard_ans_code}','${indexTdd }',event )"
								id="aa">삭제</a></td>
							<td></td>
						</c:if>
					</tr>
				</tbody>
			</c:forEach>
		</table>
		<c:if test="${loginUser!=null}">
			<textarea rows="2" cols="150" id="freeboard_comm_contt"
				name="freeboard_comm_cont"></textarea>
			<input type="hidden" id="freeboard_posting_no"
				name="freeboard_posting_no"
				value="${freeBoardVO.freeboard_posting_no }">
			<input type="hidden" id="mem_nick" name="mem_nick"
				value="${loginUser.mem_nick}">
			<input type="button" value="댓글등록"
				onclick="freeWriteComm_go($('#mem_nick').val(),$('#freeboard_posting_no').val(),$('#freeboard_comm_contt').val(),'${indexTd}','${indexTdd}',event)">
		</c:if>
		<!-- result div  -->
	</form>

</article>
