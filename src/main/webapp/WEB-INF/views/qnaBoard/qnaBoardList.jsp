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
				<c:forEach items="${notiList}" var="notice" varStatus="status">
					<tr style="text-align: center; border-bottom:2px solid gray; font-size:15pt;">
						<td>${notice.notice_id } 
						</td>
						<td colspan="2">
							<a href="#" data-toggle="modal" data-target="#myModal${status.count}">${notice.notice_title }
							<span class="label label-danger">필독</span></a></td>
						<td colspan="2">
						<fmt:formatDate value="${notice.notice_wridate}" pattern="yyyy-MM-dd"/></td>
						<td colspan="2">${notice.mem_nick }</td>
					</tr>
					<!-- modal 영역 -->
			<div class="modal fade" id="myModal${status.count}" role="dialog">
						<div class="modal-dialog">
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title" style="text-align: center; font-size: 20pt;font-weight: bold;">
									[필독]${notice.notice_id}. ${notice.notice_title }
									</h4>
								</div>
								<div class="modal-body">
									<span style="font-family: 한나; font-size: 15pt;">
										<hr style="border:none;border:5px double gray;"/>
										<c:if test="${loginUser.mem_mail ne 'admin' }">
										<textarea id="notice_cont${status.count }" name="notice_cont${status.count }" readonly="readonly" rows="13" style="width: 100%;border:0;background:clear;">${notice.notice_cont }</textarea>
										</c:if>
										<c:if test="${loginUser.mem_mail eq 'admin' }">
										<%-- <textarea id="notice_cont${status.count }" name="notice_cont${status.count }" rows="13" style="width: 100%;border:0;background:clear;">${notice.notice_cont }</textarea> --%>
										<div id="notice_cont${status.count }">
										${notice.notice_cont }									
										</div>
										
										</c:if>
										<c:set value="${notice.notice_cont}" var="notice_cont"/>
										<c:set value="${notice.notice_id}" var="notice_id"/>
										<c:set value="${status.count }" var="idea"/>
										<c:set value="notice_id${status.count }" var="idex"/>
										
										<br/>
										<hr style="border:none;border:5px double gray;"/>
										<i class="fa fa-user-circle" style="font-size:36px"></i>${notice.mem_nick } 올림
									</span>
									<span id="btnArea">
									<c:if test="${loginUser.mem_mail eq 'admin' }">
										<input type="button" class="btn btn-default btn-xs" value="수정" onclick="update_go_qna('${idea}',event);">
										<input type="button" class="btn btn-default btn-xs" value="삭제" onclick="noti_del();">
									</c:if>
									</span>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default btn-xs"
										data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
			</c:forEach>



			<!-- modal 영역 -->
			<tr
				style="background-color: gray; font-size: 15pt; color: white; font-family:;">
				<td style="text-align: center; width:7%;">번호</td>
				<td style="text-align: center; width:50%;">제목</td>
				<!-- <th>내용</th> -->
				<td style="text-align: center; width:8%;">닉네임</td>
				
				<!-- <th>작성자</th> -->
				<td style="text-align: center; width:8%;">날짜</td>
				<td style="text-align: center; width:8%;">추천</td>
				<td style="text-align: center; width:8%;">비추천</td>
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
				<td>
					<c:if test="${loginUser !=null }">
					<input type="button" class="btn btn-success btn-sm"
					value="글쓰기"
					onclick="location.href='<%=request.getContextPath()%>/qna/qnaBoardWriteForm.do'">
					</c:if>
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

function update_go_qna(idea,event){
	event.preventDefault();
	var notice_cont = $('#notice_cont'+idea).text();
	var arr = {
		"notice_cont" : notice_cont,
	};
	$.ajax({
			url : "qnaBoardList.do",
			type : "post",
			data : arr,
			success : function(data) {
				$('#notice_cont'+ idea).html(
						'<textarea id="notice_cont" name="notice_cont" rows="13" style="width: 100%;border:0;background:clear;">'
						+ notice_cont
						+ '</textarea>'
						+ '<input type="button" value="완료" onclick="update_noti_meet('+idea+',event)" id="remo">');
				},
				error : function(error) {

				}
			})
}

function update_noti_qna(idea,event){
	event.preventDefault();
	var notice_id = JSON.stringify(idea);
	var notice_cont = $('#notice_cont').val();
	
	alert("수정될 공지사항 넘버"+notice_id);
	alert("수정될 공지사항 내용"+notice_cont);
	var arr = {
			"notice_id" : notice_id,
			"notice_cont" : notice_cont
		};
	$.ajax({
		url : "noticeUpdate",
		type : "post",
		data : arr,
		success : function(data) {
			$('#remo').remove();
			$('#notice_cont'+idea).html(data);
		},
		error : function(error) {
			alert('실패');
		}
	})
	}
</script>
