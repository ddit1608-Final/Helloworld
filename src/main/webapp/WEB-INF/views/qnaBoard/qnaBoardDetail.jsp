<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/freeBoard.css">
<article>
	<div>
	<a href="<%=request.getContextPath()%>/qna/qnaBoardList.do"><img
			id="freeLogo"
			src="<%=request.getContextPath()%>/resources/images/qnaLogo.png"></a>
	</div>

	<form id="fdf" name="form" method="post">
		<table class="table .table-condensed">
			<thead>
				<tr
					style="background-color: #8bdb69; border-bottom: 2px solid #c9c9c9;">
					<th style="width: 20%;">SUBJECT</th>
					<td style="width: 50%;">${qnaBoardVO.qnaboard_title }</td>
					<c:if test="${loginUser!=null}">
					<th style="width: 10%;" onclick="qnaboardchu()">추천<input type="button" class="btn btn-success btn-xs" id=boardchu value=${qnaBoardBChuList.qnaboard_board_chu }></th>
					<th style="width: 10%;" onclick="qnaboardbchu()">/ 비추천<input type="button" class="btn btn-success btn-xs" id=boardbchu value="${qnaBoardBChuList.qnaboard_board_bchu }"></th>
					</c:if>
					<c:if test="${loginUser ==null}">
					<th style="width: 10%;" onclick="qnaboardchu()">추천<input type="button" class="btn btn-success btn-xs" id=boardchu value=${qnaBoardBChuList.qnaboard_board_chu } disabled="disabled"></th>
					<th style="width: 10%;" onclick="qnaboardbchu()">/ 비추천<input type="button" class="btn btn-success btn-xs" id=boardbchu value="${qnaBoardBChuList.qnaboard_board_bchu }" disabled="disabled"></th>
					</c:if>
					<th style="width: 10%;">조회수(${qnaBoardVO.qnaboard_hits })</th>
					

				</tr>
			</thead>

			<tr>
				<th>NAME</th>
				<td>
					<button type="button" class="btn btn-success btn-xs" data-toggle="modal" data-target="#myModal">
						${qnaBoardVO.mem_nick }</button>
				</td>
				<td colspan="2"><b>DATE</b> &nbsp;${qnaBoardVO.qnaboard_wridate }</td>
			
			 
		  	 
		      	<td>
		      	
				  <!-- Modal -->
				  <div class="modal fade" id="myModal" role="dialog">
				    <div class="modal-dialog">
				      <!-- Modal content-->
				      <div class="modal-content">
				        <div class="modal-header">
				          <button type="button" class="close" data-dismiss="modal">&times;</button>
				          <h4 class="modal-title">${qnaBoardVO.mem_nick} 님의 정보입니다.</h4>
				        </div>
				        <div class="modal-body">
				          <p>이메일:${qnaBoardVO.mem_mail} <a href="#">메일보내기</a></p>
				          <p>연락처:${qnaBoardVO.mem_phn} <a href="#">문자보내기</a> </p>
				        </div>
				        <div class="modal-footer">
				          <button type="button" class="btn btn-default btn-xs" data-dismiss="modal">Close</button>
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
				<td colspan="4">${qnaBoardVO.qnaboard_cont }</td>

			</tr>
		</table>
		<!--[8] 수정 버튼이 눌리면 상품 수정 페이지로 이동하되 현재 페이지와 상품 일련번호 값을 전달해 준다. -->
		<div id="divdiv">
			<c:if test="${loginUser.mem_mail ==qnaBoardVO.mem_mail }">
				<input class="btn" type="button" value="수정"
					onClick="location.href='/world/qna/qnaBoardUpdateForm.do?qnaboard_posting_no=${qnaBoardVO.qnaboard_posting_no}'">
				<input class="btn" type="button" value="삭제"
					onClick="location.href='/world/qna/deleteQnaBoard.do?qnaboard_posting_no=${qnaBoardVO.qnaboard_posting_no}'">
				<!--[9] 목록 버튼이 눌리면 상품 리스트 페이지로 이동하되 현재 페이지를 전달해 준다. -->
			</c:if>
			<input class="btn" type="button" value="목록"
				onclick="location.href='<%=request.getContextPath()%>/qna/qnaBoardList.do'">
		</div>
	</form>

	<form action="writeComm" id="writeComm" method="post">
		<label>댓글 테스트</label> <br />
		<table>
			<thead>
				<tr>
					<td colspan="2">댓글이 ${qnaBoardCommListCnt }개 달렸습니다.</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${qnaBoardCommList}" var="qnaBoardComm"
					varStatus="status">
					<tr>

					</tr>
					<tr>
						<td>${ qnaBoardComm.qnaboard_comm_wri}
						<input type="hidden" id="qnaboard_mail${status.count }" value="${ qnaBoardComm.qnaboard_comm_wri}"></td>
						<td>${ qnaBoardComm.qnaboard_comm_cont}</td>
						<c:forEach items="${ qnaBoardChuList }" var="qnaBoardChuList">
							<c:if
								test="${qnaBoardComm.qnaboard_ans_code == qnaBoardChuList.qnaboard_ans_code }">
							<c:if test="${loginUser != null }">
								<td onclick="chu_go('${status.count }');">추천<input
									type="button" id="chu${status.count }"
									value="${ qnaBoardChuList.qnaboard_chu }"></td>
								<td onclick="bchu_go('${status.count }');">비추천<input
									type="button" id="bchu${status.count }"
									value="${ qnaBoardChuList.qnaboard_bchu }"></td>
							</c:if>
							<c:if test="${loginUser == null }">
								<td onclick="chu_go('${status.count }');">추천<input
									type="button" id="chu${status.count }"
									value="${ qnaBoardChuList.qnaboard_chu }" disabled="disabled"></td>
								<td onclick="bchu_go('${status.count }');">비추천<input
									type="button" id="bchu${status.count }"
									value="${ qnaBoardChuList.qnaboard_bchu }" disabled="disabled"></td>
							</c:if>

								<c:if test="${empty qnaBoardChooseList.qnaboard_comm_choose }">
								<c:if test="${loginUser.mem_mail == qnaBoardVO.mem_mail }">
									<td onclick="choose_go('${status.count }')"><input
										type="button" id="cchoo${status.count}"
										value="채택"></td>
									</c:if>
								</c:if>
								<c:if
									test="${qnaBoardComm.qnaboard_ans_code == qnaBoardChooseList.qnaboard_ans_code }">
									<td>채택된글입니다.</td>
								</c:if>
							</c:if>
						</c:forEach>
						<td><input type="hidden"
							id="qnaboard_ans_code${status.count }"
							value="${qnaBoardComm.qnaboard_ans_code}"></td>
						<c:set value="${status.count }" var="indexTd" />

						<c:if
							test="${loginUser.mem_mail ==qnaBoardComm.qnaboard_comm_wri }">
							<td><a
								href="/world/qna/qnaBoardCommUpdateForm.do?qnaboard_ans_code=${qnaBoardComm.qnaboard_ans_code}">수정</a>/
								<a
								href="/world/qna/deleteqnaBoardComm.do?qnaboard_ans_code=${qnaBoardComm.qnaboard_ans_code}
								&qnaboard_posting_no=${qnaBoardVO.qnaboard_posting_no}">삭제</a>
							</td>
						</c:if>
						<td><label id="choose2${status.count }"></label></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${loginUser!=null}">
		<input type="text" id="qnaboard_comm_cont" name="qnaboard_comm_cont">
		<input type="hidden" id="qnaboard_posting_no"
			name="qnaboard_posting_no" value="${qnaBoardVO.qnaboard_posting_no }">
		<input type="hidden" id="mem_mail" name="mem_mail"
			value="${loginUser.mem_mail}">
		
	    <input type="submit" value="댓글등록">
		</c:if>
	</form>
