<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<article>
	<div>
		<c:if test="${param.result != null }">
			<c:if test="${param.result == 'pwMismatch' }">
				<script>
					alert("패스워드가 일치 하지 않습니다.");
				</script>
			</c:if>
		</c:if>

		<form action="main" method="post">
			<label>관리자 패스워드</label> <input type="password" name="admin_pw">
			<input type="submit">
		</form>

	</div>
</article>
