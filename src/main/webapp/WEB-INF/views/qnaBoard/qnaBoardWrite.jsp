<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/freeBoard.css">
<article>
	<div>
		<a href="<%=request.getContextPath()%>/qna/qnaBoardList.do"><img
			id="freeLogo"
			src="<%=request.getContextPath()%>/resources/images/qnaLogo.png"></a>
	</div>

	<form id="fdf" name="form" method="post" action="qnaBoardWrite.do">
		<input type="hidden" name="mem_mail" value="${loginUser.mem_mail }">
		<table class="table .table-condensed" id="bwt">
			<thead>
				<tr style="border-bottom: 1px solid #c9c9c9;">
					<td style="width: 20%;">작성자 ${loginUser.mem_nick}</td>
					<td style="width: 60%; float: left;">비밀번호 <input
						type="password" name="qnaboard_pwd"></td>
					<td style="width: 10%;"></td>
					<td style="width: 10%;"></td>
					<td style="width: 10%;"></td>
				</tr>
				<tr>
					<td style="text-align: center;">제목 <input type="text"
						name="qnaboard_title"></td>
				</tr>
				<tr>
					<td style="text-align: left;">&nbsp;&nbsp;&nbsp;내용</td>

					<td><textarea rows="8" cols="65" name="qnaboard_cont"></textarea>
					</td>
				</tr>
			</thead>
		</table>
		<table>

		</table>
		<div id="divdiv">
			<input class="btn" type="submit" value="글쓰기"> <input
				class="btn" type="reset" value="취소"> <input class="btn"
				type="button" value="메인"
				onclick="location.href='<%=request.getContextPath()%>/index'">
		</div>
	</form>
</article>
