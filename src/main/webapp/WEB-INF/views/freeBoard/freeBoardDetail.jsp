<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/freeBoard.css">
<article>
<div>
		<a href="<%=request.getContextPath()%>/free/freeBoardList.do"><img id="freeLogo" src="<%= request.getContextPath() %>/resources/images/freeboard.png"></a>
	</div> 

<form id="fdf" name="form" method="post">
<table class="table .table-condensed">
  <thead>
      <tr style="background-color: #8bdb69; border-bottom:2px solid #c9c9c9;">
        <th style="width:20%;">SUBJECT</th>
        <td style="width:60%;">${freeBoardVO.freeboard_title }</td>
        <th style="width:20%;"><a href="#">추천</a>(#)/ <a href="#">비추천</a>(#)조회수(${ freeBoardVO.freeboard_hits})</th>
       
      </tr>
    </thead>
  
  	 <tr> 
	    <th>NAME</th>
	    <td>${freeBoardVO.mem_nick }</td>
	    <td><b>DATE</b> &nbsp;${freeBoardVO.freeboard_wridate }</td>
	    
  	 </tr>
 		 
  
  
    
  <tr>
  <th>CONTENT</th>
   <td></td>
  <td></td>
   
  </tr>
  <tr>
   <td colspan="3">${freeBoardVO.freeboard_cont }</td>
  
   </tr>
  	<%-- <c:forEach items="${freeBoardList}" var="freeBoardVO">
	  <tr>
	 	<td>댓글작성자 | ${freeBoardVO.mem_nick }</td> 
	 	<td>댓글내용 | ${freeBoardVO.freeboard_comm_cont }</td> 
	 	<td>작성날짜 | ${freeBoardVO.freeboard_wri_date }</td> 
	  </tr>
	</c:forEach> --%>
		</table>
		<!--[8] 수정 버튼이 눌리면 상품 수정 페이지로 이동하되 현재 페이지와 상품 일련번호 값을 전달해 준다. -->
	<div id="divdiv">
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
		<div id="result">
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
				<c:forEach items="${freeBoardCommList}" var="freeBoardComm">
					<tr id="commBody">
						<td style="width:13%;">${ freeBoardComm.freeboard_comm_wri}</td>
						<td style="width:70%;" id="add">${ freeBoardComm.freeboard_comm_cont}</td>
						<td style="float:left; width:100%;">
						<input type="button" value="추천">
						<input type="button" value="비추천"></td>
						<td>${ freeBoardComm.freeboard_comm_wridate }</td>
						<c:if test="${loginUser.mem_nick ==freeBoardComm.freeboard_comm_wri }">
						<td><%-- <a href="/world/free/freeBoardCommUpdateForm.do?freeboard_ans_code=${freeBoardComm.freeboard_ans_code}">수정</a> --%>
							<a href="#" id="div1hide">수정</a>
						/
							<a href="/world/free/deleteFreeBoardComm.do?freeboard_ans_code=${freeBoardComm.freeboard_ans_code}
								&freeboard_posting_no=${freeBoardVO.freeboard_posting_no}">삭제</a>
						</td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div> <!-- div1 종료  -->
		<div id="div2" style="display:none">
			<label>★★★★★★댓글★★★★★★</label> <br /> 
		<table>
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
				<c:forEach items="${freeBoardCommList}" var="freeBoardComm">
					<tr>
						<c:if test="${loginUser.mem_mail ==freeBoardComm.freeboard_comm_wri }">
						<td>${ freeBoardComm.freeboard_comm_wri}</td>
						<td>
						<%-- <textarea rows="6" cols="45" value=${ freeBoardComm.freeboard_comm_cont}></textarea> --%>
						<input type="text" id="commCont" name="commCont" size="100" height="30" value="${ freeBoardComm.freeboard_comm_cont}">
						</td>
						<td>${ freeBoardComm.freeboard_comm_wridate }</td>
						<td><a href="/world/free/freeBoardCommUpdateForm.do?freeboard_posting_no=${freeBoardVO.freeboard_posting_no}&freeboard_ans_code=${freeBoardComm.freeboard_ans_code}
							&freeboard_comm_cont=${freeboardComm.freeboard_comm_cont}" id="div2hide" onclick="freeBoardCommUpdateForm.do">수정하기</a>/
							<a href="/world/free/freeBoardDetail.do?freeboard_posting_no=${freeBoardVO.freeboard_posting_no}">수정취소</a>
						</td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div> <!-- div2 종료  -->
		<c:if test="${loginUser!=null}">
		<textarea rows="2" cols="150" id="freeboard_comm_cont" name="freeboard_comm_cont"></textarea>
		<input type="hidden" id="freeboard_posting_no" name="freeboard_posting_no" value="${freeBoardVO.freeboard_posting_no }">
		<input type="hidden" id="mem_nick" name="mem_nick" value="${loginUser.mem_nick}">
		<input type="button" value="댓글등록" onclick="writeComm_go(this.formm)">
		</c:if>
		</div> <!-- result div  -->
	</form>
		
</article>
