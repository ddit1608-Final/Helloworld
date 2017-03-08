<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/freeBoard.css">
	
<style>
#bwt{
width:40%;
margin:0 auto;
border:0px;
}
#bwt input[type=text]{
width:100%;
font-family:나눔고뒥;
}
#bwt th,td{
font-size:12pt;
font-family:나눔고뒥;

}
#bwt th{
padding:12px;
}
.btn{
background-color: #3EAF0E;
color:white;
font-size:20pt;
font-family:한나;
}
.btn:hover{
background-color: #006f00;
color:white;
}
thead td,th{
border:1px solid #b7cbd9 !important;
}
</style>

<article>
<div>
		<a href="<%=request.getContextPath()%>/rct/rctBoardList.do">
		<img id="freeLogo" src="<%= request.getContextPath() %>/resources/images/guin.png"></a>
	</div> 
<form id="fdf" name="form" method="post" action="rctBoardWrite.do" style="border:1px solid #b7cbd9;">
		<table class="table .table-condensed" id="bwt"">
		<thead>
			<h1 style="text-align: center; padding-top:1%;">구인글 작성</h1><hr style="border-bottom:1px solid black; width:15%;">
		<tr>
	      	<th><font style="color:red;">＊</font>제목</th>
		    <td style="border:1px solid #b7cbd9"><input type="text" class="form-control" id="rctboard_title" name="rctboard_title" placeholder="ex) 유능한 인재를 찾습니다."></td> 
		    
		</tr>
			<tr>
	      		<th style="width:30%;">&nbsp;&nbsp;&nbsp;회사이름</th>
	      		<td><input type="text" class="form-control" id="compmem_comp_nm" name="compmem_comp_nm" placeholder="ex) 대전, 서울, 내근"
	      		value="${loginUser.compmem_comp_nm }" readonly></td>
		    </tr>
	      <tr>
	      		<th style="width:30%;"><font style="color:red;">＊</font>경력</th>
		        <td><input type="text" class="form-control" id="rctboard_crr" name="rctboard_crr" placeholder="ex) 경력 1년 이상 or 경력무관"></td>
		    </tr>
		    <tr>
	      		<th style="width:30%;"><font style="color:red;">＊</font>학력</th>
	      		<td><input type="text" class="form-control" id="rctboard_acdmcr" name="rctboard_acdmcr" placeholder="ex) 4년제졸, 학력무관"></td>
		    </tr>
		    <tr>
	      		<th style="width:30%;"><font style="color:red;">＊</font>연봉</th>
	      		<td><input type="text" class="form-control" id="rctboard_year_sal" name="rctboard_year_sal" placeholder="ex) 2500이상, 협의 후 결정"></td>
		    </tr>
		    <tr>
	      		<th style="width:30%;"><font style="color:red;">＊</font>고용형태</th>
	      		<td><input type="text" class="form-control" id="rctboard_emp_kind" name="rctboard_emp_kind" placeholder="ex) 정규직, 계약직"></td>
		    </tr>
		    <tr>
	      		<th style="width:30%;"><font style="color:red;">＊</font>급여</th>
	      		<td><input type="text" class="form-control" id="rctboard_sal" name="rctboard_sal"></td>
		    </tr>
		    <tr>
	      		<th style="width:30%;">&nbsp;&nbsp;&nbsp;근무지</th>
	      		<td><input type="text" class="form-control" id="rctboard_workp" name="rctboard_workp" placeholder="ex) 대전, 서울, 내근"
	      		value="${loginUser.compmem_workp }" readonly></td>
		    </tr>
		    <tr>
	      		<th style="width:30%;">&nbsp;&nbsp;&nbsp;근무시간</th>
	      		<td><input type="text" class="form-control" id="rctboard_work_time" name="rctboard_work_time" placeholder="ex) 오전9시-오후6시"></td>
		    </tr>
		    <tr>
	      		<th style="width:30%;">&nbsp;&nbsp;&nbsp;상세내용</th>
	      		<td><textarea style="width:100%;"class="form-control" id="rctboard_det_cont" name="rctboard_det_cont"  placeholder="ex) "></textarea></td>
		    </tr>
		    <tr>
	      		<th style="width:30%;">&nbsp;&nbsp;&nbsp;복지혜택</th>
	      		<td><input type="text" class="form-control" id="rctboard_welf_benefit" name="rctboard_welf_benefit" placeholder="ex) 노트북지급, 유류비지원"></td>
		    </tr>
		    <tr>
	      		<th style="width:30%;"><font style="color:red;">＊</font>연락처</th>
	      		<td><input type="text" class="form-control" id="rctboard_phn" name="rctboard_phn" placeholder="ex) 010-XXXX-XXXX"
	      		value="${loginUser.compmem_phn }" readonly></td>
		    </tr>
		    <tr>
	      		<th style="width:30%;"><font style="color:red;">＊</font>담당자명</th>
	      		<td><input type="text" class="form-control" id="rctboard_respsbt" name="rctboard_respsbt" placeholder="ex) 홍길동"
	      		value="${loginUser.compmem_nm }" readonly></td>
		    </tr>
		    <tr>
	      		<th style="width:30%;">&nbsp;&nbsp;&nbsp;회사홈페이지</th>
	      		<td><input type="text" class="form-control" id="rctboard_comp_homep" name="rctboard_comp_homep" placeholder="ex) http://helloworld.com"></td>
		    </tr>
		    <tr>
	      		<th style="width:30%;"><font style="color:red;">＊</font>모집수</th>
	      		<td><input type="text" class="form-control" id="rctboard_hope_emp" name="rctboard_hope_emp" placeholder="ex) 신입 1명, 경력 2명"></td>
		    </tr>
		    <tr>
		      	<th style="width:30%;"><font style="color:red;">＊</font>사업자등록정보</th>
	      		<td><input type="text" class="form-control" id="compmem_bsnss_lcse_no" name="compmem_bsnss_lcse_no" placeholder="ex) 145871-01-1547857"
	      		value="${loginUser.compmem_bsnss_lcse_no }" readonly></td>
		    </tr>
     </thead>
	</table>
				<div id="divdiv" style="text-align:center; margin-top:1%; margin-left:26%;">
				<%-- <input type="hidden" id="mem_mail" name="mem_mail" value="${loginUser.mem_mail}"> --%>
				<input class="btn" type="submit" value="글쓰기"> 
				<input class="btn" type="reset" value="지우기"> 
				<%-- <input class="btn" type="button" value="뒤로가기" onclick="location.href='<%=request.getContextPath()%>/free/freeBoardList.do'"> --%>
				</div>
</form>
</article>