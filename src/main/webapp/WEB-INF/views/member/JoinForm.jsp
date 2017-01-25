<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/signup.css">

<article>


	<form action="join" method="post" id="joinForm" class="form-horizontal">
		<div style="margin: auto;" class="form-group">
			<label class="control-label col-sm-2" for="mem_mail">이메일</label> <input
				class="form-control" type="email" id="mem_mail" name="mem_mail"
				value="${param.mem_mail }" onkeyup="checkDepulicateId()"> 
				
				
			<label id="mailCheck" class="cec" ></label>
			<c:choose>
				<c:when test="${param.cetifi eq null}">
					<input type="button" onclick="go_certification()" id="checkbtn" value="인증">
					<br />
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${param.cetifi == 'success'}">
							<input type="button" disabled="disabled" value="인증완료">
							<br />
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


			<label class="control-label col-sm-2" for="mem_pw">패스워드</label> 
				<input class="form-control" type="password" id="mem_pw" name="mem_pw">
			<label id="pwCheck" class="cec" ></label> <br /> 
			<label class="control-label col-sm-2" for="pwdCheck">패스워드 확인</label> 
				<input class="form-control"	type="password" id="pwdCheck" name="pwdCheck"> 
			<label id="pwdCheckCheck" class="cec" ></label> <br /> 
			<label class="control-label col-sm-2" for="mem_nm">이름</label> 
			<input class="form-control" type="text" id="mem_nm" name="mem_nm">
			<label id="nameCheck" class="cec"></label> <br /> 
			<label class="control-label col-sm-2" for="mem_nick">닉네임</label> 
			<input class="form-control" type="text" id="mem_nick" name="mem_nick">
			<label id="nickCheck" class="cec"></label> <br /> 
			<label class="control-label col-sm-2" for="mem_phn">연락처</label> 
			<input class="form-control" type="text" id="mem_phn" name="mem_phn">
			<label id="phnCheck" class="cec"></label> <br /> 
			<label class="control-label col-sm-2" for="mem_sex">성별</label> 
			<input type="radio" id="mem_sex" name="mem_sex" value="1">남성 
			<input type="radio" id="mem_sex" name="mem_sex" value="2">여성<br/> 
			<label id="sexCheck" class="cex"></label><br /> 
			<label class="control-label col-sm-2" for="addr_zipnum">주소</label> 
			<input class="form-control" type="text"	id="addr_zipnum" name="addr_zipnum"> 
			<input class="form-control" type="text" id="mem_addr" name="mem_addr">
			<label class="cec" for="addr_zipnum"	id="addrCheck"></label> 
			<input type="button" value="주소 찾기" class="btn btn-success" onclick="post_zip()"> <br />


			<hr>
			<br> 선택부분.. <br /> <label>사용언어 : </label>
			<c:forEach var="lang" items="${langList }" varStatus="status">
				<input type="checkbox" name="mem_lang" value="${lang.mem_lang }">${lang.mem_lang_nm }
			</c:forEach>
			<br /> <label>경력 : </label> <br /> <input type="button"
				onclick="go_join('${param.cetifi}');" value="가입">
		</div>
	</form>

</article>
