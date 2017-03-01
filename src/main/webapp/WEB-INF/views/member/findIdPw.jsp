<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/signup.css">

<style>
.btn{
background-color: #3EAF0E;
color:white;
font-size:14pt;
font-family:한나;
}
.btn:hover{
background-color: #006f00;
color:white;
}
</style>
<div>
		<a href="#"></a><img id="joinLogo" src="<%= request.getContextPath() %>/resources/images/joinlogo.png"></a>
	</div> 

<div style="width:100%;">
	<h2 style="text-align:center; font-family:한나;">아이디/패스워드 찾기</h2><hr style="border:1px solid gray; width:20%;">
	<div style="margin-left:41%;">
	<button class="btn" onclick="location.href='<%=request.getContextPath()%>/member/join'">아이디 찾기</button>
	<button class="btn" onclick="location.href='<%=request.getContextPath()%>/member/findPw'">패스워드 찾기</button></div>
</div>
