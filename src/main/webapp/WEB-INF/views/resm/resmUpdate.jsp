<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<article>
	<h2>자유게시판</h2>
	<h3>자유게시판 수정입니다</h3>
	<form name="form" method="post" action="resmUpdate.do">
		<input type="hidden" value="${resmVO.resm_id}"
			name="resm_id">
		<table id="list">
			<tr>
				<th>이메일</th>
				<td><input type="text" value="${resmVO.mem_mail }" name="mem_mail"></td>
			</tr>
			<tr>
				<th>취미</th>
				<td><input type="text" value="${resmVO.resm_hob }" name="resm_hob"></td>
			</tr>
			<tr>
				<th>주민등록번호</th>
				<td><input type="text" value="${resmVO.resm_regno }" name="resm_regno"></td>
			</tr>
			<tr>
				<th>병역</th>
				<td><input type="text" value="${resmVO.milt_code }" name="milt_code"></td>
			</tr>
			<tr>
				<th>취미</th>
				<td><input type="text" value="${resmVO.resm_hob }" name="resm_hob"></td>
			</tr>
			<tr>
				<th>특기</th>
				<td><input type="text" value="${resmVO.resm_like }" name="resm_like"></td>
			</tr>
			<tr>
				<th>사진</th>
				<td><input type="text" value="${resmVO.idpic_code }" name="idpic_code"></td>
			</tr>
			<tr>
				<th>자격증</th>
				<td><input type="text" value="${resmVO.lcse_code }" name="lcse_code"></td>
			</tr>
			<tr>
				<th>학력</th>
				<td><input type="text" value="${resmVO.acdmcr_code }" name="acdmr_code"></td>
			</tr>
		</table>
		<input class="btn"  type="submit" value="수정" >
	</form>
</article>