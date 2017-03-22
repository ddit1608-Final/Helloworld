<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/freeBoard.css">
<style>
#memberList tr:hover{
background-color: #abe693;
}
*{
font-family:한나;
}
.container{
width:100%;
}
label{
font-size:13pt;
}
#nonhover:hover{
background-color: #c1c1c1 !important;
}
#nonhover{
background-color: #c1c1c1;
}
#memberList td{
font-size:13pt;
}
#th{
font-size:16pt !important;
}
#paging:hover{
background-color: white !important;
}
</style>
<article>
	<div class="container">
		<h1 class="text-center">컨설팅 게시물 관리</h1>
		<hr>

		<!-- <form style="margin-left:70%;" class="form-inline" action="memberManage" id="memberSearch"
			method="get">
			<div class="form-group">
				<label for="pwd">회원 이메일 :</label> 
				<input type="text" class="form-control" id="key" name="key">
			</div>
			<input type="submit" class="btn btn-default" value="검색">
		</form> -->
		<hr>

		<table id="memberList" class="table table-striped">
			<thead>
				<tr id="nonhover">
					<td id="th">번호</td>
					<td id="th">상태</td>
					<td id="th">이메일</td>
					<td id="th">제목</td>
					<td id="th">날짜</td>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${cstListSize<=0}">
						<tr>
							<td width="100%" colspan="5" align="center" height="23">
								There are no registered cstBoard.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${cstList}" var="cstVO" varStatus="status">
							<tr>
								<td>${cstVO.cstboard_counsel_posting_no }</td>
								<td class="name"><c:forEach var="flow" items="${flowList }"
										varStatus="status">
										<c:if test="${status.count == cstVO.flow_code}">
											${flow.flow_cont }
										<c:if test="${cstVO.flow_code == '1'}">
											<button onclick="cstStart('${cstVO.cstboard_counsel_posting_no }');">진행</button>
										</c:if>
										</c:if>
									</c:forEach></td>
								<td class="id">${cstVO.mem_mail}</td>
								<td class="email"><a
									href="<%=request.getContextPath()%>/admin/CstBoardDetail?cstboard_counsel_posting_no=${cstVO.cstboard_counsel_posting_no}">${cstVO.cstboard_counsel_title}</a></td>
								<td class="phone"><fmt:formatDate value="${cstVO.cstboard_counsel_wridate}" pattern="yyyy-MM-dd  HH시 mm분"/> </td>
								
							</tr>
						</c:forEach>
						<tr id="paging">
							<td colspan="5" style="text-align: center;">${paging}</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>


	</div>
</article>
