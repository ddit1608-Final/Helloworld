<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>

<style>
.form-group label{
padding:0% 1% 0% 0% !important;
font-family:나눔고뒥;
}
article{
border:1px solid #c1c1c1;
}
#mem_mail{
display: inline-block;
}
#checkbtn{
margin-left:-11.5% !important;
background-color: #3EAF0E;
color:white;
font-family:한나;
font-size:11pt;
}
#checkbtn:hover{
background-color: #006f00;
}
.btn-success{
background-color: #3EAF0E;
font-family:한나;
font-size:11pt;
}
.btn-success:hover{
background-color: #006f00;
}
#choice{
border:1px solid #57844f;
background-color: #f3f9f2;
}
#joinS{
background-color: #3EAF0E;
font-family:한나;
font-size:20pt;
color:white;
border:none;
border-radius:5px;
margin-left:73.5%;
margin-bottom:2%;
}

#joinS:hover{
background-color: #006f00;
}
</style>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/signup.css">

<div>
		<a href="#"></a><img id="joinLogo" src="<%= request.getContextPath() %>/resources/images/joinlogo.png"></a>
	</div> 
<article>
<h2 style="text-align:center; font-size:36px; font-family:한나;">회원가입 (개인회원)</h2>
	<hr>
<div class="jfbg">

	<form style="height:500px;" action="join" method="post" id="joinForm" class="form-horizontal">
		<div style="margin:3% auto auto 18%;" class="form-group">
			<label class="control-label col-sm-2" for="mem_mail"><font color=red>* </font>이메일</label> <input
				class="form-control" type="email" id="mem_mail" name="mem_mail"
				value="${param.mem_mail }" onkeyup="checkDepulicateId()"> 
				
				
			<label id="mailCheck" class="cec" ></label>
			<c:choose>
				<c:when test="${param.cetifi eq null}">
					<input type="button" onclick="go_certification()" id="checkbtn" value="인증" class="btn">
					<br /><br/>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${param.cetifi == 'success'}">
							<input type="button" disabled="disabled" value="인증완료" style="font-family:한나; background-color: blue; color:white; border-radius:5px; border:none; font-size:14pt;">
							<br><br />
						</c:when>
						<c:otherwise>
							<input style="margin:auto auto auto 37%;" type="button" onclick="go_certification()" value="인증">
							<br />
							<script type="text/javascript">
								alert("인증에 실패 하였습니다.");
								document.getElementById("mailCheck").innerHTML = "이메일 인증을 해야 합니다.";
								// 2017-01-24 jihyun.Park
								// 메인 화면으로 이동하는 부분 추가할것
							</script>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>


			<label class="control-label col-sm-2" for="mem_pw"><font color=red>* </font>패스워드</label> 
				<input class="form-control" type="password" id="mem_pw" name="mem_pw">
			<label id="pwCheck" class="cec" ></label> <br /> 
			<label class="control-label col-sm-2" for="pwdCheck"><font color=red>* </font>패스워드 확인</label> 
				<input class="form-control"	type="password" id="pwdCheck" name="pwdCheck"> 
			<label id="pwdCheckCheck" class="cec" ></label> <br /> 
			<label class="control-label col-sm-2" for="mem_nm"><font color=red>* </font>이름</label> 
			<input class="form-control" type="text" id="mem_nm" name="mem_nm">
			<label id="nameCheck" class="cec"></label> <br /> 
			<label class="control-label col-sm-2" for="mem_nick"><font color=red>* </font>닉네임</label> 
			<input class="form-control" type="text" id="mem_nick" name="mem_nick">
			<label id="nickCheck" class="cec"></label> <br /> 
			<label class="control-label col-sm-2" for="mem_phn"><font color=red>* </font>연락처</label> 
			<input class="form-control" type="text" id="mem_phn" name="mem_phn">
			<label id="phnCheck" class="cec"></label> <br /> 
			<label class="control-label col-sm-2" for="mem_sex"><font color=red>* </font>성별</label> 
			<input type="radio" id="mem_sex" name="mem_sex" value="1">남성 
			<input type="radio" id="mem_sex" name="mem_sex" value="2">여성<br/> 
			<label id="sexCheck" class="cex"></label><br /> 
			<label class="control-label col-sm-2" for="addr_zipnum"><font color=red>* </font>주소</label>
			<input class="form-control" type="text"	id="addr_zipnum" name="addr_zipnum"  style="display: inline-block;"> 
			<input type="button" value="주소 찾기" class="btn btn-success" onclick="post_zip()" style="display: inline-block;"> <br />
			<input class="form-control" type="text" id="mem_addr" name="mem_addr">
			<label class="cec" for="addr_zipnum"	id="addrCheck"></label> 


			
		</div>
	</form>
	<!-- 선택메뉴&가입버튼 -->
	<hr>
			<h2 style="font-family:한나; margin-left:22%;">선택사항</h2>
			<div id="choice" style="margin-left:22%; width:60%;">
			<label>사용언어 : </label>
			<c:forEach var="lang" items="${langList }" varStatus="status">
				<input type="checkbox" name="mem_lang" value="${lang.mem_lang }">${lang.mem_lang_nm }
			</c:forEach>
			<br /> 
			<label>경력 : </label> 
			<select id=crr_code name="crr_code">
				<c:forEach var="crr" items="${crrList }" varStatus="status">
					<option value="${crr.crr_code }">${crr.crr_nm }</option>
				</c:forEach>
				
			</select>
			</div>
			<br /> <input type="button" onclick="go_join('${param.cetifi}');" value="가입완료" id="joinS">
	<!-- 선택,가입end -->
</div>
</article>
