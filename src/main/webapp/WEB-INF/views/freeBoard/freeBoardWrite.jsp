<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="decorator"uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<article>
	<h2>자유게시판</h2>
	<h3>자유스럽게 게시글을 작성,소통의 공간</h3>
	<form name="formm" method="post" action="freeBoardWrite.do">
		<fieldset>
			<legend>Board Info</legend>
			<label>Title</label> <input type="text" name="subject" size="64"><br>
			<label>Content</label>
			<textarea rows="8" cols="65" name="content"></textarea>
			<br>
		</fieldset>
		<div class="clear"></div>
		<div id="buttons" style="float: right">
			<input type="submit" value="글쓰기" class="submit"> 
			<input type="reset" value="취소" class="cancel"> 
			<input type="button" value="메인" class="submit" 
				onclick="location.href='<%=request.getContextPath()%>/index.do'">
		</div>
	</form>
</article>
