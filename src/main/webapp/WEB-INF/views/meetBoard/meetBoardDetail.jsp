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
				onClick="location.href='/world/free/freeBoardUpdateForm.do?freeboard_posting_no=${meetBoardVO.meet_board_posting_no}'">
			<input class="btn" type="button" value="삭제"
				onClick="location.href='/world/free/deleteFreeBoard.do?freeboard_posting_no=${meetBoardVO.meet_board_posting_no}'">
			<!--[9] 목록 버튼이 눌리면 상품 리스트 페이지로 이동하되 현재 페이지를 전달해 준다. -->
		</c:if>
		<input class="btn" type="button" value="목록"
			onclick="location.href='<%=request.getContextPath()%>/free/freeBoardList.do'">
			</div>
	</form>
	</article>
	