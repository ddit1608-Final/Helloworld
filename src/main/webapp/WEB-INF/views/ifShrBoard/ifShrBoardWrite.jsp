<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/freeBoard.css">
<article>
	<div>
		<a href="<%=request.getContextPath()%>/is/ifShrBoardList.do">
		<img id="freeLogo" src="<%= request.getContextPath() %>/resources/images/ifshrboard.png"></a>
	</div> 
	
	<form id="fdf" name="form" method="post" action="ifShrBoardWrite.do">
			<!-- freeboard_posting_no,mem_mail,freeboard_title,freeboard_cont -->
		<table class="table .table-condensed" id="bwt">
			<thead>
      		<tr style="border-bottom:1px solid #c9c9c9;">
		        <td style="width:20%;">
		        	<label id="wri">작성자</label> 
		        	<input type="text" class="form-control" value="${loginUser.mem_nick}" readonly>
		        </td>
		        <td>
		        	<label id="ifshrboard_pwd">비밀번호</label>
	      			<input type="password" class="form-control" id="ifshrboard_pwd" name="ifshrboard_pwd">
		        </td>        
		        <td style="width:10%;"></td>
		        <td style="width:10%;"></td>
		        <td style="width:10%;"></td>
      		</tr>
      		<tr>
      			<td><label for="sel1">말머리 (select one)</label>
      				<select class="form-control" id="sel1" name="type_key">
	        			<!-- <option value="type_key">꿀팁</option>
	        			<option value="ifshrboard_os">오픈소스</option>
	        			<option value="ifshrboard_com_epil">기업후기</option> -->
	        			<c:forEach items="${typeList }" var="posting" varStatus="status">
      						<c:if test="${status.count < '4'}">
      							<option value="${posting.type_key}">${posting.type_value}</option>	
      						</c:if>
      					</c:forEach>
      				</select>
      			</td>
      			<td>
      			<div class="form-group">
      			<label id="ifshrboard_title">제목</label>
      			<input type="text" class="form-control" id="ifshrboard_title" name="ifshrboard_title">
		    	</div>
		      	</td>
		      	<td></td>
		      	<td></td>
		      	<td></td>
		    </tr>
      		<tr>
      			<td><h2>내용</h2>
  					<p>한글 2000자 이내</p>
  					<p><label id="ifshrboard_cont" class="cec" ></label></p>
  					</td>
  				<td>	
    			<div class="form-group">
      			<label for="comment">Comment:</label>
      			<textarea class="form-control" rows="7" name="ifshrboard_cont" id="isboard_cont"></textarea>
    			</div>
      			</td>
      			<td></td>
      			<td></td>
      			<td></td>
      		</tr>
     		</thead>
		</table>
				<div id="divdiv" style="text-align:center;">
				<input type="hidden" id="mem_mail" name="mem_mail" value="${loginUser.mem_mail}">
				<input class="btn" type="button" value="글쓰기" onclick="is_write_ok(this.form)"> 
				<input class="btn" type="reset" value="지우기"> 
				<input class="btn" type="button" value="뒤로가기" onclick="location.href='<%=request.getContextPath()%>/is/ifShrBoardList.do'">
				</div>
</form>
</article>
