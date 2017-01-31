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
	<a href="#"></a><img id="joinLogo"
		src="<%=request.getContextPath()%>/resources/images/joinlogo.png"></a>
</div>
<article>
	<div class="jfbg">

		<form action="joinCompany" method="post" id="joinCompForm"
			class="form-horizontal">
			<div style="margin: auto;" class="form-group">
				<label class="control-label col-sm-2" for="compmem_bsnss_lcse_no">사업자번호</label> <input
					class="form-control" type="text" id="compmem_bsnss_lcse_no" name="compmem_bsnss_lcse_no" onkeypress="autoHypenLicense();" maxlength="12"> <label
					id="licenseCheck" class="cec"></label>
					
				<label
					class="control-label col-sm-2" for="compmem_nm">가입자명</label> <input
					class="form-control" type="text" id="compmem_nm" name="compmem_nm">
				<label id="nameCheck" class="cec"></label> <br />
			
				<label class="control-label col-sm-2" for="compmem_pwd">패스워드</label> <input
					class="form-control" type="password" id="compmem_pwd" name="compmem_pwd">
				<label id="pwCheck" class="cec"></label> <br /> <label
					class="control-label col-sm-2" for="pwdCheck">패스워드 확인</label> <input
					class="form-control" type="password" id="pwdCheck" name="pwdCheck">
				<label id="pwdCheckCheck" class="cec"></label> <br />
			
				<label class="control-label col-sm-2" for="compmem_mail">이메일</label> <input
					class="form-control" type="email" id="compmem_mail" name="compmem_mail"> 
				<label id="mailCheck" class="cec"></label>
					
				 <label
					class="control-label col-sm-2" for="compmem_ceo">대표자명</label> <input
					class="form-control" type="text" id="compmem_ceo" name="compmem_ceo">
				<label id="nameCheck" class="cec"></label> <br /> <label
					class="control-label col-sm-2" for="compmem_comp_nm">회사명</label> <input
					class="form-control" type="text" id="compmem_comp_nm" name="compmem_comp_nm">
				<label id="nickCheck" class="cec"></label> <br /> 
				<label
					class="control-label col-sm-2" for="compmem_phn">연락처</label> <input
					class="form-control" type="text" id="compmem_phn" name="compmem_phn">
				<br />
				
				<label
					class="control-label col-sm-2" for="compmem_workp">근무지</label> <input
					class="form-control" type="text" id="compmem_workp" name="compmem_workp">
				<br />


				</select> <br /> <input type="button" onclick="go_joinComp();"
					value="가입">
			</div>
		</form>
	</div>
</article>
