<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/freeBoard.css">
<style>
#jobt{
border:1px solid #b7cbd9;
}
#jobt td{
border:1px solid #b7cbd9;
text-align:right;
font-family:나눔고뒥;
font-size:13pt;
background-color: #f5f9ed;
color:#466d53;
font-weight:bold;
}
#jobt input[type=text]{
border:none;
font-family:나눔고뒥;
font-size:12pt;
font-weight:bold;
}
</style>
<article>
<div>
	<a href="<%=request.getContextPath()%>/jobht/jobhtBoardList.do"> 
	<img id="freeLogo" src="<%=request.getContextPath()%>/resources/images/guin.png	"></a>
</div>

	<form name="formm" method="post" action="jobhtWrite.do">
	<table id="jobt">
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
	
		<tr>
			<td><font style="color:red;">＊</font>제목&nbsp;&nbsp;&nbsp;</td>
			<td><input type="text" name="jobhtboard_title" ></td>
		</tr>
		<tr>
			<td><font style="color:red;">＊</font>이메일&nbsp;&nbsp;&nbsp;</td>
			<td><input type="text" name="mem_mail" value="${loginUser.mem_mail }" readonly></td>
		</tr>
		
		<tr>
			<td><font style="color:red;">＊</font>개인 홈페이지&nbsp;&nbsp;&nbsp;</td>
			<td><input type="text" name="jobhtboard_homep"></td>
		</tr>
		
		<tr>
			<td><font style="color:red;">＊</font>희망연봉&nbsp;&nbsp;&nbsp;</td>
			<td><input type="text" name="jobhtboard_hope_sal"></td>
		</tr>
		
		<tr>
		<td><font style="color:red;">＊</font>희망근무지&nbsp;&nbsp;&nbsp;</td>
		<td><input type="text"	name="jobhtboard_hope_workp"></td></tr>
		 <tr>
		 	<td><font style="color:red;">＊</font>희망분야&nbsp;&nbsp;&nbsp;</td>
		 	<td><input type="text" name="jobhtboard_vltr_kind"></td>
		</tr>
		
		<tr>
		<td><font style="color:red;">＊</font>job포스팅넘버(시퀀스)&nbsp;&nbsp;&nbsp;</td>
		<td><input type="text"	name="jobhtboard_posting_no"></td></tr> 
			
			
		<tr>
			<td><font style="color:red;">＊</font>이력서ID(시퀀스)&nbsp;&nbsp;&nbsp;</td>
			<td><input type="text" name="resm_id"></td></tr>
		<tr>
			<td><font style="color:red;">＊</font>컴퓨터활용능력&nbsp;&nbsp;&nbsp;</td>
			<td><input type="text" name="com_use_abil_code"></td>
		</tr> 
		
		<tr>
			<td><font style="color:red;">＊</font>어학능력&nbsp;&nbsp;&nbsp;</td>
			<td><input type="text" name="lang_abil_code"></td> 
		</tr>
		</table>
			<input type="submit" value="구인등록">
		</form>
		
</article>
