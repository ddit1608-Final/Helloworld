<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
<meta charset=UTF-8">
<title></title>
</head>
<body>
	<div style="margin: auto;" class="container-fluid">
		<form action="join" method="post" id="joinForm">
			<label>이메일</label> <input type="email" id="mem_mail"
				name="mem_mail" value="${param.mem_mail }"
				onkeyup="checkDepulicateId()"> <label id="mailCheck">메일체크하는건데
				이따가 지워야함</label>
			<c:choose>
				<c:when test="${param.cetifi eq null}">
					<input type="button" onclick="go_certification()" value="인증">
					<br />
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${param.cetifi == 'success'}">
							<input type="button" disabled="disabled" value="인증완료">
							<br />
						</c:when>
						<c:otherwise>
							<input type="button" onclick="go_certification()" value="인증">
							<br />
							<script type="text/javascript">
								alert("인증에 실패 하였습니다.");
								// 2017-01-24 jihyun.Park
								// 메인 화면으로 이동하는 부분 추가할것
							</script>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
			

			<label>패스워드</label> <input type="password" id="mem_pw"
				name="mem_pw"> <br /> <label>패스워드 확인</label> <input
				type="password" id="pwdCheck" name="pwdCheck"> <br /> <label>이름</label>
			<input type="text" id="mem_nm" name="mem_nm"> <br /> <label>닉네임</label>
			<input type="text" id="mem_nick" name="mem_nick"> <br /> <label>연락처</label>
			<input type="text" id="mem_phn" name="mem_phn"> <br /> <label>성별</label>
			<input type="radio" id="mem_sex" name="mem_sex" value="1">남성
			<input type="radio" id="mem_sex" name="mem_sex" value="2">여성<br />
			<label>주소</label> 
			<input type="text" id="addr_zipnum" name="addr_zipnum"> 
			<input type="text" id="mem_addr" name="mem_addr">
			<input type="button" value="주소 찾기" class="btn btn-success"
				onclick="post_zip()"> <br />


			<hr>
			<br> 선택부분.. <br/>
			<label>사용언어 : </label>
			<c:forEach var="lang" items="${langList }" varStatus="status">
				<input type="checkbox" name="mem_lang" value="${lang.mem_lang }">${lang.mem_lang_nm }
			</c:forEach>
			<br /> 
			<label>경력 : </label>
			<br/>
			<input type="submit" value="가입">
		</form>
	</div>
</body>
</html>