<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<style>
article {
	border: 1px solid #b7cbd9;
	padding-top: 2%;
	margin-top: 1%;
	margin-bottom: 1%;
}

form {
	font-family: 나눔고뒥 !important;
	font-size: 12pt;
}

.btn:hover {
	background-color: gray;
}

input[type=radio] {
	font-family: 돋움;
}

input[type=text] {
	font-family: 나눔고뒥;
}

#hrt td {
	background-color: #f5f9ed;
	color: #466d53;
	border: 1px solid #b7cbd9;
	text-align: center;
	font-weight: bold;
	"
}

#hrt2 td {
	border: 1px solid #b7cbd9;
	text-align: center;
}

#hrt {
	height: 35px;
}

#hrt2 {
	height: 76px;
}

#hrt3 td {
	border: 1px solid #b7cbd9;
	text-align: center;
	color: #466d53;
}
#hrt3 label{
font-weight:100;
}

input[type=checkbox] {
	margin-left: 10%;
}

.btn-success {
	background-color: #3EAF0E;
	font-family: 한나;
	font-size: 12pt;
}

.btn-success:hover {
	background-color: #006f00;
}

#sc {
	background-color: #3EAF0E;
	font-family: 한나;
	font-size: 15pt;
	border: none;
	border-radius: 5px;
	color: white;
}

#sc:hover {
	background-color: #006f00;
}

