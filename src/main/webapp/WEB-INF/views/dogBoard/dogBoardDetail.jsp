<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/freeBoard.css">
<article>
	<div>
		<a href="<%=request.getContextPath()%>/ifShr/ifShrBoardList.do"> <img
			id="freeLogo"
			src="<%=request.getContextPath()%>/resources/images/dogboard.png"></a>
	</div>

	<form id="fdf" name="form" method="post">
		<table class="table .table-condensed">
			<thead>
				<tr
					style="background-color: #8bdb69; border-bottom: 2px solid #c9c9c9;">
					<th style="width: 20%;">SUBJECT</th>
					<td style="width: 60%;">${dogBoardVO.dsboard_title }</td>
					<th style="width: 20%;"><a href="#">추천</a>(#)/ <a href="#">비추천</a>(#)조회수(${ dogBoardVO.dsboard_hits})</th>

				</tr>
			</thead>

			<tr>
				<th>NAME</th>
				<td>
					<button type="button" class="btn btn-info btn-xs"
						data-toggle="modal" data-target="#myModal">
						${dogBoardVO.mem_nick}</button>
				</td>
				<td><b>DATE</b> &nbsp;${dogBoardVO.dsboard_wridate }</td>
			</tr>



			<tr>
				<td>
					<!-- Modal -->
					<div class="modal fade" id="myModal" role="dialog">
						<div class="modal-dialog">
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">${dogBoardVO.mem_nick}님의 정보입니다.</h4>
								</div>
								<div class="modal-body">
									<p>
										이메일:${dogBoardVO.mem_mail} <a href="#">메일보내기</a>
									</p>
									<p>
										연락처:${dogBoardVO.mem_phn} <a href="#">문자보내기</a>
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
				<!-- 말머리 추가중 -->
				<td><c:forEach var="posting" items="${typeList }"
						varStatus="status">
						<c:if test="${status.count == dogBoardVO.type_key}">${posting.type_value}
		</c:if>
					</c:forEach></td>
				<!-- 말머리 추가중 -->
				<td></td>

			</tr>
			<tr>
				<td colspan="3">${dogBoardVO.dsboard_cont }</td>

			</tr>
		</table>
		<div id="divdiv">
			<c:if test="${loginUser.mem_mail ==dogBoardVO.mem_mail }">
				<input class="btn" type="button" value="수정"
					onClick="location.href='/world/dog/dogBoardUpdate?dsboard_posting_no=${dogBoardVO.dsboard_posting_no}'">
				<input class="btn" type="button" value="삭제"
					onClick="location.href='/world/dog/deleteDogBoard?dsboard_posting_no=${dogBoardVO.dsboard_posting_no}'">
			</c:if>
			<input class="btn" type="button" value="목록"
				onclick="location.href='<%=request.getContextPath()%>/dog/dogBoardList'">
		</div>
	</form>

	<form action="writeComm" id="writeComm" name="formm" method="post">
		<table class="table table-condensed">
			<thead>
				<tr>
					<td colspan="3"><span class="badge">댓글
							${dsBoardCommListCnt}</span></td>
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

		<!-- 댓글 영역 시작  -->
		<table class="table table-condensed" id="dscomm_go">
			<c:forEach items="${dogBoardCommList}" var="dsBoardComm"
				varStatus="status">
				<input type="hidden" id="dsboard_ans_code${status.count}"
					value="${dsBoardComm.dsboard_ans_code }">
				<tbody>
					<tr id="dsboard_ans_code${status.count}" class="dscoment">
						<%-- <td style="width:100px;text-align:center;">${ ifShrBoardComm.ifshrboard_comm_wri}</td> --%>

						<td style="width: 100px; text-align: center;">
							<button type="button" class="btn btn-default btn-xs"
								data-toggle="modal" data-target="#myModal2${status.count }">
								${ dsBoardComm.dsboard_comm_wri}</button>
						</td>

						<!-- 일단 댓글에서는 쪽지 기능  -->
						<div class="modal fade" id="myModal2${status.count }"
							role="dialog">
							<div class="modal-dialog">
								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">${ dsBoardComm.dsboard_comm_wri}
											님에게 쪽지 보내기</h4>
									</div>
									<div class="modal-body">
										<textarea class="form-control" rows="7" name="ifshrboard_cont"
											id="isboard_cont"></textarea>
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
						</div>
						<!--  -->

						<td style="width: 70%; word-break: break-all;"
							id="dsBoardComm_cont${status.count}"
							name="dsBoardComm_cont${status.count}">${ dsBoardComm.dsboard_comm_cont}
							<input type="button" value="추천" id="cc"> <input
							type="button" value="비추천" id="ccc">
						</td>
						<td>${ dsBoardComm.dsboard_comm_wridate }</td>
						<c:if test="${loginUser.mem_nick ==dsBoardComm.dsboard_comm_wri }">

							<c:set value="${dsBoardComm.dsboard_comm_cont}"
								var="dsboard_comm_cont" />
							<c:set value="${status.count}" var="indexTd" />
							<c:set value="${dsBoardComm.dsboard_ans_code}"
								var="dsboard_ans_code" />
							<c:set value="dsboard_ans_code${status.count}" var="indexTdd" />

							<td><a href="#"
								onclick="updateDsCommForm('${indexTd }', event )" id="aa">수정</a>
								/ <%-- id=${ifShrBoardComm.ifshrboard_ans_code}; --%> <a
								href="#"
								onclick="deleteDsComm('${dsboard_ans_code}','${indexTdd }',event )"
								id="aa">삭제</a></td>
							<td></td>
						</c:if>
					</tr>
				</tbody>
			</c:forEach>
		</table>
		<c:if test="${loginUser!=null}">
			<textarea rows="2" cols="150" id="dsboard_comm_contt"
				name="dsboard_comm_cont"></textarea>
			<input type="hidden" id="dsboard_posting_no"
				name="dsboard_posting_no" value="${dogBoardVO.dsboard_posting_no }">
			<input type="hidden" id="mem_nick" name="mem_nick"
				value="${loginUser.mem_nick}">
			<input type="button" value="댓글등록"
				onclick="dswriteComm_go($('#mem_nick').val(),$('#dsboard_posting_no').val(),$('#dsboard_comm_contt').val(),event)">
		</c:if>
	</form>



</article>
