<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
.form-group label{
padding:0;
padding-right:1%;
font-family:나눔고뒥;
}
.btn-success{
border:none !important;
}
.btn-success:hover{
background-color: #006f00 !important;
}
#idsubmit:hover{
background-color: #006f00 !important;
}

</style>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/signup.css">

<article>
	<h2 style="text-align:center; font-size:36px;">개인정보 수정</h2>
	<hr>

	<div class="jfbg">

		<form style="height:580px;"action="updateInfo" method="post" id="updateForm"
			class="form-horizontal">
			<div style="margin:3% auto auto 35%;" class="form-group">
				<label class="control-label col-sm-2" for="mem_mail">이메일</label> <input
					class="form-control" type="email" id="mem_mail" name="mem_mail"
					value="${loginUser.mem_mail }" readonly="readonly"> <br />
				<label class="control-label col-sm-2" for="mem_pw">패스워드</label> <input
					class="form-control" type="password" id="mem_pw" name="mem_pw">
				<label id="pwCheck" class="cec"></label> <br /> <label
					class="control-label col-sm-2" for="pwdCheck">패스워드 확인</label> <input
					class="form-control" type="password" id="pwdCheck" name="pwdCheck">
				<label id="pwdCheckCheck" class="cec"></label> <br /> <label
					class="control-label col-sm-2" for="mem_nm">이름</label> <input
					class="form-control" type="text" id="mem_nm" name="mem_nm" readonly="readonly"
					value="${loginUser.mem_nm }"> <label id="nameCheck"
					class="cec"></label> <br /> <label class="control-label col-sm-2"
					for="mem_nick">닉네임</label> <input class="form-control" type="text"
					id="mem_nick" name="mem_nick" value="${loginUser.mem_nick }" > <label id="nickCheck"
					class="cec"></label> <br /> <label class="control-label col-sm-2"
					for="mem_phn">연락처</label> <input class="form-control" type="text"
					id="mem_phn" name="mem_phn" value="${loginUser.mem_phn }"> <label id="phnCheck"
					class="cec"></label> <br /> <label class="control-label col-sm-2"
					for="mem_sex">성별</label> 
					<c:choose>
						<c:when test="${loginUser.mem_sex == 1 }">
							<input type="radio" id="mem_sex" name="mem_sex" value="1" checked="checked" disabled="disabled">남성
							<input type="radio" id="mem_sex" name="mem_sex" value="2" disabled="disabled">여성<br /> 
						</c:when>
						<c:otherwise>
							<input type="radio" id="mem_sex" name="mem_sex" value="1" disabled="disabled">남성
							<input type="radio" id="mem_sex" name="mem_sex" value="2" checked="checked" disabled="disabled">여성<br />
						</c:otherwise>
					</c:choose>
					
					<label
					id="sexCheck" class="cex"></label><br /> <label
					class="control-label col-sm-2" for="addr_zipnum">주소</label> <input
					class="form-control" type="text" id="addr_zipnum"
					name="addr_zipnum" value="${loginUser.addr_zipnum }"> <input class="form-control" type="text"
					id="mem_addr" name="mem_addr" value="${loginUser.mem_addr }">
					<input style="margin-left:25.5%; background-color:#3EAF0E; font-size:13pt;" type="button" value="주소 찾기" class="btn btn-success" onclick="post_zip()"><br><br> 
					<label class="cec" for="addr_zipnum" id="addrCheck"></label> 
				<br /> <input id="idsubmit" type="button" style="margin-left:23%; background-color: #3EAF0E; font-size:18pt; color:white;" class="btn" 
				onclick="go_update();" value="수정완료">
				
			</div>
		</form>
	</div>

</article>