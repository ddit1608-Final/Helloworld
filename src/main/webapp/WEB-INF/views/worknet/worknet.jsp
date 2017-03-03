<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<article>
	<div style="position: relative; float: left; width: 80px;">
		<div id="right_section"	style="position: absolute; top: 0px; left: 0px;">
			<table style="border: 1px solid black;width:100px;height:300px;">
				<tr>
				<th>담기는곳</th>
				<td></td>
				</tr>
				<tr>
				둘중에 뭐할까?
				<th>찜☞<input type="button" class="btn btn-success btn-xs" value="스크랩" onclick="#"></th>
				<td><button class="btn btn-success btn-xs" style="font-size:15px" onclick="chk_chk()")>스크랩 <i class="fa fa-cart-plus"></i></button></td>
				</tr>
			</table>
		</div>
	</div>
	<iframe id="pageFrame" name="pageFrame"
		src="http://www.work.go.kr/jobyoung/empSrch/retriveJobsCodeList.do?depth=3&code=134&superCode=13&isOffer=Y"
		frameborder="0" width="1200" height="1800" scrolling="no"></iframe>
</article>