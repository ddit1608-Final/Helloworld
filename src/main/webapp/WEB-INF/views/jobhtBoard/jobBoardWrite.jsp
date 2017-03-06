<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/freeBoard.css">
<meta charset=UTF-8>
<title></title>
</head>
<article>
	<div>
		<a href="<%=request.getContextPath()%>/jobht/jobhtBoardList.do"> <img
			id="freeLogo"
			src="<%=request.getContextPath()%>/resources/images/guin.png	"></a>
	</div>
	<form name="formm" method="post" action="jobhtWrite.do">
		<%-- 
		병현 생각 ==> 구직 게시글을 작성할때 로그인 유저는 자신의 이력서가 있을경우 이력서 ID 값으로 라디오 버튼 을 통해 선택하여
				    구직 게시글을 이력서를 통해 바로 작성이 가능하게 하도록 하면 어떨까?
		<table class="table .table-condensed" id="bwt">
			<thead>
     			<tr style="border-bottom:1px solid #c9c9c9;">
     			<td style="width:20%;">작성자 ${loginUser.mem_nick}</td>
        		<td style="width:60%; float:left;">비밀번호
       		 	<input type="password" name="meet_board_pwd"></td>       
        		<td style="width:10%;"></td>
        		<td style="width:10%;"></td>
        		<td style="width:10%;"></td>
		</table> --%>

		이력서 이름 : <input type="text" name="jobhtboard_title"> <br/>
		이름 : <input type="text" name="mem_nm" value="${loginUser.mem_nm }" readonly><br/>
		연락처 : <input type="text" name="mem_phone" value="${loginUser.mem_phn }"><br />
		이메일 : <input type="text" name="mem_mail" value="${loginUser.mem_mail }" readonly><br/>
		홈페이지 : <input type="text" name="jobhtboard_homep"><br>
		희망 연봉 : <input type="text" name="jobhtboard_hope_sal"><br>
		희망 근무지 : <input type="text" name="jobhtboard_hope_workp"><br>
		지원 분야 : <input type="text" name="jobhtboard_vltr_kind"><br>
		컴퓨터 활용 능력 : <input type="text" name="com_use_abil_code"><br> 
		컴퓨터 언어 능력 : <input type="text" name="lang_abil_code"><br> 
		<input type="hidden" name="resm_id"><br>
		<input type="hidden" name="jobhtboard_posting_no"><br> 
		<input type="submit" value="구인등록">
	</form>
</article>
</html>