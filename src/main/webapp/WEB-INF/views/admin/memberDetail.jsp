<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/signup.css">
<article>
	<form id="joinForm" class="form-horizontal">
		<div style="margin: auto;" class="form-group">
			<label class="control-label col-sm-2" for="mem_mail">이메일</label> <input
				class="form-control" type="email" id="mem_mail" name="mem_mail"
				value="${memVO.mem_mail }" readonly="readonly" onclick="edit('mem_mail');"> <label
				class="control-label col-sm-2" for="mem_pw">패스워드</label> <input
				class="form-control" type="text" id="mem_pw" name="mem_pw"
				value="${memVO.mem_pw }" readonly="readonly"> <br /> <label
				class="control-label col-sm-2" for="mem_nm">이름</label> <input
				class="form-control" type="text" id="mem_nm" name="mem_nm"
				value="${memVO.mem_nm }" readonly="readonly"> <br /> <label
				class="control-label col-sm-2" for="mem_nick">닉네임</label> <input
				class="form-control" type="text" id="mem_nick" name="mem_nick"
				value="${memVO.mem_nick }" readonly="readonly"> <br /> <label
				class="control-label col-sm-2" for="mem_phn">연락처</label> <input
				class="form-control" type="text" id="mem_phn" name="mem_phn"
				value="${memVO.mem_phn }" readonly="readonly"> <br /> <label
				class="control-label col-sm-2" for="mem_sex">성별</label>

			<c:choose>
				<c:when test="${memVO.mem_sex == 1 }">
					<input type="radio" id="mem_sex" name="mem_sex" value="1" checked="checked">남성 
					<input type="radio" id="mem_sex" name="mem_sex" value="2">여성
				</c:when>
				<c:otherwise>
					<input type="radio" id="mem_sex" name="mem_sex" value="1">남성 
					<input type="radio" id="mem_sex" name="mem_sex" value="2" checked="checked">여성
				</c:otherwise>
			</c:choose>
			<br /> 
			<label class="control-label col-sm-2" for="addr_zipnum">주소</label>
			<input class="form-control" type="text" id="addr_zipnum" name="addr_zipnum" value="${memVO.addr_zipnum }" readonly="readonly"> 
			<input class="form-control" type="text" id="mem_addr" name="mem_addr" value="${memVO.mem_addr }" readonly="readonly">
			<br />
			
			<input type="button" value="수정하기" onclick="memberUpdate();">
			<input type="button" value="뒤로" onclick="history.back()">
		</div>
	</form>
</article>
