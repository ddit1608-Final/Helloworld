<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/freeBoard.css">
<article>
	<div>
		<a href="<%=request.getContextPath()%>/is/dogBoardList">
		<img id="freeLogo" src="<%= request.getContextPath() %>/resources/images/dogboard.png"></a>
	</div> 
	
	<form id="fdf" name="form" method="post" action="dogBoardWrite">
			<!-- freeboard_posting_no,mem_mail,freeboard_title,freeboard_cont -->
		<table class="table .table-condensed" id="bwt">
			<thead>
      		<tr style="border-bottom:1px solid #c9c9c9;">
		        <td style="width:20%;">
		        	<label id="wri">작성자</label> 
		        	<input type="text" class="form-control" value="${loginUser.mem_nick}" readonly>
		        </td>
		        <td>
		        	<div class="col-xs-3">
		        	<label id="dsboard_pwd">비밀번호</label>
	      			<input type="password" class="form-control" id="dsboard_pwd" name="dsboard_pwd">
	      			</div>
		        </td>        
		        <td style="width:10%;"></td>
		        <td style="width:10%;"></td>
		        <td style="width:10%;"></td>
      		</tr>
      		<tr>
      			<td><label for="sel1">말머리 (select one)</label>
      				<select class="form-control" id="sel1" name="type_key">
	        			
	        			<c:forEach items="${typeList }" var="posting" varStatus="status">
      						<c:if test="${status.count >= '4'}">
      							<option value="${posting.type_key}">${posting.type_value}</option>	
      						</c:if>
      					</c:forEach>
      				</select>
      			</td>
      			<td>
      			<div class="col-xs-10">
      			<label id="dogboard_title">제목</label>
      			<input type="text" class="form-control" id="dsboard_title" name="dsboard_title">
		    	</div>
		      	</td>
		      	<td></td>
		      	<td></td>
		      	<td></td>
		    </tr>
      		<tr>
      			<td><h2>내용</h2>
  					<p>한글 2000자 이내</p>
  					<p><label id="dsboard_cont" class="cec" ></label></p>
  					</td>
  				<td>	
    			<div class="form-group">
      			<label for="comment">Comment:</label>
      			<textarea class="form-control" rows="7" name="dsboard_cont" id="dsboard_cont"></textarea>
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
				<input class="btn" type="button" value="글쓰기" onclick="ds_write_ok(this.form)"> 
				<input class="btn" type="reset" value="지우기"> 
				<input class="btn" type="button" value="뒤로가기" onclick="location.href='<%=request.getContextPath()%>/dog/dogBoardList'">
				</div>
</form>
</article>