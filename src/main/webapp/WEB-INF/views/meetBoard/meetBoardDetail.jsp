<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/freeBoard.css">
<article>
<div>
		<a href="<%=request.getContextPath()%>/free/freeBoardList.do"><img id="freeLogo" src="<%= request.getContextPath() %>/resources/images/freeboard3.png"></a>
	</div> 
	
<form id="fdf" name="form" method="post">
<table class="table .table-condensed">
  <thead>
      <tr style="background-color: #8bdb69; border-bottom:2px solid #c9c9c9;">
        <th style="width:20%;">SUBJECT</th>
        <td style="width:60%;">${meetBoardVO.meet_board_title }</td>
        <%-- <th style="width:20%;"><a href="#">추천</a>(#)/ <a href="#">비추천</a>(#)조회수(${ meetBoardVO.meet_board_hits})</th> --%>
       
      </tr>
    </thead>
  
  	 <tr>
  	 	<th>NAME</th> 
	    <td>
	    	<button type="button" class="btn btn-info btn-xs" data-toggle="modal" data-target="#myModal">
	    	${meetBoardVO.mem_nick}</button>
	    </td>
	    <td><b>DATE</b> &nbsp;${meetBoardVO.meet_board_wri_date }</td>
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
		          <h4 class="modal-title">${meetBoardVO.mem_mail} 님의 정보입니다.</h4>
		        </div>
		        <div class="modal-body">
		          <p>이메일:${meetBoardVO.mem_mail} <a href="#">메일보내기</a></p>
		          <p>연락처:${meetBoardVO.mem_phn} <a href="#">문자보내기</a> </p>
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
   		<td colspan="3">${meetBoardVO.meet_board_cont }</td>
   	</tr>
</table>
	<div id="divdiv">
		<c:if test="${loginUser.mem_mail ==meetBoardVO.mem_mail }">
			<input class="btn" type="button" value="수정"
				onClick="location.href='/world/meet/meetBoardUpdateForm.do?meetboard_posting_no=${meetBoardVO.meet_board_posting_no}'">
			<input class="btn" type="button" value="삭제"
				onClick="location.href='/world/meet/deleteMeetBoard.do?meet_board_posting_no=${meetBoardVO.meet_board_posting_no}'">
			<!--[9] 목록 버튼이 눌리면 상품 리스트 페이지로 이동하되 현재 페이지를 전달해 준다. -->
		</c:if>
		<input class="btn" type="button" value="목록"
			onclick="location.href='<%=request.getContextPath()%>/free/freeBoardList.do'">
			</div>
	</form>
	<!-- 댓글 -->
	<form action="writeComm" id="writeComm" name="formm" method="post">
		<table class="table table-condensed">
			<thead>
				<tr>
					<td colspan="3"><span class="badge">댓글  ${meetBoardCommListCnt}</span></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="width:100px">작성자</td>
					<td style="width:1000px">내용</td>
					<td style="width:200px">작성날짜</td>
					<td style="width:90px">비고</td>
				</tr>
			</tbody>
			</table>
			<table class="table table-condensed" id="meetcomm_go">
				
				<c:forEach items="${meetBoardCommList}" var="meetBoardComm" varStatus="status">
				<input type="hidden" id="meet_board_ans_code${status.count}" value="${meetBoardComm.meet_board_ans_code }">
				<tbody>
					<tr id="meet_board_ans_code${status.count}" class="meetcoment">
						<td style="width:100px;text-align:center;">
						<button type="button" class="btn btn-default btn-xs" data-toggle="modal" data-target="#myModal2">
	    					${ meetBoardComm.meet_board_comm_wri}</button></td>
	    					
	    				<!-- 일단 댓글에서는 쪽지 기능  -->
	    				 <div class="modal fade" id="myModal2" role="dialog">
						    <div class="modal-dialog">
						      <!-- Modal content-->
						      <div class="modal-content">
						        <div class="modal-header">
						          <button type="button" class="close" data-dismiss="modal">&times;</button>
						          <c:set value="${meetboardCommVO.getMeet_board_comm_wri}" var="meet_board_comm_wri"/>
						          <h4 class="modal-title"> meetboard_comm_wri 님에게 쪽지 보내기</h4>
						        </div>
						        <div class="modal-body">
						          	<textarea class="form-control" rows="7" name="meet_board_cont" id="meet_board_cont"></textarea>
						        	<input type="button" class="btn btn-default btn-xs" value="쪽지전송">
						        	<input type="button" class="btn btn-default btn-xs" value="취소">
						        </div>
						        <div class="modal-footer">
						          <button type="button" class="btn btn-default btn-xs" data-dismiss="modal">Close</button>
						        </div>
						      </div>
						    </div>
						    </div>
						    <!-- 쪽지 모달 끝 -->
						    <td style="width:70%;  word-break:break-all;" id="meet_BoardComm_cont${status.count}" name="meetBoardComm_cont${status.count}">
						    	${ meetBoardComm.meet_board_comm_cont}
							<input type="button" value="추천">
							<input type="button" value="비추천"></td>
							<td>${ meetBoardComm.meet_board_comm_wridate }</td>
							<c:if test="${loginUser.mem_nick ==meetBoardComm.meet_board_comm_wri }">
							
							<c:set value="${meetBoardComm.meet_board_comm_cont}" var="meet_board_comm_cont"/>
							<c:set value="${status.count}" var="indexTd"/>
							<c:set value="${meetBoardComm.meet_board_ans_code}" var="meet_board_ans_code"/>
							<c:set value="meet_board_ans_code${status.count}" var="indexTdd"/>
							
							<td>
								<a href="#" onclick="updateMeetCommForm('${indexTd }','${indexTd }', event )" id="aa">수정</a>
							/
							<%-- id=${ifShrBoardComm.ifshrboard_ans_code}; --%>
								<a href="#" onclick="deleteMeetComm('${meet_board_ans_code}','${indexTdd }',event )"id="aa">삭제</a>
							</td>
							<td></td>
							</c:if>
						</tr>	
				</tbody>
				</c:forEach>
		</table>
		<c:if test="${loginUser!=null}">
		<textarea rows="2" cols="150" id="meet_board_comm_contt" name="meet_board_comm_cont"></textarea>
		<input type="hidden" id="meet_board_posting_no" name="meet_board_posting_no" value="${meetBoardVO.meet_board_posting_no }">
		<input type="hidden" id="mem_nick" name="mem_nick" value="${loginUser.mem_nick}">
		<input type="button" value="댓글등록" onclick="meetWriteComm_go($('#mem_nick').val(),$('#meet_board_posting_no').val(),$('#meet_board_comm_contt').val(),'${indexTd}','${indexTdd}',event)">
		</c:if>
		</div> <!-- result div  -->
	</form>
	
	
	
	
	
	
	
	</article>
	