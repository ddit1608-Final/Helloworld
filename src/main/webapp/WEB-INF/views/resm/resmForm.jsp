<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<style>
article{
border:1px solid #b7cbd9;
padding-top:2%;
margin-top:1%;
margin-bottom:1%;
}
form{
font-family:나눔고뒥 !important;
font-size:12pt;
}
.btn:hover{
background-color: gray;
}

input[type=radio]{
font-family:돋움;
}
input[type=text]{
font-family:나눔고뒥;
}
#hrt td{
background-color: #f5f9ed; 
color:#466d53; 
border:1px solid #b7cbd9;
text-align:center;
font-weight:bold;"
}
#hrt2 td{
border:1px solid #b7cbd9;
text-align:center;
}
#hrt{
height:35px;
}
#hrt2{
height:76px;
}
#hrt3 td{
border:1px solid #b7cbd9;
text-align:center;
color:#466d53;
}
input[type=checkbox]{
margin-left:10%;
}
.btn-success{
background-color: #3EAF0E;
font-family:한나;
font-size:12pt;
}
.btn-success:hover{
background-color: #006f00;
}
#sc{
background-color: #3EAF0E;
font-family:한나;
font-size:15pt;
border:none;
border-radius:5px;
color:white;
}
#sc:hover{
background-color: #006f00;
}
</style>

<script language="javascript"> 

</script> 
<!-- <form name="formm" method="post" action="resmWrite.do"><br>
	아이디(resm_id) : <input type="text" name="resm_id"><br>/
	이메일(mem_mail) : <input type="text" name="mem_mail"><br>/
	자기소개서(sidn_code) : <input type="text" name="sidn_code"><br>/
	자격증코드(lcse_code) : <input type="text" name="lcse_code"><br>/
	학력코드(acdmcr_Code) : <input type="text" name="acdmcr_code"><br>/
	증명사진(idpic_code) : <input type="text" name="idpic_code"><br>/
	주민등록번호(resm_regno) : <input type="text" name="resm_regno"><br>/
	병역사항(resm_milit) : <input type="text" name="milt_code"><br>/
	취미(resm_hob) : <input type="text" name="resm_hob"><br>/
	특기(resm_like) : <input type="text" name="resm_like"><br>/
	<input type="submit" value="이력서 등록">
</form> -->