#ppp{
	margin-left: 10px;
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
	<form name="formm" method="post" enctype="multipart/form-data">
		<!-- 헤더테이블 -->
		<div>
			<h2 style="font-family: 나눔고뒥; margin-left: 20%; font-weight: bold;">
				기본정보<font style="font-size: 10pt; color: gray;">ㅣ한문명,영문명,홈페이지는
					선택사항입니다.</font>
			</h2>
		</div>
		<hr style="margin-top: 0; width: 60%;">


		<div>
			<table
				style="border: 1px solid #b7cbd9; border-top: 2px solid #376045; margin: 0 auto; width: 60%; height: 276px;">
				<tr>
					<td rowspan="6"
						style="width: 152px; border: 1px solid #b7cbd9; font-weight: bold;">
						<%-- <img style="width: 90%; margin-left: 5%;"
						src="<%=request.getContextPath()%>/images/jeung.jpg"> <br> --%>
						<div style="margin-left: 13%; margin-top: 3%;">
							<input type="file" name="uploadfile">
						</div>
					<td
						style="background-color: #f5f9ed; color: #466d53; border: 1px solid #b7cbd9; text-align: center; width: 20%; font-weight: bold;"><font
						color="red">＊</font>이름</td>
					<td style="border: 1px solid #b7cbd9; width: 55%;"><input
						type="text" style="border: none; width: 100%;"
						value="${loginUser.mem_nm }" readonly></td>
				</tr>

				<tr>
					<td
						style="background-color: #f5f9ed; color: #466d53; border: 1px solid #b7cbd9; text-align: center; font-weight: bold;"><font
						color="red">＊</font>주민등록번호</td>
					<td style="border: 1px solid #b7cbd9; width: 55%;"><input
						type="text" id="resm_regno" name="resm_regno"
						style="border: none; width: 100%;"></td>
				</tr>


				<tr>
					<td
						style="background-color: #f5f9ed; color: #466d53; border: 1px solid #b7cbd9; text-align: center; font-weight: bold;"><font
						color="red">＊</font>주소</td>
					<td><input class="form-control" type="text" id="addr_zipnum"
						name="addr_zipnum" style="width: 50%; display: inline-block;"
						value="${loginUser.addr_zipnum }"> <input
						class="form-control" type="text" id="mem_addr" name="mem_addr"
						style="width: 70.5%; margin-top: 2%;"
						value="${loginUser.mem_addr }"></td>
				</tr>

				<tr>
					<td
						style="background-color: #f5f9ed; color: #466d53; border: 1px solid #b7cbd9; text-align: center; font-weight: bold;"><font
						color="red">＊</font>연락처</td>
					<td style="border: 1px solid #b7cbd9"><input type="text"
						style="border: none; width: 100%;" value="${loginUser.mem_phn }"></td>
				</tr>

				<tr>
					<td
						style="background-color: #f5f9ed; color: #466d53; border: 1px solid #b7cbd9; text-align: center; font-weight: bold;"><font
						color="red">＊</font>이메일</td>
					<td style="border: 1px solid #b7cbd9"><input type="text"
						style="border: none; width: 100%;" name="mem_mail" value="${loginUser.mem_mail }"></td>
				</tr>
				<tr>
					<td
						style="background-color: #f5f9ed; color: #466d53; border: 1px solid #b7cbd9; text-align: center; font-weight: bold;"><font
						color="red">＊</font>성별</td>
					<td style="border: 1px solid #b7cbd9"><c:if
							test="${loginUser.mem_sex == 1}">
					&nbsp;<input type="radio" name="sex" value="male" checked>남
					&nbsp;<input type="radio" name="sex" value="female">여
					</c:if> <c:if test="${loginUser.mem_sex == 2}">
					&nbsp;<input type="radio" name="sex" value="male">남
					&nbsp;<input type="radio" name="sex" value="female" checked>여
					</c:if></td>
				</tr>

			</table>
		</div>
		<br>
		<br>
		<!-- 헤더테이블END -->
		<!-- 학력테이블 -->
		<div>
			<h2 style="font-family: 나눔고뒥; margin-left: 20%; font-weight: bold;">
				학력사항<font style="font-size: 10pt; color: gray;">ㅣ주/야간,소재지,논문제목,휴학사유는
					선택입력 사항입니다.</font>
			</h2>
		</div>
		<hr style="margin-top: 0; width: 60%;">
		<div>
			<table
				style="border: 1px solid #b7cbd9; border-top: 2px solid #376045; margin: 0 auto; width: 60%;">
				<tr id="hrt2">
					<td style="width: 25%; background-color: #f5f9ed; font-weight: bold; font-family: 나눔고뒥;">학력</td>
					<td style="background-color: white; text-align: left;">
					&nbsp;<input style="margin-left:8%;"type="radio" name="acdmcr_code"
						value="1">고졸 &nbsp;<input type="radio" name="acdmcr_code"
						value="2">전문대졸 &nbsp;<input type="radio" name="acdmcr_code"
						value="3">대졸</td>
				</tr>

			</table>
			<br />
			<div>
				<h2 style="font-family: 나눔고뒥; margin-left: 20%; font-weight: bold;">취미 및 특기</h2>
			</div>
			<hr style="margin-top: 0; width: 60%;">
			<table
				style="border: 1px solid #b7cbd9; background-color: #f5f9ed; border-top: 2px solid #376045; margin: 0 auto; width: 60%; height: 80px;">
				<tr id="hrt3">
					<td style="width: 25%; font-weight: bold; font-family: 나눔고뒥;">취미</td>
					<td style="background-color: white; text-align: left;">
						&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" id="ppp" name="resm_hob" style="border:none; height:92%; width:90%; margin-bottom:12%;"></td>
					<td style="width: 25%; font-weight: bold; font-family: 나눔고뒥;">특기</td>
					<td style="background-color: white; text-align: left;">
						&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" id="ppp" name="resm_like" style="border:none; height:92%; width:90%; margin-bottom:12%;"></td>
				</tr>
			</table>

		</div>
		<br>
		<!-- 학력테이블END -->
		<!-- 경력테이블 -->
		<div>
			<h2 style="font-family: 나눔고뒥; margin-left: 20%; font-weight: bold;">자격증</h2>
		</div>
		<hr style="margin-top: 0; width: 60%;">


		<div>
			<table
				style="border: 1px solid #b7cbd9; background-color: #f5f9ed; border-top: 2px solid #376045; margin: 0 auto; width: 60%; height: 80px;">
				<tr id="hrt3">
					<td style="width: 25%; font-weight: bold; font-family: 나눔고뒥;">자격증</td>
					<td style="background-color: white; text-align: left;" id="crr">
						<input type="checkbox" name="lcse_code" id="2" value="2"><label
						for="2">정보처리기능사</label>
						<input type="checkbox" name="lcse_code" id="1" value="1"><label
						for="1">정보처리산업기사</label>
						<input type="checkbox" name="lcse_code" id="0" value="0"><label
						for="0">정보처리기사</label>
						<input type="checkbox" name="lcse_code" id="4" value="4"><label
						for="4">운전면허증</label>
						</td>
				</tr>
			</table>
		</div>
		<Br>
		<!-- 경력테이블END -->
		<!-- 병역테이블 -->
		<div>
			<h2 style="font-family: 나눔고뒥; margin-left: 20%; font-weight: bold;">병역사항</h2>
		</div>
		<hr style="margin-top: 0; width: 60%;">
		<div>
			<table
				style="border: 1px solid #b7cbd9; background-color: #f5f9ed; border-top: 2px solid #376045; margin: 0 auto; width: 60%; height: 60px;">
				<tr id="hrt3">
					<td style="width: 25%; font-weight: bold; font-family: 나눔고뒥;">병역사항</td>
					<td style="background-color: white; text-align: left;">
						&nbsp;&nbsp;&nbsp;&nbsp;<input  style="margin-left:8%;"type="radio" name="milt_code"
						value="0">미필 &nbsp;<input type="radio" name="milt_code"
						value="1">군필 &nbsp;<input type="radio" name="milt_code"
						value="2">면제
					</td>
				</tr>
			</table>
		</div>
		<br>
		<!-- 병역테이블END -->

		<!-- <!-- 사용가능언어 -->
