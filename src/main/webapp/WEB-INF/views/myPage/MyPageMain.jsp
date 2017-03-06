<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/mypage.css">
<style>

</style>
<article>
	<%-- <div>
		<a href="<%=request.getContextPath()%>/mypage/main"><img
			id="freeLogo"
			src="<%=request.getContextPath()%>/resources/images/mylogo.png"></a>
	</div>

	<!-- <h2>myPage</h2>
	<hr> -->

	<table class="mypageMemu">
		<tr>
			<td><button
					onclick="location.href='<%=request.getContextPath()%>/mypage/updateInfo'">개인정보
					수정</button></td>	
			<td><button
					onclick="location.href='<%=request.getContextPath()%>/resm/resmList.do'">이력서
					수정</button></td>
			<td><button>컨설팅 내역 조회</button></td>
			<td><button>스크랩게시물 조회</button></td>
			<td><button
					onclick="location.href='<%=request.getContextPath()%>/mypage/myBoard'">작성한게시물 조회</button></td>
			<td><button>구직입찰조회</buttodn></td>
		</tr>
	</table>
 --%>
	<table class="table table-striped">
		<th colspan="4">
			<h1 class="text-center">포인트적립내역</h1>
		</th>
		<tr class="text-center" style="font-size:16pt;">
			<td>날짜</td>
			<td>내용</td>
			<td>적립 변동</td>
		</tr>
		<c:choose>
			<c:when test="${myPointListSize<=0 || myPointListSize == null}">
				<tr>
					<td width="100%" colspan="4" align="center" height="23">포인트
						내역이 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${myPointList}" var="pointVo">
					<tr id="pointhover">
						<td style="text-align: center;"><fmt:formatDate
								value="${pointVo.point_save_date}" /></td>
						<c:if test="${pointVo.point_cont == 0 }">
						<td style="text-align: center;">회원가입</td>
						</c:if>
						<c:if test="${pointVo.point_cont == 1 }">
						<td style="text-align: center;">로그인</td>
						</c:if>		
						<c:if test="${pointVo.point_cont == 2 }">
						<td style="text-align: center;">글 채택</td>
						</c:if>					
						<td style="text-align: center;">${pointVo.point}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4" style="text-align: center;">${paging}</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
</article>