<article>
<form>
<!-- 헤더테이블 -->
	<div>
		<h2 style="font-family:나눔고뒥; margin-left:20%; font-weight:bold;">기본정보<font style="font-size:10pt; color:gray;">ㅣ한문명,영문명,홈페이지는 선택사항입니다.</font></h2>
	</div>
	<hr style="margin-top:0; width:60%;">
	
	
	<div>
		<table style="border:1px solid #b7cbd9; border-top:2px solid #376045; margin:0 auto; width:60%; height:276px;">
			<tr>
				<td rowspan="6" style="width:152px; border:1px solid #b7cbd9; font-weight:bold;">
				<img style="width:90%; margin-left:5%;" src="<%=request.getContextPath()%>/images/jeung.jpg">
				<br>
				<div style="margin-left:13%; margin-top:3%;">
				<input type="button" value="등록/수정" class="btn">
				<input type="button" value="삭제" class="btn">
				</div>
				
				<td style="background-color: #f5f9ed; color:#466d53; border:1px solid #b7cbd9; text-align:center; width:20%; font-weight:bold;"><font color="red">＊</font>이름</td>
				<td style="border:1px solid #b7cbd9; width:55%;"><input type="text" style="border:none; width:100%;"></td>
			</tr>	
			
			<tr>
				<td style="background-color: #f5f9ed; color:#466d53; border:1px solid #b7cbd9; text-align:center; font-weight:bold;"><font color="red">＊</font>주민등록번호</td>
				<td style="border:1px solid #b7cbd9; width:55%;"><input type="text" style="border:none; width:100%;"></td>
			</tr>
			
			
			<tr>
				<td style="background-color: #f5f9ed; color:#466d53; border:1px solid #b7cbd9; text-align:center; font-weight:bold;"><font color="red">＊</font>주소</td>
				<td><!-- <label class="control-label col-sm-2" for="addr_zipnum" hidden="hidden"></label> --> 
					<input class="form-control" type="text"	id="addr_zipnum" name="addr_zipnum" style="width:50%; display: inline-block;">
					<input type="button" value="주소 찾기" class="btn btn-success" onclick="post_zip()">
					<input class="form-control" type="text" id="mem_addr" name="mem_addr" style="width:70.5%; margin-top:2%;">
					<!-- <label class="cec" for="addr_zipnum"	id="addrCheck"></label> --></td>
			</tr>
			
			<tr>
				<td style="background-color: #f5f9ed; color:#466d53; border:1px solid #b7cbd9; text-align:center; font-weight:bold;"><font color="red">＊</font>연락처</td>
				<td style="border:1px solid #b7cbd9"><input type="text" style="border:none; width:100%;"></td>
			</tr>
		
			<tr>
				<td style="background-color: #f5f9ed; color:#466d53; border:1px solid #b7cbd9; text-align:center; font-weight:bold;"><font color="red">＊</font>이메일</td>
				<td style="border:1px solid #b7cbd9"><input type="text" style="border:none; width:100%;"></td>
			</tr>
			<tr>
				<td style="background-color: #f5f9ed; color:#466d53; border:1px solid #b7cbd9; text-align:center; font-weight:bold;"><font color="red">＊</font>성별</td>
				<td style="border:1px solid #b7cbd9">
					&nbsp;<input type="radio" name="sex" value="male">남
					&nbsp;<input type="radio" name="sex" value="female">여
				</td>
			</tr>
			
		</table>
		</div><br><br>
		<!-- 헤더테이블END -->
		<!-- 학력테이블 -->
		<div>
		<h2 style="font-family:나눔고뒥; margin-left:20%; font-weight:bold;">학력사항<font style="font-size:10pt; color:gray;">ㅣ주/야간,소재지,논문제목,휴학사유는 선택입력 사항입니다.</font></h2>
			</div>
			<hr style="margin-top:0; width:60%;">
		<div>
			<table style="border:1px solid #b7cbd9; border-top:2px solid #376045; margin:0 auto; width:60%;">
				<tr id="hrt">
					<td style="width:27%;"><font color="red">＊</font>재학기간</td>
					<td style="width:30%;"><font color="red">＊</font>학교명</td>
					<td><font color="red">＊</font>전공</td>
					<td><font color="red">＊</font>학점</td>
				</tr>
			
				<tr id="hrt2">
					<td><input type="text" style="width:40%;" placeholder="2010.03">∼
						<input type="text" style="width:40%;" placeholder="2017.02" style="margin-left:1%;"><br>
						<select>
							<option>입학</option>
						</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<select>
							<option>졸업</option>
						</select></td>
						
					<td><input type="text" placeholder="대덕고등학교"></td>
					<td><select><option>문과계열</option></select></td>
					<td style="width:20%;">-</td>
				</tr>
			
			
			
			
			</table>
			<br>
			<table style="border:1px solid #b7cbd9; margin:0 auto; width:60%;">
				<tr id="hrt">
					<td style="width:27%;"><font color="red">＊</font>재학기간</td>
					<td style="width:30%;"><font color="red">＊</font>학교명</td>
					<td><font color="red">＊</font>전공</td>
					<td><font color="red">＊</font>학점</td>
				</tr>
			
				<tr id="hrt2">
					<td><input type="text" style="width:40%;">∼
						<input type="text" style="width:40%;" style="margin-left:1%;"><br>
						<select>
							<option>입학</option>
						</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<select>
							<option>졸업</option>
						</select></td>
						
					<td><input type="text"></td>
					<td><select><option>문과계열</option></select></td>
					<td style="width:20%;">-</td>
				</tr>
			
			
			
			
			</table>
			<br>
			<table style="border:1px solid #b7cbd9; margin:0 auto; width:60%;">
				<tr id="hrt">
					<td style="width:27%;"><font color="red">＊</font>재학기간</td>
					<td style="width:30%;"><font color="red">＊</font>학교명</td>
					<td><font color="red">＊</font>전공</td>
					<td><font color="red">＊</font>학점</td>
				</tr>
			
				<tr id="hrt2">
					<td><input type="text" style="width:40%;">∼
						<input type="text" style="width:40%;" style="margin-left:1%;"><br>
						<select>
							<option>입학</option>
						</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<select>
							<option>졸업</option>
						</select></td>
						
					<td><input type="text"></td>
					<td><select><option>문과계열</option></select></td>
					<td style="width:20%;">-</td>
				</tr>
			
			
			
			
			</table>
		</div>
		<br><br>
		<!-- 학력테이블END -->
		<!-- 경력테이블 -->
		<div>
		<h2 style="font-family:나눔고뒥; margin-left:20%; font-weight:bold;">경력사항</h2>
			</div>
			<hr style="margin-top:0; width:60%;">
		
		
		<div>
			<table style="border:1px solid #b7cbd9; background-color:#f5f9ed; border-top:2px solid #376045; margin:0 auto; width:60%; height:80px;">
				<tr id="hrt3">
					<td rowspan="2" style="width:25%; font-weight:bold; font-family:나눔고뒥;">경력사항</td>
					<td style="background-color: white; text-align:left;">
						  &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="gyung" value="new">신입
					&nbsp;<input type="radio" name="gyung" value="senior">경력
					<input type="radio" name="gyung" value="oper">간부</td>
				</tr>
				
				<tr>
					<td style="background-color: white;"> &nbsp;&nbsp;&nbsp;&nbsp;총 경력
					<select>
						<option>1년</option>
					</select></td>
				</tr>
			</table>
		</div><Br>
		<!-- 경력테이블END -->
		<!-- 병역테이블 -->
		<div>
		<h2 style="font-family:나눔고뒥; margin-left:20%; font-weight:bold;">병역사항</h2>
			</div>
			<hr style="margin-top:0; width:60%;">
		<div>
			<table style="border:1px solid #b7cbd9; background-color:#f5f9ed; border-top:2px solid #376045; margin:0 auto; width:60%; height:60px;">
				<tr id="hrt3">
					<td style="width:25%; font-weight:bold; font-family:나눔고뒥;">병역사항</td>	
					<td style="background-color: white; text-align:left;">
					&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="mili" value="milno">미필
					&nbsp;<input type="radio" name="mili" value="milok">군필
					&nbsp;<input type="radio" name="mili" value="milnot">면제</td>
					</td>
				</tr>
			</table>
		</div><br>
		<!-- 병역테이블END -->
	
		<!-- 사용가능언어 -->
		<div>
		<h2 style="font-family:나눔고뒥; margin-left:20%; font-weight:bold;">사용가능언어(선택)</h2>
			</div>
			<hr style="margin-top:0; width:60%;">
		<div>
			<table style="border:1px solid #b7cbd9; background-color:#f5f9ed; border-top:2px solid #376045; margin:0 auto; width:60%; height:120px;">
				<tr style="text-align:left;" id="hrt4">
					<td style="width:25%;"><input type="checkbox" value="Java"><label>Java</label></td>
					<td style="width:25%;"><input type="checkbox" value="Jsp"><label>Jsp</label></td>
					<td style="width:25%;"><input type="checkbox" value="HTML"><label>HTML</label></td>
					<td style="width:25%;"><input type="checkbox" value="CSS"><label>CSS</label></td>
				</tr>
				<tr style="text-align:left;" id="hrt4">
					<td><input type="checkbox" value="JavaScript"><label>JavaScript</label></td>
					<td><input type="checkbox" value="ASP"><label>ASP</label></td>
					<td><input type="checkbox" value=".NET"><label>.NET</label></td>
					<td><input type="checkbox" value="C#"><label>C#</label></td>
				</tr>
			</table>
		</div><br>
		<!-- 사용가능언어END -->
		<div style="margin-left:72.5%;">
		<input type="button" value="완료" id="sc">
		<input type="button" value="취소" id="sc">
		</div>
		<br><br><br>
</form>
</article>


