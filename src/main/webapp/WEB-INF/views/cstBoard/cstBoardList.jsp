<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/cstBoard.css">
	<style>
	#goCST:hover{
	cursor: pointer;
	}
	#goCST{
	width:30%;
	}
	input[type=button]{
	width:49%;
	float:left;
	}
	</style>
<article>
	<div>
		<a href="<%=request.getContextPath()%>/cst/cstBoardList"><img
			id="freeLogo"
			src="<%=request.getContextPath()%>/resources/images/cstboard.png"></a>
	</div>


	<div id="divdiv">
		<table style="margin: 0 auto;">
			<tr>
				<td><c:if test="${loginUser != null }">
				<div id="goCST" onclick="location.href='<%=request.getContextPath()%>/cst/cstBoardWrite'"><img src="<%=request.getContextPath() %>/resources/images/consulting.png"></div>
						<input style="margin-right:1%;" type="button" class="btn btn-success btn-sm" value="컨설팅신청 바로가기"
							onclick="location.href='<%=request.getContextPath()%>/cst/cstBoardWrite'">
					</c:if> <input type="button" class="btn btn-success btn-sm" value="메인으로"
					onclick="location.href='<%=request.getContextPath()%>/index'">
				</td>
			</tr>
		</table>
	</div>
	</form>
</article>
