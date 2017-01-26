<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<article>
	<h1>게시글 상세보기</h1>
	<form name="form" method="post">
		<table id="list">
			<tr>
				<th>제목</th>
				<td>${freeBoardVO.freeboard_title }</td>
			</tr>
			<tr>
				<th>작성날짜</th>
				<td>${freeBoardVO.freeboard_wridate }</td>
				<th>작성자</th>
				<td>${freeBoardVO.mem_nick }</td>
			</tr>

			<tr>
				<th>내용</th>
				<td>${freeBoardVO.freeboard_cont }</td>
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
		<c:if test="${loginUser.mem_mail ==freeBoardVO.mem_mail }">
			<input class="btn" type="button" value="수정"
				onClick="location.href='/world/free/freeBoardUpdateForm.do?freeboard_posting_no=${freeBoardVO.freeboard_posting_no}'">
			<input class="btn" type="button" value="삭제"
				onClick="location.href='/world/free/deleteFreeBoard.do?freeboard_posting_no=${freeBoardVO.freeboard_posting_no}'">
			<!--[9] 목록 버튼이 눌리면 상품 리스트 페이지로 이동하되 현재 페이지를 전달해 준다. -->
		</c:if>
		<input class="btn" type="button" value="목록"
			onclick="location.href='<%=request.getContextPath()%>/free/freeBoardList.do'">
	</form>
	
	<form action="writeComm" id="writeComm" method="post">
		<label>댓글 테스트</label> <br /> 
		<table>
			<thead>
				<tr>
					<td colspan="2">댓글이 ${freeBoardCommListCnt }개 달렸습니다.</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${freeBoardCommList}" var="freeBoardComm">
					<tr>
						<td>${ freeBoardComm.freeboard_comm_wri}</td>
						<td>${ freeBoardComm.freeboard_comm_cont}</td>
					<tr>
				</c:forEach>
			</tbody>
		</table>
		
		
		<input type="text" id="freeboard_comm_cont" name="freeboard_comm_cont">
		<input type="hidden" id="freeboard_posting_no" name="freeboard_posting_no" value="${freeBoardVO.freeboard_posting_no }">
		<input type="hidden" id="mem_mail" name="mem_mail" value="${loginUser.mem_mail}">
		<input type="submit" value="댓글등록">
	</form>
</article>