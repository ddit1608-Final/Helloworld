<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%-- <%@ include file="../header.jsp" %> --%>	 
	<article>
	    <h2> 자유게시판 </h2>
	    <h3> 자유롭게...머문자리는 아름답게</h3>    
		<form name="formm" method="post" action="freeBoardWrite.do">
			<fieldset>	
				<legend>Board Info</legend>		
			    <label>Title</label>
			    <input type="text" name="subject"  size="64" ><br>
				<label>Content</label>
			    <textarea rows="8" cols="65" name="content"></textarea><br>
			</fieldset>   
		<div class="clear"></div>
		 <div id="buttons" style="float:right">
			<input type="submit"  value="글쓰기"     class="submit"> 
			<input type="reset"   value="취소"     class="cancel">
			<input type="button"  value="메인"  class="submit"  onclick="location.href='<%=request.getContextPath()%>/index2.jsp'">	
		  </div>
		</form>
	</article>
