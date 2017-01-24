<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<article>
	 <h2> 자유게시판 </h2>
	 <h3> 자유롭게...머문자리는 아름답게</h3> 
	<form name="formm" method="post">
		<table id="cartList">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th>등록일</th>
			</tr>
			<c:forEach items="${freeBoardList}" var="freeBoardVO">
				<tr>
					<td>${freeBoardVO.freeboard_posting_no}</td>
					<td>${freeBoardVO.freeboard_title}</td>
					<td>${freeBoardVO.freeboard_cont}</td>
					<td>${freeBoardVO.mem_mail}</td>
					<td>
					<fmt:formatDate value="${freeBoardVO.freeboard_wridate}" type="date" /></td>
				</tr>
			</c:forEach>
		</table>
	<!-- 	<input type="button" name="test" value="확인해보자" onclick="test_go(this.form)">
		<script type="text/javascript">
		function test_go(form){
		alert(freeBoardVO.freeboard_posting_no);
		} -->
		</script>
		<div class="clear"></div>
		<div id="buttons" style="float: right">
			<input type="button" value="글쓰기" class="submit"
				onclick="location.href='<%=request.getContextPath()%>/free/freeBoardWriteForm.do'">
			<input type="button" value="메인" class="cancel"
				onclick="location.href='<%=request.getContextPath()%>/index2.jsp'">
		</div>
	</form>
</article>
