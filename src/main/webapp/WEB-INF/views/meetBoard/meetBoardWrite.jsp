<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/meetBoard.css">
<article>
<div>
		<a href="<%=request.getContextPath()%>/meet/meetBoardList.do"><img id="meetLogo" src="<%= request.getContextPath() %>/resources/images/meetLogo.png"></a>
	</div> 
	
	<form id="fdf" name="form" method="post" action="meetBoardWrite.do">
			<!-- freeboard_posting_no,mem_mail,freeboard_title,freeboard_cont -->
		<table class="table .table-condensed" id="bwt">
		
		<input hidden="hidden" name="mem_mail" value="${loginUser.mem_mail}">
<thead>
      <tr style="border-bottom:1px solid #c9c9c9;">
        <td>작성자</td>
        <td>${loginUser.mem_nick}</td>
      </tr>
      <tr>
      	<td>비밀번호</td>
        	<td><input type="password" name="meet_board_pwd"></td>
        </tr>       
      
      <tr>
      	<td>제목</td>
      	<td><input type="text" name="meet_board_title"></td>
      </tr>
      <tr>	
      	<td>지역</td>
      		<td><select name="flow_code">
      			<c:forEach items="${flowList }" var="flow" varStatus="status">
      				<c:if test="${status.count >= '6'}">
      					<option value="${flow.flow_code}">${flow.flow_cont}</option>	
      				</c:if>
      					
      			</c:forEach>
      			
      		</select>
      		</td>
      	</td>
      </tr>
      <tr>
      	<td>내용</td>
      	
        	<td>
      		<textarea rows="8" cols="65" name="meet_board_cont"></textarea>
      	</td>
      </tr>
     </thead>
		</table>
	<table>
		
	</table>
				<div id="divdiv">
				<input class="btn" type="submit" value="글쓰기"> 
				<input class="btn" type="reset" value="취소"> 
				<input class="btn" type="button" value="메인" onclick="location.href='<%=request.getContextPath()%>/index'">
				</div>
</form>
</article>
