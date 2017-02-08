<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<article>
	<div>
		<h1>Admin MAIN</h1>
		<hr><br>
		<button onclick="location.href='<%=request.getContextPath()%>/admin/memberManage'">회원관리</button>
	</div>
</article>
