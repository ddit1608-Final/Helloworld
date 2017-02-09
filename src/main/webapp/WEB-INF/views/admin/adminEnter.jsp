<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
article{
width:29%;
margin:7% auto auto auto;
}
#enterLogo{
width:27%;
float:left;
margin-right:5%;
}
#freeLogo{
margin:1% auto 1% auto;
	border:1px solid #5d5d5d;
	
	width:100%;
}

h3{
font-size:20pt;
font-family:한나;
}

input[type=submit]{
font-family:한나;
background-color: #3EAF0E;
color:white;
border-radius:5px;
border:none;
width:18%;
height:28px;
font-size:135%;
}
input[type=submit]:hover{
background-color: #006f00;
}


</style>
<img id="freeLogo" src="<%= request.getContextPath() %>/resources/images/adminLogo.png">
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
		<img id="enterLogo" src="<%=request.getContextPath()%>/resources/images/adminEnter.png">
			<h3>관리자 패스워드</h3> <input type="password" name="admin_pw">
			<input type="submit" value="LOGIN">
		</form>

	</div>
</article>
