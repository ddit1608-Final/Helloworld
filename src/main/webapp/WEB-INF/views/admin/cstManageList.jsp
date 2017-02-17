<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/freeBoard.css">
<article>
	<div class="container">
		<h3 class="text-center">컨설팅 게시물</h3>

		<form class="form-inline" action="memberManage" id="memberSearch"
			method="get">
			<div class="form-group">
				<label for="pwd">Member ID(E-MAIL) :</label> <input type="text"
					class="form-control" id="key" name="key">
			</div>
			<input type="submit" class="btn btn-default" value="Search">
		</form>


		<table id="memberList" class="table table-striped">
			<thead>
				<tr>
					<th>NO</th>
					<th>STATUS</th>
					<th>ID</th>
					<th>TITLE</th>
					<th>DATE</th>
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
								<td class="phone">${cstVO.cstboard_counsel_wridate}</td>
								
							</tr>
						</c:forEach>
						<tr>
							<td colspan="5" style="text-align: center;">${paging}</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>


	</div>
</article>