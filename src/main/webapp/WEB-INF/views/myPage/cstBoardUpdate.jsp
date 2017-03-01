<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/cstBoard.css">
<article>

	<form id="cstUpdateForm" name="cstUpdateForm" method="post"
		action="cstBoardUpdate">
		<input id="Cstboard_counsel_posting_no"
			name="Cstboard_counsel_posting_no" hidden="hidden"
			value="${cstBoardVO.cstboard_counsel_posting_no }"> <input
			id="mem_mail" name="mem_mail" hidden="hidden"
			value="${loginUser.mem_mail}">
		<table class="table .table-condensed" id="bwt">
			<thead>
				<tr style="border-bottom: 1px solid #c9c9c9;">
					<td style="width: 20%;">작성자 ${loginUser.mem_nm}</td>
					<td style="width: 10%;"></td>
					<td style="width: 10%;"></td>
					<td style="width: 10%;"></td>
				</tr>
				<tr>
					<td style="text-align: center;">제목 <input type="text"
						name="cstboard_counsel_title" id="cstboard_counsel_title"
						value="${cstBoardVO.cstboard_counsel_title }"></td>
					<td style="text-align: center;">상태 <select id=flow_code
						name="flow_code">

							<c:choose>
								<c:when test="${cstBoardVO.flow_code == 1}">
									<c:forEach var="flow_code" items="${flowList }"
										varStatus="status">
										<c:if test="${flow_code.flow_code == 1}">
											<option value="${flow_code.flow_code }">${flow_code.flow_cont }</option>
										</c:if>
									</c:forEach>
								</c:when>
								<c:when test="${cstBoardVO.flow_code == 3}">
									<c:forEach var="flow_code" items="${flowList }"
										varStatus="status">
										<c:if test="${flow_code.flow_code == 3 || flow_code.flow_code == 4 || flow_code.flow_code == 5}">
											
											<option value="${flow_code.flow_code }"
												<c:if test="${status.count == cstBoardVO.flow_code}"></c:if>
											>${flow_code.flow_cont }</option>
										</c:if>
									</c:forEach>
								</c:when>
								<c:when test="${cstBoardVO.flow_code == 4}">
									<c:forEach var="flow_code" items="${flowList }"
										varStatus="status">
										<c:if test="${flow_code.flow_code == 4}">
											<option value="${flow_code.flow_code }">${flow_code.flow_cont }</option>
										</c:if>
									</c:forEach>
								</c:when>
								
							</c:choose>



					</select></td>
				</tr>
				<tr>
					<td style="text-align: left;">&nbsp;&nbsp;&nbsp;내용</td>

					<td><textarea rows="8" cols="65" name="cstboard_counsel_cont"
							id="cstboard_counsel_cont">${cstBoardVO.cstboard_counsel_cont }</textarea></td>
				</tr>
			</thead>
		</table>
		<table>

		</table>
		<div id="divdiv">
			<input class="btn" type="submit" value="수정하기"><input
				class="btn" type="button" value="메인"
				onclick="location.href='<%=request.getContextPath()%>/index'">
		</div>
	</form>
</article>
