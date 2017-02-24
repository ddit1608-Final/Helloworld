<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<form id="fdf" name="form" method="post" action="rctBoardWrite.do">
		<table class="table .table-condensed" id="bwt">
		<thead>
		<tr style="border-bottom:1px solid #c9c9c9;">
	      	<td style="width:20%;">
		        <label>제목</label> 
		        <input type="text" class="form-control" id="rctboard_title" name="rctboard_title">
		    </td>
		    </tr>
	      <tr style="border-bottom:1px solid #c9c9c9;">
	      	<td style="width:20%;">
		        <label>경력</label> 
		        <input type="text" class="form-control" id="rctboard_crr" name="rctboard_crr">
		    </td>
		    </tr>
		    <tr style="border-bottom:1px solid #c9c9c9;">
	      	<td style="width:20%;">
	      		<label>학력</label>
	      		<input type="text" class="form-control" id="rctboard_acdmcr" name="rctboard_acdmcr">
	      	</td>
		    </tr>
		    <tr style="border-bottom:1px solid #c9c9c9;">
	      	<td style="width:20%;">
	      		<label>연봉</label>
	      		<input type="text" class="form-control" id="rctboard_yeard_sal" name="rctboard_yeard_sal">
	      	</td>
		    </tr>
		    <tr style="border-bottom:1px solid #c9c9c9;">
	      	<td style="width:20%;">
	      		<label>고용형태</label>
	      		<input type="text" class="form-control" id="rctboard_emp_kind" name="rctboard_emp_kind">
	      	</td>
		    </tr>
		    <tr style="border-bottom:1px solid #c9c9c9;">
	      	<td style="width:20%;">
	      		<label>급여</label>
	      		<input type="text" class="form-control" id="rctboard_sal" name="rctboard_sal">
	      	</td>
		    </tr>
		    <tr style="border-bottom:1px solid #c9c9c9;">
	      	<td style="width:20%;">
	      		<label>근무지</label>
	      		<input type="text" class="form-control" id="rctboard_workp" name="rctboard_workp">
	      	</td>
		    </tr>
		    <tr style="border-bottom:1px solid #c9c9c9;">
	      	<td style="width:20%;">
	      		<label>근무시간</label>
	      		<input type="text" class="form-control" id="rctboard_work_time" name="rctboard_work_time">
	      	</td>
		    </tr>
		    <tr style="border-bottom:1px solid #c9c9c9;">
	      	<td style="width:20%;">
	      		<label>상세내용</label>
	      		<input type="text" class="form-control" id="rctboard_det_cont" name="rctboard_det_cont">
	      	</td>
		    </tr>
		    <tr style="border-bottom:1px solid #c9c9c9;">
	      	<td style="width:20%;">
	      		<label>복지혜택</label>
	      		<input type="text" class="form-control" id="rctboard_welf_benefit" name="rctboard_welf_benefit">
	      	</td>
		    </tr>
		    <tr style="border-bottom:1px solid #c9c9c9;">
	      	<td style="width:20%;">
	      		<label>연락처</label>
	      		<input type="text" class="form-control" id="rctboard_phn" name="rctboard_phn">
	      	</td>
		    </tr>
		    <tr style="border-bottom:1px solid #c9c9c9;">
	      	<td style="width:20%;">
	      		<label>담당자명</label>
	      		<input type="text" class="form-control" id="rctboard_respsbt" name="rctboard_respsbt">
	      	</td>
		    </tr>
		    <tr style="border-bottom:1px solid #c9c9c9;">
	      	<td style="width:20%;">
	      		<label>담당자명</label>
	      		<input type="text" class="form-control" id="rctboard_comp_homep" name="rctboard_comp_homep">
	      	</td>
		    </tr>
		    <tr style="border-bottom:1px solid #c9c9c9;">
	      	<td style="width:20%;">
	      		<label>모집수</label>
	      		<input type="text" class="form-control" id="rctboard_hope_emp" name="rctboard_hope_emp">
	      	</td>
		    </tr>
		    <tr style="border-bottom:1px solid #c9c9c9;">
	      	<td style="width:20%;">
	      		<label>사업자등록정보</label>
	      		<input type="text" class="form-control" id="compmem_bsnss_lcse_no" name="compmem_bsnss_lcse_no">
	      	</td>
		    </tr>
     </thead>
	</table>
				<div id="divdiv" style="text-align:center;">
				<%-- <input type="hidden" id="mem_mail" name="mem_mail" value="${loginUser.mem_mail}"> --%>
				<input class="btn" type="submit" value="글쓰기"> 
				<input class="btn" type="reset" value="지우기"> 
				<%-- <input class="btn" type="button" value="뒤로가기" onclick="location.href='<%=request.getContextPath()%>/free/freeBoardList.do'"> --%>
				</div>
</form>
</body>
</html>