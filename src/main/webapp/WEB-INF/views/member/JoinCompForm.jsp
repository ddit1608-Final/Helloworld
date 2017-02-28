<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
<style>
article{
border:1px solid #c1c1c1;
}
.form-group{
margin-left:32% !important;
margin-top:3%;
}
label{
padding-top:0px !important;
font-family:나눔고뒥 !important;
}
input[type=text],
input[type=password],
input[type=email]{
margin-left:20%;
}
#joinSS{
background-color: #3EAF0E;
font-family:한나;
font-size:20pt;
color:white;
border:none;
border-radius:5px;
margin-left:73.5%;
margin-bottom:2%;
}
#joinSS:hover{
background-color: #006f00;
}
</style>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/signup.css">

<div>
	<a href="#"></a><img id="joinLogo"
		src="<%=request.getContextPath()%>/resources/images/joinlogo.png"></a>
</div>
<article>
<h2 style="text-align:center; font-size:36px; font-family:한나;">회원가입 (기업회원)</h2>
	<hr>
	<div class="jfbg">

		<form action="joinCompany" method="post" id="joinCompForm"
			class="form-horizontal">
			<div class="form-group" style="height:580px;">
				<label class="control-label col-sm-2" for="compmem_bsnss_lcse_no"><font color=red>* </font>사업자번호</label> <input
					class="form-control" type="text" id="compmem_bsnss_lcse_no" name="compmem_bsnss_lcse_no" onkeypress="autoHypenLicense();" maxlength="12"> <label
					id="licenseCheck" class="cec"></label> <br />
					
				<label
					class="control-label col-sm-2" for="compmem_nm"><font color=red>* </font>가입자명</label> <input
					class="form-control" type="text" id="compmem_nm" name="compmem_nm">
				<label id="nameCheck" class="cec"></label> <br />
			
				<label class="control-label col-sm-2" for="compmem_pwd"><font color=red>* </font>패스워드</label> <input
					class="form-control" type="password" id="compmem_pwd" name="compmem_pwd">
				<label id="pwCheck" class="cec"></label> <br /> <label
					class="control-label col-sm-2" for="pwdCheck" style="width:20%;"><font color=red>* </font>패스워드 확인</label> <input
					class="form-control" type="password" id="pwdCheck" name="pwdCheck">
				<label id="pwdCheckCheck" class="cec"></label> <br />
			
				<label class="control-label col-sm-2" for="compmem_mail"><font color=red>* </font>이메일</label> <input
					class="form-control" type="email" id="compmem_mail" name="compmem_mail"> 
				<label id="mailCheck" class="cec"></label> <br />
					
				 <label
					class="control-label col-sm-2" for="compmem_ceo"><font color=red>* </font>대표자명</label> <input
					class="form-control" type="text" id="compmem_ceo" name="compmem_ceo">
				<label id="nameCheck" class="cec"></label> <br /> <label
					class="control-label col-sm-2" for="compmem_comp_nm"><font color=red>* </font>회사명</label> <input
					class="form-control" type="text" id="compmem_comp_nm" name="compmem_comp_nm">
				<label id="nickCheck" class="cec"></label> <br /> 
				<label
					class="control-label col-sm-2" for="compmem_phn"><font color=red>* </font>연락처</label> <input
					class="form-control" type="text" id="compmem_phn" name="compmem_phn">
				<br />
				
				<label
					class="control-label col-sm-2" for="compmem_workp"><font color=red>* </font>근무지</label> <input
					class="form-control" type="text" id="compmem_workp" name="compmem_workp">
				<br />


				</select> <br /> <input id="joinSS" type="button" onclick="go_joinComp();"
					value="가입완료">
			</div>
		</form>
	</div>
</article>
