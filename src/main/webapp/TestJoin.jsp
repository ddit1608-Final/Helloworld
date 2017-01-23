<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title></title>
</head>
<body>
	<form action="member/join" method="post">
		<label>이메일</label> <input type="email" id="mem_mail" name="mem_mail">
		<br /> <label>패스워드</label> <input type="password" id="mem_pw"
			name="mem_pw"> <br /> <label>패스워드 확인</label> <input
			type="password" id="pwdCheck" name="pwdCheck"> <br /> <label>이름</label>
		<input type="text" id="mem_nm" name="mem_nm"> <br />
		<label>닉네임</label>
		<input type="text" id="mem_nick" name="mem_nick"> <br /> 
		<label>연락처</label>
		<input type="text" id="mem_phn" name="mem_phn"> <br /> <label>성별</label>
		<input type="radio" id="mem_sex" name="mem_sex" value="1">남성
		<input type="radio" id="mem_sex" name="mem_sex" value="2">여성<br />
		<label>주소</label> <input type="text" id="mem_addr" name="mem_addr">
		<input type="button" value="주소 찾기" class="btn btn-success"
			onclick="post_zip()"> <br /> <input type="submit" value="가입">
	</form>
</body>
</html>