</article>

<script>
	function chu_go(index) {
		$.ajax({
			url : "chu",
			type : "post",
			data : {
				chu : $('#chu' + index).val(),
				qnaboard_ans_code : $('#qnaboard_ans_code' + index).val(),
				mem_mail : $('#mem_mail').val()
			},
			success : function(data) {
				$('#chu' + index).val(data);
			}
		});
	}

	function bchu_go(index) {
		$.ajax({
			url : "bchu",
			type : "post",
			data : {
				bchu : $('#bchu' + index).val(),
				qnaboard_ans_code : $('#qnaboard_ans_code' + index).val(),
				mem_mail : $('#mem_mail').val()
			},
			success : function(data) {
				$('#bchu' + index).val(data);
			}
		});
	}

	function choose_go(index) {
		alert($('#qnaboard_mail' + index).val());
		$.ajax({
			url : "choose",
			type : "post",
			data : {
				choose : $('#cchoo' + index).val(),
				qnaboard_ans_code : $('#qnaboard_ans_code' + index).val(),
				mem_mail : $('#qnaboard_mail' + index).val()
			},
			success : function(data) {
				alert(data);
				alert(document.getElementById("choose2"+ index));
				if (data != null) {
					document.getElementById("choose2"+ index).innerHTML = "채택된글입니다";
				}
			}
		});
	}
	function qnaboardchu(){
		$.ajax({
			url : "boardchu",
			type : "post",
			data : {
				boardchu : $('#boardchu').val(),
				qnaboard_posting_no : $('#qnaboard_posting_no').val(),
				mem_mail : $('#mem_mail').val()
			},
			success : function(data) {
				$('#boardchu').val(data);
			}
		})
	}
	function qnaboardbchu(){
		$.ajax({
			url : "boardbchu",
			type : "post",
			data : {
				boardbchu : $('#boardbchu').val(),
				qnaboard_posting_no : $('#qnaboard_posting_no').val(),
				mem_mail : $('#mem_mail').val()
			},
			success : function(data) {
				$('#boardbchu').val(data);
			}
		})
	}
</script>