<!-- 		<div>
			<h2 style="font-family: 나눔고뒥; margin-left: 20%; font-weight: bold;">사용가능언어(선택)</h2>
		</div>
		<hr style="margin-top: 0; width: 60%;">
		<div>
			<table
				style="border: 1px solid #b7cbd9; background-color: #f5f9ed; border-top: 2px solid #376045; margin: 0 auto; width: 60%; height: 120px;">
				<tr style="text-align: left;" id="hrt4">
					<td style="width: 25%;"><input type="checkbox" name="acdmcr_code" id="java"
						value="Java"><label for="java">Java</label></td>
					<td style="width: 25%;"><input type="checkbox" name="acdmcr_code" id="jsp"
						value="Jsp"><label for="jsp">Jsp</label></td>
					<td style="width: 25%;"><input type="checkbox" name="acdmcr_code" id="html"
						value="HTML"><label for="html">HTML</label></td>
					<td style="width: 25%;"><input type="checkbox" name="acdmcr_code" id="css"
						value="CSS"><label for="css">CSS</label></td>
				</tr>
				<tr style="text-align: left;" id="hrt4">
					<td><input type="checkbox" name="acdmcr_code" id="script" value="JavaScript"><label
						for="script">JavaScript</label></td>
					<td><input type="checkbox" name="acdmcr_code" id="asp" value="ASP"><label
						for="asp">ASP</label></td>
					<td><input type="checkbox" name="acdmcr_code" id="net" value=".NET"><label
						for="net">.NET</label></td>
					<td><input type="checkbox" name="acdmcr_code" id="c" value="C#"><label
						for="c">C#</label></td>
				</tr>
			</table>
		</div>
		사용가능언어END -->
		<br>
		
		<div style="margin-left: 72.5%;">
			<input type="submit" value="완료" id="sc"> <input type="button"
				value="취소" id="sc">
		</div>
		<br>
		<br>
		<br>
	</form>
</article>
<script type="text/javascript">
	function plus() {
		$('#crr')
				.append(
						'<div id="nnn">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="pplus" name="lcse_code"><input type="button" id="bb" value="-" onclick="minu()"></div>');
	}
	function minu() {
		$('#nnn').remove();
	}
</script>


