<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
button{
width:43%;
background-color: white;
font-family:한나;
height:50px;	
font-size:15pt;
border-radius:5px;
}
button:hover{
background-color: #8bdb69;
}
#iimg{
width:43%;
cursor:pointer;
}

</style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/signup.css">
	<div>
		<a href="#"></a><img id="joinLogo" src="<%= request.getContextPath() %>/resources/images/joinlogo.png"></a>
	</div> 
<article style="margin:4% auto 10% 10%;">

<div>
	<a onclick="location.href='<%=request.getContextPath()%>/member/join'">
	<img id="iimg" src="<%=request.getContextPath()%>/resources/images/personal.png"></a>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a onclick="location.href='<%=request.getContextPath()%>/member/joinCompany'">
	<img id="iimg" src="<%=request.getContextPath()%>/resources/images/company.png">
	</a>

</div>
	<br>
	<button onclick="location.href='<%=request.getContextPath()%>/member/join'">개인회원 가입</button>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<button onclick="location.href='<%=request.getContextPath()%>/member/joinCompany'">기업회원 가입</button>
</article>