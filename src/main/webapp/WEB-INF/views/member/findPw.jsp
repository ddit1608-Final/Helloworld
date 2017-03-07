<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/signup.css">


<div style="margin-left:38%; margin-top:5%;">
	<h1>패스워드 찾기</h1><hr style="width:28%; margin-left:-2%;">
	<form action="findPw" id="findPw" method="post" style="margin-left:-8%;">
		<label>이메일(ID) : </label>
		<input type="email" name="mem_mail" id="mem_mail">
		<input type="button" onclick="findPw_go();" value="찾기">
		<label id="mailCheck"></label>
	</form>
</div>
