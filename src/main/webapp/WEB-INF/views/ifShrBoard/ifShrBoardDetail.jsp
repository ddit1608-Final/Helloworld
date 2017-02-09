<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/freeBoard.css">
<article>
<div>
		<a href="<%=request.getContextPath()%>/ifShr/ifShrBoardList.do">
		<img id="freeLogo" src="<%= request.getContextPath() %>/resources/images/ifshrboard.png"></a>
	</div> 

<form id="fdf" name="form" method="post">
<table class="table .table-condensed">
  <thead>
      <tr style="background-color: #8bdb69; border-bottom:2px solid #c9c9c9;">
        <th style="width:20%;">SUBJECT</th>
        <td style="width:60%;">${ifShrBoardVO.ifshrboard_title }</td>
        <th style="width:20%;"><a href="#">추천</a>(#)/ <a href="#">비추천</a>(#)조회수(${ ifShrBoardVO.ifshrboard_hits})</th>
       
      </tr>
    </thead>
  
  	 <tr> 
	    <th>NAME</th>
	    <td>
	    	<button type="button" class="btn btn-info btn-xs" data-toggle="modal" data-target="#myModal">
	    		${ifShrBoardVO.mem_nick}</button>
	    </td>
	    <td><b>DATE</b> &nbsp;${ifShrBoardVO.ifshrboard_wridate }</td>
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
		          <h4 class="modal-title">${ifShrBoardVO.mem_nick} 님의 정보입니다.</h4>
		        </div>
		        <div class="modal-body">
		          <p>이메일:${ifShrBoardVO.mem_mail} <a href="#">메일보내기</a></p>
		          <p>연락처:01*-**${ifShrBoardVO.mem_phn}*-**** <a href="#">문자보내기</a> </p>
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
   <td colspan="3">${ifShrBoardVO.ifshrboard_cont }</td>
  
   </tr>
		</table>
	<div id="divdiv">
		<c:if test="${loginUser.mem_mail ==ifShrBoardVO.mem_mail }">
			<input class="btn" type="button" value="수정"
				onClick="location.href='/world/is/ifShrBoardUpdateForm.do?ifshrboard_posting_no=${ifShrBoardVO.ifshrboard_posting_no}'">
			<input class="btn" type="button" value="삭제"
				onClick="location.href='/world/is/deleteIfShrBoard.do?ifshrboard_posting_no=${ifShrBoardVO.ifshrboard_posting_no}'">
			<!--[9] 목록 버튼이 눌리면 상품 리스트 페이지로 이동하되 현재 페이지를 전달해 준다. -->
		</c:if>
		<input class="btn" type="button" value="목록"
			onclick="location.href='<%=request.getContextPath()%>/is/ifShrBoardList.do'">
			</div>
	</form>
	
	<form action="writeComm" id="writeComm" name="formm" method="post">
		<label>★★★★★★댓글★★★★★★</label> <br /> 
		<table class="table table-condensed">
			<thead>
				<tr>
					<td colspan="3">댓글이 ${isBoardCommListCnt }개 달렸습니다.</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="width:100px;text-align:center;" >작성자</td>
					<td style="width:800px;text-align:center;">내용</td>
					<td style="width:200px;text-align:center;">작성날짜</td>
					<td></td>
				</tr>
			</tbody>
			</table>
			
			<!-- 댓글 영역 시작  -->
			<table class="table table-condensed" id="iscomm_go">
				<c:forEach items="${isBoardCommList}" var="ifShrBoardComm" varStatus="status" >
					<input type="hidden" id="ifshrboard_ans_code${status.count}" value="${ifShrBoardComm.ifshrboard_ans_code }">
					<tbody>
					<tr id="ifshrboard_ans_code${status.count}" class="iscoment">
						<%-- <td style="width:100px;text-align:center;">${ ifShrBoardComm.ifshrboard_comm_wri}</td> --%>
						
						<td style="width:100px;text-align:center;">
						<button type="button" class="btn btn-default btn-xs" data-toggle="modal" data-target="#myModal2">
	    					${ ifShrBoardComm.ifshrboard_comm_wri}</button></td>
	    					
	    				<!-- 일단 댓글에서는 쪽지 기능  -->
	    				 <div class="modal fade" id="myModal2" role="dialog">
						    <div class="modal-dialog">
						      <!-- Modal content-->
						      <div class="modal-content">
						        <div class="modal-header">
						          <button type="button" class="close" data-dismiss="modal">&times;</button>
						          <c:set value="${ifShrBoardCommVO.getIfshrboard_comm_wri}" var="ifshrboard_comm_wri"/>
						          <h4 class="modal-title"> ifshrboard_comm_wri 님에게 쪽지 보내기</h4>
						        </div>
						        <div class="modal-body">
						          	<textarea class="form-control" rows="7" name="ifshrboard_cont" id="isboard_cont"></textarea>
						        	<input type="button" class="btn btn-default btn-xs" value="쪽지전송">
						        	<input type="button" class="btn btn-default btn-xs" value="취소">
						        </div>
						        <div class="modal-footer">
						          <button type="button" class="btn btn-default btn-xs" data-dismiss="modal">Close</button>
						        </div>
						      </div>
						    </div>
						    </div>	
						 <!--  -->  
						 
						<td style="width:70%;  word-break:break-all;" id="isBoardComm_cont${status.count}" name="isBoardComm_cont${status.count}">${ ifShrBoardComm.ifshrboard_comm_cont}
						<input type="button" value="추천" id="cc">
						<input type="button" value="비추천" id="ccc"></td>
						<td>${ ifShrBoardComm.ifshrboard_comm_wridate }</td>
						<c:if test="${loginUser.mem_nick ==ifShrBoardComm.ifshrboard_comm_wri }">
						
						<c:set value="${ifShrBoardComm.ifshrboard_comm_cont}" var="ifshrboard_comm_cont"/>
						<c:set value="${status.count}" var="indexTd"/>
						<c:set value="${ifShrBoardComm.ifshrboard_ans_code}" var="ifshrboard_ans_code"/>
						<c:set value="ifshrboard_ans_code${status.count}" var="indexTdd"/>
						
						<td>
							<a href="#" onclick="updateIsCommForm('${indexTd }', event )" id="updateIs">수정</a>
						/
						<%-- id=${ifShrBoardComm.ifshrboard_ans_code}; --%>
							<a href="#" onclick="deleteIsComm('${ifshrboard_ans_code}','${indexTdd }',event )"id="deleteIs">삭제</a>
						</td>
						<td></td>
						</c:if>
					</tr>
				</tbody>
				</c:forEach>
		</table>
		<c:if test="${loginUser!=null}">
		<textarea rows="2" cols="150" id="ifshrboard_comm_contt" name="ifshrboard_comm_cont"></textarea>
		<input type="hidden" id="ifshrboard_posting_no" name="ifshrboard_posting_no" value="${ifShrBoardVO.ifshrboard_posting_no }">
		<input type="hidden" id="mem_nick" name="mem_nick" value="${loginUser.mem_nick}">
		<input type="button" value="댓글등록" onclick="iswriteComm_go($('#mem_nick').val(),$('#ifshrboard_posting_no').val(),$('#ifshrboard_comm_contt').val(),event)">
		</c:if>
	</form>
	 
	
		
</article>
