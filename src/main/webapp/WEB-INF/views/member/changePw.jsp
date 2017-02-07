<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/signup.css">


<div>
	<form action="changePw" method="post" id="changeForm"
		class="form-horizontal">
		<div style="margin: auto;" class="form-group">
			<input class="form-control" type="hidden" id="mem_mail"
				name="mem_mail" value="${param.mem_mail }">
			<label class="control-label col-sm-2" for="mem_pw">패스워드</label> <input
				class="form-control" type="password" id="mem_pw" name="mem_pw">
			<label id="pwCheck" class="cec"></label> <br /> <label
				class="control-label col-sm-2" for="pwdCheck">패스워드 확인</label> <input
				class="form-control" type="password" id="pwdCheck" name="pwdCheck">
			<label id="pwdCheckCheck" class="cec"></label> <br /> <br /> <input
				type="button" onclick="change_pw();" value="수정">
		</div>
	</form>
</div>
