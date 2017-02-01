<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/freeBoard.css">
<article>
<div>
		<a href="<%=request.getContextPath()%>/free/freeBoardList.do"><img id="freeLogo" src="<%= request.getContextPath() %>/resources/images/freeboard.png"></a>
	</div> 
	
	<form id="fdf" name="form" method="post" action="freeBoardWrite.do">
			<!-- freeboard_posting_no,mem_mail,freeboard_title,freeboard_cont -->
		<table class="table .table-condensed" id="bwt">
<thead>
      <tr style="border-bottom:1px solid #c9c9c9;">
        <td style="width:20%;">작성자 ${loginUser.mem_nick}</td>
        <td style="width:60%; float:left;">비밀번호
        <input type="password" name="freeboard_pwd">
        <label id="freeboard_pwd" class="cec" ></label>
        </td>        
        <td style="width:10%;"></td>
        <td style="width:10%;"></td>
        <td style="width:10%;"></td>
      </tr>
      <tr>
      	<td style="text-align: center;">제목
      	<input type="text" name="freeboard_title"><label id="freeboard_title" class="cec" ></label></td>
      </tr>
      <tr>
      	<td style="text-align: left;">&nbsp;&nbsp;&nbsp;내용<label id="freeboard_cont" class="cec" ></label></td>
      	
        	<td>
      		<textarea rows="8" cols="65" name="freeboard_cont"></textarea>
      	</td>
      </tr>
     </thead>
		</table>
	<table>
		
	</table>
				<div id="divdiv">
				<input type="hidden" id="mem_mail" name="mem_mail" value="${loginUser.mem_mail}">
				<input class="btn" type="button" value="글쓰기" onclick="write_ok(this.form)"> 
				<input class="btn" type="reset" value="취소"> 
				<input class="btn" type="button" value="메인" onclick="location.href='<%=request.getContextPath()%>/index2.jsp'">
				</div>
</form>
</article>
