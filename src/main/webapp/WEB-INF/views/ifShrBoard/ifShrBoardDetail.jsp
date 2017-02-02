<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/freeBoard.css">
<article>
<div>
		<a href="<%=request.getContextPath()%>/ifShr/ifShrBoardList.do"><img id="freeLogo" src="<%= request.getContextPath() %>/resources/images/ifshrboard.png"></a>
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
	    <td>${ifShrBoardVO.mem_nick }</td>
	    <td><b>DATE</b> &nbsp;${ifShrBoardVO.ifshrboard_wridate }</td>
	    
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
			onclick="location.href='<%=request.getContextPath()%>/ifShrBoard/ifShrBoardList.do'">
			</div>
	</form>
	
	<form action="writeComm" id="writeComm" name="formm" method="post">
		<div id="div1">
		<label>★★★★★★댓글★★★★★★</label> <br /> 
		<table class="table table-condensed">
			<thead>
				<tr>
					<td colspan="3">댓글이 ${freeBoardCommListCnt }개 달렸습니다.</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="width:100px">작성자</td>
					<td style="width:800px">내용</td>
					<td style="width:200px">작성날짜</td>
					<td></td>
				</tr>
				<c:forEach items="${ifShrBoardCommList}" var="ifShrBoardComm">
					<tr id="commBody">
						<td style="width:13%;">${ ifShrBoardComm.ifshrboard_comm_wri}</td>
						<td style="width:70%;" id="add">${ ifShrBoardComm.ifshrboard_comm_cont}</td>
						<td style="float:left; width:100%;">
						<input type="button" value="추천">
						<input type="button" value="비추천"></td>
						<td>${ ifShrBoardComm.ifshrboard_comm_wridate }</td>
						<c:if test="${loginUser.mem_mail ==ifShrBoardComm.ifshrboard_comm_wri }">
						<td>
							<a href="#" id="div1hide">수정</a>
						/
							<a href="/world/is/deleteifShrBoardComm.do?freeboard_ans_code=${ifShrBoardComm.ifshrboard_ans_code}
								&freeboard_posting_no=${ifShrBoardVO.ifshrboard_posting_no}">삭제</a>
						</td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div> <!-- div1 종료  -->
	</form>
		
</article>
