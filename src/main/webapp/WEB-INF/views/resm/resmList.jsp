<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
article{
border:1px solid #b7cbd9;
padding-top:2%;
margin-top:1%;
margin-bottom:1%;
}
#headerr{
width:90%; 
margin:0 auto; 
color:black;
}
#contentt{
width:90%;
margin:0 auto;
color:black;
font-size:12pt;
font-family:나눔고뒥;
}
.btn-sm{
background-color: #3EAF0E;
font-size:15pt;
margin-bottom:5%;
}
.btn-sm:hover{
background-color: #006f00;
}
</style>
<article>
	<div id="headerr">
		<h2 style="text-align:left; font-family:나눔고뒥;">이력서 관리</h2>
		<h3></h3>
	</div> 
	<form name="form" method="post">
		<table id="contentt">
			<tr>
				<td>등록일</td>
			</tr>
			<c:forEach items="${resmList}" var="ResmVO">
					<td>
					<a href="/world/resm/resmDetail.do?resm_id=${ResmVO.resm_id}"><fmt:formatDate value="${ResmVO.resm_wri_date}" type="date" /></a>
					</td>
			</c:forEach>
			</table >
			<table style="margin:0 auto;">
			<tr>
			<td><input type="button" class="btn btn-success btn-sm" value="이력서 쓰러가기"
				  	onclick="location.href='<%=request.getContextPath()%>/resm/resmWriteForm.do'">
				<input type="button" class="btn btn-success btn-sm" value="메인가기"
				  	onclick="location.href='<%=request.getContextPath()%>/index'">
			</td>
			</tr>
		</table>
	</form>
</article>
