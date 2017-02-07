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
	<h2>아이디/패스워드 찾기</h2>
	<button onclick="location.href='<%=request.getContextPath()%>/member/join'">아이디 찾기</button>
	<button onclick="location.href='<%=request.getContextPath()%>/member/findPw'">패스워드 찾기</button>
</div>
