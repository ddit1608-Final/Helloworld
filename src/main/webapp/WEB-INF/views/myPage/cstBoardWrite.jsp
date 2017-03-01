<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/cstBoard.css">
<article>

	<form id="cstWriteForm" name="cstWriteForm" method="post"
		action="cstBoardWrite">
		<input id="mem_mail" name="mem_mail" hidden="hidden"
			value="${loginUser.mem_mail}"> <input id="flow_code"
			name="flow_code" hidden="hidden" value="1">
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
						name="cstboard_counsel_title" id="cstboard_counsel_title"></td>
				</tr>
				<tr>
					<td style="text-align: left;">&nbsp;&nbsp;&nbsp;내용</td>

					<td><textarea rows="8" cols="65" name="cstboard_counsel_cont"
							id="cstboard_counsel_cont"></textarea></td>
				</tr>
			</thead>
		</table>
		<table>

		</table>
		<div id="divdiv">
			<input class="btn" type="submit" value="글쓰기"><input
				class="btn" type="button" value="메인"
				onclick="location.href='<%=request.getContextPath()%>/index'">
		</div>
	</form>
</article>
